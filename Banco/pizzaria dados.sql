insert into estado(est_nome) values ('Acre - AC');
insert into estado(est_nome) values ('Alagoas - AL');
insert into estado(est_nome) values ('Amapá - AP');
insert into estado(est_nome) values ('Amazonas - AM');
insert into estado(est_nome) values ('Bahia  - BA');
insert into estado(est_nome) values ('Ceará - CE');
insert into estado(est_nome) values ('Distrito Federal  - DF');
insert into estado(est_nome) values ('Espírito Santo - ES');
insert into estado(est_nome) values ('Goiás - GO');
insert into estado(est_nome) values ('Maranhão - MA');
insert into estado(est_nome) values ('Mato Grosso - MT');
insert into estado(est_nome) values ('Mato Grosso do Sul - MS');
insert into estado(est_nome) values ('Minas Gerais - MG');
insert into estado(est_nome) values ('Pará - PA');
insert into estado(est_nome) values ('Paraíba - PB');
insert into estado(est_nome) values ('Paraná - PR');
insert into estado(est_nome) values ('Pernambuco - PE');
insert into estado(est_nome) values ('Piauí - PI');
insert into estado(est_nome) values ('Rio de Janeiro - RJ');
insert into estado(est_nome) values ('Rio Grande do Norte - RN');
insert into estado(est_nome) values ('Rio Grande do Sul - RS');
insert into estado(est_nome) values ('Rondônia - RO');
insert into estado(est_nome) values ('Roraima - RR');
insert into estado(est_nome) values ('Santa Catarina - SC');
insert into estado(est_nome) values ('São Paulo - SP');
insert into estado(est_nome) values ('Sergipe - SE');
insert into estado(est_nome) values ('Tocantins - TO');
insert into logradouro values ('84010-110', 16, 'Ponta Grossa', 'Rua Saldanha Marinho', 'Centro');
insert into logradouro values ('84010-550', 16, 'Ponta Grossa', 'Rua Ayrton Playsant', 'Centro');
insert into cliente values (4299253224, '84010-110', 'Raphael Martins Rocha', 63, 'Loja',true);
insert into borda(bor_sabor, bor_preco, bor_tipo, bor_status) values ('Catupiry', 5, 'Salgada', true);
insert into sabor(sab_nome, sab_preco, sab_igredi, sab_tipo, sab_status) values ('Portuguesa', 30, 'Queijo, Presunto, Ovo, Tomate, Cebola, Oregano','Salgada', true);
insert into sabor(sab_nome, sab_preco, sab_igredi, sab_tipo, sab_status) values ('Calabresa', 30, 'Queijo, Linguiça Calabresa, Tomate, Cebola, Oregano','Salgada', true);
insert into sabor(sab_nome, sab_preco, sab_igredi, sab_tipo, sab_status) values ('4 Queijo', 30, 'Queijo Mussarela, Queijo Prato, Queijo Cheddar, Queijo Parmesão','Salgada', true);
insert into marca(mar_nome) values ('Coca-Cola');
insert into tipobebida(bebtip_nome) values ('Refrigerante');
insert into bebida(beb_nome,mar_codigo, bebtip_codigo, beb_volume, beb_unidade_medida, beb_preco, beb_status) values ('Coca-Cola 500ml',1, 1, 500, 'ml', 4, true);
insert into pedido(cli_telefone, ped_data, ped_valor_total) values (4299253224, CURRENT_DATE, 40);
insert into item_pedido	values (1, 'Calabresa', 1,1,'M', 35.50, 1, 35.50);