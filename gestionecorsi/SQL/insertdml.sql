insert into amministratori values(1, 'Admin', 'Admin', '1aE%)9$aVB/1a3?11dE%)9$aVB/1a3?1c9E%)9$aVB/1a3?11cE%)9$aVB/1a3?190E%)9$aVB/1a3?173E%)9$aVB/1a3?125E%)9$aVB/1a3?1c6E%)9$aVB/1a3?192E%)9$aVB/1a3?171E%)9$aVB/1a3?1ddE%)9$aVB/1a3?1f0E%)9$aVB/1a3?1c9E%)9$aVB/1a3?144E%)9$aVB/1a3?1bcE%)9$aVB/1a3?172E%)9$aVB/1a3?1');
insert into docenti values(1, 'Anna', 'Verdi', '/cv/anna.jpeg');
insert into docenti values(2, 'Massimo', 'Rossi', '/cv/massimo.jpeg');
insert into docenti values(3, 'Paolo', 'Bianchi', '/cv/paolo.jpeg');
insert into docenti values(4, 'Laura', 'Gialli', '/cv/laura.jpeg');


insert into corsisti values(corsisti_seq.nextval, 'Paolo','Rossi','si');
insert into corsisti values(corsisti_seq.nextval, 'Marco','Pellegrini','si');
insert into corsisti values(corsisti_seq.nextval, 'Giovanni','Bini','no');
insert into corsisti values(corsisti_seq.nextval, 'Mariangela','Rossi','si');
insert into corsisti values(corsisti_seq.nextval, 'Giulia','Verdi','no');

insert into corsi values(corsi_seq.nextval, 'Java','05-MAG-2021','08-MAG-2021', 300.00, 'Corso intensivo', 5, 1);