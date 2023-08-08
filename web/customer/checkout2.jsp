<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thanh toán</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&amp;display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/cart.css">
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
        <!--end header nav -->

        <!-- score-top-->

        <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-down"></i></button>
        <!-- cart -->
        <main role="main" style="margin-bottom: 20px">
            <!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là content -->
            <div class="container mt-4" style="font-size: 300px; padding-top: 15px">
                <form class="needs-validation" name="frmthanhtoan" method="post"
                      action="#">
                    <input type="hidden" name="kh_tendangnhap" value="dnpcuong">

                    <div style="text-align: center">
                        <h1 style="font-size: 50px; font-weight: bold;">THANH TOÁN</h1>
                        <h3 class="lead" style="font-size: 20px; padding-top: 15px; padding-bottom: 15px">Vui lòng kiểm tra thông tin khách hàng, thông tin giỏ hàng trước khi thanh toán.</h3>
                    </div>

                    <div class="row">
                        <div class="col-md-4 order-md-2 mb-4">
                            <h4 class="d-flex justify-content-between align-items-center mb-3">
                                <span class="text-muted" style="font-size: 30px">GIỎ HÀNG</span>
                                <span class="badge badge-secondary badge-pill" style="background-color: #ff3333;"><a href="listCart.jsp" class="col-lg-1 col-md-1 col-sm-0 header__cart">
                                        <div class="header__cart-icon-wrap">
                                            <span class="header__notice">4</span>
                                            <i class="fas fa-shopping-cart header__nav-cart-icon"></i>
                                        </div>
                                    </a>
                                </span>
                            </h4>
                            <ul class="list-group mb-3">
                                <input type="hidden" name="sanphamgiohang[1][sp_ma]" value="2">
                                <input type="hidden" name="sanphamgiohang[1][gia]" value="11800000.00">
                                <input type="hidden" name="sanphamgiohang[1][soluong]" value="2">

                                <li class="list-group-item d-flex justify-content-between lh-condensed">
                                    <div>
                                        <h6 class="my-0">Apple Ipad 4 Wifi 16GB</h6>
                                        <small class="text-muted">11800000.00 x 2</small>
                                    </div>
                                    <span class="text-muted">23600000</span>
                                </li>
                                <input type="hidden" name="sanphamgiohang[2][sp_ma]" value="4">
                                <input type="hidden" name="sanphamgiohang[2][gia]" value="14990000.00">
                                <input type="hidden" name="sanphamgiohang[2][soluong]" value="8">

                                <li class="list-group-item d-flex justify-content-between lh-condensed">
                                    <div>
                                        <h6 class="my-0">Apple iPhone 5 16GB White</h6>
                                        <small class="text-muted">14990000.00 x 8</small>
                                    </div>
                                    <span class="text-muted">119920000</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between">
                                    <span>Tổng thành tiền</span>
                                    <strong>143520000</strong>
                                </li>
                            </ul>


                            <div class="input-group">
                                <input type="text" class="form-control" style="font-size: 20px" placeholder="Mã khuyến mãi">
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-secondary" style="background-color: #ff3333;"><h1 style="font-size: 10px">Xác nhận</h1></button>
                                </div>

                            </div>

                        </div>
                        <div class="col-md-8 order-md-1">
                            <h4 class="mb-3" style="font-size: 30px">THÔNG TIN KHÁCH HÀNG</h4>

                            <div class="row">
                                <div class="col-md-12">
                                    <label for="kh_ten">Họ tên</label>
                                    <input type="text" style="font-size: 1.8rem;" class="form-control">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_gioitinh">Giới tính</label>
                                    <input type="text" style="font-size: 1.8rem;" class="form-control">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_diachi">Địa chỉ</label>
                                    <input type="text" style="font-size: 1.8rem;" class="form-control">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_dienthoai">Điện thoại</label>
                                    <input type="text" style="font-size: 1.8rem;" class="form-control">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_email">Email</label>
                                    <input type="email" style="font-size: 1.8rem;" class="form-control">
                                </div>
                            </div>

                            <h4 class="mb-3" style="margin-top: 15px">Hình thức thanh toán</h4>

                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input id="httt-1" name="httt_ma" type="radio" class="custom-control-input" required=""
                                           value="1">
                                    <label class="custom-control-label" for="httt-1">Tiền mặt</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="httt-2" name="httt_ma" type="radio" class="custom-control-input" required=""
                                           value="2">
                                    <label class="custom-control-label" for="httt-2">Chuyển khoản</label>
                                </div>                             
                            </div>
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block" style="font-size: 20px; background-color:#ff3333" type="submit" name="btnDatHang">Đặt hàng
                        </div>                              
                    </div>
            </div>
        </div>
    </form>

</div>
<!-- End block content -->
</main>
<!--end cart -->

<!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>
<!-- end footer -->
<script src="js/jq.js"></script>

</body></html>