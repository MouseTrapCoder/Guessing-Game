package gameCode;
import java.util.*;
public class RunGame {

	/*
	 * Pranav Battini
	 * 9|18|2021
	 * This class initializes Player and GamePlay objects and runs them in the main method as intended
	 */
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("GUESSING GAME");
		System.out.println("_____________________");
		System.out.println();
		System.out.println("Do you want to play with 1 player or 2 players?");
		int playerNum = kb.nextInt();
		if(playerNum == 2) {
			//two player game
			System.out.println("How many rounds of this guessing game do you want to play?");
			int match = kb.nextInt();
			kb.nextLine();
			System.out.println();
			System.out.println("Enter player 1 name: ");
			String p1Name = kb.nextLine();
			System.out.println("Enter player 2 name: ");
			String p2Name = kb.nextLine();
			//initialize players
			Player p1 = new Player(p1Name);
			Player p2 = new Player(p2Name);
		
			//plays game for x number of matches
			for(int i = 0; i < match; i++) {
			GamePlay Guess = new GamePlay(p1, p2);
			}
		
			//gets overall wins for player 1 and player 2
			int p1Wins = GamePlay.getP1Wins();
			int p2Wins = GamePlay.getP2Wins();
		
			System.out.println();
		
			//chooses overall winner
			if(p1Wins > p2Wins) {
			System.out.println("Since " + p1.Name() + " has won more rounds, " + p1.Name() + " is the overall winner!!!");
			} else if (p1Wins < p2Wins) {
			System.out.println("Since " + p2.Name() + " has won more rounds, " + p2.Name() + " is the overall winner!!!");
			} else {
			System.out.println("Since " + p1.Name() + " and " + p2.Name() + " have both won an equal number of games, it is a TIE!!!");
			}
		
			System.out.println();
			System.out.println("Thanks for playing!!!");
		} else if (playerNum == 1) {
			//one player game
			System.out.println("How many rounds of this guessing game do you want to play?");
			int match = kb.nextInt();
			kb.nextLine();
			System.out.println();
			System.out.println("Enter player 1 (your) name: ");
			String p1Name = kb.nextLine();
			//initialize player
			Player p1 = new Player(p1Name);
			
			//plays game for x number of matches 
			for(int i = 0; i < match; i++) {
				GamePlay Guess = new GamePlay(p1);
			}
			System.out.println();
			System.out.print("You won " + GamePlay.getP1Wins() + " out of " + GamePlay.getGamesPlayed() + " rounds, ");
			if(GamePlay.getGamesPlayed() == GamePlay.getP1Wins()) {
				System.out.println("perfectly guessing the correct number all " + GamePlay.getGamesPlayed() + " rounds!!!");
			} else if (GamePlay.getP1Wins() == 0) {
				System.out.println("unfortunately never guessing the correct number all " + GamePlay.getGamesPlayed() + "rounds :(");
			} else if (GamePlay.getP1Wins() != 0 && GamePlay.getP1Wins() != GamePlay.getGamesPlayed()) {
				System.out.println("a satisfactory performance...");
			}
			System.out.println();
			System.out.println("Thanks for playing!!!");
		}
		
		// TODO Auto-generated method stub

	}

}
