<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-12">
<a href="${pageContext.request.contextPath}/author/them" class="btn btn-primary">Add</a>
<form method="post" <%-- action="${pageContext.request.contextPath}/admin/author/dels.html" --%>>
<table class="table">
<tr>
<td><button class="btn btn-info">Delete</button> </td>
<th>Id</th>
<th>Name</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach items="${list}" var="o">
<tr>
<td>
<input type="checkbox" value="${o.id}" name="ids">
</td>
<td>${o.id}</td>
<td>${o.name}</td>
<td>
<a href="${pageContext.request.contextPath}/category/edit/${o.id}">
<img src="${pageContext.request.contextPath}/images/edit.png" alt="Edit">
</a>
</td>
<td>
<a href="${pageContext.request.contextPath}/category/xoa/${o.id}">
<img src="${pageContext.request.contextPath}/images/trash.png" alt="Delete">
</a>
</td>
</tr>
</c:forEach>
</table>
</form>
</div>