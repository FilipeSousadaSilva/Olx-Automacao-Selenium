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
    public void inicializa() {
    	System.setProperty("webdriver.chrome.driver","C:/users/filip/Downloads/chromedriver.exe ");
    	this.driver =  new ChromeDriver();
        this.produtos = new ProdutosPage(driver);
    }
    
	@Test
    public void pesquisaProdutoEImprimeResultados() throws Exception{
		produtos.visita();
		produtos.pesquisa();
		produtos.imprimirProdutosPesquisa();
	}
	
	@Test
	public void acessaSegundaPagina() throws Exception{
		produtos.visita();
		produtos.pesquisa();
		produtos.paginacao();
	}
	
	@After
    public void encerraBrowser() {
        driver.close();
    }
}