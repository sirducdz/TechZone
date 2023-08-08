<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <link rel="stylesheet" href="css/category.css">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: Roboto;
                font-size: 13px;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
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
            .table-wrapper .btn:hover {
                color: #333;
                background: #f2f2f2;
            }
            .table-wrapper .btn.btn-primary {
                color: #fff;
                background: #03A9F4;
            }
            .table-wrapper .btn.btn-primary:hover {
                background: #03a3e7;
            }
            .table-title .btn {
                font-size: 13px;
                border: none;
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
                background: #4b5366;
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
                font-size: 13px;
            }
        </style>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- end header -->
            <!-- score-top-->
            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></button>                        
            <!-- product -->
            <section class="menu-slide">
                <div class="container">
                    <div class="row">
                        <nav class="menu__nav col-lg-3 col-md-12 col-sm-0">
                            <ul class="menu__list">
                                <li class="menu__item">
                                    <a href="headphone.jsp" class="menu__link">
                                        <img src="images1/item/headphone.jpg" alt=""  class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Tai nghe</a>
                                </li>
                                <li class="menu__item">
                                    <a href="mouse.jsp" class="menu__link">
                                        <img src="images1/item/mouse.jpg" alt="" class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Chuột</a>
                                </li>

                                <li class="menu__item menu__item--active">
                                    <a href="keyboard.jsp" class="menu__link">
                                        <img src="images1/item/keyboard.jpg" alt="" class="menu__item-icon"  viewBox="0 0 512 512" width="1012" height="512">

                                        Bàn phím</a>
                                </li>

                            </ul>
                        </nav>
                    </div>
                </div>
            </section>
            <section  id ='category3'class="product__love">
                <div class="container">
                    <div class="row bg-white">
                        <div class="col-lg-10 col-md-10 col-sm-10 product__love-title">
                            <h2 class="product__love-heading upper">
                                Bàn phím 
                            </h2>
                        </div>
                        <div class="col-lg-2 col-md-2 col-sm-2 product__love-title">
                            <div class="show-entries">
                                <select style="font-size: 15px;">
                                    <option>Bán chạy nhất</option>
                                    <option>Giá giảm dần</option>
                                    <option>Giá tăng dần</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12 product__love-title">
                            <div class="show-entries">
                                <label class="hint-text" style="margin-right: 3px;">Hiển thị </label>
                                <select class="form-control" style="font-size: 15px;">
                                    <option>5</option>
                                    <option>10</option>
                                    <option>15</option>
                                    <option>20</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row bg-white">

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/product/p1.jpg" alt="" class="product__panel-img">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Bàn phím cơ AKKO 5075B Plus Dragon Ball Super Goku</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div>  

                            <!-- <div class="product__panel-price-sale-off">
                                -10%
                            </div>  -->
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/product/p2.jpg" alt="" class="product__panel-img">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Bàn phím cơ AKKO 5075B Plus Naruto</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <!-- <div class="product__panel-price-sale-off">
                                -10%
                            </div>  -->
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/product/p5.jpg" alt="" class="product__panel-img">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Bàn phím cơ AKKO PC98B Plus Black Gold</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <div class="product__panel-price-sale-off">
                                -10%
                            </div> 
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/product/p4.jpg" alt="" class="product__panel-img">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Bàn phím cơ AKKO 3068B Black Pink</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 ">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div>

                            <div class="product__panel-price-sale-off">
                                -10%
                            </div> 
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/product/p3.jpg" alt="" class="product__panel-img" >
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Bàn phím cơ AKKO PC98B Plus Black Gold</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 ">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <div class="product__panel-price-sale-off">
                                -15%
                            </div> 
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/product/p6.jpg" alt="" class="product__panel-img" >
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Bàn phím cơ AKKO 3068B Plus Prunus Lannesiana
                                </a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <!-- <div class="product__panel-price-sale-off">
                                -10%
                            </div>  -->
                        </div>
                    </div>
                    <div class="clearfix">
                        <div class="hint-text" style="font-size: 15px;">Hiển thị <b>5</b> trong số <b>25</b> sản phẩm</div>
                        <ul class="pagination">
                        <%--<c:set var="active" value="active"> </c:set>--%>
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item ${active}"><a href="#" class="page-link">3</a></li>
                        <li class="page-item ${active}"><a href="#" class="page-link">4</a></li>
                        <li class="page-item ${active}"><a href="#" class="page-link">5</a></li>
                        <li class="page-item ${active}"><a href="#" class="page-link">6</a></li>
                        <li class="page-item ${active}" ><a href="#" class="page-link">7</a></li>
                        <li class="page-item active"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- end footer -->
        <!-- scroll to top -->
        <!-- score-top-->

        <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></i></button>
    <!--  -->

    <script src="js/jq.js"></script>
    <script src="js/category.js"></script>
</body>
</html>