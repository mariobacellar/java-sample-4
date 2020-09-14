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

import ms.tfs.workitemtracking.clientservices._03._ClientService5Soap_GetWorkItemIdsForArtifactUris;

import java.lang.String;

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
public class _ClientService5Soap_GetWorkItemIdsForArtifactUris
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected String[] artifactUris;
    protected Calendar asOfDate;

    public _ClientService5Soap_GetWorkItemIdsForArtifactUris()
    {
        super();
    }

    public _ClientService5Soap_GetWorkItemIdsForArtifactUris(
        final String[] artifactUris,
        final Calendar asOfDate)
    {
        // TODO : Call super() instead of setting all fields directly?
        setArtifactUris(artifactUris);
        setAsOfDate(asOfDate);
    }

    public String[] getArtifactUris()
    {
        return this.artifactUris;
    }

    public void setArtifactUris(String[] value)
    {
        this.artifactUris = value;
    }

    public Calendar getAsOfDate()
    {
        return this.asOfDate;
    }

    public void setAsOfDate(Calendar value)
    {
        this.asOfDate = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Elements
        if (this.artifactUris != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("artifactUris");

            for (int iterator0 = 0; iterator0 < this.artifactUris.length; iterator0++)
            {
                XMLStreamWriterHelper.writeElement(
                    writer,
                    "string",
                    this.artifactUris[iterator0]);
            }

            writer.writeEndElement();
        }

        XMLStreamWriterHelper.writeElement(
            writer,
            "asOfDate",
            this.asOfDate,
            true);

        writer.writeEndElement();
    }
}
