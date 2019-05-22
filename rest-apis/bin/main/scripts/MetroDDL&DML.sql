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
route_name varchar(200),
route_from varchar(200),
route_to varchar(200),
route_start_date date,
route_end_date date
);

insert into route(route_name,route_from,route_to,route_start_date) values ('Blue Line','Nagole','HITECH City',now());

-- one station incharge per station

drop table if exists station_incharge;
create table station_incharge
(id bigint(10) primary key auto_increment,
metro_employee_id bigint(10) not null,
incharge_name varchar(200),
station_assignment_start_date date
);

drop table if exists station_engineer;
create table station_engineer
(id bigint(10) primary key auto_increment,
metro_employee_id bigint(10) not null,
engineer_name varchar(200),
station_assignment_start_date date
);
insert into station_incharge(metro_employee_id,incharge_name,station_assignment_start_date) values (10,'Benedict Cumberbatch',now());
insert into station_incharge(metro_employee_id,incharge_name,station_assignment_start_date) values (1,'Shahrukh Khan',now());
insert into station_engineer(metro_employee_id,engineer_name,station_assignment_start_date) values (11,'Tony Stark',now());
insert into station_engineer(metro_employee_id,engineer_name,station_assignment_start_date) values (12,'Bruce Wayne',now());
drop table if exists station;
create table station
(id bigint(10) primary key auto_increment,
station_name varchar(200),
start_date date,
station_incharge_id bigint(10) references station_incharge(id), 
station_engineer_id bigint(10),
CONSTRAINT FOREIGN KEY (station_engineer_id) REFERENCES station_engineer(id) ON DELETE CASCADE -- ON UPDATE cascade
)ENGINE=InnoDB ;

insert into station(station_name,start_date,station_incharge_id,station_engineer_id) values('Nagole',now(),2,1);
insert into station(station_name,start_date,station_incharge_id,station_engineer_id) values('HITECH City',now(),1,2);

commit;
