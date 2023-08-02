package com.example.demo.service.imp;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.users;
import com.example.demo.exception_handling.ResourceNotFoundException;
import com.example.demo.payload.users_payload;
import com.example.demo.repository.usersrepository;
import com.example.demo.service.users_service;
@Service
public class users_service_imp implements users_service {
	@Autowired
    usersrepository repo;
	@Autowired
	ModelMapper modelmapper;
	@Override
	public users_payload addusers(users_payload up) {
			users us=this.dto_users(up);
			users saveusers =this.repo.save(us);
			return this.users_dto(saveusers);
		}
	@Override
	public users_payload updateusers(users_payload up, int id) {
		// TODO Auto-generated method stub
		users us = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("users","id",id));
		us.setName(up.getName());
		us.setEmail(up.getEmail());
		us.setPassword(up.getPassword());
		users us1=this.repo.save(us);
		users_payload userpayload =this.users_dto(us1);
		return userpayload;	
	}
	@Override
	public void deleteusers(int id) {
			users us = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("users","id",id));
	         this.repo.delete(us);
	}
	@Override
	public List<users_payload> getalusers() {
		List<users> us=(List<users>) this.repo.findAll();
		List<users_payload> usersp=us.stream().map(user ->this.users_dto(user)).collect(Collectors.toList());
		return usersp;
	}
	@Override
	public users_payload getbyid(int id) {
		users u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("users", "id",id));
		return this.users_dto(u);
	}
	@Override
	public users_payload update(users_payload up, int id) {
		return null;
	}public users dto_users (users_payload userp) {
		users users = this.modelmapper.map(userp,users.class);
		return users;			
	}
	public users_payload users_dto  (users usp) {
		users_payload userpayload = this.modelmapper.map(usp,users_payload.class);
		return userpayload;
}
}
