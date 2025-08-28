package com.springdatajpa.SpringDataJpaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(SpringDataJpaDemoApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1= context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setRollno(25);
		s1.setMarks(250);
		s1.setName("Rup");

		s2.setRollno(26);
		s2.setMarks(260);
		s2.setName("mohan");

		s3.setRollno(27);
		s3.setMarks(270);
		s3.setName("sushil");

		repo.save(s2);
		repo.save(s3);

		Optional<Student> s = repo.findById(25);
		System.out.println(s.orElse(new Student()));
		System.out.println(s);

		System.out.println(s);
		System.out.println(repo.findByName("Rup"));


		s1.setRollno(25);
		s1.setMarks(250);
		s1.setName("Zaheer");

		repo.save(s1);
		repo.delete(s1);



	}

}
