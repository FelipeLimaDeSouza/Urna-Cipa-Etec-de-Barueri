drop database if exists bd_urna;
CREATE database bd_urna;
USE bd_urna;

CREATE TABLE tb_aluno (

  aluno_id 					INT 			AUTO_INCREMENT,
  aluno_nome 				VARCHAR(50) 	NOT NULL,
  aluno_cpf 				VARCHAR(11) 	NOT NULL,
  aluno_ra 					VARCHAR(15) 	NOT NULL,
  aluno_turma 				int			 	NOT NULL,
  aluno_curso 				VARCHAR(50) 	NOT NULL,
  aluno_status				int				not null default 1,
  aluno_foto 				VARCHAR(200) 	NULL,
  PRIMARY KEY (aluno_id),
  UNIQUE KEY(aluno_cpf, aluno_ra)
  
);

CREATE TABLE tb_eleicao (

  eleicao_id 				INT				AUTO_INCREMENT,
  eleicao_data 				DATE 			NOT NULL,
  eleicao_status 			int				not null default 1,
  PRIMARY KEY (`eleicao_id`)
  
);

CREATE TABLE tb_adm (
  adm_id 					INT				AUTO_INCREMENT,
  adm_usuario 				VARCHAR(50) 	NOT NULL,
  adm_senha 				VARCHAR(50) 	NOT NULL,
  PRIMARY KEY (adm_id)
  
);

CREATE TABLE tb_voto (

  aluno_id_voto				INT 			NOT NULL,
  eleicao_id_voto 			INT 			NOT NULL,
  voto_voto 				INT 			NOT NULL,
  PRIMARY KEY (aluno_id_voto, eleicao_id_voto),
  CONSTRAINT fk_al_el FOREIGN KEY (aluno_id_voto) REFERENCES tb_aluno (aluno_id),
  CONSTRAINT fk_el_al FOREIGN KEY (eleicao_id_voto) REFERENCES tb_eleicao (eleicao_id)
  
);

CREATE TABLE tb_candidato (
  aluno_id_candidato 		INT 			NOT NULL,
  eleicao_id_candidato 		INT 			NOT NULL,
  candidato_chapa 			VARCHAR(50) 	NOT NULL,
  candidato_apelido 		VARCHAR(50) 	NOT NULL,
  candidato_foto 			VARCHAR(200) 	NULL,
  PRIMARY KEY (aluno_id_candidato, eleicao_id_candidato),
  CONSTRAINT fk_al_can FOREIGN KEY (aluno_id_candidato) REFERENCES tb_aluno (aluno_id),
  CONSTRAINT fk_el_can FOREIGN KEY (eleicao_id_candidato) REFERENCES tb_eleicao (eleicao_id)
  
);

insert into tb_adm(adm_usuario, adm_senha) values('felipe','210891');
