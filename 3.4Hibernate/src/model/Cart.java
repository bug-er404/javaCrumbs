package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Cart {
    private Timestamp addedTime;
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    public Cart() {
    }

    public Cart(Book book, User user)
    {
        this.bookId = book;
        this.userId = user;
    }

    @Basic
    @Column(name = "added_time")
    public Timestamp getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (addedTime != null ? !addedTime.equals(cart.addedTime) : cart.addedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return addedTime != null ? addedTime.hashCode() : 0;
    }

    @Id
    @Column(name = "cart_id")
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
