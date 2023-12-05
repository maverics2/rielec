package com.example.rielec.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "task")
public class Task {

	@Id
	private String name;

	@Enumerated(EnumType.STRING)
	private TaskState state;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	public TaskState getState() {
		return state;
	}
}
