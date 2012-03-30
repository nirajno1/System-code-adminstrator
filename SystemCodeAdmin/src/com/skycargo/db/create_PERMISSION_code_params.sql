delimiter ;
CREATE TABLE `permission_code_params` (
  `permission_code_params_id` int(11) NOT NULL AUTO_INCREMENT,
  `MODULE` varchar(50) DEFAULT NULL,
  `SUC` varchar(50) DEFAULT NULL,
  `SCR_CODE` varchar(50) NOT NULL,
  `PERMISSION_CODE` varchar(50) NOT NULL,
  `JIRA_ID` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `AIRLINECODE` varchar(2) DEFAULT 'EK',
  `DEVELOPER` varchar(50) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_on` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`permission_code_params_id`),
  UNIQUE KEY `PERMISSION_CODE` (`PERMISSION_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

SELECT * FROM `new_schema_systemadmin`.`mst_request_type`;