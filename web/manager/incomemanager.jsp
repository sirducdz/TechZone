<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="icon" href="image/icon.png" type="image/x-icon"/>
        <title>Bảng điều khiển</title>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <style>
            .dropbtn {
                background-color: #ef2317;
                color: white;
                padding: 16px;
                font-family: Roboto;
                border: none;
            }

            .dropdown {
                margin-right: 100px;
                margin-top: 2px;
                position: relative;
                display: inline-block;
                font-size: 30px;
                color: white;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: white;
                min-width: 120px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 12px;
                text-decoration: none;
                display: block;
                font-size: 15px;
            }

            .dropdown-content a:hover {
                background-color: #ef2317;
                color: white;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown:hover .dropbtn {
                background-color: #ef2317;
            }
        </style>
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
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
                <li><a class="app-menu__item active" href="ManagerIncomeController"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>

                <li><a class="app-menu__item " href="ManagerProductController"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Danh sách sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item" href="ManagerOrderController"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Danh sách đơn hàng</span></a></li>
                <li><a class="app-menu__item" href="ManagerFeedbackController"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Đánh giá </span></a></li>
<!--                <li><a class="app-menu__item active" href="ManagerIncomeController"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>-->
            </ul>
        </aside>
        <main class="app-content">
            <div class="row">
                <div class="col-md-12">
                    <div class="app-title">
                        <ul class="app-breadcrumb breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><b>Bảng điều khiển    </b></a></li>
                        </ul>
                        <div id="clock"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <div class="widget-small info coloured-icon"><i class='icon bx bxs-purchase-tag-alt fa-3x' ></i>
                        <div class="info">
                            <h4>Tổng sản phẩm</h4>
                            <p><b>${requestScope.product} sản phẩm</b></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6">
                    <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-shopping-bag-alt'></i>
                        <div class="info">
                            <h4>Tổng đơn hàng</h4>
                            <p><b>${requestScope.order} đơn hàng</b></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small primary coloured-icon"><i class='icon fa-3x bx bxs-chart' ></i>
                        <div class="info">
                            <h4>Tổng thu nhập</h4>
                            <p><b>${requestScope.tong} đ</b></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small warning coloured-icon"><i class='icon fa-3x bx bxs-tag-x' ></i>
                        <div class="info">
                            <h4>Hết hàng</h4>
                            <p><b>${requestScope.het} sản phẩm</b></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-4">
                    <div class="widget-small danger coloured-icon"><i class='icon fa-3x bx bxs-receipt' ></i>
                        <div class="info">
                            <h4>Đơn hàng hủy</h4>
                            <p><b>${requestScope.huy} đơn hàng</b></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="tile">
                        <h3 class="tile-title">THỐNG KÊ DOANH SỐ</h3>
                        <div class="embed-responsive embed-responsive-16by9">
                            <canvas class="embed-responsive-item" id="lineChartDemo"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="tile">
                        <h3 class="tile-title">THỐNG KÊ DOANH THU</h3>
                        <div class="embed-responsive embed-responsive-16by9">
                            <canvas class="embed-responsive-item" id="barChartDemo"></canvas>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div>
                            <h3 class="tile-title">SẢN PHẨM BÁN CHẠY</h3>
                        </div>
                        <div class="tile-body">
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>Mã sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th width="500px">Ảnh</th>
                                        <th>Giá tiền</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="p">
                                        <tr>
                                            <td>${p.getProductID()}</td>
                                            <td>${p.getName()}</td>
                                            <td>
                                                <img src="${p.getPicture()}" class="col-lg-3"/>
                                                <img src="${p.getPicture2()}" class="col-lg-3"/>
                                                <img src="${p.getPicture3()}" class="col-lg-3"/>
                                            </td>
                                            <td>${p.getPrice()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div>
                            <h3 class="tile-title">SẢN PHẨM ĐÃ HẾT</h3>
                        </div>
                        <div class="tile-body">
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>Mã sản phẩm</th>
                                        <th>Tên sản phẩm</th>
                                        <th width="500px">Ảnh</th>
                                        <th>Giá tiền</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${empty listun}">
                                        <tr>
                                            <td colspan="4" style="text-align: center;">Không có sản phẩm hết</td>
                                        </tr>
                                    </c:if>
                                    <c:forEach items="${listun}" var="l">
                                        <tr>
                                            <td>${l.getProductID()}</td>
                                            <td>${l.getName()}</td>
                                            <td><img src="${l.getPicture()}" class="col-lg-3"/>
                                                <img src="${l.getPicture2()}" class="col-lg-3"/>
                                                <img src="${l.getPicture3()}" class="col-lg-3"/>
                                            </td>
                                            <td>${l.getPrice()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div> 
        </main>

        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script type="text/javascript" src="js/plugins/chart.js"></script>
        <script type="text/javascript">
        function numberWithCommas(x) {
            return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        }
        var today = new Date();
        var mm = today.getMonth() + 1;
        var one = "Tháng " + (mm - 5);
        var two = "Tháng " + (mm - 4);
        var three = "Tháng " + (mm - 3);
        var four = "Tháng " + (mm - 2);
        var five = "Tháng " + (mm - 1);
        var six = "Tháng " + (mm);

        var data = {
            labels: [one, two, three, four, five, six],

            datasets: [{
                    label: "Dữ liệu đầu tiên",
                    fillColor: "rgba(255, 213, 59, 0.767), 212, 59)",
                    strokeColor: "rgb(255, 212, 59)",
                    pointColor: "rgb(255, 212, 59)",
                    pointStrokeColor: "rgb(255, 212, 59)",
                    pointHighlightFill: "rgb(255, 212, 59)",
                    pointHighlightStroke: "rgb(255, 212, 59)",
                    data: [${firstMonth}, ${secondMonth}, ${thirdMonth}, ${fourthMonth}, ${fifthMonth}, ${currMonth}]
                }
            ]
        };
        var data2 = {
            labels: [one, two, three, four, five, six],

            datasets: [{
                    label: "Chuột",
                    fillColor: "rgba(255, 213, 59, 0.123), 212, 59)",
                    strokeColor: "rgb(255, 212, 59)",
                    pointColor: "rgb(255, 212, 59)",
                    pointStrokeColor: "rgb(255, 212, 59)",
                    pointHighlightFill: "rgb(255, 212, 59)",
                    pointHighlightStroke: "rgb(255, 212, 59)",
                    data: [${MfirstMonth}, ${MsecondMonth}, ${MthirdMonth}, ${MfourthMonth}, ${MfifthMonth}, ${McurrMonth}]
                },
                {
                    label: "Bàn phím",
                    fillColor: "rgba(9, 109, 239, 0.123)",
                    strokeColor: "rgb(9, 109, 239)",
                    pointColor: "rgb(9, 109, 239)",
                    pointStrokeColor: "rgb(9, 109, 239)",
                    pointHighlightFill: "rgb(9, 109, 239)",
                    pointHighlightStroke: "rgb(9, 109, 239)",
                    data: [${KfirstMonth}, ${KsecondMonth}, ${KthirdMonth}, ${KfourthMonth}, ${KfifthMonth}, ${KcurrMonth}]
                },
                {
                    label: "Tai nghe",
                    fillColor: "rgba(255, 69, 0, 0.123)",
                    strokeColor: "rgb(255, 69, 0)",
                    pointColor: "rgb(255, 69, 0)",
                    pointStrokeColor: "rgb(255, 69, 0)",
                    pointHighlightFill: "rgb(255, 69, 0)",
                    pointHighlightStroke: "rgb(255, 69, 0)",
                    data: [${EfirstMonth}, ${EsecondMonth}, ${EthirdMonth}, ${EfourthMonth}, ${EfifthMonth}, ${EcurrMonth}]
                }
            ]
        };
        var ctxl = $("#lineChartDemo").get(0).getContext("2d");
        var lineChart = new Chart(ctxl).Line(data2);

        var ctxb = $("#barChartDemo").get(0).getContext("2d");
        var barChart = new Chart(ctxb).Bar(data);
        </script>
        <script type="text/javascript">
            //Thời Gian
            function time() {
                var today = new Date();
                var weekday = new Array(7);
                weekday[0] = "Chủ Nhật";
                weekday[1] = "Thứ Hai";
                weekday[2] = "Thứ Ba";
                weekday[3] = "Thứ Tư";
                weekday[4] = "Thứ Năm";
                weekday[5] = "Thứ Sáu";
                weekday[6] = "Thứ Bảy";
                var day = weekday[today.getDay()];
                var dd = today.getDate();
                var mm = today.getMonth() + 1;
                var yyyy = today.getFullYear();
                var h = today.getHours();
                var m = today.getMinutes();
                var s = today.getSeconds();
                m = checkTime(m);
                s = checkTime(s);
                nowTime = h + " giờ " + m + " phút " + s + " giây";
                if (dd < 10) {
                    dd = '0' + dd
                }
                if (mm < 10) {
                    mm = '0' + mm
                }
                today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                        '</span>';
                document.getElementById("clock").innerHTML = tmp;
                clocktime = setTimeout("time()", "1000", "Javascript");

                function checkTime(i) {
                    if (i < 10) {
                        i = "0" + i;
                    }
                    return i;
                }
            }
        </script>
    </body>

</html>