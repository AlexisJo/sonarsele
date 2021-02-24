package org.seleniumInteractionBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;

public class SocleTechnique {

	public static void renseignerChamps(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}

	public static boolean isElementPresent(WebElement we, Logger log) {
		boolean resultat = we.isDisplayed();
		if (resultat == false) {
			log.error(we + " indisponible");
		} else {
			log.info(we + " présent");
		}
		return resultat;
	}

	public static int retournerNumeroDeLigne(List<WebElement> liste_lignes, String valeur_connue) {
		int numero_de_ligne = 1;
		for (WebElement ligne : liste_lignes) {
			System.out.println(numero_de_ligne);
			List<WebElement> liste_cellules = ligne.findElements(By.xpath("td"));
			for (WebElement cellule : liste_cellules) {
				if (cellule.getText().equals(valeur_connue)) {
					System.out.println("J'ai trouvé ! " + numero_de_ligne);
					return numero_de_ligne;
				}
			}
			numero_de_ligne++;
		}
		return -1;
	}

}
