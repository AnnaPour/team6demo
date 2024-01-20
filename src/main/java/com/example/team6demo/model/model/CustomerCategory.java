package com.example.team6demo.model.model;

import lombok.Getter;

@Getter
public enum CustomerCategory {
	INDIVIDUAL(0f), BUSINESS(0.2f), GOVERNMENT(0.4f);
	private final float discount;

	CustomerCategory(final Float discount) {
		this.discount = discount;
	}

	public static CustomerCategory getDefault() {
		return INDIVIDUAL;
	}
}
