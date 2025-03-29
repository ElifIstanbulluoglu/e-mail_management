import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		ListOfEmails Inbox = new ListOfEmails();
		ListOfEmails Archive = new ListOfEmails();
		ListOfEmails Sent = new ListOfEmails();

		Scanner scanner = new Scanner(System.in);
		int counter = 1; // initialize counter 1 to set the ID

		while (true) {
			System.out.println("Press N for create new email.");
			System.out.println("Press R for read an email");
			System.out.println("Press A for archive the email");
			System.out.println("Press D for delete the email");
			System.out.println("Press S for show the contents of the email box.");
			System.out.println("Press U for show all the unread emails in the folder.");
			System.out.println("Press C for clear the contents of the folder.");
			System.out.print("> ");
			String command = scanner.nextLine();

			switch (command) {

			case "N": // Create new email
				System.out.println("Enter subject:");
				String subject = scanner.nextLine();
				System.out.println("Enter message: ");
				String message = scanner.nextLine();
				Email newEmail = new Email(counter, subject, message);
				Sent.add(newEmail);
				System.out.println("Email sent with ID: " + newEmail.getId());
				counter++; // increase counter in every new mail to set a new ID
				break;

			case "R": // Read an email by its ID
				int id = scanner.nextInt();
				scanner.nextLine();

				Email email = Sent.read(id);

				if (email == null) {
					email = Inbox.read(id);
				}

				if (email == null) {
					email = Archive.read(id);
				}

				if (email != null) {
					email.printEmail();
				} else {
					System.out.println("No such email.");
				}
				break;

			case "A": // Archive an email by its ID
				int id1 = scanner.nextInt();
				scanner.nextLine();
				Email email1 = Inbox.delete(id1);
				if (email1 != null) {
					Archive.add(email1);
					System.out.println("Email " + id1 + " archived.");
				} else {
					System.out.println("There is no email in Inbox.");
				}
				break;

			case "D": // Delete an email by its ID
				int id2 = scanner.nextInt();
				scanner.nextLine();
				Email email2 = Sent.delete(id2);
				if (email2 != null) {
					System.out.println("Email " + id2 + " is deleted from Sent.");
				} else {
					email2 = Inbox.delete(id2);
					if (email2 != null) {
						System.out.println("Email " + id2 + " is deleted from Inbox.");
					} else {
						email2 = Archive.delete(id2);
						if (email2 != null) {
							System.out.println("Email " + id2 + " is deleted from Archive.");
						}
					}
				}

				if (email2 == null) {
					System.out.println("No such email.");
				}
				break;

			case "S": // Show the contents of all the mails in a linkedList
				String folder = scanner.nextLine();
				switch (folder) {
				case "Inbox":
					Inbox.showAll(true);
					break;
				case "Archive":
					Archive.showAll(true);
					break;
				case "Sent":
					Sent.showAll(true);
					break;
				default:
					System.out.println("Invalid input");

				}

				break;

			case "U": // Show the contents of the unread emails in a linkedList
				String folder2 = scanner.nextLine();
				switch (folder2) {
				case "Inbox":
					Inbox.showAll(false);
					break;
				case "Archive":
					Archive.showAll(false);
					break;
				case "Sent":
					Sent.showAll(false);
					break;
				default:
					System.out.println("Invalid input");

				}
				break;

			case "C": // Clear the contents of the folder
				String folder3 = scanner.nextLine();

				switch (folder3) {
				case "Archive":
					Archive.deleteAll();
					System.out.println("Archive cleared.");
					break;
				case "Inbox":
					Inbox.archiveAll(Archive);
					System.out.println("Inbox cleared and emails moved to Archive.");
					break;
				case "Sent":
					Sent.archiveAll(Archive);
					System.out.println("Sent folder cleared and emails moved to Archive.");
					break;
				default:
					System.out.println("Invalid folder name.");
				}
				break;

			default:
				System.out.println("Invalid Input");

			}

		}

	}

}
