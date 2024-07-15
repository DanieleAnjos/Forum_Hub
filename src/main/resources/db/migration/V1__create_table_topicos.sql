CREATE TABLE topicos (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         mensagem VARCHAR(1000) NOT NULL,
                         autor VARCHAR(255) NOT NULL,
                         curso_nome VARCHAR(255) NOT NULL
);