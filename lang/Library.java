
/**public class Book { 
	String title;
	booleanborrowed;
	// Creates a new Book 
	public Book(String bookTitle){ 
	// Implement this method 
	} 
	// Marks the book as rented 
	public void borrowed() { 
	// Implement this method 
	} 
	// Marks the book as not rented 
	public void returned() { 
	// Implement this method 
	} 
	// Returns true if the book is rented, false otherwise 
	public boolean isBorrowed() { 
	// Implement this method 
	} 
	// Returns the title of the book 
	public String getTitle() { 
	// Implement this method 
	}
	public static void main(String[] arguments){ 
	// Small test of the Book class 
	Book example = new Book("The Da Vinci Code");
	System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
	System.out.println("Borrowed? (should be false): " + example.isBorrowed());
	example.rented();
	System.out.println("Borrowed? (should be true): " + example.isBorrowed());
	example.returned();
	System.out.println("Borrowed? (should be false): " + example.isBorrowed());
	}
	}

	public class Library { 
	// Add the missing implementation to this class 
	public static void main(String[] args){ 
	// Create two libraries 
	Library firstLibrary= new Library("Zero Point, main road."); 
	Library secondLibrary= new Library("Room no 111, IMCS."); 
	// Add four books to the first library 
	firstLibrary.addBook(new Book("The Da Vinci Code"));
	firstLibrary.addBook(new Book("Le Petit Prince"));
	firstLibrary.addBook(new Book("A Tale of Two Cities"));
	firstLibrary.addBook(new Book("The Lord of the Rings"));
	// Print opening hours and the addresses 
	System.out.println("Library hours:");
	printOpeningHours();// Implement this method by yourself
	System.out.println();
	System.out.println("Library addresses:");
	firstLibrary.printAddress();
	secondLibrary.printAddress();
	System.out.println();
	// Try to borrow The Lords of the Rings from both libraries 
	System.out.println("Borrowing The Lord of the Rings:");
	firstLibrary.borrowBook("The Lord of the Rings");
	firstLibrary.borrowBook("The Lord of the Rings");
	secondLibrary.borrowBook("The Lord of the Rings");
	System.out.println();
	// Print the titles of all available books from both libraries 
	System.out.println("Books available in the first library:");
	firstLibrary.printAvailableBooks();
	System.out.println();
	System.out.println("Books available in the second library:");
	secondLibrary.printAvailableBooks();
	System.out.println();

	// Return The Lords of the Rings to the first library 
	System.out.println("Returning The Lord of the Rings:"); 
	firstLibrary.returnBook("The Lord of the Rings"); 
	System.out.println(); 
	// Print the titles of available from the first library 
	System.out.println("Books available in the first library:"); 
	firstLibrary.printAvailableBooks();
	 }
	}
*/