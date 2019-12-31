package de.massisoft.trainingsadmin.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.massisoft.trainingsadmin.TrainingsadminApplication;

@SpringBootTest(classes = TrainingsadminApplication.class)
class TrainingTest {

	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	void throws_error_when_title_is_null() {
		Training training = new Training("Some training", "a sescription", 10);
		training.setTitle(null);

		assertThrows(PersistenceException.class, () -> {
			em.persist(training);
			em.flush();
		});

	}
	
	@Test
    @Transactional
    void check_created_date_was_inserted () {
	    Training training = new Training("Some training", "a sescription", 10);
	    em.persist(training);
        em.flush();
        
        Training actualTraining = em.find(Training.class, training.getId());
	    assertNotNull(actualTraining.getUpdated());
	}
	
	@Test
    @Transactional
    void check_updated_date_was_inserted () {
        Training training = new Training("Some training", "a sescription", 10);
        em.persist(training);
        em.flush();
        
        Training actualTraining = em.find(Training.class, training.getId());
        assertNotNull(actualTraining.getCreated());
    }

}
