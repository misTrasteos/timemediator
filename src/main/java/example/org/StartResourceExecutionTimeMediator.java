package example.org;

import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

public class StartResourceExecutionTimeMediator extends AbstractMediator { 
	
	//private final Log log = LogFactory.getLog(StartResourceExecutionTimeMediator.class);
	
	public boolean mediate(MessageContext context) {
		log.info("StartResourceExecutionTimeMediator - begin execution");
		
		long initTime = System.currentTimeMillis();		
		context.setProperty(Constants.INIT_TIME_PROPERTY, initTime);
		
		log.info( String.format("Stored %d in property %s", initTime, Constants.INIT_TIME_PROPERTY) );

		log.info("StartResourceExecutionTimeMediator - end execution");
		
		return true;
	}//mediate
	
}//TimeMediator
