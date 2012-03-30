
/*SELECT * FROM `new_schema_systemadmin`.`mst_request_type`;*/
delimiter ;
CREATE TABLE transaction_code_params (
  transaction_code_params int(11) NOT NULL AUTO_INCREMENT,
  MODULE varchar(50) DEFAULT NULL,
  TRANSACTION_ID int(11) NOT NULL,
  BI_NAME varchar(50) NOT NULL,
  METHOD_NAME varchar(50) NOT NULL,
  TRANSACTION_TYPE varchar(50) NOT NULL,
  JIRA_ID varchar(50) DEFAULT NULL,
  
  DESCRIPTION varchar(200) DEFAULT NULL,
  SUC varchar(50) DEFAULT NULL,
  AIRLINECODE varchar(2) DEFAULT 'EK',
  DEVELOPER varchar(50) DEFAULT NULL,
  created_by varchar(50) DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL,
  created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_on timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (transaction_code_params),
  UNIQUE KEY SCR_CODE (TRANSACTION_TYPE,BI_NAME,METHOD_NAME,TRANSACTION_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

