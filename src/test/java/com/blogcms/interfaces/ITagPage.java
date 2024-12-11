package com.blogcms.interfaces;

import com.blogcms.pages.TagPage;

public interface ITagPage {
    TagPage clickCreateNewTag();
    TagPage setTagName(String name);
    void clickCreateTag();
}