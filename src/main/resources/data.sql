INSERT INTO cliente (saldo, data_de_nascimento, numero_da_conta, nome, plano_Exclusive)
VALUES ( 100099, '2023-03-02', 123, 'nome1', false),
 (200000, '1990-08-15', 456, 'John_Doe', true),
  ( 50000, '1985-05-20', 789, 'Jane_Smith', true),
  ( 75000, '1998-11-10', 321, 'Robert_Johnson', false),
  ( 300000, '1976-03-25', 654, 'Emily_Wilson', true),
  (150000, '1995-09-05', 987, 'Michael_Thomas', false);


  INSERT INTO transacao (valor, data_Da_Transacao, tipo_Transacao, cliente_id)
  VALUES ( 100, '2023-03-02', 0, 1),
    ( 300, '2023-03-02', 1, 1);


