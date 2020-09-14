// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /enumeration.vm template.
 */
package ms.tfs.services.authorization._03;

import com.microsoft.tfs.core.ws.runtime.exceptions.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Automatically generated enumeration class.
 */
public final class _IdentityType
    extends Enumeration
{
    /**
     * This map lets static methods in this class map strings to
     * the correct instance type at deserialization time.
     */
    private final static Map VALUES_TO_INSTANCES = new HashMap();
    public static final _IdentityType InvalidIdentity = new _IdentityType("InvalidIdentity");
    public static final _IdentityType UnknownIdentityType = new _IdentityType("UnknownIdentityType");
    public static final _IdentityType WindowsUser = new _IdentityType("WindowsUser");
    public static final _IdentityType WindowsGroup = new _IdentityType("WindowsGroup");
    public static final _IdentityType ApplicationGroup = new _IdentityType("ApplicationGroup");
    public static final _IdentityType Extensible = new _IdentityType("Extensible");

    private _IdentityType(final String name)
    {
        super(name, _IdentityType.VALUES_TO_INSTANCES);
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
    public static _IdentityType fromString(final String value)
        throws SOAPSerializationException
    {
        return (_IdentityType) Enumeration.fromString(
            value,
            _IdentityType.VALUES_TO_INSTANCES);
    }
}
