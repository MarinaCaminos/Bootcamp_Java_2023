package main.java.com.desafio.entity;

public class CovidEntity {
	
	private Long id;
	
	private Long states;
	
	private Long positive;
	
	private Long negative;
	
	

	public CovidEntity(Long id, Long states, Long positive, Long negative) {
		super();
		this.id = id;
		this.states = states;
		this.positive = positive;
		this.negative = negative;
	}

	public CovidEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
