package ru.test.model;

public class CoffeeTask {

	private Goal goal;

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	@Override
	public String toString() {
		return "CoffeeTask{" +
				"goal=" + goal +
				'}';
	}
}
