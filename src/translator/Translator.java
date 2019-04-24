package translator;

import org.testng.annotations.Test;




public class Translator {
	
	
	public String finnishToEnglish(String source) throws Exception{
		return source;
		//WebDriver driver = new HtmlUnitDriver();
	
		
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://translate.google.co.in/#view=home&op=translate&sl=fi&tl=en");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("source")).sendKeys(source);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.
				elementToBeClickable(driver.findElement(By.cssSelector("div.tlid-results-container.results-container"))));
		WebElement ele = driver.findElement(By.cssSelector("div.tlid-results-container.results-container"));
		String text = "Translating...";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ele.getText();
		*/
	}
	
	
	
	
	@Test
	public void myTest() throws Exception{
		String x = finnishToEnglish("No, mutta hei! Tämäpä yllätys! Mitä kuuluu?");
		//System.out.println(x);
		
	}
	
	

}
