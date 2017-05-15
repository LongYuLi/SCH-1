/**
 * @author 李龙雨
 * @date: 2017/4/27 22:25
 * @version 0.1
 */
function initTable() {
    var queryUrl = 'role!findAll.action';
    $('#para_table').bootstrapTable('destroy');
    $table = $('#para_table').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",
        url: queryUrl,
        pagination: true,
        pageSize: 5,
        // pageList:[2,5,10],
        queryParamsType: 'limit',
        // queryParams:queryParams(this),
        search: true, //显示 搜索框
        showColumns: false, //不显示下拉框（选择显示的列）
        sidePagination: "client", //客户端请求
        columns: [{
            field: 'roleName',
            title: '角色名称',
            width: 100,
            align: 'center',
            sortable: true
        }, {
            field: 'roleIntroduce',
            title: '角色描述',
            width: 100,
            align: 'center',
            sortable: true
        }
        // , {
        //     field: 'roleId',
        //     title: '操作',
        //     width: 140,
        //     align: 'center',
        //     formatter: function (value, row, index) {
        //         var e = '<button id="reset_pad_' + value + '" type="button" class="btn btn-default  btn-xs" style="margin-right:15px;" onclick="selectResources(' + value +','+row+ ')">角色权限修改</button>';
        //         // var d = '<button id="update_' + value + '" type="button" class="btn btn-default  btn-xs"  style="margin-right:15px;" onclick="update_isuse(' + value + ',2)">过期</a> ';
        //         return e ;
        //     }
        // }
        ],
        onDblClickRow: function (row, $element, id) {
            $.ajax({
                url: "role!selectRessourcesByRole.action",
                type: "POST",
                // dataType: "text",
                data: {
                    "id": row.roleId,
                },
                success: function (data) {
                    $("input[name=quanxian]").prop("checked", false);//prop类似于设定  attr类似于添加属性，只有一次生效
                    var biaoji=data.split(",");
                    for (var i = 0; i < biaoji.length; i++) {
                        var quanid=biaoji[i];
                        $("input[id=quanxian"+quanid+"]").prop("checked", true);
                    }
                    $("#people_name").val(row.roleName);
                    $("#people_miaoshu").val(row.roleIntroduce);
                    $("#loginId").val(row.roleId);
                    $("#myModalLabel").html("角色修改");
                    $('#select_per').modal('show');
                },
                error:function(){
                    alert("未知错误！");
                }
            });
        },
        onLoadSuccess: function () {

        },
        onLoadError: function () {
            mif.showErrorMessageBox("数据加载失败！");
        }
    });
}
function selectuserinfo() {
    initTable();
}
function insert_resource() {
    $("#myModalLabel").html("添加角色");
    $("input[name=quanxian]").prop("checked", false);
    $("#people_name").val("");
    $("#people_miaoshu").val("");
    $("#loginId").val("");
    $('#select_per').modal('show');
}
function updateLoginAndPer() {
    var id=$("#loginId").val();
    var name=$("#people_name").val();
    var select=$("#people_miaoshu").val();
    var obj=document.getElementsByName("quanxian");
    var check_val = "";
    for (var i = 0; i < obj.length; i++) {
        if(obj[i].checked()){
            check_val+=obj[i].val();
        }
    }
    alert(aaa);
    $.ajax({
        url: "role!attachDirty.action",
        type: "POST",
        dataType: "json",
        data: {
            "id": id,
            "name": name,
            "select": select,
            "obj": obj,
        },
        success: function (data) {
            if (data == 1) {
                $('#updateLogin').modal('hide');
                alert("修改成功！");
                initTable();
            } else {
                $('#updateLogin').modal('hide');
                alert("保存成功!");
                initTable();
            }
        },
        error: function () {
            alert("未知错误！");
        }
    });
}