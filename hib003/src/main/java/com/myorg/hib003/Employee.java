
package com.myorg.hib003;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 28, 2018
 */
@Entity@Table(name="employees")
public class Employee {
    
    @Id
    private Integer id;
    private String name;    
    @OneToOne
    private Account account;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    

}
