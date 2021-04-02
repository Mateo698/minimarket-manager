package exceptions;

public class NotAllowedToLeave extends Exception{

	
	private static final long serialVersionUID = 1L;
	private int localDay;
	private int lastNumber;
	
	public NotAllowedToLeave(int localDay, int lastNumber) {
		this.setLocalDay(localDay);
		this.setLastNumber(lastNumber);
	}

	public int getLocalDay() {
		return localDay;
	}

	public void setLocalDay(int localDay) {
		this.localDay = localDay;
	}

	public int getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(int lastNumber) {
		this.lastNumber = lastNumber;
	}

}
