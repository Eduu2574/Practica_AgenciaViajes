DROP DATABASE IF EXISTS agencia_viajes;
CREATE DATABASE agencia_viajes;
Use agencia_viajes;

CREATE TABLE usuarios (
                          id_usuario INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(50) NOT NULL,
                          contrasena VARCHAR(20) NOT NULL
);

CREATE TABLE reservas (
                          id_reserva INT AUTO_INCREMENT PRIMARY KEY,
                          id_usuario INT,
                          destino VARCHAR(20) NOT NULL,
                          medioTransporte VARCHAR(20) NOT NULL,
                          precio double NOT NULL,
                          FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);