package de.massisoft.trainingsadmin.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import de.massisoft.trainingsadmin.TrainingsadminApplication;
import de.massisoft.trainingsadmin.entities.Passport;
import de.massisoft.trainingsadmin.entities.Student;
import de.massisoft.trainingsadmin.entities.Training;

@SpringBootTest(classes = TrainingsadminApplication.class)
class StudentRepositoryTest {

    @Autowired
    StudentRepository repo;

    @Autowired
    EntityManager em;

    @Test
    @Transactional // creates a persistance context
    void persitance_context_test() {
        String expectedPpNumberString = "E111111";
        String expectedLastname = "Updated";

        Student student = em.find(Student.class, 20001L);
        Passport passport =  student.getPassport(); 
        
        passport.setNumber("E111111");
        student.setLastname("Updated");
        
        Student studentNew = em.find(Student.class, 20001L);
        assertEquals(expectedLastname, studentNew.getLastname());
        assertEquals(expectedPpNumberString, studentNew.getPassport().getNumber());
    }

    @Test
    @Transactional
    void retrieve_student_with_passport_details() {
        String expected = "E123456";
        Student student = em.find(Student.class, 20001L);

        assertEquals(expected, student.getPassport().getNumber());

    }
    
    @Test
    @Transactional
    void retrieve_student_with_trainings_details() {
        int expected = 2;
        Student student = em.find(Student.class, 20001L);
        
        assertEquals(expected, student.getTrainings().size());

    }

    @Test
    @Transactional
    void save_student_with_passport() {
        String expected = "Z123456";
        Passport passport = new Passport(expected);

        Student student = new Student("A", "B");
        student.setPassport(passport);
        repo.saveStudentWithPassport(student);

        assertEquals(expected, repo.findbyId(student.getId()).getPassport().getNumber());
    }
    
    @Test
    @DirtiesContext
    @Transactional
    void save_student_with_training() {
       Long studentId = 20002L;
       int expectedSize = 2;
       String expectedTitle = "ABC";
       Training training = new Training(expectedTitle, "abc", 10); 
       
       repo.saveStudentWithTraining(studentId, training);
       
       Student student = em.find(Student.class, studentId);
       
       assertThat(student.getTrainings()).hasSize(expectedSize);
       assertThat(student.getTrainings().get(1).getTitle()).isEqualTo(expectedTitle);
    }
}
