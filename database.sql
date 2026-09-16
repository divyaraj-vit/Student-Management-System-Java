CREATE TABLE IF NOT EXISTS students (
    id INTEGER PRIMARY KEY,
    name TEXT NOT NULL,
    course TEXT NOT NULL,
    java_marks INTEGER,
    dbms_marks INTEGER,
    networking_marks INTEGER
);

-- Example query:
SELECT * FROM students;

-- Example search:
SELECT * FROM students WHERE id = 1;
