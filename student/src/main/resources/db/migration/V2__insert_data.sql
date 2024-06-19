-- insert_student_data.sql
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'John', 'Doe', 'john.doe@example.com', 1);
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'Jane', 'Doe', 'jane.doe@example.com', 1);
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'Alice', 'Smith', 'alice.smith@example.com', 2);
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'Bob', 'Brown', 'bob.brown@example.com', 2);
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'Charlie', 'Johnson', 'charlie.johnson@example.com', 3);
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'Diana', 'Williams', 'diana.williams@example.com', 3);
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'Edward', 'Jones', 'edward.jones@example.com', 4);
INSERT INTO students.public.student (id, firstname, lastname, email, school_id) VALUES (nextval('students.public.student_seq'), 'Fiona', 'Taylor', 'fiona.taylor@example.com', 4);