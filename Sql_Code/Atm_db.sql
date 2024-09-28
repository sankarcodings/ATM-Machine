create database ATM;
use ATM;
create table users(
	userName varchar(20) ,
	userAcc int primary key,
    userpwd varchar(20),
    usercash double,
    userDate date );
    
drop table users;
insert into users values 
("Sankar" , 12345678 , "sankar123",60000,"2024-11-08");
    
select * from users;
