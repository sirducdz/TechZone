<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>TECHZONE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/compare.css">
        <link rel="stylesheet" href="css/product.css">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <style>
            h1{
                text-align: center;
                margin: 20px 0px 20px 0px;
            }
            u{
                font-size: 25px;
            }
        </style>
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!--end header-->
            <!-- score-top-->
            
            <h1>So sánh: <u>cái gì đó</u></h1>
            
            
            <div class="container pb-5 mb-2">
                <div class="comparison-table">
                    <table class="table table-bordered">
                        <thead class="bg-secondary">
                            <tr style="text-align: center">
                                <td>
                                    <input type="text" name="name" value="Cái gì đó" style="padding: 0 12px"><br>
                                    <img src="https://images.fpt.shop/unsafe/fit-in/240x240/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2023/3/31/638158962810512367_ss-galaxy-s22-dd-icon.jpg" width="180px" height="180px" style="margin: 10px 0px 10px 0px"/><br>
                                    Giá chỉ có: <br>
                                    <a href="#" target="target"><h5>Xem chi tiết</h5></a>
                                </td>
                                <td><input type="text" name="name" placeholder="Search..." style="padding: 0 12px"></td>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <div class="container pb-5 mb-2">
                <div class="comparison-table">
                    <table class="table table-bordered">
                        <thead class="bg-secondary">
                            <tr>
                                <td class="align-middle" colspan="3">
                                    <select class="form-control custom-select" id="compare-criteria" data-filter="trigger">
                                        <option value="all">Hiển thị tất cả</option>
                                        <option value="summary">Summary</option>
                                        <option value="general">General</option>
                                        <option value="multimedia">Multimedia</option>
                                        <option value="performance">Performance</option>
                                        <option value="design">Design</option>
                                        <option value="display">Display</option>
                                        <option value="storage">Storage</option>
                                        <option value="camera">Camera</option>
                                        <option value="battery">Battery</option>
                                        <option value="price">Price &amp; rating</option>
                                    </select>
                                </td>
                            </tr>
                        </thead>
                        <tbody id="summary" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Summary</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Performance</th>
                                <td>Hexa Core</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Display</th>
                                <td>6.5-inch</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Storage</th>
                                <td>64 GB</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Camera</th>
                                <td>Dual 12-megapixel</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Battery</th>
                                <td>3,174 mAh</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="general" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">General</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Quick charging</th>
                                <td>Yes</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Operating system</th>
                                <td>iOS v12</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Sim slots</th>
                                <td>Single SIM, GSM</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Launch date</th>
                                <td>September 12, 2018 (Official)</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Sim size</th>
                                <td>SIM1: Nano</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Network</th>
                                <td>4G: Available (supports Indian bands) 3G: Available, 2G: Available</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Fingerprint sensor</th>
                                <td>None (Face ID)</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="multimedia" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Multimedia</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Loudspeaker</th>
                                <td>Yes</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>FM radio</th>
                                <td>No</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Headphone jack</th>
                                <td>No</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="performance" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Performance</th>
                                <td>Apple iPhone Xs Ma</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Processor</th>
                                <td>Apple A12 Bionic</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Graphics</th>
                                <td>Apple GPU (4-core graphics)</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Architecture</th>
                                <td>64 bit</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>RAM</th>
                                <td>4 GB</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="design" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Design</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Build material</th>
                                <td>Case: AluminiumBack: Mineral Glass</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Thickness</th>
                                <td>7.7 mm</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Width</th>
                                <td>70.9 mm</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Height</th>
                                <td>143.6 mm</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Weight</th>
                                <td>174 grams</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Waterproof</th>
                                <td>Yes Water resistant (up to 30 minutes in a depth of 1 meter), IP67</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Colors</th>
                                <td>Silver, Space Grey</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="display" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Display</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Display type</th>
                                <td>Super Retina OLED</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Pixel density</th>
                                <td>458 ppi</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Screen protection</th>
                                <td>Yes</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Screen size</th>
                                <td>6.5 inches</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Screen resolution</th>
                                <td>1125 x 2436 pixels</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Touch screen</th>
                                <td>Yes, 3D Touch Touchscreen, Multi-touch</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="storage" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Storage</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Internal memory</th>
                                <td>64 GB</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Expandable memory</th>
                                <td>No</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="camera" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Camera</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Settings</th>
                                <td>Exposure compensation, ISO control</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Aperture</th>
                                <td>F2.2</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Camera features</th>
                                <td>10 x Digital zoom, Optical zoom, Auto flash, Face detection, Touch to focus</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Image resolution</th>
                                <td>4000 x 3000 pixels</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Sensor</th>
                                <td>BSI sensor</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Autofocus</th>
                                <td>Yes</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Shooting modes</th>
                                <td>Continuos shooting, High dynamic range mode (HDR), Burst mode</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Optical image stabilisation</th>
                                <td>Yes, Dual optical image stabilization</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Flash</th>
                                <td>Yes, Retina flash</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="battery" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Battery</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Talktime</th>
                                <td>Up to 21 hours(4G)</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Quick charging</th>
                                <td>Yes, fast, 50 % in 30 minutes</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Wireless charging</th>
                                <td>Yes</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Type</th>
                                <td>Li-ion</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Capacity</th>
                                <td>3,174 mAh</td>
                                <td></td>
                            </tr>
                        </tbody>
                        <tbody id="price" data-filter="target">
                            <tr class="bg-secondary">
                                <th class="text-uppercase">Price &amp; rating</th>
                                <td>Apple iPhone Xs Max</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Price</th>
                                <td>$1,099</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Rating</th>
                                <td>4.5/5</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Thêm vào giỏ hàng</button>
                                </td>
                                <td>
                                    
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <!--footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        <!--end footer-->
        <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></i></button>

        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">
    $(function () {
        $('[data-filter="trigger"]').on("change", function () {
            var t = $(this).find("option:selected").val().toLowerCase();

            $('[data-filter="target"]').css("display", "none");
            $("#" + t).css("display", "table-row-group");
            if (t === "all") {
                $('[data-filter="target"]').css("display", "table-row-group")
            }
            $(this).css("display", "block");
        });
    })
        </script>
    </body>
</html>