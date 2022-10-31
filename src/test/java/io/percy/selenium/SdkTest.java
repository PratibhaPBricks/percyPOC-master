package io.percy.selenium;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SdkTest {
 // private static final String TEST_URL = "https://www.boomin.dev";
//private static final String TEST_URL = "https://bee:launch2021!@cjeasey.co.uk/smartval/index.php";
 private static final String TEST_URL = "https://bee:launch2021!@training-www.boomin.dev/";
  private static WebDriver driver;
  private static Percy percy;

  @BeforeAll
  public static void testSetup() throws IOException, InterruptedException {
    // Disable browser logs from being logged to stdout
   System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
   System.setProperty("webdriver.gecko.driver", "C://Users//PratibhaSistla//geckodriver.exe");
   FirefoxOptions options = new FirefoxOptions();
   driver = new FirefoxDriver(options);
  // System.setProperty("webdriver.chrome.driver", "C://Users//PratibhaSistla//Selenium//chromedriver.exe");
  // ChromeOptions options = new ChromeOptions();
  //  driver = new ChromeDriver(options);
    percy = new Percy(driver);
   


  };
  @AfterAll
  public static void testTeardown() {
    // Close our test browser.    driver.quit();

    // Shutdown our server and make sure the threadpool also terminates.
    TestServer.shutdown();
  }

  @Test
  public void takesLocalAppSnapshotWithProvidedName() throws InterruptedException{
    driver.get(TEST_URL);

    percy.snapshot("Snapshot of Boomin Home Page - Training Environment");
  }

  @Test
  public void takesLocalAppSnapshotWithProvidedNameAndWidths() {
    driver.get(TEST_URL);
    percy.snapshot("Snapshot with provided name and widths", Arrays.asList(768, 992, 1200));
  }

  @Test
  public void takesLocalAppSnapshotWithProvidedNameAndMinHeight() {
    driver.get(TEST_URL);
    percy.snapshot("Snapshot with provided name and min height", null, 2000);
  }

  // @Test
  // public void takesMultipleSnapshotsInOneTestCase() {
  //   driver.get(TEST_URL);

  //      WebElement menuButton = driver.findElement(By.className("MuiButtonBase-root"));
        
  //      percy.snapshot("Multiple snapshots in one test case -- #1", Arrays.asList(768, 992, 1200));

    //    WebElement operator = driver.findElement(By.id("selectOperationDropdown"));
    //    operator.sendKeys("Add");

       
    // percy.snapshot("Multiple snapshots in one test case -- #2", Arrays.asList(768, 992, 1200));
  //}

//   @Test
//   public void snapshotALiveHTTPSite() {
//     driver.get("http://bee:launch2021!@training-www.boomin.dev/");
//     percy.snapshot("Site served with HTTP");
//   }

//   @Test
//   public void snapshotsWithJavaScriptEnabled() {
//     driver.get("https://bee:launch2021!@training-www.boomin.dev/");
//     percy.snapshot("Site with JS enabled", null, null, true);
//   }

//   @Test
//   public void snapshotsWithPercyCSS() {
//     driver.get("https://bee:launch2021!@training-www.boomin.dev/");
//     percy.snapshot("Site with Percy CSS", null, null, false, "body { background-color: purple; }");
//   }

//   @Test
//   public void snapshotsWithScope() {
//     driver.get("https://bee:launch2021!@training-www.boomin.dev/");
//     percy.snapshot("Site with scope", null, null, false, "", "div");
//   }
 }
