insert into persona (nombre,tipoDocumento,numDocumento,apellido,telefono,correo)values("DRAGONCITO","DNI","999999998","Jimenez","875632145","lacalaca@gmail.com");
insert into persona (nombre,tipoDocumento,numDocumento,apellido,telefono,correo)values("ADMINITRATOR","DNI","999995498","Martinez","854636745","adminitrator@gmail.com");
insert into cate_rol(nombre,descripcion) values ("Cliente","Este rol es exclusivo para clientes del CarWash");
insert into cate_rol(nombre,descripcion) values ("Administrador","Este rol es exclusivo para los administradores del CarWash");
insert into usuario (usuario,contrasena,idRol,idPersona) values ("tokiro","tokiro",1,1);
insert into usuario (usuario,contrasena,idRol,idPersona) values ("admin","admin",2,2);

select * from persona;
select * from usuario;
select * from cate_rol;

SELECT idPersona, idRol FROM usuario WHERE idUsuario = 7;




SELECT USUARIO.idUsuario,USUARIO.usuario,USUARIO.contrasena,PERSONA.nombre,PERSONA.apellido,PERSONA.tipoDocumento,PERSONA.numDocumento,PERSONA.telefono,PERSONA.correo,CATE_ROL.nombre AS rolNombre, USUARIO.idRol as ROL
FROM USUARIO INNER JOIN PERSONA ON USUARIO.idPersona = PERSONA.idPersona INNER JOIN CATE_ROL ON USUARIO.idRol = CATE_ROL.idRol;

SELECT USUARIO.idUsuario,USUARIO.usuario,USUARIO.contrasena,PERSONA.nombre,PERSONA.apellido,PERSONA.tipoDocumento,PERSONA.numDocumento,PERSONA.telefono,PERSONA.correo,CATE_ROL.nombre AS rolNombre
FROM USUARIO INNER JOIN PERSONA ON USUARIO.idPersona = PERSONA.idPersona INNER JOIN CATE_ROL ON USUARIO.idRol = CATE_ROL.idRol WHERE USUARIO.idUsuario = 2;

use cawash;
select * from producto;
insert into proveedor (razonSocial,ruc,direccion,telefono,correo) values ("GLORIA","123456789","JR ALCAZAR","123456789","MATISI");
insert into producto (nombre,descripcion,precio,stock,stockMinimo,idProveedor) values ("Kassinma","chocolate hablando webada",2.20,2,2,1);
SELECT p.*, prov.razonSocial FROM PRODUCTO p INNER JOIN PROVEEDOR prov ON p.idProveedor = prov.idProveedor WHERE idProducto = 0;