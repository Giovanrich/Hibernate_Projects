package com.myorg.hib002;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 27, 2018
 */
@Embeddable
public class Name {

    @Column(name="first_name")
    private String fname;
    @Column(name="middle_name")
    private String mname;
    @Column(name="last_name")
    private String lname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
    
}
