-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 18:19:42
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinaria_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID_CLIEN` int(11) NOT NULL,
  `NOM_CLIEN` varchar(50) NOT NULL,
  `APE_CLIEN` varchar(50) NOT NULL,
  `DNI_CLIEN` char(20) NOT NULL,
  `DIREC_CLIEN` varchar(50) NOT NULL,
  `EMAIL_CLIEN` varchar(50) NOT NULL,
  `FONO_CLIEN` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_CLIEN`, `NOM_CLIEN`, `APE_CLIEN`, `DNI_CLIEN`, `DIREC_CLIEN`, `EMAIL_CLIEN`, `FONO_CLIEN`) VALUES
(15, 'LUIS', 'GONSALES', '79412336', 'LOS OLIVOS', 'luis@gonsales.com', '989823654'),
(17, 'SOFIA', 'HUAMAN', '56981244', 'PUENTE PIEDRA', 'sofia@huaman.com', '988865144'),
(19, 'PACO', 'TORRES', '85662300', 'CALLAO', 'paco@torres.com', '778852365');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleservicio`
--

CREATE TABLE `detalleservicio` (
  `ID_VENTA` int(11) NOT NULL,
  `ID_MASCO` int(11) NOT NULL,
  `ID_SERVI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `ID_VENTA` int(11) NOT NULL,
  `ID_PRODU` int(11) NOT NULL,
  `CANT_DETVEN` int(11) NOT NULL,
  `MONTO_DETVEN` decimal(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `ID_MASCO` int(11) NOT NULL,
  `NOM_MASCO` varchar(30) NOT NULL,
  `GENE_MASCO` varchar(30) NOT NULL,
  `RAZA_MASCO` varchar(30) NOT NULL,
  `ID_CLIEN` int(11) NOT NULL,
  `ID_TIPOMAS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`ID_MASCO`, `NOM_MASCO`, `GENE_MASCO`, `RAZA_MASCO`, `ID_CLIEN`, `ID_TIPOMAS`) VALUES
(14, 'PACO', 'MACHO', 'PASTOR ALEMAN', 15, 1),
(15, 'AKI', 'HEMBRA', 'SIAMES', 17, 2),
(16, 'ZAIKO', 'MACHO', 'PIT BULL', 19, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `ID_PERSO` int(11) NOT NULL,
  `NOM_PERSO` varchar(50) NOT NULL,
  `APE_PERSO` varchar(50) NOT NULL,
  `DNI_PERSO` char(20) NOT NULL,
  `DIREC_PERSO` varchar(50) NOT NULL,
  `EMAIL_PERSO` varchar(50) NOT NULL,
  `FONO_PERSO` char(15) NOT NULL,
  `USU_PERSO` varchar(30) NOT NULL,
  `PASS_PERSO` varchar(30) NOT NULL,
  `ID_TIPOPER` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`ID_PERSO`, `NOM_PERSO`, `APE_PERSO`, `DNI_PERSO`, `DIREC_PERSO`, `EMAIL_PERSO`, `FONO_PERSO`, `USU_PERSO`, `PASS_PERSO`, `ID_TIPOPER`) VALUES
(1, 'EDIZON', 'LOPEZ', '99999991', 'VENTANILLA', 'JULIO@GMAIL.COM', '900000001', 'admin1', 'admin1', 1),
(3, 'JOSE', 'CRUZ', '99999993', 'CHORRILLOS', 'juan@gmail.com', '900000003', 'emp1', 'emp1', 2),
(7, 'ERICK', 'SIMON', '77777777', 'VENTANILLA', 'luis@gonsales.com', '989895412', 'emp2', 'emp2', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID_PRODU` int(11) NOT NULL,
  `NOM_PRODU` varchar(30) NOT NULL,
  `STOCK_PRODU` int(11) NOT NULL,
  `PRECIO_PRODU` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID_PRODU`, `NOM_PRODU`, `STOCK_PRODU`, `PRECIO_PRODU`) VALUES
(1, 'ROPA', 20, '15.50'),
(2, 'SHAMPOO', 31, '12.30'),
(5, 'COMIDA', 78, '3.20'),
(14, 'ALIMENTO PARA PERROS', 10, '50.00'),
(15, 'ALIMENTO PARA GATOS', 12, '40.00'),
(16, 'JUGUETE PARA PERROS ', 15, '10.00'),
(17, 'JUGUETE PARA GATOS', 12, '10.00'),
(18, 'COLLAR PARA PERROS', 5, '8.00'),
(19, 'COLLAR PARA GATOS', 5, '8.00'),
(20, 'CORREA PARA PERROS', 15, '10.00'),
(21, 'CHAMPU PARA GATOS', 20, '15.00'),
(22, 'CHAMPU PARA PERROS', 20, '15.00'),
(23, 'CAMA PARA PERROS', 20, '30.00'),
(24, 'CAMA PARA GATOS', 20, '25.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `ID_SERVI` int(11) NOT NULL,
  `DESC_SERVI` varchar(50) NOT NULL,
  `PRECIO_SERVI` decimal(9,2) NOT NULL,
  `ID_TIPOMAS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`ID_SERVI`, `DESC_SERVI`, `PRECIO_SERVI`, `ID_TIPOMAS`) VALUES
(10, 'BAÑO PARA PERROS', '10.00', 1),
(11, 'BAÑO PARA GATOS', '10.00', 2),
(12, 'PELUQUERIA', '10.00', 1),
(13, 'MEDICINA CANINA', '15.00', 1),
(14, 'MEDICINA FELINA', '15.00', 2),
(15, 'GUARDERIA CANINA', '20.00', 1),
(16, 'GUARDERIA FELINA', '20.00', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipomascota`
--

CREATE TABLE `tipomascota` (
  `ID_TIPOMAS` int(11) NOT NULL,
  `NOM_TIPOMAS` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipomascota`
--

INSERT INTO `tipomascota` (`ID_TIPOMAS`, `NOM_TIPOMAS`) VALUES
(1, 'PERRO'),
(2, 'GATO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopersonal`
--

CREATE TABLE `tipopersonal` (
  `ID_TIPOPER` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipopersonal`
--

INSERT INTO `tipopersonal` (`ID_TIPOPER`, `DESCRIPCION`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'EMPLEADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `ID_VENTA` int(11) NOT NULL,
  `FECHA_VENTA` varchar(30) NOT NULL,
  `TOTAL_VENTA` decimal(9,2) NOT NULL,
  `ID_PERSO` int(11) NOT NULL,
  `ID_CLIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_CLIEN`),
  ADD UNIQUE KEY `DNI_CLIEN` (`DNI_CLIEN`);

--
-- Indices de la tabla `detalleservicio`
--
ALTER TABLE `detalleservicio`
  ADD KEY `ID_VENTA` (`ID_VENTA`),
  ADD KEY `ID_MASCO` (`ID_MASCO`),
  ADD KEY `ID_SERVI` (`ID_SERVI`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD KEY `ID_VENTA` (`ID_VENTA`),
  ADD KEY `ID_PRODU` (`ID_PRODU`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`ID_MASCO`),
  ADD KEY `ID_CLIEN` (`ID_CLIEN`),
  ADD KEY `ID_TIPOMAS` (`ID_TIPOMAS`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`ID_PERSO`),
  ADD UNIQUE KEY `DNI_PERSO` (`DNI_PERSO`),
  ADD UNIQUE KEY `USU_PERSO` (`USU_PERSO`),
  ADD KEY `ID_TIPOPER` (`ID_TIPOPER`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID_PRODU`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`ID_SERVI`),
  ADD KEY `ID_TIPOMAS` (`ID_TIPOMAS`);

--
-- Indices de la tabla `tipomascota`
--
ALTER TABLE `tipomascota`
  ADD PRIMARY KEY (`ID_TIPOMAS`);

--
-- Indices de la tabla `tipopersonal`
--
ALTER TABLE `tipopersonal`
  ADD PRIMARY KEY (`ID_TIPOPER`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`ID_VENTA`),
  ADD KEY `ID_PERSO` (`ID_PERSO`),
  ADD KEY `ID_CLIEN` (`ID_CLIEN`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID_CLIEN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `ID_MASCO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `ID_PERSO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `ID_PRODU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `ID_SERVI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `tipomascota`
--
ALTER TABLE `tipomascota`
  MODIFY `ID_TIPOMAS` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tipopersonal`
--
ALTER TABLE `tipopersonal`
  MODIFY `ID_TIPOPER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `ID_VENTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleservicio`
--
ALTER TABLE `detalleservicio`
  ADD CONSTRAINT `detalleservicio_ibfk_1` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`),
  ADD CONSTRAINT `detalleservicio_ibfk_2` FOREIGN KEY (`ID_MASCO`) REFERENCES `mascota` (`ID_MASCO`),
  ADD CONSTRAINT `detalleservicio_ibfk_3` FOREIGN KEY (`ID_SERVI`) REFERENCES `servicio` (`ID_SERVI`);

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`ID_VENTA`) REFERENCES `venta` (`ID_VENTA`),
  ADD CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`ID_PRODU`) REFERENCES `producto` (`ID_PRODU`);

--
-- Filtros para la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`ID_CLIEN`) REFERENCES `cliente` (`ID_CLIEN`),
  ADD CONSTRAINT `mascota_ibfk_2` FOREIGN KEY (`ID_TIPOMAS`) REFERENCES `tipomascota` (`ID_TIPOMAS`);

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`ID_TIPOPER`) REFERENCES `tipopersonal` (`ID_TIPOPER`);

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`ID_TIPOMAS`) REFERENCES `tipomascota` (`ID_TIPOMAS`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`ID_PERSO`) REFERENCES `personal` (`ID_PERSO`),
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`ID_CLIEN`) REFERENCES `cliente` (`ID_CLIEN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
