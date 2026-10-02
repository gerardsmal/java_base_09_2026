package com.betacom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.betacom.exception.AcademyException;
import com.betacom.interfaces.GeneralInterface;
import com.betacom.process.AbstractProcess;
import com.betacom.process.BaseProcess;
import com.betacom.process.DateProcess;
import com.betacom.process.EnumProcess;
import com.betacom.process.EreditProcess;
import com.betacom.process.ExceptionProcess;
import com.betacom.process.InterfaceProcess;
import com.betacom.process.ListProcess;
import com.betacom.process.MapProcess;
import com.betacom.process.SingleTonProcess;
import com.betacom.process.StringProcess;
import com.betacom.singleton.SingleTonSample;

public class MainProject {

	public static void main(String[] args) {
		System.out.println("Start MainProject");
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Funzione da eseguire [base, abstract :");
		String selected = "singleton";
		
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
				
		if (pr.containsKey(selected)) {
			GeneralInterface ex = pr.get(selected);
			try {
				ex.execute();
				Integer i = SingleTonSample.getInstance().computeInteger();
				System.out.println("Valore di idx chiamato del main:" + i);
			} catch (Exception e) {
				System.err.println("Error found in process :" + e.getMessage());
			}			
		} else 
			throw new AcademyException("Process non previsto");	
		
	}

}
