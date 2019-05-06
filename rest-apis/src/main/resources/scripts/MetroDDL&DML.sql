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

drop table if exists route;
create table route
(id bigint(10) primary key auto_increment,
route_from varchar(200),
route_to varchar(200),
route_start_date date,
route_end_date date
);

drop table if exists station;
create table station
(id bigint(10) primary key auto_increment,
station_name varchar(200),
start_date date
);

-- one station incharge per station

drop table if exists station_incharge;
create table station_incharge
(id bigint(10) primary key auto_increment,
metro_employee_id bigint(10) not null,
name varchar(200),
station_assignment_start_date date
);