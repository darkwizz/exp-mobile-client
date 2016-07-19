package com.example.artur.exp_mobile_android.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artur on 19.07.16.
 */
public class ExpPerson {
    private String expId;
    private String firstName;
    private String lastName;
    private String location;
    private String email;
    private String phone;
    private boolean isInterviewed;
    private String lcName;
    private String lcCountryName;
    private List<ExpPerson> managers;
    private ExpPersonStatus status;

    public ExpPerson(String expId) {
        this.expId = expId;
        managers = new ArrayList<>();
    }

    public String getExpId() {
        return expId;
    }

    public String getLcName() {
        return lcName;
    }

    public void setLcName(String lcName) {
        this.lcName = lcName;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isInterviewed() {
        return isInterviewed;
    }

    public void setInterviewed(boolean interviewed) {
        isInterviewed = interviewed;
    }

    public String getLcCountryName() {
        return lcCountryName;
    }

    public void setLcCountryName(String lcCountryName) {
        this.lcCountryName = lcCountryName;
    }

    public List<ExpPerson> getManagers() {
        return managers;
    }

    public ExpPersonStatus getStatus() {
        return status;
    }

    public void setStatus(ExpPersonStatus status) {
        this.status = status;
    }
}
