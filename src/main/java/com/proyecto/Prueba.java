package com.proyecto;

import com.proyecto.model.ConsultaEntidad;

public class Prueba {
	public static void main(String[] args) throws Exception {
		
		String texto = "Zoé es una banda musical mexicana formada en 1995 en Cuernavaca y oficializada en 1997 en la Ciudad de México. La banda es liderada por León Larregui y conformada por Sergio Acosta (guitarra), Jesús Báez (teclados), Ángel Mosqueda (bajo) y Rodrigo Guardiola (batería).";
		
		ConsultaEntidad consulta = new ConsultaEntidad(texto);
		System.out.println(consulta.getEntidades());

		
	}
}
