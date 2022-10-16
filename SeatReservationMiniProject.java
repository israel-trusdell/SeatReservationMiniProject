import java.util.Scanner;
import java.util.ArrayList;

public class SeatReservationMiniProject {

	public static void main(String[] args) {

		// Seat grid
		char[][] grid = { { 'A', 'B', 'C', 'D', 'E', }, { 'F', 'G', 'H', 'I', 'J', }, { 'K', 'L', 'M', 'O', 'P', },
				{ 'Q', 'R', 'S', 'T', 'U', }, { 'V', 'W', 'X', 'Y', 'Z', } };

		ArrayList<Character> seatList = new ArrayList<Character>();
		ArrayList<String> nameList = new ArrayList<String>();

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("Would you like to reserve a seat? \nYes or No\n");
			String x = input.nextLine();
			String resName;
			if (x.matches("N|n|NO|no")) {
				System.out.println("Alright have a nice day");
				break;
			} else if (x.matches("Y|y|YES|yes")) {
				System.out.println("Ok let me help you with that. \nPlease enter you name.\n");
				resName = input.nextLine();
				System.out.println("Here are the avalible seats.\n");
			} else {
				System.out.println("Please Enter a VALID response.\n");
				continue;
			} // end if

			while (true) {
				// print seats
				printGrid(grid);
				System.out.println("What seat would you like to reserve? ");
				String c = input.nextLine();

				if (!c.matches("[A-Z]{1}")) {
					System.out.println("Please Enter a VALID seat.\n");
					continue;
				} // end if
				char resSeat = c.charAt(0);// cast string to char

				if (findSeat(grid, resSeat)) {
					System.out.println("That seat is avalible.\n");
					// reserving seat
					reserveSeat(grid, resSeat);
					// adding seat and name to reservation list
					seatList.add(resSeat);
					nameList.add(resName);

				} else {
					System.out.println("This seat has already been booked.");
					printResList(seatList, nameList);
					continue;// end if
				}
				// print reservations
				printResList(seatList, nameList);
				break;
			} // end while
		} // end while
		input.close();

	}// end main

	public static void inputCheck(String a) {
		if (a.matches("[A-Z]{1}")) {

		} else {

		}
	}

	public static void printResList(ArrayList<Character> seatList, ArrayList<String> nameList) {
		System.out.println("-----------------------");
		System.out.println("Reservation List");
		System.out.println("-----------------------");
		System.out.println("Seat     Name");
		for (int i = 0; i < seatList.size(); i++) {
			System.out.println(seatList.get(i) + "        " + nameList.get(i));
		} // end for
		System.out.println("-----------------------");
	}// end printResList

	public static char[][] reserveSeat(char[][] arr, char target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == target) {
					System.out.println("You have reserved seat: " + arr[i][j]);
					arr[i][j] = '#';

					System.out.println("Here is the updated view.");
					printGrid(arr);

				} // end if
			} // end for
		} // end for
		return arr;
	}// end findSeat

	static boolean findSeat(char[][] arr, char target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == target) {
					return true;
				} // end if
			} // end for
		} // end for
		return false;
	}// end findSeat

	// print grid
	public static void printGrid(char[][] arr) {
		System.out.println("=======================");
		System.out.println("         SEATS         ");
		System.out.println("=======================");
		for (char[] a : arr) {
			System.out.print(" | ");
			for (char b : a) {
				System.out.print(b + " | ");
			} // end for
			System.out.println();
		} // end for
		System.out.println("-----------------------");
	}// end printGrid
}
