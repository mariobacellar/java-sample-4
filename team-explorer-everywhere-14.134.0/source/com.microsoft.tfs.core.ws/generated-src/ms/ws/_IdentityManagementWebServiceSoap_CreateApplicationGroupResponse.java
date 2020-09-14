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
import ms.ws._IdentityManagementWebServiceSoap_CreateApplicationGroupResponse;

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
public class _IdentityManagementWebServiceSoap_CreateApplicationGroupResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected _IdentityDescriptor createApplicationGroupResult;

    public _IdentityManagementWebServiceSoap_CreateApplicationGroupResponse()
    {
        super();
    }

    public _IdentityManagementWebServiceSoap_CreateApplicationGroupResponse(
        final _IdentityDescriptor createApplicationGroupResult)
    {
        // TODO : Call super() instead of setting all fields directly?
        setCreateApplicationGroupResult(createApplicationGroupResult);
    }

    public _IdentityDescriptor getCreateApplicationGroupResult()
    {
        return this.createApplicationGroupResult;
    }

    public void setCreateApplicationGroupResult(_IdentityDescriptor value)
    {
        this.createApplicationGroupResult = value;
    }

    public void readFromElement(final XMLStreamReader reader)
        throws XMLStreamException
    {
        String localName;

        // This object uses no attributes

        // Elements
        int event;

        do
        {
            event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT)
            {
                localName = reader.getLocalName();

                if (localName.equalsIgnoreCase("CreateApplicationGroupResult"))
                {
                    this.createApplicationGroupResult = new _IdentityDescriptor();
                    this.createApplicationGroupResult.readFromElement(reader);
                }
                else
                {
                    // Read the unknown child element until its end
                    XMLStreamReaderHelper.readUntilElementEnd(reader);
                }
            }
        }
        while (event != XMLStreamConstants.END_ELEMENT);
    }
}