CREATE DATABASE QLKHACHSAN
create table phong(
	IDphong int not null primary key,
	loaiphong varchar(64),
	tinhtrang varchar(30),
	gia money
)
drop table phong
create table khach(
	cmnd varchar(64) not null primary key,
	ten varchar(64),
	gioitinh varchar(64),
	ngaysinh date
)
select * from khach
drop table khach
create table nhanvien(
	idnhanvien int not null primary key, 
	mk varchar (40),
	ten varchar(64),
	gioitinh varchar(64),
	ngaysinh date,
	ngayvaolam date,
)
drop table nhanvien
--thêm 1 nhân viên để tes
insert into nhanvien values(1,'nghiameow','NguyenCop','nam','1111-1-1','1111-1-1')
select * from nhanvien
create table admin(
	tkadmin varchar(20)not null primary key,
	mkadmin varchar(20)
)
drop table admin
--thêm 1 admin
insert into admin values('nguyencop','nghiameow')
--CÓ SỬA Ở ĐÂY!!!!!!!! (2/5/2021)
create table khach_datphong(
	iddatphong int not null primary key,
	idphong varchar(64) not null ,
	idkhach varchar(64) not null,
	idnhanvien int not null,
	ngaydat date,
	ngaynhan date,
	ngaytra date,
	gia money,
	tralan1 money,
	tralan2 money,
	phuongthucthanhtoan varchar(64)
)
drop table khach_datphong


drop procedure setTinhtrang
--CÓ SỬA Ở ĐÂY!!!!!!!! (2/5/2021)
--set tinh trang phong 
create procedure setTinhtrang
	@idphong int
as
begin
declare @today date=cast(getdate() as date)
declare @sophong varchar(20)=cast(@idphong as varchar(20))
	if not exists (select *
						from khach_datphong
						where @today>=ngaydat and @today<=ngaytra and @sophong in (select * from [dbo].[SplitStringToTable](idphong,','))and (tralan1+tralan2) < gia)
	begin
	update phong set tinhtrang='Trong' where IDphong=@idphong	
	end
	else
	begin
	update phong set tinhtrang='Da thue' where IDphong=@idphong
	end
end

drop procedure datphong
--CÓ SỬA Ở ĐÂY!!!!!!!! (2/5/2021)
create procedure datphong
	@idphong varchar(64),
	@idkhach varchar(64),
	@idnhanvien int,
	@ngaydat date,
	@ngaynhan date,
	@ngaytra date,
	@gia money,
	@tralan1 money,
	@phuongthucthanhtoan varchar(64)	
as
begin
declare @tralan2 money=0
declare @maxid int=(select max(iddatphong) from khach_datphong)
	if(@maxid is null) set @maxid=0
	if(@ngaydat<=@ngaytra)
	insert into khach_datphong values(@maxid+1,@idphong,@idkhach,@idnhanvien,@ngaydat,@ngaynhan,@ngaytra,@gia,@tralan1,@tralan2,@phuongthucthanhtoan)
end
drop function fn_roomsInTime
--CÓ SỬA Ở ĐÂY!!!!!!!! (2/5/2021)
--ngày trống trong khoảng thời gian từ ngaydat đến ngaytra
create function fn_roomsInTime(@ngaynhan date,@ngaytra date)
returns table
as
return (select idphong,loaiphong,gia 
from phong p
where not exists (select *
from khach_datphong k
where ((@ngaynhan<=ngaynhan and @ngaytra>=ngaytra) or 
(@ngaynhan<=ngaynhan and @ngaytra<=ngaytra and @ngaytra>ngaynhan) or 
(@ngaynhan>=ngaynhan and @ngaytra<=ngaytra) or 
(@ngaynhan>=ngaynhan and @ngaytra>=ngaytra and @ngaynhan<ngaytra)) and
cast(p.IDphong as varchar(64)) in (select * from [dbo].[SplitStringToTable](k.idphong,','))
and k.gia>(k.tralan1+k.tralan2)
)
)
drop function dbo.fn_roomsInTime
drop function [dbo].[SplitStringToTable]
--CÓ SỬA Ở ĐÂY!!!!!!!! (2/5/2021)
--HÀM TRẢ VỀ BẢNG DT
CREATE FUNCTION BANGDT
(
)
RETURNS @DOANHTHU TABLE(NGAY DATE, TIENMAT MONEY, MASTERCARD MONEY, DTNGAY MONEY)
BEGIN
	DECLARE @DAY DATE
	DECLARE @TM MONEY=0
	DECLARE @VISA MONEY=0
	DECLARE @DEM INT = 1
	DECLARE @COUNT INT=(SELECT COUNT(DISTINCT NGAYDAT) FROM KHACH_DATPHONG)
		WHILE @DEM <= @COUNT
		BEGIN
			SELECT  DISTINCT TOP(@DEM) @DAY= NGAYDAT FROM KHACH_DATPHONG ORDER BY NGAYDAT
			SELECT @TM=SUM(TRALAN1) FROM  KHACH_DATPHONG WHERE NGAYDAT=@DAY AND SUBSTRING(PHUONGTHUCTHANHTOAN,1,8)='TIEN MAT'
			SELECT @VISA=SUM(TRALAN1) FROM  KHACH_DATPHONG WHERE NGAYDAT=@DAY AND SUBSTRING(PHUONGTHUCTHANHTOAN,1,11)='MASTER CARD'	
			IF @TM IS NULL
				BEGIN
				SET @TM=0
				END
			IF @VISA IS NULL
				BEGIN
				SET @VISA=0
				END
			INSERT INTO @DOANHTHU  VALUES (@DAY,@TM,@VISA,@TM+@VISA)
			SET @DEM=@DEM+1
		END
	SET @DEM=1
	SET @COUNT=(SELECT COUNT(DISTINCT NGAYNHAN) FROM KHACH_DATPHONG)	
		WHILE @DEM <= @COUNT
		BEGIN
			SET @TM=0
			SET @VISA=0
			SELECT  DISTINCT TOP(@DEM) @DAY= NGAYNHAN FROM KHACH_DATPHONG ORDER BY NGAYNHAN
			SELECT @TM=SUM(TRALAN2) FROM  KHACH_DATPHONG 
				WHERE NGAYNHAN=@DAY AND SUBSTRING(PHUONGTHUCTHANHTOAN,CHARINDEX(',',PHUONGTHUCTHANHTOAN)+1,8)='TIEN MAT' 
			SELECT @VISA=SUM(TRALAN2) FROM  KHACH_DATPHONG
				WHERE NGAYNHAN=@DAY AND SUBSTRING(PHUONGTHUCTHANHTOAN,CHARINDEX(',',PHUONGTHUCTHANHTOAN)+1,11)='MASTER CARD'  
			IF @TM IS NULL
				BEGIN
				SET @TM=0
				END
			IF @VISA IS NULL
				BEGIN
				SET @VISA=0
				END
			IF NOT EXISTS (SELECT * FROM @DOANHTHU WHERE NGAY=@DAY) AND ( @TM <> 0 OR @VISA <> 0)
				BEGIN
				INSERT INTO @DOANHTHU  VALUES (@DAY,@TM,@VISA,@TM+@VISA)
				END
			ELSE
				BEGIN
				UPDATE @DOANHTHU SET TIENMAT=TIENMAT+@TM WHERE NGAY=@DAY
				UPDATE @DOANHTHU SET MASTERCARD=MASTERCARD+@VISA WHERE NGAY=@DAY
				UPDATE @DOANHTHU SET DTNGAY=TIENMAT+MASTERCARD WHERE NGAY=@DAY
				END
			SET @DEM=@DEM+1
		END
RETURN
END

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

DECLARE @TM MONEY=1000
SELECT @TM=DATRA FROM KHACH_DATPHONG WHERE NGAYTRA='2021-06-01'
PRINT @TM
SELECT SUBSTRING(PHUONGTHUCTHANHTOAN,1,7) FROM  KHACH_DATPHONG
SELECT * FROM  KHACH_DATPHONG WHERE NGAYTRA='2021-05-01' AND DATRA=GIA/2 and SUBSTRING(PHUONGTHUCTHANHTOAN,1,11)='TIEN MAT'
drop function dbo.BANGDT
select len('MASTER CARD')
SELECT * FROM DBO.BANGDT()
SELECT TOP(1) * FROM(SELECT DISTINCT NGAYDAT FROM KHACH_DATPHONG)
SELECT * FROM KHACH_DATPHONG
select * from phong
delete from  KHACH_DATPHONG where idkhach='1' and ngaydat='2021-05-04'
update phong set tinhtrang='Trong'
SELECT * FROM DBO.BANGDT()
SELECT DISTINCT TOP 2 NGAYDAT
FROM KHACH_DATPHONG ORDER BY NGAYDAT
SELECT SUBSTRING('LE TRUNG NGUYEN',LEN('LE TRUNG NGUYEN')+1,1)