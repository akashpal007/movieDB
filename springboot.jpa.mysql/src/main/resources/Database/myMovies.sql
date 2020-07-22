-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: myMovieDB
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `id` varchar(255) NOT NULL,
  `my_rating` varchar(255) DEFAULT NULL,
  `overview` longtext,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(255) DEFAULT NULL,
  `vote_average` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKalxd2gq5t3blfes3tmo612sp0` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES ('420818','9','Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub\'s arrival. Scar, Mufasa\'s brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba\'s exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.','2020-07-21 12:46:52','The Lion King','7.2',1),('155','8','Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.','2020-07-21 12:47:26','The Dark Knight','8.4',1),('2','8','Taisto Kasurinen is a Finnish coal miner whose father has just committed suicide and who is framed for a crime he did not commit. In jail, he starts to dream about leaving the country and starting a new life. He escapes from prison but things don\'t go as planned...','2020-07-21 12:48:18','Ariel','6.7',1),('299536','8','As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.','2020-07-21 12:48:38','Avengers: Infinity War','8.3',1),('1412','8','A sexually repressed woman\'s husband is having an affair with her sister. The arrival of a visitor with a rather unusual fetish changes everything.','2020-07-21 12:48:51','Sex, Lies, and Videotape','6.9',1),('184315','8','Fourteen hundred years ago, a tormented soul walked the earth that was neither man nor god. Hercules was the powerful son of the god king Zeus, for this he received nothing but suffering his entire life. After twelve arduous labors and the loss of his family, this dark, world-weary soul turned his back on the gods finding his only solace in bloody battle. Over the years he warmed to the company of six similar souls, their only bond being their love of fighting and presence of death. These men and woman never question where they go to fight or why or whom, just how much they will be paid. Now the King of Thrace has hired these mercenaries to train his men to become the greatest army of all time. It is time for this bunch of lost souls to finally have their eyes opened to how far they have fallen when they must train an army to become as ruthless and blood thirsty as their reputation has become.','2020-07-21 12:53:22','Hercules','5.7',1),('11','8','Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire. Venturesome Luke Skywalker and dashing captain Han Solo team together with the loveable robot duo R2-D2 and C-3PO to rescue the beautiful princess and restore peace and justice in the Empire.','2020-07-21 12:54:17','Star Wars','8.2',1),('486589','8','Princes who have been turned into Dwarfs seek the red shoes of a lady in order to break the spell, although it will not be easy.','2020-07-21 12:54:29','Red Shoes and the Seven Dwarfs','7.2',1),('550','8','A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.','2020-07-21 12:54:37','Fight Club','8.4',1),('514847','8','Twelve strangers wake up in a clearing. They don\'t know where they are—or how they got there. In the shadow of a dark internet conspiracy theory, ruthless elitists gather at a remote location to hunt humans for sport. But their master plan is about to be derailed when one of the hunted turns the tables on her pursuers.','2020-07-21 12:54:50','The Hunt','6.7',1),('218','9','In the post-apocalyptic future, reigning tyrannical supercomputers teleport a cyborg assassin known as the \"Terminator\" back to 1984 to kill Sarah Connor, whose unborn son is destined to lead insurgents against 21st century mechanical hegemony. Meanwhile, the human-resistance movement dispatches a lone warrior to safeguard Sarah. Can he stop the virtually indestructible killing machine?','2020-07-21 12:55:08','The Terminator','7.6',1),('228150','8','In the last months of World War II, as the Allies make their final push in the European theatre, a battle-hardened U.S. Army sergeant named \'Wardaddy\' commands a Sherman tank called \'Fury\' and its five-man crew on a deadly mission behind enemy lines. Outnumbered and outgunned, Wardaddy and his men face overwhelming odds in their heroic attempts to strike at the heart of Nazi Germany.','2020-07-21 12:55:27','Fury','7.5',1),('62177','8','Brave is set in the mystical Scottish Highlands, where Mérida is the princess of a kingdom ruled by King Fergus and Queen Elinor. An unruly daughter and an accomplished archer, Mérida one day defies a sacred custom of the land and inadvertently brings turmoil to the kingdom. In an attempt to set things right, Mérida seeks out an eccentric old Wise Woman and is granted an ill-fated wish. Also figuring into Mérida’s quest — and serving as comic relief — are the kingdom’s three lords: the enormous Lord MacGuffin, the surly Lord Macintosh, and the disagreeable Lord Dingwall.','2020-07-21 12:56:09','Brave','7.0',1),('42324','8','When Aryong, the daughter of a triad boss from Hong Kong is accused of killing the boss of a competing triad, she goes into hiding in Korea. Upon arriving, she is guided by a nimble but loyal Gi-chul and his motley crew, who are assigned to protect her until her return.','2020-07-21 12:56:20','My Wife Is a Gangster 3','6.3',1),('270303','8','After carefree teenager Jay  sleeps with her new boyfriend, Hugh, for the first time, she learns that she is the latest recipient of a fatal curse that is passed from victim to victim via sexual intercourse. Death, Jay learns, will creep inexorably toward her as either a friend or a stranger. Jay\'s friends don\'t believe her seemingly paranoid ravings, until they too begin to see the phantom assassins and band together to help her flee or defend herself.','2020-07-21 12:58:21','It Follows','6.5',1),('10674','8','A tomboyish girl disguises herself as a young man so she can fight with the Imperial Chinese Army against the invading Huns. With help from wise-cracking dragon Mushu, Mulan just might save her country -- and win the heart of handsome Captain Li Shang.','2020-07-21 12:58:41','Mulan','7.9',1),('203321','8','When a struggling publisher discovers his only successful author is blocked he knows he has to unblock her or he\'s finished. With her newfound success, she\'s become too damn happy and she can\'t write when she\'s happy.The only trouble is, the worse he makes her feel, the more he realises he\'s in love with her.','2020-07-21 12:58:52','Not Another Happy Ending','6.3',1),('24','9','An assassin is shot by her ruthless employer, Bill, and other members of their assassination circle – but she lives to plot her vengeance.','2020-07-21 13:00:34','Kill Bill: Vol. 1','8.0',1),('324558','9','The evolution of adult cinema through the most influential films in history, a journey that begins in the 1970s and ends nowadays. An in-depth analysis of the success of the most prestigious erotic films, their impact on industry and society, and their influence on cinema and contemporary culture.','2020-07-21 13:01:11','X-Rated: The Greatest Adult Movies of All Time','5.8',1),('86671','9','The \"slippery\" comedy is about 2 easy-living young men. They decide to make sex films. This adventurous enterprise could be a little complicated but nothing will deter them.','2020-07-21 13:01:49','Blue Movies','5.5',1),('54559','9','With so many jobs to choose from, the Minions have to make serious decisions after watching an \'Initiation Video\'. What could go wrong?!','2020-07-21 13:02:30','Minions: Orientation Day','6.9',1),('39145','9','Goku and Kuririn are given an assignment by Kame-Sen\'nin: \"Retrieve the sleeping princess from Lucifer and I will take you as my students.\" But the mission proves to be more perilous than originally thought.','2020-07-21 13:03:02','Dragon Ball: Sleeping Princess in Devil\'s Castle','6.3',1),('366143','9','Little baby needs his pacifier, but loses it during a heist in a museum. What will he do?  Short #3 from the \'Minions: 3 Mini-Movie Collection\'.','2020-07-21 13:03:16','Binky Nelson Unpacified','5.9',1),('229405','9','Two Minions are busy at work in the mailroom. One of them, bored, decides to throw a box of expired PX-41 samples into its designated chute.','2020-07-21 13:03:26','Panic in the Mailroom','6.8',1),('39148','9','A retelling of Dragon Ball\'s origin with a different take on the meeting of Goku, Bulma, and Kame-Sen\'nin. It also retells the Red Ribbon Army story; but this time they find Goku rather than Goku finding them.','2020-07-21 13:03:37','Dragon Ball: The Path to Power','7.0',1),('39105','9','Mr. Money is holding another World Martial Arts Tournament and Mr. Satan invites everyone in the world to join in. Little does he know that Bojack, an ancient villain who has escaped his prison, is competing. Since Goku is currently dead, it is up to Gohan, Vegeta, and Trunks to defeat Bojack and his henchman.','2020-07-21 13:03:45','Dragon Ball Z: Bojack Unbound','6.9',1),('39108','9','The Z Warriors discover an unopenable music box and are told to open it with the Dragon Balls. The contents turn out to be a warrior named Tapion who had sealed himself inside along with a monster called Hildegarn. Goku must now perfect a new technique to defeat the evil monster.','2020-07-21 13:03:54','Dragon Ball Z: Wrath of the Dragon','7.1',1),('39103','9','Cooler has resurrected himself as a robot and is enslaving the people of New Namek. Goku and the gang must help.','2020-07-21 13:04:03','Dragon Ball Z: The Return of Cooler','6.7',1);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-21 22:19:38
