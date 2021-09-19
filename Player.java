package gameCode;

import java.util.Scanner;

public class Player {
	
	/*
	 * Pranav Battini
	 * 9|18|2021
	 * This class contains all of the methods and variables for Player object
	 */
	
	private String name;
	private int attempts;
	private int guess;
	private boolean isGuessCorrect;
	
	public Player(String name) {
		this.name = name;
		attempts = 0;
		guess = 0;
		isGuessCorrect = false;
	}
	
	public String Name() {
		return name;
	}
	
	public void resetAttempts() {
		attempts  = 0;
	}
	
	public int getAttempts() {
		return attempts;
	}
	
	public void useAttempts() {
		attempts++;
	}
	
	public int getGuess() {
		return guess;
	}

	
	public void makeGuess() {
		Scanner kb = new Scanner(System.in);
		guess = kb.nextInt();
	}
	
	public void printAttemptInfo() {
		System.out.println("Attempt: " + attempts + ", Guess: " + guess);
	}
	
	public void resetIsGuessCorrect() {
		isGuessCorrect = false;
	}
	public void setIsGuessCorrect(int correctValue) {
		if(guess == correctValue) {
			isGuessCorrect = true;
		} else {
			isGuessCorrect = false;
		}
	}
	
	public boolean getIsGuessCorrect() {
		return isGuessCorrect;
	}
	
		

}
