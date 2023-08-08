<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sản phẩm</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/product.css">

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
            />
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
            />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- end header -->

            <!-- score-top-->
            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></button>                        
            <!-- product -->
            <form action="ProductDetailController">
                <section class="product">
                    <div class="container">
                        <div class="row bg-white pt-4 pb-4 border-bt pc">
                            <nav class="menu__nav col-lg-3 col-md-12 col-sm-0">
                                <ul class="menu__list">
                                    <li class="menu__item menu__item--active">
                                        <a href="headphone.jsp" class="menu__link">
                                            <img src="images1/item/headphone.jpg" alt=""  class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                            Tai nghe</a>
                                    </li>
                                    <li class="menu__item">
                                        <a href="mouse.jsp" class="menu__link">
                                            <img src="images1/item/mouse.jpg" alt="" class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                            Chuột</a>
                                    </li>

                                    <li class="menu__item">
                                        <a href="keyboard.jsp" class="menu__link">
                                            <img src="images1/item/keyboard.jpg" alt="" class="menu__item-icon"  viewBox="0 0 512 512" width="1012" height="512">
                                            Bàn phím</a>
                                    </li>
                                </ul>
                            </nav>

                            <article class="product__main col-lg-9 col-md-12 col-sm-12">
                                <div class="row">
                                    <div class="product__main-img col-lg-4 col-md-4 col-sm-12">
                                        <div class="product__main-img-primary">
                                            <img src="${productDetail.getPicture()}">
                                    </div>

                                    <div class="product__main-img-list">
                                        <img src="${productDetail.getPicture2()}">
                                        <img src="${productDetail.getPicture3()}">
                                        <img src="${productDetail.getPicture()}">
                                    </div>
                                </div>

                                <div class="product__main-info col-lg-8 col-md-8 col-sm-12">
                                    <div class="product__main-info-breadcrumb">
                                        Trang chủ / Sản phẩm  
                                    </div>

                                    <a href="#" class="product__main-info-title">
                                        <h2 class="product__main-info-heading">
                                            ${productDetail.getName()}
                                        </h2>
                                    </a>

                                    <div class="product__main-info-rate-wrap">
                                        <i class="product__panel-rate" style="text-decoration: underline;font-size: 20px; margin-right: 5px">${productDetail.getRateStar()}</i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                    </div>

                                    <div class="product__main-info-price">
                                        <span class="product__main-info-price-current">
                                            ${salePrice} đ
                                        </span>
                                    </div>

                                    <div class="product__main-info-description">
                                        <c:if test="${productDetail.getQuantity()!=0}">${productDetail.getQuantity()} sản phẩm có sẵn.</c:if>
                                        <c:if test="${productDetail.getQuantity()==0}">${productDetail.getQuantity()} Hết hàng.</c:if>

                                        </div> 

                                        <div class="product__main-info-cart">
                                            <div class="product__main-info-cart-quantity">
                                                <input type="button" value="-"  class="product__main-info-cart-quantity-minus" onclick="decreaseQuantity('quantity')">
                                                <input style=" width: 35px;" name="quantity" type="number" step="1" min="1" max="${productDetail.getQuantity()}" value="1" class="product__main-info-cart-quantity-total" id="quantity">
                                            <input type="button" value="+" class="product__main-info-cart-quantity-plus" onclick="increaseQuantity('quantity')">
                                        </div>
                                        <c:if test="${productDetail.getQuantity()!=0}">
                                            <div class="product__main-info-cart-btn-wrap">
                                                <button class="product__main-info-cart-btn" name="addToCart">
                                                    Thêm vào giỏ hàng
                                                </button>
                                            </div>
                                        </c:if>
                                    </div>

                                    <div class="product__main-info-contact">
                                        <a href="https://www.facebook.com/messages/t/100012162497624" class="product__main-info-contact-fb">
                                            <i class="fab fa-facebook-f"></i>
                                            Chat Facebook
                                        </a>
                                        <div class="product__main-info-contact-phone-wrap">
                                            <div class="product__main-info-contact-phone-icon">
                                                <i class="fas fa-phone-alt "></i>
                                            </div>

                                            <div class="product__main-info-contact-phone">
                                                <div class="product__main-info-contact-phone-title">
                                                    Gọi điện tư vấn
                                                </div>
                                                <div class="product__main-info-contact-phone-number">
                                                    (0352.860.701)
                                                </div>
                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="row bg-white">
                                <div class="col-12 product__main-tab">
                                    <a href="#" class="product__main-tab-link product__main-tab-link--active">
                                        Mô tả
                                    </a>
                                </div>

                                <div class="col-12 product__main-content-wrap">
                                    <h2 class="product__main-content-heading">
                                        ${productDetail.getName()}
                                    </h2>
                                    <h2 class="thongtin">    <span>Thông tin chi tiết</span> 
                                    </h2>
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <tbody>
                                                <tr>
                                                    <th>Thương hiệu</th>
                                                    <td>Corsair</td>
                                                </tr>
                                                <tr><th>Bảo hành</th><td>24 tháng</td></tr>
                                                <tr><th>Kích thước</th><td>19 x 27 cm</td></tr>
                                                <tr><th>Model</th><td>Corsair HS70 Pro Wireless Carbon</td></tr>
                                                <tr><th>Màu sắc </th><td>Đen</td></tr>
                                                <tr><th>Kiểu tai nghe</th><td>Over-ear/Không dây</td></tr>
                                                <tr><th>Kiểu kết nối</th><td>Không dây (USB Wireless Receiver)</td></tr>
                                                <tr><th>Thời lượng pin </th><td>16 giờ</td></tr>
                                                <tr><th>Tần số</th><td>Tai nghe: 20Hz - 20000Hz </br> Micro: 100Hz - 10000Hz</td></tr>
                                                <tr><th>Độ nhạy</th><td>	Tai nghe: 111dB (+/- 3dB) </br> Micro: -40dB (+/- 3dB)</td></tr>
                                                <tr><th>Kích thước (mm)</th><td>160mm x100mm x 205mm</td></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </article>

                        <aside class="product__aside col-lg-3 col-md-0 col-sm-0">
                            <div class="product__aside-top">
                                <div class="product__aside-top-item">
                                    <img src="images/shipper.png">
                                    <div class="product__aside-top-item-text">
                                        <p>
                                            Giao hàng nhanh chóng
                                        </p>
                                        <span>
                                            Chỉ trong vòng 24h
                                        </span>
                                    </div>
                                </div>
                                <div class="product__aside-top-item">
                                    <img src="images/brand.png">
                                    <div class="product__aside-top-item-text">
                                        <p>
                                            Sản phẩm chính hãng
                                        </p>
                                        <span>
                                            Sản phẩm nhập khẩu 100%
                                        </span>
                                    </div>
                                </div>
                                <div class="product__aside-top-item">
                                    <img src="images/less.png">
                                    <div class="product__aside-top-item-text">
                                        <p>
                                            Mua hàng tiết kiệm
                                        </p>
                                        <span>
                                            Rẻ hơn từ 10% đến 30%
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="product__aside-bottom">
                                <h3 class="product__aside-heading">
                                    Có thể bạn thích
                                </h3>
                                <div class="product__aside-list">
                                    <c:forEach items="${bottomDataList}" var="item">
                                        <div class="product__aside-item product__aside-item--border">
                                            <div class="product__aside-img-wrap">
                                                <img src="${item.getPicture()}" class="product__aside-img">
                                            </div>
                                            <div class="product__aside-title">
                                                <a href="ProductDetailController?ProductID=${item.getProductID()}" class="product__aside-link">
                                                    <h4 class="product__aside-link-heading">${item.getName()}</h4>
                                                </a>
                                                <div class="product__aside-rate-wrap">
                                                    <i class="product__panel-rate" style="text-decoration: underline;font-size: 20px; margin-right: 5px">${item.getRateStar()}</i>
                                                    <i class="fas fa-star product__aside-rate"></i>
                                                    <i class="fas fa-star product__aside-rate"></i>
                                                    <i class="fas fa-star product__aside-rate"></i>
                                                    <i class="fas fa-star product__aside-rate"></i>
                                                    <i class="fas fa-star product__aside-rate"></i>
                                                </div>

                                                <div class="product__aside-price">
                                                    <span class="product__aside-price-current">
                                                        ${item.getSalePrice()}đ
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>

                                    <!--                                    <div class="product__aside-item">
                                                                            <div class="product__aside-img-wrap">
                                                                                <img src="images1/product/t2.jpg" class="product__aside-img">
                                                                            </div>
                                                                            <div class="product__aside-title">
                                                                                <a href="#" class="product__aside-link">
                                                                                    <h4 class="product__aside-link-heading">Tai nghe Havit H2002D</h4>
                                                                                </a>
                                    
                                                                                <div class="product__aside-rate-wrap">
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                </div>
                                    
                                                                                <div class="product__aside-price">
                                                                                    <span class="product__aside-price-current">
                                                                                        76.800đ
                                                                                    </span>
                                                                                </div>
                                                                            </div>
                                                                        </div>-->

                                    <!--                                    <div class="product__aside-item">
                                                                            <div class="product__aside-img-wrap">
                                                                                <img src="images1/product/t3.jpg" class="product__aside-img">
                                                                            </div>
                                                                            <div class="product__aside-title">
                                                                                <a href="#" class="product__aside-link">
                                                                                    <h4 class="product__aside-link-heading">Tai nghe Gaming HAVIT H2028U</h4>
                                                                                </a>
                                    
                                                                                <div class="product__aside-rate-wrap">
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                    <i class="fas fa-star product__aside-rate"></i>
                                                                                </div>
                                    
                                                                                <div class="product__aside-price">
                                                                                    <span class="product__aside-price-current">
                                                                                        69.000đ
                                                                                    </span>
                                                                                </div>
                                                                            </div>
                                                                        </div>                                                        -->
                                </div>
                            </div>
                        </aside>

                    </div>

                    <div class="customer-reviews row pb-4 pb-4  py-4 pb-4 py-4 py-4">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <h3 >Bình luận sản phẩm</h3>
                            <c:if test="${checkBuyProduct==true}">
                                <!--<div style="margin:  ">-->
                                <!--style="margin-left: 450px"-->
                                <section style="font-size: 17px; margin-left: 350px">
                                    <input type="radio"  name="star"  value="1" checked=""> 1 <i class="fas fa-star product__panel-rate"></i>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="star" value="2"> 2 <i class="fas fa-star product__panel-rate"></i>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="star" value="3"> 3 <i class="fas fa-star product__panel-rate"></i>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="star" value="4"> 4 <i class="fas fa-star product__panel-rate"></i>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="star" value="5"> 5 <i class="fas fa-star product__panel-rate"></i> 
                                </section>
                                <div class="form-group">
                                    <label>Nội dung:</label>
                                    <textarea name="comm_details"  rows="8" id ='formcontent' class="form-control"></textarea>     
                                </div>
                                <button type="submit" name="submitComment" id= "submitcomment" onclick="SubmitContent('feedbackContent')" class="btn btn-primary" >Gửi</button>
                            </c:if>
                        </div>
                    </div>

                    <div class="product-comment row pb-4 pb-4  py-4 pb-4 py-4 py-4">
                        <div class="col-lg-12 col-md-12 col-sm-12" id="feedbackContent">
                            <c:forEach items="${feedbackList}" var="item">
                                <div class="comment-item">
                                    <ul class = item-reviewer>
                                        <div class="comment-item-user">
                                            <img src="images/img/1.png" alt="" class="comment-item-user-img">
                                            <!--<img src="images/img/2.png" alt="" class="comment-item-user-img">-->
                                            <li><b>${item.getUsername()}</b></li> 
                                        </div>
                                        <div class="product__panel-rate-wrap">
                                            <i class="product__panel-rate" style="text-decoration: underline;font-size: 20px; margin-right: 5px">${item.getProduct_rate()}</i>
                                            <c:forEach begin="1" end="${item.getProduct_rate()}" step="1">
                                                <i class="fas fa-star product__panel-rate"></i>
                                            </c:forEach>
                                        </div>
                                        <br>
                                        <li>${item.getDate()}</li>
                                        <li>
                                            <h4>${item.getInformation()}</h4>
                                        </li>
                                    </ul>
                                </div>
                            </c:forEach>
                            <c:if test="${feedbackList.size()>=3}">
                                <style>
                                    .load-more-button {
                                        background-color: #4CAF50; /* Màu nền */
                                        color: white; /* Màu chữ */
                                        padding: 10px 20px; /* Kích thước nút */
                                        border: none; /* Loại bỏ đường viền */
                                        border-radius: 4px; /* Bo góc nút */
                                        cursor: pointer; /* Hiển thị con trỏ khi di chuột vào nút */
                                        font-size: 16px; /* Kích thước chữ */
                                        margin-left: 500px;
                                    }
                                    .load-more-button:hover {
                                        background-color: #45a049; /* Màu nền khi di chuột vào nút */
                                    }

                                </style>
                                <button class="load-more-button" id="load-more-button" onclick="LoadMoreFuction('comment-item', 'feedbackContent', 'load-more-button')" >Load More</button>
                            </c:if>
                        </div>
                    </div>
                    <section class="product__love col-12 mt-4">
                        <div class="row bg-white">
                            <div class="col-lg-12 col-md-12 col-sm-12 product__love-title">
                                <h2 class="product__love-heading">
                                    Sản phẩm tương tự
                                </h2>
                            </div>
                        </div>
                        <div class="row bg-white">
                            <c:forEach items="${bottomDataList}" var="item">
                                <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">

                                    <div class="product__panel-img-wrap">
                                        <a href="ProductDetailController?ProductID=${item.getProductID()}">
                                            <img src="${item.getPicture()}" alt="" class="product__panel-img">
                                        </a>
                                    </div>
                                    <h3 class="product__panel-heading">
                                        <a href="ProductDetailController?ProductID=${item.getProductID()}" class="product__panel-link">${item.getName()}</a>
                                    </h3>
                                    <div class="product__panel-rate-wrap">
                                        <i class="product__panel-rate" style="text-decoration: underline;font-size: 20px; margin-right: 5px">${item.getRateStar()}</i>
                                        <i class="fas fa-star product__panel-rate"></i>
                                        <i class="fas fa-star product__panel-rate"></i>
                                        <i class="fas fa-star product__panel-rate"></i>
                                        <i class="fas fa-star product__panel-rate"></i>
                                        <i class="fas fa-star product__panel-rate"></i>
                                    </div>

                                    <div class="product__panel-price">
                                        <span class="product__panel-price-old product__panel-price-old-hide">

                                        </span>
                                        <span class="product__panel-price-current">
                                            ${item.getSalePrice()}đ
                                        </span>
                                    </div>  
                                </div>
                            </c:forEach>
                        </div>
                    </section>
                </div>  
            </section>
        </form>
        <!--popup-->
        <style>
            body {
                font-family: "Roboto", sans-serif;
            }

            .modal-confirm {
                color: #636363;
                width: 325px;
                font-size: 14px;
            }

            .modal-confirm .modal-content {
                padding: 20px;
                border-radius: 5px;
                border: none;
            }

            .modal-confirm .modal-header {
                border-bottom: none;
                position: relative;
            }

            .modal-confirm h4 {
                text-align: center;
                font-size: 26px;
                margin: 30px 0 -15px;
            }

            .modal-confirm .form-control,
            .modal-confirm .btn {
                min-height: 40px;
                border-radius: 3px;
            }

            .modal-confirm .close {
                position: absolute;
                top: -5px;
                right: -5px;
            }

            .modal-confirm .modal-footer {
                border: none;
                text-align: center;
                border-radius: 5px;
                font-size: 13px;
            }
            .btn.btn-success.btn-block{
                background-color: #f24137;
            }
            .modal-confirm .icon-box {
                color: #fff;
                position: absolute;
                margin: 0 auto;
                left: 0;
                right: 0;
                top: -70px;
                width: 95px;
                height: 95px;
                border-radius: 50%;
                z-index: 9;
                background: #f24137;
                padding: 15px;
                text-align: center;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
            }

            .modal-confirm .icon-box i {
                font-size: 58px;
                position: relative;
                top: 3px;
            }
            .modal-confirm.modal-dialog {
                margin-top: 80px;
            }

            .modal-confirm .btn {
                color: #fff;
                border-radius: 4px;
                background: #82ce34;
                text-decoration: none;
                transition: all 0.4s;
                line-height: normal;
                border: none;
            }

            .modal-confirm .btn:hover,
            .modal-confirm .btn:focus {
                background: #6fb32b;
                outline: none;
            }

            .trigger-btn {
                display: inline-block;
                margin: 100px auto;
            }
        </style>

        <!-- Modal HTML -->
        <div id="myModal" class="modal fade">
            <div class="modal-dialog modal-confirm">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="icon-box">
                            <i class="material-icons">&#xE876;</i>
                        </div>
                        <h4 class="modal-title w-100">Hoàn thành</h4>
                    </div>
                    <div class="modal-body">
                        <!--<p class="text-center">-->
                        <h6 class="text-center">Hàng được thêm vào giỏ hàng thành công!</h6>
                        <!--</p>-->
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-success btn-block" data-dismiss="modal">
                            OK
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
        <!--endpopup-->
        <!--product -->
        <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>

            <!-- end footer -->

            <script src="js/jq.js"></script>
            <script src="js/product.js"></script>
            <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
            <script>

                                    function SubmitContent(feedbackContent) {
                                        event.preventDefault();
                                        var comm_details = document.getElementById('formcontent').value;
                                        var starArray = document.getElementsByName('star');
                                        var starValue;
                                        for (var i = 0; i < starArray.length; ++i)
                                        {
                                            if (starArray[i].checked)
                                            {
                                                starValue = starArray[i].value;
                                                break;
                                            }
                                        }
                                        //                                        console.log(starValue);
                                        //                                        console.log(comm_details);
                                        var comm_details = document.getElementById('formcontent').value;
                                        $.ajax({
                                            url: "/TechZone/view/ProductDetailController",
                                            type: "post", //send it through get method
                                            data: {
                                                submitComment: true,
                                                comm_details: comm_details,
                                                star: starValue,
                                            },
                                            success: function (data) {
                                                var row = document.getElementById(feedbackContent);
                                                row.innerHTML = data;
                                                console.log(data);
                                            },
                                            error: function (xhr) {
                                                //Do Something to handle error
                                            }
                                        });
                                    }
                                    function LoadMoreFuction(commentListAmount, feedbackContent, loadmoreButton) {
                                        event.preventDefault();
                                        var amount = document.getElementsByClassName('comment-item').length;
                                        var loadMorebtn = document.getElementById(loadmoreButton);
                                        loadMorebtn.style.display = "none";
                                        $.ajax({
                                            url: "/TechZone/view/ProductDetailController",
                                            type: "post", //send it through get method
                                            data: {
                                                loadMore: true,
                                                amount: amount,
                                                ProductID: ${productDetail.getProductID()}
                                            },
                                            success: function (data) {
                                                var row = document.getElementById('feedbackContent');
                                                row.innerHTML += data;
                                                console.log(data);
                                            },
                                            error: function (xhr) {
                                                //Do Something to handle error
                                            }
                                        });
                                    }

                                    function decreaseQuantity(quantity) {
                                        var input = document.getElementById(quantity);
                                        if (input.value > 1) {
                                            input.value = parseInt(input.value) - 1;
                                        }
                                    }

                                    function increaseQuantity(quantity) {
                                        var input = document.getElementById(quantity);
                                        if (input.value < parseInt(${productDetail.getQuantity()})) {
                                            input.value = parseInt(input.value) + 1;
                                        }
                                    }
        </script>
        <c:if test="${checkAddToCart!=null}">
            <script>
                $(document).ready(function () {
                    $("#myModal").modal("show");
                    $(".trigger-btn").click(); // trigger click event on the button
                });
            </script>
        </c:if>

    </body>
</html>