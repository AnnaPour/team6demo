package com.example.team6demo.model.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "CUSTOMERS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CUSTOMERS_SEQ", initialValue = 1, allocationSize = 1)
public class Customer extends BaseModel {
	@NotNull(message = "Email address cannot be null")
	@Email
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@NotNull(message = "First name cannot be null")
	@Column(length = 20, nullable = false)
	private String firstname;

	@NotNull(message = "Last name cannot be null")
	@Column(length = 30, nullable = false)
	private String lastname;

	@Min(value = 18, message = "A customer cannot be under 18")
	@Max(value = 120, message = "A customer cannot be above 18")
	private Integer age;

	@Column(length = 50)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private CustomerCategory customerCategory;
}
