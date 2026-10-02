package com.betacom.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.betacom.interfaces.GeneralInterface;

public class MapProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		System.out.println("Begin MapProcess");
		
		Map<String, String> map = createMap();
		
		System.out.println("numero elementi create nella map :" + map.size());
		
		String keySearch = "k4";
		String value = null;
		if (map.containsKey(keySearch)) {
			value = map.get(keySearch);
			System.out.println("valore trovato per " + keySearch + " = " + value);
		} else
			System.out.println("Key " + keySearch + " non trovata");
		
		value = "v10";
		if (map.containsValue(value))
			System.out.println("valore trovato " +  value);
		else
			System.out.println("Valore non trovata :" + value );
		
		System.out.println("Valore di k6:" + map.get("k6")  + " length:" + map.size());
		map.put("k6", "v6 modificato");
		System.out.println("Valore di k6:" + map.get("k6")  + " length:" + map.size());
		
		System.out.println("List map with entry");
		for (Entry<String, String> it:map.entrySet()) {
			System.out.println("key:" + it.getKey() + " valore:" + it.getValue());
		}
		
		System.out.println("List map witj keySet");
		for (String it:map.keySet()) {
			System.out.println("key:" + it + " value:" + map.get(it));
		}
		
		casoUso1();
		casoUso2();
	}

	private void casoUso1() {
		String param = "p1=aaa, p2 = 888, p3= 24,p4 = Paolo";
		String[] p = param.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String it:p) {
			String[] elem = it.split("=");
			map.put(elem[0].trim(), elem[1].trim());
		}
		System.out.println("Result param transformato in map");
		for(String it:map.keySet()) {
			System.out.println("key:" + it + " value:" + map.get(it));
		}
	}
	
	private void casoUso2() {
		List<String> input = new ArrayList<String>();
		input.add("p1=aaa, p2 = 888, p3= 24,p4 = Paolo");
		input.add("par1 = 10, par2=abcd, par3=s4");
		input.add("id = 10, nome=pippo, cognome=verde");
		input.add("k1 =primo, k2=secondo, k3=terzo");
			
		
		List<Map<String, String>> res = new ArrayList<Map<String,String>>();
		
		for (String inp:input) {
			String[] par1 = inp.split(",");
			Map<String, String> colum = new HashMap<String, String>();
			for (String it:par1) {
				String[] elem = it.split("=");
				colum.put(elem[0].trim(),elem[1].trim());
			}
			res.add(colum);
		}
		System.out.println("Risultato casoUso2 .....");
		int i = 0;
		for (Map<String, String> elem:res) {
			System.out.println("map numero " + ++i);
			for(String it:elem.keySet()) {
				System.out.println("key:" + it + " value:" + elem.get(it));
			}
		}
		
		
	}
	
	
	private Map<String, String> createMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k6", "v6");
		map.put("k5", "v5");
		map.put("k7", "v7");
		map.put("k8", "v8");
		map.put("k9", "v9");
		map.put("k10", "v10");
		map.put("k11", "v11");
		map.put("k12", "v12");
		map.put("k13", "v13");
		map.put("k14", "v14");
			
		return map;
	}

}
