// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /enumeration.vm template.
 */
package ms.tfs.build.buildservice._03;

import com.microsoft.tfs.core.ws.runtime.exceptions.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Automatically generated enumeration class.
 */
public final class _BuildPhaseStatus
    extends Enumeration
{
    /**
     * This map lets static methods in this class map strings to
     * the correct instance type at deserialization time.
     */
    private final static Map VALUES_TO_INSTANCES = new HashMap();
    public static final _BuildPhaseStatus Unknown = new _BuildPhaseStatus("Unknown");
    public static final _BuildPhaseStatus Failed = new _BuildPhaseStatus("Failed");
    public static final _BuildPhaseStatus Succeeded = new _BuildPhaseStatus("Succeeded");

    private _BuildPhaseStatus(final String name)
    {
        super(name, _BuildPhaseStatus.VALUES_TO_INSTANCES);
    }

    /**
     * Gets the specific enumeration value in this class appropriate for the given
     * XML attribute value.  If no value is known, null is returned (_DEFAULT is not used; that
     * value is for when the attribute is not present).
     *
     * @param value
     *        the XML attribute value (not null)
     * @return the appropriate enumeration instance.
     */
    public static _BuildPhaseStatus fromString(final String value)
        throws SOAPSerializationException
    {
        return (_BuildPhaseStatus) Enumeration.fromString(
            value,
            _BuildPhaseStatus.VALUES_TO_INSTANCES);
    }
}
