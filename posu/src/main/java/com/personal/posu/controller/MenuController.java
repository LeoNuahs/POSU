package com.personal.posu.controller;

import com.personal.posu.entity.menu.Menu;
import com.personal.posu.exception.DatabaseException;
import com.personal.posu.exception.MenuException;
import com.personal.posu.model.menu.MenuRequest;
import com.personal.posu.service.MenuService;
import com.personal.posu.types.MenuCategory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/menu")  // Port 8080
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{category}")
    public ResponseEntity<List<Menu>> getItemsFromCategory(@PathVariable String category) throws DatabaseException {
        return ResponseEntity.ok(menuService.getItemsFromCategory(MenuCategory.valueOf(category.toUpperCase())));
    }

    @PostMapping("/add")
    public ResponseEntity<Menu> saveItem(@RequestBody @Valid MenuRequest menu) throws DatabaseException {
        return new ResponseEntity<>(menuService.saveItem(menu), HttpStatus.CREATED);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Menu> editItem(@PathVariable int id, @RequestBody @Valid MenuRequest menu) throws DatabaseException {
        return new ResponseEntity<>(menuService.editItem(id, menu), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Menu> deleteItem(@PathVariable int id) throws DatabaseException, MenuException {
        return new ResponseEntity<>(menuService.deleteItem(id), HttpStatus.OK);
    }
}
