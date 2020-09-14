// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.build.buildservice._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.build.buildservice._03._BuildQueueWebServiceSoap_QueueBuilds;
import ms.tfs.build.buildservice._03._BuildReason;
import ms.tfs.build.buildservice._03._BuildRequest;
import ms.tfs.build.buildservice._03._GetOption;
import ms.tfs.build.buildservice._03._QueueOptions;
import ms.tfs.build.buildservice._03._QueuePriority;

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
public class _BuildQueueWebServiceSoap_QueueBuilds
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected _BuildRequest[] requests;
    protected _QueueOptions options;

    public _BuildQueueWebServiceSoap_QueueBuilds()
    {
        super();
    }

    public _BuildQueueWebServiceSoap_QueueBuilds(
        final _BuildRequest[] requests,
        final _QueueOptions options)
    {
        // TODO : Call super() instead of setting all fields directly?
        setRequests(requests);
        setOptions(options);
    }

    public _BuildRequest[] getRequests()
    {
        return this.requests;
    }

    public void setRequests(_BuildRequest[] value)
    {
        this.requests = value;
    }

    public _QueueOptions getOptions()
    {
        return this.options;
    }

    public void setOptions(_QueueOptions value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("'options' is a required element, its value cannot be null");
        }

        this.options = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Elements
        if (this.requests != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("requests");

            for (int iterator0 = 0; iterator0 < this.requests.length; iterator0++)
            {
                this.requests[iterator0].writeAsElement(
                    writer,
                    "BuildRequest");
            }

            writer.writeEndElement();
        }

        this.options.writeAsElement(
            writer,
            "options");

        writer.writeEndElement();
    }
}
