//Bradley Stephen
//20207842
//April 10th 2023
package com.example.guessmaster3;

import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.DialogInterface;



public class GuessMaster extends AppCompatActivity {
	//Setting up access to layout
	private TextView entityName;
	private TextView ticketsum;
	private Button guessButton;
	private EditText userIn;
	private Button btnclearContent;
	private String user_input;
	private ImageView entityImage;
	private String answer;


	private int entityId;
	private String entName;
	private Entity currentEntity;

	//used to store all entities and ticket info
	private int numOfEntities;
	private final Entity[] entities;
	private int ticketsWon = 0;
	private int totaltik = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guess_activity);


		guessButton = (Button) findViewById(R.id.btnGuess);
		userIn = (EditText) findViewById(R.id.guessinput);
		ticketsum = (TextView) findViewById(R.id.ticket);
		entityName = (TextView) findViewById(R.id.entityName);
		btnclearContent = (Button) findViewById(R.id.btnClear);
		entityImage = (ImageView) findViewById(R.id.entityImage);


		Politician jTrudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);////
		Singer cDion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);////
		Person myCreator = new Person("My Creator", new Date("September", 1, 2000), "Female", 1);////
		Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.", 0.1);////


		new GuessMaster();
		//Adding entities
		addEntity(jTrudeau);
		addEntity(cDion);
		addEntity(myCreator);
		addEntity(usa);

		changeEntity();
		welcomeToGame(currentEntity);


		btnclearContent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				changeEntity();
			}
		});


		guessButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				playGame(currentEntity);
			}
		});


	}

	//Changes current entity
	public void changeEntity() {
		userIn.getText().clear();
		entityId = genRandomentityId();
		Entity entity = entities[entityId];
		entName = entity.getName();
		entityName.setText(entName);
		ImageSetter();
		currentEntity = entity;
	}


	public void ImageSetter() {
		String name = entName;
		switch (name) {
			case "Justin Trudeau":
				entityImage.setImageResource(R.drawable.trudeau);
				break;
			case "Celine Dion":
				entityImage.setImageResource(R.drawable.celi);
				break;
			case "My Creator":
				entityImage.setImageResource(R.drawable.check);
				break;
			case "United States":
				entityImage.setImageResource(R.drawable.flag);
				break;
		}
	}

	//provides welcome message to game
	public void welcomeToGame(Entity entity) {
		AlertDialog.Builder welcomealert = new AlertDialog.Builder(GuessMaster.this);
		welcomealert.setTitle("GuessMaster V.3 !!!!!");

		welcomealert.setCancelable(false);
		welcomealert.setNegativeButton("START", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getBaseContext(), "Starting", Toast.LENGTH_SHORT).show();
			}
		});
		welcomealert.show();
	}


	public GuessMaster() {
		numOfEntities = 0;
		entities = new Entity[10];
		totaltik = 0;
	}


	public void addEntity(Entity entity) {

		entities[numOfEntities++] = entity;
	}


	public void playGame(int entityId) {
		Entity entity = entities[entityId];
		playGame(entity);
	}


	public void playGame(Entity entity) {
		//Takes in user input from userIn editText
		entityName.setText(entity.getName());
		answer = userIn.getText().toString();
		answer = answer.replace("\n", "").replace("\r","");
		Date date = new Date(answer);


		if (date.precedes(entity.getBorn())) {
			//Alert Dialog for early guess
			AlertDialog.Builder alert = new AlertDialog.Builder(GuessMaster.this);
			alert.setTitle("Incorrect");
			alert.setMessage("Try a later date.");
			alert.setNegativeButton("Ok", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					dialogInterface.cancel();
				}
			});
			alert.show();
		} else if (entity.getBorn().precedes(date)) {
			//Alert Dialog for late guess
			AlertDialog.Builder alert = new AlertDialog.Builder(GuessMaster.this);
			alert.setTitle("Incorrect");
			alert.setMessage("Try an earlier date.");
			alert.setNegativeButton("Ok", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					dialogInterface.cancel();
				}
			});
			alert.show();
		} else { //In case of correct guess
			//Update tickets won
			ticketsWon = entity.getAwardedTicketNumber();
			totaltik += ticketsWon;
			String total = (new Integer(totaltik)).toString();

			//AlertDialog for if you had a correct guess
			AlertDialog.Builder alert = new AlertDialog.Builder(GuessMaster.this);
			alert.setTitle("You won");
			alert.setMessage("BINGO! \n" );
			alert.setCancelable(false);
			alert.setNegativeButton("Continue", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					Toast.makeText(getBaseContext(), "You got" + total, Toast.LENGTH_SHORT).show();
					continueGame(); //Changes entity
				}
			});
			ticketsum.setText("Total Tickets" + total);
			alert.show();
		}
	}

	public void continueGame(){ //Changes current entity and clears userIn
		userIn.getText().clear();
		changeEntity();
	}


	public void playGame() {
		int entityId = genRandomentityId();
		playGame(entityId);
	}


	public int genRandomentityId() {
		Random randomNumber = new Random();
		return randomNumber.nextInt(numOfEntities);
	}

}
