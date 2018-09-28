
package com.myorg.hib003;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 28, 2018
 */

@Entity@Table(name="emp_accounts")
public class Account implements Serializable {
    
    @Id
    private Integer id;
    

    private String acc_number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcc_number() {
        return acc_number;
    }

    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }
    
    

}
