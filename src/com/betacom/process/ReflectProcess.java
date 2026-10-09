package com.betacom.process;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectProcess implements GeneralInterface{
	private static final int CONTRUCTOR_TO_SELECT = 3;
	@Override
	public void execute() throws Exception {
		log.info("Begin ReflectProcess");
		
		String packageName = "com.betacom.objects";
		String className   = "MyClassReflection";
		
		Class cl = Class.forName(packageName + "." + className);
		log.debug("Class {} found", className);
		
		/*
		 * retrieve contructors for selected class
		 */
		
		Constructor[] ctore = cl.getConstructors();
		Constructor   ctoreSelected = null;
		
		
		log.debug("numero di contructors trovata: {}", ctore.length);		
		for (Constructor ctoreDetaglio: ctore) {
			log.debug("numero parametri trovato {}", ctoreDetaglio.getParameterCount());
			if (ctoreDetaglio.getParameterCount() == CONTRUCTOR_TO_SELECT) {
				ctoreSelected = ctoreDetaglio;
			}
			/*
			 * retrieve parameter type by constructor
			 */
			Type[] types = ctoreDetaglio.getGenericParameterTypes();
			for (Type type:types) {
				log.debug("......... tipo parametro : {}", type);
			}	
		}
		if (ctoreSelected == null) {
			throw new AcademyException("no constructor found with " + CONTRUCTOR_TO_SELECT + " paramters");
		}
		
		Object myClass = newInstanceObject(ctoreSelected);
		introspectionMethod(myClass);
		
	}
	/*
	 * new instance
	 */
	private Object newInstanceObject(Constructor ctoreSelected) throws Exception{
		if (ctoreSelected == null) {
			throw new AcademyException("no constructor found with " + CONTRUCTOR_TO_SELECT + " paramters");
		}
		Object myClass = null;
		if (CONTRUCTOR_TO_SELECT == 0) {
			myClass = ctoreSelected.newInstance();
			log.debug("new instant senza parametri");
		}
		if (CONTRUCTOR_TO_SELECT == 2) {
			myClass = ctoreSelected.newInstance(18, "due parametri");
			log.debug("new instant con 2 parametri");
		}
		if (CONTRUCTOR_TO_SELECT == 3) {
			myClass = ctoreSelected.newInstance(20, "tre parametri", 300);
			log.debug("new instant con 3 parametri");
		}
		return myClass;
	}
	
	
	/*
	 * introspection method
	 */
	private void introspectionMethod(Object myClass) throws Exception{
		Method[] methods = myClass.getClass().getMethods();
		for (Method method:methods) {
			if ("setId".equals(method.getName())) {
				log.debug(".......... method trovato {}", method.getName());
				method.invoke(myClass, 34);
			}
			if ("setDesc".equals(method.getName())) {
				log.debug(".......... method trovato {}", method.getName());
				method.invoke(myClass, "descrizione caricata con reflection");
			}
			if ("setP1".equals(method.getName())) {
				log.debug(".......... method trovato {}", method.getName());
				method.invoke(myClass, 1233333);
			}
			if ("getId".equals(method.getName())) {
				log.debug(".......... method trovato {}", method.getName());
				log.debug("Valore caricata: {}", method.invoke(myClass));
			}
			if ("getDesc".equals(method.getName())) {
				log.debug(".......... method trovato {}", method.getName());
				log.debug("Valore caricata: {}", method.invoke(myClass));
			}
			if ("getP1".equals(method.getName())) {
				log.debug(".......... method trovato {}", method.getName());
				log.debug("Valore caricata: {}", method.invoke(myClass));
			}			
			
		}
		String metodoName = "toString";
		Method method = myClass.getClass().getMethod(metodoName);
		String msg = (String) method.invoke(myClass);
		
		log.debug(metodoName + " : {}", msg);
		
		throw new AcademyException("errore nel process simulate");
	}
	
	

}
