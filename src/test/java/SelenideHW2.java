import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideHW2 {

    @Test
    void checkGitHubMenuTest() {
        open("https://github.com/");
        $(withText("Solutions")).hover();
        $(withText("Enterprise")).click();
        $("h1").shouldHave(text("Build like the best"));
    }
}
