 0 CREATE TABLE REGISTRADORA (
        ID INTEGER NOT NULL,
        ID_ASOCIADO VARCHAR(20),
	FECHA DATE,
	FOREIGN KEY (ID_ASOCIADO) REFERENCES ASOCIADO(NOMBRE),
        PRIMARY KEY (ID)
);

CREATE TABLE ASOCIADO(
  
    NOMBRE VARCHAR(20),
    PRIMARY KEY (NOMBRE)

);
