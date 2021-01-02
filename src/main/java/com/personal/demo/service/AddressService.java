package com.personal.demo.service;

import com.personal.demo.model.resp.AddPersonResp;
import com.personal.demo.model.resp.AddressResp;

import java.util.List;

public interface AddressService {

       AddressResp addAddress(String id, String street, String city, String state, String postalcode);
       AddressResp modifyAddress(String id, String street, String city,String state,String postalcode);
       int deleleAddr(String id);

}
