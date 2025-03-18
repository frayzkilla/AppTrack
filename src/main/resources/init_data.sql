
INSERT INTO users (email, password, first_name, last_name, role) VALUES ('admin@gmail.com', '{noop}123', 'Алексей', 'Соколов', 'USER');
INSERT INTO users (email, password, first_name, last_name, role) VALUES ('user@gmail.com', '{noop}123', 'Иван', 'Сидоров', 'USER');
INSERT INTO users (email, password, first_name, last_name, role) VALUES ('frayz@gmail.com', '{noop}123', 'Евгения', 'Цирипали', 'USER');
INSERT INTO users (email, password, first_name, last_name, role) VALUES ('mysh@gmail.com', '{noop}123', 'Александра', 'Греймер', 'USER');

INSERT INTO departments (name) VALUES ('Электрика и сети')
INSERT INTO departments (name) VALUES ('Сантехника и водоснабжение')
INSERT INTO departments (name) VALUES ('Уборка и благоустройство')

INSERT INTO users (department_id, email, password, first_name, last_name, role) VALUES ('2', 'moder@apptrack.isu', '{noop}000', 'OhModer', 'Iwanu', 'MODERATOR')
INSERT INTO users (department_id, email, password, first_name, last_name, role) VALUES ('1', 'mclovin@apptrack.isu', '{noop}001', 'Lloyd', 'Summers', 'MODERATOR')
INSERT INTO users (department_id, email, password, first_name, last_name, role) VALUES ('3', 'clean@apptrack.isu', '{noop}002', 'Simple', 'Clean', 'MODERATOR')

INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('3', '2', '17.01.2025', '0', 'Прошу перекрасить стены в подъезде номер 2 по адресу Лермонтова 303')
INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('2', '1', '16.01.2025', '0', 'По адресу Старокузьмихинская 46 при включении горячей воды, 2 минуты идет холодная')
INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('2', '4', '19.01.2025', '0', 'Пискунова 90 - подтекает вода из трубы в 1 подъезде')
INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('1', '3', '20.01.2025', '0', 'Комсомольская 2а/1, пятый подъезд, скачки напряжения и мигающий свет уже неделю')
INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('1', '1', '21.01.2025', '0', 'По адресу Пушкина 15, требуется замена ламп в подъезде.');
INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('3', '2', '22.01.2025', '0', 'Необходимо провести уборку территории вокруг дома по адресу Лермонтова 45.');
INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('2', '3', '23.01.2025', '0', 'На улице Гагарина 10 наблюдается затопление после дождя, требуется устранить проблему.');
INSERT INTO applications (department_id, user_id, creation_date, state, text) VALUES ('3', '4', '25.01.2025', '0', 'Установка новых почтовых ящиков по адресу Тихая 12.');

INSERT INTO genre (id, name) VALUES (1, 'Action');
INSERT INTO genre (id, name) VALUES (2, 'Drama');
INSERT INTO genre (id, name) VALUES (3, 'Comedy');
INSERT INTO genre (id, name) VALUES (4, 'Thriller');
INSERT INTO genre (id, name) VALUES (5, 'Sci-Fi');
INSERT INTO genre (id, name) VALUES (6, 'Horror');

INSERT INTO director (id, name) VALUES (1, 'Christopher Nolan');
INSERT INTO director (id, name) VALUES (2, 'Quentin Tarantino');
INSERT INTO director (id, name) VALUES (3, 'David Fincher');
INSERT INTO director (id, name) VALUES (4, 'Wes Anderson');
INSERT INTO director (id, name) VALUES (5, 'James Cameron');
INSERT INTO director (id, name) VALUES (6, 'John Carpenter');
INSERT INTO director (id, name) VALUES (7, 'Wes Craven');
INSERT INTO director (id, name) VALUES (8, 'Ari Aster');
INSERT INTO director (id, name) VALUES (9, 'James Wan');
INSERT INTO director (id, name) VALUES (10, 'Jordan Peele');

INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (1, 'Inception', 8.8, 2010, 1, 1);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (2, 'Pulp Fiction', 8.9, 1994, 2, 2);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (3, 'Interstellar', 8.6, 2014, 1, 1);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (4, 'Fight Club', 8.8, 1999, 4, 3);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (5, 'The Matrix', 8.7, 1999, 5, 5);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (6, 'Alien', 8.5, 1979, 6, 5);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (7, 'The Grand Budapest Hotel', 8.1, 2014, 3, 4);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (8, 'Se7en', 8.6, 1995, 4, 3);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (9, 'Titanic', 7.9, 1997, 2, 5);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (10, 'Halloween', 7.7, 1978, 6, 6);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (11, 'A Nightmare on Elm Street', 7.5, 1984, 6, 7);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (12, 'Hereditary', 7.3, 2018, 6, 8);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (13, 'The Conjuring', 7.5, 2013, 6, 9);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (14, 'Get Out', 7.8, 2017, 6, 10);
INSERT INTO film (id, title, rating, year, genre_id, director_id) VALUES (15, 'The Thing', 8.2, 1982, 6, 6);