package com.betacom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainProjectDynamic {
	private final static String PATH_PROCESS = "com.betacom.process";

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Funzione da eseguire [base, abstract :");
		String selected = "serializzable";
		log.info("MainProject is ready to execute {}", selected);
		try {
			GeneralInterface ex  = (GeneralInterface) loadProcess(selected);			
			executeOperation(ex);
			log.info("MainProject is ended");
		} catch (Exception e) {
			log.error("error found {}", e.getMessage());
		}
		
	}

	
	private static Object loadProcess(String name) throws Exception {
		try {
			Class<?> cl = Class.forName(PATH_PROCESS + "." + Utilities.buildClassName(name));
			Object obj = cl.getDeclaredConstructor().newInstance();
			return obj;
		} catch (ClassNotFoundException e) {
			throw new AcademyException("Process non previsto " + name);
		}
	}
	
	private static void executeOperation(GeneralInterface myProcess) throws Exception{
		try {
			Method method = myProcess.getClass().getMethod("execute");
			method.invoke(myProcess);
			
		} catch (SecurityException e) {
			throw new AcademyException("errore di sucurezza: " + e.getMessage());
		} catch (IllegalAccessException e) {
			throw new AcademyException("errore di IllegalAccess: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new AcademyException("errore di IllegalArgument: " + e.getMessage());
		} catch (InvocationTargetException e) {
			throw new AcademyException(e.getCause().getMessage());
		}catch (NoSuchMethodException e) {
			throw new AcademyException("metodo execute non trovato");
		}
		
		
	}

}
