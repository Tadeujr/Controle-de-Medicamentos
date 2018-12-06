INSERT INTO Pessoa (nome, email, telefone, endereco, id_pessoa, cpf) 
	VALUES ('EDLAINE', 'edlaine@gmail', '333333330', 'RUA NENHUMA', 1, '12345677755'),
	('TADEU JR', 'tadeu_junior@outlook.com', '325433101', 'RUA 14 CASA 35 ANTONIO FERREIRA BORGES', 2, '12345678900'),
	('EDIANE ANDRADE', 'tadeu_junior@outlook.com', '325444330', 'RUA 7', 3, '12345678901'),
	('JADSON PEREIRA', 'jadson@dalest.com.br', '324567780', 'RUA CURITIBA', 4, '24242424255'),
	('EWERSON VIEIRA', 'email@email.com', '999999999', 'RUA GOIANIA', 5, '12312312344'),
	('PEDRO HENRIQUE ', 'pedro@pedro', '32421234', 'RUA AMOREIRA', 6, '12345678900'),
	('ALICE MARIA', 'alice@gmail.com', '12345678', 'AVENIDA RESPLENDOR', 7, '12345678900'),
	('QUIRREL POTTER', 'qp@email.com', '66565656575', 'ALAMEDA I', 8, '12365434700'), 
	('TATIANA MASLANY', 'tmaslany@email.com', '423534523', 'AVENIDA SAO PAULO', 9, '67854323498'),
    ('TEODORA MONTEIRO', 'teomonteiro@hotmail.com', '423534523', 'AVENIDA HUGO MUSSO', 10, '67854323498');


INSERT INTO Cliente (cartao_sus, id_cliente, fk_id_pessoa) 
	VALUES ('195234758295645', 1, 3),
    ('123445678907325', 2, 4),
    ('123456789101112', 3, 7),
    ('987654321055668', 4, 9),
    ('351894168496194', 5, 10);

INSERT INTO Funcionario (login, senha, id_funcionario, tipo, fk_id_pessoa) 
	VALUES ('edlainebraga', '1234', 1, 'ATENDENTE', 1),
	('tadeujunior', '1234', 2, 'GERENTE', 2),
	('ewersonv', 'p002_2019', 3, 'GERENTE', 5),
	('PedroH', 'pedrinhoh', 4, 'ATENDENTE', 6),
	('quipot', 'harrypotter', 5, 'ATENDENTE', 8);

INSERT INTO Retirada (dataRetirada, horaRetirada, id_retirada, qtd_retirada, fk_id_medicamento, fk_id_cliente, fk_id_funcionario) 
	VALUES
	('01/10/2018', '22:47:36', 1, 1, 5, 1, 1),
	('04/10/2018', '23:16:45', 2, 10, 2, 2, 2),
	('01/11/2018', '09:56:46', 3, 2, 5, 1, 3),
    ('13/11/2018', '13:18:20', 4, 5, 1, 3, 3),
    ('19/11/2018', '10:56:42', 5, 2, 3, 4, 4),
    ('22/12/2018', '12:30:46', 6, 1, 4, 5, 2),
    ('28/12/2018', '11:48:19', 7, 3, 3, 3, 5),
    ('03/12/2018', '15:32:07', 8, 4, 5, 1, 5),
    ('07/12/2018', '13:12:09', 9, 2, 1, 4, 2),
    ('13/12/2018', '16:02:36', 10, 2, 4, 5, 4);

INSERT INTO Medicamento (id_medicamento, nome, descricao, validade, qtd_disponivel, lote)
    VALUES (1, 'DorFlex', 'Medicamento para dor', '21/12/2019', '100', 'L12345'),
    (2, 'Viagra', 'Usado para aumento de libido', '10/10/2020', '20', 'L98949'),
    (3, 'Multigripe', 'Medicamento eficaz contra gripe', '13/05/2019', 'L23120', 'lote'),
    (4, 'Tylenol', 'Eficaz contra febre', '17/08/2019', '32', 'L01072'),
    (5, 'Marevan', 'Anticoagulante eficaz contra trombose', '26/01/2021', '14', 'L31106');