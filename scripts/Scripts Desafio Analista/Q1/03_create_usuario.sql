CREATE TABLE USUARIO (
CPF VARCHAR(11) PRIMARY KEY,
NM_USUARIO VARCHAR (100) NOT NULL,
EMAIL VARCHAR (50) NOT NULL,
SENHA VARCHAR (20) NOT NULL,
CD_CARGO INTEGER NOT NULL,
CD_ORGAO INTEGER NOT NULL,
FOREIGN KEY (CD_CARGO) REFERENCES CARGO(CD_CARGO),
FOREIGN KEY (CD_ORGAO) REFERENCES ORGAO(CD_ORGAO)
) 