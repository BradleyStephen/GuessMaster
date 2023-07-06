package com.example.guessmaster3;//Bradley Stephen
//20207842
//April 10th 2023

public class Person extends Entity{
	private final String gender;
	
	public Person(String name, Date birthDate, String gender, double difficulty) {
		super(name, birthDate, difficulty);
		this.gender = gender;
	}
	
	public Person(Person entity) {
		super(entity.getName(), entity.getBorn(), entity.getDifficulty());
		this.gender = entity.getGender();
	}

	public Entity clone(Entity entity) {
		Person p = new Person((Person) entity);
		return p;
	}	
	
	public String getGender() {
		return gender;
	}

	public String toString() {
		return super.toString() + "Gender: " +gender +"\n";
	}
	
	public String entityType() {
		return "This entity is a Person!";
	}
}
