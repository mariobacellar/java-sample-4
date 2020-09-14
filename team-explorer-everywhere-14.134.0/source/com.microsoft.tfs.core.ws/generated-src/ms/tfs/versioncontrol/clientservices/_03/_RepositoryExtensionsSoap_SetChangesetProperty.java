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

import ms.tfs.versioncontrol.clientservices._03._PropertyValue;
import ms.tfs.versioncontrol.clientservices._03._RepositoryExtensionsSoap_SetChangesetProperty;

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
public class _RepositoryExtensionsSoap_SetChangesetProperty
    implements ElementSerializable
{
    // No attributes    

    // Elements
    protected int changesetId;
    protected _PropertyValue[] propertyValues;

    public _RepositoryExtensionsSoap_SetChangesetProperty()
    {
        super();
    }

    public _RepositoryExtensionsSoap_SetChangesetProperty(
        final int changesetId,
        final _PropertyValue[] propertyValues)
    {
        // TODO : Call super() instead of setting all fields directly?
        setChangesetId(changesetId);
        setPropertyValues(propertyValues);
    }

    public int getChangesetId()
    {
        return this.changesetId;
    }

    public void setChangesetId(int value)
    {
        this.changesetId = value;
    }

    public _PropertyValue[] getPropertyValues()
    {
        return this.propertyValues;
    }

    public void setPropertyValues(_PropertyValue[] value)
    {
        this.propertyValues = value;
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
            "changesetId",
            this.changesetId);

        if (this.propertyValues != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("propertyValues");

            for (int iterator0 = 0; iterator0 < this.propertyValues.length; iterator0++)
            {
                this.propertyValues[iterator0].writeAsElement(
                    writer,
                    "PropertyValue");
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }
}
