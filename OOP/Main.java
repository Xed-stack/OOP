package OOP;

public class Main{
    public static void main(String[] args){
        Library library = new Library();

        library.addBook(new FictionBook("Freiren: Beyond Journey's End", "Kanehito Yamada, Tsukasa Abe"));
        library.addBook(new NonFictionBook("Art of War", "Sun Tzu"));
        library.addBook(new FictionBook("That Time I got reincarnated as a Toilet Bowl on a Male public restroom, I hate it here", "Mark Axel Vallejos"));

        library.displayLibrary();
        System.out.println("Remove:");
        library.removeBook("sussy");

        System.out.println("Search: ");
        library.searchBook("freiren");
        library.searchBook("sussy");

        library.displayLibrary();

        Patron patron1 = new Patron("Mr. Ligma");
        patron1.GreetPatron();
        patron1.loanBook("freiren", library);
        patron1.loanBook("Art of war", library);
        patron1.displayBorrowedBooks();
        patron1.returnBook("Art of war", library);

        patron1.displayBorrowedBooks();

        System.out.println();

        Patron patron2 = new Patron("Ninja");
        patron2.GreetPatron();
        patron2.loanBook("That Time I got reincarnated as a Toilet Bowl on a" , library);
        patron2.displayBorrowedBooks();
    }
}