package com.proyecto.model;

import java.util.ArrayList;

public class ClasificadorSentimiento {
	
	int positivos;
	int negativos;
	int neutrales;
	int total;
	String tweetMasPositivo = "";
	String tweetMasNegativo = "";
	ArrayList<ConsultaSentimiento> resultadosAClasificar;
	
	float scoreMasPositivoIni = 0;
	float scoreMasNegativoIni = 0;
	
	public ClasificadorSentimiento(){
	}
	
	public ClasificadorSentimiento(ArrayList<ConsultaSentimiento> resultadosAClasificar){
		this.resultadosAClasificar = resultadosAClasificar;
		this.total = resultadosAClasificar.size();
		
		for (int i = 0; i < this.total ; i++) {
			
			resultadosAClasificar.get(i).getTextoAnalizar();
			
			if (resultadosAClasificar.get(i).getScore() <= -0.25) {
				if(resultadosAClasificar.get(i).getScore() < scoreMasNegativoIni){
					tweetMasNegativo = resultadosAClasificar.get(i).getTextoAnalizar();
					scoreMasNegativoIni = resultadosAClasificar.get(i).getScore();
				}
				this.negativos++;
			}else if(resultadosAClasificar.get(i).getScore() > -0.25 && resultadosAClasificar.get(i).getScore() <= 0.25) {
				this.neutrales ++;
			}else{
				if(resultadosAClasificar.get(i).getScore() > scoreMasPositivoIni){
					tweetMasPositivo = resultadosAClasificar.get(i).getTextoAnalizar();
					scoreMasPositivoIni = resultadosAClasificar.get(i).getScore();
				}
				
				this.positivos ++;
			}
		}	
	}

	public int getPositivos() {
		return positivos;
	}

	public int getNegativos() {
		return negativos;
	}

	public int getNeutrales() {
		return neutrales;
	}
	
	public int getTotal() {
		return total;
	}
	
	public String getTweetMasPositivo() {
		return tweetMasPositivo;
	}
	
	public String getTweetMasNegativo() {
		return tweetMasNegativo;
	}	
	
	public ArrayList<ConsultaSentimiento> getResultadosAClasificar() {
		return resultadosAClasificar;
	}
	
}