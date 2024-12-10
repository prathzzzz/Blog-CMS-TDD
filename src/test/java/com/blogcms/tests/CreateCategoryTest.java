package com.blogcms.tests;

import com.blogcms.base.BaseTest;
import com.blogcms.constants.TestConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCategoryTest extends BaseTest {
    @Test(description = "Create a new category")
    public void create_category() {
        navigateToBaseUrl();

        pages.getLoginPage()
                .enterEmail(config.getValidEmail())
                .enterPassword(config.getValidPassword())
                .clickCheckbox()
                .clickSubmitButton();

        pages.getDashboardPage()
                .goToCategoriesPage();
        pages.getCategoryPage()
                .clickCreateNewCategory();

        Assert.assertEquals(pages.getCategoryPage().getCreateCategoryHeading(),
                TestConstants.CREATE_CATEGORY_TITLE,
                TestConstants.CREATE_CATEGORY_HEADING_NOT_MATCHED);

        String categoryName = "Test Category Name";
        pages.getCategoryPage()
                .setCategoryName(categoryName)
                .setCategoryDescription("This is a test category")
                .waitForSlugToBePopulated()
                .clickCreateCategory();

        String expectedSlug = categoryName.toLowerCase().replace(" ", "-");
        Assert.assertTrue(pages.getCategoryPage().getCategorySlug(),
                "Category slug should be populated");

    }
}
