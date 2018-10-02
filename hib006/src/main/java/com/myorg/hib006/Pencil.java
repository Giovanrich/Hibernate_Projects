
package com.myorg.hib006;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 30, 2018
 */

@Entity
@Table(name = "pencils")
public class Pencil implements Serializable{
    
    @Id
    private Integer id;
    private String name;
    @ManyToOne
    private Kid kid;

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

    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }

    @Override
    public String toString() {
        return "Pencil{" + "id=" + id + ", name=" + name + ", kid id=" + kid.getId() +",kid name"+kid.getName()+ '}';
    }
    
    
    

}
