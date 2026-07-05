INSERT INTO movies (title, description, duration_minutes, release_date)
VALUES ('Inception', 'A thief who steals corporate secrets.', 148, '2010-07-16');

INSERT INTO cinemas (name, city) VALUES ('Silver Screen', 'Tashkent');

INSERT INTO halls (name, cinema_id) VALUES ('Main Hall', 1);

INSERT INTO seats (row_number, seat_number, hall_id) VALUES (1, 1, 1), (1, 2, 1);