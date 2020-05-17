$(function () {
    $("td").on("click",".delbtn",function () {
        return confirm("确认删除吗？这个操作将不可恢复！");
    });

    var uids={uids:[]};
    $(".cuid").click(function () {
        uids.uids=[];
        $(".cuid:checked").each(function () {
            uids.uids.push($(this).val());
        });
    });

    $(".delbtns").click(function () {
        if(uids.uids.length<=0)
            return;
        if(confirm("确认要删除被选中的信息吗？这个操作将不可恢复！")){
            var json=JSON.stringify(uids);
            $("#deleteuids").val(json);
            $("#form1").attr("action","/deleteUsers");
            $("#form1").submit();
        }
    });
});