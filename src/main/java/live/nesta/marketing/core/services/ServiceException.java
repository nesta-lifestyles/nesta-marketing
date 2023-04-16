package live.nesta.marketing.core.services;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -8651940035254261410L;
	
	private String code;

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
