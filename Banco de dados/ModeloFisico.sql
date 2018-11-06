/* Lógico_1: */

CREATE TABLE Pessoa (
    nome VARCHAR,
    email VARCHAR,
    telefone VARCHAR,
    endereco VARCHAR,
    id_pessoa INTEGER PRIMARY KEY,
    cpf VARCHAR
);

CREATE TABLE Funcionario (
    login VARCHAR,
    senha VARCHAR,
    id_funcionario INTEGER PRIMARY KEY,
    tipo INTEGER,
    fk_id_pessoa INTEGER REFERENCES Pessoa(id_pessoa) ON UPDATE CASCADE
);

CREATE TABLE Cliente (
    cartao_sus VARCHAR,
    id_cliente INTEGER PRIMARY KEY,
    fk_id_pessoa INTEGER REFERENCES Pessoa(id_pessoa) ON DELETE CASCADE
);

CREATE TABLE Medicamento (
    nome VARCHAR,
    descricao VARCHAR,
    qtd_disponivel INTEGER,
    validade DATE,
    lote VARCHAR,
    id_medicamento INTEGER PRIMARY KEY
);

CREATE TABLE Retirada (
    dataRetirada TEXT,
    horaRetirada INTEGER,
    id_retirada INTEGER PRIMARY KEY,
    qtd_retirada INTEGER,
    cpf_cliente VARCHAR,
    fk_id_medicamento INTEGER REFERENCES Medicamento(id_medicamento) ON DELETE RESTRICT,
    fk_id_cliente INTEGER REFERENCES Cliente(id_cliente) ON DELETE RESTRICT,
    fk_id_funcionario INTEGER REFERENCES Funcionario(id_funcionario) ON DELETE RESTRICT
);

/* 
ALTER TABLE Retirada ADD CONSTRAINT FK_Retirada
    FOREIGN KEY (fk_Cliente_id_cliente, ???)
    REFERENCES Cliente (id_cliente, ???)
    ON DELETE RESTRICT;


ALTER TABLE Retirada ADD CONSTRAINT FK_Retirada
    FOREIGN KEY (fk_Funcionario_id_funcionario, ???)
    REFERENCES Cliente (id_funcionario, ???)
    ON DELETE RESTRICT;


ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente
    FOREIGN KEY (fk_Pessoa_id_pessoa, ???)
    REFERENCES Pessoa (id_pessoa, ???)
    ON DELETE RESTRICT;


ALTER TABLE Funcionario ADD CONSTRAINT FK_Funcionario
    FOREIGN KEY (fk_Pessoa_id_pessoa, ???)
    REFERENCES Pessoa (id_pessoa, ???)
    ON DELETE RESTRICT;
*/