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

import ms.tfs.versioncontrol.clientservices._03._RepositorySoap_UpdateWorkspaceResponse;
import ms.tfs.versioncontrol.clientservices._03._WorkingFolder;
import ms.tfs.versioncontrol.clientservices._03._WorkingFolderType;
import ms.tfs.versioncontrol.clientservices._03._Workspace;

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
public class _RepositorySoap_UpdateWorkspaceResponse
    implements ElementDeserializable
{
    // No attributes    

    // Elements
    protected _Workspace updateWorkspaceResult;

    public _RepositorySoap_UpdateWorkspaceResponse()
    {
        super();
    }

    public _RepositorySoap_UpdateWorkspaceResponse(final _Workspace updateWorkspaceResult)
    {
        // TODO : Call super() instead of setting all fields directly?
        setUpdateWorkspaceResult(updateWorkspaceResult);
    }

    public _Workspace getUpdateWorkspaceResult()
    {
        return this.updateWorkspaceResult;
    }

    public void setUpdateWorkspaceResult(_Workspace value)
    {
        this.updateWorkspaceResult = value;
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

                if (localName.equalsIgnoreCase("UpdateWorkspaceResult"))
                {
                    this.updateWorkspaceResult = new _Workspace();
                    this.updateWorkspaceResult.readFromElement(reader);
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
