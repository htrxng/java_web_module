create database end_module3;

use end_module3;

create table hinh_thuc_thanh_toan(
hinh_thuc_thanh_toan_id int primary key,
hinh_thuc_thanh_toan varchar(30) 
);

create table phong_tro(
phong_tro_id int primary key auto_increment,
ten_nguoi_thue_tro varchar(45),
so_dien_thoai varchar(10),
ngay_bat_dau_thue_tro date,
hinh_thuc_thanh_toan_id int,
ghi_chu varchar(50),
foreign key (hinh_thuc_thanh_toan_id) references hinh_thuc_thanh_toan(hinh_thuc_thanh_toan_id)
);

