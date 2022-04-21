use casestudy_jsp;
​
CREATE TABLE position (
    position_id INT PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(45)
);
​
INSERT INTO position (position_name)
VALUE ("Quảng lý"),("Nhân viên");
SELECT 
    *
FROM
    position; 
​
​
CREATE TABLE education_degree (
    education_degree_id INT PRIMARY KEY AUTO_INCREMENT,
    education_degree_name VARCHAR(45)
);
​
INSERT INTO education_degree (education_degree_name)
VALUE ('Trung Cấp'),
('Cao Đẳng'),
('Đại Học'),
('Sau Đại Học');
SELECT 
    *
FROM
    education_degree; 
​
CREATE TABLE division (
    division_id INT PRIMARY KEY AUTO_INCREMENT,
    division_name VARCHAR(45)
);
​
INSERT INTO division (division_name)
VALUE ('Sale-Marketing'),
('Hành chính'),
('Phục vụ'),
('Quản lý');
SELECT 
    *
FROM
    division; 
    
create table `user` (
username varchar(255) primary key,
`password` varchar(255) 
);
​
insert into `user` (username, `password`) 
values ('annguyen','123'),
('binhle','123'),
('yenho','123'),
('toanvo','123'),
('phatnguyen','123'),
('nghikhuc','123'),
('hanguyen','123'),
('dongnguyen','123'),
('hoangtong','123'),
('daonguyen','123');
​
​
create table `role` (
role_id int primary key auto_increment,
role_name varchar(255)
);
​
​
create table user_role (
role_id int,
username varchar(255),
foreign key (role_id) references `role` (role_id)
);
​
​
CREATE TABLE employee (
	employee_id int primary key auto_increment,
	employee_name varchar(45) not null,
	employee_birthday varchar(45) not null,
	employee_id_card varchar(45) not null,
	employee_salary double not null,
	employee_phone varchar(45) not null,
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    username varchar(255),
    FOREIGN KEY (position_id)
        REFERENCES position (position_id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id),
    FOREIGN KEY (division_id)
        REFERENCES division (division_id),
	FOREIGN KEY (username)
        REFERENCES `user` (username)
);
​
INSERT INTO employee (employee_name,
			employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, 
			employee_address, position_id, education_degree_id, division_id, username)
VALUES ('Nguyễn Văn An','1970-11-07','456231786','10000000','901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1,'annguyen'),
('Lê Văn Bình','1997-04-09','654231234','7000000','934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2,'binhle'),
('Hồ Thị Yến','1995-12-12','999231723','14000000','412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2,'yenho'),
('Võ Công Toản','1980-04-04','123231365','17000000','374443232','toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4,'toanvo'),
('Nguyễn Bỉnh Phát','1999-12-09','454363232','6000000','902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1,'phatnguyen'),
('Khúc Nguyễn An Nghi','2000-11-08','964542311','7000000','978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3,'nghikhuc'),
('Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2,'hanguyen'),
('Nguyễn Hà Đông','1989-09-03','234414123',9000000,'642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4,'dongnguyen'),
('Tòng Hoang','1982-09-03','256781231',6000000,'245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4,'hoangtong'),
('Nguyễn Công Đạo','1994-01-08','755434343',8000000,'988767111','nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2,'daonguyen');
SELECT 
    *
FROM
    employee; 
    
​
​
CREATE TABLE customer_type (
	customer_type_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_type_name VARCHAR(45)
);
​
INSERT INTO customer_type (customer_type_name)
VALUE ('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');
SELECT 
    *
FROM
    customer_type; 
​
 CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_code varchar(45),
    customer_type_id INT,
    customer_name varchar(45) not null,
	customer_birthday date not null,
	customer_gender bit(1) not null,
	customer_id_card varchar(45) not null,
	customer_phone varchar(45) not null,
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id) 
);
​
insert into customer(customer_code, customer_name, customer_birthday, customer_gender,
			customer_id_card, customer_phone, customer_email, customer_address, customer_type_id)
values ("KH-1111","Nguyễn Thị Hào", "1970-11-07", '0', "643431213", "0945459999", "thihao07@gmail.com", "23 Nguyễn Hoàng, Đà Nẵng","5"),
 ("KH-1112","Phạm Xuân Diệu", "1992-08-08", '1', "865342123", "0954678909", "xuandieu92@gmail.com", "K77/22 Thái Phiên, Quảng Trị","3"),
 ("KH-1113","Trương Đình Nghệ", "1990-02-27", '1', "488645199", "0373213122", "nghenhan2702@gmail.com", "K323/12 Ông Ích Khiêm, Vinh","1"),
 ("KH-1114","Dương Văn Quang", "1981-07-08", '1', "543421111", "0490039241", "duongquan@gmail.com", "K452/12 Lê Lợi, Đà Nẵng","1"),
 ("KH-1115","Hoàng Trần Nhi Nhi", "1995-12-09", '0', "795453345", "0312345678", "nhinhi123@gmail.com", "242 Lý Thái Tổ, Gia Lai","4"),
 ("KH-1116","Tôn Nữ Mộc Châu", "2005-12-06", '0', "732434215", "0988888844", "tonnuchau@gmail.com", "37 Yên Thế, Đà Nẵng","4"),
 ("KH-1117","Nguyễn Mỹ Kim", "1984-04-08", '0', "856453123", "0912345698", "kimcuong84@gmail.com", "K123/45 Lê Lợi, Hồ Chí Minh","1"),
 ("KH-1118","Nguyễn Thị Hào", "1999-04-08", '0', "965656433", "0763212345", "haohao99@gmail.com", "55 Nguyễn Văn Linh, Kom Tum","3"),
 ("KH-1119","Trần Đại Danh", "1994-07-01", '1', "432341235", "0643343433", "danhhai99@gmail.com", "24 Lý Thường Kiệt, Quảng Ngãi","1"),
 ("KH-1121","Nguyễn Tâm Đắc", "1989-07-01", '1', "344343432", "0987654321", "dactam@gmail.com", "22 Ngô Quyền, Đà Nẵng","2");
​
SELECT 
    *
FROM
    customer; 
 
 create table rent_type (
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);
 
INSERT INTO rent_type (rent_type_name)
VALUE ('year'),('month'),('day'),('hour');
SELECT 
    *
FROM
    rent_type;
 
 CREATE TABLE service_type (
    service_type_id INT PRIMARY KEY AUTO_INCREMENT,
    service_type_name VARCHAR(45)
);
​
INSERT INTO service_type (service_type_name)
VALUE ('Villa'),
('House'),
('Room');
SELECT 
    *
FROM
    service_type;
​
create table service (
service_id int primary key auto_increment,
service_code varchar(45),
service_name varchar(45) not null,
service_area int,
service_cost double not null,
service_max_people int,
rent_type_id int,
service_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),	
pool_area double,
number_of_floor int,
foreign key (rent_type_id) references rent_type (rent_type_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (service_type_id) references service_type (service_type_id) ON DELETE CASCADE ON UPDATE CASCADE
);
​
​
INSERT INTO service (service_code, service_name, service_area, service_cost, service_max_people,
standard_room, description_other_convenience, pool_area, number_of_floor, rent_type_id, service_type_id)
VALUE ("DK-0001","Villa Beach Front", 25000, 10000000, 10, "vip", "Có hồ bơi", 500, 4, 3, 1),
("DK-0002","House Princess 01", 14000, 5000000, 7, "vip", "Có thêm Bếp Nướng",null, 3, 2, 2),
("DK-0003","Room Twin 01", 5000, 1000000, 2, "normal", "Có TV",null, null, 4, 3),
("DK-0004","Villa Beach Front", 22000, 9000000, 8, "normal", "Có hồ bơi", 300, 3, 3, 1),
("DK-0005","House Princess 02", 10000, 4000000, 5, "normal", "Có thêm Bếp Nướng", null, 2, 3, 2),
("DK-0006","Room Twin 02", 3000, 900000, 2, "normal", "Có TV",null, null, 4, 3);
SELECT 
    *
FROM
    service;
​
CREATE TABLE attach_service (
    attach_service_id INT PRIMARY KEY AUTO_INCREMENT,
    attach_service_name VARCHAR(45) not null,
    attach_service_cost DOUBLE NOT NULL,
    attach_service_unit VARCHAR(10) not null,
    attach_service_status VARCHAR(45)
);
​
INSERT INTO attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status) 
VALUES ("Karaoke", "10000", "giờ", "tiện nghi, hiện đại"),
("Thuê xe máy", "10000", "Chiếc", "hỏng 1 xe"),
("Thuê xe đẹp", "20000", "Chiếc", "Tốt"),
("Buffer buổi sáng", "15000", "Suất", "đầy đủ đồ ăn, tráng miệng"),
("Buffer buổi trưa", "9000", "Suất", "đầy đủ đồ ăn, tráng miệng"),
("Buffer buổi tối", "16000", "Suất", "đầy đủ đồ ăn, tráng miệng");
SELECT 
    *
FROM
    attach_service;
​
​
create table contract (
contract_id int primary key auto_increment,
contract_start_date date not null,
contract_end_date date not null,
contract_deposit double not null,
employee_id int,
customer_id int,
service_id int,
foreign key (employee_id) references employee (employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (customer_id) references customer (customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (service_id) references service (service_id) ON DELETE CASCADE ON UPDATE CASCADE
);
​
INSERT INTO contract(contract_start_date, contract_end_date, contract_deposit, employee_id, customer_id, service_id)
values 
("2020-12-08", "2021-12-08", 0, 3, 1, 3),
("2020-07-14", "2020-07-21", 200000, 7, 3,1),
("2021-03-15", "2021-03-17", 50000, 3,4, 2),
("2021-01-14", "2021-01-18", 100000, 7, 5, 5),
("2021-07-14", "2021-07-15", 0, 7, 2, 6),
("2021-06-01", "2021-06-03", 0, 7, 7, 6),
("2021-09-02", "2021-09-05", 100000, 7, 4, 4),
("2021-06-17", "2021-06-18", 150000, 3, 4, 1),
("2020-11-19", "2020-11-19", 0, 3, 4, 3),
("2021-04-12", "2021-04-14", 0, 10, 3, 5),
("2021-04-25", "2021-04-25", 0, 2, 2, 1),
("2021-05-25", "2021-05-27", 0, 7,10, 1);
SELECT 
    *
FROM
    contract;
​
create table contract_detail (
contract_detail_id int primary key auto_increment,
contract_id int,
attach_service_id int,
quatity int not null,
foreign key (contract_id) references contract (contract_id) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key (attach_service_id) references attach_service (attach_service_id) ON DELETE CASCADE ON UPDATE CASCADE
);
​
​
INSERT INTO contract_detail (quatity,contract_id,attach_service_id)
VALUE (5,2,4),
(8,2,5),
(15,2,6),
(1,3,1),
(11,3,2),
(1,1,3),
(2,1,2),
(2,12,2);
SELECT 
    *
FROM
    contract_detail;
    
    
​
SELECT 
    *
FROM
    casestudy_jsp.service ctm
        JOIN
    service_type ct ON ctm.service_type_id = ct.service_type_id
        JOIN
    rent_type ctt ON ctm.rent_type_id = ctt.rent_type_id;
use casestudy_jsp;
SELECT 
    *
FROM
    casestudy_jsp.employee ctm
        JOIN
    position ct ON ctm.position_id = ct.position_id
        JOIN
    education_degree ctt ON ctm.education_degree_id = ctt.education_degree_id
    join
    division cnt on ctm.division_id = cnt.division_id;