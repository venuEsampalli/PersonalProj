package com.personal.demo.service;

import com.personal.demo.model.resp.AddPersonResp;

import java.util.List;

public interface PersonService {

       AddPersonResp addPerson(String id, String fName, String lName);
       AddPersonResp modifyPerson(String id, String fName, String lName);
       int delete(String id);
       int count();
       List<AddPersonResp> listPerson();
}
