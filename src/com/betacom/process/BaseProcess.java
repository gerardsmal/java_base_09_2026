package com.betacom.process;

import java.util.ArrayList;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.User;
import com.betacom.utils.PromozioneAutomatica;



public class BaseProcess implements GeneralInterface{
	
	@Override
	public void execute() {
		System.out.println("Begin BaseProcess");
		
		/*
		 * nome       bit   byte      range valore
		 * byte       0     1         -127 +127
		 * int        32    4         +/-  2*10 **9 
		 * short      16    2         +/-  32768  
		 * long       64    8         +/- 9*10 ^18
		 * float      32    4         340282347 - 10 ** 38  7 ciffre dopo l virgola
		 * double     64    4                               15 ciffre dopo la virgola
		 */
		byte b = 127;
		int  i = 2_000_000_000;
		short w = 32767;
		long l = 12345678;
		double d = 123344;
		boolean bool = true;
		char c = 'a';
		
		
		System.out.println(-Float.MAX_VALUE);
		
		String str = "Ciao sono una string" + "\n";

//		System.err.print(str);
//		System.err.print(str);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Nome");
//		String nome = sc.next();
//		System.out.println("Valore di nome :" + nome);
		
		int eta = 33;
		String result = "";
		if (eta < 30) {
			result = "Sonos un ragazzino";
		}
		else
			result = "Sonos un vechietto";
		
		System.out.println(result);

		eta =22;
		result = (eta < 30) ? "Sono un ragazzino" : "Sono un vechietto";
		System.out.println(result);
		
		/*
		 * operatri aritmetici
		 * 
		 * + - / * %
		 * 
		 */
		
		i = 30;
		i++;
		System.out.println("Valore di i:"+ i);
		

		i--;
		System.out.println("Valore di i:"+ i);
		
		int j= 3;
		int res = i * j;
		System.out.println("Valore di res:"+ res);
		res++;
		int div = res /2;
		int rim = res % 2;
		
		System.out.println("Valore di res:" + res +
				" valore di div;" + div +
				" valore di rim;" + rim 
				);
		
		String param = "123456";
		long it = Long.parseLong(param) / 2;
		System.out.println("Valor di param / 2 -->" + it);
		
		
		param = "sklkdorrkmfodmff fmfkfkffklf ffkkfkfkf ffklkfkfkfkfewwksk";
		System.out.println("Param length:" + param.length() + " part of string:" + param.substring(4, 8));
		
		
		param = "      inizio Academy Java      ";
		System.out.println("[" + param.trim() + "]");
		
		String search = "   Academy    ";
		if (param.trim().contains(search.trim()))
			System.out.println("String " + search.trim() + " trovata");
		else
			System.out.println("String " + search.trim() + " NON trovata");
			
		/*
		 * array
		 */
		String[] array = {"primo", "secondo", "terzo", "quarto"};
		
		array[3] =  "quinto";
		
		for (int id=0;id < array.length; id++) {
			System.out.println("id:" + id + " valore:" + array[id] + " String length:" + array[id].length());
		}
		
		int zz = 0;
		for(String item:array) {
			System.out.println(zz + "/" +item);
			zz++;
		}
		
		Integer[] numeri = {10,20, null, 40, 50, 60};
		for (Integer  item : numeri) {
			System.out.println(item);
		}
		
		String [] [] multi = new String[3] [4];
		/*
		 * array 2d
		 */
		for (int id=0; id < multi.length; id++) {
			for (int jd = 0; jd < multi[id].length; jd++) {
				multi[id] [jd] = "prova_" + id + "_" +jd;

			}
		}
		System.out.println("id 2 , jd 3:" + multi[1] [3]);
		
		/*
		 * Array dimamiche
		 */
		ArrayList<String> aL = new ArrayList<String>();
		aL.add("Pietro");
		aL.add("Anna");
		aL.add("Angelo");
		aL.add("Maria");
		
		System.out.println("Numero elementi:" + aL.size());
		
		aL.add("Luca");
		
		
		
		for (String item:aL) {
			System.out.println(item);
		}
		aL.remove(3);
		
		System.out.println("al (3)" + aL.get(3));
		
		ArrayList<User> lU = new ArrayList<User>();
		lU.add(new User("Paolo", "Filo", true));
		lU.add(new User("Anna", "Bainca", false));
		lU.add(new User("Angelo", "Brindo", true));
		lU.add(new User("Maria", "Labella", false));
		lU.add(new User("Gianni", "Lavedura", true));
		lU.add(new User("anna", "Cialo", false));
		lU.add(new User("Andrea", "Depare", true));
		
		User us = new User();
		us.setCognome("Rossi");
		us.setNome("aNNa");
		us.setSesso(false);
		lU.add(us);
		
		search = "anna";
		for (User item:lU) {
			if (item.getNome().equalsIgnoreCase(search)) {
				System.out.println(item);
			}
			
		}
		
		PromozioneAutomatica.metodo(10);
		PromozioneAutomatica.metodo(2.0f);
		PromozioneAutomatica.metodo("aaaaa");
		
		System.out.println("Numero utente:" + PromozioneAutomatica.NUMER_UTENTE);
	}

}
