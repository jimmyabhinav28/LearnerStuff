drop schema if exists metro;
create schema metro;
use metro;
drop table if exists train;
create table train
(id bigint(10) primary key auto_increment,
number_of_coaches int,
special_name varchar(200),
last_maintainance_date date,
service_begin_date date,
vendor_name varchar(200)
);

insert into train(number_of_coaches,special_name,service_begin_date,vendor_name) values(6,'AnkitaExpress',now(),'Bombardier');
insert into train(number_of_coaches,special_name,service_begin_date,vendor_name) values(6,'AbhinavExpress',now(),'Bombardier');
commit;