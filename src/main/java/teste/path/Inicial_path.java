package teste.path;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import teste.commons.Methods;

public class Inicial_path extends Methods {

	@FindBy(id = "open-categories-btn")
	protected WebElement abrirCategorias;

	@FindBy(id = "category-all")
	protected WebElement selecionarTodos;

	@FindBy(xpath = "//*[ contains(text(),'Bebidas') and @class='sc-jKJlTe epkryB']")
	protected WebElement selectionarBebidas;

	@FindBy(xpath = "//*[ contains(text(),'Doces') and @class='sc-jKJlTe epkryB']")
	protected WebElement selecionarDoces;

	@FindBy(xpath = "//*[ contains(text(),'Salgados') and @class='sc-jKJlTe epkryB']")
	protected WebElement selecionarSalgados;

	@FindBy(xpath = "//*[ contains(text(),'Pratos Quentes') and @class='sc-jKJlTe epkryB']")
	protected WebElement selecionarPratosQuentes;

	@FindBy(id = "cart-btn")
	protected WebElement botaoCarrinho;

}
