import java.util.LinkedList;
import java.util.Scanner;

public class ListOfEmails {

	public ListOfEmails() {

		this.head = head;
		this.tail = tail;

	}

	Email head;
	Email tail;

	// Add email to the list
	public void add(Email email) {
		if (head == null) {
			head = email;
			tail = email;
		}

		else {
			tail.next = email;
			email.prev = tail;
			tail = email;

		}
	}

	// Read an email by its ID
	public Email read(int id) {
		Email current = head;

		while (current != null) {
			if (current.getId() == id) {
				current.markAsRead();
				current.printEmail();
			}
			current = current.next;
		}
		return null;
	}

	// Delete an email by its ID
	public Email delete(int id) {
		Email current = head;

		while (current != null) {
			if (current.getId() == id) {
				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					head = current.next;
				}

				if (current.next != null) {
					current.next.prev = current.prev;
				} else {
					tail = current.prev;
				}
			}
			current = current.next;
			return current;
		}

		return null;
	}

	// Show all emails, or only unread emails based on flag
	public void showAll(boolean flag) {
		Email current = head;
		System.out.printf("ID    Subject                   Message                                  Time       Read%n");

		while (current != null) {
			if (flag == true) {

				String subject = current.subject.length() > 25 ? current.subject.substring(0, 25) : current.subject;
				String message = current.message.length() > 40 ? current.message.substring(0, 40) : current.message;
				System.out.printf("%-5d %-25s %-40s %-10d %-5s%n", current.id, subject, message, current.time,
						current.info ? "Yes" : "No");

			} else {
				if (current.getInfo() == false) {

					String subject = current.subject.length() > 25 ? current.subject.substring(0, 25) : current.subject;
					String message = current.message.length() > 40 ? current.message.substring(0, 40) : current.message;
					System.out.printf("%-5d %-25s %-40s %-10d %-5s%n", current.id, subject, message, current.time,
							current.info ? "Yes" : "No");

				}

			}
			current = current.next;
		}

	}

	// Delete all nodes in a linkedList
	public void deleteAll() {
		Email current = head;

		while (current != null) {
			Email nextNode = current.next;
			current.prev = null;
			current.next = null;
			current = nextNode;
		}

		head = null;
		tail = null;
		System.out.println("All nodes have been deleted.");
	}

	// Archive all nodes in a linkedList
	public void archiveAll(ListOfEmails archive) {
		if (head == null) {
			return;
		}

		if (archive.head == null) {
			archive.head = this.head;
			archive.tail = this.tail;
		} else {

			archive.tail.next = this.head;
			this.head.prev = archive.tail;
			archive.tail = this.tail;
		}

		this.head = null;
		this.tail = null;

	}

}
