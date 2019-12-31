package de.massisoft.trainingsadmin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="rating", nullable = false)
    private String number;
    
    @Column(name="description", nullable = true)
    private String description;

    public Review() {}

    public Review(String number, String description) {
        super();
        this.number = number;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
