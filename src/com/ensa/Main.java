package com.ensa;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// Le premier bloc du code a éxecuter : 1
// ce code permet a créé un nouvel utilisateur de l'application

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5173");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		scrollToEnd(driver);
		WebElement buttonSignUp= driver.findElement(By.xpath("//button[contains(text(),'Créez un compte')]"));
		clickButton(driver,buttonSignUp,10);
		Thread.sleep(200);
		driver.navigate().refresh();
		Thread.sleep(200);
		WebElement buttonPersonnePh= driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
		clickButton(driver,buttonPersonnePh,10);
		WebElement buttonNext= driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/button[1]"));
		clickButton(driver,buttonNext,10);
		WebElement inputEmail = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
		sendKeys(driver,inputEmail,10,"yiwey86590@mainoj.com");
		Thread.sleep(200);
		WebElement inputPsswd = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]"));
		sendKeys(driver,inputPsswd,10,"123456789");
		Thread.sleep(200);
		WebElement inputAdr = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]"));
		sendKeys(driver,inputAdr,10,"74 LOT AZIZOU SALAM");
		Thread.sleep(200);
		WebElement inputTel = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/input[1]"));
		sendKeys(driver,inputTel,10,"0615837304");
		Thread.sleep(200);
		WebElement inputFixe = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/input[1]"));
		sendKeys(driver,inputFixe,10,"0505080907");
		Thread.sleep(200);
		WebElement buttonNext2 = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/button[1]"));
		Thread.sleep(300);
		clickButton(driver,buttonNext2,10);
		WebElement inputRS  = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
		sendKeys(driver,inputRS,10,"AX859-D");
		Thread.sleep(200);
		WebElement inputICE = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]"));
		sendKeys(driver,inputICE,10,"8596SD85");
		Thread.sleep(200);
		WebElement inputPatente  = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/input[1]"));
		sendKeys(driver,inputPatente,10,"QLO-AGA-2023");
		Thread.sleep(200);
		WebElement buttonNext3 = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/button[1]"));
		Thread.sleep(300);
		clickButton(driver,buttonNext3,10);
		WebElement inputFile = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
		String filePath = "C:\\Users\\ylach\\Desktop\\cours\\TP_Qazdar\\pieceJointe.pdf";
		inputFile.sendKeys(filePath);
		Thread.sleep(300);
		WebElement buttonConfirmer = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]"));
		clickButton(driver,buttonConfirmer,10);
		Thread.sleep(7000);
		driver.quit();
	}
	
	

	
    // Method to scroll to the end of the page
    private static void scrollToEnd(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long initialScrollPosition, currentScrollPosition;

        do {
            initialScrollPosition = (Long) js.executeScript("return window.scrollY;");
            js.executeScript("window.scrollBy(0, 200);");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentScrollPosition = (Long) js.executeScript("return window.scrollY;");

        } while (currentScrollPosition > initialScrollPosition);
        
        js.executeScript("window.scrollBy(0,-"+initialScrollPosition+");");
        
    }
    
    
    public static void clickButton(WebDriver driver1,WebElement element,int i) {
		new WebDriverWait(driver1,Duration.ofSeconds(i)).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
    
    public static void sendKeys(WebDriver driver1,WebElement element, int i,String value) {
		new WebDriverWait(driver1,Duration.ofSeconds(i)).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
}

