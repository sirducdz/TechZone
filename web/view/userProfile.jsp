<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TECHZONE</title>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/userprofile.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
<scipt src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></scipt>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/home.css">
</head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
    <form action="EditCustomerController" method="post" enctype="multipart/form-data">
        <div class="container rounded bg-white mt-5 mb-5">
            <div class="row">
                <div class="col-md-4 border-right">  

                <c:if test="${user.getAvatar()!=null}">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img src="UserImage/${user.getAvatar()}" class="rounded-circle mt-5" width="150px"
                             alt="">
                        <label class="chosen" style="font-size: 20px;" >
                            <input type="file" name="avatar" class="d-flex flex-column align-items-center text-center p-3 py-5">
                        </label>           
                    </div>
                </c:if>
                <c:if test="${user.getAvatar()==null}">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="rounded-circle mt-5" width="150px"
                             alt="avatar">
                        <label class="chosen" style="font-size: 20px;" >
                            <input type="file" name="avatar" class="d-flex flex-column align-items-center text-center p-3 py-5">
                        </label>           
                    </div>
                </c:if>
            </div>
            <div class="col-md-8 border-right" >
                <div class="p-3 py-5" style="line-height:3.5;">

                    <div class="row mt-2">
                        <div class="col-md-12"><label class="labels" style="font-size: 20px;">Họ và tên</label><input type="text" class="form-control" style="font-size: 2rem;" placeholder="Nhập họ và tên" name="name" value="${user.getName()}"></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels" style="font-size: 20px;">Số điện thoại</label><input type="text" class="form-control" style="font-size: 2rem;"  placeholder="Nhập số điện thoại" name="phone_number" value="${user.getPhone_number()}"></div>
                        <div class="col-md-12"><label class="labels"style="font-size: 20px;">Email</label><input type="email" class="form-control"style="font-size: 2rem;"  placeholder="Nhập email" name="email" value="${user.getEmail()}"><label class="labels"style="font-size: 15px; color: red;">${Message}</label></div>
                        <div class="col-md-12"><label class="labels"style="font-size: 20px;">Địa chỉ</label><input type="text" class="form-control" style="font-size: 2rem;" placeholder="Nhập địa chỉ" name="address" value="${user.getAddress()}"></div>
                        <div class="col-md-12"><label class="labels"style="font-size: 20px;">Giới tính</label>
                            <br>
                            <div class="row">
                                <c:if test="${user.getUser_sexID()=='1'}">
                                    <div class=" col-md-3">
                                        <label class="labels" style="margin:4px;font-size: 20px">Nam </label><input checked="" type="radio" class="labels " name="user_sexID" value="1" id="gender">
                                    </div>
                                    <div class=" col-md-3">
                                        <label class="labels" style="margin:4px;font-size: 20px">Nữ </label><input  type="radio" class="labels " name="user_sexID" value="2" id="gender">
                                    </div>
                                </c:if>
                                <c:if test="${user.getUser_sexID()=='2'}">
                                    <div class=" col-md-3">
                                        <label class="labels" style="margin:4px;font-size: 20px">Nam </label><input  type="radio" class="labels " name="user_sexID" value="1" id="gender">
                                    </div>
                                    <div class=" col-md-3">
                                        <label class="labels" style="margin:4px;font-size: 20px">Nữ </label><input checked=""  type="radio" class="labels " name="user_sexID" value="2" id="gender">
                                    </div>
                                </c:if>
                                <!--                                <div class=" col-md-3">
                                                                    <label class="labels" style="margin:4px;font-size: 20px">Khác </label><input  type="radio" class="labels " name="gender" id="gender">
                                                                </div>-->
                            </div>
                        </div>
                        <div class="col-md-12"><label class="labels" style="font-size: 20px;font-size: 20px">Tuổi</label><input type="text" class="form-control" style="font-size: 2rem;" placeholder="enter address line 2" name="age" value="${user.getAge()}"></div>                        
                    </div>
                    <!--<div class="mt-5 text-center"><button  class="btn btn-primary profile-button" style="background-color: #ff6633" type="button"><label class="labels" style="font-size: 20px">Lưu thông tin</label></button></div>-->
                    <div class="mt-5 text-center">
                        <input type="submit" class="btn btn-primary profile-button" class="labels" style="background-color: #ff6633;font-size: 20px" name="saveChanges" value="Lưu thông tin"> 

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- end footer -->