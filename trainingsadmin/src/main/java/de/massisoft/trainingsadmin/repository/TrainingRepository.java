package de.massisoft.trainingsadmin.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.massisoft.trainingsadmin.entities.Review;
import de.massisoft.trainingsadmin.entities.Student;
import de.massisoft.trainingsadmin.entities.Training;

@Repository
@Transactional
public class TrainingRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Training findbyId(Long id) {
        return em.find(Training.class, id);
    }

    public void deletebyId(Long id) {
        em.remove(findbyId(id));
    }
    
    
    /**
     * Doing save stuff.
     * @param training
     * @return
     */
    public Training save(Training training) {
        if (training.getId() == null) {
            em.persist(training);
        } else {
            em.merge(training);
        }

        return training;
    }
    

    public void playWithEm() {

        logger.info("############ play with entity manager -- start ############");
        Training tr1 = new Training("Training 1", "dsdsds", 10);
        em.persist(tr1);
        Training tr2 = new Training("Training 2", "dsdsds", 10);
        em.persist(tr2);
        em.flush();

        tr2.setTitle("New title f. Training 2");
        tr1.setTitle("New title f. Training 1");

        em.refresh(tr1);

        em.flush();
    }
    
    public void addReview(Long trainingId, List<Review> reviews) {
        Training training = findbyId(trainingId);
        
        for (Review review : reviews) {
            training.addReview(review);
            review.setTraining(training);
            
            em.persist(review);
        }
    }

    public Training saveTrainingWithStudent(Long trainingId, Student student) {
        Training training = findbyId(trainingId);
        
        student.addTraining(training);
        training.addStudent(student);
        
        em.persist(student);
        em.persist(training);
        
        return training;
        
    }

}
