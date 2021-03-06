// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.build.buildservice._04;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.build.buildservice._04._BuildDetail;
import ms.tfs.build.buildservice._04._BuildInformationNode;
import ms.tfs.build.buildservice._04._BuildPhaseStatus;
import ms.tfs.build.buildservice._04._BuildReason;
import ms.tfs.build.buildservice._04._BuildServiceSoap_UpdateBuildsResponse;
import ms.tfs.build.buildservice._04._BuildStatus;
import ms.tfs.build.buildservice._04._InformationField;

import java.lang.String;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Automatically generated complex type class.
 */
public class _BuildServiceSoap_UpdateBuildsResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected _BuildDetail[] updateBuildsResult;

    public _BuildServiceSoap_UpdateBuildsResponse()
    {
        super();
    }

    public _BuildServiceSoap_UpdateBuildsResponse(final _BuildDetail[] updateBuildsResult)
    {
        // TODO : Call super() instead of setting all fields directly?
        setUpdateBuildsResult(updateBuildsResult);
    }

    public _BuildDetail[] getUpdateBuildsResult()
    {
        return this.updateBuildsResult;
    }

    public void setUpdateBuildsResult(_BuildDetail[] value)
    {
        this.updateBuildsResult = value;
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

                if (localName.equalsIgnoreCase("UpdateBuildsResult"))
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
                            _BuildDetail complexObject0 = new _BuildDetail();
                            complexObject0.readFromElement(reader);
                            list0.add(complexObject0);
                        }
                    }
                    while (event0 != XMLStreamConstants.END_ELEMENT);

                    this.updateBuildsResult = (_BuildDetail[]) list0.toArray(new _BuildDetail[list0.size()]);
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
