create database QLKhachsan
use QlKhachsan

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
	ten varchar(64),
	gioitinh varchar(64),
	ngaysinh smalldatetime,
)
--thêm cột ngayvaolam vào bảng nhanvien
alter table nhanvien add ngayvaolam smalldatetime
--thêm 1 nhân viên để test
insert into nhanvien values(1,'test','nam',1/1/1111,1/1/1111)

create table khach_datphong(
	idphong int not null ,
	idkhach int not null,
	idnhanvien int not null,
	ngaydat smalldatetime,
	ngaytra smalldatetime,
)
alter table khach_datphong add constraint PK_khach_datphong primary key (idphong,idkhach,idnhanvien)
alter table khach_datphong add constraint FK_khach_datphong foreign key (idphong) references phong(idphong)
alter table khach_datphong add constraint FK_khach_datphong1 foreign key (idkhach) references khach(idkhach)
alter table khach_datphong add constraint FK_khach_datphong2 foreign key (idnhanvien) references nhanvien(idnhanvien)

create table doanhthungay(
	iddoanhthungay int not null primary key,
	ngay smalldatetime not null,
	doanhthu money
)

create table khach_tratien(
	iddoanhthungay int not null,
	idkhach int not null,
	idphong int not null,
	sotientra money,
	sotienno money
)
alter table khach_tratien add constraint PK_khach_tratien primary key (iddoanhthungay,idkhach,idphong)
alter table khach_tratien add constraint FK_khach_tratien foreign key (iddoanhthungay) references doanhthungay(iddoanhthungay)
alter table khach_tratien add constraint FK_khach_tratien1 foreign key (idphong) references phong(idphong)
alter table khach_tratien add constraint FK_khach_tratien2 foreign key (idkhach) references khach(idkhach)

select * from phong