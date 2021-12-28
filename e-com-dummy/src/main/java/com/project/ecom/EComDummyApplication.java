package com.project.ecom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.project.ecom.pojo.User;
import com.project.ecom.repository.LoginMongoRepository;

@SpringBootApplication
@EnableMongoRepositories
public class EComDummyApplication{

//	@Autowired
//	LoginMongoRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(EComDummyApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		User user = new User("Raghav1507", "Raghav@1507", "8830823772", "raghavkwal@gmail.com");
//		repo.save(user);
//		List<User> list = repo.findAll();
//		list.forEach(item -> System.out.println(item.toString()));
//	}

}
