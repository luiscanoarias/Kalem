package com.proyecto.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.proyecto.model.ClasificadorSentimiento;
import com.proyecto.model.ConsultaEntidad;
import com.proyecto.model.ConsultaSentimiento;
import com.proyecto.model.ResultadoConsulta;
import com.proyecto.model.ConsultaTwitter;
import twitter4j.Status;
import twitter4j.TwitterException;

@Service("ConsultaAnalisisTwitter")
public class ConsultaAnalisisTwitter {
	
	public String procesarBusqueda(String busqueda) throws IOException, TwitterException {
		
		ArrayList<String> listaEntidadesTemp = new ArrayList<String>();
		Set<String> setTemporal = new HashSet<>();
		
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
		
		//CONSULTA DE ENTIDADES
		for (int i = 0; i < result.size(); i++) {
			ConsultaEntidad consultaEntidad = new ConsultaEntidad(result.get(i).getText());
			
			//Agregar cada entidad encontrada en cada resultado de tweet a la lista de entidades de ResultadoConsulta
			for (String entidad : consultaEntidad.getEntidades()) {
				listaEntidadesTemp.add(entidad);
			}	
		}
		// Quitar entidades repetidas de la lista, copiandola a un set
		setTemporal.addAll(listaEntidadesTemp);
		listaEntidadesTemp.clear();
		listaEntidadesTemp.addAll(setTemporal);
		
		//CLASIFICACION DE LOS RESULTADOS
		ClasificadorSentimiento clasificador = new ClasificadorSentimiento(resultado.getTweets());
		
		
		resultado.setPositivos(clasificador.getPositivos());
		resultado.setNegativos(clasificador.getNegativos());
		resultado.setNeutrales(clasificador.getNeutrales());
		resultado.setTweetMasPositivo(clasificador.getTweetMasPositivo());
		resultado.setTweetMasNegativo(clasificador.getTweetMasNegativo());
		resultado.setCantidadTweets(result.size());		
		resultado.setEntidades(listaEntidadesTemp);
		
		return resultado.aJson();
	}

}
