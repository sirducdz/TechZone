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
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- end header -->

            <!-- score-top-->
            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></button>                        
            <!-- product -->
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
                                        <img src="images1/product/t1.jpg">
                                    </div>

                                    <div class="product__main-img-list">
                                        <img src="images1/product/t1.1.jpg">
                                        <img src="images1/product/t1.2.jpg">
                                        <img src="images1/product/t1.3.jpg">
                                        <img src="images1/product/t1.4.jpg">

                                    </div>
                                </div>

                                <div class="product__main-info col-lg-8 col-md-8 col-sm-12">
                                    <div class="product__main-info-breadcrumb">
                                        Trang chủ / Sản phẩm
                                    </div>

                                    <a href="category.jsp" class="product__main-info-title">
                                        <h2 class="product__main-info-heading">
                                            Tai nghe Corsair HS70 Pro Wireless Carbon
                                        </h2>
                                    </a>

                                    <div class="product__main-info-rate-wrap">
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                        <i class="fas fa-star product__main-info-rate"></i>
                                    </div>

                                    <div class="product__main-info-price">
                                        <span class="product__main-info-price-current">
                                            140.000đ
                                        </span>
                                    </div>

                                    <div class="product__main-info-description">
                                        Tai nghe headphone chất âm trong trẻo, kiểu dáng hiện đại, trẻ trung, phù hợp vơ mọi dòng máy,....
                                    </div> 

                                    <div class="product__main-info-cart">
                                        <div class="product__main-info-cart-quantity">
                                            <input type="button" value="-"  class="product__main-info-cart-quantity-minus">
                                            <input type="number" step="1" min="1" max="999" value="1" class="product__main-info-cart-quantity-total">
                                            <input type="button" value="+" class="product__main-info-cart-quantity-plus">
                                        </div>

                                        <div class="product__main-info-cart-btn-wrap">
                                            <button class="product__main-info-cart-btn">
                                                Thêm vào giỏ hàng
                                            </button>
                                        </div>
                                    </div>

                                    <div class="product__main-info-contact">
                                        <a href="#" class="product__main-info-contact-fb">
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
                                                    ( 0352.860.701)
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
                                    <a href="#" class="product__main-tab-link">
                                        Đánh giá
                                    </a>
                                </div>

                                <div class="col-12 product__main-content-wrap">
                                    <h2 class="product__main-content-heading">
                                        Tai nghe Corsair HS70 Pro Wireless Carbon
                                    </h2>

                                    <!--                                <p>
                                                                        <span>Trong gần một thế kỷ qua ,</span> nhiều nhà giáo dục đã tiến hành nghiên cứu và ghi nhận về những lợi ích của việc học tập qua trải nghiệm, thực hành, và lấy người học làm trung tâm. Nhà bác học Albert Einstein đã từng nói: “Ví dụ không phải là một cách khác để dạy học; ví dụ là cách duy nhất để dạy học”. Hầu như giáo viên nào cũng hiểu về sự hấp dẫn của việc học tập gắn liền với thực tế so với lớp học thuần lý thuyết.
                                                                    </p>
                                    
                                                                    <p>
                                                                        <span> Hai tác giả Hoàng Anh Đức và Tô Thụy Diễm Quyên </span> muốn đưa ra cách tiếp cận nhẹ nhàng và trực quan cho cả các giáo viên lẫn học sinh đối với Học tập qua dự án; sử dụng các dự án để làm những ví dụ đa dạng, đa chiều và gắn liền với thực tế nhất, qua đó giúp người đọc tự xây dựng nên kho tàng kiến thức và kỹ năng của chính bản thân mình.
                                                                    </p>
                                    
                                                                    <p>
                                                                        <span>Học tập qua dự án (PBL)</span> là một mô hình tổ chức lớp học nhằm làm năng động hoá lớp học truyền thống vốn lấy bài học làm trung tâm và giáo viên là trọng tâm. Học tập qua dự án hướng tới mục tiêu lâu dài, lấy người học làm trung tâm, liên nội dung và tích hợp các vấn đề thực hành thực tế. Bằng việc giáo viên lùi lại, đảm nhận vai trò dẫn dắt và trao quyền cho học sinh làm chủ quá trình học tập, học sinh hình thành tinh thần trách nhiệm đối với việc học, từ đó tạo dựng môi trường học tập chủ động hơn
                                                                    </p>
                                                                    <p> <span>Sách gồm 4 phần chính:</span></p>
                                                                    <p>
                                                                        <span>Phần I: Giới thiệu về học tập qua dự án</span> <br>
                                                                        Phần này gồm 3 chương, giới thiệu tổng quan về học tập qua dự án, 6 tính chất học tập của dự án học tập, và 8 bước triển khai học tập qua dự án trong trường phổ thông
                                                                    </p>
                                                                    <p>
                                                                        <span>Phần II: Triển khai dự án </span> <br>
                                                                        Phần này gồm 8 chương giúp giáo viên và học sinh biết cách đặt dự án vào một không gian phù hợp, biết cách triển khai dự án từ một không gian có sẵn.
                                                                    </p>
                                                                    <p>
                                                                        <span>Phần III: Giới thiệu về học tập qua dự án</span> <br>
                                                                        Phần này cung cấp kiến thức cơ bản về các biện pháp khác nhau để đánh giá Dự án học tập, cũng như các cấp độ khác nhau để đánh giá các hoạt động học tập.
                                                                    </p>
                                                                    <p>
                                                                        <span>Phần IV: Phụ lục </span> <br>
                                                                        Phần này mở rộng một số vấn đề như: Tư duy STEM trong học tập qua dự án, các vấn đề thường gặp và gợi ý hướng xử lí….
                                    
                                                                        Cuốn sách tích hợp với các mã QR code để giáo viên, học sinh có thể xem minh hoạ các dự án đã được thực hiện và đạt giải ở các cuộc thi Giáo viên sáng tạo.
                                                                    </p>
                                                                    <p>Trân trọng giới thiệu cùng bạn đọc.</p>-->

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
                                    <div class="product__aside-item product__aside-item--border">
                                        <div class="product__aside-img-wrap">
                                            <img src="images1/product/t1.jpg" class="product__aside-img">
                                        </div>
                                        <div class="product__aside-title">
                                            <a href="#" class="product__aside-link">
                                                <h4 class="product__aside-link-heading"> Tai nghe Corsair HS70 Pro Wireless Carbon</h4>
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
                                                    72.250
                                                </span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="product__aside-item">
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
                                    </div>

                                    <div class="product__aside-item">
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
                                    </div>                                                        
                                </div>
                            </div>
                        </aside>

                    </div>

                    <div class="customer-reviews row pb-4 pb-4  py-4 pb-4 py-4 py-4">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <h3 >Bình luận sản phẩm</h3>
                            <form id ="formgroupcomment" method="post">
                                <div class="form-group">
                                    <label>Tên:</label>
                                    <input name="comm_name" required="" type="text" id ='form-name' class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Email:</label>
                                    <input name="comm_mail" required="" type="email"  class="form-control" id="pwd">
                                </div>
                                <div class="form-group">
                                    <label>Nội dung:</label>
                                    <textarea name="comm_details" required="" rows="8" id ='formcontent' class="form-control"></textarea>     
                                </div>
                                <button type="submit" name="sbm" id= "submitcomment" class="btn btn-primary">Gửi</button>
                            </form> 
                        </div>
                    </div>

                    <div class="product-comment row pb-4 pb-4  py-4 pb-4 py-4 py-4">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <div class="comment-item">
                                <ul class = item-reviewer>
                                    <div class="comment-item-user">
                                        <img src="images/img/1.png" alt="" class="comment-item-user-img">

                                        <li><b>Nguyễn Nhung</b></li> 
                                    </div>

                                    <br>
                                    <li>2021-08-17 20:40:10</li>
                                    <li>
                                        <h4>Sản phẩm tốt</h4>
                                    </li>
                                </ul>
                            </div>
                            <div class="comment-item">
                                <ul class = item-reviewer> 
                                    <div class="comment-item-user">
                                        <img src="images/img/2.png" alt="" class="comment-item-user-img">
                                        <li><b>Tùng Lương</b></li> 
                                    </div>

                                    <br>
                                    <li>2021-02-17 12:20:10</li>
                                    <li>
                                        <h4>Hàng được đóng rất cẩn thận, hộp ko bị móp méo gì cả .... , giao hàng chậm cả tuần, Rõ trên app báo hàng đến kho rồi cả tuần k thấy đâu </h4>
                                </ul>
                            </div>                                 
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
                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                <div class="product__panel-img-wrap">
                                    <img src="images1/product/t1.jpg" alt="" class="product__panel-img">
                                </div>
                                <h3 class="product__panel-heading">
                                    <a href="#" class="product__panel-link">Tai nghe Corsair HS70 Pro Wireless Carbon</a>
                                </h3>
                                <div class="product__panel-rate-wrap">
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                </div>

                                <div class="product__panel-price">
                                    <span class="product__panel-price-old product__panel-price-old-hide">
                                        300.000đ
                                    </span>
                                    <span class="product__panel-price-current">
                                        273.000đ
                                    </span>
                                </div>  
                            </div>

                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                <div class="product__panel-img-wrap">
                                    <img src="images1/product/t2.jpg" alt="" class="product__panel-img">
                                </div>
                                <h3 class="product__panel-heading">
                                    <a href="#" class="product__panel-link">Tai nghe Havit H2002D</a>
                                </h3>
                                <div class="product__panel-rate-wrap">
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                </div>

                                <div class="product__panel-price">
                                    <span class="product__panel-price-old product__panel-price-old-hide">
                                        150.000đ
                                    </span>
                                    <span class="product__panel-price-current">
                                        120.000đ
                                    </span>
                                </div> 
                            </div>

                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                <div class="product__panel-img-wrap">
                                    <img src="images1/product/t3.jpg" alt="" class="product__panel-img">
                                </div>
                                <h3 class="product__panel-heading">
                                    <a href="#" class="product__panel-link">Tai nghe Gaming HAVIT H2028U</a>
                                </h3>
                                <div class="product__panel-rate-wrap">
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                </div>

                                <div class="product__panel-price">
                                    <span class="product__panel-price-old product__panel-price-old-hide
                                          ">
                                        50.000đ
                                    </span>
                                    <span class="product__panel-price-current">
                                        47.200đ
                                    </span>
                                </div>
                            </div>
                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                <div class="product__panel-img-wrap">
                                    <img src="images1/product/t4.jpg" alt="" class="product__panel-img">
                                </div>
                                <h3 class="product__panel-heading">
                                    <a href="#" class="product__panel-link">Tai nghe Havit H2008D</a>
                                </h3>
                                <div class="product__panel-rate-wrap">
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                </div>

                                <div class="product__panel-price">
                                    <span class="product__panel-price-old product__panel-price-old-hide">
                                        30.000đ
                                    </span>
                                    <span class="product__panel-price-current">
                                        24.000đ
                                    </span>
                                </div> 
                            </div>

                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                <div class="product__panel-img-wrap">
                                    <img src="images1/product/t5.jpg" alt="" class="product__panel-img" width="110">
                                </div>
                                <h3 class="product__panel-heading">
                                    <a href="#" class="product__panel-link">Tai nghe Razer Hammerhead PRO V2 <br>

                                    </a>
                                </h3>
                                <div class="product__panel-rate-wrap">
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                </div>

                                <div class="product__panel-price">
                                    <span class="product__panel-price-old product__panel-price-old-hide">
                                        62.000đ
                                    </span>
                                    <span class="product__panel-price-current">
                                        37.200đ
                                    </span>
                                </div> 
                            </div>

                            <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                                <div class="product__panel-img-wrap">
                                    <img src="images1/product/t6.jpg" alt="" class="product__panel-img" >
                                </div>
                                <h3 class="product__panel-heading">
                                    <a href="#" class="product__panel-link">Tai nghe HyperX Cloud Earbuds 
                                    </a>
                                </h3>
                                <div class="product__panel-rate-wrap">
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                    <i class="fas fa-star product__panel-rate"></i>
                                </div>

                                <div class="product__panel-price">
                                    <span class="product__panel-price-old product__panel-price-old-hide">
                                        85.000đ
                                    </span>
                                    <span class="product__panel-price-current">
                                        72.250đ
                                    </span>
                                </div> 
                            </div>
                        </div>
                    </section>
                </div>
            </section>
            <!--product -->
            <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>

        <!-- end footer -->

        <script src="js/jq.js"></script>
        <script src="js/product.js"></script>

    </body>
</html>