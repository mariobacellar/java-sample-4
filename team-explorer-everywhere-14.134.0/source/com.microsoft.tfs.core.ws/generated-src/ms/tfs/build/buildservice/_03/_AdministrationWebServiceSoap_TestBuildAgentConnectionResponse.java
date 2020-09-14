// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.build.buildservice._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.build.buildservice._03._AdministrationWebServiceSoap_TestBuildAgentConnectionResponse;
import ms.tfs.build.buildservice._03._AgentStatus;
import ms.tfs.build.buildservice._03._BuildAgent;
import ms.tfs.build.buildservice._03._BuildAgentQueryResult;
import ms.tfs.build.buildservice._03._BuildController;
import ms.tfs.build.buildservice._03._BuildServiceHost;
import ms.tfs.build.buildservice._03._ControllerStatus;
import ms.tfs.build.buildservice._03._Failure;

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
public class _AdministrationWebServiceSoap_TestBuildAgentConnectionResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected _BuildAgentQueryResult testBuildAgentConnectionResult;

    public _AdministrationWebServiceSoap_TestBuildAgentConnectionResponse()
    {
        super();
    }

    public _AdministrationWebServiceSoap_TestBuildAgentConnectionResponse(
        final _BuildAgentQueryResult testBuildAgentConnectionResult)
    {
        // TODO : Call super() instead of setting all fields directly?
        setTestBuildAgentConnectionResult(testBuildAgentConnectionResult);
    }

    public _BuildAgentQueryResult getTestBuildAgentConnectionResult()
    {
        return this.testBuildAgentConnectionResult;
    }

    public void setTestBuildAgentConnectionResult(_BuildAgentQueryResult value)
    {
        this.testBuildAgentConnectionResult = value;
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

                if (localName.equalsIgnoreCase("TestBuildAgentConnectionResult"))
                {
                    this.testBuildAgentConnectionResult = new _BuildAgentQueryResult();
                    this.testBuildAgentConnectionResult.readFromElement(reader);
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
