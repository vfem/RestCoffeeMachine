package ru.test.model;

import ru.test.repo.CoffeeTaskResponse;

import java.util.List;

public interface CoffeeMachineService {

	CoffeeTaskResponse addCoffeeTask(CoffeeTask task);

	List<CoffeeTaskResponse> getAllHistory();

	String clearAllHistory();
}
