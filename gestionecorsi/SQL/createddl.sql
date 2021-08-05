create table docenti(
coddocente int,
nomedocente varchar2(30),
cognomedocente varchar2(30),
cvdocente varchar2(70),
constraint p_coddocente primary key(coddocente));

create table amministratori(
codadmin int,
nomeadmin varchar2(30) not null,
cognomeadmin varchar2(30) not null,
password varchar2(500) not null,
constraint p_codadmin primary key(codadmin));

create table corsi(
codcorso int generated by default on null as identity,
nomecorso varchar2(30) not null,
datainiziocorso date not null,
datafinecorso date,
costocorso number(7,2),
commenticorso varchar2(200),
aulacorso int,
coddocente int,
constraint datacorsiCheck check((datafinecorso - datainiziocorso)>2),
constraint p_codcorso primary key(codcorso),
constraint f_iddocente foreign key(coddocente) references docenti(coddocente) on delete cascade);

create table corsisti(
codcorsista int generated by default on null as identity,
nomecorsista varchar2(30),
cognomecorsista varchar2(30),
precedentiformativi char(2),
constraint p_codcorsista primary key(codcorsista));

create table corsi_corsisti(
codcc int generated by default on null as identity,
codcorsista int,
codcorso int,
constraint p_codcc primary key(codcc),
constraint f_codcors1s7a foreign key(codcorsista) references corsisti(codcorsista) on delete cascade,
constraint f_codcorso foreign key(codcorso) references corsi(codcorso) on delete cascade);

--sequence
create sequence corsi_seq;
create sequence corsisti_seq;
create sequence corsi_corsisti_seq;
