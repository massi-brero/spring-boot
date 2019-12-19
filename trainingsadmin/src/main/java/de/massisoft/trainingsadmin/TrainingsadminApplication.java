package de.massisoft.trainingsadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.massisoft.trainingsadmin.entities.Training;
import de.massisoft.trainingsadmin.repository.TrainingRepository;

@SpringBootApplication
public class TrainingsadminApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TrainingRepository trainingRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TrainingsadminApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Training training = trainingRepo.findbyId(10001L);
		
		logger.info("Trainingsinfo {}", training);
	}

}
