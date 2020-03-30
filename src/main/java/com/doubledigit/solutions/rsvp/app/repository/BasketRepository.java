package com.doubledigit.solutions.rsvp.app.repository;

import com.doubledigit.solutions.rsvp.app.model.Basket;
import com.doubledigit.solutions.rsvp.app.model.OrderReceipt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasketRepository extends CrudRepository<Basket, Long> {

    @Query("SELECT new com.doubledigit.solutions.rsvp.app.model.OrderReceipt(b.id, b.quantity, h.id, h.name," +
            " h.price) FROM Basket b INNER JOIN b.harvest h")
    List<OrderReceipt> fetchHarvestBasketInnerJoin();

    @Query("SELECT new com.doubledigit.solutions.rsvp.app.model.OrderReceipt(b.id, b.quantity, h.id, h,name," +
            " h.price) FROM Basket b RIGHT JOIN b.havest h")
    List<OrderReceipt> fetchHarvestBasketRightJoin();
}
