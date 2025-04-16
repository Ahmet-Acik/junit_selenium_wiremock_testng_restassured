package org.ahmet.selenium;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.remote.RemoteWebDriver;

        import java.net.MalformedURLException;
        import java.net.URL;

        public class SeleniumGridExample {

            public static void main(String[] args) throws MalformedURLException {
                ChromeOptions options = new ChromeOptions();
                WebDriver driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    options
                );
                driver.get("https://example.com");
                System.out.println("Title: " + driver.getTitle());
                driver.quit();
            }
        }