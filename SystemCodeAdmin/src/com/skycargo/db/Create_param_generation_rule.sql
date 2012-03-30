delimiter ;
/*drop TABLE param_generation_rule;*/
CREATE TABLE param_generation_rule (
  param_gen_rule_id int(11) NOT NULL AUTO_INCREMENT,
  req_param_id int(11) DEFAULT NULL, 
  rule_data_prefix varchar(50) DEFAULT NULL,
  rule_data varchar(50) NOT NULL,
  rule_data_suffix varchar(50) NOT NULL,
  next_value varchar(50) DEFAULT NULL,
  description varchar(200) DEFAULT NULL,
  AIRLINECODE varchar(2) DEFAULT 'EK',
  developer varchar(50) DEFAULT NULL,
  created_by varchar(50) DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL,
  created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updated_on timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (param_gen_rule_id),
  CONSTRAINT fk_mst_req_param_rule FOREIGN KEY (req_param_id) REFERENCES mst_request_type (request_id),
  UNIQUE KEY UNIQUE_PARAM (req_param_id,rule_data_prefix,rule_data,rule_data_suffix)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
