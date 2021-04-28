CREATE DATABASE QLKHACHSAN
create table phong(
	IDphong int not null primary key,
	loaiphong varchar(64),
	tinhtrang varchar(30),
	gia money
)

create table khach(
	cmnd varchar(64) not null primary key,
	ten varchar(64),
	gioitinh varchar(64),
	ngaysinh date
)

create table nhanvien(
	idnhanvien int not null primary key, 
	mk varchar (40),
	ten varchar(64),
	gioitinh varchar(64),
	ngaysinh date,
	ngayvaolam date,
)

--thêm 1 nhân viên để tes
insert into nhanvien values(1,'nghiameow','NguyenCop','nam','1111-1-1','1111-1-1')

create table admin(
	tkadmin varchar(20)not null primary key,
	mkadmin varchar(20)
)
--thêm 1 admin
insert into admin values('nguyencop','nghiameow')

create table khach_datphong(
	iddatphong int not null primary key,
	idphong varchar(64) not null ,
	idkhach varchar(64) not null,
	idnhanvien int not null,
	ngaydat date,
	ngaytra date,
	gia money,
	datra money,
	phuongthucthanhtoan varchar(64)
)



--set tinh trang phong 
create procedure setTinhtrang
	@idphong int
as
begin
declare @today date=cast(getdate() as date)
declare @sophong varchar(20)=cast(@idphong as varchar(20))
	if not exists (select *
						from khach_datphong
						where @today>=ngaydat and @today<=ngaytra and @sophong in (select * from [dbo].[SplitStringToTable](idphong,',')))
	begin
	update phong set tinhtrang='Trong' where IDphong=@idphong	
	end
	else
	begin
	update phong set tinhtrang='Da thue' where IDphong=@idphong
	end
end

drop procedure setTinhtrang 


create procedure datphong
	@idphong varchar(64),
	@idkhach varchar(64),
	@idnhanvien int,
	@ngaydat date,
	@ngaytra date,
	@gia money,
	@datra money,
	@phuongthucthanhtoan varchar(64)
as
begin
declare @maxid int=(select max(iddatphong) from khach_datphong)
	if(@maxid is null) set @maxid=0
	if(@ngaydat<=@ngaytra)
	insert into khach_datphong values(@maxid+1,@idphong,@idkhach,@idnhanvien,@ngaydat,@ngaytra,@gia,@datra,@phuongthucthanhtoan)
end

--ngày trống trong khoảng thời gian từ ngaydat đến ngaytra
create function fn_roomsInTime(@ngaydat date,@ngaytra date)
returns table
as
return (select idphong,loaiphong,gia 
from phong p
where not exists (select *
from khach_datphong k
where ((@ngaydat<=ngaydat and @ngaytra>=ngaytra) or 
(@ngaydat<=ngaydat and @ngaytra<=ngaytra and @ngaytra>=ngaydat) or 
(@ngaydat>=ngaydat and @ngaytra<=ngaytra) or 
(@ngaydat>=ngaydat and @ngaytra>=ngaytra and @ngaydat<=ngaytra)) and
cast(p.IDphong as varchar(64)) in (select * from [dbo].[SplitStringToTable](k.idphong,','))
)
)

--hàm cắt chuỗi lấy trên mạng
CREATE FUNCTION [dbo].[SplitStringToTable]
(
    @string VARCHAR(MAX),
    @delimiter CHAR(1)
)
RETURNS @output TABLE(
    data VARCHAR(MAX)
)
BEGIN
    DECLARE @start INT, @end INT
    SELECT @start = 1, @end = CHARINDEX(@delimiter, @string)

    WHILE @start < LEN(@string) + 1 BEGIN
        IF @end = 0 
            SET @end = LEN(@string) + 1

        INSERT INTO @output (data) 
        VALUES(SUBSTRING(@string, @start, @end - @start))
        SET @start = @end + 1
        SET @end = CHARINDEX(@delimiter, @string, @start)
    END
    RETURN
END

