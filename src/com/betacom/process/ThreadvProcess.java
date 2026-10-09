package com.betacom.process;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.threads.MyFirstThread;
import com.betacom.threads.MySecondThread;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ThreadvProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.debug("Begin Thread Virtuals Process");
		
		Thread primo = Thread.ofVirtual()
				.name("MyFirstVirtualThread")
				.unstarted(new MyFirstThread());
		
		
		MySecondThread t2 = new MySecondThread();	
		
		
		Thread secondo = Thread.ofVirtual()
				.name("MySecondVirtualThread")
				.unstarted(t2);
		
		log.debug("before start - primo state: {}",primo.getState());
		log.debug("before start - secondo state: {}",secondo.getState());
		
		primo.start();
		secondo.start();
		
		log.debug("primo state: {}",primo.getState());
		log.debug("secondo state: {}",secondo.getState());


		Thread.sleep(4*1000);
		t2.chiudi();
		Thread.sleep(1*1000);
		
		log.debug("dopo chiudi -- primo state: {}",primo.getState());
		log.debug("dopo chiudi -- secondo state: {}",secondo.getState());
		
		Thread.sleep(50*1000);
		
		log.debug("end of process");

		
		
	}

}
