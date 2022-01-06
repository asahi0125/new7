package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class BookEntity01 implements Serializable {

    @Id @NotNull
    private String isbn;
    private String genre;
    private String title;
    private Integer price;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String exp;

    public BookEntity01() { }

    public BookEntity01(String isbn, String genre, String title, Integer price, Date date, String exp) {
        this.isbn = isbn;
        this.genre = genre;
        this.title = title;
        this.price = price;
        this.date = date;
        this.exp = exp;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
