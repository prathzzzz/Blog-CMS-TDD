package com.blogcms.interfaces;

import com.blogcms.pages.CategoryPage;

public interface ICategoryPage {
    void clickCreateNewCategory();
    String getCreateCategoryHeading();
    CategoryPage setCategoryName(String name);
    boolean getCategorySlug();
    CategoryPage waitForSlugToBePopulated();
    CategoryPage setCategoryDescription(String description);
    void clickCreateCategory();
}
