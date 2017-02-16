
--
--PROMPT CREANDO BASE DE DATOS
--
CREATE DATABASE activo;
--
--PROMPT CREANDO USUARIO Y PERMISO
--

GRANT ALL ON activo.* TO activouser@'%' IDENTIFIED BY 'pactivouser';
GRANT ALL ON activo.* TO activouser@localhost IDENTIFIED BY 'pactivouser';