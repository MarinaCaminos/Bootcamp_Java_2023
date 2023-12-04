package main.java.com.desafio.controller;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.java.com.desafio.service.CovidService;

@WebServlet("/api/covid")
public class CovidController extends HttpServlet{

	private static final long serialVersionUID = -8497230951902767955L;
	
	private CovidService service;
	
	public CovidController() {
		this.service = new CovidService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Covid covid = this.service.getCovid();
		
		resp.getWriter().print(covid);
		
	}
	
	
}
