package com.keysequencegeneration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @Created on Jan 22, 2019
 * @author chiraran (Giovanrich/JWizard)
 */
@Entity(name = "users")
public class User {

// From https://www.baeldung.com/hibernate-identifiers.
//To use a sequence-based id, Hibernate provides the SequenceStyleGenerator class.
//This generator uses sequences if they’re supported by our database, and switches to table generation if they arent.
//To customize the sequence name, we can use the @GenericGenerator annotation with SequenceStyleGenerator strategy:   
//In this example, we’ve also set an initial value for the sequence, which means the primary key generation will start at 4.
//SEQUENCE is the generation type recommended by the Hibernate documentation
//The generated values are unique per sequence. If you don’t specify a sequence name, Hibernate will re-use the same hibernate_sequence for different types
    @Id
    @GenericGenerator(
            name = "seqGen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "seqGen"),
                @Parameter(name = "initial_value", value = "4"),//Seq start at 4
                @Parameter(name = "increment_size", value = "2") // This did not work, check some time
            }
    )
    @GeneratedValue(generator ="seqGen")
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
    
    
}
