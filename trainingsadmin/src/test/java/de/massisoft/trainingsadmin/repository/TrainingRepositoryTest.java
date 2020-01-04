package de.massisoft.trainingsadmin.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import de.massisoft.trainingsadmin.TrainingsadminApplication;
import de.massisoft.trainingsadmin.entities.Review;
import de.massisoft.trainingsadmin.entities.Student;
import de.massisoft.trainingsadmin.entities.Training;

@SpringBootTest(classes = TrainingsadminApplication.class)
class TrainingRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    TrainingRepository repo;

    @Test
    void test_findById() {
        String expected = "First training";

        Training tr = repo.findbyId(10001L);

        assertEquals(expected, tr.getTitle());
    }

    @Test
    @Transactional
    void test_retrieve_student_for_training() {
        int expected = 3;
        Training tr = repo.findbyId(10001L);

        assertThat(tr.getStudents()).hasSize(expected);
    }

    @Test
    @DirtiesContext
    void test_deleteById() {
        repo.deletebyId(10001L);

        assertNull(repo.findbyId(10001L));
    }

    @Test
    @DirtiesContext
    void test_save_new_entity() {
        Training training = new Training("Some training", "a sescription", 10);
        training = repo.save(training);

        assertNotNull(training.getId());
    }

    @Test
    @DirtiesContext
    void test_update_entity() {
        String expected = "New Title";
        Training training = repo.findbyId(10001L);
        training.setTitle(expected);

        assertEquals(expected, training.getTitle());
    }

    @Test
    @DirtiesContext
    @Transactional
    void insert_new_reviews_for_one_training() {
        Long trainingId = 10002L;
        Review review1 = new Review("3", "abcd");
        Review review2 = new Review("1", "was ok...");

        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);

        repo.addReview(trainingId, reviews);
        Training training = em.find(Training.class, trainingId);

        assertTrue(training.getReviews().contains(review1));
        assertTrue(training.getReviews().contains(review2));

    }
    
    @Test
    @DirtiesContext
    @Transactional
    void save_training_with_student() {
       Long trainingId = 10002L;
       int expectedSize = 1;
       Long expectedStudentId = 20002L;
       Student student = em.find(Student.class, expectedStudentId); 
       
       repo.saveTrainingWithStudent(trainingId, student);
       
       Training training = em.find(Training.class, trainingId);
       
       assertThat(training.getStudents()).hasSize(expectedSize);
       assertThat(training.getStudents().get(0).getId()).isEqualTo(expectedStudentId);
    }
    
    

}
