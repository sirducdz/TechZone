<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="icon" href="image/icon.png" type="image/x-icon"/>
        <title>Quản lý người dùng</title>
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
                    <a href="AdminIncomeController"><img src="image/logo1.png" alt="Logo" height="45px" width="225px"/></a>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item " href="AdminIncomeController"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>
                <li><a class="app-menu__item active" href="ManagerUserController"><i class='app-menu__icon bx bx-id-card'></i>
                        <span class="app-menu__label">Quản lý người dùng</span></a></li>
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
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách người dùng</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">

                            <div class="row element-button">
                                <div class="col-sm-2">

                                    <a class="btn btn-add btn-sm" href="adduser.jsp" title="Thêm"><i class="fas fa-plus"></i>
                                        Tạo mới người dùng</a>
                                </div>
                            </div>
                            <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0"
                                   id="sampleTable">
                                <thead>
                                    <tr>
                                        <th>ID người dùng</th>
                                        <th>Tên đăng nhập</th>
                                        <th>Mật khẩu</th>
                                        <th>Vai trò</th>
                                        <th>Họ và tên</th>
                                        <th>Tuổi</th>
                                        <th>Giới tính</th>
                                        <th>Địa chỉ</th>
                                        <th>Số điện thoại</th>
                                        <!--<th>Ảnh đại diện</th>-->
                                        <th>Trạng thái</th>
                                        <th>Tính năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${data}" var="item">
                                        <!--                                        <tr>
                                                                                    <td width="10"><input type="checkbox" name="check2" value="2"></td>
                                                                                    <td>ID người dùng</td>
                                                                                    <td>Tên đăng nhập</td>
                                                                                    <td>Mật khẩu</td>
                                                                                    <td>Vai trò</td>
                                                                                    <td>Họ và tên</td>
                                                                                    <td>Tuổi</td>
                                                                                    <td>Giới tính</td>
                                                                                    <td>Địa chỉ</td>
                                                                                    <td>Số điện thoại</td>
                                                                                    <td>Ảnh đại diện</td>
                                                                                    <td>Thông tin</td>
                                                                                    <td><button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                                                                                                onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                                                                                        </button>
                                                                                        <a href="edituser.jsp" class="btn btn-primary btn-sm" title="chỉnh sửa"><i class="fas fa-edit"></i></a>
                                                                                    </td>
                                                                                </tr>-->
                                        <tr>
                                            <td>${item.getUserID()} </td>
                                            <td>${item.getUsername()}</td>
                                            <td>${item.getPassword()}</td>
                                            <c:if test="${item.getUser_roleID()=='1'}">
                                                <td>Quản trị viên</td>
                                            </c:if>
                                            <c:if test="${item.getUser_roleID()=='2'}">
                                                <td>Quản lí</td>
                                            </c:if>
                                            <c:if test="${item.getUser_roleID()=='3'}">
                                                <td>Khách hàng</td>
                                            </c:if>
                                            <c:if test="${item.getUser_roleID()=='4'}">
                                                <td>Saler</td>
                                            </c:if>
                                            <td>${item.getName()}</td>
                                            <td>${item.getAge()}</td>
                                            <c:if test="${item.getUser_sexID()=='1'}">
                                                <td>Nam</td>
                                            </c:if>
                                            <c:if test="${item.getUser_sexID()!='1'}">
                                                <td>Nữ</td>
                                            </c:if>
                                            <c:if test="${item.getAddress()!=null}">
                                                <td>${item.getAddress()!=null?item.getAddress():"None"}</td>
                                            </c:if>
                                            <td>${item.getPhone_number()}</td>
                                            <!--<td><img src="UserImage/user.getAvatar()}"></td>-->
                                            <td>${item.getStatus()=='1'?"Hoạt động":"Tắt hoạt động"}</td>
                                            <td>
                                                <!--                                                <button class="btn btn-primary btn-sm trash" type="button" title="Xóa"
                                                                                                        onclick="myFunction(this)"><i class="fas fa-trash-alt"></i>
                                                                                                </button>-->
                                                <a href="EditUserController?userID=${item.getUserID()}" class="btn btn-primary btn-sm" title="chỉnh sửa"><i class="fas fa-edit"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!--
        MODAL
        -->
        <div class="modal fade" id="ModalUP" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static"
             data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <div class="row">
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Chỉnh sửa thông tin</h5>
                                </span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label class="control-label">ID người dùng</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Tên đăng nhập</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Mật khẩu</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group  col-md-6">
                                <label for="exampleSelect1" class="control-label">Vai trò</label>
                                <select class="form-control" id="exampleSelect1">
                                    <option>Khách hàng</option>
                                    <option>Quản lý</option>
                                    <option>Admin</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Họ và tên</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Ngày sinh</label>
                                <input class="form-control" type="date" value="">
                            </div>
                            <div class="form-group  col-md-6">
                                <label for="exampleSelect1" class="control-label">Giới tính</label>
                                <select class="form-control" id="exampleSelect1">
                                    <option>Nam</option>
                                    <option>Nữ</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Địa chỉ</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Số điện thoại</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Ảnh đại diện</label>
                                <input class="form-control" type="file">
                            </div>
                            <div class="form-group col-md-6">
                                <label class="control-label">Thông tin</label>
                                <input class="form-control" type="text">
                            </div>
                        </div>
                        <BR>
                        <button class="btn btn-save" type="button">Lưu lại</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                        <BR>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
        MODAL
        -->

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

                        text: "Bạn có chắc chắn là muốn xóa người dùng này?",
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

            //EXCEL
            // $(document).ready(function () {
            //   $('#').DataTable({

            //     dom: 'Bfrtip',
            //     "buttons": [
            //       'excel'
            //     ]
            //   });
            // });


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
                }
            }
            //     //Sao chép dữ liệu
            //     var copyTextareaBtn = document.querySelector('.js-textareacopybtn');

            // copyTextareaBtn.addEventListener('click', function(event) {
            //   var copyTextarea = document.querySelector('.js-copytextarea');
            //   copyTextarea.focus();
            //   copyTextarea.select();

            //   try {
            //     var successful = document.execCommand('copy');
            //     var msg = successful ? 'successful' : 'unsuccessful';
            //     console.log('Copying text command was ' + msg);
            //   } catch (err) {
            //     console.log('Oops, unable to copy');
            //   }
            // });


            //Modal
            $("#show-emp").on("click", function () {
                $("#ModalUP").modal({backdrop: false, keyboard: false})
            });
        </script>
    </body>

</html>
