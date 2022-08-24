DROP DATABASE IF EXISTS GuessTheNumberDBtest;
CREATE DATABASE GuessTheNumberDBtest;
USE GuessTheNumberDBtest;

CREATE TABLE game(
	game_id INT PRIMARY KEY AUTO_INCREMENT,
    answer char(4),
    finished BOOLEAN DEFAULT false);

INSERT INTO game(game_id, answer, finished) VALUES
	(1, "1234", true),
    (2, "5678", true);

CREATE TABLE round (
	round_id INT PRIMARY KEY AUTO_INCREMENT,
    game_id INT NOT NULL,
    guess_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    guess char(4),
    result char(9),
    FOREIGN KEY fk_game_id (game_id) REFERENCES game(game_id));

INSERT INTO round (round_id, game_id, guess_time, guess, result) VALUES
	(1, 1, "2022-07-07 08:08:18", "1234", "e:4:p:0"),
    (2, 2, "2022-07-07 09:09:19", "5987", "e:1:p:2"),
    (3, 2, "2022-07-07 10:01:11", "5768", "e:2:p:2");

SELECT * from game;
SELECT * from round;