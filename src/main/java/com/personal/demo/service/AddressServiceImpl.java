package com.personal.demo.service;

import com.personal.demo.model.PersonObj;
import com.personal.demo.model.resp.AddPersonResp;
import com.personal.demo.model.resp.AddressResp;
import com.personal.demo.repository.AddressRepo;
import com.personal.demo.repository.PersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {

        Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
        @Autowired
        AddressRepo addressRepo;

        @Override
        public AddressResp addAddress(String id, String street, String city, String state, String postalcode){
                AddressResp addressResp = new AddressResp();
                int count =addressRepo.saveAddress(id,street,city,state,postalcode);
                logger.info("value in addressRepo "+count);
                if(count>0) {
                        addressResp.setId(id);
                        addressResp.setCity(city);
                        addressResp.setStreet(street);
                        addressResp.setState(state);
                        addressResp.setPostalcode(postalcode);

                }
                return addressResp;
        }
        @Override
        public AddressResp modifyAddress(String id, String street, String city, String state, String postalcode) {
                AddressResp addressResp = new AddressResp();
                int count =addressRepo.updateAddress(id,street,city,state,postalcode);
                logger.info("modify address check "+count);
                if(count>0) {
                        addressResp.setId(id);
                        addressResp.setCity(city);
                        addressResp.setStreet(street);
                        addressResp.setState(state);
                        addressResp.setPostalcode(postalcode);

                }
                return addressResp;
        }
        @Override
        public int deleleAddr(String id) {

                int deleteCount =addressRepo.deleteAddress(id);
                logger.info("deleted count address"+deleteCount);
                return deleteCount;
        }

}
