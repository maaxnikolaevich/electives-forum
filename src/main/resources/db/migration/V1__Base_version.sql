CREATE SEQUENCE IF NOT EXISTS seq START WITH 1 INCREMENT BY 50;

CREATE TABLE author
(
    id          BIGINT NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE author_elective
(
    author_id   BIGINT NOT NULL,
    elective_id BIGINT NOT NULL
);

CREATE TABLE elective
(
    id                BIGINT NOT NULL,
    title             VARCHAR(255),
    short_description VARCHAR(255),
    full_description  VARCHAR(255),
    minor_id          BIGINT,
    CONSTRAINT pk_elective PRIMARY KEY (id)
);

CREATE TABLE institute
(
    id    BIGINT NOT NULL,
    title VARCHAR(255),
    CONSTRAINT pk_institute PRIMARY KEY (id)
);

CREATE TABLE minor
(
    id    BIGINT NOT NULL,
    title VARCHAR(255),
    CONSTRAINT pk_minor PRIMARY KEY (id)
);

CREATE TABLE review
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    user_id     BIGINT,
    elective_id BIGINT,
    CONSTRAINT pk_review PRIMARY KEY (id)
);

CREATE TABLE tag
(
    id    BIGINT NOT NULL,
    title VARCHAR(255),
    CONSTRAINT pk_tag PRIMARY KEY (id)
);

CREATE TABLE tag_elective
(
    elective_id BIGINT NOT NULL,
    tag_id      BIGINT NOT NULL
);

CREATE TABLE "user"
(
    id           BIGINT NOT NULL,
    login        VARCHAR(255),
    email        VARCHAR(255),
    institute_id BIGINT,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE elective
    ADD CONSTRAINT FK_ELECTIVE_ON_MINOR FOREIGN KEY (minor_id) REFERENCES minor (id);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_ELECTIVE FOREIGN KEY (elective_id) REFERENCES elective (id);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE "user"
    ADD CONSTRAINT FK_USER_ON_INSTITUTE FOREIGN KEY (institute_id) REFERENCES institute (id);

ALTER TABLE author_elective
    ADD CONSTRAINT fk_autele_on_author FOREIGN KEY (author_id) REFERENCES author (id);

ALTER TABLE author_elective
    ADD CONSTRAINT fk_autele_on_elective FOREIGN KEY (elective_id) REFERENCES elective (id);

ALTER TABLE tag_elective
    ADD CONSTRAINT fk_tagele_on_elective FOREIGN KEY (elective_id) REFERENCES elective (id);

ALTER TABLE tag_elective
    ADD CONSTRAINT fk_tagele_on_tag FOREIGN KEY (tag_id) REFERENCES tag (id);

DROP TABLE alembic_version CASCADE;