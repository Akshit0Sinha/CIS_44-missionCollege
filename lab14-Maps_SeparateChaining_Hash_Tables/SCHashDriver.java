public class SCHashDriver {
	public static void main(String[] args) {
		SeparateChainingHashMap<String, Integer> map = new SeparateChainingHashMap<>();

		map.put("Aa", 1);
		map.put("BB", 2);
		map.put("AaBB", 3);

		System.out.println("Bucket(Aa)    = " + Math.abs("Aa".hashCode() % 11));
		System.out.println("Bucket(BB)    = " + Math.abs("BB".hashCode() % 11));
		System.out.println("Bucket(AaBB)  = " + Math.abs("AaBB".hashCode() % 11));
		System.out.println();

		System.out.println("Get Aa:   " + map.get("Aa"));
		System.out.println("Get BB:   " + map.get("BB"));
		System.out.println("Get AaBB: " + map.get("AaBB"));
		System.out.println("Get Xx:   " + map.get("Xx"));
		System.out.println();

		System.out.println("Remove BB: " + map.remove("BB"));
		System.out.println("Get BB after removal: " + map.get("BB"));
		System.out.println();

		System.out.println("Map size: " + map.size());
	}
}
