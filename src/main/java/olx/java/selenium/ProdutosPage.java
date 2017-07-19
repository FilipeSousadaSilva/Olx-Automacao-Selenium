package olx.java.selenium;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ProdutosPage {
	private WebDriver driver;
	public ProdutosPage(WebDriver driver) {
        this.driver = driver;
    }
	public void visitar() {
        driver.get("http://sp.olx.com.br");
    }

    public void pesquisar() {
    	WebElement ParamPesquisa = driver.findElement(By.id("searchtext"));
		ParamPesquisa.sendKeys("xbox");
		WebElement BotaoPesquisa = driver.findElement(By.id("searchbutton"));
		BotaoPesquisa.click();
    }

    public void acessarItemSegundaPagina() throws Exception { // vai para a página 2
    	WebElement BotaoPagina = driver.findElement(By.linkText("2"));
		BotaoPagina.click();
		WebElement LinkProduto =  driver.findElement(By.xpath("//a/div[2]/div/h3"));
		aguardarPresencaElemento("//a/div[2]/div/h3");
		LinkProduto.click();
    }
    public void imprimirProdutosPesquisa() throws Exception {
    	Thread.sleep(7000);
    	List<WebElement> elements = driver.findElements(By.xpath("//*[@id='main-ad-list']//a[contains(@class,'OLXad-list-link')]"));
        int contador = 0;
    	for (WebElement elem : elements) {
          contador++;
          System.out.println(elem.findElement(By.xpath(".//h3")).getText());
          System.out.println(elem.findElement(By.xpath(".//p[contains(@class,'OLXad-list-price')]")).getText());
          if (contador == 5){
        	  break;
          } 
        }
        Thread.sleep(8000);
		//int contador = 10; //Contador para exibir os 5 primeiros títulos e preços da lista
        //for (int i=0; i<=contador; i++){
        	//System.out.println(elements.get(i));
        //}
	}
    
    public void aguardarPresencaElemento(String elementXpath) { 
    	FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
    	    .withTimeout(30, TimeUnit.SECONDS)
    	    .pollingEvery(200, TimeUnit.MILLISECONDS)
    	    .ignoring(NoSuchElementException.class);
    	fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
    }
    
    public void printarTela() throws Exception{
    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\imagens\\screenshot1.png"), true);
    }
}