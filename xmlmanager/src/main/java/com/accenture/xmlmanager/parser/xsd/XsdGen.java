package com.accenture.xmlmanager.parser.xsd;

import nu.xom.*;
import org.wiztools.commons.Charsets;
import org.wiztools.commons.StringUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * @author subWiz
 */
public final class XsdGen {

    private static final String XSD_NS_URI = "http://www.w3.org/2001/XMLSchema";

    private final String xsdPrefix;
    private final boolean enableMaxOccursOnce;

    private Document doc = null; // populated after the parse method is called!

    public boolean mixed;
    
    /**
     * Constructs new {@code XsdGen} with defaults settings.
     */
    public XsdGen() {
        this(new XsdConfig());
    }

    /**
     * Constructs new {@code XsdGen} with parameters :
     *
     * @param config             the XSD configuration
     */
    public XsdGen(XsdConfig config) {
        xsdPrefix = config.getXsdPrefix();
        this.enableMaxOccursOnce = config.isEnableMaxOccursOnce();
    }


    private void processAttributes(final Element inElement, final Element outElement) {
        for (int i = 0; i < inElement.getAttributeCount(); i++) {
            final Attribute attr = inElement.getAttribute(i);
            final String name = attr.getLocalName();
            final String value = attr.getValue();
            Element attrElement = new Element(xsdPrefix + ":attribute", XSD_NS_URI);
            attrElement.addAttribute(new Attribute("name", name));
            attrElement.addAttribute(new Attribute("type", xsdPrefix + TypeInferenceUtil.getTypeOfContent(value)));
            attrElement.addAttribute(new Attribute("use", "required"));
            outElement.appendChild(attrElement);
        }
    }

    private void recurseGen(Element parent, Element parentOutElement) {

    	// Adding complexType element:
        Element complexType = new Element(xsdPrefix + ":complexType", XSD_NS_URI);
        
        if (mixed)
        	complexType.addAttribute(new Attribute("mixed", "true"));
        
        Element sequence = new Element(xsdPrefix + ":sequence", XSD_NS_URI);
        
        complexType.appendChild(sequence);
        processAttributes(parent, complexType);
        parentOutElement.appendChild(complexType);

        Elements children = parent.getChildElements();
        final Set<String> elementNamesProcessed = new HashSet<>();
        for (int i = 0; i < children.size(); i++) {
            Element e = children.get(i);
            final String localName = e.getLocalName();
            final String nsURI = e.getNamespaceURI();
            final String nsName = e.getQualifiedName();

            if (!elementNamesProcessed.contains(nsName)) { // process an element first time only
                if (e.getChildElements().size() > 0) { // Is complex type with children!
                    Element element = new Element(xsdPrefix + ":element", XSD_NS_URI);
                    element.addAttribute(new Attribute("name", localName));
                    processOccurences(element, parent, localName, nsURI);
                    recurseGen(e, element); // recurse into children:
                    sequence.appendChild(element);

                }
                else {
                    final String cnt = e.getValue();
                    final String eValue = cnt == null ? null : cnt.trim();
                    final String type = xsdPrefix + TypeInferenceUtil.getTypeOfContent(eValue);
                    Element element = new Element(xsdPrefix + ":element", XSD_NS_URI);
                    element.addAttribute(new Attribute("name", localName));
                    processOccurences(element, parent, localName, nsURI);

                    // Attributes
                    final int attrCount = e.getAttributeCount();
                    if (attrCount > 0) {
                        // has attributes: complex type without sequence!
                        Element complexTypeCurrent = new Element(xsdPrefix + ":complexType", XSD_NS_URI);
                        if (mixed)
                        	complexType.addAttribute(new Attribute("mixed", "true"));
                        Element simpleContent = new Element(xsdPrefix + ":simpleContent", XSD_NS_URI);
                        Element extension = new Element(xsdPrefix + ":extension", XSD_NS_URI);
                        extension.addAttribute(new Attribute("base", type));
                        processAttributes(e, extension);
                        simpleContent.appendChild(extension);
                        complexTypeCurrent.appendChild(simpleContent);
                        element.appendChild(complexTypeCurrent);
                    }
                    else { // if no attributes, just put the type:
                        element.addAttribute(new Attribute("type", type));
                    }
                    sequence.appendChild(element);
                }
            }
            elementNamesProcessed.add(nsName);
        }
    }

    private void processOccurences(final Element element, final Element parent,
                                   final String localName, final String nsURI) {
        if (parent.getChildElements(localName, nsURI).size() > 1) {
            element.addAttribute(new Attribute("maxOccurs", "unbounded"));
        }
        else {
            element.addAttribute(new Attribute("minOccurs", "0"));
            if (enableMaxOccursOnce) element.addAttribute(new Attribute("maxOccurs", "1"));
        }
    }

    private Document getDocument(InputStream is) throws ParsingException, IOException {
        try {
            Builder parser = new Builder();
            Document d = parser.build(is);
            final Element rootElement = d.getRootElement();

            // output Document
            Element outRoot = new Element(xsdPrefix + ":schema", XSD_NS_URI);
            Document outDoc = new Document(outRoot);

            // setting targetNamespace
            final String nsPrefix = rootElement.getNamespacePrefix();
            final boolean hasXmlns = rootElement.getNamespaceDeclarationCount() > 0;
            if (hasXmlns || StringUtil.isNotEmpty(nsPrefix)) {
                outRoot.addAttribute(new Attribute("targetNamespace", rootElement.getNamespaceURI()));
                outRoot.addAttribute(new Attribute("elementFormDefault", "qualified"));
            }

            // adding all other namespace attributes
            for (int i = 0; i < rootElement.getNamespaceDeclarationCount(); i++) {
                final String nsPrefix2 = rootElement.getNamespacePrefix(i);
                final String nsURI = rootElement.getNamespaceURI(nsPrefix2);
                outRoot.addNamespaceDeclaration(nsPrefix2, nsURI);
            }

            // adding the root element
            Element rootElementXsd = new Element(xsdPrefix + ":element", XSD_NS_URI);
            rootElementXsd.addAttribute(new Attribute("name", rootElement.getLocalName()));
            outRoot.appendChild(rootElementXsd);
            recurseGen(rootElement, rootElementXsd);
            return outDoc;
        }
        finally {
            if(is != null) {is.close();}
        }
    }

    public XsdGen parse(File file) throws IOException, ParseException {
        return parse(new FileInputStream(file));
    }
    
    public XsdGen parse(InputStream is) throws IOException, ParseException {
        try {
            doc = getDocument(is);
            return this;
        }
        catch (ParsingException ex) {
            throw new ParseException(ex);
        }
    }

    public void write(final OutputStream os) throws IOException {
        if (doc == null) throw new IllegalStateException("Call parse() before calling this method!");
        write(os, Charsets.UTF_8);
    }

    public void write(final OutputStream os, final Charset charset) throws IOException {
        if (doc == null) throw new IllegalStateException("Call parse() before calling this method!");
        // Display output:
        Serializer serializer = new Serializer(os, charset.name());
        serializer.setIndent(4);
        serializer.write(doc);
    }

    @Override
    public String toString() {
        return doc.toXML();
    }
}
