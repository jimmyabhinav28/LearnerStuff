-- many to many relationships
drop schema if exists ManyToManyBidirectional1;
create schema ManyToManyBidirectional1;
use ManyToManyBidirectional1;

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


-- associataion table without extra attributes
drop table if exists table1_table3;
create table table1_table3
(table1_id bigint(10),
table3_id bigint(10), 
PRIMARY KEY(table1_id,table3_id),
CONSTRAINT FOREIGN KEY (table3_id) REFERENCES table3(id),
CONSTRAINT FOREIGN KEY (table1_id) REFERENCES table1(id)
)ENGINE=InnoDB ;

use ManyToManyBidirectional1;

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


insert into table1_table3(table1_id,table3_id) values(1,1);
insert into table1_table3(table1_id,table3_id) values(1,2);
insert into table1_table3(table1_id,table3_id) values(2,1);
insert into table1_table3(table1_id,table3_id) values(2,2);

commit;
select * from table3;
select * from table1;
