package ru.test.model;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import ru.test.repo.CoffeeTaskResponse;
import ru.test.repo.CoffeeTaskResponseRepository;

import static org.junit.Assert.*;

public class CoffeeMachineServiceImplTest {

	@Test
	public void addCoffeeTask() {
		CoffeeTaskResponseRepository repository = Mockito.mock(CoffeeTaskResponseRepository.class);
		CoffeeMachine machine = Mockito.mock(CoffeeMachine.class);


		CoffeeMachineServiceImpl service = new CoffeeMachineServiceImpl();

		service.setRepo(repository);
		service.setMachine(machine);

		CoffeeTask task = new CoffeeTask();

		Mockito.when(repository.save(Mockito.any(CoffeeTaskResponse.class)))
				.thenAnswer((Answer<CoffeeTaskResponse>) invocationOnMock -> {
			Object[] args = invocationOnMock.getArguments();
			return (CoffeeTaskResponse) args[0];
		});

		CoffeeTaskResponse response = service.addCoffeeTask(task);
		Assert.assertFalse(response.isSuccessful());

	}
}