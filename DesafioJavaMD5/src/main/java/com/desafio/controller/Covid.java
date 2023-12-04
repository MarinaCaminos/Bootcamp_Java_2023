package main.java.com.desafio.controller;

public class Covid {
	
	private Long states;
	
	private Long positive;
	
	private Long negative;

	
	public Covid(Long states, Long positive, Long negative) {
		super();
		this.states = states;
		this.positive = positive;
		this.negative = negative;
	}

	public Long getStates() {
		return states;
	}

	public void setStates(Long states) {
		this.states = states;
	}

	public Long getPositive() {
		return positive;
	}

	public void setPositive(Long positive) {
		this.positive = positive;
	}

	public Long getNegative() {
		return negative;
	}

	public void setNegative(Long negative) {
		this.negative = negative;
	}
	
	
	
	
}
