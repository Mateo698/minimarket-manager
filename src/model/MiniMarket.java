package model;

import java.util.ArrayList;
import exceptions.*;
import java.time.LocalDate;


public class MiniMarket {
	
	private ArrayList<Person> succesfullEntries;
	private int amountOfTries;
	private static final String ALLOWEDTYPES = "CC - Cédula de Ciudadanía-, PP -Pasaporte- o CE -Cédula de Extranjeria";
	
	public MiniMarket() {
		succesfullEntries = new ArrayList<Person>();
		setAmountOfTries(0);
	}
	
	public void addPerson(int selectedIdType,String idNumber) throws ForbiddenIdType,NotAllowedToLeave{
		LocalDate date = LocalDate.now();
		int day = date.getDayOfMonth();
		int lastNumber = Integer.parseInt(String.valueOf(idNumber.charAt(idNumber.length()-1)));
		if(selectedIdType == 1) {
			setAmountOfTries(getAmountOfTries() + 1);
			throw new ForbiddenIdType(ALLOWEDTYPES);			
		}
		else if(!allowedToLeave(lastNumber,day)) {
			setAmountOfTries(getAmountOfTries() + 1);
			throw new NotAllowedToLeave(day, lastNumber);
		}
		else {
			setAmountOfTries(getAmountOfTries() + 1);
			succesfullEntries.add(new Person(convertId(selectedIdType),idNumber));
		}
	}
	
	public boolean allowedToLeave(int lastNumber,int day) {
		if((lastNumber%2 == 0 && day%2 != 0) || (lastNumber%2 != 0 && day%2 == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private String convertId(int selected) {
		String id = "";
		switch(selected) {
		case 2: 
			id = "CC";
		break;
		
		case 3:
			id = "PP";
		break;
		
		case 4:
			id = "CE";
		break;
		
		default:
			id = "xd";
		}
		return id;
	}

	public int getAmountOfTries() {
		return amountOfTries;
	}

	public void setAmountOfTries(int amountOfTries) {
		this.amountOfTries = amountOfTries;
	}
}
