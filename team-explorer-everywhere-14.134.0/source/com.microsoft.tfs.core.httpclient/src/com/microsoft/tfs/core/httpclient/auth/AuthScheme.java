/*
 * $Header:
 * /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons
 * //httpclient/src/java/org/apache/commons/httpclient/auth/AuthScheme.java,v
 * 1.12 2004/05/13 04:02:00 mbecke Exp $ $Revision: 480424 $ $Date: 2006-11-29
 * 06:56:49 +0100 (Wed, 29 Nov 2006) $
 *
 * ====================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many individuals on
 * behalf of the Apache Software Foundation. For more information on the Apache
 * Software Foundation, please see <http://www.apache.org/>.
 */

package com.microsoft.tfs.core.httpclient.auth;

import com.microsoft.tfs.core.httpclient.Credentials;
import com.microsoft.tfs.core.httpclient.HttpMethod;
import com.microsoft.tfs.core.httpclient.HttpState;

/**
 * <p>
 * This interface represents an abstract challenge-response oriented
 * authentication scheme.
 * </p>
 * <p>
 * An authentication scheme should be able to support the following functions:
 * <ul>
 * <li>Parse and process the challenge sent by the targer server in response to
 * request for a protected resource
 * <li>Provide its textual designation
 * <li>Provide its parameters, if available
 * <li>Provide the realm this authentication scheme is applicable to, if
 * available
 * <li>Generate authorization string for the given set of credentials, request
 * method and URI as specificed in the HTTP request line in response to the
 * actual authorization challenge
 * </ul>
 * </p>
 * <p>
 * Authentication schemes may ignore method name and URI parameters if they are
 * not relevant for the given authentication mechanism
 * </p>
 * <p>
 * Authentication schemes may be stateful involving a series of
 * challenge-response exchanges
 * </p>
 *
 * @author <a href="mailto:oleg@ural.ru">Oleg Kalnichevski</a>
 * @author <a href="mailto:adrian@ephox.com">Adrian Sutton</a>
 *
 * @since 2.0beta1
 */

public interface AuthScheme {
    /**
     * Determines whether this auth scheme supports credentials of the given
     * type. For example, NegotiateScheme only supports DefaultNTCredentials.
     *
     * @param credentialClass
     *        The type of credentials to query
     * @return true if these credentials are supported, false otherwise
     */
    public boolean supportsCredentials(Credentials credentials);

    /**
     * Processes the given challenge token. Some authentication schemes may
     * involve multiple challenge-response exchanges. Such schemes must be able
     * to maintain the state information when dealing with sequential challenges
     *
     * @param challenge
     *        the challenge string
     *
     * @since 3.0
     */
    void processChallenge(final String challenge) throws MalformedChallengeException;

    /**
     * Returns textual designation of the given authentication scheme.
     *
     * @return the name of the given authentication scheme
     */
    String getSchemeName();

    /**
     * Returns authentication parameter with the given name, if available.
     *
     * @param name
     *        The name of the parameter to be returned
     *
     * @return the parameter with the given name
     */
    String getParameter(final String name);

    /**
     * Tests if the authentication scheme is provides authorization on a per
     * connection basis instead of usual per request basis
     *
     * @return <tt>true</tt> if the scheme is connection based, <tt>false</tt>
     *         if the scheme is request based.
     *
     * @since 3.0
     */
    boolean isConnectionBased();

    /**
     * Authentication process may involve a series of challenge-response
     * exchanges. This method tests if the authorization process has been
     * completed, either successfully or unsuccessfully, that is, all the
     * required authorization challenges have been processed in their entirety.
     *
     * @return <tt>true</tt> if the authentication process has been completed,
     *         <tt>false</tt> otherwise.
     *
     * @since 3.0
     */
    boolean isComplete();

    /**
     * Configures the given {@link HttpMethod} for authentication to the host
     * with the given {@link Credentials}.
     *
     * @param authscope
     *        The authentication scope
     * @param credentials
     *        The set of credentials to be used for athentication
     * @param method
     *        The method being authenticated
     * @throws AuthenticationException
     *         if authorization string cannot be generated due to an
     *         authentication failure
     *
     * @since 3.0
     */
    void authenticateHost(AuthScope authscope, Credentials credentials, HttpState state, HttpMethod method)
        throws AuthenticationException;

    /**
     * Configures the given {@link HttpMethod} for authentication to the proxy
     * with the given {@link Credentials}.
     *
     * @param authscope
     *        The authentication scope
     * @param credentials
     *        The set of credentials to be used for athentication
     * @param method
     *        The method being authenticated
     * @throws AuthenticationException
     *         if authorization string cannot be generated due to an
     *         authentication failure
     *
     * @since 3.0
     */
    void authenticateProxy(AuthScope authScope, Credentials credentials, HttpState state, HttpMethod method)
        throws AuthenticationException;
}
