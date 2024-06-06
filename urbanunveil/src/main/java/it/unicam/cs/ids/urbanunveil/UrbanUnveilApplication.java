package it.unicam.cs.ids.urbanunveil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.unicam.cs.ids.urbanunveil.Controller.OSMController;
import it.unicam.cs.ids.urbanunveil.Service.OSMServiceImp;
import it.unicam.cs.ids.urbanunveil.Service.OSMService;

@SpringBootApplication
public class UrbanUnveilApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanUnveilApplication.class, args);
	}

}
