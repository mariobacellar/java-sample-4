// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.ws;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.ws._LocationMapping;
import ms.ws._LocationWebServiceSoap_RemoveServiceDefinitions;
import ms.ws._ServiceDefinition;

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
public class _LocationWebServiceSoap_RemoveServiceDefinitions
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected _ServiceDefinition[] serviceDefinitions;
    protected int lastChangeId;

    public _LocationWebServiceSoap_RemoveServiceDefinitions()
    {
        super();
    }

    public _LocationWebServiceSoap_RemoveServiceDefinitions(
        final _ServiceDefinition[] serviceDefinitions,
        final int lastChangeId)
    {
        // TODO : Call super() instead of setting all fields directly?
        setServiceDefinitions(serviceDefinitions);
        setLastChangeId(lastChangeId);
    }

    public _ServiceDefinition[] getServiceDefinitions()
    {
        return this.serviceDefinitions;
    }

    public void setServiceDefinitions(_ServiceDefinition[] value)
    {
        this.serviceDefinitions = value;
    }

    public int getLastChangeId()
    {
        return this.lastChangeId;
    }

    public void setLastChangeId(int value)
    {
        this.lastChangeId = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Elements
        if (this.serviceDefinitions != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("serviceDefinitions");

            for (int iterator0 = 0; iterator0 < this.serviceDefinitions.length; iterator0++)
            {
                this.serviceDefinitions[iterator0].writeAsElement(
                    writer,
                    "ServiceDefinition");
            }

            writer.writeEndElement();
        }

        XMLStreamWriterHelper.writeElement(
            writer,
            "lastChangeId",
            this.lastChangeId);

        writer.writeEndElement();
    }
}
