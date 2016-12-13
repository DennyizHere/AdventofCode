import java.util.Scanner;

public class WalkMapPart2 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine();
		String[] commands;
		int direction = 0; // 0 is N, 1 is E, 2 is S, and 3 is W
		int steps;
		boolean[][] coordinates = new boolean[900][900];
		int coordX = 450;
		int coordY = 450;
		
		coordinates[coordX][coordY] = true;
		commands = input.split(", "); // Makes the command list series of commands without commas
		
		outerloop:
		for (int i = 0; i < commands.length; i++) {
			String[] partsofCom = commands[i].split("(?<=\\D)(?=\\d)"); // Separates the turn from the steps
			
			// Turns the direction
			if (partsofCom[0].equalsIgnoreCase("R")) direction++;
			else if (partsofCom[0].equalsIgnoreCase("L")) direction--;
			
			// Only 4 directions, so readjusts if necessary
			if (direction == -1) direction = 3;
			
			if (direction == 4) direction = 0;
			
			// Takes the integer in the command and adds it to the number of steps made in that direction
			steps = Integer.parseInt(partsofCom[1]);
			
			// Marks all the spots on the map that you have been, checks if you have been there before
			for (int q = 0; q < steps; q++) {
			
			if (direction == 0) coordY = coordY + 1;
			if (direction == 1) coordX = coordX + 1;
			if (direction == 2) coordY = coordY - 1;
			if (direction == 3) coordX = coordX - 1;
			
			if (coordinates[coordX][coordY] == true) break outerloop;
			
			coordinates[coordX][coordY] = true;
			
			}
		}		

		// Prints out total steps made (solution)		
		System.out.println("Distance from first point of intersection: " + (Math.abs(450 - coordX) + Math.abs(450 - coordY)));

	}
}

