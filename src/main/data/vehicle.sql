create database vehicle;

create table carcase(
                     carcase_id   serial primary key,
                     carcase_name varchar(255)
);

create table engine(
                      engine_id   serial primary key,
                      engine_name varchar(255)
);

create table gearbox(
                    gearbox_id   serial primary key,
                    gearbox_name varchar(255)
);

create table vehicle(
                    id serial primary key,
                    name varchar(255),
                    carcase int references carcase(carcase_id) not null,
                    engine int references engine(engine_id) not null,
                    gearbox int references gearbox(gearbox_id) not null
);

insert into carcase (carcase_name) values ('coupe'),('sports car'),('wagon');
insert into engine (engine_name) values ('v6'),('v12'),('v10');
insert into gearbox (gearbox_name) values ('automatic'),('mechanic'),('robotics');
insert into vehicle (name,carcase,engine,gearbox)  values ('Mercedes Benz',2,3,1);
insert into vehicle (name,carcase,engine,gearbox)  values ('Audi',3,1,3);
insert into vehicle (name,carcase,engine,gearbox)  values ('BMW',1,2,2);

select vehicle.name, b.carcase_name, m.engine_name, b2.gearbox_name
from vehicle
         join engine m on vehicle.engine = m.engine_id
         join gearbox b2 on vehicle.gearbox = b2.gearbox_id
         join carcase  b on vehicle.carcase = b.carcase_id;

select carcase.carcase_name as unused_carcase
from carcase
         left join vehicle c
                   on carcase.carcase_id = c.carcase
where c.name is null;

select engine.engine_name as unused_engine
from engine
         left join vehicle c
                   on engine.engine_id = c.engine
where c.name is null;

select gearbox.gearbox_name as unused_gearbox
from gearbox
         left join vehicle c
                   on gearbox.gearbox_id = c.gearbox
where c.name is null;
