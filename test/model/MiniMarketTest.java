package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exceptions.ForbiddenIdType;
import exceptions.NotAllowedToLeave;

public class MiniMarketTest {
	private MiniMarket miniMarket;
	

	public void setupScenary1() {
		miniMarket = new MiniMarket();
	}
	
	public void setupScenary2() throws ForbiddenIdType, NotAllowedToLeave {
		LocalDate date = LocalDate.now();
		int day = date.getDayOfMonth();
		miniMarket = new MiniMarket();
		if(day%2 == 0) {
			miniMarket.addPerson(2, "41915693");
			miniMarket.addPerson(2, "42394545");
		}
		else {
			miniMarket.addPerson(3, "5246842");
			miniMarket.addPerson(4, "1035446");
		}
	}
	
	@Test
	public void testAdd1() throws ForbiddenIdType, NotAllowedToLeave {
		setupScenary1();
		int Selected = 2;
		String idNumber = "21536";
		miniMarket.addPerson(Selected, idNumber);
		assertEquals(1, miniMarket.getAmountOfTries());
		assertNotNull(miniMarket.getSuccesfillEntries());
	}
	
	@Test
	public void test2() throws ForbiddenIdType, NotAllowedToLeave {
		setupScenary1();
		int Selected = 2;
		String idNumber = "21533";
		miniMarket.addPerson(Selected, idNumber);
		assertEquals(1, miniMarket.getAmountOfTries());
		assertNotNull(miniMarket.getSuccesfillEntries());
	}
	
	@Test
	public void test3() {
		setupScenary1();
		boolean thrown = false;
		int Selected = 1;
		String idNumber = "54253";
		try {
			miniMarket.addPerson(Selected, idNumber);
		} catch (ForbiddenIdType | NotAllowedToLeave e) {
			thrown = true;
		}
		assertTrue(thrown);
		assertEquals(miniMarket.getAmountOfTries(), 1);
	}
	
	@Test
	public void test4() {
		setupScenary1();
		boolean thrownRight = false;
		int Selected = 2;
		String idNumber = "54252";
		try {
			miniMarket.addPerson(Selected, idNumber);
		} catch (ForbiddenIdType e) {
			
		} catch (NotAllowedToLeave e) {
			thrownRight = true;
		}
		assertTrue(thrownRight);

	}
	
	@Test
	public void test5() {
		setupScenary1();
		boolean thrownRight = false;
		int Selected = 3;
		String idNumber = "54253";
		try {
			miniMarket.addPerson(Selected, idNumber);
		} catch (ForbiddenIdType e) {
			
		} catch (NotAllowedToLeave e) {
			thrownRight = true;
		}
		assertTrue(thrownRight);
	}
	
	@Test
	public void test6() {
		boolean thrown = true;
		try {
			setupScenary2();
		} catch (ForbiddenIdType | NotAllowedToLeave e) {}
		LocalDate date = LocalDate.now();
		int day = date.getDayOfMonth();
		int Selected = 2;
		if(day%2 == 0) {
			String id = "21539";
			try {
				miniMarket.addPerson(Selected, id);
			} catch (ForbiddenIdType | NotAllowedToLeave e) {
				thrown = false;
			}
		}
		else {
			String id = "21536";
			try {
				miniMarket.addPerson(Selected, id);
			} catch (ForbiddenIdType | NotAllowedToLeave e) {
				thrown = false;
			}
		}
		assertTrue(thrown);
	}

}
