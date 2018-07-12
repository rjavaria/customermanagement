package au.com.rjavaria.profile.customer.proxy;

public class SiebelException extends RuntimeException {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -7502055013080680892L;
	
	private String errorCode;
	private String errorMessage;
	private int httpStatus;

	  public SiebelException() {

	  }

	  public SiebelException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  public SiebelException(String message) {
	    super(message);
	  }

	  public SiebelException(Throwable cause) {
	    super(cause);
	  }

	  public SiebelException(String errorCode, String errorMessage) {
	    this.errorCode = errorCode;
	    this.errorMessage = errorMessage;
	  }

	    public SiebelException(String errorCode, String errorMessage, int httpStatus) {
	        this.errorCode = errorCode;
	        this.errorMessage = errorMessage;
	        this.httpStatus=httpStatus;
	    }

	  public String getErrorCode() {
	    return errorCode;
	  }

	  public void setErrorCode(String errorCode) {
	    this.errorCode = errorCode;
	  }

	  public String getErrorMessage() {
	    return errorMessage;
	  }

	  public void setErrorMessage(String errorMessage) {
	    this.errorMessage = errorMessage;
	  }

	    public int getHttpStatus() {
	        return httpStatus;
	    }

	    public void setHttpStatus(int httpStatus) {
	        this.httpStatus = httpStatus;
	    }

	  public String toString() {
	    return new StringBuilder().append("[SiebelException: {")
	            .append(" errorCode: ").append(errorCode)
	            .append(" errorMessage: ").append(errorMessage)
	            .append(" httpStatus: ").append(httpStatus)
	            .append("}]").toString();
	  }
}
