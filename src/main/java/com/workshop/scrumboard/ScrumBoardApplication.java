package com.workshop.scrumboard;

import com.workshop.scrumboard.model.Task;
import com.workshop.scrumboard.model.User;
import com.workshop.scrumboard.repository.TaskRepository;

import com.workshop.scrumboard.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@SpringBootApplication
public class ScrumBoardApplication {

	private static final Logger log = LoggerFactory.getLogger(ScrumBoardApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ScrumBoardApplication.class, args);
	}

	@Bean
	public CommandLineRunner task(TaskRepository taskRepository, UserRepository userRepository){
		return (args) -> {
			User saleco = userRepository.save(new User("saleco"));
			User maria = userRepository.save(new User("maria"));
			User ben = userRepository.save(new User("ben"));


			log.info("List all users");
			userRepository.findAll().forEach(user -> {
				log.info(user.toString());
			});

			taskRepository.save(new Task("dentist", maria));
			taskRepository.save(new Task("study", saleco));
			taskRepository.save(new Task("shopping", maria));
			taskRepository.save(new Task("meeting", ben));

			log.info("List all tasks");
			taskRepository.findAll().forEach(task -> {
				log.info(task.toString());
			});

			log.info("Find task by id");
			Optional<Task> taskOptionalId = taskRepository.findById(1);
			if(taskOptionalId.isPresent())  {
				Task task1 = taskOptionalId.get();
				log.info(task1.toString());

			}

			log.info("Find task by name");

			taskRepository.findByName("meeting").forEach(task -> {
				log.info(task.toString());
			});


			log.info("Find task by Assingee");
			taskRepository.findByAssignee(ben).forEach(task -> {
				log.info(task.toString());
			});
		};

	}

}
