<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/4/2022
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <style>
        #header {
            background-color: teal;
            /*position: fixed;*/
        }

        #nav-bar {
            background-color: cornflowerblue;
            /*position: absolute;*/
        }

        #side-bar {
            background-color: lightgreen;
        }

        #content {
            padding-top: 40px;
            background-color: lightseagreen;
        }

        #title {
            margin-top: 5%;
            color: gold;
        }
        #footer{
            background-color: brown;
            text-align: center;
        }
    </style>

</head>
<body>
<div class="container-fluid p-0">
    <div id="head">
        <div class="row" id="header">
            <div class="col-6 col-md-4"><img
                    src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg"
                    width="25%" alt=""></div>
            <div class="col-md-6"><h1 id="title">Furama Manager</h1></div>
            <div class="col-md-2">huu trung</div>
        </div>
        <div class="row" id="nav-bar">
            <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-center w-100">
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
                        <a class="nav-link" href="/employees">Employee</a>
                        <a class="nav-link" href="/customers">Customer</a>
                        <a class="nav-link" href="/services">Service</a>
                        <a class="nav-link" href="/contracts">Contract</a>
                    </div>
                </div>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-6 col-md-3" id="side-bar">
            <ul class="list-group">
                <li class="list-group-item">item one</li>
                <li class="list-group-item list-group-item-primary">item two</li>
                <li class="list-group-item list-group-item-secondary">item three</li>
                <li class="list-group-item list-group-item-success">item four</li>
            </ul>
        </div>
        <div class="col-6 col-md-9" id="content">
            <h5>Mở theo lời giai điệu</h5>
            <p id="mo-theo-loi-giai-dieu">Bao la là tiếng nói của độ lượng. Đời không thấy tha thứ cho nhau mà vẫn mơ
                ước
                bao la. Ai cũng thích những cánh đồng mênh mông,
                những chân trời rộng mở. Sao mà lắt léo thế? Con người luôn luôn sẵn sàng tham dự những chuyến đi bồng
                bềnh,
                sảng khói với
                những chân trời không thấy. Thèm gió bể khơi. Thèm núi đồi trùng điệp. Hân hoan reo ca cùng chim chóc.
                Nâng
                niu những hoa đồng cỏ nội.
                Ai cũng thế. Không riêng ai. Đến với đất trời như những đứa con của vũ trụ, mà tấm lòng thì đóng kín tối
                tăm.
                Sao mà biển lận với trời đất quá vậy? <br> <br> Đời đã mở cho ta những cõi rộng. Mà lòng nhân gian thì
                quá
                hẹp hòi.
                Có cái gì bất trắc mà nẩy sinh như thế. Đã vậy thì không nên sàm sỡ thốt tiếng bao la, mở lời rộng rãi.
                Đánh lừa thiên hạ còn khả thứ. Đừng bất kính với đất trời. Chưa bao giờ đóa sen, đóa hồng nở một cách
                gian
                dối.
                Lòng không nở được một điều gì tốt đẹp thì thôi. Đừng ép gượng. <br> <br> Con người ta cũng hay đấy chứ.
                Dễ quên có phải là cái vốn liếng ở đời? Sống với người thì hẹp. Hẹp quá! Mai đây ra đứng trước cõi bao
                la
                thì nói chuyện phiêu bồng.
                Vả chăng, trời đất cũng dễ tính. Làm gì có chuyện trời đất ganh đua với người. Có chăng, chỉ là ganh với
                hồng nhan, với tài mệnh. <br> <br>
                Thế ra, ông Trời cũng khéo lắm. Cũng bày ra những cuộc chơi riêng. Chơi với kẻ tương xứng. Hiểu ra như
                thế
                thì những định mệnh nổi trôi mới khỏi buồn. <br> <br>
                Thời nào cũng có những hồng nhan đa truân. Bất cứ ở đâu. Kiều năm xưa hay Kiều nay thì cũng vậy. Gặp
                được
                người đồng điệu thì nói ngay tiếng nặng tình.
                Tinh lắm. Đã gặp được thì không bao giờ gieo lời mắc mỏ. Làm vậy, không những xấu mặc, mà xấu lòng.<br>
                <br>
                Hình như có sự xếp đặt của ai đây.
                Bàn tay ghép gán quả là tài tình lắm. Tài tình và tài tử. Tài tử trong cái nghĩ ẩn báu lộng ngọc của
                cuộc
                đời.
                Bởi khi ta chạm đến tấm lòng quí giá kia của Kiều thì lập tức ta gặp cái bao la của trời đất.
                Hay lắm! Quỷ quyệt đến thế thì hết sức. <br> <br>Và – cái bao la kia là gì vậy? Là gì mà ai nấy đều nặng
                lòng với?
                Có kẻ đứng trước bao la mà không thấy được bao la. Có kẻ ở buổi bình minh, nghe tiếng chim hót đã chạm
                mặt
                với cõi vô lượng.
                Biết được vô lượng là cùng lúc đến với vô biên. Hay đôi khi gắn bó, hòa lẫn với nhau trong một cuộc hôn
                phối
                son sắt.
                Qua tay kẻ phàm nhân, cái vô biên được ví von đối chiếu nghịch lý với cuộc đời hữu hạn của con người.
                Nhưng nếu rảnh rỗi một chút hãy ra nhìn sông nước thử. Cái vô biên nằm đâu đó trên cánh vạc chở hoàng
                hôn về
                núi mỗi chiều. <br><br>
                Chạm đến vô biên là nhắc nhở cái lý sinh tử ở đời. Là muốn tầm tích con đường vô định của sự sống chết.
                Thường khi nó gây nên sự buồn bã không nguôi trong kiếp nhân sinh. Trái lại, đi vào cõi bao la người ta
                nhận
                ra được nỗi hân hoan trong lòng.
                Khi bắt được cái nhịp của trời đất, lòng ta bỗng reo ca, nhảy múa trong một hòa âm thuận chiều. Một cái
                gì
                đó soi tỏ đời ta như đạo đạt.
                Đó là cái bước nhảy hân hoan, nối liền trời với đất, của Zorba trên bờ biển. Cái hạnh phúc đó không đến
                với
                mọi người.
                Cái sự hòa nhịp kia cũng không thể có nếu lòng ta không được trang bị vẻ thênh thang của vũ trụ.
                Có thực sự chạm đến cõi vĩnh phúc vô hình, mới hý lộng, mới nhảy múa say sưa đến thế được. <br><br>
                Cho nên, nói đến chuyện riêng chung của trời đất là nói trong cái lý đó vậy. Cũng không dễ gì tập tành
                sự độ
                lượng.
                Muốn có được phải làm cả một cuộc đổi đời. Thay cái nhìn. Thay trí óc. Và tuyệt đối phải có một con tim
                đẹp
                đẽ. <br><br>
                Nếu không, cái tình với cõi bao la kia chỉ là cái tình gian lận. Và còn thú vị gì một cuộc chơi thiếu
                hào
                hứng như thế.
                Trời đất nương ta, nhưng ta vốn như con bệnh, thủy chung không phát giác được gì.
                Con mắt rêu phong đã đóng kín ta lại với thế giới ích kỷ, hẹp hòi, riêng tư. Làm sao còn nghe ra tiếng
                hoan
                ca của thế giới bên ngoài.
                Nếu bảo là nghe, thì sao lại có thể thiếu hòa điệu đến thế được. Chân tay trì trệ. Đời sống như đóng
                đinh,
                xa cách. Đừng mưu toan với trời đất.
                Hạnh phúc xa lạ kia chỉ dành cho người có lòng. Kẻ hời hợt dễ đàm tiếu, thị phi về cái hạnh phúc đó lắm.
                Bởi
                nhìn gần, hạnh phúc đó có vẻ phù du quá.
                Không mang lại áo cơm. Đến thế thì còn nói thêm được một lời nào nữa. Hãy ôm lấy cái phần của mình. Kẻ
                nổi
                trôi gặp người trôi nổi.
                Cứ theo trời xa đất rộng kia mà rong chơi vui thú một đời vậy. <br> <br> <br> Tháng 9 1973 <br> Trịnh
                Công
                Sơn<br>...</p>
        </div>
    </div>
    <div class="row" id="footer">
        <div class="col-12">huutrung@2022</div>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
        integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
</html>
