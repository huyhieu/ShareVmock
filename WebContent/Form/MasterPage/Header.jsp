<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<style>
<!--
.navbar .nav>li>a#StatusUser:hover,.navbar .nav .open>a#StatusUser,.navbar .nav .open>a#StatusUser:hover
	{
	background: #f9f9f9 !important;
}

.search {
	position: absolute;
	right: 22px;
	width: 41px;
	top: 5px;
	color: #fff;
	background: #1bb3ca;
	text-align: center;
	margin-right: -22px;
	margin-top: -5px;
	height: 28px;
	padding: 4px;
	font-size: 15px;
}

h3.vtstname {
	margin: -3px;
	float: left;
	font-weight: 400
}

img.flagNational {
	position: static !important;
	height: 13px !important;
	width: 22px !important;
	top: 4px !important;
	left: 30px !important;
}

.languagePage {
	margin: 13px 5px 0px 0px;
	float: right;
	min-width: 135px
}

.lang {
	float: left;
}
-->
</style>
<header class="navbar clearfix" id="header">
	<div class="container center-vertical">
		<div class="navbar-brand" style="width: auto;">
			<!-- COMPANY LOGO -->
			<a href="#" onclick="location.href = 'Home.do';"> <img
				src="./PAGE-STYLE/images/Masterpage/ic_viettelstore.png"
				alt="GoGoGrocer Logo" class="img-responsive" height="30" width="120"
				style="left: 15px;">
				<h3 class="vtstname" style="color: #1bb3ca;">Viettel</h3>
				<h3 class="vtstname">&nbsp; AppStore</h3>

			</a>
		</div>

		<!-- END TOP NAVIGATION MENU -->

		<div class="languagePage">
			<jsp:include page="/Form/Common/Language.jsp"></jsp:include>
			<div id="account_status" style="margin-right: -10px;">
			</div>
		</div>


		<!-- NAVBAR LEFT -->
		<div id="search-bar" class="hidden-xs"
			style="float: left; position: absolute; top: 12px; left: 260px; width: 400px;">
			<input class="searchApp" type="text"
				placeholder='Search'
				onkeydown="searchKeyPress(event);" id="seachapp"
				style="background: none repeat scroll 0 0 #fff; border: solid 1px #c0c9ca; border-radius: 1px; color: #b8b8b8; padding: 4px 10px; width: 100%; margin: 0 auto 10px; padding-right: 30px !important;">
			<div class="search">
				<i class="fa fa-search search-icon" onclick="onSearchApp();"></i>
			</div>
		</div>

	</div>
</header>
<script>
	function loadHomePage(action) {
		if (navigator.onLine) {
			// Show loading
			showOverlay(EN_MESSAGE.Key_loading, VI_MESSAGE.Key_loading);
			$.ajax({
				type : 'post',
				url : 'Home!' + action + '.do',
				timeout : G_MESSAGE.globalTimeOut,
				dataType : 'html',
				data : JSON.stringify({
					"countLoad" : 1
				}),
				async : true,
				success : function(response) {
					var fileContent = response.trim();
					if (fileContent === 'error') {
						showAlertMessage(EN_MESSAGE.Key_loadhome_error,
								VI_MESSAGE.Key_loadhome_error);
					} else {
						$("#content").html(response);
					}

					hideOverlay();
				},
				error : function(response) {
					showAlertMessage(EN_MESSAGE.Key_loadhome_error,
							VI_MESSAGE.Key_loadhome_error);
				}
			});
		} else {
			showAlertMessage(EN_MESSAGE.Key_loadhome_error,
					VI_MESSAGE.Key_loadhome_error);
		}
	}

	// Search textfield enter key pressed
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		if (typeof e == 'undefined' && window.event) {
			e = window.event;
		}
		if (e.keyCode == 13) {
			onSearchApp();
		}
	};

	// Search apps
	function onSearchApp() {
		var keySearch = $('#seachapp').val().trim();
		if (keySearch === null || keySearch === '') {
			return;
		}

		// Start searching
		if (navigator.onLine) {
			// Show loading
			showOverlay(EN_MESSAGE.Key_loading, VI_MESSAGE.Key_loading);
			$.ajax({
				type : 'POST',
				url : 'Home!SearchApp.do',
				timeout : G_MESSAGE.globalTimeOut,
				data : JSON.stringify({
					"keySearch" : keySearch,
					"countLoad" : 1
				}),
				contentType : 'application/json',
				dataType : 'html',
				async : true,
				success : function(response) {
					var fileContent = response.trim();
					if (fileContent === 'error') {
						showAlertMessage(EN_MESSAGE.Key_search_error,
								VI_MESSAGE.Key_search_error);
					} else {
						$("#content").html(response);
					}
					hideOverlay();
				},
				error : function(response) {
					showAlertMessage(EN_MESSAGE.Key_search_error,
							VI_MESSAGE.Key_search_error);
				}
			});
		} else {
			showAlertMessage(EN_MESSAGE.Key_search_error,
					VI_MESSAGE.Key_search_error);
		}
	};

	
</script>