package com.blogcms.constants;

public final class TestConstants {
    private TestConstants() {
        // Prevent instantiation
    }

    // Page Titles
    public static final String DASHBOARD_TITLE = "Dashboard";
    public static final String SIGN_IN_TITLE = "Sign in";
    public static final String CREATE_CATEGORY_TITLE = "Create Category";

    // Messages
    public static final String INVALID_CREDENTIALS_MESSAGE = "These credentials do not match our records.";
    
    // Error Messages
    public static final String HEADING_MISMATCH_ERROR = "The heading does not match. Expected: %s, but got: %s";
    public static final String SIGN_OUT_ERROR = "Sign-out failed: The heading does not match the expected value.";
    public static final String INVALID_LOGIN_ERROR = "User logged in with invalid credentials";
    public static final String DASHBOARD_NOT_DISPLAYED = "Dashboard page is not displayed after login";
    public static final String INVALID_CREDENTIALS_NOT_DISPLAYED = "Invalid credentials message is not displayed";
    public static final String CREATE_CATEGORY_HEADING_NOT_MATCHED = "Create category page heading does not match expected";
    
    // Timeouts
    public static final int DEFAULT_TIMEOUT_SECONDS = 10;
    public static final int POLLING_INTERVAL_MS = 500;
} 