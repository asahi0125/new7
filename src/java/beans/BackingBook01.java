package beans;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

@Named
@RequestScoped
public class BackingBook01 {

	@Id
    @Pattern(regexp="^(\\d{3}-).+")
    private String isbn;
    @NotNull
    private String genre;
    @Size(min=1, max=60)
    private String title;
    @Min(500)@Max(9999) @NotNull
    private Integer price;
    @Temporal(TemporalType.DATE)
    @NotNull @Past
    private Date date;
    @Size(max=200)
    private String exp;
    private static final Map<String, String> item;
    static {
        item = new LinkedHashMap<>();
        item.put("コンピュータ・IT", "コンピュータ・IT");	
        item.put("趣味・実用", "趣味・実用");
        item.put("フィクション", "フィクション");
    }

    @EJB
    Worker01 wk;
    @Inject
    transient Logger log;

    public String doRegistrate() {
        register();
        return null;
    }

    public void register() {
        BookEntity01 entity = new BookEntity01(isbn, genre, title, price, date, exp);
        try {
            wk.register(entity);
            clear();
        } catch (Exception e) {
            log.log(Level.SEVERE, "ISBN番号{0}を登録できません", isbn);
        }
    }

    public void clear() {
        isbn = genre = title = exp =null;
        price = null;
        date = null;
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

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, String> getItem() {
        return item;
    }
}
