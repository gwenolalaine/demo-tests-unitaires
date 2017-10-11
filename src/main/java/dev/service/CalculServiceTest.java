package dev.service;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exceptions.CalculException;
/**
* Test unitaire de la classe dev.service.CalculService.
*/
public class CalculServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);

	@Test
	public void testAdditionner() throws Exception {
		LOG.info("Etant donné, une instance de la classe CalculService");
		
		CalculService calculService = new CalculService();
		
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4");
		
		
		int somme = calculService.additionner("1+3+4");
		LOG.info("Alors j'obtiens le résultat 8");
		assertThat(somme).isEqualTo(8);



	}
	
	@Test(expected = CalculException.class)
	public void testAdditionnerNonPassant() throws Exception {
		LOG.info("Etant donné, une instance de la classe CalculService");
		
		CalculService calculService = new CalculService();
		
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4");
		
		
		int somme = calculService.additionner("dodo");
		LOG.info("Alors j'obtiens le résultat 8");
		assertThat(somme).isEqualTo(8);


	}
}