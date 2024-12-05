package OOP;

class Book {
    //book class properties
    //Seth gawin mong Private mga variables na to tas gawa ka ng Getters tas Setters
    private String bookTitle;
    private String bookAuthor;

    //Book class constructor
    Book(){
        bookTitle = "";
    }

    Book(String bookTitle, String bookAuthor){
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle(){
        return bookTitle;
    }

    public String getBookAuthor(){
        return bookAuthor;
    }

    String displayBookInfo(){
        System.out.println("Book: " + bookTitle);
        if(!bookAuthor.isEmpty()){
            System.out.print("by: " + getBookAuthor() + "\n");
        }else{
        return "Author: unknown";
        }
        return "";
    }

}



class FictionBook extends Book{
    FictionBook(String bookTitle, String bookAuthor){
        super(bookTitle, bookAuthor);
    }

    @Override
    String displayBookInfo(){
        return "Genre: Fiction " + super.displayBookInfo();
    }

}

class NonFictionBook extends Book{
    NonFictionBook(String bookTitle, String bookAuthor){
        super(bookTitle, bookAuthor);
    }

    @Override
    String displayBookInfo(){
        return "Genre: Non-Fiction " + super.displayBookInfo();
    }

}

