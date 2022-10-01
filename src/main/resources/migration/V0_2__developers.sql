CREATE TABLE IF NOT EXISTS developers
(
    id integer NOT NULL,
    firstname character varying(20) ,
    lastname character varying(20) ,
    status character varying(20) ,
    specialty_id integer NOT NULL,
    CONSTRAINT developers_pkey PRIMARY KEY (id),
    CONSTRAINT fk_developers_specialty FOREIGN KEY (specialty_id)
        REFERENCES specialty (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
