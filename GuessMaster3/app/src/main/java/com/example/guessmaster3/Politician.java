package com.example.guessmaster3;//Bradley Stephen
//20207842
//April 10th 2023

public class Politician extends Person {
	private final String party;
	
	public Politician(String name, Date birthDate, String gender, String party, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.party = party;
	}
	
	public Politician(Politician entity) {
		super(entity.getName(), entity.getBorn(), ((Person) entity).getGender(), entity.getDifficulty());
		this.party = entity.getParty();
	}
	
	public Politician clone(Politician entity) {
		Politician p1 = new Politician(entity);
		return p1;
	}	
	
	public String getParty() {
		return party;
	}
	
	public String toString() {
		return super.toString() + "Party: " +party +"\n";
	}
	
	public String entityType() {
		return "This entity is a Politician!";
	}
}
