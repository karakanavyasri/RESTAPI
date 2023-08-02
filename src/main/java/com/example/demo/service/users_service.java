package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.users_payload;

public interface users_service {
   users_payload addusers(users_payload up);//reference for function original to duplicate
   users_payload updateusers(users_payload up,int id);
   void deleteusers(int id);
   List<users_payload>getalusers();
   users_payload getbyid(int id);
   users_payload update(users_payload up,int id);
}
