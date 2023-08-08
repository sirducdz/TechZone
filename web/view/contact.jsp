<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Liên hệ</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/contact.css">
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>

            <!--end header nav -->
            <!-- score-top-->

            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-down"></i></button>
            <!-- contact -->
            <section class="contact">
                <div class="container">
                    <div class="row mt-4 mb-50 pc">
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

                        <div class="col-12 contact__map">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.485409665761!2d105.52448937502432!3d21.013254988311374!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345b465a4e65fb%3A0xaae6040cfabe8fe!2zVHLGsOG7nW5nIMSQ4bqhaSBI4buNYyBGUFQ!5e0!3m2!1svi!2s!4v1688723147121!5m2!1svi!2s" width="1100" height="200" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                        </div>
                    </div>

                    <div class="row mt-4 mb-4">
                        <div class="col-lg-8 col-md-6 col-sm-12 contact__self">
                            <h3 class="mb-4">
                                Liên hệ với chúng tôi
                            </h3>
                            <p>
                                Để không ngừng nâng cao chất lượng dịch vụ và đáp ứng tốt hơn nữa các yêu cầu sử dụng của Quý khách, 
                                chúng tôi mong muốn nhận được các thông tin phản hồi. Nếu Quý khách có bất kỳ thắc mắc hoặc đóng góp nào, 
                                xin vui lòng liên hệ với chúng tôi theo thông tin dưới đây. Chúng tôi sẽ phản hồi lại Quý khách trong thời gian sớm nhất.
                            </p>
                  
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-12 contact__regist">
                            <h3>
                                Thông tin liên hệ
                            </h3>

                            <ul class="contact__self-list">
                                <li class="contact__self-item">
                                    <a class="contact__self-link" href="index.jsp">TechZone.com</a>
                                </li>
                                <li class="contact__self-item">
                                    <a class="contact__self-link" href="#">SĐT: 0911 106 013</a>
                                </li>
                                <li class="contact__self-item">
                                    <a class="contact__self-link" href="#">Email: dangnhhe161703@fpt.edu.vn</a>
                                </li>
                                <!--                            <li class="contact__self-item">
                                                                <a class="contact__self-link" href="#">Địa chỉ: Số 3A, Tạ Quang Bử, Hai Bà Trưng, Hà Nội</a>
                                                            </li>-->
                            </ul>
                        </div>
                    </div>
                </div>
            </section>
            <!--end contact -->

            <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- end footer -->
        <script src="js/jq.js"></script>
    </body>
</html>