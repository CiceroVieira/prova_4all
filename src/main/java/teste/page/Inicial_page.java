package teste.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import teste.commons.TestRule;
import teste.path.Inicial_path;

public class Inicial_page extends Inicial_path {
	protected WebDriver driver = TestRule.getDriver();

	public Inicial_page() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void abrirSelectCategorias() {
		clickElement(abrirCategorias);
	}

	public void selecionarCategoria(String categoria) {
		switch (categoria) {
		case "Todos":
			clickElement(selecionarTodos);
			break;

		case "Bebidas":
			clickElement(selectionarBebidas);
			break;

		case "Doces":
			clickElement(selecionarDoces);
			break;

		case "Salgados":
			clickElement(selecionarSalgados);
			break;

		case "Pratos Quentes":
			clickElement(selecionarPratosQuentes);
			break;
		default:
			Assert.fail("Categoria invalida");
		}
	}

	public void irCarrinhoDeCompras() {
		clickElement(botaoCarrinho);
	}

	public void selecionarTodosProdutos() {
		if (quantidadeProdutosNaCategoria() == 0) {
			Assert.fail("Nenhum Produto para ser selecionado nesta categoria");
		} else {
			for (int i = 1; i <= quantidadeProdutosNaCategoria(); i++) {
				WebElement produto = driver.findElement(
						By.xpath("//*[@id='root']/div[2]/ul/li[" + i + "]//*[text()='Adicionar ao carrinho']"));
				clickElement(produto);
			}
		}
	}

	public int quantidadeProdutosNaCategoria() {
		return driver.findElements(By.xpath("//*[@id='root']/div[2]/ul/li")).size();
	}

	public void selecionarProduto(String produto) {
		clickElement(gerarIdAddProdutoCarrinho(produto));
	}

	public WebElement gerarIdAddProdutoCarrinho(String produto) {
		WebElement produtoId = driver
				.findElement(By.xpath("//*[ contains(text(),'" + produto + "') and @class='sc-EHOje kwbzOF']"));

		String id = "add-" + produtoId.getAttribute("data-id").replace("name", "btn");
		return driver.findElement(By.id(id));
	}

}