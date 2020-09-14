/*
 * Copyright (c) Microsoft Corporation. All rights reserved. This code released
 * under the terms of the Microsoft Public License (MS-PL,
 * http://opensource.org/licenses/ms-pl.html.)
 */

package com.accenture.tim.tfs.query;

import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.accenture.tim.tfs.connector.TFSSettings;
import com.microsoft.tfs.core.TFSTeamProjectCollection;
import com.microsoft.tfs.core.clients.workitem.WorkItemClient;
import com.microsoft.tfs.core.clients.workitem.project.Project;
import com.microsoft.tfs.core.clients.workitem.query.WorkItemCollection;

public class QueryWorkItem {
	
//	private static final Logger LOG = LoggerFactory.getLogger(QueryWorkItem.class.getName());
	private static final Logger LOG = Logger.getLogger(QueryWorkItem.class.getName());
	
	public TFSTeamProjectCollection	tpc;
	public Project project;
	public WorkItemClient workItemClient;

	public QueryWorkItem() {
		// Is mandatory config the JNDI
    	System.setProperty("com.microsoft.tfs.jni.native.base-directory",".\\ext\\native");
    	
        this.tpc            = TFSSettings.connectToTFS();
        this.project        = tpc.getWorkItemClient().getProjects().get(TFSSettings.PROJECT_NAME);
        this.workItemClient	= project.getWorkItemClient();
	}
	
	public WorkItemCollection execute(String wiqlQuery) {
		LOG.debug("-> execute");
        // Run the query and get the results.
        WorkItemCollection workItems = workItemClient.query(wiqlQuery);
        LOG.debug("<- execute:NORMAL");
        return workItems;
	}
	
}
