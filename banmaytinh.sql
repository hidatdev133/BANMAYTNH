-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 19, 2022 lúc 02:32 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `banmaytinh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `userID` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `manhanvien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hotennhanvien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quyen` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`userID`, `username`, `password`, `manhanvien`, `hotennhanvien`, `gioitinh`, `diachi`, `quyen`) VALUES
('admin', 'admin', 'admin', '', '', 'nam', 'Long An', 'admin'),
('user01', 'nv01', 'NV01', 'NV01', 'Phạm Quốc Đạt', 'Nam', 'Long AN', 'nhân viên'),
('user02', 'nv02', 'NV02', 'NV02', 'Võ Anh Hào', 'Nam', 'Củ Chi', 'nhân viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dathang`
--

CREATE TABLE `dathang` (
  `madathang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `mahoadon` int(11) NOT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `dathang`
--

INSERT INTO `dathang` (`madathang`, `masanpham`, `mahoadon`, `soluong`) VALUES
(39, 1, 2, 2),
(40, 2, 4, 2),
(41, 2, 4, 2),
(42, 2, 4, 2),
(43, 2, 4, 2),
(45, 1, 4, 3),
(46, 2, 4, 2),
(47, 3, 4, 2),
(48, 2, 4, 2),
(49, 1, 4, 2),
(50, 2, 4, 4),
(51, 1, 1, 4),
(52, 3, 4, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `mahoadon` int(11) NOT NULL,
  `makhachhang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tenkhachhang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `soluong` int(255) NOT NULL,
  `tensanpham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `giasanpham` int(255) NOT NULL,
  `thanhtien` int(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`mahoadon`, `makhachhang`, `tenkhachhang`, `soluong`, `tensanpham`, `giasanpham`, `thanhtien`, `trangthai`) VALUES
(1, 'KH01', 'Nguyễn Văn A', 0, '', 0, 0, 0),
(2, 'KH02', 'Nguyễn Thị B', 0, '', 0, 0, 0),
(3, 'KH03', 'Phạm Văn C', 0, '', 0, 0, 0),
(4, 'KH04', 'Vũ Văn D', 0, '', 0, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `makhachhang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tenkhachhang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `trangthai` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`makhachhang`, `tenkhachhang`, `gioitinh`, `diachi`, `sdt`, `trangthai`) VALUES
('KH01', 'Nguyễn Văn A', 'Nam', 'Hồ Chí Minh', '0123456789', 0),
('KH02', 'Nguyễn Thị B', 'Nữ', 'Hà Nội', '0987654321', 1),
('KH03', 'Phạm Văn C', 'Nam', 'Lâm Đồng', '0123456789', 0),
('KH04', 'Vũ Văn D', 'Nam', 'Lâm Đồng', '0123456789', 1),
('KH05', 'Vũ Văn D', 'Nam', 'Lâm Đồng', '0123456789', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `manhacungcap` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tennhacungcap` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`manhacungcap`, `tennhacungcap`, `diachi`, `sdt`) VALUES
('NCC01', 'ACER', 'HỒ CHÍ MINH', '0123456789'),
('NCC02', 'DELL', 'ĐÀ NẴNG', '012345665'),
('NCC03', 'ASUS', 'HÀ NỘI', '0987654321'),
('NCC04', 'HP', 'HẢI PHÒNG', '01239456753'),
('NCC05', 'LOGITECH', 'HỒ CHÍ MINH', '033245678'),
('NCC06', 'LENOVO', 'HÀ NỘI', '0987652323'),
('NCC07', 'DARE', 'ĐÀ LẠT', '0663212434'),
('NCC08', 'GIGABYTE', 'HỒ CHÍ MINH', '0862001643'),
('NCC09', 'CORSAIR', 'HẢI PHÒNG', '0123456789'),
('NCC10', 'MSI', 'HỒ CHÍ MINH', '0123456789'),
('NCC11', 'ABC', 'HỒ CHÍ MINH', '0123456789');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manhanvien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hotennhanvien` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `namsinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manhanvien`, `hotennhanvien`, `gioitinh`, `namsinh`, `diachi`, `sdt`) VALUES
('NV01', 'Phạm Quốc Đạt', 'Nam', '2002', 'Long An', '0123456789'),
('NV02', 'Võ Anh Hào', 'Nam', '2002', 'Củ Chi', '0123456789'),
('NV03', 'Đinh Thị B', 'Nữ', '1999', 'Tiền Giang', '098654321'),
('NV04', 'Cao Thành C', 'Nam', '2001', 'Đồng Nai', '097125342'),
('NV05', 'Vũ Văn Đ', 'Nam', '2002', 'Lâm Đồng', '0847914186'),
('NV06', 'ABCD', 'Nam', '1998', 'Hà Nội', '0447744897'),
('NV07', 'ABC', 'Nam', '1997', 'Hà Nội', '0447744897'),
('NV08', 'ABC', 'Nam', '1997', 'Hà Nội', '0447744897');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `loaisanpham` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `giasanpham` double NOT NULL,
  `nhacungcap` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `thoigianbaohanh` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`masanpham`, `tensanpham`, `loaisanpham`, `giasanpham`, `nhacungcap`, `thoigianbaohanh`) VALUES
(1, 'Laptop Lenovo V330-14IKBR', 'Laptop', 13190000, 'NCC01', 12),
(2, 'Laptop Lenovo Ideapad ', 'Laptop', 11090000, 'NCC06', 12),
(3, 'Laptop Lenovo Ideapad S145', 'Laptop', 13090000, 'NCC07', 12);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`userID`);

--
-- Chỉ mục cho bảng `dathang`
--
ALTER TABLE `dathang`
  ADD PRIMARY KEY (`madathang`),
  ADD KEY `masanpham` (`masanpham`),
  ADD KEY `mahoadon` (`mahoadon`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahoadon`),
  ADD KEY `makhachhang` (`makhachhang`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makhachhang`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`manhacungcap`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manhanvien`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masanpham`),
  ADD KEY `nhacungcap` (`nhacungcap`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `dathang`
--
ALTER TABLE `dathang`
  MODIFY `madathang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `mahoadon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `dathang`
--
ALTER TABLE `dathang`
  ADD CONSTRAINT `dathang_ibfk_1` FOREIGN KEY (`masanpham`) REFERENCES `sanpham` (`masanpham`),
  ADD CONSTRAINT `dathang_ibfk_2` FOREIGN KEY (`mahoadon`) REFERENCES `hoadon` (`mahoadon`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`makhachhang`) REFERENCES `khachhang` (`makhachhang`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`nhacungcap`) REFERENCES `nhacungcap` (`manhacungcap`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
