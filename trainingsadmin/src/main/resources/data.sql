insert into training (id, title, description, points_needed, created, updated) 
values (10001, 'First training', 'the first one', 10, sysdate(), sysdate());

insert into training (id, title, description, points_needed, created, updated) 
values (10002, 'Second training', 'the second one', 20, sysdate(), sysdate());

insert into training (id, title, description, points_needed, created, updated) 
values (10003, 'Third training', 'the third one', 15, sysdate(), sysdate());


insert into passport (id, id_number)
values (40001, 'E123456');

insert into passport (id, id_number)
values (40002, 'E6565474');

insert into passport (id, id_number)
values (40003, 'E986453');

 
insert into student (id, firstname, lastname, passport_id)
values (20001, 'Massi', 'Brero', 40001);

insert into student (id, firstname, lastname, passport_id)
values (20002, 'Joe', 'Flat', 40002);

insert into student (id, firstname, lastname, passport_id)
values (20003, 'Susan', 'Sharp', 40003);


insert into review (id, rating, description, training_id)
values (50001, '5', 'Great Course', 10001);

insert into review (id, rating, description, training_id)
values (50002, '4', 'Nice One', 10001);

insert into review (id, rating, description, training_id)
values (50003, '5', 'Liked it...', 10003);


insert into student_training (student_id, training_id)
values (20001, 10001);

insert into student_training (student_id, training_id)
values (20002, 10001);

insert into student_training (student_id, training_id)
values (20003, 10001);

insert into student_training (student_id, training_id)
values (20001, 10003);