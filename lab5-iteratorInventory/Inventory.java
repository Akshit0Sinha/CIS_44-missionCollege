import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Inventory {
	private List<Item> items;

	// Constructor initializes the inventory with an empty ArrayList
	public Inventory() {
		this.items = new ArrayList<>();
	}

	// Adds a new item to the inventory
	public void addItem(Item i) {
		items.add(i);
	}

	public void combineItems(String name1, String name2) {
		boolean f1 = false;
		boolean f2 = false;

		// Iterate through the list using an Iterator for safe removal

		Iterator<Item> i = items.iterator();
		while (i.hasNext()) {
			Item current = i.next();

			// If current item matches name1/name2 and hasn't been removed yet

			if (!f1 && current.getName().equalsIgnoreCase(name1)) {
				f1 = true;
				i.remove();
			} else if (!f2 && current.getName().equalsIgnoreCase(name2)) {
				f2 = true;
				i.remove();
			}
		}

		// After iteration is finished, check if both were found
		if (f1 && f2) {
			String combinedName = name1 + "-" + name2;
			Item combined = new Item(combinedName);
			items.add(combined);
			System.out.println("Successfully combined " + name1 + " and " + name2 + " into " + combinedName + "!");
		} else {
			System.out.println("Combination failed. Missing required items.");
		}
	}

	// Displays all items currently in the inventory
	public void display() {
		if (items.isEmpty()) {
			System.out.println("Inventory is empty.");
		}

		else {
			System.out.println("Inventory:");
			for (Item item : items) {
				System.out.println(" " + item);
			}
		}
	}

}
