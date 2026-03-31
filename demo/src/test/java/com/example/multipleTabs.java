package com.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class multipleTabs {
    public static void main(String[] args) {

    try (Playwright playwright = Playwright.create()) {

      Browser browser = playwright.chromium()
          .launch(new BrowserType.LaunchOptions().setHeadless(false));

      Page page = browser.newPage();

      page.navigate("https://www.hyrtutorials.com/p/window-handles-practice.html");

      Page popupPage = page.waitForPopup(() -> {
        page.getByRole(AriaRole.BUTTON,
            new Page.GetByRoleOptions().setName("Open Multiple Windows")).click();
      });

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter First Name")).click();

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter First Name")).fill("ganesh");

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter First Name")).press("Tab");

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter Last Name")).fill("panchal");

      popupPage.getByText("Basic Controls in HTMLIn HTML").click();

      popupPage.locator("#englishchbx").check();
      popupPage.locator("#hindichchbx").check();
      popupPage.locator("#chinesechbx").check();

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter Email")).click();

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter Email")).fill("ganesh@panchal.com");

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter Email")).press("Tab");

      popupPage.getByRole(AriaRole.TEXTBOX,
          new Page.GetByRoleOptions().setName("Enter Password")).fill("ganeshchomu");

      popupPage.getByRole(AriaRole.BUTTON,
          new Page.GetByRoleOptions().setName("Register")).click();

      browser.close();
    }
  }

}
