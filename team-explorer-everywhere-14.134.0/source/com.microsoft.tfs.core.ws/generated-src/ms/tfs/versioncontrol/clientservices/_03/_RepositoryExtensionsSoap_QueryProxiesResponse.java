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

import ms.tfs.versioncontrol.clientservices._03._ProxyInfo;
import ms.tfs.versioncontrol.clientservices._03._RepositoryExtensionsSoap_QueryProxiesResponse;

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
public class _RepositoryExtensionsSoap_QueryProxiesResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected _ProxyInfo[] queryProxiesResult;

    public _RepositoryExtensionsSoap_QueryProxiesResponse()
    {
        super();
    }

    public _RepositoryExtensionsSoap_QueryProxiesResponse(final _ProxyInfo[] queryProxiesResult)
    {
        // TODO : Call super() instead of setting all fields directly?
        setQueryProxiesResult(queryProxiesResult);
    }

    public _ProxyInfo[] getQueryProxiesResult()
    {
        return this.queryProxiesResult;
    }

    public void setQueryProxiesResult(_ProxyInfo[] value)
    {
        this.queryProxiesResult = value;
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

                if (localName.equalsIgnoreCase("QueryProxiesResult"))
                {
                    /*
                     * The element type is an array.
                     */
                    int event0;
                    final List list0 = new ArrayList();

                    do
                    {
                        event0 = reader.nextTag();

                        if (event0 == XMLStreamConstants.START_ELEMENT)
                        {
                            _ProxyInfo complexObject0 = new _ProxyInfo();
                            complexObject0.readFromElement(reader);
                            list0.add(complexObject0);
                        }
                    }
                    while (event0 != XMLStreamConstants.END_ELEMENT);

                    this.queryProxiesResult = (_ProxyInfo[]) list0.toArray(new _ProxyInfo[list0.size()]);
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
