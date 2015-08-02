var JQUERY_KEY_LANG_CLASS = {
	KEY_LANG_EN : "EN",
	KEY_LANG_VI : "VI",
};

function showAlertMessage(en_key_message, vi_key_message) {
	if (lang === 'VI') {
		lang = 'VI';
		alert(vi_key_message);
	} else {
		lang = 'EN';
		alert(en_key_message);
	}
};

var EN_MESSAGE = {

	// Time out
	Key_timeout : "Your session has been time out. Please try again.",

	// Login
	Key_show_loginmodal : "Error occured during acting with the system. Please try again.",
	Key_invalid_email : "Email is not correct.",
	Key_invalid_pass_email : "Email or password  is not correct.",
	Key_invalid_pass : "Password is not correct.",
	Key_login_error : "Error occured during login into system.",
	Key_account_not_active : "Your account is not actived.",
	Key_account_is_locked : "Your account is locked.",
	Key_logout_error : "Error occured during signing out of the system.",
	Key_error_reload_account : "Error occured during reloading account information.",

	// Language
	Key_changelocale_error : "Error occured during changing locale.",


	// Home page
	Key_loadhome_error : "Error occured during loading home page.",
	Key_loading_list_app : "Error occured during loading.",

	// Search app
	Key_search_error : "Error occured during searching.",

	// App Detail
	Key_loading_appdetail : "Error occured during loading app detail.",

	// Overlay
	Key_loading : "Loading data...",
	Key_waiting : "Waiting..."

};
var VI_MESSAGE = {

	// Time out
	Key_timeout : "Phiên làm việc của bạn đã hết. Vui lòng thử lại sau.",

	// Login
	Key_show_loginmodal : "Có lỗi xảy ra, vui lòng thử lại.",
	Key_invalid_email : "Email đăng nhập không hợp lệ.",
	Key_invalid_pass_email : "Email hoặc mật khẩu không hợp lệ.",
	Key_invalid_pass : "Mật khẩu đăng nhập không đúng.",
	Key_login_error : "Có lỗi xảy ra trong quá trình đăng nhập hệ thống.",
	Key_account_not_active : "Tài khoản của bạn chưa được kích hoạt.",
	Key_account_is_locked : "Tài khoản của bạn đã bị khóa.",
	Key_logout_error : "Có lỗi xảy ra trong quá trình thoát khỏi hệ thống.",
	Key_error_reload_account : "Có lỗi xảy ra trong quá trình cập nhật thông tin tài khoản.",

	// Language
	Key_changelocale_error : "Có lỗi xảy ra trong quá trình thay đổi ngôn ngữ hiển thị.",

	// Home page
	Key_loadhome_error : "Có lỗi xảy ra trong quá trình tải trang Home.",
	Key_loading_list_app : "Có lỗi xảy ra trong quá trình tải danh sách.",
	
	// Search app
	Key_search_error : "Có lỗi xảy ra trong quá trình tìm kiếm.",


	// Overlay
	Key_loading : "Đang tải...",
	Key_waiting : "Đang chờ..."

};