package com.proyecto.model;

import java.io.IOException;
import java.util.ArrayList;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.Entity;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Document.Type;

public class ConsultaEntidad {

	String textoAnalizar;
	int cantidadEntidades;
	ArrayList<String> entidades = new ArrayList<String>();
	
	public ConsultaEntidad(String textoAnalizar) throws IOException{
		this.textoAnalizar = textoAnalizar;
		
		try (LanguageServiceClient language = LanguageServiceClient.create()) {
			Document doc = Document.newBuilder()
				.setContent(textoAnalizar)
				.setType(Type.PLAIN_TEXT)
				.build();
			AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
				.setDocument(doc)
				.setEncodingType(EncodingType.UTF16)
				.build();
			
			AnalyzeEntitiesResponse response = language.analyzeEntities(request);
				
			this.cantidadEntidades = response.getEntitiesCount();
			
			for (Entity entity : response.getEntitiesList()) {
				
				if(entity.getName().contains("https") == false){

					if(entity.getName().contains(textoAnalizar) == false){
						entidades.add(entity.getName());
					}	
				}


			}			  
		}
	}

	public String getTextoAnalizar() {
		return textoAnalizar;
	}

	public int getCantidadEntidades() {
		return cantidadEntidades;
	}
	
	public ArrayList<String> getEntidades() {
		return entidades;
	}

}
