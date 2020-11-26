create database person;
create table person
(
    id   serial primary key,
    name varchar(255),
    area text,
    room int,
    Salary money
);

insert into person(name, area, room, Salary) values ('Alex', 'Canada', '123', '400');
update person set Salary = 550;
delete from person;
select * from person;
