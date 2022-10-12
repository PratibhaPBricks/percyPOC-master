import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.percy.selenium.Percy;


public class Example {
  private static WebDriver driver;
  private static Percy percy;

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", "C://Users//PratibhaSistla//geckodriver.exe");
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);
    driver = new FirefoxDriver(options);
    percy = new Percy(driver);

    driver.get("https://example.com");
    percy.snapshot("Java example");
  }

}
