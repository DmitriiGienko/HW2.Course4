CREATE TABLE employee(
    id SERIAL PRIMARY KEY NOT NULL ,
    name VARCHAR(255),
    salary INT,
    FOREIGN KEY (position_id) REFERENCES position (position_id)
);