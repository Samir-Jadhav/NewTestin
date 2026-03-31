package com.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class SwitchWindow {

    @Test
    void switchWindowTest() {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("https://the-internet.herokuapp.com/windows");

            Page newPage = page.waitForPopup(() -> {
                page.click("text=Click Here");
            });

            newPage.bringToFront();
            System.out.println(newPage.title());
            
        }
    }
}