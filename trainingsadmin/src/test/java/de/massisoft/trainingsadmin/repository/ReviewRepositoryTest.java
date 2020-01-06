package de.massisoft.trainingsadmin.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.massisoft.trainingsadmin.TrainingsadminApplication;
import de.massisoft.trainingsadmin.entities.Review;
import de.massisoft.trainingsadmin.entities.Student;
import de.massisoft.trainingsadmin.entities.Training;

@SpringBootTest(classes = TrainingsadminApplication.class)
class ReviewRepositoryTest {
    
    @Autowired
    EntityManager em;
    
    @Autowired
    ReviewRepository repo;

    @Test
    void save_review_with_Student() {
        Long expected = 20002L;
        Student student = em.find(Student.class, expected);
        Training training = em.find(Training.class, 10001L);
        
        Review review = new Review("4", "ok");
        review.setTraining(training);    
        review = repo.saveReviewWithStudent(review, student);
        
        Review reviewFromDB = em.find(Review.class, review.getId());
        
        assertThat(reviewFromDB.getStudent().getId()).isEqualTo(expected);
        
    }

}
