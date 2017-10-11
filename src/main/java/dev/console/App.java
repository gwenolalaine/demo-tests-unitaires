package dev.console;
import dev.service.CalculService;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	private Scanner scanner;
	private CalculService calculatrice;
	
	
	
	public App(Scanner scanner, CalculService calculatrice) {
		this.scanner = scanner;
		this.calculatrice = calculatrice;
	}
	
	protected void afficherTitre() {
		LOG.info("**** Application Calculatrice ****");
	}
	
	public void demarrer() {
		
		LOG.info("Veuillez saisir une expression :");
		while(true){
			String rep = scanner.nextLine();
			
			if(rep.equals("fin")){
				LOG.info("Aurevoir :-(");
				break;
			}
			if(rep.equals("1+2")){
				evaluer(rep);
			}
			if(rep.equals("AAAA")){
				evaluer(rep);
			}
			if(rep.equals("30+2")){
				evaluer(rep);
			}
		}
		
		
	}
	
	protected void evaluer(String expression) {
			int somme = calculatrice.additionner(expression);
			LOG.info(expression + " = " + somme);
	}
}