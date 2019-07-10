package teste.commons;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Evidencias {

	protected WebDriver driver = TestRule.getDriver();
	private String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\evidencias";

	public Evidencias() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	private String path;

	public void setPathName(String className, String testName) {
		this.path = filePath + "\\" + className + "\\" + testName;
	}

	public String getPathName() {
		return this.path;
	}

	public void createPahClass() {
		File f = new File(getPathName());
		if (!f.exists()) {
			System.out.println("creating directory: " + f.getName());
			boolean result;

			try {
				f.mkdirs();
				result = true;
			} catch (SecurityException se) {
				System.out.println(se);
				result = false;
			}
			if (result) {
				System.out.println("DIR created");
			}
		} else {
			String[] myFiles;
			if (f.isDirectory()) {
				myFiles = f.list();
				for (int i = 0; i < myFiles.length; i++) {
					File myFile = new File(f, myFiles[i]);
					myFile.delete();
				}
			}
		}
	}

	public void takeScreenShot() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		Date date = new Date();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(getPathName() + "\\" + dateFormat.format(date) + ".jpg"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}

}
