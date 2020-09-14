package com.accenture.tim.tfs;

import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.accenture.tim.tfs.commoms.ApplicationProperties;
import com.accenture.tim.tfs.query.QueryPerformer;
import com.accenture.tim.tfs.query.model.Query;

public class Toolbox {

	//private static final Logger LOG = LoggerFactory.getLogger(Toolbox.class.getName());
	
	//private static final Logger LOG = Logger.getRootLogger();
	private static final Logger LOG = Logger.getLogger(Toolbox.class.getName());
	
	
	public static int G_FLG_EXECUTION_CONTROL_RUNNING			= 0;
	public static int G_FLG_EXECUTION_CONTROL_STOP_REQUESTED	= 1;
	public static int G_FLG_EXECUTION_CONTROL_STOP_CRASH		= 2;
	
	public static long G_APP_SLEEP_5_SEC = 5000; // 4Segundo
	public static long G_APP_SLEEP_1_MIN = (10000 * 6); // 1minuto
	
	public static void main(String[] args) {
		try {

			LOG.info("-> main");
			
			ApplicationProperties.appProperties();
			
			int flgExecutionControl = readExecutionControlFile();// check the control file
			
			boolean stopToolbox = (flgExecutionControl == G_FLG_EXECUTION_CONTROL_RUNNING);
			
			while(stopToolbox) {

				LOG.info("=== Looking for tasks to do.");

				Query[] queries = loadQueries(); 
				for (int i = 0; i < queries.length; i++) {
					Query  query     = queries[i];
					String queryId	 = query.getId();
					String queryName = query.getName();
					LOG.info("=============================================================");
					LOG.info("Performing QueryId=["+queryId+"] - QueryName=["+queryName+"]");
					LOG.info("=============================================================");
				
					QueryPerformer	
					queryPerf = new QueryPerformer(query);
					queryPerf.perform();
				}
				
				sleepingWhile();
				LOG.info("=== Running another round.");
			}

			
			if (flgExecutionControl==G_FLG_EXECUTION_CONTROL_STOP_REQUESTED) {
				LOG.debug("@@@ Toolbox stoped by request @@@");
			}
			
			if (flgExecutionControl==G_FLG_EXECUTION_CONTROL_STOP_CRASH) {
				LOG.debug("### Toolbox stoped by crash ###: Look for the reasons in the log file.");
			}

			LOG.info("-> main: NORMAL");
		} catch (Exception e) {
			LOG.debug("<- main: ERROR");
			e.printStackTrace();
		}
	}

	
	private static Query[] loadQueries() {
		
		Query[] queries = new Query[2]; 
		
		Query 
		query1 = new Query();
		query1.setId("1");
		query1.setName("Epicos Em Desenvolvimento");
		query1.setWiql("SELECT ID, [Work Item Type], Title, [Assigned To], State, Tags FROM WorkItems WHERE  ([Work Item Type] = 'Epic' and [Text field 3] = 'Aguardando desenvolvimento') OR ([Work Item Type] = 'Epic' and [Text field 3] = 'Em desenvolvimento') ORDER BY ID ");

		Query 
		query2 = new Query();
		query2.setId("1");
		query2.setName("Todos os Epicos");
		query2.setWiql("SELECT ID, [Work Item Type], Title, [Assigned To], State, Tags FROM WorkItems WHERE State = 'Active'" );
//		query2.setWiql("SELECT ID, [Work Item Type], Title, [Assigned To], State, Tags FROM WorkItems WHERE ([Work Item Type] = 'Epic' and [Text field 3] = 'Aguardando desenvolvimento') OR ([Work Item Type] = 'Epic' and [Text field 3] = 'Em desenvolvimento') ORDER BY ID ");

		queries[0]=query1;
		queries[1]=query2;
		
		return queries;
	}


	private static void sleepingWhile() throws Exception {
		boolean existNewRequests = checkTaskRequests();
		
		if (existNewRequests) {
			
			System.out.println("+++ New requests were made +++: Toolbox won't sleeping");
			
		}else {
			System.out.println("+++ No new requests were made +++: Toolbox is sleeping by ["+G_APP_SLEEP_5_SEC+"] miliseconds");
			Thread.sleep(G_APP_SLEEP_5_SEC);
		}
	}

	
	/**
	 * Implementar uma rotina para comparar se os arquivos de configuração das queries tiveram suas datas alteradas
	 * @return
	 */
	private static boolean checkTaskRequests() {
		LOG.debug("-> checkTaskRequests()");
		boolean ret=false;
		LOG.debug("<- checkTaskRequests():NORMAL");
		return ret;
	}


	/**
	 * It reads the execution control file and return the execution status:
	 * 0=running
	 * 1=stop requested
	 * 2=stop by crash
	 * 
	 * @return an execution status
	 */
	private static int readExecutionControlFile() {
		LOG.debug("-> readExecutionControlFile()");
		int ret=0;
		LOG.debug("<- readExecutionControlFile():NORMAL");
		return ret;
	}

	
	
}
