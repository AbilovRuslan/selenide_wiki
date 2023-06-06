import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.text;

public class SelenideWiki {
    @BeforeAll

    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";

    }
    @Test
     void selenideWiki() {
        //Откроsте  Github
        open ("https://github.com");
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        // Откройте страницу Selenide
        $$("ul.repo-list").first().$("a").click();
        //Перейдите в раздел Wiki проекта
        $("#repository-container-header").$("#wiki-tab").click();;

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions. Откройте страницу SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        //$("#wiki-body").setValue("Soft Assertions").click();

        //проверьте что внутри есть пример кода для JUnit5
        //$("#user-content-3-using-junit5-extend-test-class").shouldBe(Condition.visible).scrollTo();
        $("#wiki-body").shouldHave(Condition.text("$(\"#first\").should(visible).click();"));
        $("#wiki-body").shouldHave(Condition.text("$(\"#second\").should(visible).click();"));

    }


    
}


