package teste.commons;



import org.openqa.selenium.WebElement;

public interface IMethods {

	public void selectElement(WebElement element, String option);

	public void typeElement(WebElement element, String option);

	public void clickElement(WebElement element);

	public void elementIsUsable(WebElement element);

	public WebElement getElement(WebElement element);


}
