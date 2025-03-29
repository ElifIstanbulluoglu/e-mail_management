public class Email {

	public String subject;
	public String message;
	public int id;
	public int time;
	public boolean info;
	public Email next, prev;

	public Email(int id, String subject, String message) {
		this.id = id;
		this.time = (int) System.currentTimeMillis();
		this.subject = subject;
		this.message = message;
		this.info = false; // it is initially false to show to mail is unread
		this.next = next;
		this.prev = prev;

	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}

	public int getId() {
		return id;
	}

	public int getTime() {
		return time;
	}

	public boolean getInfo() {
		return info;
	}

	// we call it in the read function to show the email is read
	public void markAsRead() {
		this.info = true;

	}

	public void printEmail() {

		System.out.println("Email id: " + id);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		System.out.println("Time received: " + this.time);
		if (info == true) {
			System.out.println("Read");
		} else {
			System.out.println("Unread");
		}
	}

}
