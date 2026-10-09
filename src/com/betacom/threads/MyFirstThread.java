package com.betacom.threads;


import java.time.LocalDate;
import java.time.LocalDateTime;

import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyFirstThread implements Runnable{
	
	@Override
	public void run() {
		log.debug("Sono dentro il thread MyFirstThread..");
		
		
		for (int i=0; i <= 15; i++ ) {
			log.debug("Runnable MyFirstThread in esecuzione item: {}", i);
			try {
				Thread.sleep(2*1000);
			} catch (InterruptedException e) {
				log.error("InterruptedException {}", e.getMessage());
			}
		}
		
		log.debug("Thread MyFirstThread is ended at {}", Utilities.dataToString(LocalDateTime.now()));
	}
	
}
