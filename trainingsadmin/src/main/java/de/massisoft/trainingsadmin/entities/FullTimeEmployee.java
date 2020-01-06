package de.massisoft.trainingsadmin.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {

    private BigDecimal salary;
    
    protected FullTimeEmployee() {
    }
    
    protected FullTimeEmployee(String firstname, String lastname, BigDecimal hourlyWage) {
        super(firstname, lastname);
        this.salary = hourlyWage;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee [salary=" + salary + ", id=" + getId() + ", firstname="
                + getFirstname() + ", lastname=" + getLastname() + "]";
    }
    
    
}
