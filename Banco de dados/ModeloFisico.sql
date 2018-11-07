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
    fk_id_pessoa INTEGER REFERENCES Pessoa(id_pessoa) ON DELETE CASCADE
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
    fk_id_medicamento INTEGER REFERENCES Medicamento(id_medicamento) ON DELETE RESTRICT,
    fk_id_cliente VARCHAR REFERENCES Cliente(id_cliente) ON DELETE RESTRICT,
    fk_id_funcionario INTEGER REFERENCES Funcionario(id_funcionario) ON DELETE RESTRICT
);
