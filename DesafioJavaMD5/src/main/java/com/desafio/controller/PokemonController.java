package main.java.com.desafio.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.java.com.desafio.service.PokemonService;

@WebServlet("/api/pokemon")
public class PokemonController extends HttpServlet{

	private static final long serialVersionUID = -8497230951902767955L;
	
	private PokemonService service;
	
	public PokemonController() {
		this.service = new PokemonService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Pokemon pokemon = this.service.getPokemon();
		
		resp.getWriter().print(pokemon);
		
	}
	
	
}
