package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class BusquedaController {
	
	@GetMapping("/busqueda")
	public String busqueda() {
		return "busqueda.html";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/report")
	public String report() {
		return "report.html";
	}
	
}
