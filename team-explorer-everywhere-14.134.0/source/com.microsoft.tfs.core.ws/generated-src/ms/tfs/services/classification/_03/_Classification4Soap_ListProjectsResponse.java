// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.services.classification._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.services.classification._03._Classification4Soap_ListProjectsResponse;
import ms.tfs.services.classification._03._ProjectInfo;
import ms.tfs.services.classification._03._ProjectState;

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
public class _Classification4Soap_ListProjectsResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected _ProjectInfo[] listProjectsResult;

    public _Classification4Soap_ListProjectsResponse()
    {
        super();
    }

    public _Classification4Soap_ListProjectsResponse(final _ProjectInfo[] listProjectsResult)
    {
        // TODO : Call super() instead of setting all fields directly?
        setListProjectsResult(listProjectsResult);
    }

    public _ProjectInfo[] getListProjectsResult()
    {
        return this.listProjectsResult;
    }

    public void setListProjectsResult(_ProjectInfo[] value)
    {
        this.listProjectsResult = value;
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

                if (localName.equalsIgnoreCase("ListProjectsResult"))
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
                            _ProjectInfo complexObject0 = new _ProjectInfo();
                            complexObject0.readFromElement(reader);
                            list0.add(complexObject0);
                        }
                    }
                    while (event0 != XMLStreamConstants.END_ELEMENT);

                    this.listProjectsResult = (_ProjectInfo[]) list0.toArray(new _ProjectInfo[list0.size()]);
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
