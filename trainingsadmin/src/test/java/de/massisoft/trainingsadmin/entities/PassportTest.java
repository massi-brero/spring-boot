package de.massisoft.trainingsadmin.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.massisoft.trainingsadmin.TrainingsadminApplication;

@SpringBootTest(classes = TrainingsadminApplication.class)
class PassportTest {
    
    @Autowired
    EntityManager em;

    @Test
    void get_student_information() {
        var expected = 20001L;
        Passport passport = em.find(Passport.class, 40001L);
       
        Student student = passport.getStudent();
        
        assertNotNull(student);
        assertEquals(expected, student.getId());
        
    }

}
