-- init_database.sql
create table if not exists student
(
    id integer not null primary key,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255),
    school_id integer
);

create sequence if not exists student_seq increment by 50;