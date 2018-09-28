package com.myorg.hib.hib001;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author (Nation Chirara) :JWizard 
 * @Created On: Sep 26, 2018
 */

@Entity
public class User {
    
    @Id
    private Integer id;
    private String name;
    private String surname;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + '}';
    }
    

}
