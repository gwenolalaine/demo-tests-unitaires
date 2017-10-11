package dev.console;

import dev.exceptions.CalculException;
import dev.service.CalculService;
import dev.service.CalculServiceTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.mockito.Mockito.*;

import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
	private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

	@Rule
	public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	private App app;
	private CalculService calculService;

	@Before
	public void setUp() throws Exception {
		Scanner sc = new Scanner(System.in);

		this.calculService = new CalculService();
		this.app = new App(sc, calculService);
	}

	@Test
	public void testAfficherTitre() throws Exception {
		this.app.afficherTitre();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("**** Application Calculatrice ****");
	}

	@Test
	public void testUserInput() {
		systemInMock.provideLines("fin");
		this.app.demarrer();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("Aurevoir :-(");
	}

	@Test
	public void testUserInput1() {
		systemInMock.provideLines("1+2", "fin");
		this.app.demarrer();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("3");
	}

	@Test(expected = CalculException.class)
	public void testUserInput2() {
		systemInMock.provideLines("AAAA");
		this.app.demarrer();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("L'expression AAAA est invalide");
	}
	
	@Test
	public void testUserInput3() {
		systemInMock.provideLines("1+2", "30+2", "fin");
		this.app.demarrer();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("3", "32");
	}
}