// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.sql.reporting.reportingservices;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.sql.reporting.reportingservices._Property;
import ms.sql.reporting.reportingservices._ReportingService2005Soap_CreateLinkedReport;

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
public class _ReportingService2005Soap_CreateLinkedReport
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected String report;
    protected String parent;
    protected String link;
    protected _Property[] properties;

    public _ReportingService2005Soap_CreateLinkedReport()
    {
        super();
    }

    public _ReportingService2005Soap_CreateLinkedReport(
        final String report,
        final String parent,
        final String link,
        final _Property[] properties)
    {
        // TODO : Call super() instead of setting all fields directly?
        setReport(report);
        setParent(parent);
        setLink(link);
        setProperties(properties);
    }

    public String getReport()
    {
        return this.report;
    }

    public void setReport(String value)
    {
        this.report = value;
    }

    public String getParent()
    {
        return this.parent;
    }

    public void setParent(String value)
    {
        this.parent = value;
    }

    public String getLink()
    {
        return this.link;
    }

    public void setLink(String value)
    {
        this.link = value;
    }

    public _Property[] getProperties()
    {
        return this.properties;
    }

    public void setProperties(_Property[] value)
    {
        this.properties = value;
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
            "Report",
            this.report);
        XMLStreamWriterHelper.writeElement(
            writer,
            "Parent",
            this.parent);
        XMLStreamWriterHelper.writeElement(
            writer,
            "Link",
            this.link);

        if (this.properties != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("Properties");

            for (int iterator0 = 0; iterator0 < this.properties.length; iterator0++)
            {
                this.properties[iterator0].writeAsElement(
                    writer,
                    "Property");
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }
}
