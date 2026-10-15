/*
 * int -> Integer
 * decimal -> decimale
 * char -> string di lungezza fissa con max. 255
 * varchar -> string di lunghezza vairiabile con max. 65535
 * text -> string fisso con max. 65535
 * date -> Date yyyy-mm-dd
 * datetime -> date yyyy-mm-dd hh:mm:ss
 * Timestamp -> numero di secondi da l'inizio unix (1970-01-01 00:00:01 UTC; 
 */
drop table dipendenti;
create table dipendenti (
	id_dipendente int not null auto_increment,
	nome varchar(200) not null,
	cognome varchar(200) not null,
	data_assunzione date not null,
	telefono varchar(10) unique,
	mansione varchar(50) default 'impiegato',
	stipendio decimal not null check (stipendio >= 1000 and stipendio <= 9000),	
	primary key (id_dipendente)
);

drop table clienti;
create table clienti (
	id_cliente int not null auto_increment,
	denominazione varchar(255) not null,
	p_iva varchar(16) not null unique,
	inidirizzo varchar(255) not null,
	telefono varchar(10) unique,
	primary key (id_cliente)
);

create table rapporto_cliente (
	id_rapporto int  auto_increment,
	descrizione varchar (255),
	id_cliente int not null,
	id_dipendente int not null,	
	primary key (id_rapporto),
	foreign key (id_cliente) references clienti(id_cliente),
	foreign key (id_dipendente) references dipendenti(id_dipendente)
);

insert into dipendenti (nome , cognome, data_assunzione , telefono, stipendio)
	values ("Paolo", "Bainco", "2026-09-01", "111111", 1300);

insert into dipendenti (nome , cognome, data_assunzione , telefono, stipendio)
	values ("Marco", "Bluete", "2026-09-01", "22222222", 1350),
		("Anna", "Beder", "2026-08-01", "3333333", 1250),
		("Andrea", "Vialo", "2026-10-01", "44444444", 1450),
		("Lucia", "Viaeda", "2026-09-01", "55555555", 1550),
		("Enrico", "Marica", "2026-10-01", "66666666", 1650),
		("Alice", "Deipare", "2026-10-01", "77777777", 1750),
		("Luca", "Rossi", "2026-09-01", "88888888", 1650)

insert into clienti (denominazione, p_iva, inidirizzo, telefono)
	values ("Una spa", "111111111111", "via una, 1", "99111111"),
		   ("Due srl", "222222222222", "via due, 2", "98222222"),
	       ("Tre sas", "333333333333", "via tre, 3", "97333333");


insert into rapporto_cliente (descrizione, id_cliente, id_dipendente) VALUES 
		("rapporto 1", 1, 4),
		("rapporto 1", 2, 5),
		("rapporto 1", 3, 6)

insert into dipendenti (nome , cognome, data_assunzione , telefono, stipendio)
	values ("Angelo", "Zuado", "2025-01-02", "99222222", 1450),
		("Marta", "Vincen", "2024-02-01", "9933333", 1550),
		("Silvio", "Nipardo", "2025-03-01", "99444444", 1350),
		("Berta", "Sumpi", "2024-04-01", "99555555", 1650),
		("Filippo", "Plucake", "2022-06-01", "99666666", 1850),
		("Elisa", "Envieccetta", "2024-07-01", "99777777", 2050),
		("Pier", "Pluarli", "2026-03-01", "99888888", 2650)
		
insert into clienti (denominazione, p_iva, inidirizzo, telefono)
	values ("Quatro spa", "444444111111", "via quatro, 4", "964444411"),
		   ("Cinque srl", "555555222222", "via cinque, 5", "955555222"),
	       ("Sei sas", "6333333", "via sei, 6", "9566633");
		
insert into dipendenti (nome, cognome, data_assunzione, telefono, mansione, stipendio)
	VALUES 
	("Angela", "Sottenra", "2025-09-20", "34523004", "Team manager",2300),
	("Mauro", "Nearo", "2025-10-20", "34523005", "HR",1600),
	("Agnes", "Dellagrange", "2025-09-20", "34523006", "Team manager",2200),
	("Marco", "Lavvasa", "2025-09-20", "34523007", "Amministrazione",1900);


select * from dipendenti;
select * from clienti;
select * from rapporto_cliente rc 

/*
 * condizione logici
 * =, !=
 * >, = , <=, >=
 * IN (valore 1, valore 2 .....)
 * between
 * like
 * and
 * or not
 */

select nome, cognome, stipendio, mansione from dipendenti d  WHERE mansione in ('Team manager', 'HR');

insert into dipendenti (nome , cognome, data_assunzione , telefono, stipendio)
	values
	("Filippo", "Plucake", "2022-06-01", "888663466", 1850);

select distinct nome, cognome, data_assunzione from dipendenti d  where cognome = 'Plucake';

select distinct mansione from dipendenti d  

select * from dipendenti d  where stipendio >= 1300 order by d.stipendio desc limit 1;

select count(*) from dipendenti d  where stipendio > 1600 and mansione = 'impiegato';

delete from rapporto_cliente  where id_dipendente = 4;
delete from dipendenti where stipendio < 1300 and mansione = 'impiegato';

drop table test;
create table test (
	id int auto_increment,
	tipo int,
	descrizione varchar(255) not null,
	primary key (id)
);

insert into test (tipo, descrizione) values (1,"aaaaa"), (2,"bbbb"), (3, "ccccc"), (4, "dddd"), (5, "eeelkel");

select * from test;
delete  from test;

truncate table test;

update dipendenti set mansione = 'sviluppatore' where stipendio > 1600 and mansione = 'impiegato';

select * from dipendenti  ORDER by stipendio desc;

select distinct nome, cognome from dipendenti order by cognome ;


update dipendenti set nome = 'Giuglia' , cognome ='Labella' , mansione = 'capo progetto' where id_dipendente=15;

create table uffici(
	id_ufficio int auto_increment,
	nome_ufficio varchar(50) not null,
	primary key (id_ufficio)
)

insert into uffici (nome_ufficio) VALUES 
	("Amministrazione"),
	("Vendite"),
	("Produzione"),
	("IT");

insert into uffici (nome_ufficio) VALUES 
	("Marketing");

select * from uffici;

/*
 * alter table
 */

alter table rapporto_cliente 
	add column prova varchar(50);



update rapporto_cliente rc set prova = 'test';

alter table rapporto_cliente 
	modify prova varchar(50) after id_rapporto;

alter table rapporto_cliente 
	modify prova varchar(50) not null;

update rapporto_cliente rc set prova = '12';

alter table rapporto_cliente 
	modify column prova INT;

alter table rapporto_cliente 
	drop column prova;

alter table test rename academy_test;

alter table dipendenti 
	add column id_ufficio int;

alter table dipendenti 
	add constraint fk_dipendente_uffici 
		FOREIGN key (id_ufficio) references uffici(id_ufficio);

select * from dipendenti where mansione = 'impiegato';

update dipendenti set id_ufficio=4 where id_dipendente in (7,8,9,13,14,16,21,15);
update dipendenti set id_ufficio=1 where id_dipendente in (18,20);
update dipendenti set id_ufficio=2 where id_dipendente in (17,19);
update dipendenti set id_ufficio=3 where id_dipendente in (1,3,5,6,10);

/*
 * join
*/
delete from uffici  where id_ufficio=4;

/* inner join */
select d.id_dipendente , d.nome , d.cognome , u.nome_ufficio  from dipendenti d 
	inner join uffici u on d.id_ufficio = u.id_ufficio 

/* left join */
select d.id_dipendente , d.nome , d.cognome , u.nome_ufficio  from dipendenti d 
	left join uffici u on d.id_ufficio = u.id_ufficio 	
	
/* right join */	
select d.id_dipendente , d.nome , d.cognome , u.nome_ufficio  from dipendenti d 
	right join uffici u on d.id_ufficio = u.id_ufficio 
	
/* full join */
select d.id_dipendente , d.nome , d.cognome , u.nome_ufficio  from dipendenti d 
	left join uffici u on d.id_ufficio = u.id_ufficio 	
union
select d.id_dipendente , d.nome , d.cognome , u.nome_ufficio  from dipendenti d 
	right join uffici u on d.id_ufficio = u.id_ufficio ;
	
/*
 * like
 * $%    --> inizia con $
 * %$    --> finische con $
 * $a_o% ---> 
 * %o%   ---> contiene o
 */	

select d.id_dipendente , d.cognome , d.nome from dipendenti d 
	where cognome like 'Via%';

select d.id_dipendente , d.cognome , d.nome from dipendenti d 
	where d.nome like '%a';

select d.id_dipendente , d.cognome , d.nome from dipendenti d 
    where d.cognome like 'P__c%';

select d.id_dipendente , d.cognome , d.nome from dipendenti d 
	where d.cognome like '%ia%'
	
	
/*
 * Group by
 * having  condzione sul group by
 * 
 */	
	select u.nome_ufficio , COUNT(d.id_dipendente ) as totale_dipendente  from dipendenti d 
	right join uffici u on d.id_ufficio = u.id_ufficio 
	GROUP by u.nome_ufficio
	having totale_dipendente = 0
	
/*
 * view
 */
	
create or replace view dipendente_view as
	select d.id_dipendente , d.nome , d.cognome , u.nome_ufficio  from dipendenti d 
	left join uffici u on d.id_ufficio = u.id_ufficio 	
	
select * from dipendente_view dv where dv.nome_ufficio = 'IT';

/*
 * Date
 * pattern di formatazione data
 * %a	Abbreviated weekday name (Sun to Sat)
 * %b	Abbreviated month name (Jan to Dec)
 * %c	Numeric month name (0 to 12)
 * %D	Day of the month as a numeric value, followed by suffix (1st, 2nd, 3rd, ...)
 * %d	Day of the month as a numeric value (01 to 31)
 * %f	Microseconds (000000 to 999999)
 * %H	Hour (00 to 23)
 * %h	Hour (00 to 12)
 * %i	Minutes (00 to 59)
 * %j	Day of the year (001 to 366)
 * %M	Month name in full (January to December)
 * %m	Month name as a numeric value (00 to 12)
 * %p	AM or PM
 * %r	Time in 12 hour AM or PM format (hh:mm:ss AM/PM)
 * %S	Seconds (00 to 59)
 * %T	Time in 24 hour format (hh:mm:ss)
 * %U	Week where Sunday is the first day of the week (00 to 53)
 * %Y	Year as a numeric, 4-digit value
 * %u	Week where Monday is the first day of the week (00 to 53)
 * %W	Weekday name in full (Sunday to Saturday)
 * %w	Day of the week where Sunday=0 and Saturday=6
 * %Y	Year as a numeric, 4-digit value
 * %y	Year as a numeric, 2-digit value * 
 */

SET GLOBAL time_zone = 'Europe/Rome';
drop table prova_data;
create table prova_data (
	id int primary key  auto_increment,
	nome varchar(250),
	data_nascita DATE not null,
	data_inserimento DateTime default current_timestamp,
	data_modifica DateTime default CURRENT_TIMESTAMP on update current_timestamp 
)
insert into prova_data (nome, data_nascita)
	values
	("Luca", '1999-03-27');

insert into prova_data (nome, data_nascita)
	values
	("Angela", '2006-08-18');


select * from prova_data pd ;

update prova_data set data_nascita = '2002-03-05' where nome = 'Luca';

select pd.nome ,  DATE_FORMAT(pd.data_nascita, "%a %d/%m/%y") as nascita,
	DATE_FORMAT(pd.data_modifica , "%a %d/%m/%y %T") as aggiornato		
	from prova_data pd 
		where date(pd.data_modifica) = CURDATE();


create table dipendente_generate(
	id int primary key auto_increment,
	nome varchar(200) not null,
	cognome varchar(200) not null,
	nome_ufficio varchar(50)
)

insert into dipendente_generate (nome, cognome, nome_ufficio)
	(select nome, cognome, nome_ufficio from dipendente_view);

select * from dipendente_generate dg ;

/*
 * index
*/
create index idx_cognome_dipendente on dipendenti(cognome);

SELECT
    NOW() AS ora_mysql,
    UTC_TIMESTAMP() AS ora_utc,
    @@global.time_zone AS global_timezone,
    @@session.time_zone AS session_timezone,
    @@system_time_zone AS system_timezone;
