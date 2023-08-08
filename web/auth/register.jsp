<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Register</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/popup.css">
    </head>
    <body>
        <div class="main">

            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Đăng kí</h2>
                            <form method="post" action="Register" class="register-form" id="register-form" >
                                <div class="form-group">
                                    <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="fullName" id="name" placeholder="Họ Và Tên" value="${fullName}"/>
                                </div>
                                ${msg1}   
                                <div class="form-group">
                                    <label for="userName"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="userName" id="userName" placeholder="Tên đăng nhập" value="${userName}"/>
                                </div>
                                ${msg2}
                                <div class="form-group">
                                    <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="password" id="pass" placeholder="Mật khẩu" value="${password}"/>
                                </div>
                                ${msg3}
                                <div class="form-group">
                                    <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                    <input type="password" name="rePassword" id="re_pass" placeholder="Nhập lại mật khẩu" value="${rePassword}"/>
                                </div>
                                ${msg4}
                                <div class="form-group">
                                    <label for="email"><i class="zmdi zmdi-email"></i></label>
                                    <input type="email" name="email" id="email" placeholder="Email" value="${email}"/>
                                </div>
                                ${msg5}
                                <div class="form-group">
                                    <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="date" name="dob" id="name" placeholder="Your Date" value="${dob}"/>
                                </div>
                                ${msg6}
                                <div class="form-group">
                                    <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="number" name="phone" id="name" placeholder="Số điện thoại" value="${phone}"/>
                                </div>
                                ${msg7}
                                <div class="form-group">
                                    <input type="checkbox" name="agree_term" id="agree-term" class="agree-term" />
                                    <label for="agree-term" class="label-agree-term"><span><span></span></span>Tôi đồng ý với <a href="#" id="terms-link">điều khoản</a></label>
                                </div>
                                ${msg8}
                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup" class="form-submit" value="Đăng ký"/>
                                </div>
                                ${registerMessage}

                            </form>
                        </div>
                        <div class="signup-image">
                            <figure><a href="../view/homepage"><img src="images/logo1.png" alt="sing up image"></a></figure>
                        </div>
                    </div>
                </div>
            </section>  
            <div id="popup" class="popup">
                <div class="popup-content">
                    <span class="close-button">&times;</span>
                    <p>1. Chấp nhận điều khoản
                          Bằng cách truy cập và sử dụng trang web này, bạn đồng ý tuân thủ các điều khoản và điều kiện sau đây. Nếu bạn không đồng ý với các điều khoản này, vui lòng không sử dụng trang web.</p>
                    <p>2. Thông tin cá nhân
                          Khi bạn tạo tài khoản hoặc đặt hàng trên trang web, bạn phải cung cấp thông tin cá nhân chính xác và hoàn chỉnh. Bạn đồng ý rằng thông tin cá nhân của bạn sẽ được xử lý theo Chính sách Riêng tư của chúng tôi.</p>
                </div>
            </div>

            <script>
                document.addEventListener('DOMContentLoaded', function () {
                    var termsLink = document.getElementById('terms-link');
                    var popup = document.getElementById('popup');
                    var closeButton = popup.querySelector('.close-button');

                    termsLink.addEventListener('click', function (e) {
                        e.preventDefault();
                        popup.classList.add('active');
                    });

                    closeButton.addEventListener('click', function () {
                        popup.classList.remove('active');
                    });
                });
            </script>
            <!-- JS -->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="js/main.js"></script>
    </body>
</html>
