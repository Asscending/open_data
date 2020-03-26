<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		font-size: .9em;
        color: #4a4a4a;
	}
    a{
        text-decoration-line: none;
        color: #4a4a4a;
    }
    body{
        margin: 0;
        padding: 0;
    }
    .searchBox{
        width: 90%;
        margin: 10px auto;
    }
    .header{
    background: rgb(55, 47, 129);
    overflow: hidden;
    padding: 20px;
    text-align: center;
    }
    .header h1{
        text-transform: uppercase;
        color: white;
        margin: 0;
        margin-bottom: 8px;
    }
    #value{
        border: none;
        background: rgb(131, 137, 219);
        padding: 6px;
        font-size: 18px;
        width: 80%;
        border-radius: 6px;
        color: white;
    }
    #value:focus{
        outline: none;
    }
    .container{
        background: rgb(190, 204, 243);
        padding: 1%;
        width:40%;
    }
    .cultureDetail{
        background: rgb(190, 204, 243);
        padding: 1%;
        align-items: center;
    }
    .item{
        margin: 3% 0px;
        display: flex;
        align-items: center;
    }
    .name{
        font-size: 17px;
        font-weight: 470;
        color: #333;
    }
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    var go = ["종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구","도봉구","노원구","은평구","서대문구","마포구",
            "양천구","강서구","구로구","금천구","영등포구","동작구","관악구","서초구","강남구","송파구","강동구"];
    var addr;
    function filter(){
        var value, name, item, i;
        value = document.getElementById("value").value.toUpperCase();
        item = document.getElementsByClassName("item");
        for(var i=0;i<item.length;i++){
            name = item[i].getElementsByClassName("name");
            if(name[0].innerHTML.toUpperCase().indexOf(value)>-1){
                item[i].style.display = "flex";
            }else{
                item[i].style.display="none";
            }
        }
    }

    $(function() {
        var result;
		$.getJSON("culture.json",function(data){
			console.log(data);
            var str = [];
            result = data.DATA;
            for(var i = 0; i < result.length; i++){
            	str.push("<div idx ="+i+" id='detail' class= 'item' style='margin: 1em 1em 1em 1em;'>");
                str.push("<div class='name'>"+result[i].fac_name+" / </div>");
                str.push("<div>&nbsp;주소 :"+result[i].addr+"</div>");
                str.push("</div>");
            }
            $(".container").html(str.join(""));
        })

        //셀렉트 옵션 추가
        $.each(go, function(idx, item){
            var option = $("<option class='opt' idx="+idx+"></option>").text(item).attr("addr",item);
            $("#select").append(option);
        })
        
        $(document).on("click",".opt",function(){
            addr = $(this).attr("addr");
            
        })

        $(document).on("click","#goBtn", function(){
            
        })

        $(document).on("click","#detail",function(){
            $("#cultureDetail").text("");
            var idx = $(this).attr("idx");
            var title = result[idx].fac_name;
            var phone = result[idx].phne;
            var homepage = "http://"+result[idx].homepage;
            var closeday = result[idx].closeday;
            var c1 = $("<h2></h2>").html("기관이름 : "+title);
            var c2 = $("<h3></h3>").html("전화번호 : "+phone);
            var c3 = $("<h3></h3>").html("휴관정보 : "+closeday);
            var c4 = $("<a></a>").attr("href",homepage).html(homepage);
            $("#cultureDetail").append(c1,c2,c3,c4);
        });


	});
</script>
</head>
<body>
    <div class="searchBox">
        <div class="header">
            <h1>서울 문화 예술 공간</h1>
            <input onkeyup="filter()" type="text" id="value" placeholder="찾으실 문화 예술 공간을 입력하세요."><br>
            
        </div>
    </div>
    <select id="select"></select>
    <div id="cultureDetail" class="cultureDetail"></div>
    <hr>
    <div class="container"></div><button id="goBtn">자치구</button>
</body>
</html>