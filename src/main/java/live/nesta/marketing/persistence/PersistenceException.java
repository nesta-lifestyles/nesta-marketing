package live.nesta.marketing.persistence;

public class PersistenceException extends Exception {

	private static final long serialVersionUID = -5138526492948223255L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
