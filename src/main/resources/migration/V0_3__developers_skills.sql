CREATE TABLE IF NOT EXISTS developers_skills
(
    id integer NOT NULL,
    developers_id integer NOT NULL,
    skills_id integer NOT NULL,
    CONSTRAINT developers_skills_pkey PRIMARY KEY (id),
    CONSTRAINT fk_developer_id FOREIGN KEY (developers_id)
        REFERENCES developers (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_skill_id FOREIGN KEY (skills_id)
        REFERENCES skills (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
