-- create database quanlytrungtam; 

-- create table TAIKHOAN (
-- 	id int,
-- 	tendangnhap char(20) not null,
--     matkhau char(20) not null,
--     sdt int default null,
--     gmail char(255) default null,
--     ten char(255) default null,
--     primary key (id)
-- );
-- create table tracnghiem (
-- 	id int,
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
-- 	id int,
--     mon varchar(255),
-- 	chuong int,
--     deBai varchar(255),
--     doKho int,
--     goiY varchar(255),
-- 	primary key(id)
-- );

-- insert into taikhoan(id, tendangnhap, matkhau, sdt, gmail, ten) 
-- values (001, 'kong1032002', 10032002, 0354976596, 'kong1032002@gmail.com', 'nguyen thanh cong');

-- insert into tracnghiem(id, mon, chuong, deBai, doKho, A, B, C, D, dapAn) 
-- values (001, 'toan', 1, '1+1 = ?' , 1, '2','3','4','5','A');

-- insert into tuluan(id, mon, chuong , deBai, doKho, goiY)
-- values (001, 'toan', 1, '1+1', 1, 'Ap dung cong thuc la ra');

select * from taikhoan;
select * from tracnghiem;
select * from tuluan;