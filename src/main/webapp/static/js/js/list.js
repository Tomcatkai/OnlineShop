/*
@功能：列表页js
@作者：diamondwang
@时间：2013年11月13日
*/

$(function(){
	$(".child h3").click(function(){
		$(this).toggleClass("on").parent().find("ul").toggle();
	});



    // /**
    //  * 图书信息展示
    //  *
    //  */
    // var totalRecord = 0;//初始化总记录数
    // var pageNum = 1;//初始化页数为第一页
    // var pageSize = 20;//每页显示条数20条
    // getBookData();

    // function getBookData() {
    //     $.ajax({
    //         type:"post",
    //         async:false,
    //         url:"/index/bookList.json",
    //         data:{pageNum:pageNum, pageSize:pageSize},
    //         success:function(data){
    //             totalRecord  = data.total;//数据总条数
    //             fillDataToPage(data.list)
    //         }
    //     });
    // }

    // /**
    //  * 填充数据
    //  * @param data
    //  */
    // function fillDataToPage(data) {
    //     var i = 0;
    //     for(i;i<data.length;i++){
    //         $('#book-list').append('<li class="box-item posi-a" style="margin-right: 13px;margin-top: 10px;">\n' +
    //             '            <a target="_blank" href="/book/detail/'+data[i].bookId+'.html" >\n' +
    //             '                <img src="'+data[i].bookPicBig+'"/>\n' +
    //             '                <div class="down">\n' +
    //             '                    <h2 class="box-title">\n' +
    //             '                        <span style="display: block;\n' +
    //             '  width: 120px;\n' +
    //             '  overflow: hidden;\n' +
    //             '  white-space: nowrap;\n' +
    //             '  text-overflow: ellipsis;">'+data[i].bookName+'</span>\n' +
    //             '                    </h2>\n' +
    //             '                    <h5 class="box-title1">'+data[i].bookSubhead+'</h5>\n' +
    //             '                </div>\n' +
    //             '            </a>\n' +
    //             '        </li>')
    //     }
    // }

    /**
     * 分页插件
     */
    // function toPage() {

});