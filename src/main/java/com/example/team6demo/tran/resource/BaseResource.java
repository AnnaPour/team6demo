package com.example.team6demo.tran.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BaseResource implements Serializable {
	private Long id;
}
