public class Book {
    private int code;
    private String title;
    private int quantity;
    private int price;
    private String author;

    public Book() {
    }

    public Book(int code, String title, int quantity, int price, String author) {
        this.code = code;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.author = author;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return
                "code=" + code +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", author='" + author + '\'' ;
    }
}
