insert into persona (nombre,tipoDocumento,numDocumento,apellido,telefono,correo)values("DRAGONCITO","DNI","999999998","Jimenez","875632145","lacalaca@gmail.com");
insert into persona (nombre,tipoDocumento,numDocumento,apellido,telefono,correo)values("ADMINITRATOR","DNI","999995498","Martinez","854636745","adminitrator@gmail.com");
insert into cate_rol(nombre,descripcion) values ("Cliente","Este rol es exclusivo para clientes del CarWash");
insert into cate_rol(nombre,descripcion) values ("Administrador","Este rol es exclusivo para los administradores del CarWash");
insert into usuario (usuario,contrasena,idRol,idPersona,limiteIntentos) values ("tokiro","e98a8940444681a1bbd04def259440dd0007e1cf6a27242ba6bddd385d93700e",1,1,3);/*password tokiro*/
insert into usuario (usuario,contrasena,idRol,idPersona,limiteIntentos) values ("admin","8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918",2,2,3); /*password admin*/

USE CAWASH;

select * from persona;
select * from usuario;
select * from producto;/**/
select * from cate_rol;
select * from proveedor;
SELECT * FROM tipo_vehiculo;
select * from cita;

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



SELECT USUARIO.contrasena FROM USUARIO WHERE USUARIO.idUsuario =2;

/*update usuario set limiteIntentos=3 where idUsuario=4;*/

SELECT idUsuario FROM USUARIO WHERE usuario="tokiro";

/*PARA COSITAS QUE TIENEN QUE VER CON CITAS*/
insert into tipo_vehiculo(tipo,descripcion) values("3 FILAS","SOLO PARA COCHECITOS PREMIUM");
insert into vehiculo (placa,marca,anio,idTipoVehiculo,natenciones,idUsuario) values ("VHX-789","NISSAN",2024,1,18,1);
insert into cita (estado,horario,idUsuario,idPersona,idVehiculo) values("bueno","2024-10-02 23:13:06",1,4,1);

SELECT C.idCita, V.placa, C.horario, U.idUsuario, P.nombre, P.apellido
FROM CITA C
INNER JOIN VEHICULO V ON C.idVehiculo = V.idVehiculo
INNER JOIN USUARIO U ON C.idUsuario = U.idUsuario
INNER JOIN PERSONA P ON U.idPersona = P.idPersona
WHERE U.idUsuario = 1;

select * from cita;
update cita set estado="excelente", horario="2024-10-11 18:12:00", idUsuario="1",idPersona="1",idVehiculo="1" where idCita="5";



