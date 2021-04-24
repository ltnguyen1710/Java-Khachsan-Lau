CREATE DATABASE QLKHACHSAN
create table phong(
	IDphong int not null primary key,
	loaiphong varchar(64),
	tinhtrang varchar(30),
	gia money
)

create table khach(
	idkhach int not null primary key,
	cmnd varchar(64) not null ,
	ten varchar(64),
	gioitinh varchar(64),
	ngaysinh smalldatetime
)

create table nhanvien(
	idnhanvien int not null primary key, 
	mkstaff varchar (40),
	ten varchar(64),
	gioitinh varchar(64),
	ngaysinh smalldatetime,
	ngayvaolam smalldatetime,
)
--thêm 1 nhân viên để test
insert into nhanvien values(1,'nghiameow','NguyenCop','nam',1/1/1111,1/1/1111)

create table admin(
	tkadmin varchar(20)not null primary key,
	mkadmin varchar(20)
)
drop table nhanvien
--thêm 1 admin


create table khach_datphong(
	iddatphong int not null primary key,
	idphong int not null ,
	idkhach int not null,
	idnhanvien int not null,
	ngaydat smalldatetime,
	ngaytra smalldatetime,
	gia money,
	datra money
)
drop table khach_datphong





select * from phong