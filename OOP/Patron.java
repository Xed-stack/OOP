package OOP;
import java.util.ArrayList;
class Patron implements Loanable {
    private String name;
    private ArrayList<Book> borrowedBooks;

    Patron(String name){
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    void GreetPatron(){
        System.out.println("Hello, " + name + "!" + " Welcome to our library!");
        System.out.println();
    }

    public String getName(){
        return this.name;
    }

    //Overridden abstract methods from loanable
    @Override
    public void loanBook(String bookTitle, Library library){
        Book loanedBook = library.loanedBooks(bookTitle);
        if (loanedBook != null) {
            borrowedBooks.add(loanedBook);
            System.out.println(name + " borrowed " + loanedBook.getBookTitle() + ".");
        } else {
            System.out.println( bookTitle + " is not available in the library.");
        }
    }

    public void returnBook(String bookTitle, Library library){
        if(borrowedBooks == null){
            System.out.println("You have no books to return.");
        }

        for(int i = 0; i < borrowedBooks.size(); i++){
            if(borrowedBooks.get(i).getBookTitle().equalsIgnoreCase(bookTitle)){
                Book returnedbooks = borrowedBooks.remove(i);
                library.returnedBook(returnedbooks);
                System.out.println(name + " returned " + returnedbooks.getBookTitle() + ".");
                return;
            }
        }
        System.out.println(name + " does not have " + bookTitle + " in your BorrowedList");

    }

    //Method para ma display yung borrowedBooks na arraylist ng patron
    void displayBorrowedBooks(){
        if (borrowedBooks.isEmpty()){
            System.out.println("You do not have any book/s.");
        }

        for(int i = 0; i < borrowedBooks.size(); i++) {
            Book book = borrowedBooks.get(i);
            System.out.println("Borrowed Books: " + book.getBookTitle());
        }
    }



}
