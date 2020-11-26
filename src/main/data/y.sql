create database y;

create table departments (
                             id serial primary key ,
                             name varchar(255)
);

create table emploees(
                           emploees_id serial primary key ,
                           name varchar(255),
                           department_id int references departments(id)
);

insert into departments(name)
values ('one'), ('two'), ('three');

insert into emploees(name, department_id)
values ('Stan', 1), ('Finn', 2), ('Pol', 3),
       ('Alexander', 1), ('Alex', 2);



select * from emploees e
                  left join departments d
                            on e.department_id = d.id;

select * from departments d
                  right join emploees e
                             on d.id = e.department_id;

select * from departments d
                  full join emploees e
                            on d.id = e.department_id;

select * from departments d
                  cross join emploees e;



select * from emploees e
                  left join departments d
                            on e.department_id = d.id
where  e.department_id is null;



SELECT * FROM emploees e
                  LEFT JOIN departments d
                            ON e.department_id = d.id;

SELECT * FROM departments d
                  RIGHT JOIN emploees e
                             ON d.id = e.department_id;



CREATE TABLE teens(
                      id SERIAL PRIMARY KEY,
                      name VARCHAR (255),
                      gender CHAR (1)
);

INSERT INTO teens(name, gender)
VALUES ('Mike', 'Male'), ('Gustav', 'Male'), ('Rebecka', 'Female'), ('Luci', 'Female'), ('Chris', 'Male'), ('Vanessa', 'Female');

SELECT t1.name, concat(t1.gender, t2.gender) as pol, t2.name FROM teens t1 CROSS JOIN teens t2
WHERE t1.gender <> t2.gender;