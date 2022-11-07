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
                "In-order traversal",
                "Delete by code",
                "Delete by code",
                "Count the number of books"};
        ArrayList<Book> books = new ArrayList<>();
        try {
            readFile("book.txt", books);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < books.size(); i++) {
//            System.out.println(books.get(i).toString());
            b.Insert(books.get(i));
        }
        b.Show();
        System.out.println("After remove 3: \n --------------------------- \n");
        BTree.Node x = b.Search(b.getRoot(), 3);
        b.Remove(x.key[x.Find(3)]);
//        System.out.println();
        b.Show();
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
        int i = 2;
        for (String str : mainScreen) {
            i++;
            System.out.println(i + ". " + str);
        }
        return Inputter.inputIntegerInRange("Enter your choice: ", 1, mainScreen.length);
    }

}