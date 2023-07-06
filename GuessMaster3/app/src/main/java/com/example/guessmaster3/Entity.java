package com.example.guessmaster3;//Bradley Stephen
//20207842
//April 10th 2023

abstract class Entity {
	private final String name;
	private final Date born;
	private final double difficulty; //will be between 0 and 1
	
	public Entity(String name, Date birthDate, double difficulty) {
		this.name = name;
		this.born = new Date(birthDate);
		this.difficulty = difficulty;//no privacy leak
	}
	
	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born);
		this.difficulty = entity.getDifficulty(); //no privacy leak
	}
	
	public int getAwardedTicketNumber(){
		Integer ticketNum = (int) (difficulty*100);
		return ticketNum;
	} 
	
	abstract String entityType();
	
	abstract Entity clone(Entity entity);
	/*
	 * The clone function is defined but never used in any of my classes.
	 * 
	 * By marking all instance variables as final, and by not having any mutator methods,
	 * there are no privacy leaks.
	 * 
	 * This method of implementation was confirmed to be acceptable by the professor.
	 */
	
	public void welcomeMessage() {
		System.out.println("Welcome! Let's start the game! \n This entity is a " + entityType());
	}
	
	public void cloningMessage() {
		System.out.println("Congratulations! The detailed information of the entity you guessed is:\n" + toString());
	}

	public String getName() {
		return name;
	}

	public Date getBorn() {
		return new Date(born);
	}
	
	public String toString() {
		return "Name: "+name+"\n"+"Born at: "+born.toString()+"\n";
	}
	
	public double getDifficulty() {
		return difficulty;
	}
}
