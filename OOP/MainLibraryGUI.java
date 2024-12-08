package OOP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainLibraryGUI {
    JFrame AdminFrame, UserFrame;
    JButton AddBookBTN, DisplaLibraryBTN, LoanBookBTN, DisplayBorrowedBTN, SearchBTN, RemoveBTN;
    JLabel label1, label2, Imagelabel1, label4, label5, label6;
    JPanel panel1, panel2;
    JTextField textField1, textField2;
    Font labelFont;
    ImageIcon image;
    Patron patron;
    Library library;

        MainLibraryGUI(String username){

        library = new Library();
        library.addBook(new FictionBook("Freiren", "Kanehito"));
        library.addBook(new NonFictionBook("Art of war", "Sun Tzu"));
        library.addBook(new FictionBook("That Time I got reincarnated as a Slime", "Fuse"));

        if(username.equals("admin")){

        AdminFrame = new JFrame("Library (****ADMIN VIEW****)");
        AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminFrame.setSize(800, 800);
        AdminFrame.setLayout(null);

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 800, 800);

        label1 = new JLabel("Good day " + username + ", what do you want to do?");
        label1.setBounds(0,0, 500, 30);
        panel1.add(label1);

        AddBookBTN = new JButton("Add Book");
        AddBookBTN.setBounds(150, 350, 200, 50);
        AddBookBTN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String bookname = JOptionPane.showInputDialog(AdminFrame, "Enter book name");
                String bookauthor = JOptionPane.showInputDialog(AdminFrame, "Enter the Author");
                String genre = JOptionPane.showInputDialog(AdminFrame, "Enter book genre (Fiction or Non-Fiction)");
                if(genre.equalsIgnoreCase("fiction")){
                    library.addBook(new FictionBook(bookname, bookauthor));
                    JOptionPane.showMessageDialog(AdminFrame, "Added " + bookname + " by " + bookauthor + " to the library");
                }else if(genre.equalsIgnoreCase("non-fiction")){
                    library.addBook(new NonFictionBook(bookname, bookauthor));
                    JOptionPane.showMessageDialog(AdminFrame, "Added " + bookname + " by " + bookauthor + " to the library");
                }
            }
        });
        panel1.add(AddBookBTN);

        RemoveBTN = new JButton("remove book");
        RemoveBTN.setBounds(350, 350, 200, 50);

        RemoveBTN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String bookName = JOptionPane.showInputDialog(AdminFrame,"Enter the name of the book you want to remove");
                library.removeBook(bookName);
                JOptionPane.showMessageDialog(AdminFrame, bookName + " is Removed from the Library");

            }
        });
        panel1.add(RemoveBTN);

        DisplaLibraryBTN = new JButton("Display Library");
        DisplaLibraryBTN.setBounds(350, 300, 200, 50);
        DisplaLibraryBTN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                library.displayLibrary();
            }
        });
        panel1.add(DisplaLibraryBTN);

        SearchBTN = new JButton("Search Book");
            SearchBTN.setBounds(150, 300, 200, 50);

            SearchBTN.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){

                    String bookName = JOptionPane.showInputDialog(AdminFrame, "Enter the title of the book");
                    if(bookName != null && !bookName.isEmpty()){
                        library.searchBook(bookName);
                    }
                }
            });

            panel1.add(SearchBTN);
        AdminFrame.add(panel1);
        AdminFrame.setVisible(true);
        }

        //goes here if the username is Admin
        else {
            patron = new Patron(username);


            UserFrame = new JFrame("Library");
            UserFrame.setSize(800,800);
            UserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            UserFrame.setLayout(null);

            panel2 = new JPanel();
            panel2.setLayout(null);
            panel2.setBounds(0, 0, 800, 800);

            label2 = new JLabel("Good day " + username + ", what do you want to do?");
            panel2.add(label2);



            LoanBookBTN = new JButton("Loan Book");
            LoanBookBTN.setBounds(300,100,200,50);
            LoanBookBTN.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String bookTitle = JOptionPane.showInputDialog(UserFrame, "Enter the title of the book you want to loan");
                    if(bookTitle != null && !bookTitle.isEmpty()){
                        patron.loanBook(bookTitle, library);
                        JOptionPane.showMessageDialog(UserFrame, username + " borrowed " + bookTitle);
                    }
                }
            });


            DisplayBorrowedBTN = new JButton("Display Borrowed Books");
            DisplayBorrowedBTN.setBounds(300, 150, 200, 50);
            DisplayBorrowedBTN.addActionListener((new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    patron.displayBorrowedBooks();
                    JOptionPane.showMessageDialog(UserFrame, "Check the Terminal for the list of Borrowed Books");
                }
            }));


            SearchBTN = new JButton("Search Book");
            SearchBTN.setBounds(300, 200, 200, 50);
            SearchBTN.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String bookName = JOptionPane.showInputDialog(UserFrame, "Enter the title of the book");
                    if(bookName != null && !bookName.isEmpty()){
                        library.searchBook(bookName);
                    }
                }
            });

            panel2.add(SearchBTN);
            panel2.add(LoanBookBTN);
            panel2.add(DisplayBorrowedBTN);
            UserFrame.add(panel2);
            UserFrame.setVisible(true);
        }
    }
}

