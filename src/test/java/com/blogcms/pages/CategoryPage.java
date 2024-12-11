package com.blogcms.pages;

import com.blogcms.base.BasePage;
import com.blogcms.interfaces.ICategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.blogcms.locators.CategoryLocators.*;


public class CategoryPage extends BasePage implements ICategoryPage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = NEW_CATEGORY_BUTTON)
    private WebElement buttonCreateNewCategory;

    @FindBy(xpath = CREATE_CATEGORY_HEADING)
    private WebElement labelCreateCategoryHeading;

    @FindBy(xpath = CATEGORY_NAME_INPUT)
    private WebElement inputCategoryName;

    @FindBy(xpath = CATEGORY_SLUG_INPUT)
    private WebElement inputCategorySlug;

    @FindBy(xpath = CATEGORY_DESCRIPTION_INPUT)
    private WebElement inputCategoryDescription;

    @FindBy(xpath = CREATE_CATEGORY_BUTTON)
    private WebElement buttonCreateCategory;


    @Override
    public void clickCreateNewCategory() {
        elementUtils.click(buttonCreateNewCategory);
    }

    @Override
    public String getCreateCategoryHeading() {
        return elementUtils.getText(labelCreateCategoryHeading);
    }

    @Override
    public CategoryPage setCategoryName(String name) {
        elementUtils.sendKeys(inputCategoryName, name);
        return this;
    }

    @Override
    public boolean getCategorySlug() {
        return elementUtils.getText(inputCategorySlug).equalsIgnoreCase(inputCategorySlug.getText());
    }

    @Override
    public CategoryPage setCategoryDescription(String description) {
        elementUtils.sendKeys(inputCategoryDescription, description);
        return this;
    }

    @Override
    public void clickCreateCategory() {
        elementUtils.click(buttonCreateCategory);
    }


}
