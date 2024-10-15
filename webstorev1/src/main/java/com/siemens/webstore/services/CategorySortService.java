package com.siemens.webstore.services;

import com.siemens.webstore.models.Category;

import java.util.Comparator;

public class CategorySortService implements Comparator<Category> {
    @Override
    public int compare(Category category1, Category category2) {
        if(category1.getCategoryId() == category2.getCategoryId())
            return 0;
        else if (category1.getCategoryId()>category2.getCategoryId()) {
            return 1;

        }
        else
            return -1;

    }
}
