package com.proyecto.model;

import java.io.IOException;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;


public class ConsultaSentimiento {
	
	String textoAnalizar;
	Float score;
	Float magnitud;

	public ConsultaSentimiento(){
	}

	public ConsultaSentimiento(String textoAnalizar) throws IOException{
		this.textoAnalizar = textoAnalizar;
		
	    try (LanguageServiceClient language = LanguageServiceClient.create()) {
	    	
	    	// Texto a analizar
		    Document doc = Document.newBuilder().setContent(this.textoAnalizar).setType(Type.PLAIN_TEXT).build();
		
		    // Detectar el sentimiento del texto
		    Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();
		    
			this.score = sentiment.getScore();
			this.magnitud = sentiment.getMagnitude();
	    }
	}
	
	public String getTextoAnalizar() {
		return textoAnalizar;
	}

	public Float getScore() {
		return score;
	}

	public Float getMagnitud() {
		return magnitud;
	}

}
