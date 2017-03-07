jQuery(document).ready(function(){
	var token = jQuery("meta[name='_csrf']").attr("content");
	var header = jQuery("meta[name='_csrf_header']").attr("content");
	
	jQuery('#loginmsg').hide();						
	///// TRANSFORM CHECKBOX /////							
	jQuery('input:checkbox').uniform();
	
	///// LOGIN FORM SUBMIT /////
	jQuery('#teacherLoginForm').submit(function(){
		if(jQuery('#username').val() != '' && jQuery('#password').val() != ''){
			jQuery('#loginmsg').hide();
			if(jQuery('#username').val()!="admin"){
				var password = jQuery('#password').val();
				var verifyCode = jQuery("#verifyCode").val();
				jQuery('#password').val(password+verifyCode);
			}
			return true;
		}
	});
	
	jQuery('#teacherRegisterForm').submit(function(){
		if(jQuery('#username').val() != '' && jQuery('#password').val() != ''){
			jQuery('#loginmsg').hide();
			var password = jQuery('#password').val();
			var verifyCode = jQuery("#verifyCode").val();
			jQuery('#password').val(password+verifyCode);
			return true;
		}
	});
	
});
