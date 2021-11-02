insert into user (username, password, enabled, role) values ('elte', 'elte', true, 'ROLE_USER');
insert into user (username, password, enabled, role) values ('tameem', 'tameem', true, 'ROLE_GUEST');
insert into user (username, password, enabled, role) values ('messi', 'messi', true, 'ROLE_USER');
insert into user (username, password, enabled, role) values ('ronaldo', 'ronaldo', true, 'ROLE_USER');
 
insert into task (user_id, title, description) values (1, 'task1', 'description1');
insert into task (user_id, title, description) values (1, 'task1', 'description1');
insert into task (user_id, title, description) values (2, 'task2', 'description1');
insert into task (user_id, title, description) values (2, 'task2', 'description1');

insert into solution (task_id, text, created_at, updated_at) values (1, 'solution1', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into solution (task_id, text, created_at, updated_at) values (1, 'solution2', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into solution (task_id, text, created_at, updated_at) values (2, 'solution3', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into solution (task_id, text, created_at, updated_at) values (3, 'solution4', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into solution (task_id, text, created_at, updated_at) values (4, 'solution5', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into solver (tasksolver, usersolver) values (1,1);
insert into solver (tasksolver, usersolver) values (1,2);
insert into solver (tasksolver, usersolver) values (1,3);
insert into solver (tasksolver, usersolver) values (2,1);
insert into solver (tasksolver, usersolver) values (2,2);
insert into solver (tasksolver,usersolver) values (2,3);




