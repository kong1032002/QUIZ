-- create database quanlytrungtam; 
drop table if exists thoiGianHoc;
drop table if exists lopBoMon;
drop table if exists cauhoitrongde;
drop table if exists deThi;
drop table if exists tracnghiem;
drop table if exists tuluan;
drop table if exists monHoc;
drop table if exists hocsinh;
drop table if exists lopHanhChinh;
drop table if exists giaovien;
drop table if EXISTS taikhoan;

create table TAIKHOAN (
	id int auto_increment, 
	tendangnhap char(20) not null unique,
    matkhau char(20) not null,
    sdt varchar(15) default null,
    email char(255) default null,
    ten char(255) default null,
    primary key (id)
);

create table monHoc(
	id int auto_increment,
    tenMonHoc varchar(255) not null unique,
    primary key(id)
);

create table tracnghiem (
	id int auto_increment,
    idMonHoc int not null,
    deBai varchar(255) not null,
    doKho varchar(255) not null,
    A varchar(255),
    B varchar(255),
    C varchar(255),
    D varchar(255),
    dapAn varchar(255) not null,
	primary key(id),
    foreign key(idMonHoc) references monHoc(id)
);

create table tuLuan (
	id int auto_increment,
    idMonHoc int not null,
    deBai varchar(255) not null,
    doKho varchar(255) not null,
    goiY varchar(255) not null,
	primary key(id),
    foreign key(idMonHoc) references monHoc(id)
);

create table giaovien(
	id int auto_increment,
    ho varchar(255) not null,
    ten varchar(255) not null,
    ngaySinh date not null,
    gioiTinh varchar(10) not null,
    cccd varchar(15) not null unique,
    sdt varchar(15) not null unique not null,
    email varchar(255) not null unique not null,
    diaChi varchar(255),
    chucVu varchar(255) not null,
    luong varchar(255) not null,
    primary key(id)
);

create table lopBoMon(
	id int auto_increment,
    idMonHoc int not null,
    idGVPT int not null,
    primary key(id),
    foreign key(idMonHoc) references monHoc(id),
    foreign key(idGVPT) references giaovien(id)
);

create table thoiGianHoc(
	idLop int not null,
	ngayTrongTuan varchar(255) not null,
    thoiGian varchar(255) not null,
    phongHoc varchar(255) not null,
    unique(ngayTrongTuan, thoiGian, phongHoc),
    foreign key(idLop) references lopBoMon(id)
);

create table lopHanhChinh(
	id int auto_increment,
    tenLop varchar(255) not null unique,
    idGVCN int not null unique,
    primary key(id),
    foreign key(idGVCN) references giaovien(id)
);

create table hocsinh(
	id int auto_increment,
    ho varchar(255) not null,
    ten varchar(255) not null,
    ngaySinh date not null,
    gioiTinh varchar(10) not null,
    cccd varchar(13) not null unique,
    sdt varchar(15) not null,
    email varchar(255),
    teNBo varchar(255),
    tenMe varchar(255),
    sdtPhuHuynh varchar(15) not null,
    idLopHanhChinh int not null,
    foreign key(idLopHanhChinh) references lopHanhChinh(id),
    primary key(id)
);

create table deThi(
	id int auto_increment,
    idMonHoc int,
    title varchar(255),
    primary key(id),
    foreign key(idMonHoc) references monhoc(id)
);

create table cauHoiTrongDe(
	idDeThi int not null,
    idCauHoi int not null,
    foreign key(idDeThi) references dethi(id),
    foreign key(idCauHoi) references tracNghiem(id),
    unique(idDeThi, idCauHoi)
);

insert into monHoc(tenMonHoc) values('Toán');insert into monHoc(tenMonHoc) values('Lý');insert into monHoc(tenMonHoc) values('Hóa');insert into monHoc(tenMonHoc) values('Sinh');insert into monHoc(tenMonHoc) values('Anh');insert into monHoc(tenMonHoc) values('Văn');insert into monHoc(tenMonHoc) values('Sử');insert into monHoc(tenMonHoc) values('Địa');
insert into giaoVien(ho, ten, ngaySinh, gioiTinh, cccd, sdt, email, diaChi, chucVu, luong)
values ('Lê','Thị Hoài','1977-03-21','Nữ','06001113','0987142124','ltHoai@gmail.com','Yên Bái', 'Giáo Viên', 7500000);
insert into giaoVien(ho, ten, ngaySinh, gioiTinh, cccd, sdt, email, diaChi, chucVu, luong)
values ('Nguyễn','Trung Nghĩa','1981-08-11','Nam','06003313','0987192124','ntnghia@gmail.com','Yên Bái', 'Giáo Viên', 6500000);
insert into giaoVien(ho, ten, ngaySinh, gioiTinh, cccd, sdt, email, diaChi, chucVu, luong)
values ('Lê','Thị Hồi','1969-02-13','Nữ','06013313','0987192524','lthoi@gmail.com','Yên Bái', 'Hiệu Trưởng', 1150000);

insert into lopBoMon(idMonHoc, idGVPT) values(1, 2);

insert into lopHanhChinh(tenLop, idGVCN) values ('Lý K28',1);
insert into lopHanhChinh(tenLop, idGVCN) values ('Toán Tin K28',2);

insert into hocSinh(idLopHanhChinh,ho, ten, ngaySinh, gioiTinh, cccd, sdt, email, teNBo, tenMe, sdtPhuHuynh)
values (1,'Nguyễn', 'Thành Công', '2002-03-10', 'Nam', '061159311', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776');
insert into hocSinh(idLopHanhChinh,ho, ten, ngaySinh, gioiTinh, cccd, sdt, email, teNBo, tenMe, sdtPhuHuynh)
values (2,'Vũ', 'Bảo Phương', '2002-09-11', 'Nữ', '061159321', '0354976596', 'phuongvb@gmail.com', '', '', '0378366776');

insert into taikhoan(tendangnhap, matkhau, sdt, email, ten) 
values ('kong1032002', 10032002, 0354976596, 'kong1032002@gmail.com', 'nguyen thanh cong');

INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VD', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'TH', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Động vật nào sau đây có tim 2 ngăn?', 'NB',  'Ếch đồng.\n', 'Cá chép.', 'Mèo.', 'Thỏ.', 'B');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Phân tử nào sau đây được dùng làm khuôn cho quá trình dịch mã?\n', 'NB', 'ADN.\n', 'tARN.\n', 'mARN.\n', 'rARN.\n', 'C');
INSERT into tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Một loài thực vật, xét 2 cặp NST kí hiệu là D, d và E, e. Cơ thể có bộ NST nào sau đây là thể một?\n', 'NB', 'dEE.\n', 'DDdEe.\n', 'Ddeee.\n', 'DdEe.\n', 'A');
INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Dạng đột biến nào sau đây làm thay đổi trình tự phân bố các gen nhưng không làm thay đổi chiều dài của NST?\n', 'NB',  'Đảo đoạn NST.', 'Mất đoạn NST.	', 'Thêm 1 cặp nuclêôtit.\n', 'Mất 1 cặp nuclêôtit.\n', 'A');

insert into tuLuan(idMonHoc, deBai, doKho, goiY)
values (6, 'Cảm nghĩ về hình ảnh bà cụ Tứ', 'Vận dụng', '');

insert into dethi(idMonHoc, title)
values (4, 'Kiem tra Hoc Ky');
insert into dethi(idMonHoc, title)
values (4, 'Kiem Tra 15ph');

insert into cauhoitrongde(idDeThi, idCauHoi)
values (1,1);
insert into cauhoitrongde(idDeThi, idCauHoi)
values (1,2);
insert into cauhoitrongde(idDeThi, idCauHoi)
values (1,3);
insert into cauhoitrongde(idDeThi, idCauHoi)
values (1,4);
insert into cauhoitrongde(idDeThi, idCauHoi)
values (1,5);

select * from taikhoan;
select * from monhoc;
select monHoc.tenMonHoc,tracnghiem.* from tracnghiem, monhoc where monhoc.id = tracnghiem.idMonHoc and doKho = 'NB' and idMonHoc = 4 order by rand() limit 2 ;
select * from tuluan;
select * from hocsinh;
select * from giaovien;
select lopbomon.* from lopBoMon;
select dethi.id , dethi.title, tracnghiem.* from dethi, tracnghiem, cauhoitrongde where cauhoitrongde.idCauHoi = tracnghiem.id and cauhoitrongde.idDeThi = dethi.id;
select * from tracnghiem where idMonHoc = 4 and doKho = 'NB' order by rand() limit 2;