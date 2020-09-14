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

import ms.ws._IdentityDescriptor;
import ms.ws._SecurityWebServiceSoap_RemoveAccessControlEntries;

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
public class _SecurityWebServiceSoap_RemoveAccessControlEntries
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected String namespaceId;
    protected String token;
    protected _IdentityDescriptor[] identities;

    public _SecurityWebServiceSoap_RemoveAccessControlEntries()
    {
        super();
    }

    public _SecurityWebServiceSoap_RemoveAccessControlEntries(
        final String namespaceId,
        final String token,
        final _IdentityDescriptor[] identities)
    {
        // TODO : Call super() instead of setting all fields directly?
        setNamespaceId(namespaceId);
        setToken(token);
        setIdentities(identities);
    }

    public String getNamespaceId()
    {
        return this.namespaceId;
    }

    public void setNamespaceId(String value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("'namespaceId' is a required element, its value cannot be null");
        }

        this.namespaceId = value;
    }

    public String getToken()
    {
        return this.token;
    }

    public void setToken(String value)
    {
        this.token = value;
    }

    public _IdentityDescriptor[] getIdentities()
    {
        return this.identities;
    }

    public void setIdentities(_IdentityDescriptor[] value)
    {
        this.identities = value;
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
            "namespaceId",
            this.namespaceId);
        XMLStreamWriterHelper.writeElement(
            writer,
            "token",
            this.token);

        if (this.identities != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("identities");

            for (int iterator0 = 0; iterator0 < this.identities.length; iterator0++)
            {
                this.identities[iterator0].writeAsElement(
                    writer,
                    "IdentityDescriptor");
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }
}