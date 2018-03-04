<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="http://baidu.com" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公司机构列表</title>
    <%@include file="../../res/common/common.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

</head>
<body>
<div class="content">
    <div class="search_content resizeLayout">
        <form class="form-inline" role="form" action="${pageContext.request.contextPath }/company/list">
            <div class="form-group">
                <label for="name">名称</label>
                <input type="text" class="form-control" id="name" value="${name}" name="name">
            </div>
            <div class="form-group">
                <label for="address">地址</label>
                <input type="text" class="form-control" id="address" value="${address}" name="address">
            </div>
            <div class="form-group">
                <label for="custLevel">类型</label>
                <select class="form-control" id="custLevel" name="type">
                    <option value="">--请选择--</option>
                    <option value="1" <c:if test="${type==1}"> selected</c:if>>1</option>
                    <option value="2" <c:if test="${type==2}"> selected</c:if>>2</option>
                    <option value="3" <c:if test="${type==3}"> selected</c:if>>3</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-search"></i>&nbsp;查询</button>
            <button type="button" class="btn btn-primary btn-sm" onclick="location.href='/company/form'"><i class="glyphicon glyphicon-plus"></i>&nbsp;登记
            </button>
        </form>
    </div>
    <div class="data_table_height_auto">
        <table class="table table-bordered table-hover table-striped">
            <thead>
            <tr>
                <th style="text-align: center" width="5%">序号</th>
                <th style="text-align: center" width="20%">名称</th>
                <th style="text-align: center" width="30%">地址</th>
                <th style="text-align: center" width="8%">类型</th>
                <th style="text-align: center" width="8%">操作</th>
            </thead>
            <tbody>
            <c:forEach items="${page.rows}" var="company" varStatus="status">
                <tr>
                    <td style="text-align: center">${status.index+1}</td>
                    <td>${company.name}</td>
                    <td>${company.address}</td>
                    <td style="text-align: center">${company.type}</td>
                    <td style="text-align: center">
                        <a href="#" class="btn btn-danger btn-xs" onclick="deleteCustomer(${company.id})">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <page:page url="${pageContext.request.contextPath }/company/list" number="7"/>
</div>

</body>
</html>
<script>
    function deleteCustomer(id) {
        if(confirm('确实要删除该数据吗?')) {
            $.get("${pageContext.request.contextPath }/company/delete.action",{"id":id},function(data){
                alert("删除更新成功！");
                window.location.reload();
            });
        }
    }
</script>
