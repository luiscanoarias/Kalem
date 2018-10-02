package com.proyecto.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.service.ConsultaAnalisisTwitter;

import twitter4j.TwitterException;

@RestController
public class ConsultaController {
	
	@Autowired
	@Qualifier("ConsultaAnalisisTwitter")
	private ConsultaAnalisisTwitter cat;
	
	//consulta?busqueda="algo"
	@GetMapping("/consulta")
	public String consulta(@RequestParam String busqueda) throws IOException, TwitterException{
		
		return cat.procesarBusqueda(busqueda);
	}
	
}
