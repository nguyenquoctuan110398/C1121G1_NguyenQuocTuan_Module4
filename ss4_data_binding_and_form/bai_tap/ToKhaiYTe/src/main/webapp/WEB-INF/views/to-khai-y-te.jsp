<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 3/31/2022
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tờ Khai Y Tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container text-center">
    <div class="row">
        <h1>Tờ Khai Y Tế</h1>
        <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP Cơ QUAN Y TÉ LIÊN LẠC KHI CÀN THIẾT ĐỂ PHÒNG CHÓNG
            DỊCH BỆNH TRUYỀN NHIỄM</h3>
        <h5 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
            sự</h5>
        <h6 class="text-danger">${message}</h6>
    </div>
</div>
<form:form action="/toKhai" method="post" modelAttribute="toKhaiYTe">

    <label>Họ Tên</label><span class="text-danger">(*)</span>
    <form:input path="hoTen" type="text" class="form-control"/>

    <label>Năm Sinh</label><span class="text-danger">(*)</span>
    <form:input path="namSinh" type="text" class="form-control"/>

    <label>Giới tính</label><span class="text-danger">(*)</span>
    <form:select items="${gioiTinh}" path="gioiTinh" type="text" class="form-control"/>

    <label>Quôc tịch</label><span class="text-danger">(*)</span>
    <form:select path="quocTich" items="${quocTich}" type="text" class="form-control"/>

    <label>CMND</label><span class="text-danger">(*)</span>
    <form:input path="CMND" type="text" class="form-control"/>

    <label>Thông tin đi lại</label><span class="text-danger">(*)</span>
    <span> <form:radiobuttons path="tenPhuongTien" items="${phuongTien}"/>&nbsp </span><br>

    <label>Số hiệu phương tiện</label>
    <form:input path="soHieuPhuongTien" class="form-control"/>

    <label>Số ghế</label>
    <form:input path="soGhe" class="form-control"/>

    <label>Ngày khởi hành</label>
    <form:input type="date" path="ngayKhoiHanh" class="form-control"/>

    <label>Ngày kết thúc</label>
    <form:input type="date" path="ngayKetThuc" class="form-control"/>

    <label>14 ngày qua đã đi đâu ?</label><span
        class="text-danger">(*)</span>
    <form:textarea path="thongTinDiChuyen14Ngay" class="form-control"/>

    <p><b>Địa chỉ liên lạc</b></p>

    <label>Tỉnh / Thành</label><span class="text-danger">(*)</span>
    <form:select items="${tinhThanh}" path="tinhThanh" type="text" class="form-control"/>

    <label>Quận / Huyện</label><span class="text-danger">(*)</span>
    <form:select items="${quanHuyen}" path="quanHuyen" type="text" class="form-control"/>

    <label>Phường / Xã</label><span class="text-danger">(*)</span>
    <form:select items="${phuongXa}" path="phuongXa" type="text" class="form-control"/>

    <label>Địa chỉ nơi ở :</label>
    <form:input type="text" path="soNha" class="form-control"/>

    <label>Điện thoại :</label>
    <form:input type="text" path="dienThoai" class="form-control"/>

    <label>Email :</label>
    <form:input type="text" path="email" class="form-control"/>

    <p><b>các triệu chứng trong 14 ngày gần đây :</b></p>

    <table border="1" style="text-align: center">
        <thead>
        <tr>
            <th>Triệu chứng</th>
            <th>Có</th>
            <th>Không</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Sốt</td>
            <td><form:radiobutton path="sot" value="1"/></td>
            <td><form:radiobutton path="sot" value="0"/></td>
        </tr>
        <tr>
            <td>Ho</td>
            <td><form:radiobutton path="ho" value="1"/></td>
            <td><form:radiobutton path="ho" value="0"/></td>
        </tr>
        <tr>
            <td>Khó thở</td>
            <td><form:radiobutton path="khoTho" value="1"/></td>
            <td><form:radiobutton path="khoTho" value="0"/></td>
        </tr>
        <tr>
            <td>Đau họng</td>
            <td><form:radiobutton path="dauHong" value="1"/></td>
            <td><form:radiobutton path="dauHong" value="0"/></td>
        </tr>
        </tbody>
    </table>
    <br>
    <table border="1" style="text-align: center">
        <thead>
        <tr>
            <th>Triệu chứng</th>
            <th>Có</th>
            <th>Không</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Nôn</td>
            <td><form:radiobutton path="buonNon" value="1"/></td>
            <td><form:radiobutton path="buonNon" value="0"/></td>
        </tr>
        <tr>
            <td>Tiêu Chảy</td>
            <td><form:radiobutton path="tieuChay" value="1"/></td>
            <td><form:radiobutton path="tieuChay" value="0"/></td>
        </tr>
        <tr>
            <td>Xuất huyết</td>
            <td><form:radiobutton path="xuatHuyet" value="1"/></td>
            <td><form:radiobutton path="xuatHuyet" value="0"/></td>
        </tr>
        <tr>
            <td>Nổi ban</td>
            <td><form:radiobutton path="noiBan" value="1"/></td>
            <td><form:radiobutton path="noiBan" value="0"/></td>
        </tr>
        </tbody>
    </table>
    <br>

    <button class="btn btn-success mx-auto" type="submit" style="">Gửi</button>

</form:form>
</body>

</html>
