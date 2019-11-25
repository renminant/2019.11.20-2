<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<form method="post" action="/ren/bookUpdate.action" enctype="multipart/form-data">
<div class="main">
	<div class="optitle clearfix">
		<div class="title">图书管理&gt;&gt;</div>
	</div>

		<input type="hidden" name="book_id" value="${book.book_id}">
		<div class="content">
			<table class="box">
			   <tbody>
			   <tr>
				   <td class="field">书籍编号：</td>
				   <td><input type="hidden" name="book_id" value="${book.book_id}"> ${book.book_id}</td>
			   </tr>
			   <tr>
					<td class="field">书籍名称：</td>
					<td><input type="text" name="name" class="text" id="productName" value="<c:out value="${book.name}"></c:out>"> <font color="red">*</font><font color="red" id="productName_span"></font></td>
				</tr>
				 <tr>
					<td class="field">作者：</td>
					<td><input type="text" name="author" class="text" id="productUnit" value="<c:out value="${book.author}"></c:out>"> <font color="red">*</font><font color="red" id="productUnit_span"></font></td>
				</tr>
				<tr>
					<td class="field">书籍数量：</td>
					<td><input type="text" name="booknumber" class="text" id="productCount" value="<c:out value="${book.booknumber}"></c:out>"> <font color="red">*</font><font color="red" id="productCount_span"></font></td>
				</tr>
				<tr>
					<td class="field">总额：</td>
					<td><input name="price" id="billMoney" class="text" value="<c:out value="${book.price}"></c:out>"><font color="red">*</font><font color="red" id="billMoney_span"></font></td>
				</tr>
			   <tr>
					<td class="field">出版社：</td>
					<td>
						<select name="press" id="proId">
							
								<option value="0" <c:if  test="${book.press=='0'}">selected</c:if>>中华出版社</option>
							
								<option value="1" <c:if  test="${book.press=='1'}">selected</c:if>>清华出版社</option>
							
								<option value="2" <c:if  test="${book.press=='2'}">selected</c:if>>成光出版社</option>
							
						</select>
						<font color="red">*</font><font color="red" id="proId_span"></font>
					</td>
				</tr>
				 <tr>
					<td class="field">是否借出：</td>
					<td>
						<input type="radio" name="borrower" value="1" <c:if  test="${book.borrower=='1'}">checked</c:if>>是
						<input type="radio" name="borrower" value="0" <c:if  test="${book.borrower=='0'}">checked</c:if>>否
					</td>
				</tr>

			   <tr>
				   <td class="field">头像</td>
				   <td>
					   <img src="/pic/${book.headpathbook}" width="30" height="30"/>
					   <input type="file" name="pictureFile" value="${book.headpathbook}" />
				   </td>
				   <%--<td>--%>
					   <%--<img src="/pic/${book.headpathbook}" width="30" height="30"/>--%>
					   <%--<input type="file" name="pictureFile"  readonly/>--%>
				   <%--</td>--%>
			   </tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="update" id="update" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>


</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bill/update.js"></script>

</form>
</body>
</html>