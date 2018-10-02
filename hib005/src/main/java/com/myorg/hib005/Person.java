
package com.myorg.hib005;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 30, 2018
 */

@Entity
@Table(name = "persons")
public class Person {
    
    @Id@Column(name = "person_id")
    private Integer id;
    private String name;
    
    /**
     * The below mappedBy tag will result in two tables being formed
     * instead of three, thus a column in computers table will be added 
     * to form the relationship
     */
    @OneToMany(mappedBy = "person") //One person has many laptops
    private List<Computer> computers=new ArrayList<>();

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

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
    
    
    

}
