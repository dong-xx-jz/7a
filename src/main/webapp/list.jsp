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
	<a href="add.jsp"><input type="button" value="新增商品"></a>
	<input type="button" value="批量删除" onclick="deleteAll()">
	<table border="1">
		<tr>
			<td>选择</td>
			<td>编号</td>
			<td>商品名称</td>
			<td>英文名称</td>
			<td>商品品牌</td>
			<td>商品种类</td>
			<td>尺寸</td>
			<td>单价(元)</td>
			<td>数量</td>
			<td>标签</td>
			<td>商品图片</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="g">
		<tr>
			<td><input type="checkbox" class="gids" value="${g.gid }"></td>
			<td>${g.gid }</td>
			<td>${g.gname }</td>
			<td>${g.gnameEng }</td>
			<td>${g.bname }</td>
			<td>${g.kname }</td>
			<td>${g.size }</td>
			<td>${g.price }</td>
			<td>${g.number }</td>
			<td>${g.label }</td>
			<td><img alt="xxx" src="<%=request.getContextPath()%>/lookingImg?path=${g.picurl }" width="70" height="50"></td>
			<td>
				<a href="update.jsp?gid=${g.gid }"><input type="button" value="商品编辑"></a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="12">
				<a href="?pageNum=1">首页</a>
				<a href="?pageNum=${page.pageNum-1 < 1 ? page.pageNum : page.pageNum-1 }">上一页</a>
				<a href="?pageNum=${page.pageNum+1 > page.pages ? page.pageNum : page.pageNum+1 }">下一页</a>
				<a href="?pageNum=${page.pages }">尾页</a>
				共${page.pages }页
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	
	function deleteAll(){
		var gids = $(".gids").map(function(){
			return $(this).val();
		}).get().join(",");
		if (confirm("您确认要删除编号为"+gids+"的数据吗?")) {
			$.post(
				"deleteGoods",
				{gids:gids},
				function(data){
					if (data > 0) {
						alert("删除成功!");
						location.href = "list";
					} else {
						alert("删除失败!");
					}
				},
				"json"
			)
		}
	}
	
	
	
	
	
	
</script>
</html>