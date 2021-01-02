package com.personal.demo.service;
import com.personal.demo.model.PersonObj;
import com.personal.demo.model.resp.AddPersonResp;
import com.personal.demo.repository.PersonRepo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PersonService")
public class PersonServiceImpl implements PersonService {

        Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
        @Autowired
        PersonRepo personRepo;

        @Override
        public AddPersonResp addPerson(String id, String fName, String lName) {
                AddPersonResp addPersonResp = new AddPersonResp();
                int count =personRepo.savePerson(id,lName,fName);
                logger.info("value in personrepo "+count);
                if(count>0) {
                        addPersonResp.setId(id);
                        addPersonResp.setFirstName(fName);
                        addPersonResp.setLastName(lName);
                }
                return addPersonResp;
        }
        @Override
        public AddPersonResp modifyPerson(String id, String fName, String lName) {
                AddPersonResp addPersonResp = new AddPersonResp();
                int count =personRepo.updatePerson(id,lName,fName);
                logger.info("modify person check "+count);
                if(count>0) {
                        addPersonResp.setId(id);
                        addPersonResp.setFirstName(fName);
                        addPersonResp.setLastName(lName);
                }
                return addPersonResp;
        }
        @Override
        public int delete(String id) {

                int deleteCount =personRepo.deletePerson(id);
                logger.info("deleted count "+deleteCount);
                return deleteCount;
        }
        @Override
        public int count() {
                int count =personRepo.countPerson();
                logger.info("count number of persons "+count);
                return count;
        }
        @Override
        public List<AddPersonResp> listPerson() {
                AddPersonResp addPersonResp = new AddPersonResp();
                List<AddPersonResp> resultList =new ArrayList<>();
                List<PersonObj> personList =personRepo.listPerson();
                for (PersonObj personObj: personList) {
                        addPersonResp.setId(personObj.getId());
                        addPersonResp.setLastName(personObj.getLastname());
                        addPersonResp.setFirstName(personObj.getFirstname());
                        resultList.add(addPersonResp);
                }
                logger.info("value in personrepo count"+personList.size());

                return resultList;
        }

}
