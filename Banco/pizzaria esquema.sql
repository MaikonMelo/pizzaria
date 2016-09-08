create table usuario(
usu_codigo serial primary key,
usu_nome varchar(30),
usu_senha varchar(20),
usu_nivel integer,
usu_status boolean);

create table estado (
est_codigo serial primary key,
est_nome varchar);

create table logradouro (
log_cep varchar primary key,
log_estado integer,
log_cidade varchar,
log_logradouro varchar,
log_bairro varchar);

alter table logradouro 
add constraint log_estado_fk foreign key (log_estado) 
references estado(est_codigo);

create table cliente (
cli_telefone bigint primary key,
log_cep varchar,
cli_nome varchar,
cli_numerocasa integer,
cli_complemento varchar,
cli_status boolean);

alter table cliente 
add constraint log_cep_fk foreign key (log_cep) 
references logradouro(log_cep);

create table borda (
bor_codigo serial primary key,
bor_sabor varchar,
bor_preco real,
bor_tipo varchar,
bor_status boolean);

create table sabor (
sab_codigo serial primary key,
sab_nome varchar,
sab_preco real,
sab_igredi varchar,
sab_tipo varchar,
sab_status boolean);

create table marca (
mar_codigo serial primary key,
mar_nome varchar);

create table tipobebida (
bebtip_codigo serial primary key,
bebtip_nome varchar);

create table bebida (
beb_codigo serial primary key,
beb_nome varchar,
mar_codigo integer,
bebtip_codigo integer,
beb_volume integer,
beb_unidade_medida varchar,
beb_preco real,
beb_status boolean);

alter table bebida
add constraint mar_codigo_fk foreign key (mar_codigo) 
references marca(mar_codigo) on delete cascade;

alter table bebida
add constraint bebtip_codigo_fk foreign key (bebtip_codigo) 
references tipobebida(bebtip_codigo);

create table item_pedido(
bor_codigo integer,
piz_sabores varchar,
beb_codigo integer,
ped_codigo integer,
item_tamanho char,
item_valorunit real,
item_quant integer,
item_valortotal real);

alter table item_pedido
add constraint bor_codigo_fk foreign key (bor_codigo) 
references borda(bor_codigo) on delete cascade;

alter table item_pedido
add constraint beb_codigo_fk foreign key (beb_codigo) 
references bebida(beb_codigo) on delete cascade;

create table pedido (
ped_codigo serial primary key,
cli_telefone bigint,
ped_data date,
ped_valor_total real);

alter table pedido
add constraint cli_telefone_fk foreign key (cli_telefone) 
references cliente(cli_telefone);