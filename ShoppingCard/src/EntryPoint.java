import java.util.Scanner;

public class EntryPoint {
	//public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RESET = "\"";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\"";
	//public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	private static Scanner scan;
	private static String[] commands;
	
	public static void main(String[] args) {
		init();	
	}

	private static void init() {
		Catalog catalog = new Catalog();
		ShoppingCart cart = new ShoppingCart();
		
		scan = new Scanner(System.in);
		
		System.out.println("Type \"help\" to see all comands");
		String rawInput;
		do {
			System.out.print("Enter command: ");
			rawInput = scan.nextLine().toLowerCase().trim().replaceAll(" +", " ");
	
			commands = rawInput.split(" ", -1);
			try {		
				switch(commands[0]) {
					case "show":						
							switch(commands[1]) {										
								case "catalog":								
										System.out.println(catalog.toString(commands[2]));
									break;
								case "cart":
										System.out.println(cart.toString(commands[2]));
									break;
							}						
						break;
					case "add":
							if(commands.length == 3) {			
								cart.addItem(catalog.getItem(commands[1]), Integer.parseInt(commands[2]));
							} else {
								cart.addItem(catalog.getItem(commands[1]), 1);
							}
						break;
					case "remove":
							if(commands.length == 3) {
								cart.removeItem(commands[1], Integer.parseInt(commands[2]));
							} else {
								cart.removeItem(commands[1]);
							}
						break;
					case "help":
							showHelp();
						break;
					case "clear":
							cart.clear();
						break;
					default:
						showErrorMessage();
						break;
				
				}
			
			} catch (ArrayIndexOutOfBoundsException e) {
				showErrorMessage();
		    } catch (NumberFormatException e) {
			  System.err.println("Input valid numbers!");
			  showErrorMessage();
//		    } catch (OverflowException e) {
//				  showErrorMessage();
//			    
		    } catch (Exception e) {
			  showErrorMessage();
		    }
		} while(!rawInput.equals("exit"));	
	}

	private static void showHelp() {
		System.out.print(ANSI_PURPLE + "show catalog products" + ANSI_RESET);
		System.out.println(" will show the products in the catalog\n");
		System.out.print(ANSI_PURPLE + "show catalog services" + ANSI_RESET);
		System.out.println(" will show all available services in the catalog\n");
		System.out.print(ANSI_PURPLE + "show catalog all" + ANSI_RESET);
		System.out.println(" will show all items in the catalog\n");
		
		System.out.print(ANSI_PURPLE + "add <name> <count>" + ANSI_RESET);
		System.out.println(" will add to your cart wanted name and count\n");
		System.out.print(ANSI_PURPLE + "add <name>" + ANSI_RESET);
		System.out.println(" will add single item to your cart\n");
		
		System.out.print(ANSI_PURPLE + "remove <name> <count>" + ANSI_RESET);
		System.out.println(" will remove from your cart selected name and count\n");
		System.out.print(ANSI_PURPLE + "remove <name>" + ANSI_RESET);
		System.out.println(" will remove all items with selected name from your cart\n");
		System.out.print(ANSI_PURPLE + "clear" + ANSI_RESET);
		System.out.println(" will remove all items from cart\n");
		System.out.println();	
	}

	private static void showErrorMessage() {
		System.out.println("Invalid command !");
		System.out.println("Type \"help\" to see all comands");	
	}
}
