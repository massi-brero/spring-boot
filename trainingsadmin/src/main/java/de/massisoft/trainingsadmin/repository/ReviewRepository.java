package de.massisoft.trainingsadmin.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.massisoft.trainingsadmin.entities.Review;
import de.massisoft.trainingsadmin.entities.Student;

@Repository
@Transactional
public class ReviewRepository {

    @Autowired
    EntityManager em;

    public Review findbyId(Long id) {
        return em.find(Review.class, id);
    }

    public void deletebyId(Long id) {
        em.remove(findbyId(id));
    }
    
    
    /**
     * Doing save stuff.
     * @param review
     * @return
     */
    public Review save(Review review) {
        if (review.getId() == null) {
            em.persist(review);
        } else {
            em.merge(review);
        }

        return review;
    }
    
    
    public Review saveReviewWithStudent(Review review, Student student) {
        
        review.setStudent(student);
        em.persist(review);
        
        return review;
    }

}
