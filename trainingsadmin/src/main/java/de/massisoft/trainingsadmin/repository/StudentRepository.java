package de.massisoft.trainingsadmin.repository;

import java.util.MissingResourceException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.massisoft.trainingsadmin.entities.Student;
import de.massisoft.trainingsadmin.entities.Training;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findbyId(Long id) {
        return em.find(Student.class, id);
    }

    public void deletebyId(Long id) {
        em.remove(findbyId(id));
    }
    
    
    /**
     * Doing save stuff.
     * @param student
     * @return
     */
    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }
    

    public Student saveStudentWithPassport(Student student) throws MissingResourceException {
        
        em.persist(student);
        
        if (student.getPassport() != null) {
            em.persist(student.getPassport());
        } else {
            throw new MissingResourceException("Please provide a passport for the student", "Passport", "");
        }
       
        return student;

    }
    
    public Student saveStudentWithTraining(Long studentId, Training training) {
        Student student = findbyId(studentId);
        
        student.addTraining(training);
        training.addStudent(student);
        
        em.persist(student);
        em.persist(training);
        
        return student;
    }

}
