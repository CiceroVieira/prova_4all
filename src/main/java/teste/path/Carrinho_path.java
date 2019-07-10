package teste.path;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import teste.commons.Methods;

public class Carrinho_path extends Methods {

	@FindBy(id = "finish-checkout-button")
	protected WebElement botaoFinalizarCompra;

	@FindBy(xpath = "//*[ contains(text(),'Pedido realizado com sucesso!') and @class='sc-dNLxif jyncPa']")
	protected WebElement mensagemSucesso;

	@FindBy(xpath = "//button[ contains(text(),'Fechar')]")
	protected WebElement botaoFechar;

	@FindBy(id = "price-total-checkout")
	protected WebElement valorTotal;

}
