package com.proyecto;

/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.Entity;
import com.google.cloud.language.v1.EntityMention;
import com.google.cloud.language.v1.LanguageServiceClient;

import java.util.Map;

/**
 * A sample application that uses the Natural Language API to perform entity, sentiment and syntax
 * analysis.
 */
public class Analyze {

  /**
   * Detects entities,sentiment and syntax in a document using the Natural Language API.
   */
	public static void main(String[] args) throws Exception {
				
		String text = "Zoé es una banda musical mexicana formada en 1995 en Cuernavaca y oficializada en 1997 en la Ciudad de México. La banda es liderada por León Larregui y conformada por Sergio Acosta (guitarra), Jesús Báez (teclados), Ángel Mosqueda (bajo) y Rodrigo Guardiola (batería).";
		
		try (LanguageServiceClient language = LanguageServiceClient.create()) {
			Document doc = Document.newBuilder()
				.setContent(text)
				.setType(Type.PLAIN_TEXT)
				.build();
			AnalyzeEntitiesRequest request = AnalyzeEntitiesRequest.newBuilder()
				.setDocument(doc)
				.setEncodingType(EncodingType.UTF16)
				.build();
			
			AnalyzeEntitiesResponse response = language.analyzeEntities(request);
				
				// Print the response
			for (Entity entity : response.getEntitiesList()) {
				System.out.printf("Entity: %s", entity.getName());
				System.out.printf("Salience: %.3f\n", entity.getSalience());
				System.out.println("Metadata: ");
				
				for (Map.Entry<String, String> entry : entity.getMetadataMap().entrySet()) {
					System.out.printf("%s : %s", entry.getKey(), entry.getValue());
				}
				
				for (EntityMention mention : entity.getMentionsList()) {
					System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
					System.out.printf("Content: %s\n", mention.getText().getContent());
					System.out.printf("Type: %s\n\n", mention.getType());
				}
								  
			}			  
		}
								  		
	}

}

 



  





  
