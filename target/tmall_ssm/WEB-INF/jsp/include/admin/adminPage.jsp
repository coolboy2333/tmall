<%--
  Created by IntelliJ IDEA.
  User: Danger
  Date: 2018/4/17
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" isELIgnored="false" %>
<script>

</script>
<nav>
    <ul class="pagination">
        <li <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="?start=0${page.param}" aria-label="Previous">
                <span aria-hidden="true"><<</span>
            </a>
        </li>
        <li <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="?start=${page.start-page.count}${page.param}" aria-label="Previous">
                <span aria-hidden="true"><</span>
            </a>
        </li>
        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
            <li <c:if test="${status.index*page.count==page.start}">class="disabled" </c:if> >
                <a href="?start=${status.index*page.count}${page.param}" class="current">${status.count}</a>
            </li>
        </c:forEach>
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?start=${page.start+page.count}${page.param}" aria-label="Next">
                <span aria-hidden="true">></span>
            </a>
        </li>
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?start=${page.last}${page.param}" aria-label="Next">
                <span aria-hidden="true">>></span>
            </a>
        </li>
    </ul>
</nav>

