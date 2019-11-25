package pojo;

public class Book {
    Integer book_id;
    String name;
    String author;
    String booknumber;
    String price;
    String press;
    String borrower;
    String headpathbook;
    Borrow borrow;

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getHeadpathbook() {
        return headpathbook;
    }

    public void setHeadpathbook(String headpathbook) {
        this.headpathbook = headpathbook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", booknumber='" + booknumber + '\'' +
                ", price='" + price + '\'' +
                ", press='" + press + '\'' +
                ", borrower='" + borrower + '\'' +
                ", headpathbook='" + headpathbook + '\'' +
                ", borrow=" + borrow +
                '}';
    }
}
