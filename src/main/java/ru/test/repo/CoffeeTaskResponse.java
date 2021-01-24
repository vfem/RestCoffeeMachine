package ru.test.repo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.test.model.Goal;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CoffeeTaskResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Goal goal;

	@JsonFormat
			(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
	private Date startTime;

	@JsonFormat
			(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss.SSS")
	private Date finishTime;

	private boolean isSuccessful;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorText;



	public CoffeeTaskResponse() {
	}

	public CoffeeTaskResponse(Goal goal) {
		this.goal = goal;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean successful) {
		isSuccessful = successful;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	@Override
	public String toString() {
		return "CoffeeTask{" +
				"id=" + id +
				", goal='" + goal + '\'' +
				", isSuccessful=" + isSuccessful +
				", errorText='" + errorText + '\'' +
				'}';
	}

}
