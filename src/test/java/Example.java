import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.percy.selenium.Percy;


public class Example {
  private static WebDriver driver;
  private static Percy percy;

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C://Users//PratibhaSistla//Selenium//chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);
    driver = new ChromeDriver(options);
    percy = new Percy(driver);

    driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    percy.snapshot("Calculator example");
  }

}
