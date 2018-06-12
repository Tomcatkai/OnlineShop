/*
@功能：购物车页面js
@作者：diamondwang
@时间：2013年11月14日
*/
$(function () {

    $.ajax({
        type: "post",
        async: false,
        url: "/order/addresslist.json",
        data: {},
        success: function (data) {
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    var addressArea = data[i].addressArea;
                    var addressCity = data[i].addressCity;
                    var addressId = data[i].addressId;
                    var addressProvince = data[i].addressProvince;
                    var addressReceiver = data[i].addressReceiver;
                    var addressReceiverPhone = data[i].addressReceiverPhone;
                    var addressStatus = data[i].addressStatus;
                    var addressUid = data[i].addressUid;
                    var addressDetail = data[i].addressDetail;

                    if (addressStatus === 1) {
                        $("#people_msg").append('收货人信息 <a href="javascript:;" id="address_modify">[修改]</a>');
                        $("#people_detail").append('<p> <span id="using_addressReceiver">' + addressReceiver + '</span> <span id="using_addressReceiverPhone">' + addressReceiverPhone + '</span> </p>\n' +
                            '                <p> <span id="using_addressProvince">' + addressProvince + '</span> <span id="using_addressCity">' + addressCity + '</span> <span id="using_addressArea">' + addressArea + '</span> <span id="using_addressDetail">' + addressDetail + '</span> <span id="using_addressId" style="display:none">'+addressId+'</span></p>');

                        $("#location_ul").append(' <li>\n' +
                            '                        <input type="radio" name="address" checked="checked"/>' + '<span class="addressReceiver">'+addressReceiver + '</span> <span class="addressProvince">' + addressProvince + '</span> <span class="addressCity">' + addressCity + '</span> <span class="addressArea">' + addressArea + '</span> <span class="addressDetail">' + addressDetail + '</span> <span class="addressReceiverPhone">' + addressReceiverPhone + '</span><span class="hide_addressId" style="display:none">'+addressId+'</span>\n' +
                            '                        <a class="confirm_use">确认使用</a>\n' +
                            '                    </li>');
                    } else {
                        $("#location_ul").append(' <li>\n' +
                            '                        <input type="radio" name="address"/>' + '<span class="addressReceiver">'+addressReceiver + '</span> <span class="addressProvince">' + addressProvince + '</span> <span class="addressCity">' + addressCity + '</span> <span class="addressArea">' + addressArea + '</span> <span class="addressDetail">' + addressDetail + '</span> <span class="addressReceiverPhone">' + addressReceiverPhone + '</span><span class="hide_addressId" style="display:none">'+addressId+'</span>\n' +
                            '                        <a class="confirm_use">确认使用</a>\n' +
                            '                    </li>');
                    }
                }
            } else {
                $("#people_msg").hide();
                $("#people_detail").hide();
                $(".address_select").show();
            }
        }
    });


    //收货人修改
    $("#address_modify").click(function () {
        $(this).hide();
        $(".address_info").hide();
        $(".address_select").show();
    });

    $("#new_address").click(function () {
        $("#address_form").show();
    }).parent().siblings().find("input").click(function () {
        $("#address_form").hide();
    });

/*
确认使用
 */
    $(".confirm_use").click(function () {

        var addressReceiver = $(this).siblings(".addressReceiver")[0].innerText;
        var addressProvince = $(this).siblings(".addressProvince")[0].innerText;
        var addressCity = $(this).siblings(".addressCity")[0].innerText;
        var addressArea = $(this).siblings(".addressArea")[0].innerText;
        var addressDetail = $(this).siblings(".addressDetail")[0].innerText;
        var addressReceiverPhone = $(this).siblings(".addressReceiverPhone")[0].innerText;
        var addressId = $(this).siblings(".hide_addressId")[0].innerText;

        $("#using_addressReceiver").text(addressReceiver);
        $("#using_addressReceiverPhone").text(addressReceiverPhone);
        $("#using_addressProvince").text(addressProvince);
        $("#using_addressCity").text(addressCity);
        $("#using_addressArea").text(addressArea);
        $("#using_addressDetail").text(addressDetail);
        $("#using_addressId").text(addressId);
        $(".address_info").show();
        $("#address_modify").show();
        $(".address_select").hide();
    });

    $("#orderCreate").click(function () {
        $.ajax({
            type: "post",
            async: false,
            url: "/order/create.json",
            data: {addressId: $("#using_addressId")[0].innerText},
            success: function (data) {
                if (data.code === 1) {
                    window.location.href = "/order/suc.html";
                } else {
                    alert(data.msg);
                }
            }
        });
    });






    $("#confirm_btn").click(function () {
        var new_receiver = $("#new_receiver").val();
        var prov = $("#provid").siblings(".layui-unselect").find(".layui-select-title").find("input").val();
        var city = $("#cityid").siblings(".layui-unselect").find(".layui-select-title").find("input").val();
        var area = $("#areaid").siblings(".layui-unselect").find(".layui-select-title").find("input").val();
        var new_address_detail = $("#new_address_detail").val();
        var new_address_phone = $("#new_address_phone").val();
        var newAddressId = "";
        $.ajax({
            type: "post",
            async: false,
            url: "/order/newaddress.json",
            data: {addressReciver:$("#new_receiver").val(),addressReceiverPhone:$("#new_address_phone").val(),addressDetail:$("#new_address_detail").val(),addressProvince:$("#provid").siblings(".layui-unselect").find(".layui-select-title").find("input").val(),addressCity:$("#cityid").siblings(".layui-unselect").find(".layui-select-title").find("input").val(),addressArea:$("#areaid").siblings(".layui-unselect").find(".layui-select-title").find("input").val()},
            success: function (data) {
                if(data.code===1){
                    newAddressId = data.addressId;
                }else {
                    alert(data.msg);
                }
            }
        });
        $("#using_addressReceiver").text(new_receiver);
        $("#using_addressReceiverPhone").text(new_address_phone);
        $("#using_addressProvince").text(prov);
        $("#using_addressCity").text(city);
        $("#using_addressArea").text(area);
        $("#using_addressDetail").text(new_address_detail);
        $("#using_addressId").text(newAddressId);

        $(".address_info").show();
        $("#address_modify").show();
        $(".address_select").hide();
    });
});