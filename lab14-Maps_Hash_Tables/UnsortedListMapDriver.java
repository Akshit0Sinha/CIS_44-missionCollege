
public class UnsortedListMapDriver {
	public static void main(String[] args) {
		UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

		// put(5, A)
		System.out.println("put(5, A) → " + map.put(5, "A")); // null

		// put(7, B)
		System.out.println("put(7, B) → " + map.put(7, "B")); // null

		// put(2, C)
		System.out.println("put(2, C) → " + map.put(2, "C")); // null

		// put(2, E) → replaces C
		System.out.println("put(2, E) → " + map.put(2, "C")); // C

		// get(7)
		System.out.println("get(7) → " + map.get(7)); // B

		// remove(5)
		System.out.println("remove(5) → " + map.remove(5)); // A
	}
}
