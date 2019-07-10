package teste.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import Test.Evidencias;

public class Methods {
	protected WebDriver driver = TestRule.getDriver();

	public Methods() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public WebElement highlightElement(WebElement element) { // mostra em verde o elemento que recebeu a ação
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='4px solid black'", element);
		}
		return element;
	}

	public WebElement getElement(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			return highlightElement(element);

		} else {
			Assert.fail("Elemento não esta disponivel");
		}
		return element;

	}

	public void typeElement(WebElement element, String valor) {
		WebElement ele = getElement(element);
		try {
			ele.clear();
			ele.sendKeys(valor);

		} catch (Exception e) {
			Assert.fail("Elemento não esta disponivel");
		}

	}

	public void simpleType(WebElement ele, String valor) {
		ele.clear();
		ele.sendKeys(valor);
	}

	public void clickElement(WebElement element) {
		try {

			getElement(element).click();

		} catch (Exception e) {

			Assert.fail("Erro ao clicar no elemento -> " + element + "\n Erro : " + e);

		}

	}

	public void selectElement(WebElement element, String valor) {
		Select select = new Select(getElement(element));

		try {
			select.selectByVisibleText(valor);
		} catch (Exception e) {
			Assert.fail("Erro ao selecionar o opção      -> " + e);
		}
	}

	public String getnameElement(WebElement element) {
		return element.getText();
	}

	public WebElement getElementByOnlyText(String text) {
		return driver.findElement(By.xpath("//*[ contains(text(),'" + text + "')]"));
	}

	public String getId(WebElement element) {
		return element.getAttribute("id");
	}

}
