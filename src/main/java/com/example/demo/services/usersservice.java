package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.users_payload;

public interface usersservice {//applying all methods on users_payload 
	users_payload addusers(users_payload up);
	users_payload updateusers(users_payload up,int id);
	void deleteusers(int id);
	List<users_payload>getallusers();
	users_payload getbyid(int id);
}
