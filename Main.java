package portContainer;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	private static ArrayDeque<Container> container = new ArrayDeque<>();
	private static ArrayDeque<Ship> ship = new ArrayDeque<>();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;
		
		do {
			printMenu();
			choice = getChoice();
			
			switch (choice) {
			case 1:
				storeContainer();
				break;
			case 2:
				viewContainer();
				break;
			case 3:
				registerShip();
				break;
			case 4:
				viewShips();
				break;
			case 5:
				loadNextShip();
				break;
			case 0:
				System.out.println("Exciting... Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		while(choice != 0);
	}
	
	private static void printMenu() {
		System.out.println("\n=== Port Container Management System ===");
		System.out.println("[1] Store container");
		System.out.println("[2] View port containers");
		System.out.println("[3] Register arriving ship");
		System.out.println("[4] View waiting ships");
		System.out.println("[5] Load next ship");
		System.out.println("[0] Exit");
		System.out.print("Choose an option: ");
		
	}
	
	private static int getChoice() {
		try {
			return Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	private static void storeContainer() {
		System.out.print("\nEnter container ID: ");
		String id = scan.nextLine();
		System.out.print("Enter description: ");
		String desc = scan.nextLine();
		System.out.print("Enter weight (kg): ");
		int weight = Integer.parseInt(scan.nextLine());
		
		Container con = new Container(id, desc, weight);
		container.push(con);
		System.out.println("\nStored: " + con);
		
	}
	
	private static void viewContainer() {
		if (container.isEmpty()) {
			System.out.println("\nNo containers in the port.");
			return;
		}
		
		System.out.println("\nTOP →");
		for (Container con : container) {
			System.out.println(con);
		}
		System.out.println("← BOTTOM");
	}
	
	private static void registerShip() {
		System.out.print("\nEnter ship name: ");
		String name = scan.nextLine();
		System.out.print("Enter captain name: ");
		String captain = scan.nextLine();
		
		Ship s = new Ship(name, captain);
		ship.add(s);
		System.out.println("\nRegistered: " + s);
	}
	
	private static void viewShips() {
		if(ship.isEmpty()) {
			System.out.println("\nNo ships waiting.");
			return;
		}
		System.out.println("\nFRONT →");
		for (Ship s : ship) {
			System.out.println(s);
		}
		System.out.println("← REAR");
	}
	
	private static void loadNextShip() {
		if(container.isEmpty() || ship.isEmpty()) {
			System.out.println("\nCannot load. Either no containers or no ships available.");
			return;
		}
		
		Container con = container.pop();
		Ship s = ship.poll();
		
		System.out.println("\nLoaded: " + con + " → " + s);
		System.out.println("Remaining containers: " + container.size());
		System.out.println("Remaining ships waiting: " + ship.size());
	}

}
