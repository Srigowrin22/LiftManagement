package LiftManagement.manage;

import java.util.Scanner;

import LiftManagement.Datalayer.LiftDatalayer;

public class ManageView {
	private ManageModel manageModel;

	public static Scanner sc = new Scanner(System.in);

	public ManageView() {
		manageModel = new ManageModel(this);
	}

	public void start() {
		System.out.println("Welcome");
		while (true) {
			int curr = 0;
			int dest = 0;
			String name = "";
			System.out.println("Enter your choice: ");
			System.out.println("1.Display Lifts|| 2.Insert Lift || 3.Set positions || 4.Assign lift with currentpos");
			System.out.println("5.Choose Lift with direction || 6. Restrict access || 7.Least Stops || 8.Capacity || 9.Block Lift ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				boolean b = LiftDatalayer.getInstance().displayLift();
				if (b)
					showAlert("Empty! InsertLifts");
				break;

			case 2:
				init();
				return;

			case 3:
				sc.nextLine();
				System.out.println("Enter the lift name: ");
				name = sc.nextLine();
				System.out.println("Enter the position: ");
				int pos = sc.nextInt();
				manageModel.setPos(name, pos);
				break;

			case 4:
				System.out.println("Current Floor: ");
				curr = sc.nextInt();
				System.out.println("Destination floor");
				dest = sc.nextInt();
				manageModel.assignCurrent(curr, dest);
				LiftDatalayer.getInstance().displayLift();
				break;

			case 5:
				System.out.println("Current Floor: ");
				curr = sc.nextInt();
				System.out.println("Destination floor");
				dest = sc.nextInt();
				manageModel.assignDirect(curr, dest);
				LiftDatalayer.getInstance().displayLift();
				break;

			case 6:
				sc.nextLine();
				System.out.println("Enter the lift name:");
				name = sc.nextLine();
				System.out.println("Restrict access number (from - to): ");
				int from = sc.nextInt();
				int to = sc.nextInt();
				manageModel.restrict(name, from, to);
				LiftDatalayer.getInstance().displayLift();
				break;

			case 7:
				System.out.println("Current Floor: ");
				curr = sc.nextInt();
				System.out.println("Destination floor");
				dest = sc.nextInt();
				manageModel.leastStops(curr, dest);
				break;

			case 8:
				sc.nextLine();
				System.out.println("Enter the lift name: ");
				name = sc.nextLine();
				System.out.println("Set the capacity: ");
				int capacity = sc.nextInt();
				manageModel.setCapacity(name, capacity);	
				break;
				
			case 9:
				sc.nextLine();
				System.out.println("Enter the lift name to block: ");
				name = sc.nextLine();
				manageModel.blockLift(name);
				break;
				
			default:
				System.out.println("Enter valid choice");
			}
		}
	}

	public void init() {
		System.out.println("------Lift SETUP------");
		System.out.println("Enter the number of lifts: ");
		int number = sc.nextInt();
		manageModel.setLift(number);
		start();
	}

	public void showAlert(String alert) {
		System.out.println(alert);
	}
}
