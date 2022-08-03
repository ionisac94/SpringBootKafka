CREATE TABLE IF NOT EXISTS postgres.student2 (
    id integer NOT NULL,
    address character varying(255),
    name character varying(255),
    salary integer,
    CONSTRAINT student_pkey PRIMARY KEY (id)
)