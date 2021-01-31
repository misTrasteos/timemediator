package example.org;

import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.rest.RESTConstants;

import io.prometheus.client.Summary;

public class EndResourceExecutionTimeMediator extends AbstractMediator {

	private static final Summary timeSummary = Summary.build().name("resource_execution_time").help("Execution time for each resource").register();

	public boolean mediate(MessageContext context) {
		log.info("EndResourceExecutionTimeMediator - begin execution");
		
		String restFullRequestPath 	= (String) context.getProperty(RESTConstants.REST_FULL_REQUEST_PATH);
		String restSubRequestPath 	= (String) context.getProperty(RESTConstants.REST_SUB_REQUEST_PATH);
		String method 				= (String) context.getProperty(RESTConstants.REST_METHOD);
		
		log.info( String.format("Property %s, %s", RESTConstants.REST_FULL_REQUEST_PATH, restFullRequestPath) );
		log.info( String.format("Property %s, %s", RESTConstants.REST_SUB_REQUEST_PATH, restSubRequestPath) );
		log.info( String.format("Property %s, %s", RESTConstants.REST_METHOD, method) );
		
		try {
			long endTime = System.currentTimeMillis();
			long initTime = (long) context.getProperty(Constants.INIT_TIME_PROPERTY);
			long executionTime = endTime - initTime;
		
			//timeSummary.observe( executionTime );

			log.info( String.format("Execution time, %d", executionTime) );
		}catch(Exception e) {
			log.error( String.format("Error, %s", e.getMessage()) );
		}		
		
		log.info("EndResourceExecutionTimeMediator - end execution");
		
		return true;
	}//mediate

}//