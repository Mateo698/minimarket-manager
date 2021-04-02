package exceptions;

public class ForbiddenIdType extends Exception {

	
	private static final long serialVersionUID = 1L;
	private String allowedTypes;
	private String forbiddenType;
	
	public ForbiddenIdType(String allowedTypes) {
		this.setAllowedTypes(allowedTypes);
		setForbiddenType("TI");
	}

	public String getAllowedTypes() {
		return allowedTypes;
	}

	public void setAllowedTypes(String allowedTypes) {
		this.allowedTypes = allowedTypes;
	}

	public String getForbiddenType() {
		return forbiddenType;
	}

	public void setForbiddenType(String forbiddenType) {
		this.forbiddenType = forbiddenType;
	}

}
