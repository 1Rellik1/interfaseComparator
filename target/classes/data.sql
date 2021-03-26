SELECT uuid_generate_v1();
INSERT INTO Game (id, name, creation_year) VALUES
(uuid_generate_v1(), 'First', 2001),
(uuid_generate_v1(), 'Second', 1994),
(uuid_generate_v1(), 'Third', 2012),
(uuid_generate_v1(), 'Fourth', 2016);

SELECT uuid_generate_v1();
INSERT INTO Level (id, name, complexity) VALUES
(uuid_generate_v1(), 'First', 'Easy'),
(uuid_generate_v1(), 'Second', 'Crazy'),
(uuid_generate_v1(), 'Third', 'Hard'),
(uuid_generate_v1(), 'Fourth', 'Easy');