// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.versioncontrol.clientservices._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.versioncontrol.clientservices._03._ItemMerge;

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
public class _ItemMerge
    implements ElementSerializable, ElementDeserializable
{
    // Attributes
    protected int sid;
    protected int svf;
    protected String ssi;
    protected int tid;
    protected int tvf;
    protected String tsi;

    // No elements    
    public _ItemMerge()
    {
        super();
    }

    public _ItemMerge(
        final int sid,
        final int svf,
        final String ssi,
        final int tid,
        final int tvf,
        final String tsi)
    {
        // TODO : Call super() instead of setting all fields directly?
        setSid(sid);
        setSvf(svf);
        setSsi(ssi);
        setTid(tid);
        setTvf(tvf);
        setTsi(tsi);
    }

    public int getSid()
    {
        return this.sid;
    }

    public void setSid(final int value)
    {
        this.sid = value;
    }

    public int getSvf()
    {
        return this.svf;
    }

    public void setSvf(final int value)
    {
        this.svf = value;
    }

    public String getSsi()
    {
        return this.ssi;
    }

    public void setSsi(final String value)
    {
        this.ssi = value;
    }

    public int getTid()
    {
        return this.tid;
    }

    public void setTid(final int value)
    {
        this.tid = value;
    }

    public int getTvf()
    {
        return this.tvf;
    }

    public void setTvf(final int value)
    {
        this.tvf = value;
    }

    public String getTsi()
    {
        return this.tsi;
    }

    public void setTsi(final String value)
    {
        this.tsi = value;
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
            "sid",
            this.sid);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "svf",
            this.svf);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "ssi",
            this.ssi);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "tid",
            this.tid);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "tvf",
            this.tvf);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "tsi",
            this.tsi);

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

            if (localName.equalsIgnoreCase("sid"))
            {
                this.sid = XMLConvert.toInt(attributeValue);
            }
            else if (localName.equalsIgnoreCase("svf"))
            {
                this.svf = XMLConvert.toInt(attributeValue);
            }
            else if (localName.equalsIgnoreCase("ssi"))
            {
                this.ssi = attributeValue;
            }
            else if (localName.equalsIgnoreCase("tid"))
            {
                this.tid = XMLConvert.toInt(attributeValue);
            }
            else if (localName.equalsIgnoreCase("tvf"))
            {
                this.tvf = XMLConvert.toInt(attributeValue);
            }
            else if (localName.equalsIgnoreCase("tsi"))
            {
                this.tsi = attributeValue;
            }

            // Ignore unknown attributes.
        }

        // This object uses no elements, so read until our element end
        XMLStreamReaderHelper.readUntilElementEnd(reader);
    }
}