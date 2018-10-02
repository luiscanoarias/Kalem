package com.proyecto.model;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.proyecto.model.ConsultaSentimiento;

public class ResultadoConsulta {
	
	String busqueda;
	int cantidadTweets;
	int positivos;
	int negativos;
	int neutrales;
	ArrayList<ConsultaSentimiento> tweets = new ArrayList<ConsultaSentimiento>();
	
	public ResultadoConsulta() {
	}
	
	public ArrayList<ConsultaSentimiento> getTweets() {
		return tweets;
	}
	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}
	public void setCantidadTweets(int cantidadTweets) {
		this.cantidadTweets = cantidadTweets;
	}
	public void setPositivos(int positivos) {
		this.positivos = positivos;
	}
	public void setNegativos(int negativos) {
		this.negativos = negativos;
	}
	public void setNeutrales(int neutrales) {
		this.neutrales = neutrales;
	}
	public void setTweets(ArrayList<ConsultaSentimiento> tweets) {
		this.tweets = tweets;
	}	
	public void setTweet(ConsultaSentimiento consultaSentimiento) {
		this.tweets.add(consultaSentimiento);
	}
	
	public String aJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
