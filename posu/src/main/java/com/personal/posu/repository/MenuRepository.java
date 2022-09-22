package com.personal.posu.repository;

import com.personal.posu.entity.menu.Menu;
import com.personal.posu.types.MenuCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends MongoRepository<Menu, Integer> {
    @Query("{$and: [{'category': ?0}, {'deleted': false}]}")
    List<Menu> findItemsByTypeEquals(MenuCategory type);
    @Query("{$and: [{'_id': ?0}, {'deleted': false}]}")
    Optional<Menu> findItem(int id);

    @Query("{$and: [{'_id': ?0}, {'deleted': false}]}")
    Menu returnNotOptional(int id);
}
