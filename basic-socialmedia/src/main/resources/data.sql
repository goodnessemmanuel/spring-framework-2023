-- this does not get executed when you are connected to databases(e.g mysql, postgres) that is not h2
INSERT INTO tb_users(id, name, date_of_birth)
VALUES ( 1001, 'oche', current_date),
       ( 1002, 'Gabriel', current_date),
       ( 1003, 'Peter', current_date);