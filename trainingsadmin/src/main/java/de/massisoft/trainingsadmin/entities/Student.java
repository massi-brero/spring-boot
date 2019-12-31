package de.massisoft.trainingsadmin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="firstname", nullable = false)
    private String firstname;
    
    
    @Column(name="lastname", nullable = false)
    private String lastname;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
    
    protected Student() {}

    public Student(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
    }

}
