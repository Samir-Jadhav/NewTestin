package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class switchwindow {

    public static void main(String[] args) {
        
       Playwright playwright =  Playwright.create();
       Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(java.util.Arrays.asList("--start-maximized")));

         BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
            );

            Page page = context.newPage();

       page.navigate("https://www.hyrtutorials.com/p/window-handles-practice.html");

        Page newWindow = context.waitForPage(()->{

page.locator("//button[@id='newWindowBtn']").click();
        });

        System.out.println(newWindow.title());
        page.bringToFront();
        System.out.println(page.title());
       

       




    }
    
}
