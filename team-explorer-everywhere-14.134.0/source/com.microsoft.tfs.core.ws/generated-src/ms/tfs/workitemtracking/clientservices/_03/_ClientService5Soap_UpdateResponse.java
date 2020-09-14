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

import ms.tfs.workitemtracking.clientservices._03._ClientService5Soap_UpdateResponse;

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
public class _ClientService5Soap_UpdateResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected AnyContentType result;
    protected String dbStamp;
    protected AnyContentType metadata;

    public _ClientService5Soap_UpdateResponse()
    {
        super();
    }

    public _ClientService5Soap_UpdateResponse(
        final AnyContentType result,
        final String dbStamp,
        final AnyContentType metadata)
    {
        // TODO : Call super() instead of setting all fields directly?
        setResult(result);
        setDbStamp(dbStamp);
        setMetadata(metadata);
    }

    public AnyContentType getResult()
    {
        return this.result;
    }

    public void setResult(AnyContentType value)
    {
        this.result = value;
    }

    public String getDbStamp()
    {
        return this.dbStamp;
    }

    public void setDbStamp(String value)
    {
        this.dbStamp = value;
    }

    public AnyContentType getMetadata()
    {
        return this.metadata;
    }

    public void setMetadata(AnyContentType value)
    {
        this.metadata = value;
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

                if (localName.equalsIgnoreCase("result"))
                {
                    if (this.result == null)
                    {
                        throw new XMLStreamException(
                                "An AnyContentType implementation must be supplied by the caller "
                                + "for the 'result' field before deserialization can occur.");
                    }

                    this.result.readFromElement(reader);
                }
                else if (localName.equalsIgnoreCase("dbStamp"))
                {
                    this.dbStamp = reader.getElementText();
                }
                else if (localName.equalsIgnoreCase("metadata"))
                {
                    if (this.metadata == null)
                    {
                        throw new XMLStreamException(
                                "An AnyContentType implementation must be supplied by the caller "
                                + "for the 'metadata' field before deserialization can occur.");
                    }

                    this.metadata.readFromElement(reader);
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
