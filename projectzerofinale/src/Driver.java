
import java.util.Scanner;

import bl.Request;
import dl.DBStorage;
import dl.RequestDAO;
import dl.StatusDAO;
import ui.MainMenu;

public class Driver {

	public static void main(String[] args) {
		
		// Start application here
		MainMenu menu = new MainMenu(new Scanner(System.in), new Request(new DBStorage(new RequestDAO(), new StatusDAO())));
		menu.start();
	}
}
