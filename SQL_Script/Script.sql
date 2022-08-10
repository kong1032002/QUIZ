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
    deBai varchar(1000) not null,
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


insert into monHoc(tenMonHoc) values('Toán'),('Lý'),('Hóa'),('Sinh'),('Anh'),('Văn'),('Sử'),('Địa'),('Tin');

insert into giaoVien(ho, ten, ngaySinh, gioiTinh, cccd, sdt, email, diaChi, chucVu, luong) values 
('Lê','Thị Hoài','1977-03-21','Nữ','06901113','0987112124','ltHoai@gmail.com','Yên Bái', 'Giáo Viên', 7500000), 
('Nguyễn','Trung Nghĩa','1981-08-11','Nam','06003313','0987192124','ntnghia@gmail.com','Yên Bái', 'Giáo Viên', 6500000), 
('Nguyễn','Văn Đối','1973-10-30','Nam','06003613','0983155381','nvdoi@gmail.com','Yên Bái', 'Giáo Viên', 6500000), 
('Phạm','Trung Nghĩa','1983-08-11','Nam','06010313','0987192134','ptnghia@gmail.com','Yên Bái', 'Giáo Viên', 6500000), 
('Nguyễn','Văn Phương','1982-08-11','Nam','06073613','0987192424','pvphuong@gmail.com','Yên Bái', 'Giáo Viên', 6500000), 
('Nguyễn','Thị Thủy','1980-08-11','Nữ','07003313','0987192126','ntthuy@gmail.com','Yên Bái', 'Giáo Viên', 6500000), 
('Nguyễn','Thanh Hoa','1988-08-11','Nữ','06003513','0987192164','nthoa@gmail.com','Yên Bái', 'Giáo Viên', 6500000), 
('Nguyễn','Thị Thanh Tâm','1979-08-11','Nữ','06003318','0987792124','nttam@gmail.com','Yên Bái', 'Giáo Viên', 6500000), 
('Lê','Thị Hồi','1969-02-13','Nữ','06013313','0187192524','lthoi@gmail.com','Yên Bái', 'Hiệu Trưởng', 1150000);

insert into lopBoMon(idMonHoc, idGVPT) values(1, 2);

insert into lopHanhChinh(tenLop, idGVCN) values ('Lý K28',1), ('Toán Tin K28',2);

insert into hocSinh(idLopHanhChinh,ho, ten, ngaySinh, gioiTinh, cccd, sdt, email, teNBo, tenMe, sdtPhuHuynh) values 
(1,'Nguyễn', 'Thành Công', '2002-03-10', 'Nam', '06159311', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Đỗ', 'Việt Trung', '2002-03-10', 'Nam', '06115911', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Phạm', 'Trường An', '2002-03-10', 'Nam', '06115311', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Nguyễn Phan', 'Thanh Thủy', '2002-03-10', 'Nam', '011159311', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Bùi Phùng', 'Lê Lương', '2002-03-10', 'Nam', '6515939991', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Bùi', 'Mạnh Cường', '2002-03-10', 'Nam', '06115431', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Bùi', 'Xuân Lộc', '2002-02-26', 'Nam', '061159321', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Đặng', 'Xuân Lộc', '2002-06-10', 'Nam', '061159511', '0354976596', 'ntk10302@gmail.com', 'Doi', 'Hinh', '0378306776'),
(1,'Vũ', 'Bảo Phương', '2002-09-11', 'Nữ', '061159361', '0354976596', 'phuongvb@gmail.com', '', '', '0378366776');

insert into taikhoan(tendangnhap, matkhau, sdt, email, ten) 
values ('kong1032002', 10032002, 0354976596, 'kong1032002@gmail.com', 'nguyen thanh cong');

insert into tuLuan(idMonHoc, deBai, doKho, goiY)
values (6, 'Cảm nghĩ về hình ảnh bà cụ Tứ', 'Vận dụng', '');

insert into dethi(idMonHoc, title)
values (4, 'Kiem tra Hoc Ky'), (4, 'Kiem Tra 15ph');

INSERT INTO tracnghiem (idMonHoc, `doKho`, `deBai`, `A`, `B`, `C`, `D`, `DapAn`) 
values (9,'NB','Hệ thống các chương trình đảm nhận chức năng làm môi trường trung gian giữa người sử dụng và  phần cứng của máy tính được gọi là?','Phần cứng','Hệ điều hành','Các loại trình dịch trung gian','Tất cả đều đúng','B'),
(9,'NB','Kết quả của biểu thức 2*3+4/2 > 3 && 3<5 || 10<9 sẽ bằng?','0','1','Không có kết quả nào ở trên','Biểu thức viết sai, không tính được kết quả','B'),
(9,'TH','Cho các số nguyên không dấu A = FA(16), B = 153(8), C = 200(10)\nHãy sắp xếp A, B, C theo thứ tự tăng dần','A, B, C','B, C, A','A, C, B','B, A, C','B'),
(9,'VD','Điền dòng lệnh thích hợp vào dấu (…) trong đoạn chương trình sau để thực hiện thao tác kiểm tra xem người dùng đã nhập đúng giá trị là số nguyên dương nhỏ hơn 10 hay chưa, nếu chưa yêu cầu nhập cho đến khi nào đúng thì thôi.\nvoid main(){\n	int n;\n	do{\n	printf(“Nhap vao mot so nguyen duong nho hon 10”);\n	scanf(“%d”,&n);\n	}….;\n}','while (n<10)','while (n<10 & n>=0)','while (n<=0 || n>=10)','while (n>=0 || n<=10)','B'),
(9,'VD','Giá trị số nhị phân 110101010 khi chuyển sang hệ thập lục phân (hệ cơ số đếm 16) sẽ bằng?','1AA','D50','FAA','D5A','A'),
(9,'VDC','Cách biểu diễn số âm trong máy tính là?','Thêm dấu – vào trước giá trị nhị phân dương tương ứng','Đảo các bit của giá trị nhị phân dương tương ứng','Sử dụng mã bù 2','Sử dụng mã bù 10','A'),
(9,'TH','Hãy cho biết sau đoạn lệnh sau biến a nhận giá trị bằng bao nhiêu?\nint a,b,c;\nb=10;c=20;\na=b>c?100:200;','a = 0','a = -1','a = 100','a = 200','D'),
(9,'TH','Hãy cho biết sau khi chạy xong đoạn chương trình sau kết quả ta thu được mảng a như thế nào?\nvoid main(){ \nint a[10];\nint temp;\nint i;\n	for(i=0;i<10;i++){\n	  printf(“Nhap gia tri cho so  a[%d]”,i);\n	scanf(“%d”,&a[i]);\n	}\n	temp=a[0];\n	for(i=1;i<10;i++)\n	     if(a[i] > temp) temp =a[i];\n	 a[0]=temp;\n       }','Phần tử đầu tiên của mảng a được thay bằng phần tử nhỏ nhất trong mảng','Mảng a sắp xếp theo thứ tự tăng dần','Mảng a sắp xếp theo thứ tự giảm dần Phần tử đầu tiên của mảng a được tha','Phần tử đầu tiên của mảng a được thay bằng phần tử lớn nhất trong mảng','D'),
(9,'TH','Các thao tác xử lý của máy tính gồm (a) Nhận lệnh tiếp theo, (b) Nhận dữ liệu nếu cần, (c) Giải mã lệnh, (d) Thực hiện lệnh. Trình tự thực hiện hợp lý là?','a, b, c, d','a, c, b, d','c, b, d, a','d, b, a, c','B'),
(9,'TH','Sau khi thực hiện các câu lệnh sau một cách tuần tự\nint a=5,c=2;\nfloat b=11;\nint d=3;\nd= (int)b++/c%5;\nGiá trị của biến d sẽ là :','0','1','6','5','D'),
(9,'NB','Với khai báo biến M sau\nint M[4][5] = { 10, 2, -3, 17, 82, 9, 0, 5, 8, -7, 32, 20, 1, 0, 14, 0, 0, 8, 7, 6 };\ngiá trị của M[1][2] là','0','5','8','2','B'),
(9,'NB','Chức năng chính của tập các thanh ghi là?','Điều khiển nhận lệnh','Vận chuyển thông tin giữa các thành phần trong máy tính','Chứa các thông tin phục vụ cho hoạt động của CPU','Không có câu trả lời nào ở trên là đúng','C'),
(9,'NB','Lệnh đúng để in 2 biến số thực x, y ra màn hình theo quy cách sau\nDòng 1 :  In giá trị x, căn lề trái, chiếm 10 vị trí trong đó có 2 vị trí cho phần thập phân\nDòng 2 : In giá trị y, căn lề phải, chiếm 6 vị trí trong đó có 3 vị trí cho phần thập phân','printf(“%-10.2f \\n%6.3f”,x,y);','printf(“%-10.3f \\n%6.4f”,x,y);','printf(“%10.2f ”,x) ; printf(“%-6.3f ”,y) ;','printf(“%10.2f ”,x) ; printf(“\\n%-6.3f ”,y) ;','A'),
(9,'NB','Cho biết kết quả trên màn hình của lệnh sau  (Với □ là ký tự space):\nprintf(\"%5.2f \", 3.454) ;','3.4','3.45','3.454','3.5','B'),
(9,'NB','Trong các khai báo sau, khai báo nào không có lỗi?','#define MAX=10','#define MAX 10','#define MAX 10;','const int MAX 10;','B'),
(9,'NB','Khẳng định nào sau đây về mạng máy tính là đúng','Mạng máy tính là tập hợp các thiết bị tính toán được nối với nhau','Các thiết bị kết nối với nhau trong mạng để chia sẻ thông tin','Các máy tính trong mạng được kết nối với nhau thông qua dây, sóng radio hoặc hồng nngoại','Tất cả các khẳng định trên','D'),
(9,'NB','Giá trị của biến m sau khi thực hiện đoạn chương trình sau là?\nfloat A[4]={1.1,1.2,1.3,1.4};\nint i; float m=0; \nfor(i=0;i<=2;i++) \n      if(m<A[i]) m=A[i];','0','1.1','1.3','1.4','C'),
(9,'NB','Câu 19. Cần nhập vào từ bàn phím n số nguyên với n cũng được nhập từ bàn phím. Khai báo nào đúng nhất cho mảng A  để lưu trữ n số nguyên này','int A[n];','int A[100];','int A[int n];','int A[]={1,2,3};','B'),
(9,'VDC','Dòng lệnh khai báo nào sau đây là đúng với cú pháp khai báo nguyên mẫu hàm trong C của hàm tìm giá trị lớn nhất trong 3 số a,b,c','function max(int a, int b, int c);','int max(int a, int b, int c);','max(int a, int b, int c);','max()','B'),
(9,'VDC','Hãy cho biết kết quả sau khi chạy đoạn chương trình sau\nvoid main(){\n		char *s1, *s2;\n		s1 = “Xin chao ”;\n		s2 = “cac ban”;\n		s1 = strcat(s1,s2);\n		printf(“%s”,s1);\n}','Xin chao','cac ban','chao cac ban','Xin chao cac ban','D'),
(9,'VDC','Hãy cho biết sau khi thực hiện đoạn chương trình sau kết quả thu được là như thế nào?\nvoid main(){			int  i;\n	char  temp;		\n	char s[20] = “Xin chao ban than”;	\n	for(i=0;i<8;i++){				\n		temp =s[i];				\n		s[i] = s[i+9];\n		s[i+9] = temp;\n	}\n	printf(“%s”,s);\n}','Xin chao ban than','chao ban than Xin','ban than Xin chao','than Xin chao ban','C'),
(9,'VDC','Trong các thiết bị sau, thiết bị nào là thiết bị ra?','Con chuột','Bàn phím','Máy quét','Máy chiếu','D'),
(9,'VDC','Sau khi thực hiện các câu lệnh sau một cách tuần tự\nint a=5,c=2;\nfloat b=11;\nint d=3;\nd= (int)b/c%5;\ngiá trị của biến d sẽ bằng?','5','3','0','1','C'),
(9,'VD','Một số nguyên có dấu biểu diễn dưới dạng số nhị phân 8 bit là 01010101. Giá trị của số đó là?','1100.1011','1100.01011','1010.1011','1010.1011','A'),
(9,'VD','Sau khi thực hiện các lệnh sau một cách tuần tự\nint i;\nchar str[] = {\"helloworld!\"};\nchar words[10];    	\nfor(i=0;i<strlen(str)/2;i++)    	       \nwords[i]=str[i+1];\nwords[i-1]=\'\\0\';   		\nprintf(\"%s\\n\",words);\nNội dung màn hình sẽ là?','ellow','hello','ello','hhell','A'),
(9,'VD','hello everyone','hi','nice to meet you','5','66','C');

INSERT INTO tracnghiem (idMonHoc, `DeBai`, `DoKho`, `A`, `B`, `C`, `D`, `DapAn`) VALUES 
('4', 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D'),
('4', 'Động vật nào sau đây có tim 2 ngăn?', 'NB', 'Ếch đồng.\n', 'Cá chép.', 'Mèo.', 'Thỏ.', 'B'),
('4', 'Phân tử nào sau đây được dùng làm khuôn cho quá trình dịch mã?\n', 'NB', 'ADN.\n', 'tARN.\n', 'mARN.\n', 'rARN.\n', 'C'),
('4', 'Một loài thực vật, xét 2 cặp NST kí hiệu là D, d và E, e. Cơ thể có bộ NST nào sau đây là thể một?\n', 'NB', 'dEE.\n', 'DDdEe.\n', 'Ddeee.\n', 'DdEe.\n', 'A'),
('4', 'Dạng đột biến nào sau đây làm thay đổi trình tự phân bố các gen nhưng không làm thay đổi chiều dài của NST?\n', 'NB', 'Đảo đoạn NST.', 'Mất đoạn NST.	', 'Thêm 1 cặp nuclêôtit.\n', 'Mất 1 cặp nuclêôtit.\n', 'A'),
('4', 'Ở tế bào động vật, bào quan nào sau đây chứa gen di truyền theo dòng mẹ?\n', 'NB', 'Ti thể.\n', 'Ribôxôm.\n', 'Không bào.\n', 'Lưới nội chất.\n', 'A'),
('4', 'Cho biết alen B quy định thân cao trội hoàn toàn so với alen b quy định thân thấp. Theo lí thuyết, phép lai nào sau đây cho đời con có tỉ lệ kiểu hình 3 : 1?', 'NB', 'Bb  Bb.\n', 'Bb  bb.\n', 'BB  Bb.\n', 'BB  bb.\n', 'A'),
('4', 'Cơ thể có kiểu gen nào sau đây gọi là thể dị hợp 2 cặp gen?\n', 'NB', 'aaBb.\n', 'AaBb.\n', 'Aabb.\n', 'AAbb.', 'B'),
('4', 'Một loài thực vật có 12 nhóm gen liên kết. Theo lí thuyết, bộ NST lưỡng bội của loài này là\n', 'NB', '2n = 12.\n', '2n = 24.\n', '2n = 36.\n', '2n = 6.', 'B'),
('4', 'Theo lí thuyết, quá trình giảm phân ở cơ thể có kiểu gen nào sau đây tạo ra giao tử ab?\n', 'NB', 'AaBB.\n', 'Aabb.\n', 'AAbb.\n', 'aaBB.', 'B'),
('4', 'Một quần thể thực vật gồm 400 cây có kiểu gen AA, 400 cây có kiểu gen Aa và 200 cây có kiểu gen aa. Tần số kiểu gen Aa của quần thể này là', 'NB', '0,4.\n', '0,5.\n', '0,6.\n', '0,2.\n', 'A'),
('4', 'Từ cây có kiểu gen aaBbDD, bằng phương pháp nuôi cấy hạt phấn trong ống nghiệm có thể tạo ra dòng cây đơn bội có kiểu gen nào sau đây?\n', 'NB', 'aBD.\n', 'aBd.\n', 'Abd.\n', 'ABD.\n', 'A'),
('4', 'Theo thuyết tiến hóa hiện đại, nhân tố nào sau đây có thể tạo ra các alen mới cho quần thể?\n', 'NB', 'Chọn lọc tự nhiên.\n', 'Giao phối không ngẫu nhiên.\n', 'Các yếu tố ngẫu nhiên.\n', 'Đột biến.\n', 'D');


INSERT INTO tracnghiem (idMonHoc, `deBai`, `doKho`, `A`, `B`, `C`, `D`, `DapAn`) 
VALUES (4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'NB', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D'),
(4, 'Rễ cây có thể hấp thụ nitơ ở dạng nào sau đây?', 'VDC', 'N2.', 'N2O.', 'NO.', 'NH4+.', 'D'),
(4, 'Động vật nào sau đây có tim 2 ngăn?', 'NB',  'Ếch đồng.\n', 'Cá chép.', 'Mèo.', 'Thỏ.', 'B'),
(4, 'Phân tử nào sau đây được dùng làm khuôn cho quá trình dịch mã?\n', 'NB', 'ADN.\n', 'tARN.\n', 'mARN.\n', 'rARN.\n', 'C'),
(4, 'Một loài thực vật, xét 2 cặp NST kí hiệu là D, d và E, e. Cơ thể có bộ NST nào sau đây là thể một?\n', 'NB', 'dEE.\n', 'DDdEe.\n', 'Ddeee.\n', 'DdEe.\n', 'A'),
(4, 'Dạng đột biến nào sau đây làm thay đổi trình tự phân bố các gen nhưng không làm thay đổi chiều dài của NST?\n', 'NB',  'Đảo đoạn NST.', 'Mất đoạn NST.	', 'Thêm 1 cặp nuclêôtit.\n', 'Mất 1 cặp nuclêôtit.\n', 'A');

insert into cauhoitrongde(idDeThi, idCauHoi)
values (1,1),(1,2),(1,3),(1,4),(1,5);


select * from cauhoitrongde;
select * from dethi;
select * from giaoVien;
select * from hocSinh;
select * from lopBoMon;
select * from lopHanhChinh;
select * from MonHoc;
select * from taiKhoan;
select * from thoiGianhoc;
select * from tracNghiem;
select * from tuLuan;