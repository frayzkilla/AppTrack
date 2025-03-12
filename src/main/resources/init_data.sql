
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