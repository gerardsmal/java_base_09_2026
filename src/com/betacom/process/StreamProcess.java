package com.betacom.process;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.betacom.interfaces.GeneralInterface;
import com.betacom.objects.Impiegato;
import com.betacom.objects.ImpiegatoStream;
import com.betacom.objects.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class StreamProcess implements GeneralInterface{

	@Override
	public void execute() throws Exception {
		log.info("Begin StreamProcess");
		
		/*
		 * create list with stream
		 */
		List<Impiegato> lI = Stream.of(
				new Impiegato("Andrea", "Verde", true, 1500, "IT"),
				new Impiegato("Pietro", "Giallo", true, 1300, "IT"),
				new Impiegato("Anna", "Nero", false, 1600, "IT"),
				new Impiegato("Giuseppe", "Rossi", true, 2000, "IT"),
				new Impiegato("Alice", "Dibello", false, 2500, "PRODUZIONE"),
				new Impiegato("Cecillia", "Grande", false, 1300, "IT"),
				new Impiegato("Eric", "Piccolo", true, 1800, "LOGISTICA"),
				new Impiegato("Paolo", "Bluetto", true, 1900, "IT"),
				new Impiegato("Ugo", "noede", true, 1200, "IT")				
				).collect(Collectors.toList());
		
		lI.add(new Impiegato("Luca", "cicol", true, 2600, "IT"));
		 
		lI.forEach(i -> System.out.println(i));
		
		/*
		 * create stream with builder
		 */
		Stream<String> streamBuilder = Stream.<String> builder()
				.add("Lunedi")
				.add("Martedi")
				.add("Mercoledi")
				.add("Giovedi")
				.add("Venerdi")
				.add("Sabato")
				.add("Domenica")
				.build();
		
		String[] giorni = streamBuilder.toArray(size -> new String[size]);
		
		log.debug("Giorni length : {}. giorni [3]  {}", giorni.length, giorni[3]);
		
		/*
		 * create random
		 */
		Random ra = new Random();
		Stream<Long> sL = Stream.generate(() -> ra.nextLong()) .limit(10);
		sL.forEach(l ->log.debug(l.toString()));
		
		/*
		 * generate dati primitivi
		 */
		log.debug("Generate dati primitivi");
		IntStream intStream = IntStream.range(1, 10);
		intStream.forEach(is -> log.debug(Long.toString(is)));
		
		
		/*
		 * filter
		 */
		lI.stream()
			.filter(im -> im.getSesso())
			.filter(im -> im.getSalary() > 1900)
			.forEach(im -> log.debug(im.toString()));
		
		/*
		 * mapping
		 */
		List<User> lU = List.of(
				new User("Anna", "Vella", false),
				new User("Paolo", "Grande", true),
				new User("Cecilia", "Blerif", false),
				new User("Eric", "Temis", true),
				new User("Matteo", "Brandi", true),
				new User("Alice", "Meravi", false)
				); 
		
		
		log.debug("Mapping");
		List<ImpiegatoStream> res =lU.stream()
			.filter(im -> im.getSesso())	
			.map(im -> ImpiegatoStream.builder()
					.nome(im.getNome() + " " + im.getCognome())
					.sesso(im.getSesso())
					.build()
					).toList();
		
		res.forEach(u -> log.debug(u.toString()));
		
		log.debug("count");
		long count = lI.stream()
				.filter(im -> im.getSesso())
				.count();
		log.debug("Numero di maschi trovato {}", count);
		
		/*
		 * match
		 */
		boolean rm = lI.stream()
				.filter(im -> !im.getSesso())
				.anyMatch(im -> im.getSalary() > 2400);
		
		log.debug("Risultato del match {}", rm);
		
		
	}

}
