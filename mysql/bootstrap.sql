create database demodb;
use demodb;
create table demotable(id int not null auto_increment, content int, primary key(id));
insert into demotable(content) values (1);