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
	String tweetMasPositivo;
	String tweetMasNegativo;
	ArrayList<ConsultaSentimiento> tweets = new ArrayList<ConsultaSentimiento>();
	ArrayList<String> entidades = new ArrayList<String>();
	
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
	public void setTweetMasPositivo(String tweetMasPositivo) {
		this.tweetMasPositivo = tweetMasPositivo;
	}
	public void setTweetMasNegativo(String tweetMasNegativo) {
		this.tweetMasNegativo = tweetMasNegativo;
	}	
	public void setTweets(ArrayList<ConsultaSentimiento> tweets) {
		this.tweets = tweets;
	}	
	public void setTweet(ConsultaSentimiento consultaSentimiento) {
		this.tweets.add(consultaSentimiento);
	}
	public void setEntidad(String entidad) {
		this.entidades.add(entidad);
	}
	public void setEntidades(ArrayList<String> entidades) {
		this.entidades = entidades;
	}
	public ArrayList<String> getEntidades(){
		return this.entidades;
	}
	
	public String aJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
