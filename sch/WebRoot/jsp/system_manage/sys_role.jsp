<%--
   @author 李龙雨
   @date: 2017/5/8 20:16
   @version 0.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/comlw.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<%=basePath %>js/system_manage/sys_role.js"></script>
<html>
<head>
    <title></title>
</head>
<body onload="selectuserinfo()">
<div class="modal fade" id="select_per" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    权限修改
                </h4>
            </div>
            <div class="modal-body" id="per_info">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <input type="hidden" id="loginId"/>
                        <label for="people_name" class="col-sm-3 control-label">角色名称：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="people_name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="people_name" class="col-sm-3 control-label">角色描述：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="people_miaoshu"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="people_name" class="col-sm-3 control-label">角色权限：</label>
                        <div class="col-sm-9">
                            <c:forEach items="${listres}" var="listres">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="quanxian" id="quanxian${listres.resourceId}" value="${listres.resourceId}">${listres.resourceName}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateLoginAndPer();">保存</button>
            </div>
        </div>
    </div>
</div>
<button type="button" class="btn btn-primary btn-lg" onclick="insert_resource()">+ 新增</button>
<table class="table" id="para_table">

</table>
</body>
</html>
