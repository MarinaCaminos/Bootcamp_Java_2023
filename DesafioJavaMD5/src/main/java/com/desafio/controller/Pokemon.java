package main.java.com.desafio.controller;

public class Pokemon {
	
	private String name;
	
	private Long order;
	
	private Long height;

	public Pokemon(String name, Long order, Long height) {
		super();
		this.name = name;
		this.order = order;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}
	
	
}
