package de.massisoft.trainingsadmin.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;
    
    protected PartTimeEmployee() {
    }
    
    protected PartTimeEmployee(String firstname, String lastname, BigDecimal hourlyWage) {
        super(firstname, lastname);
        this.hourlyWage = hourlyWage;
    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee [hourlyWage=" + hourlyWage + ", id=" + getId() + ", firstname="
                + getFirstname() + ", lastname=" + getLastname() + "]";
    }
    
    
}
