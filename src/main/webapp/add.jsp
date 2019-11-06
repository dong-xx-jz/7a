<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index_work.css"/> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
</head>
<body>
	<h1>新增商品页面</h1>
	<form action="insertGoods" method="post" enctype="multipart/form-data">
		商品名称:<input type="text" name="gname"><br/><br/>
		英文名称:<input type="text" name="gnameEng"><br/><br/>
		商品品牌:<select name="bid">
					<option>==请选择品牌==</option>
				</select><br/><br/>
		商品种类:<select name="kid">
					<option>==请选择种类==</option>
				</select><br/><br/>
		尺寸:<input type="text" name="size"><br/><br/>
		单价(元):<input type="text" name="price"><br/><br/>
		数量:<input type="text" name="number"><br/><br/>
		标签:<input type="text" name="label"><br/><br/>
		商品图片上传:<input type="file" name="photo"><br/><br/>
		<input type="submit" value="提交">
	</form>
</body>
<script type="text/javascript">

	$.post(
		"queryBrandList",
		function(data){
			if (data != null) {
				var str = "";
				for ( var i in data) {
					str += "<option value='"+data[i].bid+"'>"+data[i].bname+"</option>";
				}
				$("[name=bid]").append(str);
			}
		},
		"json"
	)

	$.post(
		"queryKindList",
		function(data){
			if (data != null) {
				var str = "";
				for ( var i in data) {
					str += "<option value='"+data[i].kid+"'>"+data[i].kname+"</option>";
				}
				$("[name=kid]").append(str);
			}
		},
		"json"
	)







</script>
</html>