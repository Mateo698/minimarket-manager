package model;

public class Person {

	private String idType;
	private String idNumber;
	
	public Person(String id, String number) {
		setIdType(id);
		setIdNumber(number);
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	
}
