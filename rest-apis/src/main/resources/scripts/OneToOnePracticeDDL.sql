drop schema if exists jpaPractice1;
create schema jpaPractice1;

drop table if exists table1;
create table table1
{id bigint(10) primary key auto_increment,
attribute1 varchar(20)
}ENGINE=InnoDB ;;

drop table if exists table2;
create table table2
{id bigint(10) primary key auto_increment,
attribute1 varchar(20)
}ENGINE=InnoDB ;;

drop table if exists table3;
create table table3
{id bigint(10) primary key auto_increment,
attribute1 varchar(20),
table1_id bigint(10),
table2_id bigint(10),
CONSTRAINT FOREIGN KEY (table1_id) REFERENCES table1(id),
CONSTRAINT FOREIGN KEY (table2_id) REFERENCES table2(id)
}ENGINE=InnoDB ;;