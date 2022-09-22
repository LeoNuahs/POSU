package com.personal.posu.entity.menu;

import com.personal.posu.types.MenuCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Menu")
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Menu {
    @Id
    private int id;
    @Indexed(unique = true)
    private String name;
    private double price;
//    @DBRef(db = "Inventory")
//    private List<Ingredients> ingredient;
    private MenuCategory category;
    private boolean available;
    private boolean deleted;
}
