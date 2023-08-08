<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
        <!--popup-->
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
        <!--end popup-->
    </head>
    <body>
        <!--popup-->

        <%--<c:if test="${allowRegister !=null}">--%>
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
                        <p class="text-center">                           
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-success btn-block" data-dismiss="modal">
                            OK
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <%--</c:if>--%>


        <!--endpopup-->
        <div class="main">
            <!-- Sing in  Form -->
            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure><img src="images/logo1.png" alt="sing up image"></figure>                      
                        </div>

                        <div class="signin-form">
                            <h2 class="form-title">Đăng nhập</h2>
                            <form method="POST" action="login" class="register-form" id="login-form">
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="username" id="your_name" placeholder="Your User Name"/>
                                </div>
                                <div class="form-group">
                                    <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="password" id="your_pass" placeholder="Password"/>
                                </div>
                                    <a href="forgetpassword.jsp" >Quên mật khẩu</a>
                                <div class="form-group">
                                    <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                    <label for="remember-me" class="label-agree-term"><span><span></span></span>Ghi nhớ mật khẩu</label>

                                </div>
                                <div class="form-group form-button">
                                    <!--// mình sét nhi?u th? form d?c không-->
                                    <input type="submit" name="signIn" id="signin" class="form-submit" value="Đăng nhập"/>
                                    <input type="submit" name="signUp" id="signin" class="form-submit" value="Tạo tài khoản"/>
                                </div>
                            </form>
                            <div class="social-login">
                                <span class="social-label">ĐĂNG NHẬP VỚI</span>
                                <ul class="socials">
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                    <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                    <li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:9999/TechZone/auth/LoginWithGoogle&response_type=code
		   &client_id=403286912163-5tgcg35ogl3jujvvteq6b4vm38uvvu1h.apps.googleusercontent.com&approval_prompt=force"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
        <c:if test="${(allowRegister!=null) ||(allowResetPassword!=null)||(changepasswordSuccess!=null)}">
            <script>
                $(document).ready(function () {
                    $("#myModal").modal("show");
                    $(".trigger-btn").click(); // trigger click event on the button
                });
            </script>
        </c:if>
    </body>
</html>
