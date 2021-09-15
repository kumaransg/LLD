package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import application.mainClass;
import business.logic.implementation.*;

public class businessLogicImplTest {

	BusinessLogicImplementation bobj=new BusinessLogicImplementation();
	
	@Test
	public void ObjectNotnullTest() throws Exception
	{
		assertNotNull(bobj);
	}
	
	@Test
	public void t() throws Exception
	{
		assertNotNull((bobj.eligibleDrivers("Test")));
	}
}
