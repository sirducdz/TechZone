<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="icon" href="image/icon.png" type="image/x-icon"/>
        <title>Chỉnh sửa người dùng</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <script>

            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else { // Sử dụng cho IE
                    $("#thumbimage").attr('src', input.value);

                }
                $("#thumbimage").show();
                $('.filename').text($("#uploadfile").val());
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'default');
                $(".removeimg").show();
                $(".Choicefile").unbind('click');

            }
            $(document).ready(function () {
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();

                });
                $(".removeimg").click(function () {
                    $("#thumbimage").attr('src', '').hide();
                    $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $(".Choicefile").bind('click', function () {
                        $("#uploadfile").click();
                    });
                    $('.Choicefile').css('background', '#14142B');
                    $('.Choicefile').css('cursor', 'pointer');
                    $(".filename").text("");
                });
            })
        </script>
    </head>

    <body class="app sidebar-mini rtl">
        <style>
            .Choicefile {
                display: block;
                background: #14142B;
                border: 1px solid #fff;
                color: #fff;
                width: 150px;
                text-align: center;
                text-decoration: none;
                cursor: pointer;
                padding: 5px 0px;
                border-radius: 5px;
                font-weight: 500;
                align-items: center;
                justify-content: center;
            }

            .Choicefile:hover {
                text-decoration: none;
                color: white;
            }

            #uploadfile,
            .removeimg {
                display: none;
            }

            #thumbbox {
                position: relative;
                width: 100%;
                margin-bottom: 20px;
            }

            .removeimg {
                height: 25px;
                position: absolute;
                background-repeat: no-repeat;
                top: 5px;
                left: 5px;
                background-size: 25px;
                width: 25px;
                /* border: 3px solid red; */
                border-radius: 50%;

            }

            .removeimg::before {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
                content: '';
                border: 1px solid red;
                background: red;
                text-align: center;
                display: block;
                margin-top: 11px;
                transform: rotate(45deg);
            }

            .removeimg::after {
                /* color: #FFF; */
                /* background-color: #DC403B; */
                content: '';
                background: red;
                border: 1px solid red;
                text-align: center;
                display: block;
                transform: rotate(-45deg);
                margin-top: -2px;
            }
        </style>
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="../view/homepage"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <div>
                    <a href="AdminIncomeController"><img src="image/logo1.png" alt="Logo" height="45px" width="225px"/></a>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="AdminIncomeController"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>
                <li><a class="app-menu__item active" href="ManagerUserController"><i class='app-menu__icon bx bx-id-card'></i> <span
                            class="app-menu__label">Quản lý người dùng</span></a></li>
                <li><a class="app-menu__item" href="AdminController"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item" href="OrderController"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Quản lý đơn hàng</span></a></li>
<!--                <li><a class="app-menu__item" href="AdminIncomeController"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>-->
            </ul>
        </aside>
        <!--<for class="app-content" action="EditUserController" method="post">-->
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">Danh sách người dùng</li>
                    <li class="breadcrumb-item"><a href="#">Chỉnh sửa người dùng</a></li>
                </ul>
            </div>

            <div class="row">
                <div class="col-md-12">

                    <div class="tile">

                        <h3 class="tile-title">Chỉnh sửa người dùng</h3>
                        <div class="tile-body">
                            <form class="row">
                                <div class="form-group col-md-4">
                                    <label class="control-label">ID người dùng</label>
                                    <input class="form-control" type="text" readonly="" name="userID"  value="${user.getUserID()}">
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="control-label">Tên đăng nhập</label>
                                    <input class="form-control" type="text" name="username"  value="${user.getUsername()}">
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="control-label">Mật khẩu</label>
                                    <input class="form-control" type="text" name="password"  value="${user.getPassword()}">
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="control-label">Họ và tên</label>
                                    <input class="form-control" type="text" name="name"  value="${user.getName()}">
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Số điện thoại</label>
                                    <input class="form-control" type="number" name="phone_number"  value="${user.getPhone_number()}">
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="control-label">Tuổi</label>
                                    <input class="form-control" type="number" name="age"  value="${user.getAge()}">
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Địa chỉ</label>
                                    <input class="form-control" type="text" name="address"  value="${user.getAddress()}">
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="control-label">Giới tính</label>
                                    <select class="form-control" id="exampleSelect2" name="user_sexID">
                                        <option>-- Chọn giới tính --</option>
                                        <c:if test="${user.getUser_sexID()=='1'}">
                                            <option value="1" selected="">Nam</option>
                                            <option value="2">Nữ</option>
                                        </c:if>
                                        <c:if test="${user.getUser_sexID()!='1'}">
                                            <option value="1">Nam</option>
                                            <option value="2"selected="">Nữ</option>
                                        </c:if>
                                    </select>
                                </div>

                                <div class="form-group  col-md-4">
                                    <label for="exampleSelect1" class="control-label">Vai trò</label>
                                    <select class="form-control" id="exampleSelect1" name="user_roleID">
                                        <c:if test="${user.getUser_roleID()=='1'}">
                                            <option value="3">Khách hàng</option>
                                            <option value="2">Quản lý</option>
                                            <option value="1" selected="">Admin</option>
                                            <option value="4">Người bán hàng</option>
                                        </c:if>
                                        <c:if test="${user.getUser_roleID()=='2'}">
                                            <option value="3">Khách hàng</option>
                                            <option value="2" selected="">Quản lý</option>
                                            <option value="1" >Admin</option>
                                            <option value="4">Người bán hàng</option>
                                        </c:if>
                                        <c:if test="${user.getUser_roleID()=='3'}">
                                            <option value="3" selected="">Khách hàng</option>
                                            <option value="2">Quản lý</option>
                                            <option value="1" >Admin</option>
                                            <option value="4">Người bán hàng</option>
                                        </c:if>
                                        <c:if test="${user.getUser_roleID()=='4'}">
                                            <option value="3">Khách hàng</option>
                                            <option value="2">Quản lý</option>
                                            <option value="1" >Admin</option>
                                            <option value="4" selected="">Người bán hàng</option>
                                        </c:if>


                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="exampleSelect1" class="control-label">Tình trạng</label>
                                    <select class="form-control" id="exampleSelect1" name="status">
                                        <c:if test="${user.getStatus()=='1'}">
                                            <option value="1"selected="">Tài khoản mở</option>
                                            <option value="0">Tài khoản Khóa</option>
                                        </c:if>
                                        <c:if test="${user.getStatus()=='0'}">
                                            <option value="1">Tài khoản mở</option>
                                            <option value="0" selected="">Tài khoản khóa</option>
                                        </c:if>
                                    </select>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Ảnh 3x4 </label>
                                    <div id="myfileupload">
                                        <input type="file" id="uploadfile" name="ImageUpload" onchange="readURL(this);" />
                                    </div>
                                    <div id="thumbbox">
                                        <img height="300" width="300" alt="Thumb image" id="thumbimage" style="display: none" />
                                        <a class="removeimg" href="javascript:"></a>
                                    </div>
                                    <div id="boxchoice">
                                        <a href="javascript:" class="Choicefile"><i class='bx bx-upload'></i></a>
                                        <p style="clear:both"></p>
                                    </div>

                                </div>

                                <input class="btn btn-save" type="submit" name="Submit" value="Lưu lại"> 
                                <a class="btn btn-cancel" href="ManagerUserController">Hủy bỏ</a>

                            </form>
                            ${message}
                        </div>
                    </div>

                    </main>
                    <!--</form>-->

                    <!--
                    MODAL
                    -->

                    <!--
                    MODAL
                    -->


                    <!-- Essential javascripts for application to work-->
                    <script src="js/jquery-3.2.1.min.js"></script>
                    <script src="js/popper.min.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                    <script src="js/main.js"></script>
                    <!-- The javascript plugin to display page loading on top-->
                    <script src="js/plugins/pace.min.js"></script>

                    </body>

                    </html>
