CREATE DATABASE IF NOT EXISTS CAWASH;

USE CAWASH;

CREATE TABLE BOLETA 
( 
    idBoleta           INT  NOT NULL PRIMARY KEY auto_increment,
    nota               VARCHAR(200)  NULL,
    idComprobante      INT  NULL 
);

CREATE TABLE CATE_ROL
( 
    idRol             INT  NOT NULL PRIMARY KEY auto_increment,
    nombre            VARCHAR(50)  NULL,
    descripcion       VARCHAR(150)  NULL
);

CREATE TABLE CITA
( 
    idCita            INT  NOT NULL PRIMARY KEY auto_increment,
    promocion         VARCHAR(50)  NULL,
    estado            VARCHAR(20)  NULL,
    horario				datetime,
    idUsuario         INT  NULL,
    idPersona         INT  NULL,
    idVehiculo        INT  NULL
);

CREATE TABLE COMPROBANTE 
( 
    idComprobante     INT  NOT NULL PRIMARY KEY auto_increment,
    fechaEmision      DATETIME  NULL,
    metodoPago         VARCHAR(50)  NULL,
    subtotal          FLOAT  NULL,
    idUsuario         INT  NULL
);

CREATE TABLE CONTACTO_PROVEEDOR 
( 
    idContacto        INT  NOT NULL PRIMARY KEY auto_increment,
    nombre            VARCHAR(150)  NULL,
    telefono          VARCHAR(9)  NULL,
    correo            VARCHAR(150)  NULL,
    cargo             VARCHAR(50)  NULL,
    idProveedor       INT  NULL
);

CREATE TABLE DETALLE_CITA 
( 
    idDetalleCita     INT  NOT NULL PRIMARY KEY auto_increment,
    idCita            INT  NULL,
    idLavado          INT  NULL,
    idServicio        INT  NULL
);

CREATE TABLE DETALLE_COMPROBANTE 
( 
    idDetalle         INT  NOT NULL PRIMARY KEY auto_increment,
    idComprobante     INT  NULL,
    idCita            INT  NULL
);

CREATE TABLE FACTURA 
( 
    idFactura         INT  NOT NULL PRIMARY KEY auto_increment,
    ruc               VARCHAR(20)  NULL,
    impuesto          FLOAT  NULL,
    idComprobante     INT  NULL
);

CREATE TABLE LAVADO 
( 
    idLavado          INT  NOT NULL PRIMARY KEY auto_increment,
    nombre            VARCHAR(200)  NULL,
    precio            FLOAT  NULL
);

CREATE TABLE PERSONA 
( 
    idPersona         INT  NOT NULL PRIMARY KEY auto_increment,
    nombre            VARCHAR(150)  NULL,
    tipoDocumento     VARCHAR(20)  NULL,
    numDocumento      VARCHAR(30)  NULL,
    apellido          VARCHAR(150)  NULL,
    telefono          VARCHAR(9)  NULL,
    correo            VARCHAR(150)  NULL
);

CREATE TABLE PRODUCTO 
( 
    idProducto        INT  NOT NULL PRIMARY KEY auto_increment,
    nombre            VARCHAR(150)  NULL,
    descripcion       VARCHAR(250)  NULL,
    precio            FLOAT  NULL,
    stock             INT  NULL,
    stockMinimo       INT  NULL,
    idProveedor       INT  NULL
);

CREATE TABLE PROVEEDOR 
( 
    idProveedor       INT  NOT NULL PRIMARY KEY auto_increment,
    razonSocial       VARCHAR(200)  NULL,
    ruc               VARCHAR(30)  NULL,
    direccion         VARCHAR(200)  NULL,
    telefono          VARCHAR(9)  NULL,
    correo            VARCHAR(150)  NULL
);

CREATE TABLE SERVICIO_ADICIONAL 
( 
    idServicio        INT  NOT NULL PRIMARY KEY auto_increment,
    nombre            VARCHAR(150)  NULL,
    descripcion       VARCHAR(250)  NULL,
    idProducto        INT  NULL
);

CREATE TABLE TIPO_VEHICULO 
( 
    idTipoVehiculo    INT  NOT NULL PRIMARY KEY auto_increment,
    tipo              VARCHAR(150)  NULL,
    descripcion       VARCHAR(250)  NULL
);

CREATE TABLE USUARIO
( 
    idUsuario         INT  NOT NULL PRIMARY KEY auto_increment,
    usuario           VARCHAR(50)  NULL,
    contrasena        VARCHAR(300)  NULL,
    idRol             INT  NULL,
    limiteIntentos    INT  NULL default 3,
    fechaSesion		  datetime,
    ipUltimaSesion    VARCHAR(50) NULL, 
    idPersona         INT  NULL
);

CREATE TABLE VEHICULO 
( 
    idVehiculo        INT  NOT NULL PRIMARY KEY auto_increment,
    placa             VARCHAR(6)  NULL,
    marca             VARCHAR(50)  NULL,
    anio              INT  NULL,
    idTipoVehiculo    INT  NULL,
    natenciones       INT  NULL,
    idUsuario         INT  NULL
);

-- Relaciones de Claves Foráneas
ALTER TABLE BOLETA 
    ADD CONSTRAINT R_23 FOREIGN KEY (idComprobante) REFERENCES COMPROBANTE (idComprobante)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE CITA 
    ADD CONSTRAINT R_13 FOREIGN KEY (idUsuario) REFERENCES USUARIO (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE CITA 
    ADD CONSTRAINT R_14 FOREIGN KEY (idPersona) REFERENCES PERSONA (idPersona)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE CITA 
    ADD CONSTRAINT R_16 FOREIGN KEY (idVehiculo) REFERENCES VEHICULO (idVehiculo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE COMPROBANTE 
    ADD CONSTRAINT R_20 FOREIGN KEY (idUsuario) REFERENCES USUARIO (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE CONTACTO_PROVEEDOR 
    ADD CONSTRAINT R_26 FOREIGN KEY (idProveedor) REFERENCES PROVEEDOR (idProveedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE DETALLE_CITA 
    ADD CONSTRAINT R_5 FOREIGN KEY (idLavado) REFERENCES LAVADO (idLavado)
    ON DELETE NO ACTION;

ALTER TABLE DETALLE_CITA 
    ADD CONSTRAINT R_6 FOREIGN KEY (idServicio) REFERENCES SERVICIO_ADICIONAL (idServicio)
    ON DELETE NO ACTION;

ALTER TABLE DETALLE_CITA 
    ADD CONSTRAINT R_4 FOREIGN KEY (idCita) REFERENCES CITA (idCita)
    ON DELETE NO ACTION;

ALTER TABLE DETALLE_COMPROBANTE 
    ADD CONSTRAINT R_8 FOREIGN KEY (idComprobante) REFERENCES COMPROBANTE (idComprobante)
    ON DELETE NO ACTION;

ALTER TABLE DETALLE_COMPROBANTE 
    ADD CONSTRAINT R_21 FOREIGN KEY (idCita) REFERENCES CITA (idCita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE FACTURA 
    ADD CONSTRAINT R_22 FOREIGN KEY (idComprobante) REFERENCES COMPROBANTE (idComprobante)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE PRODUCTO 
    ADD CONSTRAINT R_25 FOREIGN KEY (idProveedor) REFERENCES PROVEEDOR (idProveedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE SERVICIO_ADICIONAL 
    ADD CONSTRAINT R_24 FOREIGN KEY (idProducto) REFERENCES PRODUCTO (idProducto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE USUARIO 
    ADD CONSTRAINT R_10 FOREIGN KEY (idPersona) REFERENCES PERSONA (idPersona)
    ON DELETE NO ACTION;

ALTER TABLE USUARIO 
    ADD CONSTRAINT R_11 FOREIGN KEY (idRol) REFERENCES CATE_ROL (idRol)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE VEHICULO 
    ADD CONSTRAINT R_18 FOREIGN KEY (idTipoVehiculo) REFERENCES TIPO_VEHICULO (idTipoVehiculo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER TABLE VEHICULO 
    ADD CONSTRAINT R_19 FOREIGN KEY (idUsuario) REFERENCES USUARIO (idUsuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

/**/