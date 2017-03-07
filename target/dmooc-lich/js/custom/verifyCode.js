//function changeImg(){
// var imgSrc = jQuery("#imgObj");
// var src = imgSrc.attr("src");
// imgSrc.attr("src",chgUrl(src));
//}
////时间戳
////为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
//function chgUrl(url){
// var timestamp = (new Date()).valueOf();
// url = url.substring(0,17);
// if((url.indexOf("&")>=0)){
// url = url + "×tamp=" + timestamp;
// }else{
// url = url + "?timestamp=" + timestamp;
// }
// return url;
//}
// 
//function isRightCode(){
// var code = jQuery("#veryCode").attr("value");
// code = "c=" + code;
// jQuery.ajax({
// type:"POST",
// url:"resultServlet",
// data:code,
// success:callback
// });
//}
// 
//function callback(data){
// jQuery("#info").html(data);
//}


//jQuery.ajax({
//	type:"POST",
//	url:"/dmooc-lich/teacher/verifyCode",
//	data:null,
//    success: function(data) {  
//        console.log(data);  
//    },  
//})

var token = jQuery("meta[name='_csrf']").attr("content");
var header = jQuery("meta[name='_csrf_header']").attr("content");
	

//jQuery.ajax({
//	type:"POST",
//	url:"/dmooc-lich/teacher/verifyCode",
//	data:null,
//    beforeSend: function(request) {
//        request.setRequestHeader(header, token);
//    },
//    success: function(data) {  
//        console.log(data);  
//    },  
//})
