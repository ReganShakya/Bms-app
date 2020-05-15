create database bms_app;
use bms_app;

create table tbl_employees(id serial primary key,
 first_name varchar(50), last_name varchar(50), email varchar(50),
 contact_no varchar(50), address varchar(50), 
status boolean default true);

create table mst_tasks(id serial primary key,task_name varchar(100), rate bigint unsigned);


create table tbl_employees_daily_activities(id serial primary key,
working_date date default CURRENT_TIMESTAMP,
 employee_id bigint unsigned, task_id bigint unsigned, 
quantity bigint unsigned, amount bigint unsigned);

alter table tbl_employees_daily_activities add foreign key (employee_id)
references tbl_employees(id);

alter table tbl_employees_daily_activities add foreign key (task_id)
references tbl_tasks(id);


create table tbl_salary (id serial primary key,
employee_id bigint unsigned, total_salary bigint unsigned,
status boolean default true, created_date timestamp default CURRENT_TIMESTAMP);

alter table tbl_salary add foreign key (employee_id) references
tbl_employees(id);

create table mst_roles(id serial primary key,
role_name varchar(100));

insert into mst_roles(role_name)
values('admin'),('user');

create table tbl_users(id serial primary key,
username varchar(100), password varchar(100), email varchar(100),
 role_id bigint unsigned, created_date timestamp default current_timestamp,
status boolean);

alter table tbl_users add foreign key (role_id) references
mst_roles(id);

create table tbl_salary(id serial primary key, user_id bigint unsigned,
amount bigint unsigned);

alter table tbl_salary add foreign key (user_id) references tbl_employees_daily_activities(user_id);

insert into tbl_users(username, password, email,role_id, status)
values('admin','$2a$10$F4O3kX4K4aYk2eytHvnQCuQGx9pCAE2V2OxDpmhS18Of/XXnlHM16',
'reganshakya@gmail.com',1,1);

insert into tbl_users(username, password, email,role_id, status)
values('regan','$2a$10$F4O3kX4K4aYk2eytHvnQCuQGx9pCAE2V2OxDpmhS18Of/XXnlHM16',
'regan_shakya@gmail.com',1,1);

-- Query for making salary table
SELECT u.user_id, a.username, SUM(u.amount) FROM tbl_employees_daily_activities
    u inner join tbl_users a on a.id=u.user_id GROUP BY u.user_id;

-- Query for selecting activity of specified users
select * from tbl_employees_daily_activities a inner join tbl_users e
     on e.id=a.user_id where e.username="SitaRam";

-- Query for selecting salary of specified users
SELECT u.user_id, u.username, u.amount FROM 
    (SELECT u.user_id, a.username, SUM(u.amount) as amount FROM 
    tbl_employees_daily_activities u inner join tbl_users a on a.id=u.user_id GROUP BY u.user_id )
     u where u.username="SitaRam"


insert into tbl_salary(user_id,username,amount) SELECT u.user_id, a.username, SUM(u.amount) as amount FROM tbl_employees_daily_activities u inner join tbl_users a on a.id=u.user_id GROUP BY u.user_id


