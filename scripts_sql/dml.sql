use sincronizador;

select * from transacoes;
select * from postos;
select * from empresas;
select * from veiculos;

select * from produtos;

delete from transacoes where id > 0;
delete from empresas where id > 0;
delete from postos where id > 0;
delete from veiculos where id > 0;

ALTER TABLE transacoes DROP COLUMN produto;

ALTER TABLE transacoes RENAME COLUMN empresa TO fk_id_empresa;

ALTER TABLE transacoes RENAME COLUMN veiculo TO fk_id_veiculo;

ALTER TABLE transacoes RENAME COLUMN posto TO fk_id_posto;

ALTER TABLE transacoes RENAME COLUMN id_produto TO fk_id_produto;
ALTER TABLE `sincronizador`.`transacoes` 
ADD CONSTRAINT `fk_id_produto`
  FOREIGN KEY (`fk_id_produto`)
  REFERENCES `sincronizador`.`produtos` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
    select t.*, p.id_posto, e.id_empresa, v.placa, pd.descricao from transacoes as t, postos as p, empresas as e, veiculos as v, produtos as pd
  where p.id = t.fk_id_posto and e.id = t.fk_id_empresa and v.id = t.fk_id_veiculo and pd.id = t.fk_id_produto;
  
  select t.*, p.id_posto, e.id_empresa, v.placa, pd.descricao from transacoes as t, postos as p, empresas as e, veiculos as v, produtos as pd
  where p.id = t.fk_id_posto and e.id = t.fk_id_empresa and v.id = t.fk_id_veiculo and pd.id = t.fk_id_produto and v.placa = "ERC7D65" and pd.descricao="Diesel";
