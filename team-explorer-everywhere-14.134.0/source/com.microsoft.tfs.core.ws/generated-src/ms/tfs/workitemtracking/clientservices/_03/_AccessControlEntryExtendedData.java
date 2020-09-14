// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.workitemtracking.clientservices._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.workitemtracking.clientservices._03._AccessControlEntryExtendedData;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Automatically generated complex type class.
 */
public class _AccessControlEntryExtendedData
    implements ElementSerializable, ElementDeserializable
{
    // Attributes
    protected int inheritedAllow;
    protected int inheritedDeny;
    protected int effectiveAllow;
    protected int effectiveDeny;

    // No elements    
    public _AccessControlEntryExtendedData()
    {
        super();
    }

    public _AccessControlEntryExtendedData(
        final int inheritedAllow,
        final int inheritedDeny,
        final int effectiveAllow,
        final int effectiveDeny)
    {
        // TODO : Call super() instead of setting all fields directly?
        setInheritedAllow(inheritedAllow);
        setInheritedDeny(inheritedDeny);
        setEffectiveAllow(effectiveAllow);
        setEffectiveDeny(effectiveDeny);
    }

    public int getInheritedAllow()
    {
        return this.inheritedAllow;
    }

    public void setInheritedAllow(final int value)
    {
        this.inheritedAllow = value;
    }

    public int getInheritedDeny()
    {
        return this.inheritedDeny;
    }

    public void setInheritedDeny(final int value)
    {
        this.inheritedDeny = value;
    }

    public int getEffectiveAllow()
    {
        return this.effectiveAllow;
    }

    public void setEffectiveAllow(final int value)
    {
        this.effectiveAllow = value;
    }

    public int getEffectiveDeny()
    {
        return this.effectiveDeny;
    }

    public void setEffectiveDeny(final int value)
    {
        this.effectiveDeny = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Attributes
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "InheritedAllow",
            this.inheritedAllow);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "InheritedDeny",
            this.inheritedDeny);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "EffectiveAllow",
            this.effectiveAllow);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "EffectiveDeny",
            this.effectiveDeny);

        writer.writeEndElement();
    }

    public void readFromElement(final XMLStreamReader reader)
        throws XMLStreamException
    {
        String localName;

        // Attributes
        final int attributeCount = reader.getAttributeCount();
        String attributeValue;

        for (int i = 0; i < attributeCount; i++)
        {
            localName = reader.getAttributeLocalName(i);
            attributeValue = reader.getAttributeValue(i);

            if (localName.equalsIgnoreCase("InheritedAllow"))
            {
                this.inheritedAllow = XMLConvert.toInt(attributeValue);
            }
            else if (localName.equalsIgnoreCase("InheritedDeny"))
            {
                this.inheritedDeny = XMLConvert.toInt(attributeValue);
            }
            else if (localName.equalsIgnoreCase("EffectiveAllow"))
            {
                this.effectiveAllow = XMLConvert.toInt(attributeValue);
            }
            else if (localName.equalsIgnoreCase("EffectiveDeny"))
            {
                this.effectiveDeny = XMLConvert.toInt(attributeValue);
            }

            // Ignore unknown attributes.
        }

        // This object uses no elements, so read until our element end
        XMLStreamReaderHelper.readUntilElementEnd(reader);
    }
}
