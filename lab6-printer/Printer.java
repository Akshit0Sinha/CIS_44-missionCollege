
public class Printer {
	public static void main(String[] args) {
		Printer officePrinter = new Printer();

		officePrinter.addJob(new PrintList("Annual_Report.pdf", 25));
		officePrinter.addJob(new PrintList("Meeting_Agenda.docx", 2));
		officePrinter.addJob(new PrintList("Presentation_Slides.pptx", 30));

		System.out.println("\n--- Starting to Print ---");
		officePrinter.processNextJob(); // Annual_Report.pdf
		officePrinter.processNextJob(); // Meeting_Agenda.docx

		System.out.println("\nNew high-priority job arrives...");
		officePrinter.addJob(new PrintList("Urgent_Memo.pdf", 1));

		officePrinter.processNextJob(); // Presentation_Slides.pptx
		officePrinter.processNextJob(); // Urgent_Memo.pdf
		officePrinter.processNextJob(); // Queue empty message
	}

	/**
	 * Adds a new print job to the rear of the queue.
	 * 
	 * @param job The print job to add.
	 */

	private PrintQueue<PrintList> jobQueue;

	public Printer() {
		// TODO: Initialize the jobQueue with a LinkedQueue
		jobQueue = new QueueProcessor<>();
	}

	public void addJob(PrintList newJob) {
		System.out.println("Adding to queue: " + newJob);
		jobQueue.enqueue(newJob);
	}


	public void processNextJob() {
		// TODO: Check if the queue is empty. If so, print a message.
		// If not empty, dequeue the job and print a "Processing..." message.
		if (jobQueue.isEmpty()) {
			System.out.println("No jobs to process. The queue is empty.");
		} else {
			PrintList job = jobQueue.dequeue();
			System.out.println("Processing " + job + "...");
		}
	}

}
