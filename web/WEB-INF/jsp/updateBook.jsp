<%--
  Created by IntelliJ IDEA.
  User: AVloger
  Date: 2021/11/28
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookID" value="${Qbook.bookID}">
        书籍名称：<input type="text" name="bookName" value="${Qbook.bookName}" required><br><br><br>
        书籍数量：<input type="text" name="bookCounts" value="${Qbook.bookCounts}" required><br><br><br>
        书籍详情：<input type="text" name="detail" value="${Qbook.detail}" required><br><br><br>
        <input type="submit" value="修改">
    </form>

</div>
</body>
</html>
