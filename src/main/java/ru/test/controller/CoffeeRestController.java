package ru.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import ru.test.model.CoffeeMachineService;
import ru.test.model.CoffeeTask;
import ru.test.repo.CoffeeTaskResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;


@RestController
public class CoffeeRestController {

	private static final Logger log = Logger.getLogger(CoffeeRestController.class.getName());

	@Autowired
	private CoffeeMachineService coffeeService;

	/*http://localhost:8080/coffee/swagger-ui.html*/

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String welcome() {
		return "Welcome to CoffeeRestService Example.";
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Async
	public CompletableFuture<CoffeeTaskResponse> addTask(@RequestBody CoffeeTask task) {
		log.info(Thread.currentThread().getName());
		return CompletableFuture.completedFuture(coffeeService.addCoffeeTask(task));
	}

	@RequestMapping(value = "/getAllHistory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CoffeeTaskResponse> getAllHistory() {
		return coffeeService.getAllHistory();
	}

	@RequestMapping(value = "/clearAllHistory", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String clearAllHistory() {
		return coffeeService.clearAllHistory();
	}
}
