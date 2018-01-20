-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 18, 2017 at 09:43 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkirdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bayar`
--

CREATE TABLE `bayar` (
  `no_polisi` varchar(100) NOT NULL,
  `id_jenis` int(11) NOT NULL,
  `nama` varchar(111) NOT NULL,
  `masuk` datetime NOT NULL,
  `keluar` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `harga`
--

CREATE TABLE `harga` (
  `id_harga` int(11) NOT NULL,
  `id_jenis` int(11) NOT NULL,
  `jenis` varchar(200) NOT NULL,
  `waktu` varchar(200) NOT NULL,
  `harga` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `harga`
--

INSERT INTO `harga` (`id_harga`, `id_jenis`, `jenis`, `waktu`, `harga`) VALUES
(1, 1, 'Roda 2', '1 hari', 'RP 2000'),
(2, 1, 'Roda 4', '1 hari', 'RP 4000'),
(3, 1, 'Truk', '1 hari', 'RP 5000'),
(4, 1, 'BIS', '1 hari', 'RP 7000');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kendaraan`
--

CREATE TABLE `jenis_kendaraan` (
  `id_jenis` int(10) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `harga` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_kendaraan`
--

INSERT INTO `jenis_kendaraan` (`id_jenis`, `jenis`, `harga`) VALUES
(1, 'Roda 2', 2000),
(2, 'Roda 4', 5000),
(3, 'Truk', 10000),
(4, 'BIS', 10000),
(5, 'Odong-Odong', 1000),
(6, 'Dokar', 3000),
(7, 'Kereta', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `parkir_data`
--

CREATE TABLE `parkir_data` (
  `id_parkir` int(10) NOT NULL,
  `nomor_polisi` varchar(16) NOT NULL,
  `id_jenis` varchar(10) NOT NULL,
  `masuk` datetime NOT NULL,
  `keluar` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parkir_data`
--

INSERT INTO `parkir_data` (`id_parkir`, `nomor_polisi`, `id_jenis`, `masuk`, `keluar`) VALUES
(4, 'BH77878T', '1', '2013-06-27 10:59:15', '2013-06-27 14:43:17'),
(5, 'AB213123R', '3', '2013-06-27 15:20:26', '2013-06-27 15:20:33'),
(6, 'B6789C', '2', '2013-06-27 15:28:06', '2013-06-27 15:30:14'),
(7, 'A6789B', '1', '2013-06-27 15:31:06', '2013-06-27 15:31:16'),
(8, 'BA12345TO', '3', '2013-06-27 15:32:10', '2013-06-27 15:34:38'),
(9, 'Ahhhh', '4', '2017-04-27 18:52:15', '2017-04-27 18:53:01'),
(10, 'B612', '4', '2017-04-27 18:56:34', NULL),
(11, '', '2', '2017-04-27 19:38:08', '2017-05-17 20:23:01'),
(12, '', '1', '2017-04-27 19:53:35', '2017-05-17 20:23:01'),
(13, 'Z4545d', '1', '2017-04-29 11:42:45', NULL),
(14, 'ajaj', '2', '2017-04-30 20:53:53', '2017-04-30 22:03:13'),
(15, 'lllllllll', '1', '2017-04-30 22:21:35', NULL),
(16, '13527', '2', '2017-05-04 09:42:23', NULL),
(17, '!23451', '1', '2017-05-04 12:27:49', NULL),
(18, 'abcdef', '1', '2017-05-04 12:28:24', '2017-05-04 12:28:46'),
(19, 'XAXI2', '1', '2017-05-16 10:12:16', NULL),
(20, 'RPL1', '1', '2017-05-16 10:14:16', '2017-05-16 10:16:14');

-- --------------------------------------------------------

--
-- Table structure for table `parkir_paid`
--

CREATE TABLE `parkir_paid` (
  `id_parkir` int(10) NOT NULL,
  `id_jenis` int(11) NOT NULL,
  `nomor_pemilik` varchar(16) NOT NULL,
  `masuk` datetime NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `total` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parkir_paid`
--

INSERT INTO `parkir_paid` (`id_parkir`, `id_jenis`, `nomor_pemilik`, `masuk`, `tanggal`, `total`) VALUES
(1, 1, 'Zidni Ridwan N', '2017-05-04 17:48:47', '11-11-2011', '2000'),
(2, 3, 'Kamui', '2017-05-17 20:30:39', 'MMM d, yyyy', '1000'),
(3, 4, 'Chan_U', '2017-05-17 20:31:26', 'MMM d, yyyy', '1000'),
(4, 2, 'D_YouS', '2017-05-17 20:39:23', 'MMM d, yyyy', '2000'),
(5, 2, 'S_B_z', '2017-05-17 20:42:57', 'May 5, 2017', '10000');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`username`, `password`) VALUES
('zidniryi', 'zidniryi');

-- --------------------------------------------------------

--
-- Table structure for table `tanggal`
--

CREATE TABLE `tanggal` (
  `id` int(11) NOT NULL,
  `tanggal_bayar` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tanggal`
--

INSERT INTO `tanggal` (`id`, `tanggal_bayar`) VALUES
(1, 'Becak');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `harga`
--
ALTER TABLE `harga`
  ADD PRIMARY KEY (`id_harga`),
  ADD KEY `id_jenis` (`id_jenis`);

--
-- Indexes for table `jenis_kendaraan`
--
ALTER TABLE `jenis_kendaraan`
  ADD PRIMARY KEY (`id_jenis`),
  ADD UNIQUE KEY `id_jenis` (`id_jenis`),
  ADD KEY `id_jenis_2` (`id_jenis`);

--
-- Indexes for table `parkir_data`
--
ALTER TABLE `parkir_data`
  ADD PRIMARY KEY (`id_parkir`);

--
-- Indexes for table `parkir_paid`
--
ALTER TABLE `parkir_paid`
  ADD PRIMARY KEY (`id_parkir`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tanggal`
--
ALTER TABLE `tanggal`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `harga`
--
ALTER TABLE `harga`
  MODIFY `id_harga` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `jenis_kendaraan`
--
ALTER TABLE `jenis_kendaraan`
  MODIFY `id_jenis` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `parkir_data`
--
ALTER TABLE `parkir_data`
  MODIFY `id_parkir` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `parkir_paid`
--
ALTER TABLE `parkir_paid`
  MODIFY `id_parkir` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tanggal`
--
ALTER TABLE `tanggal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `harga`
--
ALTER TABLE `harga`
  ADD CONSTRAINT `harga_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_kendaraan` (`id_jenis`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
