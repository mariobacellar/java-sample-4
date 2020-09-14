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

import ms.tfs.versioncontrol.clientservices._03._Change;
import ms.tfs.versioncontrol.clientservices._03._ChangeType;
import ms.tfs.versioncontrol.clientservices._03._Changeset;
import ms.tfs.versioncontrol.clientservices._03._CheckinNote;
import ms.tfs.versioncontrol.clientservices._03._CheckinNoteFieldValue;
import ms.tfs.versioncontrol.clientservices._03._CheckinNotificationInfo;
import ms.tfs.versioncontrol.clientservices._03._CheckinNotificationWorkItemInfo;
import ms.tfs.versioncontrol.clientservices._03._CheckinWorkItemAction;
import ms.tfs.versioncontrol.clientservices._03._Item;
import ms.tfs.versioncontrol.clientservices._03._ItemType;
import ms.tfs.versioncontrol.clientservices._03._MergeSource;
import ms.tfs.versioncontrol.clientservices._03._PolicyFailureInfo;
import ms.tfs.versioncontrol.clientservices._03._PolicyOverrideInfo;
import ms.tfs.versioncontrol.clientservices._03._PropertyValue;
import ms.tfs.versioncontrol.clientservices._03._Repository4Soap_CheckIn;

import java.lang.Object;
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
public class _Repository4Soap_CheckIn
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected String workspaceName;
    protected String ownerName;
    protected String[] serverItems;
    protected _Changeset info;
    protected _CheckinNotificationInfo checkinNotificationInfo;
    protected int checkinOptions;
    protected boolean deferCheckIn;
    protected int checkInTicket;

    public _Repository4Soap_CheckIn()
    {
        super();
    }

    public _Repository4Soap_CheckIn(
        final String workspaceName,
        final String ownerName,
        final String[] serverItems,
        final _Changeset info,
        final _CheckinNotificationInfo checkinNotificationInfo,
        final int checkinOptions,
        final boolean deferCheckIn,
        final int checkInTicket)
    {
        // TODO : Call super() instead of setting all fields directly?
        setWorkspaceName(workspaceName);
        setOwnerName(ownerName);
        setServerItems(serverItems);
        setInfo(info);
        setCheckinNotificationInfo(checkinNotificationInfo);
        setCheckinOptions(checkinOptions);
        setDeferCheckIn(deferCheckIn);
        setCheckInTicket(checkInTicket);
    }

    public String getWorkspaceName()
    {
        return this.workspaceName;
    }

    public void setWorkspaceName(String value)
    {
        this.workspaceName = value;
    }

    public String getOwnerName()
    {
        return this.ownerName;
    }

    public void setOwnerName(String value)
    {
        this.ownerName = value;
    }

    public String[] getServerItems()
    {
        return this.serverItems;
    }

    public void setServerItems(String[] value)
    {
        this.serverItems = value;
    }

    public _Changeset getInfo()
    {
        return this.info;
    }

    public void setInfo(_Changeset value)
    {
        this.info = value;
    }

    public _CheckinNotificationInfo getCheckinNotificationInfo()
    {
        return this.checkinNotificationInfo;
    }

    public void setCheckinNotificationInfo(_CheckinNotificationInfo value)
    {
        this.checkinNotificationInfo = value;
    }

    public int getCheckinOptions()
    {
        return this.checkinOptions;
    }

    public void setCheckinOptions(int value)
    {
        this.checkinOptions = value;
    }

    public boolean isDeferCheckIn()
    {
        return this.deferCheckIn;
    }

    public void setDeferCheckIn(boolean value)
    {
        this.deferCheckIn = value;
    }

    public int getCheckInTicket()
    {
        return this.checkInTicket;
    }

    public void setCheckInTicket(int value)
    {
        this.checkInTicket = value;
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
            "workspaceName",
            this.workspaceName);
        XMLStreamWriterHelper.writeElement(
            writer,
            "ownerName",
            this.ownerName);

        if (this.serverItems != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("serverItems");

            for (int iterator0 = 0; iterator0 < this.serverItems.length; iterator0++)
            {
                XMLStreamWriterHelper.writeElement(
                    writer,
                    "string",
                    this.serverItems[iterator0]);
            }

            writer.writeEndElement();
        }

        if (this.info != null)
        {
            this.info.writeAsElement(
                writer,
                "info");
        }

        if (this.checkinNotificationInfo != null)
        {
            this.checkinNotificationInfo.writeAsElement(
                writer,
                "checkinNotificationInfo");
        }

        XMLStreamWriterHelper.writeElement(
            writer,
            "checkinOptions",
            this.checkinOptions);
        XMLStreamWriterHelper.writeElement(
            writer,
            "deferCheckIn",
            this.deferCheckIn);
        XMLStreamWriterHelper.writeElement(
            writer,
            "checkInTicket",
            this.checkInTicket);

        writer.writeEndElement();
    }
}
