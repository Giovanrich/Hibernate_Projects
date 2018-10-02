
package com.myorg.hib004;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 29, 2018
 */
@Entity
@Table(name = "laptops")
public class Laptop {
    
    @Id
    private Integer id;
    private String name;

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
    

}
