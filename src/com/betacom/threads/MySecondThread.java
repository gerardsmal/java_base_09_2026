package com.betacom.threads;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySecondThread implements Runnable{
	private volatile boolean attiva = true;
	
	@Override
	public void run() {
		Thread current = Thread.currentThread();
		
		log.debug("Thread MySecondThread is started at {}", Utilities.dataToString(LocalDateTime.now()));
		log.debug("Is virtual thread {}", current.isVirtual());
		while (attiva) {
			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				this.attiva = false;
			}
		}
		
		log.debug("Thread MySecondThread is ended at {}", Utilities.dataToString(LocalDateTime.now()));
		
	}
	
	public void chiudi() {
		log.debug("chiudi is called at {}", Utilities.dataToString(LocalDateTime.now()));
		this.attiva = false;
	}

}
