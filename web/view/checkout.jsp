<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Giỏ hàng</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&amp;display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/cart.css">
    </head>
    <style>
        .form-control{
            border: none;
            border-bottom: 1px solid #999;
            font-size: 1.5rem;
            padding: 2px;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        .form-control:disabled, .form-control[readonly]{
            background-color: white;
        }
        element.style {
            font-family: 'roboto';
        }
        .custom-control-label{
        }
        .custom-radio .custom-control-input:checked~.custom-control-label::after {
            background-image: none;
            
        }
    </style>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!--end header nav -->

            <!-- score-top-->

            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-down"></i></button>
            <!-- cart -->
            <form action="CheckoutController">
                <main role="main" style="margin-bottom: 20px">
                    <!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là content -->
                    <div class="container mt-4" style="font-size: 300px; padding-top: 15px">
                        <!--                    <form class="needs-validation" name="frmthanhtoan" method="post"
                                                  action="#">-->
                        <input type="hidden" name="kh_tendangnhap" value="dnpcuong">

                        <div style="text-align: center">
                            <h1 style="font-size: 4rem; font-weight: bold;">THANH TOÁN</h1>
                            <h3 class="lead" style="font-size: 20px; padding-top: 15px; padding-bottom: 15px; font-style:italic;">Vui lòng kiểm tra thông tin khách hàng, thông tin giỏ hàng trước khi thanh toán.</h3>
                        </div>

                        <div class="row">
                            <div class="col-md-4 order-md-2 mb-4">
                                <h4 class="d-flex justify-content-between align-items-center mb-3">
                                    <span class="text-muted" style="font-size: 2rem; color: red;">GIỎ HÀNG</span>
                                    <span class="badge badge-secondary badge-pill" style="background-color: #ff3333;">
                                        <a href="${user!=null?'CartController?tab=cartList':'../auth/login'}" class="col-lg-1 col-md-1 col-sm-0 header__cart">
                                        <div class="header__cart-icon-wrap">
                                            <span class="header__notice">${user!=null?AmountOfProductType:'0'}</span>
                                            <i class="fas fa-shopping-cart header__nav-cart-icon"></i>
                                        </div>
                                    </a>
                                </span>
                            </h4>
                            <div class="list-group mb-3" id="confirmation">
                                <ul>
                                    <c:forEach items="${data}" var="item">
                                        <li class="list-group-item d-flex justify-content-between lh-condensed">
                                            <div>
                                                <h6 class="my-0" style="font-size: 1.2rem;font-style: italic">${item.getProductName()}</h6>
                                                <small class="text-muted" style="font-style: italic; font-weight: bold; color: black;">${item.getPrice()} x ${item.getQuantity()}</small>
                                            </div>
                                            <span class="text-muted">${item.getTotalcost()} đ</span>
                                        </li>
                                    </c:forEach>
                                    <li class="list-group-item d-flex justify-content-between">
                                        <span>Tổng thành tiền</span>
                                        <strong>${totalPrice} đ</strong>
                                    </li>
                                </ul>
                                <!--<h6 style="font-size: 15px" >hay</h6>-->
                            </div>

                            <div class="input-group">
                                <input type="text" class="form-control" style="font-size: 1.8rem; font-style: italic;font-family: 'roboto';" placeholder="Mã giảm giá" name="inputSalecode">
                                <div class="input-group-append" >
                                    <button type="submit" class="btn btn-secondary"  onclick="confirmSalecodeFunct()" name="confirmSalecode" style="background-color: #ff3333;"><h1 style="font-size: 1.2rem">Xác nhận</h1></button>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-8 order-md-1">
                            <h4 class="mb-3" style="font-size: 2.8rem; font-weight: bold; font-style:italic;">THÔNG TIN KHÁCH HÀNG</h4>

                            <div class="row">
                                <div class="col-md-12">
                                    <label for="kh_ten"  style="font-weight: bold; font-size: 2.5rem;">Họ và tên</label>
                                    <input type="text" class="form-control" value="${user.getName()}" readonly>
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_gioitinh" style="font-weight: bold; font-size: 2.5rem;">Giới tính</label>
                                    <input type="text" class="form-control" readonly value="${user.getUser_sexID()==1?"Nam":"Nữ"}">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_diachi" style="font-weight: bold; font-size: 2.5rem;">Địa chỉ</label>
                                    <input type="text" class="form-control" value="${user.getAddress()}" readonly>
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_dienthoai" style="font-weight: bold; font-size: 2.5rem;">Điện thoại</label>
                                    <input type="text" class="form-control" value="${user.getPhone_number()}" readonly>
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_email" style="font-weight: bold; font-size: 2.5rem;">Email</label>
                                    <input type="email" class="form-control"  value="${user.getEmail()}" readonly>
                                </div>
                            </div>

                            <h4 class="mb-3" style="margin-top: 15px; font-weight: bold; font-size: 2.5rem;">Hình thức thanh toán</h4>

                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input id="httt-1" name="checkoutType" type="radio" class="custom-control-input" required=""
                                           value="cash">
                                    <label class="custom-control-label" for="httt-1" style="font-size: 1.5rem;">Tiền mặt</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="httt-2" name="checkoutType" type="radio" class="custom-control-input" required=""
                                           value="transfer">
                                    <label class="custom-control-label" for="httt-2" style="font-size: 1.5rem;">Chuyển khoản</label>
                                </div>                             
                            </div>
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block"  style="font-size: 20px; background-color:#ff3333" type="submit" name="btnDatHang">Đặt hàng</button>
                        </div>                              
                    </div>
                </div>




                <!-- End block content -->
            </main>
        </form>
        <!--end cart -->

        <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- end footer -->
        <script src="js/jq.js"></script>
        <script>
                                        function confirmSalecodeFunct() {
                                            event.preventDefault();
                                            $.ajax({
                                                url: "/TechZone/view/CheckoutController",
                                                type: "post", //send it through get method
                                                data: {
                                                    confirmSalecode: true,
                                                    inputSalecode: document.getElementsByName("inputSalecode")[0].value
                                                },
                                                success: function (data) {
                                                    var row = document.getElementById("confirmation");
                                                    row.innerHTML = data;
                                                    console.log("runnable");
//                            var row = document.getElementById("allCart");
//                            row.innerHTML = data;
                                                },
                                                error: function (xhr) {
                                                    //Do Something to handle error
                                                }
                                            });
                                        }
        </script>
    </body>


</html>