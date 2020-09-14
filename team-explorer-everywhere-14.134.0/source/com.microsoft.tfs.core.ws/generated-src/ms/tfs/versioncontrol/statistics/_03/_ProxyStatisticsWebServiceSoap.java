// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /serviceInterface.vm template.
 */
package ms.tfs.versioncontrol.statistics._03;

import com.microsoft.tfs.core.ws.runtime.exceptions.*;
import com.microsoft.tfs.core.ws.runtime.types.*;

import ms.tfs.versioncontrol.statistics._03._ProxyStatisticsInfo;
import ms.tfs.versioncontrol.statistics._03._ProxyStatisticsWebServiceSoap_QueryProxyStatistics;
import ms.tfs.versioncontrol.statistics._03._ProxyStatisticsWebServiceSoap_QueryProxyStatisticsResponse;

import java.lang.String;

/**
 * Automatically generated service interface.
 *
 * {http://schemas.microsoft.com/TeamFoundation/2005/06/VersionControl/Statistics/03}ProxyStatisticsWebServiceSoap
 */
public interface _ProxyStatisticsWebServiceSoap
{
    public _ProxyStatisticsInfo[] queryProxyStatistics()
        throws TransportException, SOAPFault;
}
