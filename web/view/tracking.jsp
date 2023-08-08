<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Tình trạng ship</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" rel="stylesheet">
        <link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/tracking.css">
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/home.css">
    </head>
    <body>
        <!--        <header>-->
        <jsp:include page="header.jsp"></jsp:include>
            <!--        </header>-->
            <div class="container">
                <article class="card">
                    <header class="card-header"> Trạng thái đơn hàng </header>
                    <div class="card-body">

                        <article class="card">
                            <div class="card-body row" style="font-size: 3rem;">
                                <!--<h6 style="font-size: 1.6rem;">Mã đơn hàng: OD45345345435</h6>-->
                                <div class="col"> <strong>Mã đơn hàng:</strong> <br> ${order.getOrderID()} </div>
                            <div class="col"> <strong>Ngày đặt:</strong> <br>${order.getDate()} </div>
                            <div class="col"> <strong>Địa chỉ nhận hàng/Số điện thoại:</strong> <br> ${order.getAddress()}, | <i class="fa fa-phone"></i> ${order.getPhone_number()} </div>
                            <div class="col"> <strong>Trạng thái:</strong> <br> ${order.getStatus()} </div>

                        </div>
                    </article>
                    <div class="track">
                        <c:if test="${order.getStatus()=='Cancelled'}">
                            <div class="step"> <span class="icon"> <i class="fa fa-check"></i> </span> <span class="text">Xác nhận đơn hàng</span> </div>
                            <div class="step"> <span class="icon"> <i class="fa fa-user"></i> </span> <span class="text">Hàng đang Giao</span> </div>
                            <div class="step"> <span class="icon"> <i class="fa fa-truck"></i> </span> <span class="text">Hoàn Thành</span> </div>
                        </c:if>
                        <c:if test="${order.getStatus()=='Pending'}">
                            <div class="step active"> <span class="icon"> <i class="fa fa-check"></i> </span> <span class="text">Xác nhận đơn hàng</span> </div>
                            <div class="step "> <span class="icon"> <i class="fa fa-user"></i> </span> <span class="text">Hàng đang Giao</span> </div>
                            <div class="step"> <span class="icon"> <i class="fa fa-truck"></i> </span> <span class="text">Hoàn Thành</span> </div>
                        </c:if>
                        <c:if test="${order.getStatus()=='Shipping'}">
                            <div class="step active"> <span class="icon"> <i class="fa fa-check"></i> </span> <span class="text">Xác nhận đơn hàng</span> </div>
                            <div class="step active"> <span class="icon"> <i class="fa fa-user"></i> </span> <span class="text">Hàng đang Giao</span> </div>
                            <div class="step"> <span class="icon"> <i class="fa fa-truck"></i> </span> <span class="text">Hoàn Thành</span> </div>
                        </c:if>
                        <c:if test="${order.getStatus()=='Completed'}">
                            <div class="step active"> <span class="icon"> <i class="fa fa-check"></i> </span> <span class="text">Xác nhận đơn hàng</span> </div>
                            <div class="step active"> <span class="icon"> <i class="fa fa-user"></i> </span> <span class="text">Hàng đang Giao</span> </div>
                            <div class="step active"> <span class="icon"> <i class="fa fa-truck"></i> </span> <span class="text">Hoàn Thành</span> </div>
                        </c:if>
                        <!--<div class="step"> <span class="icon"> <i class="fa fa-box-open"></i> </span> <span class="text">Đã đến nơi</span> </div>-->
                    </div>
                    <hr>                      
                    <a href="OrderListController" class="btn btn-warning" style="font-size: 1.6rem" data-abc="true"> <i class="fa fa-chevron-left"></i> Quay về danh sách đơn hàng</a>
                </div>
            </article>
        </div>
        <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- end footer -->
        <script src="js/jq.js"></script>

    </body>
</html>