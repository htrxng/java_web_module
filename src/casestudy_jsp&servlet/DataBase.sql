create database furama_manager_1;
use furama_manager_1;

create table `position`(
position_id int primary key,
position_name varchar(45)
);

create table `education_degree`(
education_degree_id int primary key,
education_degree_name varchar(45)
);

create table `division`(
division_id int primary key,
divion_name varchar(45)
);

create table `role`(
role_id int primary key,
role_name varchar(255)
);

create table `user`(
username varchar(255) primary key,
`password` varchar(255)
);

-- block
create table user_role(
role_id int,
username varchar(255),
primary key (role_id,username),
foreign key (role_id) references `role`(role_id),
foreign key (username) references `user`(username)
);         	

create table `employee`(
employee_id int primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card  varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int not null,
education_degree_id int not null,
division_id int not null,
`username` varchar(255),
foreign key (position_id) references `position`(position_id),
foreign key (education_degree_id) references `education_degree`(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (`username`) references `user`(`username`)
);

create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);

create table  customer(
customer_id int primary key auto_increment,
customer_type_id int not null,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45),
foreign key (customer_type_id) references customer_type(customer_type_id)
);

create table service_type(
service_type_id int primary key,
service_type_name varchar(45)
);

create table rent_type(
rent_type_id int primary key,
rent_type_name varchar(45),
rent_type_cost double
);

create table service(
service_id int primary key auto_increment,
service_name varchar(45) not null,
service_area int,
service_cost double not null,
service_max_people int,
rent_type_id int not null,
service_type_id int not null,
standard_room varchar(45),
description_other_converience varchar(45),
pool_area double,
number_of_floors int,
foreign key (rent_type_id) references rent_type(rent_type_id), 
foreign key (service_type_id) references service_type(service_type_id) 
);

create table contract(
contract_id int primary key auto_increment,
contract_start_date datetime not null,
contract_end_date datetime not null,
contract_deposit double not null,
contract_total_money double not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id),
foreign key (service_id) references service(service_id)
);

create table attach_service(
attach_service_id int primary key,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit int not null,
attact_service_status varchar(45)
);

create table contract_detail(
contract_detail_id int primary key,
contract_id int not null,
attach_service_id int not null,
quantity int not null,
foreign key (contract_id) references contract(contract_id),
foreign key (attach_service_id) references attach_service(attach_service_id)
);

-- insert data
INSERT INTO `furama_manager_1`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_converience`, `pool_area`, `number_of_floors`) VALUES 
(1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'Deluxe', 'Buffet', 500, 4);

INSERT INTO `furama_manager_1`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_converience`, `pool_area`, `number_of_floors`) VALUES 
(2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'Suite', 'Tivi', null , 2);

INSERT INTO `furama_manager_1`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_converience`, `pool_area`, `number_of_floors`) VALUES 
(3, 'Room Twin 01', 5000, 1000000, 2, 2, 3, null, 'Water',null ,null );

INSERT INTO `furama_manager_1`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_converience`, `pool_area`, `number_of_floors`) VALUES 
(4, 'Villa No Beach Front', 22000, 9000000, 8, 2, 1, 'Superior ', 'Buffet', 600, 3);

INSERT INTO `furama_manager_1`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_converience`, `pool_area`, `number_of_floors`) VALUES 
(5, 'House Princess 02', 10000, 4000000, 5, 3, 2, 'Deluxe', 'Tivi', null, 2);

INSERT INTO `furama_manager_1`.`service` (`service_id`, `service_name`, `service_area`, `service_cost`, `service_max_people`, `rent_type_id`, `service_type_id`, `standard_room`, `description_other_converience`, `pool_area`, `number_of_floors`) VALUES 
(6, 'Room Twin 02', 3000, 900000, 2, 1, 3, null, 'Water',null, null);

-- insert customer
INSERT INTO `furama_manager_1`.`customer` 
(`customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (5, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362','thihao07@gmail.com','23 Nguyễn Hoàng,Đà Nẵng');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (2, 3, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (3, 1, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (4, 1, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng');


INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (6, 4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (7, 1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (8, 3, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (9, 1, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi');

INSERT INTO `furama_manager_1`.`customer` 
(`customer_id`, `customer_type_id`, `customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`) 
VALUES (10, 2, 'Nguyễn Tâm Đắc','1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng');







