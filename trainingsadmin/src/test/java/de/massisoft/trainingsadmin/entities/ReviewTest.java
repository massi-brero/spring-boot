package de.massisoft.trainingsadmin.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import de.massisoft.trainingsadmin.TrainingsadminApplication;

@SpringBootTest(classes = TrainingsadminApplication.class)
class ReviewTest {
    
    @Autowired
    EntityManager em;
    
    @Test
    @Transactional
    @DirtiesContext
    void add_review_to_training() {
        
        Training training = em.find(Training.class, 10002L);
        
        Review review1 = new Review("3", "was ok...");
        
        review1.setTraining(training);
        training.addReview(review1);
        
        em.persist(review1);
        em.flush();
        
        training = em.find(Training.class, 10002L);
        
        assertThat(training.getReviews()).hasSize(1);
    }
    
    @Test
    void retrieve_training_from_review() {
        Long expected = 10001L;
        Review review = em.find(Review.class, 50001L);
       
        assertEquals(expected, review.getTraining().getId());
    }

}
