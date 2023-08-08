<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TechZone</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/productlist.css">
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
            <section class="menu-slide">
                <div class="container">
                    <div class="row">
                        <nav class="menu__nav col-lg-3 col-md-12 col-sm-0">
                            <ul class="menu__list">
                            <c:if test="${tab=='headphone' || tab=='allProduct'}">
                                <li class="menu__item menu__item--active">
                                    <a href="ProductListController?tab=headphone" class="menu__link">
                                        <img src="images1/item/headphone.jpg" alt=""  class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Tai nghe</a>
                                </li>
                            </c:if>
                            <c:if test="${tab!='headphone'&&tab!='allProduct'}"> 
                                <li class="menu__item">
                                    <a href="ProductListController?tab=headphone" class="menu__link">
                                        <img src="images1/item/headphone.jpg" alt=""  class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Tai nghe</a>
                                </li>
                            </c:if>
                            <c:if test="${tab=='mouse' || tab=='allProduct'}">
                                <li class="menu__item menu__item--active">
                                    <a href="ProductListController?tab=mouse" class="menu__link">
                                        <img src="images1/item/mouse.jpg" alt="" class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Chuột</a>
                                </li>
                            </c:if>
                            <c:if test="${tab!='mouse' &&tab!='allProduct'}">
                                <li class="menu__item">
                                    <a href="ProductListController?tab=mouse" class="menu__link">
                                        <img src="images1/item/mouse.jpg" alt="" class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Chuột</a>
                                </li>
                            </c:if> 
                            <c:if test="${tab=='keyboard' || tab=='allProduct'}">
                                <li class="menu__item menu__item--active">
                                    <a href="ProductListController?tab=keyboard" class="menu__link">
                                        <img src="images1/item/keyboard.jpg" alt="" class="menu__item-icon"  viewBox="0 0 512 512" width="1012" height="512">

                                        Bàn phím</a>
                                </li>
                            </c:if>
                            <c:if test="${tab!='keyboard' &&tab!='allProduct'}">
                                <li class="menu__item">
                                    <a href="ProductListController?tab=keyboard" class="menu__link">
                                        <img src="images1/item/keyboard.jpg" alt="" class="menu__item-icon"  viewBox="0 0 512 512" width="1012" height="512">

                                        Bàn phím</a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </section>

        <!-- category 1: tai nghe -->
        <form method="post" action="ProductListController?tab=${tab}" id="formm1">  
            <c:if test="${tab=='allProduct'||tab=='headphone'}">
                <c:set var="category1" value="category1"></c:set>
                <section id ='${category1}' class="product__love">
                    <div class="container">
                        <div class="row bg-white">
                            <div class="col-lg-10 col-md-10 col-sm-10 product__love-title">
                                <h2 class="product__love-heading upper">
                                    Tai Nghe  
                                </h2>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 product__love-title">
                                <div class="show-entries">
                                    <c:if test="${(headPhonesortOrder==null)||(headPhonesortOrder=='rate')}">
                                        <select name="headPhonesortOrder" style="font-size: 15px;"  onchange="changeHeadPhone()">
                                            <option value="rate" selected>Bán chạy nhất</option>
                                            <option value="descendingSalePrice">Giá giảm dần</option>
                                            <option value="ascendingSalePrice">Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${headPhonesortOrder=='descendingSalePrice'}">
                                        <select name="headPhonesortOrder" style="font-size: 15px;"  onchange="changeHeadPhone()">
                                            <option value="rate">Bán chạy nhất</option>
                                            <option value="descendingSalePrice" selected>Giá giảm dần</option>
                                            <option value="ascendingSalePrice">Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${headPhonesortOrder=='ascendingSalePrice'}">
                                        <select style="font-size: 15px;" name="headPhonesortOrder" onchange="changeHeadPhone()">
                                            <option value="rate">Bán chạy nhất</option>
                                            <option value="descendingSalePrice">Giá giảm dần</option>
                                            <option value="ascendingSalePrice" selected>Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <%--<c:if test="${sortOrder=='rate'}">--%>
                                    <!--                                        <select style="font-size: 15px;" name="sortOrder" onchange="change()">
                                                                                <option value="rate">Bán chạy nhất</option>
                                                                                <option value="descendingSalePrice">Giá giảm dần</option>
                                                                                <option value="ascendingSalePrice">Giá tăng dần</option>
                                                                                <option value="rate" selected>Đánh Giá Cao Nhất</option>
                                                                            </select>-->
                                    <%--</c:if>--%>
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 product__love-title">
                                <div class="show-entries">
                                    <label class="hint-text" style="margin-right: 3px;">Hiển thị </label>
                                    <c:if test="${headPhoneamountElementInPage==6}">
                                        <select class="form-control" style="font-size: 15px;" name="headPhoneamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18">18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${headPhoneamountElementInPage==12}">
                                        <select class="form-control" style="font-size: 15px;" name="headPhoneamountElementInPage">
                                            <option value="6" >6</option>
                                            <option value="12" selected>12</option>
                                            <option value="18">18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${headPhoneamountElementInPage==18}">
                                        <select class="form-control" style="font-size: 15px;" name="headPhoneamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18" selected>18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${headPhoneamountElementInPage==24}">
                                        <select class="form-control" style="font-size: 15px;" name="headPhoneamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18">18</option>
                                            <option value="24" selected>24</option>
                                        </select>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                        <div class="row bg-white">
                            <c:if test="${headPhonepageAmount>0}">
                                <c:set var="i" value="${(headPhonepageIndex-1)*headPhoneamountElementInPage}"></c:set>
                                <c:set var="end" value="${headPhonepageIndex*headPhoneamountElementInPage-1}"></c:set>
                                <c:set var="countDisplayElement" value="0"></c:set>
                                <c:forEach begin="${i}" end="${end}" >
                                    <c:if test="${i<headPhoneData.size()}">
                                        <c:set var="countDisplayElement" value="${countDisplayElement+1}"></c:set>
                                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                                <div class="product__panel-img-wrap">
                                                    <a href="ProductDetailController?ProductID=${headPhoneData.get(i).getProductID()}"> <img src="${headPhoneData.get(i).getPicture()}" class="product__panel-img"></a>
                                            </div>
                                            <h3 class="product__panel-heading">
                                                <a href="ProductDetailController?ProductID=${headPhoneData.get(i).getProductID()}"  class="product__panel-link">${headPhoneData.get(i).getName()}</a>
                                            </h3>                       
                                            <div class="product__panel-rate-wrap">
                                                <i class="product__panel-rate" style="text-decoration: underline;font-size: 20px; margin-right: 5px">${headPhoneData.get(i).getRateStar()}</i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                            </div>
                                            <div class="product__panel-price">
                                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                                    <div>    
                                                        <!--<button class="bestselling__product-btn">So sánh</button>-->
                                                        <a href="CompareProductController?productID=${headPhoneData.get(i).getProductID()}" class="bestselling__product-btn">So sánh</a>
                                                    </div>
                                                </span>
                                                <span class="product__panel-price-current">
                                                    <button href="compareProduct.jsp" class="bestselling__product-btn">${headPhoneData.get(i).getSalePrice()}đ</button>
                                                </span>
                                            </div>
                                            <c:if test="${headPhoneData.get(i).getSale()>0}">
                                                <div class="product__panel-price-sale-off">
                                                    -${headPhoneData.get(i).getSale()}%
                                                </div>
                                            </c:if>

                                        </div>
                                    </c:if>
                                    <c:set var="i" value="${i+1}"></c:set>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="clearfix">
                            <c:if test="${headPhonepageAmount>0}">
                                <div class="hint-text" style="font-size: 15px;">Hiển thị ${countDisplayElement} trong số ${headPhoneData.size()} sản phẩm</div>
                                <ul class="pagination">
                                    <%--<c:set var="active" value="active"> </c:set>--%>
                                    <c:set var="count" value="1"></c:set>
                                    <c:if test="${headPhonepageIndex!=1}">
                                        <li class="page-item disabled"><a onclick="Paging('${headPhonepageIndex-1}', '${category1}')" id="${headPhonepageIndex-1}" href="ProductListController?tab=${tab}&headPhonepageIndex=${headPhonepageIndex-1}" >Previous</a></li>
                                        </c:if>
                                        <c:forEach begin="${count}" end="${headPhonepageAmount}">
                                            <c:if test="${headPhonepageIndex==count}">
                                            <li class="page-item active"><a onclick="Paging('${count}', '${category1}')"  id="${count}" href="ProductListController?tab=${tab}&headPhonepageIndex=${count}" class="page-link" >${count}</a></li>
                                            </c:if>
                                            <c:if test="${headPhonepageIndex!=count}">
                                            <li class="page-item"><a onclick="Paging('${count}', '${category1}')"  id="${count}" href="ProductListController?tab=${tab}&headPhonepageIndex=${count}" class="page-link" >${count}</a></li>
                                            </c:if>
                                            <c:set var="count" value="${count+1}"></c:set>
                                        </c:forEach>
                                        <c:if test="${headPhonepageIndex!=headPhonepageAmount}">
                                        <li class="page-item disabled"><a onclick="Paging('${headPhonepageIndex+1}', '${category1}')"  id="${headPhonepageIndex+1}" href="ProductListController?tab=${tab}&headPhonepageIndex=${headPhonepageIndex+1}" >Next</a></li>
                                        </c:if>
                                    <!--<li class="page-item active"><a href="#" class="page-link">Next</a></li>-->
                                </ul>
                            </c:if>
                        </div>
                    </div>
                </section>
            </c:if>
        </form>
        <!-- category 2: chuột-->
        <form method="post" action="ProductListController?tab=${tab}" id="formm2">
            <c:if test="${tab=='allProduct'||tab=='mouse'}">
                <c:set var="category2" value="category2"></c:set>
                <section id ="${category2}" class="product__love">
                    <div class="container">
                        <div class="row bg-white">
                            <div class="col-lg-10 col-md-10 col-sm-10 product__love-title">
                                <h2 class="product__love-heading upper">
                                    Chuột 
                                </h2>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 product__love-title">
                                <div class="show-entries">
                                    <c:if test="${(mousesortOrder==null)||(mousesortOrder=='rate')}">
                                        <select name="mousesortOrder" style="font-size: 15px;"  onchange="changeMouse()">
                                            <option value="rate" selected>Bán chạy nhất</option>
                                            <option value="descendingSalePrice">Giá giảm dần</option>
                                            <option value="ascendingSalePrice">Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${mousesortOrder=='descendingSalePrice'}">
                                        <select name="mousesortOrder" style="font-size: 15px;"  onchange="changeMouse()">
                                            <option value="rate">Bán chạy nhất</option>
                                            <option value="descendingSalePrice" selected>Giá giảm dần</option>
                                            <option value="ascendingSalePrice">Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${mousesortOrder=='ascendingSalePrice'}">
                                        <select style="font-size: 15px;" name="mousesortOrder" onchange="changeMouse()">
                                            <option value="rate">Bán chạy nhất</option>
                                            <option value="descendingSalePrice">Giá giảm dần</option>
                                            <option value="ascendingSalePrice" selected>Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <%--<c:if test="${sortOrder=='rate'}">--%>
                                    <!--                                        <select style="font-size: 15px;" name="sortOrder" onchange="change()">
                                                                                <option value="rate">Bán chạy nhất</option>
                                                                                <option value="descendingSalePrice">Giá giảm dần</option>
                                                                                <option value="ascendingSalePrice">Giá tăng dần</option>
                                                                                <option value="rate" selected>Đánh Giá Cao Nhất</option>
                                                                            </select>-->
                                    <%--</c:if>--%>
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 product__love-title">
                                <div class="show-entries">
                                    <label class="hint-text" style="margin-right: 3px;">Hiển thị </label>
                                    <c:if test="${mouseamountElementInPage==6}">
                                        <select class="form-control" style="font-size: 15px;" name="mouseamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18">18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${mouseamountElementInPage==12}">
                                        <select class="form-control" style="font-size: 15px;" name="mouseamountElementInPage">
                                            <option value="6" >6</option>
                                            <option value="12" selected>12</option>
                                            <option value="18">18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${mouseamountElementInPage==18}">
                                        <select class="form-control" style="font-size: 15px;" name="mouseamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18" selected>18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${mouseamountElementInPage==24}">
                                        <select class="form-control" style="font-size: 15px;" name="mouseamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18">18</option>
                                            <option value="24" selected>24</option>
                                        </select>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                        <div class="row bg-white">
                            <c:if test="${mousepageAmount>0}"> 
                                <c:set var="i" value="${(mousepageIndex-1)*mouseamountElementInPage}"></c:set>
                                <c:set var="end" value="${mousepageIndex*mouseamountElementInPage-1}"></c:set>
                                <c:set var="countDisplayElement" value="0"></c:set>
                                <c:forEach begin="${i}" end="${end}" >
                                    <c:if test="${i<mouseData.size()}">
                                        <c:set var="countDisplayElement" value="${countDisplayElement+1}"></c:set>
                                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                                <div class="product__panel-img-wrap">
                                                    <a href="ProductDetailController?ProductID=${mouseData.get(i).getProductID()}"> <img src="${mouseData.get(i).getPicture()}" class="product__panel-img"></a>
                                            </div>
                                            <h3 class="product__panel-heading">
                                                <a href="ProductDetailController?ProductID=${mouseData.get(i).getProductID()}"  class="product__panel-link">${mouseData.get(i).getName()}</a>
                                            </h3>                       
                                            <div class="product__panel-rate-wrap">
                                                <i class="product__panel-rate" style="text-decoration: underline;font-size: 20px; margin-right: 5px">${mouseData.get(i).getRateStar()}</i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                            </div>
                                            <div class="product__panel-price">
                                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                                    <div>    
                                                        <button class="bestselling__product-btn">So sánh</button>
                                                    </div>
                                                </span>
                                                <span class="product__panel-price-current">
                                                    <button href="compareProduct.jsp" class="bestselling__product-btn">${mouseData.get(i).getSalePrice()}đ</button>
                                                </span>
                                            </div>
                                            <c:if test="${mouseData.get(i).getSale()>0}">
                                                <div class="product__panel-price-sale-off">
                                                    -${mouseData.get(i).getSale()}%
                                                </div>
                                            </c:if>

                                        </div>
                                    </c:if>
                                    <c:set var="i" value="${i+1}"></c:set>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="clearfix">
                            <c:if test="${mousepageAmount>0}">
                                <div class="hint-text" style="font-size: 15px;">Hiển thị ${countDisplayElement} trong số ${mouseData.size()} sản phẩm</div>
                                <ul class="pagination">
                                    <%--<c:set var="active" value="active"> </c:set>--%>
                                    <c:set var="count" value="1"></c:set>
                                    <c:if test="${mousepageIndex!=1}">
                                        <li class="page-item disabled"><a onclick="Paging('m${mousepageIndex-1}', '${category2}')" id="m${mousepageIndex-1}" href="ProductListController?tab=${tab}&mousepageIndex=${mousepageIndex-1}">Previous</a></li>
                                        </c:if>
                                        <c:forEach begin="${count}" end="${mousepageAmount}">
                                            <c:if test="${mousepageIndex==count}">
                                            <li class="page-item active"><a onclick="Paging('m${count}', '${category2}')" id="m${count}" href="ProductListController?tab=${tab}&mousepageIndex=${count}" class="page-link">${count}</a></li>
                                            </c:if>
                                            <c:if test="${mousepageIndex!=count}">
                                            <li class="page-item"><a onclick="Paging('m${count}', '${category2}')" id="m${count}" href="ProductListController?tab=${tab}&mousepageIndex=${count}" class="page-link">${count}</a></li>
                                            </c:if>
                                            <c:set var="count" value="${count+1}"></c:set>
                                        </c:forEach>
                                        <c:if test="${mousepageIndex!=mousepageAmount}">
                                        <li class="page-item disabled"><a onclick="Paging('m${mousepageIndex+1}', '${category2}')" id="m${mousepageIndex-1}" href="ProductListController?tab=${tab}&mousepageIndex=${mousepageIndex+1}">Next</a></li>
                                        </c:if>
                                    <!--<li class="page-item active"><a href="#" class="page-link">Next</a></li>-->
                                </ul>
                            </c:if>
                        </div>
                    </div>
                </section>
            </c:if>
        </form> 
        <!-- category 3: bàn phím -->
        <form method="post" action="ProductListController?tab=${tab}" id="formm3">
            <c:if test="${tab=='allProduct'||tab=='keyboard'}">
                <c:set var="category3" value="category3"></c:set>
                <section id ='${category3}' class="product__love">
                    <div class="container">
                        <div class="row bg-white">
                            <div class="col-lg-10 col-md-10 col-sm-10 product__love-title">
                                <h2 class="product__love-heading upper">
                                    Bàn phím 
                                </h2>
                            </div>
                            <div class="col-lg-2 col-md-2 col-sm-2 product__love-title">
                                <div class="show-entries">
                                    <c:if test="${(keyboardsortOrder==null)||(keyboardsortOrder=='rate')}">
                                        <select name="keyboardsortOrder" style="font-size: 15px;"  onchange="changeKeyboard()">
                                            <option value="rate" selected>Bán chạy nhất</option>
                                            <option value="descendingSalePrice">Giá giảm dần</option>
                                            <option value="ascendingSalePrice">Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${keyboardsortOrder=='descendingSalePrice'}">
                                        <select name="keyboardsortOrder" style="font-size: 15px;"  onchange="changeKeyboard()">
                                            <option value="rate">Bán chạy nhất</option>
                                            <option value="descendingSalePrice" selected>Giá giảm dần</option>
                                            <option value="ascendingSalePrice">Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${keyboardsortOrder=='ascendingSalePrice'}">
                                        <select style="font-size: 15px;" name="keyboardsortOrder" onchange="changeKeyboard()">
                                            <option value="rate">Bán chạy nhất</option>
                                            <option value="descendingSalePrice">Giá giảm dần</option>
                                            <option value="ascendingSalePrice" selected>Giá tăng dần</option>
                                            <option value="rate">Đánh Giá Cao Nhất</option>
                                        </select>
                                    </c:if>
                                    <%--<c:if test="${sortOrder=='rate'}">--%>
                                    <!--                                        <select style="font-size: 15px;" name="sortOrder" onchange="change()">
                                                                                <option value="rate">Bán chạy nhất</option>
                                                                                <option value="descendingSalePrice">Giá giảm dần</option>
                                                                                <option value="ascendingSalePrice">Giá tăng dần</option>
                                                                                <option value="rate" selected>Đánh Giá Cao Nhất</option>
                                                                            </select>-->
                                    <%--</c:if>--%>
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 product__love-title">
                                <div class="show-entries">
                                    <label class="hint-text" style="margin-right: 3px;">Hiển thị </label>
                                    <c:if test="${keyboardamountElementInPage==6}">
                                        <select class="form-control" style="font-size: 15px;" name="keyboardamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18">18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${keyboardamountElementInPage==12}">
                                        <select class="form-control" style="font-size: 15px;" name="keyboardamountElementInPage">
                                            <option value="6" >6</option>
                                            <option value="12" selected>12</option>
                                            <option value="18">18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${keyboardamountElementInPage==18}">
                                        <select class="form-control" style="font-size: 15px;" name="keyboardamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18" selected>18</option>
                                            <option value="24">24</option>
                                        </select>
                                    </c:if>
                                    <c:if test="${keyboardamountElementInPage==24}">
                                        <select class="form-control" style="font-size: 15px;" name="keyboardamountElementInPage">
                                            <option value="6" selected>6</option>
                                            <option value="12">12</option>
                                            <option value="18">18</option>
                                            <option value="24" selected>24</option>
                                        </select>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                        <div class="row bg-white">
                            <c:if test="${keyboardpageAmount>0}"> 
                                <c:set var="i" value="${(keyboardpageIndex-1)*keyboardamountElementInPage}"></c:set>
                                <c:set var="end" value="${keyboardpageIndex*keyboardamountElementInPage-1}"></c:set>
                                <c:set var="countDisplayElement" value="0"></c:set>
                                <c:forEach begin="${i}" end="${end}" >
                                    <c:if test="${i<keyboardData.size()}">
                                        <c:set var="countDisplayElement" value="${countDisplayElement+1}"></c:set>
                                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                                <div class="product__panel-img-wrap">
                                                    <a href="ProductDetailController?ProductID=${keyboardData.get(i).getProductID()}"> <img src="${keyboardData.get(i).getPicture()}" class="product__panel-img"></a>
                                            </div>
                                            <h3 class="product__panel-heading">
                                                <a href="ProductDetailController?ProductID=${keyboardData.get(i).getProductID()}"  class="product__panel-link">${keyboardData.get(i).getName()}</a>
                                            </h3>                       
                                            <div class="product__panel-rate-wrap">
                                                <i class="product__panel-rate" style="text-decoration: underline;font-size: 20px; margin-right: 5px">${keyboardData.get(i).getRateStar()}</i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                                <i class="fas fa-star product__panel-rate"></i>
                                            </div>
                                            <div class="product__panel-price">
                                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                                    <div>    
                                                        <button class="bestselling__product-btn">So sánh</button>
                                                    </div>
                                                </span>
                                                <span class="product__panel-price-current">
                                                    <button href="compareProduct.jsp" class="bestselling__product-btn">${keyboardData.get(i).getSalePrice()}đ</button>
                                                </span>
                                            </div>
                                            <c:if test="${keyboardData.get(i).getSale()>0}">
                                                <div class="product__panel-price-sale-off">
                                                    -${keyboardData.get(i).getSale()}%
                                                </div>
                                            </c:if>

                                        </div>
                                    </c:if>
                                    <c:set var="i" value="${i+1}"></c:set>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="clearfix">
                            <c:if test="${keyboardpageAmount>0}">
                                <div class="hint-text" style="font-size: 15px;">Hiển thị ${countDisplayElement} trong số ${keyboardData.size()} sản phẩm</div>
                                <ul class="pagination">
                                    <%--<c:set var="active" value="active"> </c:set>--%>
                                    <c:set var="count" value="1"></c:set>
                                    <c:if test="${keyboardpageIndex!=1}">
                                        <li class="page-item disabled"><a onclick="Paging('k${keyboardpageIndex-1}', '${category3}')" id="k${keyboardpageIndex-1}" href="ProductListController?tab=${tab}&keyboardpageIndex=${keyboardpageIndex-1}">Previous</a></li>
                                        </c:if>
                                        <c:forEach begin="${count}" end="${keyboardpageAmount}">
                                            <c:if test="${keyboardpageIndex==count}">
                                            <li class="page-item active"><a onclick="Paging('k${count}', '${category3}')" id="k${count}" href="ProductListController?tab=${tab}&keyboardpageIndex=${count}" class="page-link">${count}</a></li>
                                            </c:if>
                                            <c:if test="${keyboardpageIndex!=count}">
                                            <li class="page-item"><a onclick="Paging('k${count}', '${category3}')" id="k${count}" href="ProductListController?tab=${tab}&keyboardpageIndex=${count}" class="page-link">${count}</a></li>
                                            </c:if>
                                            <c:set var="count" value="${count+1}"></c:set>
                                        </c:forEach>
                                        <c:if test="${keyboardpageIndex!=keyboardpageAmount}">
                                        <li class="page-item disabled"><a onclick="Paging('k${keyboardpageIndex+1}', '${category3}')" id="k${keyboardpageIndex+1}" href="ProductListController?tab=${tab}&keyboardpageIndex=${keyboardpageIndex+1}">Next</a></li>
                                        </c:if>
                                    <!--<li class="page-item active"><a href="#" class="page-link">Next</a></li>-->
                                </ul>
                            </c:if>
                        </div>
                    </div>
                </section>
            </form>
        </c:if>
        <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- end footer -->
        <!-- scroll to top -->
        <!-- score-top-->

        <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></i></button>
    <!--  -->

   <script src="js/category.js"></script>
    <script>
            function changeHeadPhone() {
                document.getElementById("formm1").submit();
            }

    </script>
    <script>
        function changeMouse() {
            document.getElementById("formm2").submit();
        }

    </script>
    <script>
        function changeKeyboard() {
            document.getElementById("formm3").submit();
        }

    </script>
    <script>
        function Paging(input, category) {
            event.preventDefault();
            var linkHref = document.getElementById(input).href;
            $.ajax({
                url: linkHref,
                type: "post", //send it through get method
                data: {
                    paging: true
                },
                success: function (data) {
                    var row = document.getElementById(category);
                    row.innerHTML = data;
//                    row.innerHTML += data;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }
    </script>

    <!--    <script>
            $(document).ready(function () {
                $("#myLink1").click(function (event) {
                    event.preventDefault(); // Ngăn chặn hành vi mặc định khi người dùng nhấp vào liên kết
                    var linkHref = $(this).attr("href"); // Lấy giá trị href của thẻ a
                    // Thực hiện AJAX tại đây
                    $.ajax({
                        url: linkHref,
                        type: "post",
                        data: {checkResponse: "true", param2: "2"},
                        success: function (data) {
    //                        window.location.reload();
                            var row = document.getElementById("category1");
                            row.innerHTML = data;
                            // Xử lý kết quả AJAX ở đây
                            console.log(response);
                        },
                        error: function (xhr, status, error) {
                            // Xử lý lỗi nếu có
                            console.log(error);
                        }
                    });
                });
            });
        </script>-->
</body>
</html>