INSERT INTO `Admin` (`admin_id`, `jmeno`, `prijmeni`, `email`, `heslo`, `access`) VALUES
('1', 'Dorota', 'Máchalová', 'dorymachy@gmail.com', SHA('heslo123'), '3'),
('2', 'Petr', 'Máchal', 'petrmachy@gmail.com', SHA('cert123'), '3'),
('3', 'Lucifer', 'Kníže', 'lucifer@peklo.de', SHA('rumplcimprcampr'), '3');

INSERT INTO `Akce` (`akce_id`, `typ`, `nazev`, `casOd`, `casDo`, `misto`, `popis`, `cena`, `maxUcast`) VALUES
('1', 'Sightseeing', 'Karlštejn', '2018-07-21 10:00:00', '2018-07-21 19:00:00', 'Karlštejn', 'No women allowed', '600', '28'),
('2', 'Sightseeing', 'Prague Castle', '2018-07-15 14:00:00', '2018-07-15 18:00:00', 'Prague Castle and Charles Bridge', 'No terrorists allowed', '800', '15'),
('3', 'Bicycle trip', 'Èeský ráj', '2018-08-16 08:00:00', '2018-08-16 19:00:00', 'Èeský ráj - Svijany', 'No fatties allowed', '500', '8'),
('4', 'Bicycle trip', 'Èeský ráj', '2018-08-24 09:00:00', '2018-08-24 18:00:00', 'Èeský ráj - Žïár', 'No fatties allowed', '550', '12'),
('5', 'Lecture', 'VŠE - Žižkov', '2018-09-17 09:00:00', '2018-09-17 12:00:00', 'NB D', 'Cryptocurrencies and Bitcoin', '550', '12'),
('6', 'Social event', 'Prague', '2018-09-18 19:00:00', '2018-09-19 03:00:00', 'The Pub - Praha 1', 'Drinking beer competition', '1500', '16');

INSERT INTO `Buddy` (`buddy_id`, `adresa`, `titul`, `xname`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES
('1', 'Náhodná 88, Praha 68', 'Ivan', 'Válek', '1997-04-17', '+420 425 872 128', 'muž', 'ÈR', 'vanwallee@gmail.com', SHA('cjoe89dn'), '1'),
('2', 'Neexistující 2, Praha 77', 'Jan', 'Hnízdo', '1996-04-14', '+420 428 872 128', 'muž', 'ÈR', 'hnizdojanek@seznam.cz', SHA('de8Hwv6n'), '1'),
('3', 'Nenaimplementovaná 0, Aš', 'Lubor', 'Váchal', '1995-07-17', '+420 427 772 128', 'muž', 'ÈR', 'luvachy@seznam.cz', SHA('ndu76b5q'), '1'),
('4', 'DevNullová, Tøebíè', 'Pavel', 'Rampír', '1996-09-12', '+420 426 875 158', 'muž', 'ÈR', 'rampamcpaul@gmail.com', SHA('4Gjuw8d1'), '1'),
('5', 'Vymazaná 404, Starý Kostelec', 'Petr', 'Trojhránek', '1995-12-17', '+420 105 872 128', 'muž', 'ÈR', 'hran3petr@seznam.cz', SHA('2fijJm8d'), '1'),
('6', 'Zapomenutá 11, Cukronín', 'Adam', 'Šlitr', '1993-08-08', '+420 425 718 128', 'muž', 'ÈR', 'adamsli@vse.cz', SHA('d8j4KO5i'), '1'),
('7', 'Oranžová 69, Nový Karotkov', 'Igor', 'Plotzl', '1997-11-16', '+420 479 822 129', 'muž', 'ÈR', 'igorplacka@seznam.cz', SHA('e89dw54v'), '1'),
('8', 'Nedefinovaná 999, Mìstec', 'Matìj', 'Ètverec', '1996-01-08', '+420 625 271 168', 'muž', 'ÈR', 'maty4@gmail.com', SHA('e8dwQn4C'), '1'),
('9', 'Ïábelská 666, Luciferov', 'Michal', 'Paflíèek', '1996-06-26', '+420 465 982 628', 'muž', 'ÈR', 'guitarmage@jazzfusion.com', SHA('g11Rm9oL'), '1'),
('10', 'Nenalezená 403, Ztracenov', 'Jaromír', 'Nohavice', '1995-07-02', '+420 525 872 128', 'muž', 'ÈR', 'nohajaros@seznam.cz', SHA('jo3n3sB0'), '1'),
('11', 'Tajná 007, Agentov', 'Martin', 'Smutnovský', '1990-08-12', '+420 514 759 177', 'muž', 'ÈR', 'nebudeveselo@dvtv.cz', SHA('sk8R4u69'), '1'),
('12', 'Pøepsaná 557, Praha 2', 'Jaromír', 'Leitz', '1998-02-24', '+420 445 972 224', 'muž', 'ÈR', 'jarleitz@seznam.cz', SHA('syA8nE29'), '1'),
('13', 'Zkorumpovaná 1, Praha 1', 'Lubomír', 'Vyorálek', '1995-05-08', '+420 424 812 328', 'muž', 'ÈR', 'vyoranamys@seznam.cz', SHA('pk81q5Mx'), '1');


INSERT INTO `Exchange` (`exchange_id`, `adresaCR`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES
('1', 'U Zvonaøky 1, 120 00 Praha 2', 'Yvan', 'Vladimirov', '1997-04-17', '+7 425 872 128', 'muž', 'RU', 'yvvlado@mid.ru', SHA('LcKe8d2'), '2'),
('2', 'Veleslavínova 1098/2a, 110 00 Praha 1', 'Johnie', 'McAfee', '1996-04-14', '+1 428 872 128', 'muž', 'USA', 'virusAfreed@gmail.com', SHA('dew4H6Mn'), '2'),
('3', 'Stroupežnického 21, 150 00 Praha 5', 'Michael', 'Walker', '1995-07-17', '+44 427 772 128', 'muž', 'GB', 'walkmemichael@gmail.com', SHA('n11dub3q'), '2'),
('4', 'U Zvonaøky 1, 120 00 Praha 2', 'Vyacheslav', 'Titkov', '1996-09-12', '+7 426 875 158', 'muž', 'RU', 'tititi54@mid.ru', SHA('4tTjwdE1'), '2'),
('5', 'Stroupežnického 21, 150 00 Praha 5', 'Peter', 'Black', '1995-12-17', '+44 105 872 128', 'muž', 'GB', 'blackpjotor@gmail.com', SHA('fi87jJm8d'), '2'),
('6', 'U Zvonaøky 1, 120 00 Praha 2', 'Vadim', 'Smirnov', '1993-08-08', '+7 425 718 128', 'muž', 'RU', 'smirnmeoff@mid.ru', SHA('djr44O5i'), '2'),
('7', 'U Zvonaøky 1, 120 00 Praha 2', 'Antonio', 'Panderas', '1997-11-16', '+34 479 822 129', 'muž', 'ES', 'luketmypanda@serco.es', SHA('e8Fdfw5v'), '2'),
('8', 'Paøížská 30, 110 00 Staré Mìsto', 'Clovis', 'Marielle', '1996-01-08', '+33 625 271 168', 'muž', 'FR', 'clovellema@jazzfusion.fr', SHA('e8W9Qn4C'), '2'),
('9', 'Paøížská 30, 110 00 Staré Mìsto', 'Sebastien', 'Mayne', '1996-06-26', '+33 465 982 628', 'muž', 'FR', 'sebastienfromage@jazzfusion.fr', SHA('g118PmoL'), '2'),
('10', 'Štìpánská 623/40, 110 00 Nové Mìsto', 'Giuseppe', 'Riccardo', '1995-07-02', '+39 525 872 128', 'muž', 'IT', 'beefpizza@steri.it', SHA('jo3gTsB0'), '2'),
('11', 'U Zvonaøky 1, 120 00 Praha 2', 'Arkady', 'Matvei', '1990-08-12', '+7 514 759 177', 'muž', 'RU', 'matvarka@mid.ru', SHA('sk5w4u69'), '2'),
('12', 'Štìpánská 623/40, 110 00 Nové Mìsto', 'Alberto', 'Emanuele', '1998-02-24', '+39 445 972 224', 'muž', 'IT', 'emanalb@steri.it', SHA('syA8nEa9'), '2'),
('13', 'Štìpánská 623/40, 110 00 Nové Mìsto', 'Filippo', 'Emanuele', '1995-05-08', '+39 424 812 328', 'muž', 'IT', 'emanfill@esteri.it', SHA('pt81q5Mx'), '2');

INSERT INTO `Request` (`request_id`, `exchange_id`, `akce_id`, `zaplaceno`, `schvaleno`) VALUES
('1', '1', '1', '0', '1'),
('2', '1', '2', '0', '1'),
('3', '1', '4', '0', '0'),
('4', '2', '2', '0', '1'),
('5', '2', '3', '0', '0'),
('6', '3', '1', '1', '1'),
('7', '3', '6', '0', '0'),
('8', '4', '6', '0', '0'),
('9', '5', '1', '0', '0'),
('10', '6', '2', '1', '1'),
('11', '6', '6', '0', '1'),
('12', '6', '4', '0', '0'),
('13', '7', '1', '1', '1'),
('14', '7', '3', '0', '1'),
('15', '7', '5', '0', '0'),
('16', '8', '1', '0', '0'),
('17', '8', '2', '1', '1'),
('18', '8', '4', '1', '1'),
('19', '8', '6', '0', '1'),
('20', '9', '4', '0', '0'),
('21', '9', '2', '1', '1'),
('22', '10', '1', '0', '0'),
('23', '10', '2', '0', '0'),
('24', '10', '5', '1', '1'),
('25', '10', '3', '0', '1'),
('26', '11', '3', '1', '1'),
('27', '11', '2', '1', '1'),
('28', '11', '1', '0', '1'),
('29', '11', '6', '0', '0'),
('30', '12', '5', '0', '0'),
('31', '12', '4', '0', '1'),
('32', '12', '3', '1', '1'),
('33', '13', '2', '1', '1'),
('34', '13', '5', '0', '0');

INSERT INTO `VztahBuddyExchange` (`exchange_id`, `buddy_id`, `vztah_id`) VALUES
('1', '11', '1'),
('3', '5', '2'),
('4', '6', '3'),
('2', '7', '4'),
('6', '2', '5'),
('10', '8', '6'),
('13', '12', '7');
