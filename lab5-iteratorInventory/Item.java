
public class Item {
	private String name;

	public Item(String n) {
		this.name = n;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
