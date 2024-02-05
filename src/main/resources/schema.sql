CREATE TABLE IF NOT EXISTS Profile (
    id INTEGER AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    calorie_goal INTEGER NOT NULL,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS FitnessData (
    id INTEGER AUTO_INCREMENT,
    profile_id INTEGER NOT NULL,
    date VARCHAR(255) NOT NULL,
    total_calories INTEGER NOT NULL,
    calories_burned INTEGER NOT NULL,
    primary key (id)
);

INSERT INTO Profile(username, calorie_goal)
VALUES ('michaeljgoerlitz', 2500);

INSERT INTO FitnessData(profile_id, date, total_calories, calories_burned)
VALUES (1, '2024-01-01', 1700, 130);