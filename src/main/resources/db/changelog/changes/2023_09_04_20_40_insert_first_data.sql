INSERT INTO tasks (title, description, date_created, date_modified, due_date, status, author_id)
VALUES
    ('First Task', 'Do first task', NOW(), NULL, NOW() + INTERVAL '5 days', 'NEW', 0),
    ('Second Task', 'Do second task', NOW(), NULL, NOW() + INTERVAL '6 days', 'NEW', 0),
    ('Third Task', 'Do third task', NOW(), NULL, NOW() + INTERVAL '7 days', 'NEW', 0),
    ('Fourth Task', 'Do fourth task', NOW(), NULL, NOW() + INTERVAL '8 days', 'NEW', 0);