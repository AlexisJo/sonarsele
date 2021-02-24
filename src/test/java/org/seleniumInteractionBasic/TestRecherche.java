package org.seleniumInteractionBasic;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRecherche {
	String ENV_NAVIGATEUR = "c";

	String jdd_mot_clef = "dog";
	String jdd_animal = "Bulldog";

	WebDriver driver;
	
	static Logger logger = LoggerFactory.getLogger(TestRecherche.class);

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://localhost:8090/jpetstore/");

		// Instanciation PageIndex
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);

		// Appel méthode clicSignIn() --> instanciation PageLogin
		PageLogin page_login = page_index.clicSignIn(driver);

		// Appel méthode seConnecter() --> instanciation PageAccueil
		PageAccueil page_accueil = page_login.seConnecter(driver, "j2ee", "j2ee");

		// Appel méthode rechercher() --> instanciation PageResultatRecherche
		PageResultatRecherche page_search = page_accueil.rechercher(driver, jdd_mot_clef);

		// clic sur le lien du produit
		driver.findElement(By.xpath("//a[contains(text(), 'dog')]")).click();
		

	}

	

		
		
}
