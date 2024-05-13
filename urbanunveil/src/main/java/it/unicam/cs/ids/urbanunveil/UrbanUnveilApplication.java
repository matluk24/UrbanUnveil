package it.unicam.cs.ids.urbanunveil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.unicam.cs.ids.urbanunveil.Controller.OSMController;

@SpringBootApplication
public class UrbanUnveilApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanUnveilApplication.class, args);
		
		OSMController c = new OSMController();
		
		System.out.print(c.search("New York").getBody()); //TEST PER CONTROLLARE FUNZIONAMENTO CONTROLLER
		//CREAZIONE OGGETTO OSMNode, QUANDO RICHIESTO UN PUNTO PRECISO SULA MAPPA
	}

}
