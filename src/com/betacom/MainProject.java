package com.betacom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.process.AbstractProcess;
import com.betacom.process.BaseProcess;
import com.betacom.process.DateProcess;
import com.betacom.process.EnumProcess;
import com.betacom.process.EreditProcess;
import com.betacom.process.ExceptionProcess;
import com.betacom.process.GenericsProcess;
import com.betacom.process.InnerProcess;
import com.betacom.process.InterfaceProcess;
import com.betacom.process.ListProcess;
import com.betacom.process.MapProcess;
import com.betacom.process.SequentialProcess;
import com.betacom.process.SingleTonProcess;
import com.betacom.process.StringProcess;
import com.betacom.singleton.SingleTonSample;

public class MainProject {
	private static final Logger log = LoggerFactory.getLogger(MainProject.class);
	
	public static void main(String[] args) {
		
		log.info("Start MainProject");
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Funzione da eseguire [base, abstract :");
		String selected = "inner";
		
		Map<String, GeneralInterface> pr = new HashMap<String, GeneralInterface>();
		pr.put("base",      new BaseProcess());
		pr.put("abstract",  new AbstractProcess());
		pr.put("interface", new InterfaceProcess());
		pr.put("eredit",    new EreditProcess());
		pr.put("string",    new StringProcess());
		pr.put("exception", new ExceptionProcess());
		pr.put("enum",      new EnumProcess());
		pr.put("date",      new DateProcess());
		pr.put("list",      new ListProcess());
		pr.put("map",       new MapProcess());
		pr.put("singleton", new SingleTonProcess());
		pr.put("sequential",new SequentialProcess());
		pr.put("generics",new GenericsProcess());
		pr.put("inner",new InnerProcess());
				
		if (pr.containsKey(selected)) {
			GeneralInterface ex = pr.get(selected);
			try {
				ex.execute();
			} catch (Exception e) {
				log.error("Error found in process :" + e.getMessage());
			}			
		} else 
			throw new AcademyException("Process non previsto");	
		
	}

}
