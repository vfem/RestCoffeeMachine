package ru.test.model;

import org.springframework.stereotype.Component;
import ru.test.repo.CoffeeTaskResponse;


public interface CoffeeMachine {

	void startUp(CoffeeTaskResponse response);

	void shutDown(CoffeeTaskResponse response);
	void brewEspresso(CoffeeTaskResponse response);

	void brewLatte(CoffeeTaskResponse response);
	void clean(CoffeeTaskResponse response);


}
