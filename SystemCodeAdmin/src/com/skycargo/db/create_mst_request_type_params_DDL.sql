/*drop the existing table 
DROP TABLE mst_request_type_params IF EXISTS;

--Create mst_request_type_params table to store what kind of data it need to be store
--for a particular type of request*/

create table mst_request_type_params (
request_param_id integer AUTO_INCREMENT primary key,
request_id integer,
request_param_name varchar(50) not null, /* name of the parameters which need to be stored */
request_param_data_type varchar(20) not null, /*data type of parameter, e.g. integer, double, string etc */
airline_code varchar(2), /*airline spacific parameter if required */
created_by varchar(50),
updated_by varchar(50),
created_on timestamp,
updated_on timestamp);

/*--create primary key constraint
ALTER TABLE mst_request_type_params ADD CONSTRAINT pk_mst_request_type_params
    PRIMARY KEY (request_param_id);*/

/*--map the referencial constraint*/
ALTER TABLE mst_request_type_params ADD CONSTRAINT fk_mst_request_type_params
    FOREIGN KEY (request_id)
    REFERENCES mst_request_type (request_id);