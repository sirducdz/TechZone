<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .dropbtn {
            background-color: #ef2317;
            color: white;
            padding: 16px;
            font-family: Roboto;
            border: none;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: white;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 16px 16px;
            text-decoration: none;
            display: block;
            font-size: 1.3rem;
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
<header id="header">
    <!-- header top -->
    <div class="header__top">
        <div class="container">
            <section class="row flex">
                <div class="col-lg-5 col-md-0 col-sm-0 heade__top-left">
                    <span>TECHZONE - LỰA CHỌN ĐỂ VƯƠN XA</span>
                </div>
                <nav class="col-lg-7 col-md-0 col-sm-0 header__top-right">
                    <ul class="header__top-list">
                        <li class="header__top-item">
                            <a href="#" class="header__top-link">Giỏ hàng</a>
                        </li>
<!--                        <li class="header__top-item">
                            <a href="#" class="header__top-link">Thanh toán</a>
                        </li>-->
                        <li class="header__top-item">
                            <a href="#" class="header__top-link"></a>
                        </li>
                        <li class="header__top-item">
                            <div class="dropdown fas fa-user header__nav-cart-icon">
                                <div class="dropdown-content">
                                    <a href="#">Thông tin cá nhân</a>
                                    <a href="#">Đơn hàng của tôi</a>
                                    <a href="#">Đăng xuất</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </nav>
            </section>
        </div>
    </div>
    <!--end header top -->

    <!-- header bottom -->
    <div class="header__bottom">
        <div class="container">
            <section class="row">
                <div class="col-lg-3 col-md-4 col-sm-12 header__logo">
                    <h1 class="header__heading">
                        <a href="homepage.jsp" class="header__logo-link">
                            <img src="images1/logo1.png" alt="Logo" class="header__logo-img">
                        </a>
                    </h1>
                </div>

                <div class="col-lg-6 col-md-7 col-sm-0 header__search">
                    <input type="text" class="header__search-input" placeholder="Tìm kiếm tại đây...">
                    <button class="header__search-btn">
                        <div class="header__search-icon-wrap">
                            <i class="fas fa-search header__search-icon"></i>
                        </div>
                    </button>
                </div>

                <div class="col-lg-2 col-md-0 col-sm-0 header__call">
                    <div class="header__call-icon-wrap">
                        <i class="fas fa-phone-alt header__call-icon"></i>  
                    </div>
                    <div class="header__call-info">
                        <div class="header__call-text">
                            Tư vấn khách hàng
                        </div>
                        <div class="header__call-number">
                            039.882.3232
                        </div>
                    </div>
                </div>

                <a href="listCart.jsp" class="col-lg-1 col-md-1 col-sm-0 header__cart">
                    <div class="header__cart-icon-wrap">
                        <span class="header__notice">4</span>
                        <i class="fas fa-shopping-cart header__nav-cart-icon"></i>
                    </div>
                </a>
            </section>
        </div>   
    </div>
    <!--end header bottom -->

    <!-- header nav -->
    <div class="header__nav">
        <div class="container">
            <section class="row">
                <div class="header__nav-menu-wrap col-lg-3 col-md-0 col-sm-0">
                    <i class="fas fa-bars header__nav-menu-icon"></i>
                    <div class="header__nav-menu-title">Danh mục sản phẩm</div>
                </div>

                <div class="header__nav col-lg-9 col-md-0 col-sm-0">
                    <ul class="header__nav-list">
                        <li class="header__nav-item">
                            <a href="homepage.jsp" class="header__nav-link">TRANG CHỦ</a>
                        </li>
                        <li class="header__nav-item">
                            <a href="listProduct.jsp" class="header__nav-link">SẢN PHẨM</a>
                        </li>
                        <li class="header__nav-item">
                            <a href="compareProduct.jsp" class="header__nav-link">SO SÁNH SẢN PHẨM</a>
                        </li>  
                        <li class="header__nav-item">
                            <a href="checkout2.jsp" class="header__nav-link">THANH TOÁN</a>
                        </li>               
                        <li class="header__nav-item">
                            <a href="contact.jsp" class="header__nav-link">LIÊN HỆ</a>
                        </li>
                    </ul>
                </div>
            </section>
        </div>
    </div>
</header>
<!--end header nav -->