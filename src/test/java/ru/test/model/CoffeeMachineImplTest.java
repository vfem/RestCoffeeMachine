package ru.test.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.test.repo.CoffeeTaskResponse;

public class CoffeeMachineImplTest {

	private CoffeeMachineImpl machine;
	private CoffeeTaskResponse response;

	@Before
	public void setUp() {
		machine = new CoffeeMachineImpl();
		response = new CoffeeTaskResponse();
	}

	@Test
	public void startUp() {
		response.setGoal(Goal.STARTUP);
		machine.startUp(response);

		Assert.assertTrue(response.isSuccessful());
		Assert.assertTrue(machine.isStarted());

		machine.startUp(response);
		Assert.assertFalse(response.isSuccessful());

		machine.setStarted(false);
	}

	@Test
	public void shutDown() {
		response.setGoal(Goal.SHUTDOWN);
		machine.shutDown(response);
		Assert.assertFalse(response.isSuccessful());

		machine.setStarted(true);
		machine.shutDown(response);
		Assert.assertTrue(response.isSuccessful());
		Assert.assertFalse(machine.isStarted());
	}

	@Test
	public void brewEspresso() {
		response.setGoal(Goal.BREW_ESPRESSO);
		machine.setStarted(true);
		machine.brewEspresso(response);

		Assert.assertTrue(response.isSuccessful());

		machine.setStarted(false);
		machine.brewEspresso(response);
		Assert.assertFalse(response.isSuccessful());
	}

	@Test
	public void brewLatte() {
		response.setGoal(Goal.BREW_LATTE);
		machine.setStarted(true);
		machine.brewLatte(response);

		Assert.assertTrue(response.isSuccessful());

		machine.setStarted(false);
		machine.brewLatte(response);
		Assert.assertFalse(response.isSuccessful());
	}

	@Test
	public void clean() {
		response.setGoal(Goal.CLEAN);
		machine.setStarted(true);
		machine.clean(response);

		Assert.assertTrue(response.isSuccessful());

		machine.setStarted(false);
		machine.clean(response);
		Assert.assertFalse(response.isSuccessful());
	}
}