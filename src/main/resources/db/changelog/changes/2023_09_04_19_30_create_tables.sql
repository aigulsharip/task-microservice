CREATE TABLE tasks (
    id            BIGSERIAL PRIMARY KEY,
    title         VARCHAR(255),
    description   TEXT,
    date_created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    date_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date      TIMESTAMP,
    task_status   VARCHAR(50) DEFAULT 'NEW',
    author_id     NUMERIC
);