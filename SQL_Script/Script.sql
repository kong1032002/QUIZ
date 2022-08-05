-- create database quanlytrungtam; 
-- drop table taikhoan;
-- drop table tracnghiem;
-- drop table tuluan;
-- drop table hocsinh;
-- drop table giaovien;

-- create table TAIKHOAN (
-- 	id int auto_increment, 
-- 	tendangnhap char(20) not null,
--     matkhau char(20) not null,
--     sdt int default null,
--     gmail char(255) default null,
--     ten char(255) default null,
--     primary key (id)
-- );
-- create table tracnghiem (
-- 	id int auto_increment,
--     mon varchar(255),
-- 	chuong int,
--     deBai varchar(255),
--     doKho int,
--     A varchar(255),
--     B varchar(255),
--     C varchar(255),
--     D varchar(255),
--     dapAn varchar(255),
-- 	primary key(id)
-- );

-- create table tuLuan (
-- 	id int auto_increment,
--     mon varchar(255),
-- 	chuong int,
--     deBai varchar(255),
--     doKho int,
--     goiY varchar(255),
-- 	primary key(id)
-- );

-- create table giaovien(
-- 	id int auto_increment,
--     ho varchar(255) not null,
--     ten varchar(255) not null,
--     ngaySinh varchar(10) not null,
--     gioiTinh varchar(10) not null,
--     CMND int not null,
--     sdt int not null,
--     email varchar(255) not null,
--     diaChi varchar(255),
--     chucVu varchar(255) not null,
--     luong varchar(255) not null,
--     primary key(id)
-- );

-- create table hocsinh(
-- 	id int auto_increment,
--     ho varchar(255) not null,
--     ten varchar(255) not null,
--     ngaySinh varchar(10) not null,
--     gioiTinh varchar(10) not null,
--     sdt int not null,
--     tenBo varchar(255),
--     tenMe varchar(255),
--     sdtPhuHuynh int not null,
--     primary key(id)
-- );

-- insert into taikhoan(tendangnhap, matkhau, sdt, gmail, ten) 
-- values ('kong1032002', 10032002, 0354976596, 'kong1032002@gmail.com', 'nguyen thanh cong');

-- insert into tracnghiem(mon, chuong, deBai, doKho, A, B, C, D, dapAn) 
-- values ('toan', 1, '1+1 = ?' , 1, '2','3','4','5','A');

-- insert into tuluan(mon, chuong , deBai, doKho, goiY)
-- values ('toan', 1, '1+1', 1, 'Ap dung cong thuc la ra'); 

-- insert into hocsinh(ho, ten, ngaySinh, gioiTinh, sdt, sdtPhuHuynh) 
-- values('nguyen', 'thanh cong', '10/03/2002', 'nam', 0354976596, 0378306776);

-- insert into giaovien(ho, ten, ngaySinh, gioiTinh, sdt, email, CMND, diaChi, chucVu, luong)
-- values ('nguyen', 'thanh cong', '10/03/2002', 'nam', 0354976596, 'kong10032002@gmail.com', 061159311, 'YenBai', 'Giam Doc', 12000000);
giaoviengiaovien
select * from taikhoan;
select * from tracnghiem;
select * from tuluan;
select * from hocsinh;
select * from giaovien;