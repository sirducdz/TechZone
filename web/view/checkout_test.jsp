<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!--        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Danh sách đơn hàng</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/home.css">
        <link rel="stylesheet" href="css/orderlist.css">
        <style>
            .container-xl{
                color: #566787;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
                font-size: 40rem;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .font-0{
                font-size: 2.5rem;
                width: 100%;
            }
            .font-1{
                font-size: 2rem;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
                /*font-style:*/
            }
            .page-item.active .page-link{
                background-color: #ff794b;
                border-color: #ff794b;
            }
            .pagination li.active a:hover{
                background: #ff6666;
            }
            .table-wrapper .btn {
                float: right;
                color: #333;
                background-color: #fff;
                border-radius: 3px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .col-sm-3{
                font-size: 3rem;
                color: black;
            }
            .table-wrapper .btn:hover {
                color: #333;
                background: #f2f2f2;
            }
            .table-wrapper .btn.btn-primary {
                color: #fff;
                background: #333333;
            }
            .table-wrapper .btn.btn-primary:hover {
                background: #009999;
            }
            .table-title .btn {
                font-size: 13px;
                border: none;
            }
            .bt{
                color: #4080ee;
                text-transform: capitalize;
                cursor: pointer;
                display: block;
                background: none;
                border: none;
                padding: 0;
                margin: 0;
                cursor: pointer;
                text-align: inherit;
            }
            .but{
                font-size: 3rem;
                display: flex;
                align-items: center;
                justify-content: center;
                align-self: flex-start;
                background: #f24137;
                border: 1px solid rgba(0,0,0,.09);
                box-shadow: 0 1px 1px 0 rgba(0,0,0,.03);
                border-radius: 2px!important;
                color: white;
                text-transform: capitalize;
                outline: none;
                padding: 5px 30px;
                margin-left: 80%;
            }
            .end{
                font-size: 2rem;
            }
            .end-n2{
                font-size: 3rem;
                color: red;
            }
            .end-n3{
                font-size: 3rem;
            }
            .size{
                font-size: 2rem;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            .table-title {
                color: #fff;
                background: #ff3333;
                padding: 16px 25px;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .show-entries select.form-control {
                width: 60px;
                margin: 0 5px;
            }
            .table-filter .filter-group {
                float: right;
                margin-left: 15px;
            }
            .table-filter input, .table-filter select {
                height: 34px;
                border-radius: 3px;
                border-color: #ddd;
                box-shadow: none;
            }
            .table-filter {
                padding: 5px 0 15px;
                border-bottom: 1px solid #e9e9e9;
                margin-bottom: 5px;
            }
            .table-filter .btn {
                height: 34px;
            }
            .table-filter label {
                font-weight: normal;
                margin-left: 10px;
            }
            .table-filter select, .table-filter input {
                display: inline-block;
                margin-left: 5px;
            }
            .table-filter input {
                width: 200px;
                display: inline-block;
            }
            .filter-group select.form-control {
                width: 110px;
            }
            .filter-icon {
                float: right;
                margin-top: 7px;
            }
            .filter-icon i {
                font-size: 18px;
                opacity: 0.7;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 60px;
            }
            table.table tr th:last-child {
                width: 80px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
            }
            table.table td a:hover {
                color: #2196F3;
            }
            table.table td a.view {
                width: 30px;
                height: 30px;
                color: #2196F3;
                border: 2px solid;
                border-radius: 30px;
                text-align: center;
            }
            table.table td a.view i {
                font-size: 22px;
                margin: 2px 0 0 1px;
            }
            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }
            .col-sm-9{
                font-size: 5rem;
            }
            .btn:not(:disabled):not(.disabled) {
                margin-top:0px;
                font-size: 3rem;
            }
            .status {
                font-size: 30px;
                margin: 2px 2px 0 0;
                display: inline-block;
                vertical-align: middle;
                line-height: 10px;
            }
            .text-success {
                color: #10c469;
            }
            .text-info {
                color: #62c9e8;
            }
            .text-warning {
                color: #FFC107;
            }
            .text-danger {
                color: #ff5b5b;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .show-entries{

            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a {
                background: #03A9F4;
            }
            .pagination li.active a:hover {
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 1.8rem;
                color: black;
            }
            .show-entries {
                font-size: 2.5rem;
                padding-top: 10px;
                padding-bottom: 10px;
                color: black;
            }
            .hover-order:hover{
                background: white;
                border: 2px solid red;
                color: red;
                text-decoration: none;
            }
            .show-entries.active {
                border: 2px solid red;
                color: red;
            }
            .show-entries.active:hover {
                border: 2px solid red;
                color: red;
            }
            @media all and (max-width:375px){

            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container-xl">
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <h2>Thanh toán</h2>
                        </div>
                        <div class="container">
                            <h3>Địa chỉ nhận hàng</h3>
                            <section class="row">
                                <h4 class="col-lg-3" style="font-weight: bold; color: black">(Họ và tên)&nbsp&nbsp&nbsp&nbsp&nbsp(Số điện thoại)</h4>
                                <h4 class="col-lg-6">(Địa chỉ)</h4>
                                <button type="button" class="bt" onclick="openPopupButton()"><h4>Thay đổi</h4></button>
                            </section>
                        </div>
                    </div>
                </div> 
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr class="font-0">
                                    <th style="width: 500px;">Sản phẩm</th>
                                    <th>Ảnh sản phẩm</th>
                                    <th>Số lượng</th>
                                    <th style="width: 150px;">Thành tiền</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="font-1">
                                    <td>Chuột Mickey</td>
                                    <td>Chuột</td>
                                    <td>2</td>
                                    <td>100.000</td>  
                                </tr>
                            </tbody>
                        </table>
                        <div class="table-filter">
                            <div class="container">
                                <section class="row">
                                    <div class="col-md-7" style="display: flex">
                                        <h4><input type="type" placeholder="Nhập mã giảm giá"></h4>
                                        <button type="button" class="bt"><h4>Xác nhận</h4></button>
                                    </div>
                                    <div class="col-md-5" style="display: flex; margin: auto">
                                        <div class="end">Tổng tiền (n sản phầm): </div>&nbsp&nbsp&nbsp
                                        <div class="end-n2">100.000</div>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                </div> 
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="container">
                            <h3>Hình thức thanh toán</h3>
                            <section class="row" style="text-align: center">
                            <%-- Khi chưa click vào thì để nguyên, sau khi click vào thì thêm active vào --%>
                            <a href="" class="show-entries hover-order col-lg-4">
                                <div>Thanh toán qua ngân hàng</div>
                            </a>
                            <%--
                                </a><a href="" class="show-entries hover-order col-lg-2 active">
                                    <div>Tất cả</div>
                                </a>
                            --%>
                            <a href="" class="show-entries hover-order col-lg-4">
                                <div>Thanh toán khi nhận hàng</div>
                            </a>                          
                        </section>
                    </div>
                </div>
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="container" style="display: flex">
                            <div style="margin-left: 65%">
                                <div class="end">Tổng tiền sản phẩm: </div>
                                <div class="end">Được giảm:</div> 
                                <div class="end">Tổng thanh toán: </div>
                            </div>&nbsp&nbsp&nbsp&nbsp&nbsp
                            <div>
                                <div class="end">100.000 </div>
                                <div class="end">20.000</div> 
                                <div class="end-n2">80.000 </div>
                            </div>
                        </div>
                    </div>
                </div> 
                <div class="table-responsive">
                    <div class="table-wrapper">
                        <div class="end-n3">
                            <div>Hãy kiểm tra thông tin thật kỹ trước khi bấm đặt hàng!</div>
                        </div>
                        <button class="but">Đặt hàng</button>
                    </div>
                </div> 
            </div>  

            <div class="popup" id="popupbt">
                <h2 style="font-size: 1.5rem ;">Địa chỉ mới</h2>
                <div class="row">
                    <input type="text" value="Họ và tên" class="col-lg-12" style="font-size: 1.5rem ;">
                    <input type="text" value="Số điện thoại" class="col-lg-12" style="font-size: 1.5rem ;">
                    <input type="text" value="Địa chỉ" class="col-lg-12" style="font-size: 1.5rem ;">
                    <div class="col-lg-6"> 
                        <button type="button" onclick="closePopupButton()">Lưu</button>
                    </div>
                    <div class="col-lg-6"> 
                        <button type="button" onclick="closePopupButton()">Hủy</button>
                    </div>
                </div>
            </div>
            <script>
                let popupbt = document.getElementById("popupbt");
                function openPopupButton() {
                    popupbt.classList.add("open-popup");
                }
                function closePopupButton() {
                    popupbt.classList.remove("open-popup");
                }
                document.querySelectorAll('.show-entries').forEach(item => {

                    item.addEventListener('click', event => {

                        document.querySelector('.active').classList.remove('active');

                        event.target.classList.add('active');

                    });

                });
            </script>
            <!-- footer -->
            <jsp:include page="footer.jsp"></jsp:include>
            <!-- end footer -->
    </body>
</html>