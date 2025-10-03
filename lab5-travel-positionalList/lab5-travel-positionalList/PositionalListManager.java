import java.util.Scanner;

public class PositionalListManager {

	public static PositionalList<String> buildItinerary() {
		Scanner in = new Scanner(System.in);
		PositionalList<String> itinerary = new PositionalList<>();

		System.out.println("Enter your travel itinerary. Type 'done' to finish.");

		while (true) {
			System.out.print("Enter a destination: ");
			String stop = in.nextLine().trim();

			if (stop.equalsIgnoreCase("done")) {
				break;
			}
			// add @ end
			itinerary.addLast(stop);
		}

		return itinerary;
	}

	public static void main(String[] args) {
		// Build itinerary from user input
		PositionalList<String> itinerary = buildItinerary();

		// Demonstrate addAfter and addBefore (test case)
		if (itinerary.size() >= 2) {
			Position<String> first = itinerary.first();
			Position<String> second = itinerary.after(first);

			// example of before and add after in hardcoded version
			// Insert Monaco AFTER the second stop
			itinerary.addAfter(second, "Monaco");

			// Insert London BEFORE the first stop
			itinerary.addBefore(first, "London");
		}

		// Print final itinerary using for-each loop (custom iterator)
		System.out.println("Your  Travel Itinerary:");
		for (String stop : itinerary) {
			System.out.println(" " + stop);
		}
	}
}


