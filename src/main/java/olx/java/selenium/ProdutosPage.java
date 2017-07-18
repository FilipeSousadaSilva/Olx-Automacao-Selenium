package olx.java.selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutosPage {
	private WebDriver driver;
	public ProdutosPage(WebDriver driver) {
        this.driver = driver;
    }
	public void visita() {
        driver.get("http://sp.olx.com.br");
    }

    public void pesquisa() {
    	WebElement ParamPesquisa = driver.findElement(By.id("searchtext"));
		ParamPesquisa.sendKeys("xbox");
		WebElement BotaoPesquisa = driver.findElement(By.id("searchbutton"));
		BotaoPesquisa.click();
    }

    public void paginacao() throws Exception { // vai para a página 2
    	WebElement BotaoPagina = driver.findElement(By.linkText("2"));
		BotaoPagina.click();
		Thread.sleep(3000);
		WebElement LinkProduto =  driver.findElement(By.xpath("//a/div[2]/div/h3"));
		LinkProduto.click();
    }
    public void imprimirProdutosPesquisa() throws Exception {
		Thread.sleep(8000);
		int contador =  7;
		for(int i=1; i<=contador; i++){ //identifica preço e título
			if (i != 3){
				System.out.println(driver.findElement(By.xpath("//li[" + i + "]/a/div[3]/p")).getText());
				System.out.println(driver.findElement(By.xpath("//li[" + i + "]/a/div[2]/div/h3")).getText());
			}else {i++;}
		}
		Thread.sleep(5000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\imagens\\screenshot1.png"), true);
	}
}