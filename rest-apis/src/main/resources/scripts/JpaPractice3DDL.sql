
drop schema if exists jpaPractice3;
create schema jpaPractice3;
use jpaPractice3;

drop table if exists table3;
create table table3
(id bigint(10) primary key auto_increment,
attribute1 varchar(20)
)ENGINE=InnoDB ;


--since the foreign key is not unique, the table structure permits one to many
drop table if exists table1;
create table table1
(id bigint(10) primary key auto_increment,
attribute1 varchar(20),
table3_id bigint(10), 
CONSTRAINT FOREIGN KEY (table3_id) REFERENCES table3(id)
)ENGINE=InnoDB ;


--since the foreign key is not unique, the table structure permits one to many
drop table if exists table2;
create table table2
(id bigint(10) primary key auto_increment,
attribute1 varchar(20),
table3_id bigint(10) ,
CONSTRAINT FOREIGN KEY (table3_id) REFERENCES table3(id)
)ENGINE=InnoDB ;



use jpaPractice3;

insert into table3(attribute1) values('table3entry1');
insert into table3(attribute1) values('table3entry2');
insert into table3(attribute1) values('table3entry3');
insert into table3(attribute1) values('table3entry4');
insert into table3(attribute1) values('table3entry5');

insert into table1(attribute1,table3_id) values('table1entry1_1',1);
insert into table1(attribute1,table3_id) values('table1entry2_1',2);
insert into table1(attribute1,table3_id) values('table1entry3_1',3);
insert into table1(attribute1,table3_id) values('table1entry4_1',4);
insert into table1(attribute1,table3_id) values('table1entry1_2',1);
insert into table1(attribute1,table3_id) values('table1entry2_2',2);
insert into table1(attribute1,table3_id) values('table1entry3_2',3);
insert into table1(attribute1,table3_id) values('table1entry4_2',4);

insert into table2(attribute1,table3_id) values('table2entry1_1',1);
insert into table2(attribute1,table3_id) values('table2entry2_1',2);
insert into table2(attribute1,table3_id) values('table2entry3_1',3);
insert into table2(attribute1,table3_id) values('table2entry4_1',4);
insert into table2(attribute1,table3_id) values('table2entry1_2',1);
insert into table2(attribute1,table3_id) values('table2entry2_2',2);
insert into table2(attribute1,table3_id) values('table2entry3_2',3);
insert into table2(attribute1,table3_id) values('table2entry4_2',4);


commit;
select * from table3;
select * from table1;
select * from table2;
