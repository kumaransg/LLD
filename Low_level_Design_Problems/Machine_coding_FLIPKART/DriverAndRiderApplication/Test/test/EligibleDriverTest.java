package test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import business.logic.implementation.EligibleDrivers;

public class EligibleDriverTest {

	EligibleDrivers dobj= new EligibleDrivers();
	@Test
	public void ObjectNotnullTest() throws Exception
	{
		assertNotNull(dobj);
	}
	
}
