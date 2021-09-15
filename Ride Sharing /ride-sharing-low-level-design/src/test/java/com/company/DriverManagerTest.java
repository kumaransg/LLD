package com.company;

import com.company.exception.DriverAlreadyPresentException;
import com.company.exception.DriverNotFoundException;
import com.company.manager.DriverManager;
import com.company.model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DriverManagerTest {

	DriverManager driverManager;

	@BeforeEach
	void setup() {
		driverManager = new DriverManager();
	}

	@Test
	void test_createDriverAndGetDrivers() {
		// Given.
		Driver dummyDriver = new Driver(2, "Shubham");
		driverManager.createDriver(new Driver(1, "Amar"));
		driverManager.createDriver(new Driver(2, "Prateek"));
		driverManager.createDriver(new Driver(3, "Rajat"));

		// Then.
		assertThrows(DriverAlreadyPresentException.class, () -> {
			// When.
			driverManager.createDriver(dummyDriver);
		});

		// Then.
		assertEquals(3, driverManager.getDrivers().size());
	}

	@Test
	void test_updateDriverAvailability() {

		// Given.
		driverManager.createDriver(new Driver(1, "Amar"));
		driverManager.createDriver(new Driver(2, "Prateek"));
		driverManager.createDriver(new Driver(3, "Rajat"));

		assertEquals(3, driverManager.getDrivers().size());

		// When.
		driverManager.updateDriverAvailability(3, false);

		// Then.
		assertEquals(2, driverManager.getDrivers().size());

		// Then.
		assertThrows(DriverNotFoundException.class, () -> {
			// When.
			driverManager.updateDriverAvailability(10, false);
		});
	}
}
