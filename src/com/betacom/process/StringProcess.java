package com.betacom.process;

import java.util.StringTokenizer;

import com.betacom.interfaces.GeneralInterface;

public class StringProcess implements GeneralInterface{

	@Override
	public void execute() {
		System.out.println("Begin StringProcess");
		
		String nome = "Gérard";
		
		StringBuilder sb = new StringBuilder();
		sb.append("Buongiorno");
		sb.append(", ");
		sb.append("sono ");
		sb.append(nome);
		
		String res = sb.toString();
		System.out.println(res);
		
		/*
		 * String format
		 */
		String n = "francese";
		res = String.format("Mio nome é %s, sono %s.", nome, n);
		
		System.out.println(res);
		
		if ("gérard".equalsIgnoreCase(nome))
			System.out.println("found");
		else
			System.out.println("not found");
		
		if (res.contains("sono"))
			System.out.println("found sono");
		
		res = "        ".trim();
		if (res.isEmpty())
			System.out.println("res é vuoto");
		
		/*
		 * String compare
		 */
		String s1 = "Samsung";
		String s2 = "Samsung1";
		
		int result = s2.compareTo(s1);
		System.out.println("Result compare:" + result);
		
		/*
		 * transform integer to string
		 */
		
		result = 123;
		String numeroStr = String.valueOf(result);
		System.out.println("numeroStr :" + numeroStr.substring(2));
		result = Integer.parseInt(numeroStr.substring(1));
		System.out.println("Valore di result: " + result);
		
		
		/*
		 * trasformazione String to array
		 */
		String parameters = "token1, token2 , token3, token4,  token5";
		String[] tokens = parameters.split(",");
		for (String it:tokens) {
			System.out.println("->" + it + "<-");
		}
		
		/*
		 * StringTokenizer
		 */
		System.out.println("StringTokenizer");
		StringTokenizer st = new StringTokenizer(parameters, ",");
		while (st.hasMoreElements()) {
			String txt = st.nextToken().trim();
			System.out.println("->" + txt + "<-");
		}
		
		/*
		 * Substring
		 */
		res = String.format("Mio nome é %s, sono %s.", nome, n);
		System.out.println(res.substring(res.indexOf("G")));
		System.out.println(res.substring(res.indexOf("G"), res.indexOf(",")));
		/*
		 * replacing
		 */
		String prova = "         questa é un test per ££ , vediamo il risultato in ££";
		String prova1 = prova.replaceAll("££", "Java").trim();
		
		System.out.println(prova1);
		
	}

}
