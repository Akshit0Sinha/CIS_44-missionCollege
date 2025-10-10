
public class PrintList {
	private String doc;
	private int pgCount;

	// Constructor
	public PrintList(String doc, int pgCount) {
		this.doc = doc;
		this.pgCount = pgCount;
	}

	// toString method
	@Override
	public String toString() {
		return "PrintJob(Document: " + doc + " with " + pgCount + " number of pages.]";
	}

}
