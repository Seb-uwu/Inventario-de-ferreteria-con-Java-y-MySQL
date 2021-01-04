-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema InventarioFerreteria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema InventarioFerreteria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `InventarioFerreteria` DEFAULT CHARACTER SET utf8 ;
USE `InventarioFerreteria` ;

-- -----------------------------------------------------
-- Table `InventarioFerreteria`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InventarioFerreteria`.`USUARIO` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `estado` CHAR(1) NOT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InventarioFerreteria`.`CATEGORIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InventarioFerreteria`.`CATEGORIA` (
  `Cod_Categoria` INT NOT NULL AUTO_INCREMENT,
  `Categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Cod_Categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InventarioFerreteria`.`PROVEEDOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InventarioFerreteria`.`PROVEEDOR` (
  `idProveedor` INT NOT NULL AUTO_INCREMENT,
  `Ruc_Provee` CHAR(11) NOT NULL,
  `Telefono` CHAR(9) NOT NULL,
  `Razon_Social` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NULL,
  `Correo` VARCHAR(45) NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InventarioFerreteria`.`DETALLE_PEDIDO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InventarioFerreteria`.`DETALLE_PEDIDO` (
  `Codigo_Pedido` CHAR(4) NOT NULL,
  `Ruc_Provee` CHAR(11) NOT NULL,
  `Razon_Social` VARCHAR(45) NOT NULL,
  `Detalle_Pedido` VARCHAR(50) NOT NULL,
  `Precio_Uni` DECIMAL(7,2) NOT NULL,
  `Cant_Pedido` DECIMAL(7,2) NOT NULL,
  `Precio_Total` DECIMAL(7,2) NOT NULL,
  `Fecha_Entrega` DATE NOT NULL,
  PRIMARY KEY (`Codigo_Pedido`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `InventarioFerreteria`.`PRODUCTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InventarioFerreteria`.`PRODUCTO` (
  `idPRODUCTO` INT NOT NULL AUTO_INCREMENT,
  `Cod_Producto` CHAR(6) NOT NULL,
  `Cate_Prod` VARCHAR(45) NOT NULL,
  `Cod_Categoria` INT NOT NULL,
  `Descrip_Producto` VARCHAR(50) NOT NULL,
  `Marca` VARCHAR(30) NOT NULL,
  `Cantidad` DECIMAL(7,2) NOT NULL,
  `Valor_Unitario` DECIMAL(7,2) NOT NULL,
  `Unidad_Medida` VARCHAR(30) NOT NULL,
  `Fecha_Registro` DATE NOT NULL,
  PRIMARY KEY (`idPRODUCTO`))
ENGINE = InnoDB;

USE `InventarioFerreteria` ;

-- -----------------------------------------------------
-- Placeholder table for view `InventarioFerreteria`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `InventarioFerreteria`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `InventarioFerreteria`.`view1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `InventarioFerreteria`.`view1`;
USE `InventarioFerreteria`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
