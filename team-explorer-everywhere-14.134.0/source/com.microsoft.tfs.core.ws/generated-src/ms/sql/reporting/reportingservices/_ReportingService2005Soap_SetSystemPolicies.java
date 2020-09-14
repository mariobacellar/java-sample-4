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

import ms.sql.reporting.reportingservices._Policy;
import ms.sql.reporting.reportingservices._ReportingService2005Soap_SetSystemPolicies;
import ms.sql.reporting.reportingservices._Role;

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
public class _ReportingService2005Soap_SetSystemPolicies
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected _Policy[] policies;

    public _ReportingService2005Soap_SetSystemPolicies()
    {
        super();
    }

    public _ReportingService2005Soap_SetSystemPolicies(final _Policy[] policies)
    {
        // TODO : Call super() instead of setting all fields directly?
        setPolicies(policies);
    }

    public _Policy[] getPolicies()
    {
        return this.policies;
    }

    public void setPolicies(_Policy[] value)
    {
        this.policies = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Elements
        if (this.policies != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("Policies");

            for (int iterator0 = 0; iterator0 < this.policies.length; iterator0++)
            {
                this.policies[iterator0].writeAsElement(
                    writer,
                    "Policy");
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }
}
