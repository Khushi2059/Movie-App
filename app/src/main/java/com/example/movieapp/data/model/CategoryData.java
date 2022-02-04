package com.example.movieapp.data.model;

import java.util.List;

public class CategoryData {

    private String categoryTitle;
    private Integer categoryId;
    private List<CategoryItemData> categoryItemList;

    public CategoryData(Integer categoryId, String categoryTitle, List<CategoryItemData> categoryItemList) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    public List<CategoryItemData> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<CategoryItemData> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}


