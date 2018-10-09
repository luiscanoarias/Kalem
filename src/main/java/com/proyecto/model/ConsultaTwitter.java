package com.proyecto.model;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class ConsultaTwitter {
	
    private Twitter twitter;
    
    public ConsultaTwitter(){
        twitter = TwitterFactory.getSingleton();
    }
    
    public List<Status> query(String query) throws TwitterException{
    	
    	//Agregado para aumentar el numero de respuestas
    	Query otraQuery =  new Query(query);
    	otraQuery.setCount(50);
    	//otraQuery.setLang("ES");	
    	
        QueryResult search = twitter.search(otraQuery);
        List<Status> tweets = search.getTweets();
        return tweets;
    }
    
}
