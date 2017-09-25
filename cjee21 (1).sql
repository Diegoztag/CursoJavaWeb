-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 22-09-2017 a las 20:21:31
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cjee21`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_alumnos` (IN `alid` INT)  BEGIN
	delete from alumnos
	WHERE id = alid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_alumnos` (IN `alnombre` VARCHAR(20), IN `alapaterno` VARCHAR(20), IN `alamaterno` VARCHAR(20), IN `almatricula` VARCHAR(10))  BEGIN
	INSERT INTO alumnos(
    	nombre,
        apaterno,
        amaterno,
        matricula
    ) VALUES (
    	alnombre,
        alapaterno,
        alamaterno,
        almatricula
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_usuarios` (IN `pusuario` VARCHAR(50), IN `pnombre` VARCHAR(50), IN `ppass` VARCHAR(50))  BEGIN
	INSERT INTO usuarios(
    	nombre,
        usuario,
        password
    ) VALUES (
    	pnombre,
        pusuario,
        ppass
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAlumnos` ()  BEGIN
	SELECT * from alumnos;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectUsrByID` (IN `pid` INT)  BEGIN
	SELECT * FROM usuarios WHERE id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectUsuarios` ()  BEGIN
	SELECT * FROM usuarios;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `select_alByID` (IN `alid` INT)  BEGIN
	SELECT id, nombre, apaterno, amaterno, matricula FROM alumnos
	WHERE id = alid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_alumnos` (IN `alnombre` VARCHAR(30), IN `alapaterno` VARCHAR(30), IN `alamaterno` VARCHAR(30), IN `almatricula` VARCHAR(10), IN `alid` INT(10))  NO SQL
BEGIN
	UPDATE alumnos SET nombre = alnombre , apaterno = alapaterno, amaterno = alamaterno, matricula = almatricula WHERE id = alid;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apaterno` varchar(30) DEFAULT NULL,
  `amaterno` varchar(30) DEFAULT NULL,
  `matricula` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `nombre`, `apaterno`, `amaterno`, `matricula`) VALUES
(1, 'Diego', 'zazueta', 'Aguirre', '1234567'),
(5, 'dsad', 'dsada', 'dsada', 'dada'),
(7, 'dddd', 'homie', 'mcklsdñamdfkl', 'mkxlsñamd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `nivel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `nombre`, `nivel`) VALUES
(2, 'Algoritmos', 'Mega Avanzado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `password`, `nombre`) VALUES
(4, 'null', 'null,l', 'Juan Lopezxd'),
(5, 'marian', 'marian', 'Maria Nuñez'),
(7, 'Ana Mendez', 'amen', 'ame'),
(8, 'rosaju', 'rojajuju', 'Rosa Juarez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
