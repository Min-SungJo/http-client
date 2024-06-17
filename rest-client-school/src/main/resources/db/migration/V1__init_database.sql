-- init_database.sql
create table if not exists school
(
    id integer not null primary key,
    name varchar(255),
    email varchar(255)
);

create sequence if not exists school_seq increment by 50;