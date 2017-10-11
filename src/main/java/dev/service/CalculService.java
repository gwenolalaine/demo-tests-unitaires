package dev.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exceptions.CalculException;

public class CalculService {
	private static final Logger LOG = LoggerFactory.getLogger(CalculService.class);
	
	public int additionner(String expression) {	
		LOG.debug("Evaluation de l'expression " + expression);
		
		String nums[] = expression.split("\\+");
		try{
			return Arrays.stream(nums).mapToInt(s->Integer.parseInt(s)).sum();
		}catch(Exception e){
			throw new CalculException("L’expression " + expression + " est invalide.");
		}
	}
}
