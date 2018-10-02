package com.proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaFakeController {
	
	@GetMapping("/consultaFake")
	public String consultaFake() {

		return "{\"busqueda\":\"zoe\","
				+ "\"cantidadTweets\":10,"
				+ "\"positivos\":22,"
				+ "\"negativos\":1,"
				+ "\"neutrales\":7,"
				+ "\"tweets\":["
				+ "{\"textoAnalizar\":\"@Cabral12Juli @Claudinobri Jajajajajjaa lpmm, bastaa llevense bien loco\","
					+ "\"score\":0.1,"
					+ "\"magnitud\":0.6},"
					
					+ "{\"textoAnalizar\":\"RT @JuanCarrizo23: Pf entrá a mi curso y fijate https://t.co/xhoHS90gqT\","
					+ "\"score\":0.6,"
					+ "\"magnitud\":0.6},"
					
					+ "{\"textoAnalizar\":\"RT @JuanCarrizo23: Pf entrá a mi curso y fijate https://t.co/xhoHS90gqT\","
					+ "\"score\":-0.4,"
					+ "\"magnitud\":0.6}"
				+ "]}";

	}
}



