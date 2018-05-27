INSERT INTO `Admin` (`admin_id`, `jmeno`, `prijmeni`, `email`, `heslo`, `access`) VALUES ('1', 'Dorota', 'M�chalov�', 'dorymachy@gmail.com', SHA('heslo123'), '3'), ('2', 'Petr', 'M�chal', 'petrmachy@gmail.com', SHA('cert123'), '3'), ('3', 'Lucifer', 'Kn�e', 'lucifer@peklo.de', SHA('rumplcimprcampr'), '3');

INSERT INTO `Akce` (`akce_id`, `typ`, `nazev`, `casOd`, `casDo`, `misto`, `popis`, `cena`, `maxUcast`) VALUES ('1', 'Sightseeing', 'Karl�tejn', '2018-07-21 10:00:00', '2018-07-21 19:00:00', 'Karl�tejn', 'No women allowed', '600', '28'), ('2', 'Sightseeing', 'Prague Castle', '2018-07-15 14:00:00', '2018-07-15 18:00:00', 'Prague Castle and Charles Bridge', 'No terrorists allowed', '800', '15'), ('3', 'Bicycle trip', '�esk� r�j', '2018-08-16 08:00:00', '2018-08-16 19:00:00', '�esk� r�j - Svijany', 'No fatties allowed', '500', '8'), ('4', 'Bicycle trip', '�esk� r�j', '2018-08-24 09:00:00', '2018-08-24 18:00:00', '�esk� r�j - ���r', 'No fatties allowed', '550', '12'), ('5', 'Lecture', 'V�E - �i�kov', '2018-09-17 09:00:00', '2018-09-17 12:00:00', 'NB D', 'Cryptocurrencies and Bitcoin', '550', '12'), ('6', 'Social event', 'Prague', '2018-09-18 19:00:00', '2018-09-19 03:00:00', 'The Pub - Praha 1', 'Drinking beer competition', '1500', '16');

INSERT INTO `Buddy` (`buddy_id`, `adresa`, `titul`, `xname`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES
('1', 'N�hodn� 88, Praha 68', 'Ivan', 'V�lek', '1997-04-17', '+420 425 872 128', 'mu�', '�R', 'vanwallee@gmail.com', SHA('cjoe89dn'), '1'),
('2', 'Neexistuj�c� 2, Praha 77', 'Jan', 'Hn�zdo', '1996-04-14', '+420 428 872 128', 'mu�', '�R', 'hnizdojanek@seznam.cz', SHA('de8Hwv6n'), '1'),
('3', 'Nenaimplementovan� 0, A�', 'Lubor', 'V�chal', '1995-07-17', '+420 427 772 128', 'mu�', '�R', 'luvachy@seznam.cz', SHA('ndu76b5q'), '1'),
('4', 'DevNullov�, T�eb��', 'Pavel', 'Ramp�r', '1996-09-12', '+420 426 875 158', 'mu�', '�R', 'rampamcpaul@gmail.com', SHA('4Gjuw8d1'), '1'),
('5', 'Vymazan� 404, Star� Kostelec', 'Petr', 'Trojhr�nek', '1995-12-17', '+420 105 872 128', 'mu�', '�R', 'hran3petr@seznam.cz', SHA('2fijJm8d'), '1'),
('6', 'Zapomenut� 11, Cukron�n', 'Adam', '�litr', '1993-08-08', '+420 425 718 128', 'mu�', '�R', 'adamsli@vse.cz', SHA('d8j4KO5i'), '1'),
('7', 'Oran�ov� 69, Nov� Karotkov', 'Igor', 'Plotzl', '1997-11-16', '+420 479 822 129', 'mu�', '�R', 'igorplacka@seznam.cz', SHA('e89dw54v'), '1'),
('8', 'Nedefinovan� 999, M�stec', 'Mat�j', '�tverec', '1996-01-08', '+420 625 271 168', 'mu�', '�R', 'maty4@gmail.com', SHA('e8dwQn4C'), '1'),
('9', '��belsk� 666, Luciferov', 'Michal', 'Pafl��ek', '1996-06-26', '+420 465 982 628', 'mu�', '�R', 'guitarmage@jazzfusion.com', SHA('g11Rm9oL'), '1'),
('10', 'Nenalezen� 403, Ztracenov', 'Jarom�r', 'Nohavice', '1995-07-02', '+420 525 872 128', 'mu�', '�R', 'nohajaros@seznam.cz', SHA('jo3n3sB0'), '1'),
('11', 'Tajn� 007, Agentov', 'Martin', 'Smutnovsk�', '1990-08-12', '+420 514 759 177', 'mu�', '�R', 'nebudeveselo@dvtv.cz', SHA('sk8R4u69'), '1'),
('12', 'P�epsan� 557, Praha 2', 'Jarom�r', 'Leitz', '1998-02-24', '+420 445 972 224', 'mu�', '�R', 'jarleitz@seznam.cz', SHA('syA8nE29'), '1'),
('13', 'Zkorumpovan� 1, Praha 1', 'Lubom�r', 'Vyor�lek', '1995-05-08', '+420 424 812 328', 'mu�', '�R', 'vyoranamys@seznam.cz', SHA('pk81q5Mx'), '1');


INSERT INTO `Exchange` (`exchange_id`, `adresaCR`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES
('1', 'U Zvona�ky 1, 120 00 Praha 2', 'Yvan', 'Vladimirov', '1997-04-17', '+7 425 872 128', 'mu�', 'RU', 'yvvlado@mid.ru', SHA('LcKe8d2'), '2'),
('2', 'Veleslav�nova 1098/2a, 110 00 Praha 1', 'Johnie', 'McAfee', '1996-04-14', '+1 428 872 128', 'mu�', 'USA', 'virusAfreed@gmail.com', SHA('dew4H6Mn'), '2'),
('3', 'Stroupe�nick�ho 21, 150 00 Praha 5', 'Michael', 'Walker', '1995-07-17', '+44 427 772 128', 'mu�', 'GB', 'walkmemichael@gmail.com', SHA('n11dub3q'), '2'),
('4', 'U Zvona�ky 1, 120 00 Praha 2', 'Vyacheslav', 'Titkov', '1996-09-12', '+7 426 875 158', 'mu�', 'RU', 'tititi54@mid.ru', SHA('4tTjwdE1'), '2'),
('5', 'Stroupe�nick�ho 21, 150 00 Praha 5', 'Peter', 'Black', '1995-12-17', '+44 105 872 128', 'mu�', 'GB', 'blackpjotor@gmail.com', SHA('fi87jJm8d'), '2'),
('6', 'U Zvona�ky 1, 120 00 Praha 2', 'Vadim', 'Smirnov', '1993-08-08', '+7 425 718 128', 'mu�', 'RU', 'smirnmeoff@mid.ru', SHA('djr44O5i'), '2'),
('7', 'U Zvona�ky 1, 120 00 Praha 2', 'Antonio', 'Panderas', '1997-11-16', '+34 479 822 129', 'mu�', 'ES', 'luketmypanda@serco.es', SHA('e8Fdfw5v'), '2'),
('8', 'Pa��sk� 30, 110 00 Star� M�sto', 'Clovis', 'Marielle', '1996-01-08', '+33 625 271 168', 'mu�', 'FR', 'clovellema@jazzfusion.fr', SHA('e8W9Qn4C'), '2'),
('9', 'Pa��sk� 30, 110 00 Star� M�sto', 'Sebastien', 'Mayne', '1996-06-26', '+33 465 982 628', 'mu�', 'FR', 'sebastienfromage@jazzfusion.fr', SHA('g118PmoL'), '2'),
('10', '�t�p�nsk� 623/40, 110 00 Nov� M�sto', 'Giuseppe', 'Riccardo', '1995-07-02', '+39 525 872 128', 'mu�', 'IT', 'beefpizza@steri.it', SHA('jo3gTsB0'), '2'),
('11', 'U Zvona�ky 1, 120 00 Praha 2', 'Arkady', 'Matvei', '1990-08-12', '+7 514 759 177', 'mu�', 'RU', 'matvarka@mid.ru', SHA('sk5w4u69'), '2'),
('12', '�t�p�nsk� 623/40, 110 00 Nov� M�sto', 'Alberto', 'Emanuele', '1998-02-24', '+39 445 972 224', 'mu�', 'IT', 'emanalb@steri.it', SHA('syA8nEa9'), '2'),
('13', '�t�p�nsk� 623/40, 110 00 Nov� M�sto', 'Filippo', 'Emanuele', '1995-05-08', '+39 424 812 328', 'mu�', 'IT', 'emanfill@esteri.it', SHA('pt81q5Mx'), '2');

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