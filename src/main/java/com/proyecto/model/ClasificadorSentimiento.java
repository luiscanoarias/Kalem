package com.proyecto.model;

import java.util.ArrayList;

public class ClasificadorSentimiento {
	
	int positivos;
	int negativos;
	int neutrales;
	int total;
	ArrayList<ConsultaSentimiento> resultadosAClasificar;
	
	public ClasificadorSentimiento(){
	}
	
	public ClasificadorSentimiento(ArrayList<ConsultaSentimiento> resultadosAClasificar){
		this.resultadosAClasificar = resultadosAClasificar;
		this.total = resultadosAClasificar.size();
		
		for (int i = 0; i < this.total ; i++) {
			
			if (resultadosAClasificar.get(i).getScore() <= -0.25) {
				this.negativos++;
			}else if(resultadosAClasificar.get(i).getScore() > -0.25 && resultadosAClasificar.get(i).getScore() <= 0.25) {
				this.neutrales ++;
			}else{
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
	
	public ArrayList<ConsultaSentimiento> getResultadosAClasificar() {
		return resultadosAClasificar;
	}
	
}