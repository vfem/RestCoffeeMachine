package ru.test.model;

import ru.test.repo.CoffeeTaskResponse;

public interface CoffeeMachineService {

	CoffeeTaskResponse addCoffeeTask(CoffeeTask task);
}
