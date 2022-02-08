package ui;

import java.util.Scanner;

import bl.Request;
import models.Reimbursement;
import models.Status;

public class MainMenu {
	
	private Scanner myScanner;
	private Request request;
	
	public MainMenu(Scanner myScanner, Request request) {
		this.myScanner = myScanner;
		this.request = request;
	}
	
	public void start() {
		
		boolean keepGoing = true;
		
		do {
			System.out.println("Welcome! What would you like to do?");
			System.out.println("[0] Create a reimbursement request");
			System.out.println("[1] View reimbursement requests");
			System.out.println("[2] View a specific reimbursement request");
			System.out.println("[3] Accept or reject requests");
			System.out.println("[x] Exit");
			
			String userInput = myScanner.nextLine();
			
			switch (userInput) {
			case "0":
				System.out.println("Let's create an issue...");
				createRequest();
				break;
				
			case "1":
				System.out.println("Viewing reimbursement request(s)...");
				getRequests();
				break;
				
			case "2":
				getSpecificRequest();
				break;
				
			case "3":
				addStatus();
				break;
			
			case "x":
				System.out.println("Goodbye");
				keepGoing = false;
				break;
				
			default:
				System.out.println("Incorrect input, please choose again");
				break;
			}
		} while(keepGoing);
	}	
	
	
	private void addStatus() {
		System.out.println("Please enter the reimbursement request you want to accept/reject: ");
		String userInput = myScanner.nextLine();
		
		Status newStatus = new Status(userInput);
		
		try {
			newStatus.setReimbursementID(Integer.parseInt(userInput));
			request.addStatus(newStatus);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getSpecificRequest() {
		System.out.println("Enter the id of the issue you'd like to view the solutions for: ");
		String stringId = myScanner.nextLine();

		Reimbursement foundIssue;
		try {
			foundIssue = request.getReimbursementID(Integer.parseInt(stringId));
			System.out.println(foundIssue);
			for (Status solution : foundIssue.getStatuses()) {
				System.out.println(solution);
			}
			getStatusSubMenu();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			System.out.println("Please only enter numerics");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("No such issue found, try another id");
		}
	}
	
	private void getStatusSubMenu() {
		System.out.println("[0] Accept");
		System.out.println("[1] Reject");
		String userInput = myScanner.nextLine();
		switch(userInput) {
		case "0":
			acceptStatus();
			break;
		case "1":
			rejectStatus();
			break;
		default:
			break;
		}
	}
	
	private void acceptStatus() {
		System.out.println("Do you want to accept this reimbursement request?");
		String userInput = myScanner.nextLine();
		request.acceptStatus(Integer.parseInt(userInput));
	}
	
	private void rejectStatus() {
		System.out.println("Do you want to reject this reimbursement request?");
		String userInput = myScanner.nextLine();
		request.rejectStatus(Integer.parseInt(userInput));
	}
	
	
	private void getRequests() {
		for (Reimbursement reimbursement : request.getReimbursements()) {
			System.out.println(reimbursement);
		}
	}

	private void createRequest() {
		System.out.println("Please enter the type of reimbursement request");
		String type = myScanner.nextLine();
		
		System.out.println("Please enter the amount of the reimbursement request");
		String amt = myScanner.nextLine();
		
		System.out.println("Please enter the description of the reimbursement request");
		String description = myScanner.nextLine();
		
		Reimbursement newReimbursement = new Reimbursement(type, description, Integer.parseInt(amt));
		
		
	}
	
}
