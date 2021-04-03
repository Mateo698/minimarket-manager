package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.ForbiddenIdType;
import exceptions.NotAllowedToLeave;

public class MiniMarketTest {
	private MiniMarket miniMarket;
	

	public void setupScenary1() {
		miniMarket = new MiniMarket();
	}
	
	public void setupScenary2() throws ForbiddenIdType, NotAllowedToLeave {
		miniMarket = new MiniMarket();
		miniMarket.addPerson(2, "41915693");
		miniMarket.addPerson(3, "5246842");
		miniMarket.addPerson(4, "1035442");
		miniMarket.addPerson(2, "423945");
	}
	
	@Test
	public void testAdd1() throws ForbiddenIdType, NotAllowedToLeave {
		setupScenary1();
		int Selected = 2;
		String idNumber = "21536";
		miniMarket.addPerson(Selected, idNumber);
		assertEquals(1, miniMarket.getAmountOfTries());
		assertEquals(, null);
	}

}
