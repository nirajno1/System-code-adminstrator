/*drop the existing child table 
DROP TABLE mst_request_type_params;*/
/*drop the existing table 
DROP TABLE mst_request_type;*/
/*Create table this table is used to store all supporting request types.
--This is a type of master table*/
create table mst_request_type (
request_id integer AUTO_INCREMENT,
request_type varchar(50) not null,
created_by varchar(50),
updated_by varchar(50),
created_on timestamp,
updated_on timestamp);

/*Add primary key constraint*/

ALTER TABLE mst_request_type ADD CONSTRAINT pk_mst_request_type PRIMARY KEY (request_id);