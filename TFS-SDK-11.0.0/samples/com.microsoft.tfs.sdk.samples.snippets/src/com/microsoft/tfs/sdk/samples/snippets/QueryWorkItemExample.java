package com.microsoft.tfs.sdk.samples.snippets;

import com.microsoft.tfs.core.TFSTeamProjectCollection; 
import com.microsoft.tfs.core.clients.workitem.WorkItem; 
import com.microsoft.tfs.core.clients.workitem.WorkItemClient; 
import com.microsoft.tfs.core.clients.workitem.query.WorkItemCollection;

public class QueryWorkItemExample {

    /** 
     * @param args 
     */ 
    public static void main(String[] args) {
    	System.setProperty("com.microsoft.tfs.jni.native.base-directory","C:\\workspace\\vsts\\redist\\native");
    	
//    	TFSTeamProjectCollection tpc = new TFSTeamProjectCollection("http://tfs2010:8080/tfs/DefaultCollection", "username","password","domain"); 
        TFSTeamProjectCollection tpc = SnippetSettings.connectToTFS();
        
    	
        WorkItemClient workItemClient = tpc.getWorkItemClient(); 
        
        // Define the WIQL query.          
        String wiqlQuery = "Select ID, Title from WorkItems where (State = 'Active') order by Title"; 
        
        // Run the query and get the results.          
        WorkItemCollection workItems = workItemClient.query(wiqlQuery);

        System.out.println("Found " + workItems.size() + " work items."); 
        System.out.println(); 
        
        // Write out the heading.          
        System.out.println("ID\tTitle"); 
        
        // Output the first 20 results of the query 
        final int maxToPrint = 200; 
        
        for (int i = 0; i < workItems.size(); i++) { 
        	if (i >= maxToPrint) { 
                System.out.println("[...]");                  
                break; 
            } 
            WorkItem workItem = workItems.getWorkItem(i); 
            System.out.println(workItem.getID() + "\t" + workItem.getTitle());  
        } 
        System.out.println("Done"); 
    }

}