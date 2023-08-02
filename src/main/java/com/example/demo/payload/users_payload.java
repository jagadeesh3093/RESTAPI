package com.example.demo.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class users_payload {//it is for security purpose it is duplicate of entity layer so any third party can't change entity layer
	private int id;
	@NotEmpty
	private String name;
	private String email;
	@Size(min = 6,max = 16)
	@NotEmpty
	private String password;
}
