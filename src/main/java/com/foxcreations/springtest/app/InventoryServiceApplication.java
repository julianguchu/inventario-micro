package com.foxcreations.springtest.app;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.foxcreations.springtest.app.util.Fechas;

@SpringBootApplication
public class InventoryServiceApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Fechas fecha = new Fechas();
		Map<LocalDate, LocalDate>  traido=fecha.calculaMesInicioYFinal(1);
		traido.forEach((k,v ) -> {System.out.println("fecha inicial mes:"+ k + " "  + "fecha final mes:" + v);});
		
		
	}

}
