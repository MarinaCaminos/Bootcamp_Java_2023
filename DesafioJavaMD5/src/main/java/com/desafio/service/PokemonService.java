package main.java.com.desafio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import main.java.com.desafio.controller.Pokemon;
import main.java.com.desafio.entity.PokemonEntity;
import main.java.com.desafio.repository.PokemonRepository;

public class PokemonService {
	
	private PokemonRepository repository;
	
	public PokemonService() {
		this.repository = new PokemonRepository();
	}
		
	public Pokemon getPokemon() {		
		 
		PokemonEntity entity = this.repository.buscarPokemonPorId(1);
		
		Pokemon pokemon = null;
		
		if(entity == null) {
			pokemon = buscarPokemonEnAPI();
			if(pokemon != null) {
				PokemonEntity entityAux = new PokemonEntity();
				entityAux.setName(pokemon.getName());
				entityAux.setHeight(pokemon.getHeight());
				entityAux.setOrder(pokemon.getOrder());
				this.repository.guardarPokemon(entityAux);
			}
			
			return pokemon;
		}
		
		return new Pokemon(entity.getName(), entity.getHeight(), entity.getOrder());
	}
	
	 public Pokemon buscarPokemonEnAPI() {
	        
		String pokemonName = "ditto";

		String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
		
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

                String name = jsonObject.get("name").getAsString();
                long height = jsonObject.get("height").getAsLong();
                long order = jsonObject.get("order").getAsLong();

                return new Pokemon(name, height, order);
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
