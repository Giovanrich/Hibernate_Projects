
package com.myorg.hib006;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Sep 30, 2018
 */
@Entity@Table(name = "kids")
public class Kid implements Serializable{
    
    @Id
    private Integer id;
    private String name;    
    @OneToMany(mappedBy = "kid", fetch = FetchType.EAGER, cascade = CascadeType.ALL)//by default its LAZY.
    private List<Pencil> pencil=new ArrayList<>();

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

    public List<Pencil> getPencil() {
        return pencil;
    }

    public void setPencil(List<Pencil> pencil) {
        this.pencil = pencil;
    }

    @Override
    public String toString() {
        return "Kid{" + "id=" + id + ", name=" + name + ", pencil=" + pencil + '}';
    }
    
    

}
