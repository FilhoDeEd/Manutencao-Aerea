-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22/06/2023 às 01:31
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `manutencao-aerea`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aeronave`
--

CREATE TABLE `aeronave` (
  `prefixo` varchar(10) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `fabricante` varchar(50) NOT NULL,
  `numeroSerie` int(11) NOT NULL,
  `dataFabricacao` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `manutencao`
--

CREATE TABLE `manutencao` (
  `codigo` int(11) NOT NULL,
  `dataRealizacao` date NOT NULL,
  `aeronaveCod` int(11) NOT NULL,
  `mecanicoResp` varchar(14) NOT NULL,
  `horasPrevistas` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `mecanico`
--

CREATE TABLE `mecanico` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `dataNasc` date NOT NULL,
  `registro` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `aeronave`
--
ALTER TABLE `aeronave`
  ADD PRIMARY KEY (`numeroSerie`);

--
-- Índices de tabela `manutencao`
--
ALTER TABLE `manutencao`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_aerocod` (`aeronaveCod`),
  ADD KEY `fk_mecresp` (`mecanicoResp`);

--
-- Índices de tabela `mecanico`
--
ALTER TABLE `mecanico`
  ADD PRIMARY KEY (`cpf`),
  ADD UNIQUE KEY `registro` (`registro`);

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `manutencao`
--
ALTER TABLE `manutencao`
  ADD CONSTRAINT `fk_aerocod` FOREIGN KEY (`aeronaveCod`) REFERENCES `aeronave` (`numeroSerie`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_mecresp` FOREIGN KEY (`mecanicoResp`) REFERENCES `mecanico` (`cpf`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
