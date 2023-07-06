package com.example.guessmaster3;//Bradley Stephen
//20207842
//April 10th 2023

public class Country extends Entity {
	private final String capital;
	
	public Country(String name, Date birthDate, String capital, double difficulty) {
		super(name, birthDate, difficulty);
		this.capital = capital;
	}
	
	public Country(Country entity) {
		super(entity.getName(), entity.getBorn(), entity.getDifficulty());
		this.capital = entity.getCapital();
	}
	
	public Entity clone(Entity entity) {
		Country c = new Country((Country) entity);
		return c;
}	
	
	public String getCapital() {
		return capital;
	}
	
	public String toString() {
		return super.toString() + "Capital: " +capital +"\n";
	}
	
	public String entityType() {
		return "This entity is a country!";
	}
}
