<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="icon" href="image/icon.png" type="image/x-icon"/>
        <title>Thêm mới đơn hàng</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
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
                    <a href="ManagerHomepageController"><img src="image/logo1.png" alt="Logo" height="45px" width="225px"/></a>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item " href="ManagerHomepageController"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>

                <li><a class="app-menu__item " href="ManagerProductController"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Danh sách sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item active" href="ManagerOrderController"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Danh sách đơn hàng</span></a></li>
                <li><a class="app-menu__item" href="ManagerFeedbackController"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Đánh giá </span></a></li>
                <li><a class="app-menu__item" href="ManagerIncomeController"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">Danh sách đơn hàng</li>
                    <li class="breadcrumb-item"><a href="#">Thêm đơn hàng</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Tạo mới đơn hàng</h3>
                        <div class="tile-body">
                            <p class="text-danger">${wrongText}</p>
                            <p class="text-success">${successText}</p>

                            <form action="ManagerAddOrderController" method="post">
                                <div class="row">
<!--                                    <div class="form-group col-md-6">
                                        <label class="control-label">ID đơn hàng</label>
                                        <input class="form-control" type="text" value="${o.getOrderID()}" name="id">
                                    </div>-->
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Tên khách hàng</label>
                                        <input class="form-control" type="text" name="user" value="${listU.get(o.getOrder_userID()-1).getName()}">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Địa chỉ</label>
                                        <input class="form-control" type="text" name="saler" value="${o.getOrder_salecodeID()}">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Số điện thoại</label>
                                        <input class="form-control" type="text" name="order" value="${o.getNote()}">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Sản phẩm</label>
                                        <input class="form-control" type="text" name="order" value="${o.getNote()}">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Số lượng</label>
                                        <input class="form-control" type="text" name="order" value="${o.getNote()}">
                                    </div>
                                    <div class="form-group  col-md-4">
                                        <label class="control-label">Tổng tiền</label>
                                        <input class="form-control" type="text">
                                    </div>
                                    <div class="form-group  col-md-6">
                                        <label class="control-label">Ngày đặt</label>
                                        <input class="form-control" type="datetime-local" name="date" value="${o.getDate()}">
                                    </div>
                                    <div class="form-group  col-md-6">
                                        <label for="exampleSelect1" class="control-label">Tình trạng</label>
                                        <input name="status" value="${status}" class="form-control" type="text" readonly="" placeholder="Đang xử lý">  

                                        <!--                                    <select class="form-control" id="exampleSelect1" name="status">
                                                                                    <option name="status" value="${o.getStatus()}" selected="selected">${o.getStatus()}</option>
                                                                            </select>-->
                                    </div>
                                </div>
                                <BR>
                                <button class="btn btn-save" type="submit">Lưu lại</button>
                                <a class="btn btn-cancel" data-dismiss="modal" href="ManagerOrderController">Hủy bỏ</a>
                                <BR>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>
        <script>
            const inpFile = document.getElementById("inpFile");
            const loadFile = document.getElementById("loadFile");
            const previewContainer = document.getElementById("imagePreview");
            const previewContainer = document.getElementById("imagePreview");
            const previewImage = previewContainer.querySelector(".image-preview__image");
            const previewDefaultText = previewContainer.querySelector(".image-preview__default-text");
            inpFile.addEventListener("change", function () {
                const file = this.files[0];
                if (file) {
                    const reader = new FileReader();
                    previewDefaultText.style.display = "none";
                    previewImage.style.display = "block";
                    reader.addEventListener("load", function () {
                        previewImage.setAttribute("src", this.result);
                    });
                    reader.readAsDataURL(file);
                }
            });

        </script>
    </body>

</html>