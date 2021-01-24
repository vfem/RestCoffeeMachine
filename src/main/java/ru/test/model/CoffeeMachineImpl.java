package ru.test.model;

import org.springframework.stereotype.Component;
import ru.test.repo.CoffeeTaskResponse;

import java.util.Date;
import java.util.logging.Logger;

@Component
public class CoffeeMachineImpl implements CoffeeMachine {

	public CoffeeMachineImpl() {
	}

	private boolean isStarted = false;

	private static final Logger log = Logger.getLogger(CoffeeMachineImpl.class.getName());

	@Override
	public void startUp(CoffeeTaskResponse response) {
		response.setStartTime(new Date());
		if (!isStarted) {
			try {
				log.info("bbbbrrrrrrr Coffee machine starting...");
				Thread.sleep(50);
				response.setFinishTime(new Date());
				response.setSuccessful(true);
				log.info("Machine started, task is done");
				isStarted = true;
			} catch (InterruptedException e) {
				log.info("Caught InterruptedException " + e.getMessage());
				e.printStackTrace();
				response.setSuccessful(false);
				response.setFinishTime(new Date());
				response.setErrorText("Unexpected error occur " + e.getMessage());
			}
		} else {
			log.info("Can't start, machine already started, task is done unsuccessfully");
			response.setFinishTime(new Date());
			response.setSuccessful(false);
			response.setErrorText("Machine already started");
		}
	}

	@Override
	public void shutDown(CoffeeTaskResponse response) {
		response.setStartTime(new Date());
		if (isStarted) {
			try {
				log.info("pppphhhhhhhh Coffee machine turning off...");
				Thread.sleep(30);
				response.setFinishTime(new Date());
				response.setSuccessful(true);
				log.info("Machine turned off, task is done");
				isStarted = false;
			} catch (InterruptedException e) {
				log.info("Caught InterruptedException " + e.getMessage());
				e.printStackTrace();
				response.setSuccessful(false);
				response.setFinishTime(new Date());
				response.setErrorText("Unexpected error occur " + e.getMessage());
			}
		} else {
			log.info("Can't stop, machine already turned off, task is done unsuccessfully");
			response.setFinishTime(new Date());
			response.setSuccessful(false);
			response.setErrorText("Machine already turned off");
		}
	}

	@Override
	public void brewEspresso(CoffeeTaskResponse response) {
		response.setStartTime(new Date());
		if (isStarted) {
			try {
				log.info("brrrrrrr, phhhhhhhh, brrrrrrrrrr Coffee machine brewing espresso...");
				Thread.sleep(100);
				response.setFinishTime(new Date());
				response.setSuccessful(true);
				log.info("Machine brewed espresso, task is done");
			} catch (InterruptedException e) {
				log.info("Caught InterruptedException " + e.getMessage());
				e.printStackTrace();
				response.setSuccessful(false);
				response.setFinishTime(new Date());
				response.setErrorText("Unexpected error occur " + e.getMessage());
			}
		} else {
			log.info("Can't brew espresso, machine turned off, task is done unsuccessfully");
			response.setFinishTime(new Date());
			response.setSuccessful(false);
			response.setErrorText("Machine turned off");
		}
	}

	@Override
	public void brewLatte(CoffeeTaskResponse response) {
		response.setStartTime(new Date());
		if (isStarted) {
			try {
				log.info("brrrrrrr, phhhhhhhh, brrrrrrrrrr Coffee machine brewing latte...");
				Thread.sleep(100);
				response.setFinishTime(new Date());
				response.setSuccessful(true);
				log.info("Machine brewed latte, task is done");
			} catch (InterruptedException e) {
				log.info("Caught InterruptedException " + e.getMessage());
				e.printStackTrace();
				response.setSuccessful(false);
				response.setFinishTime(new Date());
				response.setErrorText("Unexpected error occur " + e.getMessage());
			}
		} else {
			log.info("Can't brew latte, machine turned off, task is done unsuccessfully");
			response.setFinishTime(new Date());
			response.setSuccessful(false);
			response.setErrorText("Machine turned off");
		}
	}

	@Override
	public void clean(CoffeeTaskResponse response) {
		response.setStartTime(new Date());
		if (isStarted) {
			try {
				log.info("phhhhhhhh, phhhhhhhh, brrrrrrrrrr, phhhhhhhh Coffee machine cleaning cycle started...");
				Thread.sleep(100);
				response.setFinishTime(new Date());
				response.setSuccessful(true);
				log.info("Machine cleaning cycle complete, task is done");
			} catch (InterruptedException e) {
				log.info("Caught InterruptedException " + e.getMessage());
				e.printStackTrace();
				response.setSuccessful(false);
				response.setFinishTime(new Date());
				response.setErrorText("Unexpected error occur " + e.getMessage());
			}
		} else {
			log.info("Can't start cleaning cycle, machine turned off, task is done unsuccessfully");
			response.setFinishTime(new Date());
			response.setSuccessful(false);
			response.setErrorText("Machine turned off");
		}
	}


	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean started) {
		isStarted = started;
	}
}
