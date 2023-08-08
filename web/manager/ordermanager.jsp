<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="icon" href="image/icon.png" type="image/x-icon"/>
        <title>Quản lý đơn hàng</title>
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
                    <a href="ManagerIncomeController"><img src="image/logo1.png" alt="Logo" height="45px" width="225px"/></a>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item " href="ManagerIncomeController"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>

                <li><a class="app-menu__item " href="ManagerProductController"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Danh sách sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item active" href="ManagerOrderController"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Danh sách đơn hàng</span></a></li>
                <li><a class="app-menu__item" href="ManagerFeedbackController"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Đánh giá </span></a></li>
<!--                <li><a class="app-menu__item" href="ManagerIncomeController"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>-->
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách đơn hàng</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <!--                            <div class="row element-button">
                                                            <div class="col-sm-2">
                                                                <a class="btn btn-excel btn-sm" href="" title="In"><i class="fas fa-file-excel"></i> Xuất file</a>
                                                            </div>
                                                        </div>-->
                            <table class="table table-hover table-bordered" id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>Mã đơn hàng</th>
                                        <th>Khách hàng</th>
                                        <th>Tư vấn viên</th>
                                        <th>Ngày tạo đơn</th>
                                        <th>Tổng tiền</th>
                                        <th style="width: 20%">Trạng thái đơn hàng</th>
                                        <!--                                        <th>Tính năng</th>-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listO}" var="o">
                                        <tr>
                                            <td style="width:8%;">${o.getOrderID()}</td>
                                            <td>${o.getName_user()}</td>
                                            <td>${o.getOrder_salecodeID()}</td>
                                            <td>${o.getDate()}</td>
                                            <td>${o.getPrice_order()}</td>
                                            <td>
                                                <form action="ManagerOrderController" method="post">
                                                    <input type="hidden" name="orderId" value="${o.getOrderID()}">

                                                    <select name="newStatus">
                                                        <option value="Pending" ${ o.getStatus().equals("Pending") ? "selected" : "" }>Pending</option>
                                                        <option value="Shipping" ${o.getStatus().equals("Shipping") ? "selected" : "" }>Shipping</option>
                                                        <option value="Completed" ${o.getStatus().equals("Completed") ? "selected" : "" }>Completed</option>
                                                        <option value="Cancelled" ${ o.getStatus().equals("Cancelled") ? "selected" : "" }>Cancelled</option>
                                                    </select>
                                                    <input style="background-color: #99ffff; border: 2px solid #00ffff; border-radius: 10px;color: blue;" type="submit" value="Cập nhật">
                                                    <a href="ManagerOrderDetailController?id=${o.getOrderID()}" style="background-color: #ffff99; border: 2px solid #ccff36; border-radius: 10px;color: blue; padding: 1px 6px 1px 6px;" type="submit" value="Chi tiết"> Chi tiết</a>
                                                </form>
                                            </td>
                                            <!--<td>${o.getNote()}</td>-->
                                            <!--                                            <td>
                                                                                            <button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                                                                                                    onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                                                                                            </button>
                                                                                        </td>-->
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
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>
        <script>
            function deleteRow(r) {
                var i = r.parentNode.parentNode.rowIndex;
                document.getElementById("myTable").deleteRow(i);
            }
            jQuery(function () {
                jQuery(".trash").click(function () {
                    swal({
                        title: "Cảnh báo",

                        text: "Bạn có chắc chắn là muốn xóa đơn hàng này?",
                        buttons: ["Hủy bỏ", "Đồng ý"],
                    })
                            .then((willDelete) => {
                                if (willDelete) {
                                    swal("Đã xóa thành công.!", {

                                    });
                                }
                            });
                });
            });
            oTable = $('#sampleTable').dataTable();
            $('#all').click(function (e) {
                $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
                e.stopImmediatePropagation();
            });

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
            //In dữ liệu
            var myApp = new function () {
                this.printTable = function () {
                    var tab = document.getElementById('sampleTable');
                    var win = window.open('', '', 'height=700,width=700');
                    win.document.write(tab.outerHTML);
                    win.document.close();
                    win.print();
                };
            };
        </script>
    </body>

</html>