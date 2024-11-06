package week1.day3;

public class Library {
	String addBook(String bookTitle){
		
		System.out.println("Book added successfully");
		return bookTitle;
	}
	
	public void issueBook(){
		System.out.println("Book issued successfully");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library lib = new Library();
		String bt = lib.addBook("Basics of java");
		System.out.println(bt);
		lib.issueBook();
		
	}

}
