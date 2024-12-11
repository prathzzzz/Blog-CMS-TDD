package com.blogcms.tests;

import com.blogcms.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTagTest extends BaseTest {

    @Test(description = "Create a new tag")
    public void createTagTest() {
        navigateToBaseUrl();
        
        pages.getLoginPage()
                .enterEmail(config.getValidEmail())
                .enterPassword(config.getValidPassword())
                .clickCheckbox()
                .clickSubmitButton();

        pages.getDashboardPage()
                .goToTagsPage();

        String tagName = "Tesaaaaaaaat Tag";
        String expectedSlug = tagName.toLowerCase().replace(" ", "-");
        
        pages.getTagPage()
                .clickCreateNewTag()
                .setTagName(tagName)
                .clickCreateTag();

    }
}