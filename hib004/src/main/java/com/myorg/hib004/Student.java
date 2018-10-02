
package com.myorg.hib004;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 29, 2018
 */

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    private Integer rollNumber;
    
    /**
     * This will trigger the creation of a third table (students_laptops). This
     * table will hold the relationship between students and laptops tables.
     * 
     */
    @OneToMany
    private List<Laptop> laptops= new ArrayList<>();

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
    
    

    
    

}
