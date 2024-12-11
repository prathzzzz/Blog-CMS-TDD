package com.blogcms.interfaces;

public interface IDashboardPage {
    boolean isDashboardDisplayed();

    String getHeading();
    void clickLogout();
    void goToCategoriesPage();
    void goToTagsPage();
}
