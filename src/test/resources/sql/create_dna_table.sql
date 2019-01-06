CREATE TABLE `dna` (
  `dna` varchar(36) NOT NULL,
  `is_mutant` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`dna`),
  UNIQUE KEY `dna_UNIQUE` (`dna`)
);
