
package com.keyautogeneration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@Created on Jan 22, 2019
 * @author chiraran (Giovanrich/JWizard)
 */

@Entity
@Table(name = "people")
public class Person {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    

}
