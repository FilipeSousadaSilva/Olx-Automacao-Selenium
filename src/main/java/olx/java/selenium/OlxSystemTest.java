package olx.java.selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlxSystemTest  {
	
	private WebDriver driver;
    private ProdutosPage produtos;
    
    @Before
    public void inicializar() {
    	System.setProperty("webdriver.chrome.driver","C:/users/filip/Downloads/chromedriver.exe ");
    	this.driver =  new ChromeDriver();
        this.produtos = new ProdutosPage(driver);
    }
    
	@Test
    public void pesquisarProdutoEImprimeResultados() throws Exception{
		produtos.visitar();
		produtos.pesquisar();
		produtos.imprimirProdutosPesquisa();
	}
	
	@Test
	public void acessarSegundaPaginaEPrintarProduto() throws Exception{
		produtos.visitar();
		produtos.pesquisar();
		produtos.acessarItemSegundaPagina();
		produtos.printarTela();
	}
	
	@After
    public void encerrarBrowser() {
        driver.close();
    }
}