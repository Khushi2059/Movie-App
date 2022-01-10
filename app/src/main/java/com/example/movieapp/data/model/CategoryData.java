package com.example.movieapp.data.model;

import java.util.List;

public class CategoryData {

    private String categoryTitle;
    private Integer categoryId;
    private List<CategoryItem> categoryItemList;

    public CategoryData(Integer categoryId, String categoryTitle, List<CategoryItem> categoryItemList) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    public List<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<CategoryItem> categoryItemList) {
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


