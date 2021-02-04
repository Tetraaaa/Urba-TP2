INSERT INTO user (id, firstname, lastname) VALUES (1, 'Nicolas', 'Strohl')
INSERT INTO user (id, firstname, lastname) VALUES (2, 'Thomas', 'Personeni')
INSERT INTO user (id, firstname, lastname) VALUES (3, 'Quentin', 'Schaeffer')
INSERT INTO user (id, firstname, lastname) VALUES (4, 'Antoine', 'Pritzy')

INSERT INTO account (id, money, user_id) VALUES (1, 100, 1)
INSERT INTO account (id, money, user_id) VALUES (2, 250, 2)
INSERT INTO account (id, money, user_id) VALUES (3, 520, 3)
INSERT INTO account (id, money, user_id) VALUES (4, 1900, 4)

INSERT INTO deposit (id, amount, depositaire, account) VALUES (1, 52, 1, 1)
INSERT INTO deposit (id, amount, depositaire, account) VALUES (2, 79, 2, 1)

INSERT INTO withdrawal (id, amount, beneficiaire, account) VALUES (1, 300, 1, 1)
INSERT INTO withdrawal (id, amount, beneficiaire, account) VALUES (2, 300, 2, 2)