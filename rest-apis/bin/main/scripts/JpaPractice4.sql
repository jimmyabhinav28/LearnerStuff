
drop schema if exists jpaPractice4;
create schema jpaPractice4;
use jpaPractice4;

drop table if exists table3;
create table table3
(id bigint(10) primary key auto_increment,
attribute1 varchar(20)
)ENGINE=InnoDB ;


drop table if exists table1;
create table table1
(id bigint(10) primary key auto_increment,
attribute1 varchar(20)
)ENGINE=InnoDB ;


-- associataion table
drop table if exists table1_table3;
create table table1_table3
(table1_id bigint(10),
table3_id bigint(10), 
CONSTRAINT FOREIGN KEY (table3_id) REFERENCES table3(id),
CONSTRAINT FOREIGN KEY (table1_id) REFERENCES table1(id)
)ENGINE=InnoDB ;

drop table if exists table2;
create table table2
(id bigint(10) primary key auto_increment,
attribute1 varchar(20)
)ENGINE=InnoDB ;

-- associataion table
drop table if exists table2_table3;
create table table2_table3
(table2_id bigint(10),
table3_id bigint(10), 
CONSTRAINT FOREIGN KEY (table3_id) REFERENCES table3(id),
CONSTRAINT FOREIGN KEY (table2_id) REFERENCES table2(id)
)ENGINE=InnoDB ;



use jpaPractice4;

insert into table3(attribute1) values('table3entry1');
insert into table3(attribute1) values('table3entry2');
insert into table3(attribute1) values('table3entry3');
insert into table3(attribute1) values('table3entry4');
insert into table3(attribute1) values('table3entry5');


insert into table1(attribute1) values('table1entry1');
insert into table1(attribute1) values('table1entry2');
insert into table1(attribute1) values('table1entry3');
insert into table1(attribute1) values('table1entry4');
insert into table1(attribute1) values('table1entry5');
insert into table1(attribute1) values('table1entry6');
insert into table1(attribute1) values('table1entry7');
insert into table1(attribute1) values('table1entry8');
insert into table1(attribute1) values('table1entry9');
insert into table1(attribute1) values('table1entry10');


insert into table2(attribute1) values('table2entry1');
insert into table2(attribute1) values('table2entry2');
insert into table2(attribute1) values('table2entry3');
insert into table2(attribute1) values('table2entry4');
insert into table2(attribute1) values('table2entry5');
insert into table2(attribute1) values('table2entry6');
insert into table2(attribute1) values('table2entry7');
insert into table2(attribute1) values('table2entry8');
insert into table2(attribute1) values('table2entry9');
insert into table2(attribute1) values('table2entry10');

insert into table1_table3(table1_id,table3_id) values(1,1);
insert into table1_table3(table1_id,table3_id) values(2,2);
insert into table1_table3(table1_id,table3_id) values(3,3);
insert into table1_table3(table1_id,table3_id) values(4,4);
insert into table1_table3(table1_id,table3_id) values(5,5);
insert into table1_table3(table1_id,table3_id) values(6,1);
insert into table1_table3(table1_id,table3_id) values(7,2);
insert into table1_table3(table1_id,table3_id) values(8,3);
insert into table1_table3(table1_id,table3_id) values(8,4);
insert into table1_table3(table1_id,table3_id) values(10,5);


insert into table2_table3(table2_id,table3_id) values(1,1);
insert into table2_table3(table2_id,table3_id) values(2,2);
insert into table2_table3(table2_id,table3_id) values(3,3);
insert into table2_table3(table2_id,table3_id) values(4,4);
insert into table2_table3(table2_id,table3_id) values(5,5);
insert into table2_table3(table2_id,table3_id) values(6,1);
insert into table2_table3(table2_id,table3_id) values(7,2);
insert into table2_table3(table2_id,table3_id) values(8,3);
insert into table2_table3(table2_id,table3_id) values(8,4);
insert into table2_table3(table2_id,table3_id) values(10,5);



commit;
select * from table3;
select * from table1;
select * from table2;
