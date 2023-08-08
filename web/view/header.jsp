<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form method="post" action="ProductListController?tab=${tab}" >
    <header id="header">
        <style>
            .dropbtn {
                background-color: #ef2317;
                color: white;
                padding: 16px;
                font-size: 16px;
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
        <!-- header top -->

        <div class="header__top">
            <div class="container">
                <section class="row flex">
                    <div class="col-lg-5 col-md-0 col-sm-0 heade__top-left">
                        <span>TECHZONE - LỰA CHỌN ĐỂ VƯƠN XA</span>
                    </div>
                    <nav class="col-lg-7 col-md-0 col-sm-0 header__top-right">
                        <c:if test="${role==null}" >
                            <ul class="header__top-list">
                                <li class="header__top-item">
                                    <a href="${user!=null?'CartController?tab=cartList':'../auth/login'}" class="header__top-link">Giỏ hàng</a>
                                </li>
                                <!--                                <li class="header__top-item">
                                                                    <a href="${user!=null?'OrderListController':'../auth/login'}" class="header__top-link">Đơn Hàng Của Tôi</a>
                                                                </li>-->
                                <!--                                <li class="header__top-item">
                                                                    <a href="../auth/login" class="header__top-link">Thanh toán</a>
                                                                </li>-->
                                <li class="header__top-item">
                                    <a href="../auth/login" class="header__top-link">Đăng nhập</a>
                                </li>
                            </ul>
                        </c:if>
                        <c:if test="${role!=null}" >
                            <ul class="header__top-list">
                                <li class="header__top-item">
                                    <a href="CartController?tab=cartList" class="header__top-link">Giỏ hàng</a>
                                </li>
                                <!--                                <li class="header__top-item">
                                                                    <a href="#" class="header__top-link">Thanh toán</a>
                                                                </li>-->
                                <li class="header__top-item">
                                    <a href="${user!=null?'OrderListController':'../auth/login'}" class="header__top-link">Đơn Hàng </a>
                                </li>
                                <li class="header__top-item">
                                    <a class="header__top-link"></a>
                                </li>
                                <li class="header__top-item">
                                    <div class="dropdown fas fa-user header__nav-cart-icon">
                                        <div class="dropdown-content">
                                            <a href="EditCustomerController">Hồ sơ cá nhân</a>
                                            <a href="../auth/ChangePassword?tab=changePassword">Đổi mật khẩu</a>
                                            <c:if test="${role==1}">
                                                <a href="../admin/AdminIncomeController">Admin</a>
                                            </c:if>
                                            <c:if test="${role==2}">
                                                <a href="../manager/ManagerIncomeController">Manager</a>
                                            </c:if>                                          
                                            <c:if test="${role==4}">
                                                <a href="../saler/SalerOrderController">Saler</a>
                                            </c:if>
                                            <a href="HomePageController?tab=logOut">Đăng xuất</a>

                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </c:if>
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
                            <a href="HomePageController?tab=homepage" class="header__logo-link">
                                <img src="images1/logo1.png" alt="Logo" class="header__logo-img">
                            </a>
                        </h1>
                    </div>

                    <!--<form action="ProductListController?tab=allproduct" method="get" >-->
                    <div class="col-lg-6 col-md-7 col-sm-0 header__search">

                        <input type="text" name="searchInput" class="header__search-input" placeholder="Tìm kiếm tại đây...">

                        <button class="header__search-btn" name="searchSubmit" value="submit">
                            <!--<a class="header__search-btn" href="#">--> 
                            <div class="header__search-icon-wrap">
                                <i class="fas fa-search header__search-icon"></i>
                            </div>
                            <!--</a>-->
                        </button>


                    </div>
                    <!--</form>-->
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

                    <a href="${user!=null?'CartController?tab=cartList':'../auth/login'}" class="col-lg-1 col-md-1 col-sm-0 header__cart">
                        <div class="header__cart-icon-wrap">
                            <span class="header__notice">${((user!=null)&&(AmountOfProductType!=null))?AmountOfProductType:'0'}</span>
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
                                <a href="HomePageController?tab=homepage" class="header__nav-link">TRANG CHỦ</a>
                            </li>
                            <li class="header__nav-item">
                                <!--<a href="listProduct.jsp" class="header__nav-link">SẢN PHẨM</a>-->
                                <a href="ProductListController?tab=allProduct" class="header__nav-link">SẢN PHẨM</a>
                            </li>
                            <li class="header__nav-item">
                                <a href="compareProduct.jsp" class="header__nav-link">SO SÁNH SẢN PHẨM</a>
                            </li>  
                            <!--                            <li class="header__nav-item">
                                                            <a href="checkout2.jsp" class="header__nav-link">THANH TOÁN</a>
                                                        </li>               -->
                            <li class="header__nav-item">
                                <a href="contact.jsp" class="header__nav-link">LIÊN HỆ</a>
                            </li>
                        </ul>
                    </div>
                </section>
            </div>
        </div>

    </header>
</form>
<!--end header nav -->