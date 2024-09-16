create database upnexpress5;
use upnexpress5;

create table usuario (
	usuario_id int primary key,
    usuario_nombre varchar(50),
    usuario_apellido varchar(50),
    usuario_correo varchar(100),
    usuario_telefono varchar(100),
    usuario_password varchar(100),
    usuario_rol int
);
create table productos (
	codigo_producto  varchar(50)  primary key,
    nombre_producto varchar(100),
    descripcion_producto varchar(100),
    cantidad_producto varchar(100)
);
create table citas (
	codigo_cita varchar (50) primary key,
    placa varchar (50),
    fecha datetime,
    usuario_id int
);
create table pagos(
	id_pago integer primary key auto_increment,
	dni varchar(8),
    nombre_completo varchar(150),
    placa varchar(7),
    tipo_lavado varchar(100),
    tamano_auto varchar(100),
    precio double
);