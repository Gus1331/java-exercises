INSERT INTO curso
        (nome, descricao, preco, categoria)
VALUES ('From 0 to Hero em Java', 'Aprenda Java do básico ao avançado e transforme-se em um super-herói dos códigos!', 1999.99, 'Programação'),
       ('Fique rico com PHP', 'Descubra os segredos obscuros do PHP que os milionários não querem que você saiba!', 2999.99, 'Programação'),
       ('Compre uma BMW com Javascript', 'A única maneira de garantir sua próxima BMW é dominar o Javascript, dizem os gurus!', 3999.99, 'Desenvolvimento Web'),
       ('Seja um expert em dados usando Python apenas', 'Porque o Python é a resposta para todos os seus problemas... com dados!', 4999.99, 'Ciência de Dados'),
       ('Aprenda C e tenha pesadelos com ponteiros', 'Aperte os cintos e prepare-se para uma jornada cheia de ponteiros e desafios lógicos!', 999.99, 'Programação de Sistemas'),
       ('Kotlin: Porque Java já era', 'Aprenda a linguagem que está tirando o sono dos desenvolvedores Java!', 1499.99, 'Programação Mobile'),
       ('Blockchain para quem não sabe nem o que é um bloco', 'Entenda o básico de blockchain e finja saber do que está falando em reuniões!', 2499.99, 'Tecnologia');

       INSERT INTO aluno (nome, cpf, data_nascimento, curso_id)
       VALUES ('João da Silva', '123.456.789-00', '2000-05-15', 1),
              ('Maria Souza', '987.654.321-00', '1998-11-30', 2),
              ('Carlos Pereira', '456.789.123-00', '2001-03-22', 3),
              ('Ana Oliveira', '789.123.456-00', '1999-07-10', 1),
              ('Bruno Santos', '321.654.987-00', '2000-08-25', 2);