use sincronizador;
CREATE TABLE empresas (
	id integer primary key,
    id_empresa varchar(50)
);

CREATE TABLE postos(
	id integer primary key,
    id_posto varchar(50)
);

CREATE TABLE veiculos(
	id integer primary key,
    placa varchar(20)
);
CREATE TABLE transacoes(
	id integer primary key,
    descricao varchar(50) not null,
    valor_unitario double not null ,
    quantidade double not null, 
    valor double not null, 
    valor_calculado double not  null,
    fk_id_produto varchar(5) not null,
    fk_id_empresa int not null, 
    fk_id_veiculo int not null,
    fk_id_posto int not null
);