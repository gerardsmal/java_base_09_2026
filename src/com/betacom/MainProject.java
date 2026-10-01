package com.betacom;

import java.util.Scanner;

import com.betacom.process.AbstractProcess;
import com.betacom.process.BaseProcess;
import com.betacom.process.DateProcess;
import com.betacom.process.EnumProcess;
import com.betacom.process.EreditProcess;
import com.betacom.process.ExceptionProcess;
import com.betacom.process.InterfaceProcess;
import com.betacom.process.ListProcess;
import com.betacom.process.StringProcess;

public class MainProject {

	public static void main(String[] args) {
		System.out.println("Start MainProject");
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Funzione da eseguire [base, abstract :");
		String selected = "list";
		try {
		
			if (selected.trim().equalsIgnoreCase("base")) new BaseProcess().execute();
			if (selected.trim().equalsIgnoreCase("abstract")) new AbstractProcess().execute();
			if (selected.trim().equalsIgnoreCase("interface")) new InterfaceProcess().execute();
			if (selected.trim().equalsIgnoreCase("eredit")) new EreditProcess().execute();
			if (selected.trim().equalsIgnoreCase("string")) new StringProcess().execute();
			if (selected.trim().equalsIgnoreCase("exception")) new ExceptionProcess().execute();
			if (selected.trim().equalsIgnoreCase("enum")) new EnumProcess().execute();
			if (selected.trim().equalsIgnoreCase("date")) new DateProcess().execute();
			if (selected.trim().equalsIgnoreCase("list")) new ListProcess().execute();

		} catch (Exception e) {
			System.err.println("Error found in process :" + e.getMessage());
		}
	}

}
