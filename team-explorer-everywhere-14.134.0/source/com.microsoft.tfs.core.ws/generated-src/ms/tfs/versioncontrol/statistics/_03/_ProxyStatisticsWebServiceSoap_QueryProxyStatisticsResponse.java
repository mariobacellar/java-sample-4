// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.versioncontrol.statistics._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.versioncontrol.statistics._03._ProxyStatisticsInfo;
import ms.tfs.versioncontrol.statistics._03._ProxyStatisticsWebServiceSoap_QueryProxyStatisticsResponse;

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
public class _ProxyStatisticsWebServiceSoap_QueryProxyStatisticsResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected _ProxyStatisticsInfo[] queryProxyStatisticsResult;

    public _ProxyStatisticsWebServiceSoap_QueryProxyStatisticsResponse()
    {
        super();
    }

    public _ProxyStatisticsWebServiceSoap_QueryProxyStatisticsResponse(
        final _ProxyStatisticsInfo[] queryProxyStatisticsResult)
    {
        // TODO : Call super() instead of setting all fields directly?
        setQueryProxyStatisticsResult(queryProxyStatisticsResult);
    }

    public _ProxyStatisticsInfo[] getQueryProxyStatisticsResult()
    {
        return this.queryProxyStatisticsResult;
    }

    public void setQueryProxyStatisticsResult(_ProxyStatisticsInfo[] value)
    {
        this.queryProxyStatisticsResult = value;
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

                if (localName.equalsIgnoreCase("QueryProxyStatisticsResult"))
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
                            _ProxyStatisticsInfo complexObject0 = new _ProxyStatisticsInfo();
                            complexObject0.readFromElement(reader);
                            list0.add(complexObject0);
                        }
                    }
                    while (event0 != XMLStreamConstants.END_ELEMENT);

                    this.queryProxyStatisticsResult = (_ProxyStatisticsInfo[]) list0.toArray(
                                new _ProxyStatisticsInfo[list0.size()]);
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
