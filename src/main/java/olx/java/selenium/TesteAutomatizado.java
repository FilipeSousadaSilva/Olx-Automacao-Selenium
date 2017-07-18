package olx.java.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://sp.olx.com.br");
		driver.findElement(By.id("searchtext")).sendKeys("xobx");
		int quantidade =  5;
		for(int i=0; i<=quantidade; i++){ //identifica preço e título
			System.out.println(driver.findElement(By.xpath("//li[" + i + "]/a/div[3]/p")).toString());
			System.out.println(driver.findElement(By.xpath("//li[" + i + "]/a/div[2]/div/h3")).toString());
		}	
	}

}
