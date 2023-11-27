package project_final_block_01;

import project_final_block_01.util.Colors;
import project_final_block_01.util.Input;

public class Menu {

	public static String optionsMenuMain = "o--------------------------------------------------o\n"
			+ "|-------- E-Commerce - Genesis 16-bit -------------|\n"
			+ "o--------------------------------------------------o\n"
			+ "|            1- Create Product                     |\n"
			+ "|            2- List Products                      |\n"
			+ "|            3- Find Products                      |\n"
			+ "|            4- Update Data of Product             |\n"
			+ "|            5- Delete Product                     |\n"
			+ "|            6- Buy Products                       |\n"
			+ "|--------------------------------------------------|\n"
			+ "|--------------------------------------------------|\n"
			+ "|            9- Exit                               |\n"
			+ "o--------------------------------------------------o\n"
			+ "| Select the desired option:                       |\n"
			+ "o--------------------------------------------------o";

	public static void main(String[] args) {

		showMenu();
		showAboutProgram();
	}

	private static void showMenu() {
		
		int option;

		do {

			showOptionsMain();
			option = Input.getInteger("");
			System.out.println();

			showOperation(option);

			switch (option) {

			case 1 -> System.out.println("to do - create");

			case 2 -> System.out.println("to do - List");

			case 3 -> System.out.println("to do - Find");

			case 4 -> System.out.println("to do - Update");

			case 5 -> System.out.println("to do - Delete");
			
			case 6 -> System.out.println("to do - Buy");

			}

			Input.systemPause();

		} while (continueLoop(option));
	}

	public static boolean continueLoop(int option) {
		return option != 9;
	}

	public static void showOperation(int operation) {

		var menu = optionsMenuMain.split("\n");

		System.out.println(Colors.theme + menu[0] + "\n" + menu[2 + operation] + "\n" + menu[2]);
	}

	public static void showOptionsMain() {
		System.out.println(Colors.theme + optionsMenuMain);
		System.out.printf(Colors.TEXT_RESET);
	}

	public static void showAboutProgram() {
		System.out.println(Colors.theme + "o-------------------------------------------------------------------o");
		System.out.println("| Project: E-Commerce - Genesis 16-bit                              |");
		System.out.println("| https://github.com/antonioviniciusvb/Project_Final_Block_01.git   |");
		System.out.println("| Developed by: Antonio Bandeira                                    |");
		System.out.println("| Generation Brasil - generation@generation.org                     |");
		System.out.println("o-------------------------------------------------------------------o");
	}
}
