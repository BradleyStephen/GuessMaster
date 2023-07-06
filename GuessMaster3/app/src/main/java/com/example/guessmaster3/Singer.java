package com.example.guessmaster3;//Bradley Stephen
//20207842
//April 10th 2023

public class Singer extends Person {
	private final String debutAlbum;
	private final Date debutAlbumReleaseDate;
	
	public Singer(String name, Date birthDate, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
		super(name, birthDate, gender, difficulty);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate); 
	}
	
	public Singer(Singer entity) {
		super(entity.getName(), entity.getBorn(), ((Person) entity).getGender(), entity.getDifficulty());
		this.debutAlbum = entity.getDebutAlbum();
		this.debutAlbumReleaseDate = entity.getDebutAlbumDate();
	}
	
	public Singer clone(Singer entity) {
		Singer s1 = new Singer(entity);
		return s1;
	}	
	
	public String getDebutAlbum() {
		return debutAlbum;
	}
	
	public Date getDebutAlbumDate() {
		return debutAlbumReleaseDate;
	}
	
	public String toString() {
		return super.toString() + "Debut Album: " +debutAlbum +"\n" + "Release Date: " + debutAlbumReleaseDate.toString() + "\n";
	}
	
	public String entityType() {
		return "This entity is a Singer!";
	}
}
