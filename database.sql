USE spring;

-- --------------------------------------------------------
-- 1. Tabla: cliente
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    dni VARCHAR(8) NOT NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (id),
    CONSTRAINT uq_cliente_dni UNIQUE (dni),
    CONSTRAINT chk_cliente_dni_formato CHECK (dni REGEXP '^[0-9]{8}$')
) ENGINE = InnoDB;

-- --------------------------------------------------------
-- 2. Tabla: vehiculo
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS vehiculo (
    id INT AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    condicion ENUM('nuevo', 'usado', 'retirado') NOT NULL,
    fecha_compra DATE NOT NULL,
    precio_compra DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    CONSTRAINT pk_vehiculo PRIMARY KEY (id),
    CONSTRAINT chk_vehiculo_precio_compra CHECK (precio_compra >= 0.00)
) ENGINE = InnoDB;

-- --------------------------------------------------------
-- 3. Tabla: alquiler
-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS alquiler (
    id INT AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    vehiculo_id INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NULL DEFAULT NULL,
    precio_dia DECIMAL(8, 2) NOT NULL,
    CONSTRAINT pk_alquiler PRIMARY KEY (id),
    CONSTRAINT fk_alquiler_cliente FOREIGN KEY (cliente_id) 
        REFERENCES cliente (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_alquiler_vehiculo FOREIGN KEY (vehiculo_id) 
        REFERENCES vehiculo (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT chk_alquiler_precio_dia CHECK (precio_dia > 0.00),
    CONSTRAINT chk_alquiler_fechas CHECK (fecha_fin IS NULL OR fecha_fin >= fecha_inicio)
) ENGINE = InnoDB;