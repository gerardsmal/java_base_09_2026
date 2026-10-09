package com.betacom.process;

import java.util.List;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.ObjectJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.info("Begin JsonProcess");
		
		ObjectJson user = new ObjectJson("Paolo", "Verde", true);
		
		/*
		 * initialize Jackson
		 */
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		/*
		 * Object to Json
		 */
		String jsonString = mapper.writeValueAsString(user);
		log.debug("\n {}", jsonString);
		
		
		/*
		 * Json to Object
		 */
		ObjectJson newUser = mapper.readValue(jsonString, ObjectJson.class);
		
		log.debug("newUser value : {}", newUser);
		
		/*
		 * List to Json
		 */
		List<ObjectJson> lU = List.of(
				new ObjectJson("Paolo", "Verde", true),
				new ObjectJson("Alice", "Bruno", false),
				new ObjectJson("Andrea", "Nero", true),
				new ObjectJson("Caterina", "Giallo", false)
				);
		
		jsonString = mapper.writeValueAsString(lU);
		log.debug("List \n {}", jsonString);
		
		/*
		 * Json to List
		 */
		List<ObjectJson> res = mapper.readValue(
				jsonString,
				new TypeReference<List<ObjectJson>>() {}
				);

		res.forEach(j -> log.debug(j.toString()));
		
	}

}
