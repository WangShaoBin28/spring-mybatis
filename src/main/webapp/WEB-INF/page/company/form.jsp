<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>家庭入户信息表单</title>
    <%@include file="../../res/common/common.jsp" %>
    <style>
        .footer {
            text-align: center;
            width: 100%;
            bottom: 0px;
            left: 0px;
            right: 0px;
            color: inherit;
            padding: 8px 0 5px 0;
        }
    </style>
</head>
<body>
<div class="content">
    <form action="save"  class="form-inline" id="form">
        <div class="content">
            <c:if test="${not empty company.id}">
                <input type="hidden" name="id" value="${company.id}">
            </c:if>
            <fieldset>
                <legend>一、基本信息</legend>
                <table class="table table-bordered">
                    <tr>
                        <td class="fieldName">名称</td>
                        <td class="fieldValue"><input name="name"  type="text" size="50" class="form-control" value="${company.name}"/></td>
                        <td class="fieldName">地址</td>
                        <td class="fieldValue" colspan="3"><input name="address" size="50" type="text" class="form-control" value="${company.address}"/></td>
                    </tr>
                    <tr>
                        <td class="fieldName">类型</td>
                        <td class="fieldValue">
                            <select class="form-control" name="type">
                                <option value="">--请选择--</option>
                                <option value="1" <c:if test="${company.type==1}"> selected</c:if>>1</option>
                                <option value="2" <c:if test="${company.type==1}"> selected</c:if>>2</option>
                                <option value="3" <c:if test="${company.type==1}"> selected</c:if>>3</option>
                            </select>
                        </td>
                        <td class="fieldName"></td>
                        <td class="fieldValue" colspan="3"></td>
                    </tr>
                </table>
            </fieldset>
        </div>
        <div class="footer">
            <button class="btn btn-primary btn-sm" type="submit"><i class="fa fa-save"></i>&nbsp;保存</button>
            &nbsp;&nbsp;
            <button class="btn btn-white btn-sm" type="button" onclick="history.back()"><i class="fa fa-backward"></i>&nbsp;返回
            </button>
        </div>
    </form>
</div>
</body>
</html>

