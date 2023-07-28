// Jared Baker
// NID ja907583
// COP 3503C - Fall 2022
// Assignment 3 - Sneaky Knights

import java.util.*;
import java.io.*;

public class SneakyKnights
{
	public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardSize)
	{
		// the number of knights in the arrayList
		int numKnights = coordinateStrings.size();

		// creates a hashSet to store all the cordinates of the knights
		HashSet<List<Integer>> boardKnights = new HashSet<> (numKnights);

		// Loops through all the knights
		// uses the same code of getting the X and Y coordinate from SneakyKnights
		for (int i = 0; i < numKnights; i++)
		{
			// base for the number conversion
			int nBase = 1;

			// base for the letter conversion
			int lBase = 1;

			// count for traversing the cordinate from right -> left
			int travers = 1;

			// X and Y cordinate of the queen piece
			int x = 0;
			int y = 0;

			// Length of the cordinate string
			int corLength = coordinateStrings.get(i).length();

			// Loops through the coordinate and calculates the y - value
			while (Character.isDigit(coordinateStrings.get(i).charAt(corLength - travers)))
			{
				y += ((coordinateStrings.get(i).charAt(corLength - travers)) - '1' + 1) * nBase;
				nBase *= 10;
				travers ++;
			}

			// Loops through the coordinate and calculates the x - Value
			while (travers <= corLength &&
						Character.isLetter(coordinateStrings.get(i).charAt(corLength - travers)))
			{
				x += ((coordinateStrings.get(i).charAt(corLength - travers)) - 'a' + 1) * lBase;
				lBase *= 26;
				travers ++;
			}

			// Stops the out of bounds error if the queen is on the edge of the board
			// for the x - axis and y - axis arrays
			x -= 1;
			y -= 1;

			// adds the cordinate the knight is at to the HashSet
			boardKnights.add(List.of(x,y));

			// checks all eight locations that the knight attacks to see if it it already occupied
			// checks the area to the right two and up one
			if (boardKnights.contains(List.of(x + 2,y + 1)))
			{
				return false;
			}

			// checks the area to the right two and down one
			if (boardKnights.contains(List.of(x + 2,y - 1)))
			{
				return false;
			}

			// checks the area right one and down two
			if (boardKnights.contains(List.of(x + 1,y - 2)))
			{
				return false;
			}

			// checks the area left one and down two
			if (boardKnights.contains(List.of(x - 1,y - 2)))
			{
				return false;
			}

			// checks the area left two and up one
			if (boardKnights.contains(List.of(x - 2,y + 1)))
			{
				return false;
			}

			// checks the area left two and down one
			if (boardKnights.contains(List.of(x - 2,y - 1)))
			{
				return false;
			}

			// checks the area right one and up two
			if (boardKnights.contains(List.of(x + 1,y + 2)))
			{
				return false;
			}

			// checks the area left one and up two
			if (boardKnights.contains(List.of(x - 1,y + 2)))
			{
				return false;
			}
		}
		// returns true if it loops through all the nights and no knights attack each other
		return true;
	}

	// difficultyRating of the Assignment
	public static double difficultyRating()
	{
		return 5.0;
	}

	// time spent on the assignment
	public static double hoursSpent()
	{
		return 50.0;
	}
}
