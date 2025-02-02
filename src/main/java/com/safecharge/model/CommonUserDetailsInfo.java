

/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

public abstract class CommonUserDetailsInfo {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String zip;
    private String city;
    private String countryCode;
    private String state;
    private String email;
    private String locale;
    private String county;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("firstName='")
                .append(firstName)
                .append('\'');
        sb.append(", lastName='")
                .append(lastName)
                .append('\'');
        sb.append(", address='")
                .append(address)
                .append('\'');
        sb.append(", phone='")
                .append(phone)
                .append('\'');
        sb.append(", zip='")
                .append(zip)
                .append('\'');
        sb.append(", city='")
                .append(city)
                .append('\'');
        sb.append(", countryCode='")
                .append(countryCode)
                .append('\'');
        sb.append(", state='")
                .append(state)
                .append('\'');
        sb.append(", email='")
                .append(email)
                .append('\'');
        sb.append(", locale='")
                .append(locale)
                .append('\'');
        sb.append(", county='")
                .append(county)
                .append('\'');
        sb.append('}');

        return sb.toString();
    }
}
