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

import ms.tfs.build.buildservice._04._AgentStatus;
import ms.tfs.build.buildservice._04._BuildAgent;
import ms.tfs.build.buildservice._04._PropertyValue;

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
public class _BuildAgent
    implements ElementSerializable, ElementDeserializable
{
    // Attributes
    protected String uri;
    protected String serviceHostUri;
    protected String controllerUri;
    protected String name;
    protected String buildDirectory;
    protected _AgentStatus status = _AgentStatus.Unavailable;
    protected String statusMessage;
    protected boolean enabled;
    protected String url;
    protected String messageQueueUrl;
    protected Calendar dateCreated;
    protected Calendar dateUpdated;
    protected String reservedForBuild;

    // Elements
    protected String description;
    protected _PropertyValue[] properties;
    protected String[] tags;

    public _BuildAgent()
    {
        super();
    }

    public _BuildAgent(
        final String uri,
        final String serviceHostUri,
        final String controllerUri,
        final String name,
        final String buildDirectory,
        final _AgentStatus status,
        final String statusMessage,
        final boolean enabled,
        final String url,
        final String messageQueueUrl,
        final Calendar dateCreated,
        final Calendar dateUpdated,
        final String reservedForBuild,
        final String description,
        final _PropertyValue[] properties,
        final String[] tags)
    {
        // TODO : Call super() instead of setting all fields directly?
        setUri(uri);
        setServiceHostUri(serviceHostUri);
        setControllerUri(controllerUri);
        setName(name);
        setBuildDirectory(buildDirectory);
        setStatus(status);
        setStatusMessage(statusMessage);
        setEnabled(enabled);
        setUrl(url);
        setMessageQueueUrl(messageQueueUrl);
        setDateCreated(dateCreated);
        setDateUpdated(dateUpdated);
        setReservedForBuild(reservedForBuild);
        setDescription(description);
        setProperties(properties);
        setTags(tags);
    }

    public String getUri()
    {
        return this.uri;
    }

    public void setUri(final String value)
    {
        this.uri = value;
    }

    public String getServiceHostUri()
    {
        return this.serviceHostUri;
    }

    public void setServiceHostUri(final String value)
    {
        this.serviceHostUri = value;
    }

    public String getControllerUri()
    {
        return this.controllerUri;
    }

    public void setControllerUri(final String value)
    {
        this.controllerUri = value;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(final String value)
    {
        this.name = value;
    }

    public String getBuildDirectory()
    {
        return this.buildDirectory;
    }

    public void setBuildDirectory(final String value)
    {
        this.buildDirectory = value;
    }

    public _AgentStatus getStatus()
    {
        return this.status;
    }

    public void setStatus(final _AgentStatus value)
    {
        this.status = value;
    }

    public String getStatusMessage()
    {
        return this.statusMessage;
    }

    public void setStatusMessage(final String value)
    {
        this.statusMessage = value;
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    public void setEnabled(final boolean value)
    {
        this.enabled = value;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(final String value)
    {
        this.url = value;
    }

    public String getMessageQueueUrl()
    {
        return this.messageQueueUrl;
    }

    public void setMessageQueueUrl(final String value)
    {
        this.messageQueueUrl = value;
    }

    public Calendar getDateCreated()
    {
        return this.dateCreated;
    }

    public void setDateCreated(final Calendar value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("'DateCreated' is a required attribute, its value cannot be null");
        }

        this.dateCreated = value;
    }

    public Calendar getDateUpdated()
    {
        return this.dateUpdated;
    }

    public void setDateUpdated(final Calendar value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("'DateUpdated' is a required attribute, its value cannot be null");
        }

        this.dateUpdated = value;
    }

    public String getReservedForBuild()
    {
        return this.reservedForBuild;
    }

    public void setReservedForBuild(final String value)
    {
        this.reservedForBuild = value;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String value)
    {
        this.description = value;
    }

    public _PropertyValue[] getProperties()
    {
        return this.properties;
    }

    public void setProperties(_PropertyValue[] value)
    {
        this.properties = value;
    }

    public String[] getTags()
    {
        return this.tags;
    }

    public void setTags(String[] value)
    {
        this.tags = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Attributes
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "Uri",
            this.uri);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "ServiceHostUri",
            this.serviceHostUri);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "ControllerUri",
            this.controllerUri);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "Name",
            this.name);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "BuildDirectory",
            this.buildDirectory);

        if (this.status != null)
        {
            this.status.writeAsAttribute(
                writer,
                "Status");
        }

        XMLStreamWriterHelper.writeAttribute(
            writer,
            "StatusMessage",
            this.statusMessage);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "Enabled",
            this.enabled);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "Url",
            this.url);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "MessageQueueUrl",
            this.messageQueueUrl);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "DateCreated",
            this.dateCreated,
            true);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "DateUpdated",
            this.dateUpdated,
            true);
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "ReservedForBuild",
            this.reservedForBuild);

        // Elements
        XMLStreamWriterHelper.writeElement(
            writer,
            "Description",
            this.description);

        if (this.properties != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("Properties");

            for (int iterator0 = 0; iterator0 < this.properties.length; iterator0++)
            {
                this.properties[iterator0].writeAsElement(
                    writer,
                    "PropertyValue");
            }

            writer.writeEndElement();
        }

        if (this.tags != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("Tags");

            for (int iterator0 = 0; iterator0 < this.tags.length; iterator0++)
            {
                XMLStreamWriterHelper.writeElement(
                    writer,
                    "string",
                    this.tags[iterator0]);
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }

    public void readFromElement(final XMLStreamReader reader)
        throws XMLStreamException
    {
        String localName;

        // Attributes
        final int attributeCount = reader.getAttributeCount();
        String attributeValue;

        for (int i = 0; i < attributeCount; i++)
        {
            localName = reader.getAttributeLocalName(i);
            attributeValue = reader.getAttributeValue(i);

            if (localName.equalsIgnoreCase("Uri"))
            {
                this.uri = attributeValue;
            }
            else if (localName.equalsIgnoreCase("ServiceHostUri"))
            {
                this.serviceHostUri = attributeValue;
            }
            else if (localName.equalsIgnoreCase("ControllerUri"))
            {
                this.controllerUri = attributeValue;
            }
            else if (localName.equalsIgnoreCase("Name"))
            {
                this.name = attributeValue;
            }
            else if (localName.equalsIgnoreCase("BuildDirectory"))
            {
                this.buildDirectory = attributeValue;
            }
            else if (localName.equalsIgnoreCase("Status"))
            {
                this.status = _AgentStatus.fromString(attributeValue);
            }
            else if (localName.equalsIgnoreCase("StatusMessage"))
            {
                this.statusMessage = attributeValue;
            }
            else if (localName.equalsIgnoreCase("Enabled"))
            {
                this.enabled = XMLConvert.toBoolean(attributeValue);
            }
            else if (localName.equalsIgnoreCase("Url"))
            {
                this.url = attributeValue;
            }
            else if (localName.equalsIgnoreCase("MessageQueueUrl"))
            {
                this.messageQueueUrl = attributeValue;
            }
            else if (localName.equalsIgnoreCase("DateCreated"))
            {
                this.dateCreated = XMLConvert.toCalendar(
                        attributeValue,
                        true);
            }
            else if (localName.equalsIgnoreCase("DateUpdated"))
            {
                this.dateUpdated = XMLConvert.toCalendar(
                        attributeValue,
                        true);
            }
            else if (localName.equalsIgnoreCase("ReservedForBuild"))
            {
                this.reservedForBuild = attributeValue;
            }

            // Ignore unknown attributes.
        }

        // Elements
        int event;

        do
        {
            event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT)
            {
                localName = reader.getLocalName();

                if (localName.equalsIgnoreCase("Description"))
                {
                    this.description = reader.getElementText();
                }
                else if (localName.equalsIgnoreCase("Properties"))
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
                            _PropertyValue complexObject0 = new _PropertyValue();
                            complexObject0.readFromElement(reader);
                            list0.add(complexObject0);
                        }
                    }
                    while (event0 != XMLStreamConstants.END_ELEMENT);

                    this.properties = (_PropertyValue[]) list0.toArray(new _PropertyValue[list0.size()]);
                }
                else if (localName.equalsIgnoreCase("Tags"))
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
                            list0.add(reader.getElementText());
                        }
                    }
                    while (event0 != XMLStreamConstants.END_ELEMENT);

                    this.tags = (String[]) list0.toArray(new String[list0.size()]);
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
