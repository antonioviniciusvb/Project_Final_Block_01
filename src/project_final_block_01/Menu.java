package project_final_block_01;

import java.util.Optional;

import model.Console;
import model.Game;
import model.Product;
import model.controller.ProductController;
import project_final_block_01.util.Colors;
import project_final_block_01.util.Converter;
import project_final_block_01.util.Input;
import project_final_block_01.util.OutPut;

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

	public static ProductController productsController = new ProductController();

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

			case 1 -> productsController.register(createProduct(0, 0));

			case 2 -> productsController.listAll();

			case 3 -> productsController.findById(Input.getInteger("Product Id to search:"));

			case 4 -> {

				var account = productsController.findProduct(Input.getInteger("Enter Product Id to update:"));

				if (account.isPresent())
					productsController
							.update(Optional.of(createProduct(account.get().getId(), account.get().getType())));
				else
					OutPut.printFailed(productsController.errorOperation);
			}

			case 5 -> productsController.delete(Input.getInteger("Enter Product Id to delete:"));

			case 6 -> System.out.println("to do - Buy");

			}

			Input.systemPause();

		} while (continueLoop(option));
	}

	private static Product createProduct(int productId, int productType) {

		int id, type, joystick;
		String name, platform, releaseYear, developer, model;
		double price = 0.0d;
		boolean cdplayer;

		id = defineProductId(productId);
		type = defineProductType(productType);

		name = Input.getString("Enter the Name:");

		platform = Input.getString("Enter the Plataform:");

		releaseYear = Input.getString("Enter the Release Year:");

		price = Input.getDouble("Enter the Product price:");

		if (type == 0)
			type = Input.getInteger("1- Game\n2- Console\nChoose Product option:");

		if (type == 1) {

			developer = Input.getString("Enter the developer:");
			return new Game(id, name, type, price, platform, Converter.stringToLocalDate(releaseYear), developer);
		} else {

			model = Input.getString("Enter with the model:");
			joystick = Input.getInteger("Enter with Quantity Joystick:");
			cdplayer = Input.getString("Has a CD player: S/N:").toLowerCase() == "S" ? true : false;

			return new Console(id, name, type, price, platform, Converter.stringToLocalDate(releaseYear), joystick,
					cdplayer, model);

		}
	}

	private static int defineProductType(int productType) {
		return productType == 1 || productType == 2 ? productType : 0;
	}

	private static int defineProductId(int productId) {
		return productId > 0 ? productId : productsController.generateId();
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
