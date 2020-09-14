// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.services.classification._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.services.classification._03._ProjectInfo;
import ms.tfs.services.classification._03._ProjectState;

import java.lang.String;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Automatically generated complex type class.
 */
public class _ProjectInfo
    implements ElementSerializable, ElementDeserializable
{
    // No attributes    

    // Elements
    protected String uri;
    protected String name;
    protected _ProjectState status;

    public _ProjectInfo()
    {
        super();
    }

    public _ProjectInfo(
        final String uri,
        final String name,
        final _ProjectState status)
    {
        // TODO : Call super() instead of setting all fields directly?
        setUri(uri);
        setName(name);
        setStatus(status);
    }

    public String getUri()
    {
        return this.uri;
    }

    public void setUri(String value)
    {
        this.uri = value;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String value)
    {
        this.name = value;
    }

    public _ProjectState getStatus()
    {
        return this.status;
    }

    public void setStatus(_ProjectState value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("'Status' is a required element, its value cannot be null");
        }

        this.status = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Elements
        XMLStreamWriterHelper.writeElement(
            writer,
            "Uri",
            this.uri);
        XMLStreamWriterHelper.writeElement(
            writer,
            "Name",
            this.name);
        this.status.writeAsElement(
            writer,
            "Status");

        writer.writeEndElement();
    }

    public void readFromElement(final XMLStreamReader reader)
        throws XMLStreamException
    {
        String localName;

        // This object uses no attributes

        // Elements
        int event;

        do
        {
            event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT)
            {
                localName = reader.getLocalName();

                if (localName.equalsIgnoreCase("Uri"))
                {
                    this.uri = reader.getElementText();
                }
                else if (localName.equalsIgnoreCase("Name"))
                {
                    this.name = reader.getElementText();
                }
                else if (localName.equalsIgnoreCase("Status"))
                {
                    this.status = _ProjectState.fromString(reader.getElementText());
                }
                else
                {
                    // Read the unknown child element until its end
                    XMLStreamReaderHelper.readUntilElementEnd(reader);
                }
            }
        }
        while (event != XMLStreamConstants.END_ELEMENT);
    }
}
