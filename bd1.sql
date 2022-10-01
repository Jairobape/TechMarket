-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.9.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando datos para la tabla techmarket_db.detalle: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle` ENABLE KEYS */;

-- Volcando datos para la tabla techmarket_db.factura: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

-- Volcando datos para la tabla techmarket_db.producto: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id_producto`, `producto`, `categoria`, `precio`, `stock`, `descripcion`, `imagen_path`) VALUES
	(3, 'Mouse Ergonomico', 'ergonomico', 200, 7, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_ergonomico.png'),
	(4, 'Mouse Bola', 'gamer', 300, 5, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_bola.png'),
	(5, 'Mouse Razer', 'gamer', 600, 3, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_gamer.png'),
	(6, 'Mouse Touchpad', 'otros', 500, 3, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_touchpad.png'),
	(7, 'Mouse Pequeño', 'oficina', 150, 17, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_pequeño.png'),
	(8, 'Mouse Palanca', 'gamer', 500, 3, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_palanca.png'),
	(9, 'Mouse Anillo', 'otros', 500, 3, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_anillo.png'),
	(10, 'Mouse botones', 'gamer', 600, 4, 'Contiene USB inhalambrico. incluye baterias recargables, rueda de desplazamiento, botones de navegación', './img/mouse_botones.png');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando datos para la tabla techmarket_db.usuario: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `email`, `contrasena`, `nombre`, `apellido`, `rol`) VALUES
	(1, 'correo@edu.co', '12345', 'juan', 'mota', 'cliente'),
	(2, 'asd', 'asd', 'asd', 'asd', 'asd'),
	(10, 'ergdfg@fse.es', '123', 'asd', 'asd', 'cliente'),
	(11, 'prueba@a.s', '1234', 'asd', 'asd', 'cliente'),
	(12, 'juan@correo.com', '123', 'Juan', 'Rodriguez', 'cliente'),
	(13, 'correo@correo.com', '123', 'nombre', 'apellido', 'cliente'),
	(19, 'correo@correoo.com', '1234', 'Miguel', 'Molina', 'cliente'),
	(20, 'miguel@correo.com', '123', 'Miguel', 'Molina', 'cliente');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
