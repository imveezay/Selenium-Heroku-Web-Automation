package herokuapp;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HerokuappWebAutomation {

    private WebDriver driver;

    @BeforeMethod 
    public void setUp() throws InterruptedException {
    	//Setting up Google Chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Goto TestSuite Website
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        //Quit The Driver and Close Window
        driver.quit();
    }

    @Test(priority=1) //priority 1 runs first
    public void LoginBasicAuth() throws InterruptedException {
        //Click on BasicAuth Link
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).getText();
        System.out.println(text);
    }

	@Test(priority=2) //priority 2 runs second
    public void ValidateCheckBoxes() throws InterruptedException {
        //Click On CheckBoxes Link
        driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[6]/a")).click();
        Thread.sleep(2000);


        //For the first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
        if (!checkbox1.isSelected()) {
            checkbox1.click();          

        }
        //For Second CheckBox
        WebElement checkbox2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]"));
        Thread.sleep(2000);
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        //State of the checkbox
        System.out.println("The First checkbox is in state :" + checkbox1.isSelected());
        System.out.println("The Second checkbox is in state  :" + checkbox2.isSelected());
    }
	@Test(priority=3)
	public void AddRemoveElements() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button")).click();
		Thread.sleep(2000);
		
	}
}


