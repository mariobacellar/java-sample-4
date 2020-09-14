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

import ms.ws._IdentityManagementWebServiceSoap_ReadIdentitiesById;

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
public class _IdentityManagementWebServiceSoap_ReadIdentitiesById
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected String[] teamFoundationIds;
    protected int queryMembership;
    protected int features;
    protected int options;
    protected String[] propertyNameFilters;
    protected int propertyScope;

    public _IdentityManagementWebServiceSoap_ReadIdentitiesById()
    {
        super();
    }

    public _IdentityManagementWebServiceSoap_ReadIdentitiesById(
        final String[] teamFoundationIds,
        final int queryMembership,
        final int features,
        final int options,
        final String[] propertyNameFilters,
        final int propertyScope)
    {
        // TODO : Call super() instead of setting all fields directly?
        setTeamFoundationIds(teamFoundationIds);
        setQueryMembership(queryMembership);
        setFeatures(features);
        setOptions(options);
        setPropertyNameFilters(propertyNameFilters);
        setPropertyScope(propertyScope);
    }

    public String[] getTeamFoundationIds()
    {
        return this.teamFoundationIds;
    }

    public void setTeamFoundationIds(String[] value)
    {
        this.teamFoundationIds = value;
    }

    public int getQueryMembership()
    {
        return this.queryMembership;
    }

    public void setQueryMembership(int value)
    {
        this.queryMembership = value;
    }

    public int getFeatures()
    {
        return this.features;
    }

    public void setFeatures(int value)
    {
        this.features = value;
    }

    public int getOptions()
    {
        return this.options;
    }

    public void setOptions(int value)
    {
        this.options = value;
    }

    public String[] getPropertyNameFilters()
    {
        return this.propertyNameFilters;
    }

    public void setPropertyNameFilters(String[] value)
    {
        this.propertyNameFilters = value;
    }

    public int getPropertyScope()
    {
        return this.propertyScope;
    }

    public void setPropertyScope(int value)
    {
        this.propertyScope = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Elements
        if (this.teamFoundationIds != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("teamFoundationIds");

            for (int iterator0 = 0; iterator0 < this.teamFoundationIds.length; iterator0++)
            {
                XMLStreamWriterHelper.writeElement(
                    writer,
                    "guid",
                    this.teamFoundationIds[iterator0]);
            }

            writer.writeEndElement();
        }

        XMLStreamWriterHelper.writeElement(
            writer,
            "queryMembership",
            this.queryMembership);
        XMLStreamWriterHelper.writeElement(
            writer,
            "features",
            this.features);
        XMLStreamWriterHelper.writeElement(
            writer,
            "options",
            this.options);

        if (this.propertyNameFilters != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("propertyNameFilters");

            for (int iterator0 = 0; iterator0 < this.propertyNameFilters.length; iterator0++)
            {
                XMLStreamWriterHelper.writeElement(
                    writer,
                    "string",
                    this.propertyNameFilters[iterator0]);
            }

            writer.writeEndElement();
        }

        XMLStreamWriterHelper.writeElement(
            writer,
            "propertyScope",
            this.propertyScope);

        writer.writeEndElement();
    }
}
