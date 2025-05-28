package com.devskiller.dao;

import com.devskiller.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(value = "select i.id, i.description, i.title, AVG(r.rating) from item i inner join review r on i.id=r.item_id group by i.title having AVG(r.rating) < %?1%", nativeQuery = true)
    List<Item> findByItemWithAverageRatingLowerThan(Double rating);

}
