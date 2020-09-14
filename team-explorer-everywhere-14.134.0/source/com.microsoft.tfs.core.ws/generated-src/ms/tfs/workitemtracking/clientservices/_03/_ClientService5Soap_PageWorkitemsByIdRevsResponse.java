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
import com.microsoft.tfs.core.ws.runtime.types.AnyContentType;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.workitemtracking.clientservices._03._ClientService5Soap_PageWorkitemsByIdRevsResponse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Automatically generated complex type class.
 */
public class _ClientService5Soap_PageWorkitemsByIdRevsResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected Calendar pageDate;
    protected AnyContentType items;

    public _ClientService5Soap_PageWorkitemsByIdRevsResponse()
    {
        super();
    }

    public _ClientService5Soap_PageWorkitemsByIdRevsResponse(
        final Calendar pageDate,
        final AnyContentType items)
    {
        // TODO : Call super() instead of setting all fields directly?
        setPageDate(pageDate);
        setItems(items);
    }

    public Calendar getPageDate()
    {
        return this.pageDate;
    }

    public void setPageDate(Calendar value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("'pageDate' is a required element, its value cannot be null");
        }

        this.pageDate = value;
    }

    public AnyContentType getItems()
    {
        return this.items;
    }

    public void setItems(AnyContentType value)
    {
        this.items = value;
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

                if (localName.equalsIgnoreCase("pageDate"))
                {
                    this.pageDate = XMLConvert.toCalendar(
                            reader.getElementText(),
                            true);
                }
                else if (localName.equalsIgnoreCase("items"))
                {
                    if (this.items == null)
                    {
                        throw new XMLStreamException(
                                "An AnyContentType implementation must be supplied by the caller "
                                + "for the 'items' field before deserialization can occur.");
                    }

                    this.items.readFromElement(reader);
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
