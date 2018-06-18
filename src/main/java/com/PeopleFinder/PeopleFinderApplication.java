package com.PeopleFinder;



import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PeopleFinder.Repository.PeopleRepository;
import com.PeopleFinder.data.PersonInfo;

@SpringBootApplication
public class PeopleFinderApplication implements CommandLineRunner{

	private final static org.apache.logging.log4j.Logger log = LogManager.getLogger(PeopleFinderApplication.class);
	
	@Autowired
	private PeopleRepository pr;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PeopleFinderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(pr.findall());
		log.info("/////////////////////////");
		log.info(pr.findById(1));
		log.info("/////////////////////////");
		log.info("Deleted by Id number ="+pr.deleteById(1));
		log.info("/////////////////////////");
		log.info(pr.findall());
		log.info("/////////////////////////");
		log.info(pr.insert(new PersonInfo(10,"Flaco","Tampa",new Date(365))));
		log.info("/////////////////////////");
		log.info(pr.update(new PersonInfo(10,"testName","TestPlace",new Date(365))));
		log.info("/////////////////////////");
		log.info(pr.findall());
		
	}
}
