<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Giỏ hàng</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/cart.css">
    </head>
    <body>

        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!--end header nav -->
            <!-- score-top-->
            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></button>
            <!-- cart -->

            <form action="CartController?tab=cartList" method="post">
                <section id="allCart" class="cart">
                    <div class="container">
                        <article class="row cart__head pc">
                            <nav class="menu__nav col-lg-3 col-md-12 col-sm-0">
                                <ul class="menu__list">
                                    <li class="menu__item ">
                                        <a href="ProductListController?tab=headphone" class="menu__link">
                                            <img src="images1/item/headphone.jpg" alt=""  class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                            Tai nghe</a>
                                    </li>
                                    <li class="menu__item">
                                        <a <a href="ProductListController?tab=mouse" class="menu__link">
                                                <img src="images1/item/mouse.jpg" alt="" class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                                Chuột</a>
                                    </li>

                                    <li class="menu__item">
                                        <a href="ProductListController?tab=keyboard" class="menu__link">
                                            <img src="images1/item/keyboard.jpg" alt="" class="menu__item-icon"  viewBox="0 0 512 512" width="1012" height="512">
                                            Bàn phím</a>
                                    </li>
                                </ul>
                            </nav>
                            <div class="col-6 cart__head-name">
                                Thông tin sản phẩm
                            </div>
                            <div class="col-3 cart__head-quantity">
                                Số lượng
                            </div>
                            <div class="col-3 cart__head-price">
                                Đơn giá
                            </div>
                        </article>
                    <c:forEach items="${cartList}" var="item">
                        <article  class="row cart__body">
                            <div class="col-6 cart__body-name">
                                <input type="checkbox" name="cartCheckBox" value="${item.getCartID()}"  onclick="cartCheckBoxFunc('cartCheckBox')"> 
                                <!--<input type="checkbox" name="cartCheckBox" value="${item.getCartID()}" >--> 
                                <div class="cart__body-name-img">
                                    <img src="${item.getPicture()}">
                                </div>
                                <a href="" class="cart__body-name-title">
                                    ${item.getProductName()}
                                </a>
                            </div>
                            <!--${item.getProduct_Quantity()}-->
                            <div class="col-3 cart__body-quantity">
                                <input type="button" value="-" class="cart__body-quantity-minus" onclick="decreaseQuantity('${item.getCartID()}');UpdateContent('${item.getCartID()}', 'cartCheckBox');">
                                <input type="number" readonly="" name="quantityValue" step="1" min="1" max="${item.getProduct_Quantity()}" value="${item.getQuantity()}" class="cart__body-quantity-total" id="${item.getCartID()}">
                                <input type="button" value="+" class="cart__body-quantity-plus" onclick="increaseQuantity('${item.getCartID()}', '${item.getProduct_Quantity()}');UpdateContent('${item.getCartID()}', 'cartCheckBox');">
                            </div>

                            <div class="col-3 cart__body-price">
                                <span>${item.getTotalcost()}đ</span>

                                <a href="CartController?tab=cartList&DeleteProduct&cartID=${item.getCartID()}">Xóa</a>
                            </div>
                        </article>
                    </c:forEach>
                    <article class="row cart__foot">
                        <div class="col-6 col-lg-6 col-sm-6 cart__foot-update">
                            <!--<button class="cart__foot-update-btn">Cập nhật giỏ hàng</button>-->
                        </div>

                        <p class="col-3 col-lg-3 col-sm-3 cart__foot-total">
                            Tổng cộng: 
                        </p>

                        <span class="col-3 col-lg-3 col-sm-3 cart__foot-price">
                            0đ <br>
                            <button class="cart__foot-price-btn" name="buyProductsSubmit">Mua hàng</button>
                        </span>
                        <span class="col-3 col-lg-3 col-sm-3 cart__foot-price">
                            ${message}
                        </span>
                    </article>
                </div>
            </section>
        </form>
        <!--end cart -->

        <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- end footer -->
        <script src="js/jq.js"></script>
        <script>
                                    function decreaseQuantity(inputId) {
                                        var input = document.getElementById(inputId);
                                        if (input.value > 1) {
                                            input.value = parseInt(input.value) - 1;
                                        }
                                    }

                                    function increaseQuantity(inputId, productQuantity) {
                                        var input = document.getElementById(inputId);
                                        if (input.value < parseInt(productQuantity)) {
                                            input.value = parseInt(input.value) + 1;
                                        }
                                    }
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>

                                    function UpdateContent(cartID, cartCheckBoxName) {
                                        var quantity = document.getElementById(cartID);
                                        var checkBoxes = document.getElementsByName(cartCheckBoxName);
                                        var value = [];
                                        for (var i = 0; i < checkBoxes.length; ++i)
                                        {
                                            if (checkBoxes[i].checked)
                                            {
                                                value.push(checkBoxes[i].value);
                                            }
                                        }
                                        $.ajax({
                                            url: "/TechZone/view/CartController",
                                            type: "post", //send it through get method
                                            data: {
                                                updatequantity: true,
                                                cartID: cartID,
                                                quantity: quantity.value,
                                                cartIDArray: value.toString(),
                                                tab: 'cartList'
                                            },
                                            success: function (data) {
                                                var row = document.getElementById("allCart");
                                                row.innerHTML = data;
                                            },
                                            error: function (xhr) {
                                                //Do Something to handle error
                                            }
                                        });
                                    }


        </script>
        <script>
            function cartCheckBoxFunc(cartCheckBoxName) {
                var checkBoxes = document.getElementsByName(cartCheckBoxName);
                var value = [];
                for (var i = 0; i < checkBoxes.length; ++i)
                {
                    if (checkBoxes[i].checked)
                    {
                        value.push(checkBoxes[i].value);
                    }
                }
                console.log(value[0]);
                console.log(value[1]);
                console.log(value[2]);
                console.log(value.toString());
                $.ajax({
                    url: "/TechZone/view/CartController",
                    type: "post", //send it through get method
                    data: {
                        cartCheckBox: true,
                        cartIDArray: value.toString(),
                        tab: 'cartList'
                    },
                    success: function (data) {
                        var row = document.getElementById("allCart");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }



        </script>
    </body>
</html>