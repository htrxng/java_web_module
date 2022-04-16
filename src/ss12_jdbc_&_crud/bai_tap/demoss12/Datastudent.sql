create database student_list;
use student_list;

create table student(
code_student  int primary key auto_increment,
name_student varchar(45) not null,
date_of_birht date, 
gender boolean,
`point` int,
`code_class` int
);

create table `class`(
code_class int primary key auto_increment,
name_class varchar(30)
);

INSERT INTO `student_list`.`class` (`code_class`, `name_class`) VALUES ('1', 'C12');
INSERT INTO `student_list`.`class` (`code_class`, `name_class`) VALUES ('2', 'C01');
INSERT INTO `student_list`.`class` (`code_class`, `name_class`) VALUES ('3', 'C02');
INSERT INTO `student_list`.`class` (`code_class`, `name_class`) VALUES ('4', 'C03');

alter table student add constraint lien_ket_lop foreign key (code_class) references `class`(code_class); 

INSERT INTO `student_list`.`student` (`code_student`, `name_student`, `date_of_birht`, `gender`, `point`, `code_class`) VALUES ('1', 'Trung', '2002/1/1', '1', '8', '1');
INSERT INTO `student_list`.`student` (`code_student`, `name_student`, `date_of_birht`, `gender`, `point`, `code_class`) VALUES ('2', 'Toan', '2001/1/1', '1', '9', '2');
INSERT INTO `student_list`.`student` (`code_student`, `name_student`, `date_of_birht`, `gender`, `point`, `code_class`) VALUES ('3', 'Ly', '2005/2/10', '0', '10', '3');




