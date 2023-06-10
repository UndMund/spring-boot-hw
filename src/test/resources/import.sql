INSERT INTO company (name) VALUES ('Google');
INSERT INTO company (name) VALUES ('Meta');
INSERT INTO company (name) VALUES ('Amazon');

INSERT INTO company_locales (company_id, lang, description) VALUES ((SELECT id FROM company WHERE name = 'Google'), 'en', 'Google description');
INSERT INTO company_locales (company_id, lang, description) VALUES ((SELECT id FROM company WHERE name = 'Google'), 'ru', 'Google описание');
INSERT INTO company_locales (company_id, lang, description) VALUES ((SELECT id FROM company WHERE name = 'Meta'), 'en', 'Meta description');
INSERT INTO company_locales (company_id, lang, description) VALUES ((SELECT id FROM company WHERE name = 'Meta'), 'ru', 'Meta описание');
INSERT INTO company_locales (company_id, lang, description) VALUES ((SELECT id FROM company WHERE name = 'Amazon'), 'en', 'Amazon description');
INSERT INTO company_locales (company_id, lang, description) VALUES ((SELECT id FROM company WHERE name = 'Amazon'), 'ru', 'Amazon описание');

INSERT INTO users (birth_date, firstname, lastname, role, username, company_id) VALUES ('1990-01-10', 'Ivan', 'Ivanov', 'ADMIN', 'ivan@gmail.com', (SELECT id FROM company WHERE name = 'Google'));
INSERT INTO users (birth_date, firstname, lastname, role, username, company_id) VALUES ('1995-10-19', 'Petr', 'Petrov', 'USER', 'petr@gmail.com', (SELECT id FROM company WHERE name = 'Google'));
INSERT INTO users (birth_date, firstname, lastname, role, username, company_id) VALUES ('2001-12-23', 'Sveta', 'Svetikova', 'USER', 'sveta@gmail.com', (SELECT id FROM company WHERE name = 'Meta'));
INSERT INTO users (birth_date, firstname, lastname, role, username, company_id) VALUES ('1984-03-14', 'Vlad', 'Vladikov', 'USER', 'vlad@gmail.com', (SELECT id FROM company WHERE name = 'Amazon'));
INSERT INTO users (birth_date, firstname, lastname, role, username, company_id) VALUES ('1984-03-14', 'Kate', 'Smith', 'ADMIN', 'kate@gmail.com', (SELECT id FROM company WHERE name = 'Amazon'));


INSERT INTO payment (amount, receiver_id) VALUES (100, (SELECT id FROM users WHERE username = 'ivan@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (300, (SELECT id FROM users WHERE username = 'ivan@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (500, (SELECT id FROM users WHERE username = 'ivan@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (250, (SELECT id FROM users WHERE username = 'petr@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (600, (SELECT id FROM users WHERE username = 'petr@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (500, (SELECT id FROM users WHERE username = 'petr@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (400, (SELECT id FROM users WHERE username = 'sveta@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (300, (SELECT id FROM users WHERE username = 'sveta@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (500, (SELECT id FROM users WHERE username = 'vlad@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (700, (SELECT id FROM users WHERE username = 'vlad@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (340, (SELECT id FROM users WHERE username = 'vlad@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (440, (SELECT id FROM users WHERE username = 'kate@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (510, (SELECT id FROM users WHERE username = 'kate@gmail.com'));
INSERT INTO payment (amount, receiver_id) VALUES (630, (SELECT id FROM users WHERE username = 'kate@gmail.com'));


INSERT INTO chat (name) VALUES ('minsk');
INSERT INTO chat (name) VALUES ('java');
INSERT INTO chat (name) VALUES ('database');


INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'ivan@gmail.com'), (SELECT id FROM chat WHERE name = 'minsk'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'petr@gmail.com'), (SELECT id FROM chat WHERE name = 'minsk'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'sveta@gmail.com'), (SELECT id FROM chat WHERE name = 'minsk'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'petr@gmail.com'), (SELECT id FROM chat WHERE name = 'java'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'sveta@gmail.com'), (SELECT id FROM chat WHERE name = 'java'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'vlad@gmail.com'), (SELECT id FROM chat WHERE name = 'java'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'kate@gmail.com'), (SELECT id FROM chat WHERE name = 'java'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'petr@gmail.com'), (SELECT id FROM chat WHERE name = 'database'));
INSERT INTO users_chat(user_id, chat_id) VALUES ((SELECT id FROM users WHERE username = 'kate@gmail.com'), (SELECT id FROM chat WHERE name = 'database'));