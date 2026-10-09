package com.betacom.process;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.threads.MyFirstThread;
import com.betacom.threads.MySecondThread;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ThreadProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.info("Begin ThreadProcess");
		
		
		Thread primo = new Thread(new MyFirstThread());  // Thread definition
		
		MySecondThread t2 = new MySecondThread();		
		Thread secondo = new Thread(t2);  // Thread definition
		
		
		Thread terzo = new Thread(() -> {
			log.debug("Thread chiamato con lambda : {}", Thread.currentThread().getName());
			for (int i=0; i <= 15; i++ ) {
				try {
					log.debug("Runnable MyThirdThread in esecuzione item: {}", i);
					Thread.sleep(1*1000);
				} catch (InterruptedException e) {
					log.error("InterruptedException {}", e.getMessage());
				}
			}
		});
		
		new Thread(() -> {
			log.debug("Thread non riferenziato : {}", Thread.currentThread().getName());
			for (int i=0; i <= 15; i++ ) {
				log.debug("Runnable non riferenziaro in esecuzione item: {}", i);
			}
			log.debug("end of Thread non riferenziato : {}", Thread.currentThread().getName());
		}).start();
		

		log.debug("before start - primo state: {}",primo.getState());
		log.debug("before start - secondo state: {}",secondo.getState());
		log.debug("before start - terzo state: {}",terzo.getState());

		
		log.debug("Thread started ......");
		primo.start();
		secondo.start();
		terzo.start();

		log.debug("primo state: {}",primo.getState());
		log.debug("secondo state: {}",secondo.getState());
		log.debug("terzo state: {}",terzo.getState());

		Thread.sleep(4*1000);
		t2.chiudi();
		Thread.sleep(1*1000);
		
		log.debug("dopo chiudi -- primo state: {}",primo.getState());
		log.debug("dopo chiudi -- secondo state: {}",secondo.getState());
		log.debug("dopo chiudi -- terzo state: {}",terzo.getState());
		
		
		
		Thread.sleep(50*1000);
		
		log.debug("end of process");
	}

}
