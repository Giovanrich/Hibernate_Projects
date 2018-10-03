package com.myorg.hib007;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JWizard (Nation Chirara)
 * @Created On: Oct 2, 2018
 */
@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    private Integer id;
    private String name;
    private String course;

    public Student(Integer id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    //default empty constructor is needed by Hibernate!
    public Student() {
    }

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", course=" + course + '}';
    }

}
