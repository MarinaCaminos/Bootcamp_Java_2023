package main.java.com.desafio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import main.java.com.desafio.controller.Covid;
import main.java.com.desafio.entity.CovidEntity;
import main.java.com.desafio.repository.CovidRepository;


public class CovidService {

	
	private CovidRepository repository;
	
	public CovidService() {
		this.repository = new CovidRepository();
	}
		
	public Covid getCovid() {		
		 
		CovidEntity entity = this.repository.buscarCovidPorId(1);
		
		Covid covid = null;
		
		if(entity == null) {
			covid = buscarCovidEnAPI();
			if(covid != null) {
				CovidEntity entityAux = new CovidEntity();
				entityAux.setStates(covid.getStates());
				entityAux.setPositive(covid.getPositive());
				entityAux.setNegative(covid.getNegative());
				this.repository.guardarPokemon(entityAux);
			}
			
			return covid;
		}
		
		return new Covid(entity.getStates(), entity.getPositive(), entity.getNegative());
	}
	
	 public Covid buscarCovidEnAPI() {

		String apiUrl = "https://api.covidtracking.com/v1/us/daily.json";
		
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
                JsonArray jsonArray = JsonParser.parseString(response.toString()).getAsJsonArray();
                JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();

                long status = jsonObject.get("status").getAsLong();
                long positive = jsonObject.get("positive").getAsLong();
                long negative = jsonObject.get("negative").getAsLong();

                return new Covid(status, positive, negative);
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
