 
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  rezen
 * Created: 20/11/2016
 */
insert into solicitacao(id_cliente, id_servico, id_lavador, id_avaliacao) values ((select id from cliente where email = 'teste@teste.com.br'),1,1,1);
create table cliente(
    ID int NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    nome varchar(255) NOT NULL,
    telefone varchar(255) NOT NULL,
    dt_nascimento Date not null,
    CPF varchar(255) NOT NULL,
    CEP varchar(9) NOT NULL,
    estado varchar(255) NOT NULL,
    cidade varchar(255) NOT NULL,
    bairro varchar(255) NOT NULL,
    endereco varchar(255) NOT NULL,
    numero int NOT NULL,
    UNIQUE (CPF),
    UNIQUE (email),
    PRIMARY KEY (id)
    
);

create table lavador(
    ID int NOT NULL AUTO_INCREMENT,
    dt_contrato Date not null,
    email varchar(255) NOT NULL,
    nome varchar(255) NOT NULL,
    telefone varchar(255) NOT NULL,
    dt_nascimento Date not null,
    CPF varchar(255) NOT NULL,
    CEP varchar(9) NOT NULL,
    estado varchar(255) NOT NULL,
    cidade varchar(255) NOT NULL,
    bairro varchar(255) NOT NULL,
    endereco varchar(255) NOT NULL,
    numero int NOT NULL,
    UNIQUE (CPF),
    UNIQUE (email),
    PRIMARY KEY (id)
);

create table gerente(
    ID int NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    nome varchar(255) NOT NULL,
    telefone varchar(255) NOT NULL,
    dt_nascimento Date not null,
    CPF varchar(255) NOT NULL,
    CEP varchar(9) NOT NULL,
    estado varchar(255) NOT NULL,
    cidade varchar(255) NOT NULL,
    bairro varchar(255) NOT NULL,
    endereco varchar(255) NOT NULL,
    numero int NOT NULL,
    PRIMARY KEY (id)
);

insert into gerente(email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) 
values('ricardo@icarwash.com.br','Ricardo Carvalho','11987647197', '1993-06-29', '40524153884', '0890000', 'SP', 'Mogi das Cruzes', 'Biritiba Ussu', 'Rua Tucano', 90);
insert into gerente(email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) 
values('rodrigo@icarwash.com.br','Rodrigo Rios','11970942165', '1995-01-21', '40564980838', '07171120', 'SP', 'Guarulhos', 'Jardim Presidente Dutra', 'Rua Ichu', 517);
insert into gerente(email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) 
values('renan@icarwash.com.br','Renan Rezenes','11999032358', '1991-01-16', '40674829816', '08745310', 'SP', 'Mogi das Cruzes', 'Vila Bela Flor', 'Avenida Santo Antonio', 366);
 

create table produto(
    ID int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    descricao varchar(255),
    ativo bool NOT NULL,
    PRIMARY KEY (id)
);

create table servico(
    ID int NOT NULL AUTO_INCREMENT,
    valor DECIMAL(10,2),
    descricao varchar(255),
    PRIMARY KEY (id)
);

insert into servico(valor, descricao) values (20, 'Aspirar');
insert into servico(valor, descricao) values (30, 'Lavagem');
insert into servico(valor, descricao) values (110, 'Cristalizar');
insert into servico(valor, descricao) values (30, 'Higienização');
insert into servico(valor, descricao) values (50, 'Lavagem do Motor');

create table avaliacao(
    ID int NOT NULL AUTO_INCREMENT,
    nota_pontualidade int not null,
    nota_servico int not null,
    nota_atendimento int not null,
    nota_agilidade int not null,
    nota_media int not null,
    PRIMARY KEY (id)
);

insert into avaliacao(nota_pontualidade,nota_servico,nota_atendimento,nota_agilidade,nota_media) values (0,0,0,0,0)

create table solicitacao(
    ID int NOT NULL AUTO_INCREMENT,
    id_cliente int not null,
    id_servico int not null,
    id_lavador int not null,
    id_avaliacao int not null, 
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_servico) REFERENCES servico(id),
    FOREIGN KEY (id_lavador) REFERENCES lavador(id),
    FOREIGN KEY (id_avaliacao) REFERENCES avaliacao(id)
);

create table servico_produtos(
    id_servico int not null,    
    id_produto int not null,
    quantidade int not null,
    primary key(id_servico, id_produto),
    FOREIGN KEY (id_servico) REFERENCES servico(id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);

create table solicitacao_servico(
    id_solicitacao int not null,
    id_servico int not null,
    primary key(id_solicitacao, id_servico),
    FOREIGN KEY (id_solicitacao) REFERENCES solicitacao(id),
    FOREIGN KEY (id_servico) REFERENCES servico(id)
);

CREATE TABLE usuario(
    id INT(11) NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(25) NOT NULL,
    senha VARCHAR(40) NOT NULL,
    nivel INT(1) UNSIGNED NOT NULL DEFAULT '1',
    ativo BOOL NOT NULL DEFAULT '1',
    cadastro DATETIME NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY usuario (usuario),
    KEY nivel (nivel)
);

INSERT INTO `usuario` VALUES (NULL, 'ricardo',SHA1('admin'),3,1, NOW());
INSERT INTO `usuario` VALUES (NULL, 'rodrigo',SHA1('admin'),3,1, NOW());
INSERT INTO `usuario` VALUES (NULL, 'renan',SHA1('admin'),3,1, NOW());
INSERT INTO `usuario` VALUES (NULL, 'cliente',SHA1('123'),1,1, NOW());

create table cliente_usuario(
    id_CLIENTE int not null,
    id_usuario int not null,
    primary key(id_CLIENTE, id_usuario),
    FOREIGN KEY (id_CLIENTE) REFERENCES cliente(id),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(ID)
);

create table lavador_usuario(
    id_lavador int not null,
    id_usuario int not null,
    primary key(id_lavador, id_usuario),
    FOREIGN KEY (id_lavador) REFERENCES lavador(ID),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(ID)
);

create table gerente_usuario(
    id_gerente int not null,
    id_usuario int not null,
    primary key(id_gerente, id_usuario),
    FOREIGN KEY (id_gerente) REFERENCES gerente(ID),
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(ID)
);

insert into gerente_usuario values(1,1);
insert into gerente_usuario values(2,2);
insert into gerente_usuario values(3,3);

select g.nome, g.email, g.cpf, u.usuario, u.nivel
    from gerente g, usuario u, gerente_usuario
    where g.id = gerente_usuario.id_gerente
        and u.id = gerente_usuario.id_usuario;

create table lavador_avaliacao(
    id_lavador int not null,
    id_avaliacao int not null,
    primary key(id_lavador, id_avaliacao),
    FOREIGN KEY (id_lavador) REFERENCES lavador(ID),
    FOREIGN KEY (id_avaliacao) REFERENCES avaliacao(ID)
);

INSERT INTO `usuarios` VALUES (NULL, 'demo', SHA1('demo'), 1, 1, NOW());
INSERT INTO `usuarios` VALUES (NULL, 'Admin', 'admin', SHA1('admin'), 'admin@icarwash.com', 2, 1, NOW());



insert into gerente(email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) 
values('teste@teste.com.br','','111111', '1991-01-16', '12334565671', '08745310', 'sp', 'mogi das cruzes', 'vila bela flor', 'rua 1', 123); 
insert into cliente(email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) 
values('teste2@teste.com.br','Fulano2','222222', '1991-01-12', '12334565672', '08745312', 'sp', 'mogi das cruzes', 'vila bela flor', 'rua 2', 122);
insert into lavador(dt_contrato, email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) values('2015-11-11', 'teste@teste.com.br','Fulano','111111', '1991-01-16', '12334565671', '08745310', 'sp', 'mogi das cruzes', 'vila bela flor', 'rua 1', 123); 
insert into lavador(dt_contrato, email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) values('2015-11-11', 'teste2@teste.com.br','Fulano2','222222', '1991-01-12', '12334565672', '08745312', 'sp', 'mogi das cruzes', 'vila bela flor', 'rua 2', 122);
insert into produto(nome, descricao, ativo) values('Pano', 'Pano De Microfibra 50x60cm',1);
insert into produto(nome, descricao, ativo) values('Cristalizador De Vidros', 'Cristalizador De Vidros 500ml',1);
insert into produto(nome, descricao, ativo) values('Spray ICarWash', 'Spray ICarWash 1000ml',1);

