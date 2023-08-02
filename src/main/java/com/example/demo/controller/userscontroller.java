package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.excephand.Apiresponse;
import com.example.demo.payload.users_payload;
import com.example.demo.services.usersservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/")
public class userscontroller {
	@Autowired
	usersservice ser;
	@PostMapping("insert")
	public ResponseEntity<users_payload>addusers(@Valid @RequestBody users_payload up){
		users_payload users=this.ser.addusers(up);
		return new ResponseEntity<>(users,HttpStatus.CREATED);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<users_payload>updateusers(@Valid @PathVariable int id,@RequestBody users_payload up){
		users_payload users=this.ser.updateusers(up, id);
		return ResponseEntity.ok(users);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Apiresponse>deleteusers(@Valid @PathVariable int id){
		this.ser.deleteusers(id);
		return new ResponseEntity<Apiresponse>(new Apiresponse("id deleted successfully",true),HttpStatus.OK);
	}
	@GetMapping("getall")
	public ResponseEntity<List<users_payload>> getall(){
		return ResponseEntity.ok(this.ser.getallusers());
	}
	@GetMapping("getbyid/{id}")
	public ResponseEntity<users_payload> getbyid(@Valid @PathVariable int id){
		return ResponseEntity.ok(this.ser.getbyid(id));
	}
}
