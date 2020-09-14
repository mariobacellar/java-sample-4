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

import ms.sql.reporting.reportingservices._DrillthroughType;
import ms.sql.reporting.reportingservices._ModelDrillthroughReport;
import ms.sql.reporting.reportingservices._ReportingService2005Soap_SetModelDrillthroughReports;

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
public class _ReportingService2005Soap_SetModelDrillthroughReports
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected String model;
    protected String modelItemID;
    protected _ModelDrillthroughReport[] reports;

    public _ReportingService2005Soap_SetModelDrillthroughReports()
    {
        super();
    }

    public _ReportingService2005Soap_SetModelDrillthroughReports(
        final String model,
        final String modelItemID,
        final _ModelDrillthroughReport[] reports)
    {
        // TODO : Call super() instead of setting all fields directly?
        setModel(model);
        setModelItemID(modelItemID);
        setReports(reports);
    }

    public String getModel()
    {
        return this.model;
    }

    public void setModel(String value)
    {
        this.model = value;
    }

    public String getModelItemID()
    {
        return this.modelItemID;
    }

    public void setModelItemID(String value)
    {
        this.modelItemID = value;
    }

    public _ModelDrillthroughReport[] getReports()
    {
        return this.reports;
    }

    public void setReports(_ModelDrillthroughReport[] value)
    {
        this.reports = value;
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
            "Model",
            this.model);
        XMLStreamWriterHelper.writeElement(
            writer,
            "ModelItemID",
            this.modelItemID);

        if (this.reports != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("Reports");

            for (int iterator0 = 0; iterator0 < this.reports.length; iterator0++)
            {
                this.reports[iterator0].writeAsElement(
                    writer,
                    "ModelDrillthroughReport");
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }
}
