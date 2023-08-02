package com.example.demo.services.imply;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.excephand.ResourceNotFoundException;
import com.example.demo.model.users;
import com.example.demo.payload.users_payload;
import com.example.demo.repository.usersrepo;
import com.example.demo.services.usersservice;
@Service

public class userservice_imply implements usersservice {

	@Autowired
	usersrepo repo;
	@Autowired
	ModelMapper modelmapper;
	@Override
	
	public users_payload addusers(users_payload up) {
		users u=this.dto_users(up);
		users savesusers=this.repo.save(u);
		return this.users_dto(savesusers);
	}
	@Override
	public users_payload updateusers(users_payload up, int id) {
		users u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users", "id", id));
		u.setName(up.getName());
		u.setEmail(up.getEmail());
		u.setPassword(up.getPassword());
		users u1=this.repo.save(u);
		users_payload upd=this.users_dto(u1);
		return upd;
	}

	@Override
	public void deleteusers(int id) {
		users u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users", "id", id));
		this.repo.delete(u);

	}

	@Override
	public List<users_payload> getallusers() {
		List<users> u=(List<users>) this.repo.findAll();
		List<users_payload> up=u.stream().map(ups->this.users_dto(ups)).collect(Collectors.toList());
		return up;
	}

	@Override
	public users_payload getbyid(int id) {
		users u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users", "id", id));
		return this.users_dto(u);
	}
	public users dto_users(users_payload userp){//data from duplicate to model(original) 
		users u=this.modelmapper.map(userp, users.class);
		return u;
	}
	public users_payload users_dto(users userp){//data from original to duplicate(users_payload)
		users_payload up=this.modelmapper.map(userp, users_payload.class);
		return up;
	}
}
