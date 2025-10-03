import java.util.Scanner;
public class IteratorRunner {

	public static void main(String[] args) {
		Inventory i = new Inventory();
		Scanner in = new Scanner(System.in);

		// Add initial items
		i.addItem(new Item("Stick"));
		i.addItem(new Item("Gem"));
		i.addItem(new Item("Rope"));
		i.addItem(new Item("Stone"));

		// Display inventory after adding initial items
		System.out.println("\nInventory after adding initial items:");
		i.display();

		// Allow user to add custom items
		System.out.println("\nDo you want to add more items? (yes/no)");
		String response = in.nextLine();
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("How many items do you want to add?");
			int count = Integer.parseInt(in.nextLine());

			for (int j = 1; j <= count; j++) {
				System.out.println("Enter the name of item #" + j + ":");
				String itemName = in.nextLine();
				i.addItem(new Item(itemName));
			}

			System.out.println("\nInventory after adding user items:");
			i.display();
		}

		// Let the user combine items
		System.out.println("\nDo you want to combine two items? (yes/no)");
		response = in.nextLine();
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("Enter the first item to combine:");
			String first = in.nextLine();

			System.out.println("Enter the second item to combine:");
			String second = in.nextLine();

			i.combineItems(first, second);

			System.out.println("\nInventory after combination:");
			i.display();
		}

		in.close();
	}
}
