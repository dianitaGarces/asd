--
--PROMPT CREANDO TABLA AREA ASIGNADA A UN ACTIVO
--

CREATE TABLE TB_ASIGNADO_AREA (
  ID  NUMBER CONSTRAINT NN_TB_ASIG_AREA NOT NULL,
  ID_AREA NUMBER,
  ID_ACTIVO NUMBER
);