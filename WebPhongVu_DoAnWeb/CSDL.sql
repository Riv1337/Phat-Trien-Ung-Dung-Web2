CREATE DATABASE QLBH_QLDA_HTMmart
GO
USE QLBH_QLDA_HTMmart
GO


CREATE TABLE LoaiSP
(
MaLSP  VARCHAR(10) PRIMARY KEY,
TenLSP NVARCHAR(50) NOT NULL
)
GO
CREATE TABLE SanPham
(
MaSP VARCHAR(10) PRIMARY KEY,
TenSP NVARCHAR(50) NOT NULL,
AnhSP VARCHAR(50) NOT NULL,
DVT NVARCHAR(50) NOT NULL,
DonGia INT,
MoTaSP NVARCHAR(50),
MaSLP VARCHAR(10) REFERENCES LoaiSP(MaLSP)
)
GO
CREATE TABLE NhanVien
(
MaNV VARCHAR(10) PRIMARY KEY,
HoTen NVARCHAR(50) NOT NULL,
NgaySinh DATE,
Email VARCHAR(50) NOT NULL,
MatKhau VARCHAR(50) NOT NULL,
GioiTinh BIT DEFAULT(1),
Administrator BIT 
)
CREATE TABLE NhaCungCap
(
MaNCC VARCHAR(10) PRIMARY KEY,
TenNCC NVARCHAR(50) NOT NULL,
DiaChi NVARCHAR(50) NOT NULL,
SDT_NCC NVARCHAR(13) NOT NULL,
Email varchar(50) NOT NULL,
MLSP VARCHAR(10) REFERENCES LoaiSP(MaLSP)
)
GO
CREATE TABLE KhachHang
(
MaKH VARCHAR(10) PRIMARY KEY,
HoTen NVARCHAR(50) NOT NULL,
DiaChi NVARCHAR(50) NOT NULL,
NgaySinh DATE,
MatKhau VARCHAR(50) NOT NULL,
Email VARCHAR(50) NOT NULL,
)

GO
CREATE TABLE GioHang
(
SoHD VARCHAR(50) PRIMARY KEY,
MaNVD VARCHAR(10) REFERENCES NhanVien(MaNV),
MaNVG VARCHAR(10) REFERENCES NhanVien(MaNV), 
MaKH VARCHAR(10) REFERENCES KhachHang(MaKH), 
NgayDat smalldatetime,
NgayGiao smalldatetime,
TinhTrang INT DEFAULT(0),
)
GO
CREATE TABLE CTGH
(
DonGia INT,
MaSP VARCHAR(10) REFERENCES SanPham(MaSP),
SoHD VARCHAR(50) REFERENCES GioHang(SoHD),
SoLuong INT,
CONSTRAINT PK_CTGH PRIMARYKEY (MaSP,SoHD)
)

insert NhanVien VALUES('A001',N'Baly Richard Kim Hoàng',CAST(N'1995-11-23' AS Date),'richardbaly2001@gmail.com','password123',1,1)
insert LoaiSP VALUES('MAC01',N'Máy tính MAC')
insert LoaiSP VALUES ('TB01',N'Thiết bị máy tính')
insert LoaiSP VALUES ('MG01',N'Máy giặt')
insert into SanPham(MaSP,TenSP,AnhSP,DVT,DonGia,MoTaSP,MaSLP)
VALUES 
('MC001',N'Macbook 2023',N'macbook1.png','1',20000000,N'Máy tính cầm tay mới từ Apple','MAC01'),
('ASUS01',N'Màn hình ASUS',N'monitor.png','1',5600000,N'Màn hình ASUS BE279Q giá rẻ 144hz','TB01'),
('COMBO1',N'Combo 1',N'combo1.png','1',560000,N'Combo chuột+bàn phím','TB01'),
('HP01',N'Tai nghe ATH-M40X',N'headphones1.png','1',2680000,N' Audiotechnica với chất lượng nghe tốt','TB01'),
('MG023',N'Máy giặt 2023',N'maygiat2023.jpg','1',7600000,N'Máy giặt công nghệ mới 2023','MG01'),
('SP01',N'Loa Surround Sound',N'speaker1.png','1',8600300,N'Loa mới từ bose','TB01');
insert into NhaCungCap VALUES
('ADT01',N'AUDIOTECHNICA',N'Ohio',N'330-686-2600','audiotechnica@gmail.com','TB01'),
('ASUS01',N'ASUS COMPANY',N'New York',N'852-35824770','asus@gmail.com','TB01'),
('APP01',N'APPLE',N'Cupertino, California',N'0800-761-0880','apple@gmail.com','MAC01');



