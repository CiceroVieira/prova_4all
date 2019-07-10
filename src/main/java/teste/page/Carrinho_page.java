package teste.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import teste.commons.TestRule;
import teste.path.Carrinho_path;

public class Carrinho_page extends Carrinho_path {

	protected WebDriver driver = TestRule.getDriver();

	public Carrinho_page() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public WebElement gerarIdPAddProduto(String produto) {
		String id = "add-" + getId(getElementByOnlyText(produto)).replace("name", "qtd");
		return driver.findElement(By.id(id));
	}

	public void addProdutoQtd(int qtd, String produto) {
		for (int i = 1; i < qtd; i++) {
			clickElement(gerarIdPAddProduto(produto));
		}
	}

	public WebElement gerarIdPRemoveProduto(String produto) {
		String id = "remove-" + getId(getElementByOnlyText(produto)).replace("name", "qtd");
		return driver.findElement(By.id(id));
	}

	public void removeProdutoQtd(int qtd, String produto) {
		for (int i = 1; i < qtd; i++) {
			clickElement(gerarIdPRemoveProduto(produto));
		}
	}

	public void finalizarPedido() {
		clickElement(botaoFinalizarCompra);
	}

	public void mensagemDeSucesso() {
		getElement(mensagemSucesso);
	}

	public void fechar() {
		clickElement(botaoFechar);
	}

	public double multiplicador(int qtd, double valor) {
		return qtd * valor;
	}

	public int qtdItensCarrinho() {
		return driver.findElements(By.xpath("//*[@id='root']/div[2]/div[2]/ul/li")).size() - 1;// -1 do li do subtotal
	}

	public String calculoTotal() {

		double soma = 0;

		for (int i = 1; i <= qtdItensCarrinho(); i++) {
			int qtd = 0;
			double valor = 0;
			WebElement detalhes = driver.findElement(By.xpath("//*/li[" + i + "]/div/div[@class='sc-fMiknA BpYZx']"));
			String id = getId(detalhes);
			String qtdId = id.replace("name", "qtd");
			String valorId = id.replace("name", "price");
			qtd = Integer.valueOf(driver.findElement(By.id(qtdId)).getText());
			valor = Double.parseDouble(driver.findElement(By.id(valorId)).getText().replace(",",".").replace("R$", ""));
			soma = soma + (multiplicador(qtd, valor));
		}
		
		System.out.println(soma);


		return "R$ "+soma+("0");
	}
	
	public  String valorTota() {
		return valorTotal.getText();
	}
	
	

}
