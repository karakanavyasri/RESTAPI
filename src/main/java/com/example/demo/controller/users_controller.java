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

import com.example.demo.exception_handling.Apiresponse;
import com.example.demo.payload.users_payload;
import com.example.demo.service.users_service;

import jakarta.validation.Valid;
@RestController
@RequestMapping("api/v1")
public class users_controller {
      @Autowired
      users_service service;	
      @PostMapping("/insert")
      public ResponseEntity<users_payload>addusers(@Valid @RequestBody users_payload up){
    	  users_payload users=this.service.addusers(up);
    	  return new ResponseEntity<>(users,HttpStatus.CREATED);  
      }
      @PutMapping("/update/{id}")
      public ResponseEntity<users_payload>updateusers(@Valid @PathVariable int id,@RequestBody users_payload u){
    	  users_payload user=this.service.updateusers(u,id);
    	  return ResponseEntity.ok(user);  
      }
      @DeleteMapping("/delete/{id}")
      public ResponseEntity<Apiresponse>deleteusers(@Valid @PathVariable int id ){
     	  this.service.deleteusers(id);
     	  return new ResponseEntity<Apiresponse>(new Apiresponse("id deleted was successfully",true),HttpStatus.OK);
       }
      @GetMapping("/getalusers")
      public ResponseEntity<List<users_payload>>getalusers(){
    	  return ResponseEntity.ok(this.service.getalusers());  
      }
      @GetMapping("/getbyid/{id}")
      public ResponseEntity<users_payload>getbyid(@Valid @PathVariable int id){
    	  return ResponseEntity.ok(this.service.getbyid(id));
      }
}

