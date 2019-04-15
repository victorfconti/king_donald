insert into ingredient values(null, 'Alface', 'Alface', 0.40),
                             (null, 'Bacon', 'Bacon', 2.00), (null, 'Hambúrguer', 'Hambúrguer', 3.00),
                             (null, 'Ovo', 'Ovo', 0.80), (null, 'Queijo', 'Queijo', 1.50);

insert into sandwich values(null, 'X-Bacon'), (null, 'X-Burguer'), (null, 'X-Egg'), (null, 'X-Egg Bacon');

insert into sandwich_ingredients values
(1,2),
(1,3),
(1,5),
(2,3),
(2,5),
(3,3),
(3,4),
(3,5),
(4,2),
(4,3),
(4,4),
(4,5);

insert into promotion values (null, 0, 1, 'Light', 2, 1), (null, 1, 3, 'Muita carne', null, 3),
                             (null, 1, 3, 'Muito queijo', null, 5);