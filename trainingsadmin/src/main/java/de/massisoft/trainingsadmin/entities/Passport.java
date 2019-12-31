package de.massisoft.trainingsadmin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="id_number", nullable = false)
    private String number;
    
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "passport")
    Student student;
    
    public Passport() {}

    public Passport(String number) {
        super();
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport [id=" + id + ", number=" + number + "]";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
