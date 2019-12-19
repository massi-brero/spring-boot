package de.massisoft.trainingsadmin.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.massisoft.trainingsadmin.entities.Training;

@Repository
public class TrainingRepository {

	@Autowired
	EntityManager em;

	public Training findbyId(Long id) {
		return em.find(Training.class, id);
	}

	public void deletebyId(Long id) {
		em.remove(findbyId(id));
	}

}
