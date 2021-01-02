package com.personal.demo.controller;

import com.personal.demo.model.AddressForm;
import com.personal.demo.model.PersonForm;
import com.personal.demo.model.resp.AddPersonResp;
import com.personal.demo.model.resp.AddressResp;
import com.personal.demo.service.AddressService;
import com.personal.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@RestController
    public class PersonController {

        //Logger
        Logger logger = LoggerFactory.getLogger(PersonController.class);
        @Autowired
        private PersonService personService;

        @Autowired
        private AddressService addressService;

        @PostMapping(path = "/person", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
        public List<AddPersonResp> addPerson(@RequestBody List<PersonForm> formList) throws Exception {
            logger.info("Controller class");
            List<AddPersonResp> resultList=new ArrayList<>();
            AddPersonResp addPersonResp=null;
            for (PersonForm form:formList ){
                System.out.println("input first name "+form.getFirstName());
                addPersonResp = personService.addPerson(form.getId(), form.getFirstName(), form.getLastName());
                resultList.add(addPersonResp);
            }

            if (resultList.isEmpty())
                throw new Exception("Result Object is null");

            return resultList;
        }
    @PutMapping(path = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AddPersonResp> modifyPerson(@RequestBody List<PersonForm> formList) throws Exception {

        List<AddPersonResp> resultList=new ArrayList<>();
        AddPersonResp addPersonResp=null;
        for (PersonForm form:formList ){
            System.out.println("input first name "+form.getFirstName());
            addPersonResp = personService.modifyPerson(form.getId(), form.getFirstName(), form.getLastName());
            resultList.add(addPersonResp);
        }

        if (resultList.isEmpty())
            throw new Exception("Result Object is null");

        return resultList;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {

        int isRemoved = personService.delete(id);

        if (isRemoved==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Integer> getCunt() {

        int count = personService.count();

        if (count==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping(path = "/listperson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AddPersonResp> addPerson() throws Exception {
        logger.info("list person method");
        List<AddPersonResp> resultList=new ArrayList<>();

         resultList = personService.listPerson();

        if (resultList.isEmpty())
            throw new Exception("Result Object is null");

        return resultList;
    }
    @PostMapping(path = "/address", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AddressResp> addAddress(@RequestBody List<AddressForm> formList) throws Exception {
        logger.info("Controller Address class");
        List<AddressResp> resultList=new ArrayList<>();
        AddressResp addressResp=null;
        for (AddressForm form:formList ){
            System.out.println("input first name "+form.getCity());
            addressResp = addressService.addAddress(form.getId(), form.getStreet(), form.getCity(),form.getState(),form.getPostalcode());

            resultList.add(addressResp);
        }

        if (resultList.isEmpty())
            throw new Exception("Result Object is null");

        return resultList;
    }
    @PutMapping(path = "/updateAddr", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AddressResp> modifyPAddress(@RequestBody List<AddressForm> formList) throws Exception {

        List<AddressResp> resultList=new ArrayList<>();
        AddressResp addressResp=null;
        for (AddressForm form:formList ){

            addressResp = addressService.modifyAddress(form.getId(), form.getStreet(), form.getCity(),form.getState(),form.getPostalcode());
            resultList.add(addressResp);
        }

        if (resultList.isEmpty())
            throw new Exception("Result Object is null");

        return resultList;
    }
    @DeleteMapping(value = "/deleteAddr/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable String id) {

        int isRemoved = addressService.deleleAddr(id);

        if (isRemoved==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
