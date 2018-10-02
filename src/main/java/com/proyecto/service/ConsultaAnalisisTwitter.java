package com.proyecto.service;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.proyecto.model.ClasificadorSentimiento;
import com.proyecto.model.ConsultaSentimiento;
import com.proyecto.model.ResultadoConsulta;
import com.proyecto.model.ConsultaTwitter;
import twitter4j.Status;
import twitter4j.TwitterException;

@Service("ConsultaAnalisisTwitter")
public class ConsultaAnalisisTwitter {
	
	public String procesarBusqueda(String busqueda) throws IOException, TwitterException {
		
		//OBJETO A REGRESAR COMO JSON 
		ResultadoConsulta resultado = new ResultadoConsulta();
		resultado.setBusqueda(busqueda);
		
		//CONSULTA DE TWITTER
		ConsultaTwitter controller = new ConsultaTwitter();
		List<Status> result = controller.query(busqueda);
		
		//CONSULTA DE SENTIMIENTO
		for (int i = 0; i < result.size(); i++) {
			ConsultaSentimiento consultaSentimiento = new ConsultaSentimiento(result.get(i).getText());
			resultado.setTweet(consultaSentimiento);
		}
		
		//CLASIFICACION DE LOS RESULTADOS
		ClasificadorSentimiento clasificador = new ClasificadorSentimiento(resultado.getTweets());
		
		resultado.setPositivos(clasificador.getPositivos());
		resultado.setNegativos(clasificador.getNegativos());
		resultado.setNeutrales(clasificador.getNeutrales());
		resultado.setCantidadTweets(result.size());		

		return resultado.aJson();
	}

}
