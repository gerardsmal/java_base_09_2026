package com.betacom.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.betacom.interfaces.GeneralInterface;

public class SequentialProcess implements GeneralInterface{
	private static final Logger log = LoggerFactory.getLogger(SequentialProcess.class);
	
	@Override
	public void execute() throws Exception {
		log.info("Begin SequentialProcess");
		String filePath = "/Users/gerard/Downloads/fileToRead.txt";
		String fileOutputPath = "/Users/gerard/Downloads/fileToWrite.txt";
		
		
		
		List<String> records = readFile(filePath);
		for (String record:records) {
			 log.debug(record);
		}
		
		List<String> rWrite = List.of(
				"write 1",
				"write 2",
				"write 3",
				"write 4",
				"write 5",
				"write 6",
				"write 7",
				"write 8",
				"write 9",
				"write 10"
				);
		
		log.debug("Numero di records scritti {}" , writeFile(fileOutputPath, rWrite, false));
	}
	/*
	 * read sequential file
	 */
	private List<String> readFile(String path ){
		List<String> r = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line = reader.readLine();
			while (line != null) {
				r.add(line);
				line = reader.readLine();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return r;
	}
	
	/*
	 * write sequential file metodo 1
	 */
	private int writeFile(String path, List<String> inp) {
		int num = 0;
		File f = new File(path);
		
		if (f.exists()) {
			log.info("file " + path + " exits");
			f.delete();
		}
		
		try (FileWriter o = new FileWriter(f)){
			for (String rec:inp) {
				o.write(rec + "\n");
//				o.write("\n");
				num++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return num;
	}
	
	/*
	 * mode true   ->  extend del file
	 *      false --> replace
	 */
	private int writeFile(String path, List<String> inp, boolean mode) {
		int num = 0;
				
		try (FileWriter o = new FileWriter(path,mode)){
			for (String rec:inp) {
				o.write(rec + "\n");
//				o.write("\n");
				num++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return num;
	}
	
	
}
