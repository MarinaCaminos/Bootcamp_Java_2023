package main.java.com.desafio.controller;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.java.com.desafio.service.PlaceHolderService;


@WebServlet("/api/placeHolder")
public class PlaceHolderController extends HttpServlet{

	private static final long serialVersionUID = -8497230951902767955L;
	
	private PlaceHolderService service;
	
	public PlaceHolderController() {
		this.service = new PlaceHolderService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PlaceHolder placeHolder = this.service.getPlaceHolder();
		
		resp.getWriter().print(placeHolder);
		
	}
}