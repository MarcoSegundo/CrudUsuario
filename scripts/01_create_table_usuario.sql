CREATE TABLE USUARIO (
CD_USUARIO INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,
NM_USUARIO VARCHAR (100) NOT NULL UNIQUE,
EMAIL VARCHAR (50) NOT NULL,
SENHA VARCHAR (20) NOT NULL,
);