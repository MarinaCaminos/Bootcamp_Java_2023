package main.java.com.desafio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import main.java.com.desafio.controller.PlaceHolder;
import main.java.com.desafio.entity.PlaceHolderEntity;
import main.java.com.desafio.repository.PlaceHolderRepository;

public class PlaceHolderService {
	
	private PlaceHolderRepository repository;
	
	public PlaceHolderService() {
		this.repository = new PlaceHolderRepository();
	}
		
	public PlaceHolder getPlaceHolder() {		
		 
		PlaceHolderEntity entity = this.repository.buscarPlaceHolderPorId(1);
		
		PlaceHolder placeHolder = null;
		
		if(entity == null) {
			placeHolder = buscarPlaceHolderEnAPI();
			if(placeHolder != null) {
				PlaceHolderEntity entityAux = new PlaceHolderEntity();
				entityAux.setId(placeHolder.getId());
				entityAux.setTitle(placeHolder.getTitle());
				entityAux.setCompleted(placeHolder.isCompleted());
				this.repository.guardarPlaceHolder(entityAux);
			}
			
			return placeHolder;
		}
		
		return new PlaceHolder(entity.getId(), entity.getTitle(), entity.isCompleted());
	}
	
	 public PlaceHolder buscarPlaceHolderEnAPI() {
	        
		Long placeHolderId = (long) 1;

		String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + placeHolderId;
		
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                Gson gson = new Gson();
                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

                long id = jsonObject.get("id").getAsLong();
                String title = jsonObject.get("title").getAsString();
                boolean completed = jsonObject.get("completed").getAsBoolean();

                return new PlaceHolder(id, title, completed);
			} else {
			    System.out.println("Error al realizar la solicitud. Código de respuesta: " + responseCode);
			}
			
			connection.disconnect();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return null;
    }
}
