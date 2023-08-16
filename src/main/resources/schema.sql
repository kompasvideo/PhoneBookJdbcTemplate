CREATE TABLE phonebook(
                          phonebook_id int GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                          first_name VARCHAR(30),
                          last_name VARCHAR(30),
                          three_name VARCHAR(30),
                          number_phone VARCHAR(30),
                          address VARCHAR(30),
                          description VARCHAR(30),
                          CONSTRAINT pk_phonebook PRIMARY KEY (phonebook_id)
);

INSERT INTO phonebook (last_name, first_name, three_name, number_phone, address, description)
VALUES
    ('Ivanov', 'Ivan', 'Ivanovich','+7(919)154-56-78', 'st. Lenina 1, 15', 'worker'),
    ('Petrov', 'Petr', 'Petrovich','+7(919)154-56-79', 'st. Petrova 7, 3', 'worker'),
    ('Sidorov', 'Sidor', 'Sidorovich', '+7(919)154-56-80', 'st. Pushkina 4, 1', 'worker')