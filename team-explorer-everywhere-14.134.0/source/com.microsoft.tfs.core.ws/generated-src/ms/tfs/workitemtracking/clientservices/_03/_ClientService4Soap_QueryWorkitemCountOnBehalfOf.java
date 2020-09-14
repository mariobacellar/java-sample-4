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

import ms.tfs.workitemtracking.clientservices._03._ClientService4Soap_QueryWorkitemCountOnBehalfOf;

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
public class _ClientService4Soap_QueryWorkitemCountOnBehalfOf
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected String userName;
    protected AnyContentType query;

    public _ClientService4Soap_QueryWorkitemCountOnBehalfOf()
    {
        super();
    }

    public _ClientService4Soap_QueryWorkitemCountOnBehalfOf(
        final String userName,
        final AnyContentType query)
    {
        // TODO : Call super() instead of setting all fields directly?
        setUserName(userName);
        setQuery(query);
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String value)
    {
        this.userName = value;
    }

    public AnyContentType getQuery()
    {
        return this.query;
    }

    public void setQuery(AnyContentType value)
    {
        this.query = value;
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
            "userName",
            this.userName);
        this.query.writeAsElement(
            writer,
            "query");

        writer.writeEndElement();
    }
}
