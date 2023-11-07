INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('A', '+');
INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('A', '-');
INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('B', '+');
INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('B', '-');
INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('AB', '+');
INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('AB', '-');
INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('O', '+');
INSERT INTO tb_fenotipagem (tipagem_abo, tipagem_rh) VALUES ('O', '-');

INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-A');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-B');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-A1');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-A2');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-D');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-C');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-c');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-E');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-e');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-K');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-k');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-F');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Jka');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Jkb');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Fya');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Fyb');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Lea');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Leb');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Dia');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Dib');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Lua');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-Lub');
INSERT INTO tb_anticorpo (anticorpo_identificado) VALUES ('Anti-P1');

INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('12345678900', '1980-01-01', 'João', 'Silva', '5/32', 1);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('23456789011', '1985-02-02', 'Maria', 'Souza', '6/32', 2);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('34567890122', '1990-03-03', 'Pedro', 'Oliveira', '8/32', 3);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('45678901233', '1995-04-04', 'Ana', 'Santos', '5/32', 4);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('56789012344', '2000-05-05', 'Carlos', 'Pereira', '6/32', 5);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('67890123455', '2005-06-06', 'Mariana', 'Costa', '8/32', 6);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('78901234566', '2010-07-07', 'José', 'Rodrigues', '5/32', 1);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('89012345677', '2015-08-08', 'Amanda', 'Martins', '6/32', 2);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('90123456788', '2020-09-09', 'Rafael', 'Almeida', '8/32', 3);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('01234567899', '2025-10-10', 'Juliana', 'Ferreira', '5/32', 4);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('12345098765', '2030-11-11', 'Lucas', 'Barbosa', '6/32', 5);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('23456109876', '2035-12-12', 'Fernanda', 'Ribeiro', '8/32', 6);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('34567210987', '2040-01-13', 'Gabriel', 'Cardoso', '5/32', 1);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('45678321098', '2045-02-14', 'Laura', 'Gomes', '6/32', 2);
INSERT INTO tb_paciente (cpf, data_nascimento, nome, sobrenome, titulo_anticorpo, fenotipagem_id)
VALUES ('56789432109', '2050-03-15', 'Eduardo', 'Reis', '8/32', 3);

INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (1, 1);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (1, 2);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (2, 3);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (2, 4);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (3, 5);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (3, 6);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (4, 7);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (4, 8);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (5, 9);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (5, 10);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (6, 11);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (6, 12);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (7, 1);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (8, 2);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (9, 3);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (10, 4);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (11, 5);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (12, 6);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (13, 7);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (14, 8);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (15, 9);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (15, 10);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (14, 11);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (13, 12);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (12, 1);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (11, 2);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (10, 3);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (9, 4);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (8, 5);
INSERT INTO tb_anticorpo_paciente (id_paciente, id_anticorpo) VALUES (7, 6);

INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (1, 1);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (1, 2);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (2, 1);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (2, 2);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (3, 1);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (3, 2);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (4, 1);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (4, 2);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (5, 1);
INSERT INTO tb_armazenamento (numero_caixa, numero_gaveta) VALUES (5, 2);

INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (5, 123456789, '2023-01-01', '2024-01-01', 1, 1, 1);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (10, 234567890, '2023-02-02', '2024-02-02', 0, 2, 2);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (15, 345678901, '2023-03-03', '2024-03-03', 1, 3, 3);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (20, 456789012, '2023-04-04', '2024-04-04', 0, 4, 4);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (25, 567890123, '2023-05-05', '2024-05-05', 1, 5, 5);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (30, 678901234, '2023-06-06', '2024-06-06', 0, 6, 6);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (35, 789012345, '2023-07-07', '2024-07-07', 1, 7, 7);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (40, 890123456, '2023-08-08', '2024-08-08', 0, 8, 8);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (45, 901234567, '2023-09-09', '2024-09-09', 1, 9, 9);
INSERT INTO tb_ampola (ampola_ml, codigo_internacao, data_cadastro, data_validade, status_armazenamento, armazenamento_id, paciente_id)
VALUES (50, 123450987, '2023-10-10', '2024-10-10', 0, 10, 10);