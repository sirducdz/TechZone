<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>So sánh: <u>${product1.getName()}</u> VS <u>${product2.getName()}</u></h1>
        <div class="container pb-5 mb-2">
            <div class="comparison-table">
                <table class="table table-bordered">
                    <thead class="bg-secondary">
                        <tr style="text-align: center">
                            <td>
                                <input value="${product1.getName()}"  id='input1' oninput="searchFunct('input1','productList1')" type="text" name="name" style="padding: 0 12px; width: 320px; text-align: center"><br>
                                <ul id="productList1" style="list-style: none;"> 
                                </ul>
                                <img src="${product1.getPicture()}" width="180px" height="180px" style="margin: 10px 0px 10px 0px"/><br>
                                Giá chỉ có: ${product1.getSalePrice()}<br>
                                <a href="#" target="target"><h5>Xem chi tiết</h5></a>
                            </td>
                            <td>
                                <input value="${product2.getName()}"  id='input2' oninput="searchFunct('input2','productList2')" type="text" name="name" style="padding: 0 12px; width: 320px; text-align: center"><br>
                                <ul id="productList2" style="list-style: none;"> 
                                </ul>
                                <c:if test="${product2!=null}">
                                    <img src="${product2.getPicture()}" width="180px" height="180px" style="margin: 10px 0px 10px 0px"/><br>
                                </c:if>
                                <c:if test="${product2==null}">
                                    <img  width="180px" height="180px" style="margin: 10px 0px 10px 0px"/><br>
                                </c:if>
                                Giá chỉ có: ${product2.getSalePrice()}<br>
                                <a href="#" target="target"><h5>Xem chi tiết</h5></a>
                            </td>
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
                            <td>${product1.getName()}</td>
                            <td>${product2.getName()}</td>
                        </tr>
                        <tr>
                            <th>Performance</th>
                            <td>Hexa Core</td>
                            <td>Octa Core</td>
                        </tr>
                        <tr>
                            <th>Display</th>
                            <td>6.5-inch</td>
                            <td>6.3-inch</td>
                        </tr>
                        <tr>
                            <th>Storage</th>
                            <td>64 GB</td>
                            <td>64 GB</td>
                        </tr>
                        <tr>
                            <th>Camera</th>
                            <td>Dual 12-megapixel</td>
                            <td>12.2-megapixel</td>
                        </tr>
                        <tr>
                            <th>Battery</th>
                            <td>3,174 mAh</td>
                            <td>3,430 mAh</td>
                        </tr>
                    </tbody>
                    <tbody id="general" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">General</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Quick charging</th>
                            <td>Yes</td>
                            <td>Yes</td>
                        </tr>
                        <tr>
                            <th>Operating system</th>
                            <td>iOS v12</td>
                            <td>Android v9.0 Pie </td>
                        </tr>
                        <tr>
                            <th>Sim slots</th>
                            <td>Single SIM, GSM</td>
                            <td>Single SIM, GSM</td>
                        </tr>
                        <tr>
                            <th>Launch date</th>
                            <td>September 12, 2018 (Official)</td>
                            <td>November 1, 2018 (Official)</td>
                        </tr>
                        <tr>
                            <th>Sim size</th>
                            <td>SIM1: Nano</td>
                            <td>SIM1: Nano</td>
                        </tr>
                        <tr>
                            <th>Network</th>
                            <td>4G: Available (supports Indian bands) 3G: Available, 2G: Available</td>
                            <td>4G: Available (supports Indian bands) 3G: Available, 2G: Available</td>
                        </tr>
                        <tr>
                            <th>Fingerprint sensor</th>
                            <td>None (Face ID)</td>
                            <td>Back cover</td>
                        </tr>
                    </tbody>
                    <tbody id="multimedia" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Multimedia</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Loudspeaker</th>
                            <td>Yes</td>
                            <td>Yes</td>
                        </tr>
                        <tr>
                            <th>FM radio</th>
                            <td>No</td>
                            <td>No</td>
                        </tr>
                        <tr>
                            <th>Headphone jack</th>
                            <td>No</td>
                            <td>No</td>
                        </tr>
                    </tbody>
                    <tbody id="performance" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Performance</th>
                            <td>Apple iPhone Xs Ma</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Processor</th>
                            <td>Apple A12 Bionic</td>
                            <td>Qualcomm Snapdragon 845 (2.5GHz octa-core)</td>
                        </tr>
                        <tr>
                            <th>Graphics</th>
                            <td>Apple GPU (4-core graphics)</td>
                            <td>Adreno 630</td>
                        </tr>
                        <tr>
                            <th>Architecture</th>
                            <td>64 bit</td>
                            <td>64 bit</td>
                        </tr>
                        <tr>
                            <th>RAM</th>
                            <td>4 GB</td>
                            <td>4 GB</td>
                        </tr>
                    </tbody>
                    <tbody id="design" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Design</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Build material</th>
                            <td>Case: AluminiumBack: Mineral Glass</td>
                            <td>Case: AluminiumBack: Aluminium</td>
                        </tr>
                        <tr>
                            <th>Thickness</th>
                            <td>7.7 mm</td>
                            <td>7.9 mm</td>
                        </tr>
                        <tr>
                            <th>Width</th>
                            <td>70.9 mm</td>
                            <td>76.7 mm</td>
                        </tr>
                        <tr>
                            <th>Height</th>
                            <td>143.6 mm</td>
                            <td>157.9 mm</td>
                        </tr>
                        <tr>
                            <th>Weight</th>
                            <td>174 grams</td>
                            <td>175 grams</td>
                        </tr>
                        <tr>
                            <th>Waterproof</th>
                            <td>Yes Water resistant (up to 30 minutes in a depth of 1 meter), IP67</td>
                            <td>Yes Water resistant (up to 30 minutes in a depth of 1 meter), IP67</td>
                        </tr>
                        <tr>
                            <th>Colors</th>
                            <td>Silver, Space Grey</td>
                            <td>Black, Black and White</td>
                        </tr>
                    </tbody>
                    <tbody id="display" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Display</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Display type</th>
                            <td>Super Retina OLED</td>
                            <td>'flexible' OLED</td>
                        </tr>
                        <tr>
                            <th>Pixel density</th>
                            <td>458 ppi</td>
                            <td>522 ppi</td>
                        </tr>
                        <tr>
                            <th>Screen protection</th>
                            <td>Yes</td>
                            <td>Corning Gorilla Glass v5</td>
                        </tr>
                        <tr>
                            <th>Screen size</th>
                            <td>6.5 inches</td>
                            <td>6.3 inches</td>
                        </tr>
                        <tr>
                            <th>Screen resolution</th>
                            <td>1125 x 2436 pixels</td>
                            <td>1440 x 2880 pixels</td>
                        </tr>
                        <tr>
                            <th>Touch screen</th>
                            <td>Yes, 3D Touch Touchscreen, Multi-touch</td>
                            <td>Yes, Capacitive Touchscreen, Multi-touch</td>
                        </tr>
                    </tbody>
                    <tbody id="storage" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Storage</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Internal memory</th>
                            <td>64 GB</td>
                            <td>64 GB</td>
                        </tr>
                        <tr>
                            <th>Expandable memory</th>
                            <td>No</td>
                            <td>No</td>
                        </tr>
                    </tbody>
                    <tbody id="camera" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Camera</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Settings</th>
                            <td>Exposure compensation, ISO control</td>
                            <td>Exposure compensation, ISO control</td>
                        </tr>
                        <tr>
                            <th>Aperture</th>
                            <td>F2.2</td>
                            <td>F2.4</td>
                        </tr>
                        <tr>
                            <th>Camera features</th>
                            <td>10 x Digital zoom, Optical zoom, Auto flash, Face detection, Touch to focus</td>
                            <td>Fixed zocus</td>
                        </tr>
                        <tr>
                            <th>Image resolution</th>
                            <td>4000 x 3000 pixels</td>
                            <td>4000 x 3000 pixels</td>
                        </tr>
                        <tr>
                            <th>Sensor</th>
                            <td>BSI sensor</td>
                            <td>CMOS image sensor</td>
                        </tr>
                        <tr>
                            <th>Autofocus</th>
                            <td>Yes</td>
                            <td>No</td>
                        </tr>
                        <tr>
                            <th>Shooting modes</th>
                            <td>Continuos shooting, High dynamic range mode (HDR), Burst mode</td>
                            <td>Continuos shooting, High dynamic range mode (HDR)</td>
                        </tr>
                        <tr>
                            <th>Optical image stabilisation</th>
                            <td>Yes, Dual optical image stabilization</td>
                            <td>Yes</td>
                        </tr>
                        <tr>
                            <th>Flash</th>
                            <td>Yes, Retina flash</td>
                            <td>Yes, Dual LED flash</td>
                        </tr>
                    </tbody>
                    <tbody id="battery" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Battery</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Talktime</th>
                            <td>Up to 21 hours(4G)</td>
                            <td>Up to 24 hours(4G)</td>
                        </tr>
                        <tr>
                            <th>Quick charging</th>
                            <td>Yes, fast, 50 % in 30 minutes</td>
                            <td>Yes</td>
                        </tr>
                        <tr>
                            <th>Wireless charging</th>
                            <td>Yes</td>
                            <td>Yes</td>
                        </tr>
                        <tr>
                            <th>Type</th>
                            <td>Li-ion</td>
                            <td>Li-ion</td>
                        </tr>
                        <tr>
                            <th>Capacity</th>
                            <td>3,174 mAh</td>
                            <td>3,430 mAh</td>
                        </tr>
                    </tbody>
                    <tbody id="price" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Price &amp; rating</th>
                            <td>Apple iPhone Xs Max</td>
                            <td>Google Pixel 3 XL</td>
                        </tr>
                        <tr>
                            <th>Price</th>
                            <td>$1,099</td>
                            <td>$899</td>
                        </tr>
                        <tr>
                            <th>Rating</th>
                            <td>4.5/5</td>
                            <td>4.5/5</td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Thêm vào giỏ hàng</button>
                            </td>
                            <td>
                                <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Thêm vào giỏ hàng</button>
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
    <script>
        function searchFunct(input, ulType) {
            event.preventDefault();
            var inputValue = document.getElementById(input).value.trim();
            $.ajax({
                url: '/TechZone/view/CompareProductController',
                type: "post", //send it through get method
                data: {
                    productNameInput: inputValue,
                    inputType: input
                },
                success: function (data) {
                    var row = document.getElementById(ulType);
                    row.innerHTML = data;
//                    row.innerHTML += data;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }

    </script>
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