package com.personal.posu.service;

import com.personal.posu.entity.menu.Menu;
import com.personal.posu.exception.DatabaseException;
import com.personal.posu.exception.MenuException;
import com.personal.posu.model.menu.MenuRequest;
import com.personal.posu.repository.MenuRepository;
import com.personal.posu.types.ExceptionType;
import com.personal.posu.types.MenuCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final NextSequenceService nextSequenceService;

    public List<Menu> getItemsFromCategory(MenuCategory category) throws DatabaseException {
        List<Menu> items = menuRepository.findItemsByTypeEquals(category);

        if (items.isEmpty()) {
            throw new DatabaseException(
                    String.valueOf(category),
                    ExceptionType.EMPTY_ITEM_CATEGORY_EXCEPTION
            );
        } else {
            return items;
        }
    }

    public Menu saveItem(MenuRequest menuRequest) throws DatabaseException {
        try {
            Menu menu = Menu.build(
                    nextSequenceService.getNextSequence("ItemSequence"),
                    menuRequest.getName(),
                    menuRequest.getPrice(),
//                    menuRequest.getIngredients(),
                    menuRequest.getCategory(),
                    true,
                    false
            );
            return menuRepository.save(menu);
        } catch (Exception ex) {
            throw new DatabaseException(
                    ex,
                    ExceptionType.SAVE_ITEM_EXCEPTION
            );
        }
    }

    public Menu editItem(int id, MenuRequest menuRequest) throws DatabaseException {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new DatabaseException(
                        String.valueOf(id),
                        ExceptionType.ITEM_NOT_FOUND_EXCEPTION
                ));

        menu.setName(menuRequest.getName());
        menu.setPrice(menuRequest.getPrice());
//        menu.setIngredients(menuRequest.getIngredients());
        menu.setCategory(menuRequest.getCategory());

        return menuRepository.save(menu);
    }

    public Menu deleteItem(int id) throws DatabaseException, MenuException {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new DatabaseException(
                        String.valueOf(id),
                        ExceptionType.ITEM_NOT_FOUND_EXCEPTION
                ));

        if (menu.isDeleted()) throw new MenuException(
                String.valueOf(id),
                ExceptionType.ITEM_ALREADY_DELETED_EXCEPTION
        );

        menu.setDeleted(true);

        return menuRepository.save(menu);
    }
}
