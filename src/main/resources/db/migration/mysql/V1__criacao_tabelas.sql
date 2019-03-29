CREATE TABLE pauta (
  id_pauta INT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(50) NOT NULL,
  PRIMARY KEY (id_pauta)) DEFAULT CHARSET=utf8;
  
  CREATE TABLE associado (
  id_associado INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  login VARCHAR(15),
  senha VARCHAR(150),
  PRIMARY KEY (id_associado)) DEFAULT CHARSET=utf8;
  
  CREATE TABLE voto (
  id_voto INT NOT NULL AUTO_INCREMENT,
  valor VARCHAR(3) NOT NULL,
  id_associado INT NOT NULL,
  id_sessao_votacao INT NOT NULL,
  PRIMARY KEY (id_voto)) DEFAULT CHARSET=utf8;
  
  CREATE TABLE sessao_votacao (
  id_sessao_votacao INT NOT NULL AUTO_INCREMENT,
  inicio_sessao_votacao DATETIME NOT NULL,
  fim_sessao_votacao DATETIME NOT NULL,
  id_pauta INT NOT NULL,
  PRIMARY KEY (id_sessao_votacao)) DEFAULT CHARSET=utf8;
  
  ALTER TABLE sessao_votacao ADD CONSTRAINT fk_sessao_pauta FOREIGN KEY (id_pauta) REFERENCES pauta (id_pauta);
ALTER TABLE voto ADD CONSTRAINT fk_voto_associado FOREIGN KEY (id_associado) REFERENCES associado (id_associado);
ALTER TABLE voto ADD CONSTRAINT fk_voto_sessao FOREIGN KEY (id_sessao_votacao) REFERENCES sessao_votacao (id_sessao_votacao);
  