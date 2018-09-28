package com.myorg.hib002;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 27, 2018
 */

@Entity@Table(name="users")
public class User {

    @Id @Column(name="stud_id")
    private Integer id;
    private Name aname;
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getAname() {
        return aname;
    }

    public void setAname(Name aname) {
        this.aname = aname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

}
