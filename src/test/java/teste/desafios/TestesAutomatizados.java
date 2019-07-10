package teste.desafios;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import teste.commons.Evidencias;
import teste.commons.TestRule;
import teste.page.Carrinho_page;
import teste.page.Inicial_page;

public class TestesAutomatizados {

	String className = getClass().getName();
	@Rule
	public TestName name = new TestName();

	@Before
	public void startTest() {
		TestRule.openApplication("Chrome", "https://shopcart-challenge.4all.com/"); // 
	}

	@Test
	public void desafio01() throws Exception {
		Inicial_page inicial = new Inicial_page();
		Carrinho_page carrinho = new Carrinho_page();
		Evidencias Evidencias = new Evidencias();
		Evidencias.setPathName(className, name.getMethodName());
		Evidencias.createPahClass();

		inicial.abrirSelectCategorias();
		Evidencias.takeScreenShot();

		inicial.selecionarCategoria("Doces");
		Evidencias.takeScreenShot();

		inicial.selecionarTodosProdutos();
		Evidencias.takeScreenShot();

		inicial.abrirSelectCategorias();
		Evidencias.takeScreenShot();

		inicial.selecionarCategoria("Todos");
		Evidencias.takeScreenShot();

		inicial.irCarrinhoDeCompras();
		Evidencias.takeScreenShot();

		carrinho.addProdutoQtd(4, "Brigadeiro"); // quantidade =4 , produto = brigadeiro
		Evidencias.takeScreenShot();

		carrinho.finalizarPedido();
		Evidencias.takeScreenShot();

		carrinho.mensagemDeSucesso();
		Evidencias.takeScreenShot();

		carrinho.fechar();

	}

	@Test
	public void desafio02() throws Exception {
		Inicial_page inicial = new Inicial_page();
		Carrinho_page carrinho = new Carrinho_page();
		Evidencias Evidencias = new Evidencias();
		Evidencias.setPathName(className, name.getMethodName());
		Evidencias.createPahClass();

		inicial.abrirSelectCategorias();
		Evidencias.takeScreenShot();

		inicial.selecionarCategoria("Bebidas");
		Evidencias.takeScreenShot();

		inicial.selecionarTodosProdutos();
		Evidencias.takeScreenShot();

		inicial.abrirSelectCategorias();
		Evidencias.takeScreenShot();

		inicial.selecionarCategoria("Todos");
		Evidencias.takeScreenShot();

		inicial.selecionarProduto("Rissole médio");
		Evidencias.takeScreenShot();

		inicial.irCarrinhoDeCompras();
		Evidencias.takeScreenShot();

		carrinho.addProdutoQtd(9, "Rissole médio"); // quantidade =4 , produto = brigadeiro
		Evidencias.takeScreenShot();

		carrinho.removeProdutoQtd(5, "Rissole médio");
		Evidencias.takeScreenShot();

		Assert.assertEquals(carrinho.valorTota(), carrinho.calculoTotal().replace(".", ","));

		carrinho.finalizarPedido();
		Evidencias.takeScreenShot();

		carrinho.mensagemDeSucesso();
		Evidencias.takeScreenShot();

		carrinho.fechar();

	}

	@After
	public void closeSection() {
		TestRule.afterCenario();
	}

}
