create table Categorias (
    id int auto_increment primary key,
    nome  varchar(150) not null
);

create table Produtos (
	id int auto_increment primary key, 
	nome varchar(150) not null,
    quantidade int not null,
    preco decimal(10,2) not null, 
    categoria_id int not null, 
    FOREIGN KEY (categoria_id) REFERENCES Categorias(id)
);
select * from Produtos;

alter table Produtos add
qtd_minima int not null,
add qtd_maxima int not null;

select * from Produtos;

create table Unidade_Medida (
	id int auto_increment primary key, 
    sigla varchar(10)
);

select * from Unidade_Medida;

alter table Produtos add 
FOREIGN KEY (unidade_medida_id) REFERENCES Unidade_Medida(id);

select * from Produtos;

alter table Produtos add
unidade_medida_id int;

alter table Produtos add constraint
FOREIGN KEY (unidade_medida_id) REFERENCES Unidade_Medida(id);

select * from Produtos;

create table Movimentacoes(
	id int auto_increment primary key not null,
    produto_id int not null,
    FOREIGN KEY (produto_id) REFERENCES Produtos(id),
    tipo  enum('entrada', 'saida') not null,
    quantidade int not null,
    data_movimentacao datetime default current_timestamp not null,
    observacoes text not null
);

select * from Movimentacoes;

select * from Produtos;

select * from Unidade_Medida;

select * from Categorias;

insert into Categorias (nome)
values("massas");

select * from Categorias;

insert into unidade_medida (sigla)
values("kg");


insert into produtos (nome, quantidade, preco,categoria_id,qtd_minima,qtd_maxima, unidade_medida_id)
values("macarrão parafuso", 30, 3.50, 1,600, 5.000, 1);
                
select p.nome as nome_produto,
  p.preco,
  p.quantidade,
  p.qtd_minima,
  p.qtd_maxima,
  c.nome as categoria,
  u.sigla AS unidade_medida
  from Produtos p join categorias c on p.categoria_id = c.id
  join unidade_medida u on p.unidade_medida_id = u.id;
  
  select * from Produtos;
  
  drop table unidade_medida;
  
  ALTER TABLE produtos DROP FOREIGN KEY produtos_ibfk_2;
  
drop table unidade_medida;
  
alter table Produtos add
unidade_medida int;


select * from Produtos;

ALTER TABLE produtos DROP COLUMN unidade_medida_id;

select * from Produtos;

ALTER TABLE produtos MODIFY unidade_medida varchar(10) NOT NULL;

 ALTER TABLE produtos DROP column unidade_medida;
 
 select * from Produtos;
 
 alter table Produtos add
unidade_medida varchar(5) not null;

 select * from Produtos;
 
select * from Produtos;

SELECT * FROM produtos WHERE nome = 'feijão';
SELECT * FROM produtos WHERE nome = 'arroz';

select * from Movimentacoes;