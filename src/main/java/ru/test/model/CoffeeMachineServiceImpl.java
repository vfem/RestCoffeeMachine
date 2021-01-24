package ru.test.model;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.repo.CoffeeTaskResponse;
import ru.test.repo.CoffeeTaskResponseRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

	private static final Logger log = Logger.getLogger(CoffeeMachineServiceImpl.class.getName());

	@Autowired
	private CoffeeTaskResponseRepository repo;

	@Autowired
	private CoffeeMachine machine;

	@Override
	public CoffeeTaskResponse addCoffeeTask(CoffeeTask task) {
		log.info(String.format("Processing of task %s is starting...", task));
		CoffeeTaskResponse doneTask = doWork(task);
		log.info(String.format("Task %s is done, saving is starting...", task));
		doneTask = repo.save(doneTask);
		log.info(String.format("Task %s is saved successfully, responding to request...", task));
		return doneTask;
	}

	@Override
	public List<CoffeeTaskResponse> getAllHistory() {
		return Lists.newArrayList(repo.findAll());
	}

	@Override
	public String clearAllHistory() {
		repo.deleteAll();
		return "Done successfully, current size of history log is " + Lists.newArrayList(repo.findAll()).size();
	}

	private CoffeeTaskResponse doWork(CoffeeTask task) {
		CoffeeTaskResponse response = new CoffeeTaskResponse(task.getGoal());

		if (response.getGoal() == Goal.STARTUP) {
			machine.startUp(response);
		} else if (response.getGoal() == Goal.SHUTDOWN) {
			machine.shutDown(response);
		} else if (response.getGoal() == Goal.BREW_ESPRESSO) {
			machine.brewEspresso(response);
		} else if (response.getGoal() == Goal.BREW_LATTE) {
			machine.brewLatte(response);
		} else if (response.getGoal() == Goal.CLEAN) {
			machine.clean(response);
		} else {
			response.setSuccessful(false);
			response.setErrorText("Current goal is unavailable");
		}
		return response;
	}

	public void setRepo(CoffeeTaskResponseRepository repo) {
		this.repo = repo;
	}

	public void setMachine(CoffeeMachine machine) {
		this.machine = machine;
	}
}
