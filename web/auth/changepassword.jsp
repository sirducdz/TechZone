<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Đổi mật khẩu </title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <!--        <link rel="stylesheet" href="css/style.css">-->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="main">
            <!-- Sing in  Form -->
            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure><a href="../view/homepage"><img src="images/logo1.png" alt="sing up image"></a></figure>
                        </div>

                        <div class="signin-form"><h2>ĐỔI MẬT KHẨU</h2>
                            <form method="POST" action="ChangePassword" class="register-form" id="login-form">
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="text" name="currentPassword" id="your_name" placeholder=" Mật khẩu hiện tại "/>
                                </div>
                                 ${msg1}
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="text" name="password" id="your_name" placeholder=" Mật khẩu mới "/>
                                </div>
                                ${msg2}
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="text" name="rePassword" id="your_name" placeholder=" Xác nhận lại mật khẩu "/>
                                </div>    
                                ${msg3}
                                <div class="form-group form-button">
                                    <input type="submit" name="submit" id="signin" class="form-submit" value="Đổi mật khẩu"/>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
