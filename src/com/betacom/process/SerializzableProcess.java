package com.betacom.process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Address;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SerializzableProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.info("Begin SerializzableProcess");
		
		Address a = new Address();
		a.setCity("Roma");
		a.setName("Vincenzio Rossi");
		a.setStreet("Vai della Rosa, 25");
		a.setSesso(true);
		a.setDesc("mia descrizione");
		a.setPwd("aaaaaa");
		
		try(FileOutputStream fout = new FileOutputStream("/Users/gerard/Downloads/address.txt")){
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(a);
			oos.close();
			
			
			log.info("end of SerializzableProcess");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
