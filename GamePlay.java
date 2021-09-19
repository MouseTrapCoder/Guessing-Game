package gameCode;
import java.util.*;
public class GamePlay {
	
	/*
	 * Pranav Battini
	 * 9|18|2021
	 * This class the variables and methods of the GamePlay object, whose constructor runs the main functionality of the game
	 */
	private int minVal;
	private int maxVal;
	private static int gamesPlayed = 0;
	private static int p1Wins = 0;
	private static int p2Wins = 0;
	private int correctValue;
	private int attemptsAllowed;
	
	//two player game
	public GamePlay(Player p1, Player p2) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Round: " + (gamesPlayed + 1));
		System.out.println();
		System.out.println("What range of numbers do you want to guess between (inclusive)?");
		System.out.println("Enter in format: \"minimum number to maximum number\"");
		minVal = kb.nextInt();
		kb.next();
		maxVal = kb.nextInt();
		System.out.println("WELCOME CHILDREN!");
		System.out.println("TODAY WE WILL BE PLAYING A GUESSING GAME!!!");
		System.out.println("PLAYERS WILL GUESS A NUMBER FROM " + minVal + " to " + maxVal +  " INCLUSIVE!!!");
		System.out.println("THE PLAYER WHO GUESSES THE NUMBER WITH THE LEAST ATTEMPTS OR THE PLAYER WHO GUESSES CORRECTLY WITHIN THE ALLOTED ATTEMPTS WINS!!!");
		System.out.println();
		System.out.println();
		System.out.println("How many attempts shall each player have?");
		attemptsAllowed = kb.nextInt();
		//tells whether to print "chance" or "chances" as per singular vs plural logic in line 44
		String chanceS = "";
		if(attemptsAllowed == 1) {
			chanceS = " chance";
		} else {
			chanceS = " chances";
		}
		
		System.out.println("You will each have " + attemptsAllowed + chanceS + " to guess the correct number." );
		System.out.println();
		correctValue = (int) (Math.random() * ((maxVal - minVal) + 1)) + minVal;
		System.out.println("The MouseTrap has chosen the correct number for " + p1.Name() + " to guess...");
		System.out.println();
		play(p1);
		System.out.println();
		correctValue = (int) (Math.random() * ((maxVal - minVal))) + minVal;
		System.out.println("The MouseTrap has chosen the correct number for " + p2.Name() + " to guess...");
		System.out.println();
		play(p2);
		System.out.println();
		selectWinner(p1, p2);
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println();
	}
	
	public GamePlay(Player p1) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Round: " + (gamesPlayed + 1));
		System.out.println();
		System.out.println("What range of numbers do you want to guess between (inclusive)?");
		System.out.println("Enter in format: \"minimum number to maximum number\"");
		minVal = kb.nextInt();
		kb.next();
		maxVal = kb.nextInt();
		System.out.println("WELCOME CHILDREN!");
		System.out.println("TODAY WE WILL BE PLAYING A GUESSING GAME!!!");
		System.out.println("PLAYERS WILL GUESS A NUMBER FROM " + minVal + " to " + maxVal +  " INCLUSIVE!!!");
		System.out.println("TO WIN THE GAME, YOU MUST GUESS THE CORRECT NUMBER WITHIN THE ALLOTED ATTEMPTS!!!");
		System.out.println();
		System.out.println();
		System.out.println("How many attempts will you give yourself " + "(" + p1.Name() + ")" + " to guess the correct number?");
		attemptsAllowed = kb.nextInt();
		//tells whether to print "chance" or "chances" as per singular vs plural logic in line 86
		String chanceS = "";
		if(attemptsAllowed == 1) {
			chanceS = " chance";
		} else {
			chanceS = " chances";
		}
		System.out.println("You will have " + attemptsAllowed + chanceS + " to guess the correct number." );
		System.out.println();
		correctValue = (int) (Math.random() * ((maxVal - minVal) + 1)) + minVal;
		System.out.println("The MouseTrap has chosen the correct number for " + p1.Name() + " to guess...");
		System.out.println();
		play(p1);
		System.out.println();
		selectWinner(p1);
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println();
	}
	
	//player turn
	public void play(Player p1) {
		while(p1.getAttempts() < attemptsAllowed) {
			System.out.println(p1.Name() + ", make a guess!");
			p1.makeGuess();
			p1.useAttempts();
			p1.printAttemptInfo();
			
			int attemptsLeft = attemptsAllowed - p1.getAttempts();
			
			//tells whether to print "attempt" or "attempts" per singular vs plural logic in line 117
			String attemptS = "";
			if(attemptsLeft == 1) {
				attemptS = " attempt";
			} else {
				attemptS = " attempts";
			}
			
			System.out.println("You have " + attemptsLeft + attemptS + " left...");
			System.out.println();
			p1.setIsGuessCorrect(correctValue);
			if(p1.getIsGuessCorrect()) {
				break;
			}
			}
		if(p1.getIsGuessCorrect()) {
			System.out.println(p1.Name() + " guessed the value correctly in " + p1.getAttempts() + " attempts!");
			System.out.println("The correct number was " + correctValue + "!");
		} else {
			System.out.println(p1.Name() + " was not able to guess the correct number in the alloted attempts... ");
			System.out.println("The correct number was " + correctValue + "!");
		}
		
	
	}
	
	public void selectWinner(Player p1) {
		if(p1.getIsGuessCorrect()) {
			System.out.println(p1.Name() + " has won this round!!!");
			p1Wins++;
		} else {
			System.out.println("Better luck next round...");
		}
		gamesPlayed++;
		p1.resetAttempts();
		p1.resetIsGuessCorrect();
	}
	
	public void selectWinner(Player p1, Player p2) {
		//both guess correctly
		if(p1.getIsGuessCorrect() && p2.getIsGuessCorrect()) {
			if(p1.getAttempts() > p2.getAttempts()) {
				//player 2 uses less attempts = player 2 win
				System.out.println(p2.Name() + " has won this round, guessing the correct number in the least attempts!!!");
				p2Wins++;
			} else if(p1.getAttempts() < p2.getAttempts()) {
				//player 1 uses less attempts = player 1 win
				System.out.println(p1.Name() + " has won this round, guessing the correct number in the least attempts!!!");
				p1Wins++;
			}
		 }
			//player 2 win player 1 guess wrong
			if(!p1.getIsGuessCorrect()) {
				if(p2.getIsGuessCorrect()) {
					System.out.println(p2.Name() + " has won this round!!!");
					p2Wins++;
				} else if (!p2.getIsGuessCorrect()) {
					System.out.println("This round is a tie...");
				}
			}
			//player 1 win player 2 guess wrong
			if(!p2.getIsGuessCorrect()) {
				if(p1.getIsGuessCorrect()) {
					System.out.println(p1.Name() + " has won this round!!!");
					p1Wins++;
				}
			}
			
			gamesPlayed++;
			//resets variables for next round
			p1.resetAttempts();
			p2.resetAttempts();
			p1.resetIsGuessCorrect();
			p2.resetIsGuessCorrect();
	}
	
	public static int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public static int getP1Wins() {
		return p1Wins;
	}
	
	public static int getP2Wins() {
		return p2Wins;
	}
	
	

}
