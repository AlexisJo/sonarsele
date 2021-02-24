package org.seleniumInteractionBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageLogin extends AbstractPageBandeau{
	Logger logger = LoggerFactory.getLogger(PageLogin.class);
	@FindBy (name="username")
	WebElement champ_username;
	@FindBy (name="password")
	WebElement champ_password;
	@FindBy (name="signon")
	WebElement btn_submit;
	@FindBy (xpath="//a[contains(@href, 'signon')]")
	WebElement log_in;

	public PageAccueil seConnecter(WebDriver driver, String username, String password) {
		log_in.click();
		logger.info("Utilisation méthode seConnecter() avec les parametres "+username+"/"+password);
		SocleTechnique.renseignerChamps(champ_username, username);
		SocleTechnique.renseignerChamps(champ_password, password);
		btn_submit.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
}
