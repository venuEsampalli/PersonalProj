package com.personal.demo.model;

public class AddressForm {
        private String id;
        private String street;
        private String city;
        private String state;
        private String postalcode;

        public AddressForm() {
        }

    public AddressForm(String id, String street, String city, String state, String postalcode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalcode = postalcode;
    }

    public String getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalcode() {
        return postalcode;
    }
}
