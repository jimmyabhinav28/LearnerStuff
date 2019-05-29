drop schema if exists jpaPractice2;
create schema jpaPractice2;
use jpaPractice2;

drop table if exists table3;
create table table3
(id bigint(10) primary key auto_increment,
attribute1 varchar(20)
)ENGINE=InnoDB ;


drop table if exists table1;
create table table1
(-- 																id bigint(10) primary key auto_increment,
attribute1 varchar(20),
table3_id bigint(10) primary key,
CONSTRAINT FOREIGN KEY (table3_id) REFERENCES table3(id)
)ENGINE=InnoDB ;

drop table if exists table2;
create table table2
(-- 																id bigint(10) primary key auto_increment,
attribute1 varchar(20),
table3_id bigint(10) primary key,
CONSTRAINT FOREIGN KEY (table3_id) REFERENCES table3(id)
)ENGINE=InnoDB ;



use jpapractice2;

insert into table3(attribute1) values('table3entry1');
insert into table3(attribute1) values('table3entry2');
insert into table3(attribute1) values('table3entry3');
insert into table3(attribute1) values('table3entry4');
insert into table3(attribute1) values('table3entry5');

insert into table1(attribute1,table3_id) values('table1entry1',1);
insert into table1(attribute1,table3_id) values('table1entry2',2);
insert into table1(attribute1,table3_id) values('table1entry3',3);
insert into table1(attribute1,table3_id) values('table1entry4',4);

insert into table2(attribute1,table3_id) values('table2entry1',1);
insert into table2(attribute1,table3_id) values('table2entry2',2);
insert into table2(attribute1,table3_id) values('table2entry3',3);
insert into table2(attribute1,table3_id) values('table2entry4',4);


commit;
select * from table3;
select * from table1;
select * from table2;
