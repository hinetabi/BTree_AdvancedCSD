import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BTree b = new BTree(3);
//        b.Insert(8);
//        b.Insert(9);
//        b.Insert(10);
//        b.Insert(11);
//        b.Insert(15);
//        b.Insert(20);
//        b.Insert(17);

//        b.Show();
        final String[] menu = {"Load data from file",
                "Input data & insert to the tree",
                "Breadth-first traversal",
                "In-order traversal",
                "Delete by code",
                "Count the number of books",
                "Exit."};
        int choice;
        ArrayList<Book> books = new ArrayList<>();

        while(true) {
            System.out.println("\n----------------MENU---------------");
            choice = getChoice(menu);
            if (choice == menu.length) {
                break;
            }

            switch (choice){
                // Load data from file
                case 1:
                    try {
                        readFile("book.txt", books);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    for (int i = 0; i < books.size(); i++) {
                    //System.out.println(books.get(i).toString());
                        b.Insert(books.get(i));
                    }
                    System.out.println("Load done!");
                    break;
                case 2:
                    System.err.println("Tinh nang chua hoan thien!");
                    break;
                case 3:
                    //Breadth-first traversal
                    b.Show();
                    break;
                case 4:
                    // In-order traversal
                    System.err.println("Tinh nang chua hoan thien!");
                    b.inOrderTraversal();
                    break;
                case 5:
                    // Delete by code
                    int code = Inputter.inputInteger("Enter code: ", false, false);
                    BTree.Node x = b.Search(b.getRoot(), code);

                    if (x == null) {
                        System.out.println("Can not find code in tree.");
                    } else {
                        b.Remove(x.key[x.Find(code)]);
                        System.out.println("Remove done!");
                    }

                    break;
                case 6:
                    // Count the number of books
                    b.count();
                    int numberOfBook = b.getCount();
                    System.out.println("The number of books in tree: " + numberOfBook);
                    break;
            }

        }
//        b.Show();

    }

    /**
     * read file for input
     * @param filepath
     * @param books
     * @throws Exception
     */
    public static void readFile(String filepath, ArrayList<Book> books) throws Exception {
        File f = new File(filepath);
        if (f.exists()) {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] split = str.split(";");
                int code = Integer.parseInt(split[0].trim());
                String title = split[1];
                int quantity = Integer.parseInt(split[2].trim());
                int price = Integer.parseInt(split[3].trim());
                String author = split[4];
                Book book = new Book(code, title, quantity, price, author);
                books.add(book);
            }
        } else {
            throw new FileNotFoundException();
        }
    }

    /**
     * add new book by input from keyboard
     * @return
     */
    public static Book inputBook() {
        int code = Inputter.inputInteger("Enter the code: ", false, false);
        String title = Inputter.inputString("Enter title of the Book: ", false);
        int quantity = Inputter.inputInteger("Enter quantity: ", false, false);
        int price = Inputter.inputInteger("Enter price: ", false, false);
        String author = Inputter.inputString("Enter author of the book: ", false);

        return new Book(code, title, quantity, price, author);
    }

    public static int getChoice(String[] mainScreen) {
        int i = 0;
        for (String str : mainScreen) {
            i++;
            System.out.println(i + ". " + str);
        }
        return Inputter.inputIntegerInRange("Enter your choice: ", 1, mainScreen.length);
    }

}