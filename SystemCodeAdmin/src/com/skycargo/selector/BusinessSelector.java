package com.skycargo.selector;

import com.skycargo.exception.InvalidException;

public class BusinessSelector {
	public RequestHandler selectBusiness(String requestType) throws InvalidException{
		RequestHandler requestHandler=null;
		if(requestType !=null){
			//selection process logic
		if(RequestType.SYSTEM_PARAMETER.equals(requestType)){
			
			requestHandler=new SystemParamCodeAction();
		}else if(RequestType.MODULE_CODE.equals(requestType)){
			
			requestHandler=new ModuleCodeAction();
		}else if(RequestType.SCREEN_CODE.equals(requestType)){
			
			requestHandler=new ScreenCodeAction();
		}else if(RequestType.PERMISSION.equals(requestType)){
			
			requestHandler=new PermissionCodeAction();
		}else if(RequestType.QUEUE_CODE.equals(requestType)){
			
			requestHandler=new QueueCodeAction();
		}else if(RequestType.JOB_CODE.equals(requestType)){
			
			requestHandler=new JobCodeAction();
		}else{
			
			throw new InvalidException("Invalid request type: "+requestType);
		}
		
		
		
		
		
		
		
		
		
		
		
		}
		
		return requestHandler;
	}
}
