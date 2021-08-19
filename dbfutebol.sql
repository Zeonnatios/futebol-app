DROP DATABASE dbfutebol;
CREATE DATABASE dbfutebol;
USE dbfutebol;

CREATE TABLE time (
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
gols INT NULL,
pontos INT NULL,
partidas INT NULL,
vitorias INT NULL,
empates INT NULL,
derrotas INT NULL,
PRIMARY KEY (id)
);

CREATE TABLE partidas (
id INT NOT NULL AUTO_INCREMENT,
time_casa varchar(50) NULL,
time_visitante varchar(50) NULL,
gols_casa INT NULL,
gols_visitante INT NULL,
PRIMARY KEY (id)
);

INSERT INTO `time` (`nome`, `gols`, `pontos`,`partidas`, `vitorias`, `empates`, `derrotas`) VALUES 
('Atletico-MG', '0', '0', '0', '0', '0', '0'),
('Internacional', '0', '0', '0', '0', '0', '0'), 
('Sao Paulo', '0', '0', '0', '0', '0', '0'), 
('Flamengo', '0', '0', '0', '0', '0', '0'),
('Palmeiras', '0', '0', '0', '0', '0', '0'),
('Santos', '0', '0', '0', '0', '0', '0'),
('Gremio', '0', '0', '0', '0', '0', '0'),
('Fluminense', '0', '0', '0', '0', '0', '0'),
('Bahia', '0', '0', '0', '0', '0', '0'),
('Atletico-PR', '0', '0', '0', '0', '0', '0'),
('Sport Recife', '0', '0', '0', '0', '0', '0'),
('Fortaleza', '0', '0', '0', '0', '0', '0'),
('Corinthians', '0', '0', '0', '0', '0', '0'),
('Ceara SC', '0', '0', '0', '0', '0', '0'),
('Atletico-GO', '0', '0', '0', '0', '0', '0'),
('Vasco da Gama', '0', '0', '0', '0', '0', '0'),
('Bragantino', '0', '0', '0', '0', '0', '0'),
('Coritiba', '0', '0', '0', '0', '0', '0'), 
('Botafogo', '0', '0', '0', '0', '0', '0'),
('Goias', '0', '0', '0', '0', '0', '0');
