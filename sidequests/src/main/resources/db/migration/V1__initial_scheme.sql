-- CREATE TABLE users (
--     id SERIAL PRIMARY KEY NOT NULL,
--     name VARCHAR(50) NOT NULL,
--     password VARCHAR(255) NOT NULL
-- );

CREATE TABLE daily_tasks (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL,
    description TEXT,
    completed BOOL NOT NULL DEFAULT ('FALSE')
--     user_id INTEGER NOT NULL,
--     FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE yearly (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL,
    description TEXT,
    completed BOOL NOT NULL DEFAULT ('FALSE')
--     user_id INTEGER NOT NULL,
--     FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE quinquennially (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL,
    description TEXT,
    completed BOOL NOT NULL DEFAULT ('FALSE')
--     user_id INTEGER NOT NULL,
--     FOREIGN KEY (user_id) REFERENCES users(id)
);