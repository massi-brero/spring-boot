package de.massisoft.trainingsadmin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name="rating", nullable = false)
    private String rating;
    
    @Column(name="description", nullable = true)
    private String description;
    
    @ManyToOne
    private Training training;

    public Review() {}

    public Review(String rating, String description) {
        super();
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return rating;
    }

    public void setNumber(String number) {
        this.rating = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", number=" + rating + ", description=" + description + ", training=" + training
                + "]";
    }

}
