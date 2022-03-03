--CREATE SEQUENCE
CREATE SEQUENCE seq_todolist
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

--CREATE TABLE
CREATE TABLE IF NOT EXISTS todolist
(
    id bigint NOT NULL DEFAULT nextval('seq_todolist'::regclass),
    description character varying(255) NOT NULL,
    data timestamp without time zone NOT NULL,
    status boolean DEFAULT false
);

--CREATE PRIMARY KEY
ALTER TABLE todolist ADD CONSTRAINT pk_todo PRIMARY KEY (id);