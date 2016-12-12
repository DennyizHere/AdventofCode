import java.util.*;

public class WalkMapPart1 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine();
		String[] commands;
		int direction = 0; // 0 is N, 1 is E, 2 is S, and 3 is W
		int[] route = new int[4];
		int steps;
		int north;
		int east;
		int south;
		int west;
		int x = 0;
		int y = 0;
		
		commands = input.split(", "); // Makes the command list series of commands without commas
		
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
			route[direction] += steps;
			
		}
		
		// Makes the variables easy to read and work with
		north = route[0];
		east = route[1];
		south = route[2];
		west = route[3];
		
		// Prints out steps made in a direction
		if (north > south) {
			y = north - south;
			System.out.println("North these steps: " + y);
		}
		else if (south > north) {
			y = south - north;
			System.out.println("South these steps: " + y);
		}
		
		if (west > east) {
			x = west - east;
			System.out.println("West these steps: " + x);
		}
		else if (east > west) {
			x = east - west;
			System.out.println("East these steps: " + x);
		}
		
		// Prints out total steps made (solution)
		System.out.print("Total steps taken: " + (x + y));
		
	}
}
