package au.com.rjavaria.profile.customer.api;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import au.com.rjavaria.profile.common.ApiUtils;
import au.com.rjavaria.profile.customer.proxy.SiebelException;
import au.com.rjavaria.profile.entities.Error;

/**
 * Exception Handler across application.
 * 
 * @author rjavaria
 *
 */

@ControllerAdvice
public class ApiExceptionHandler { 

    private static final Logger logger = 
            LoggerFactory.getLogger(ApiExceptionHandler.class);
    
    @ExceptionHandler(SiebelException.class)
    public ResponseEntity<Error> siebelError(HttpServletRequest request, SiebelException e) {
        //HttpStatus status = getHttpStatus(e.getErrorCode());
        
    	logger.error("Exception : {}", e.getMessage());
        Error error = new Error();
        error.setCode(e.getErrorCode());
        error.setMessage(e.getErrorMessage());
        
        logger.info("Error : {}", ApiUtils.toJsonString(error));
        
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if("SIEBEL-001".equals(e.getErrorCode()))
        	status = HttpStatus.BAD_REQUEST;
        else if("SIEBEL-002".equals(e.getErrorCode())) 
            status = HttpStatus.NOT_FOUND;
        
        return new ResponseEntity<Error>(error, status);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> handleRuntimeException(HttpServletRequest request, 
                                                                  RuntimeException e) {
    	logger.error("Exception : {}", e.getMessage());
    	
    	Error error = new Error();
        error.setCode("Run time failure");
        error.setMessage(e.getMessage());
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<Error>(error, status);
    }
}