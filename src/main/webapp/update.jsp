<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index_work.css"/> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
</head>
<body>
	<h1>商品修改页面</h1>
	<form action="updateGoods" method="post" enctype="multipart/form-data">
		<input type="hidden" name="gid"><br/><br/>
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
		
		<input type="submit" value="修改">
	</form>
</body>
<script type="text/javascript">

	var gid = ${param.gid};

	$.post(
		"/queryGoodsById",
		{gid:gid},
		function(data){
			if (data != null) {
				$("[name=gid]").val(gid);
				$("[name=gname]").val(data.gname);
				$("[name=gnameEng]").val(data.gnameEng);
				$("[name=size]").val(data.size);
				$("[name=price]").val(data.price);
				$("[name=number]").val(data.number);
				$("[name=label]").val(data.label);
				
				$.post(
					"/queryBrandList",
					function(obj){
						if (obj != null) {
							var str = "";
							for ( var i in obj) {
								if (data.bid == obj[i].bid) {
									str += "<option value='"+obj[i].bid+"' selected>"+obj[i].bname+"</option>";
								} else {
									str += "<option value='"+obj[i].bid+"'>"+obj[i].bname+"</option>";
								}
							}
							$("[name=bid]").append(str);
						}
					},
					"json"
				)
				
				$.post(
					"/queryKindList",
					function(obj){
						if (obj != null) {
							var str = "";
							for ( var i in obj) {
								if (data.kid == obj[i].kid) {
									str += "<option value='"+obj[i].kid+"' selected>"+obj[i].kname+"</option>";
								} else {
									str += "<option value='"+obj[i].kid+"'>"+obj[i].kname+"</option>";
								}
							}
							$("[name=kid]").append(str);
						}
					},
					"json"
				)
				
				$("[name=photo]").after("<img alt='xxx' src='<%=request.getContextPath()%>/lookingImg?path="+data.picurl+"'  width='70' height='50'>");
				
			}
		},
		"json"
	)




</script>
</html>