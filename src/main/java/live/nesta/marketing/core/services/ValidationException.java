package live.nesta.marketing.core.services;

public class ValidationException extends ServiceException {

	private static final long serialVersionUID = 2497443653945124678L;
	
	public ValidationException(Throwable e) {
		super(e);
	}

	public ValidationException(String code, String message) {
		super(code, message);
	}
}
