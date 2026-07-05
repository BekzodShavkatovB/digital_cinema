CREATE TABLE IF NOT EXISTS movies (
                                      id BIGSERIAL PRIMARY KEY,
                                      title VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    duration_minutes INTEGER NOT NULL,
    release_date DATE
    );

CREATE TABLE IF NOT EXISTS cinemas (
                                       id BIGSERIAL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    city VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS halls (
                                     id BIGSERIAL PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
    cinema_id BIGINT REFERENCES cinemas(id)
    );

CREATE TABLE IF NOT EXISTS seats (
                                     id BIGSERIAL PRIMARY KEY,
                                     row_number INTEGER NOT NULL,
                                     seat_number INTEGER NOT NULL,
                                     hall_id BIGINT REFERENCES halls(id)
    );

CREATE TABLE IF NOT EXISTS sessions (
                                        id BIGSERIAL PRIMARY KEY,
                                        start_time TIMESTAMP NOT NULL,
                                        movie_id BIGINT REFERENCES movies(id),
    hall_id BIGINT REFERENCES halls(id)
    );

CREATE TABLE IF NOT EXISTS bookings (
                                        id BIGSERIAL PRIMARY KEY,
                                        customer_name VARCHAR(255),
    session_id BIGINT REFERENCES sessions(id),
    seat_id BIGINT REFERENCES seats(id)
    );