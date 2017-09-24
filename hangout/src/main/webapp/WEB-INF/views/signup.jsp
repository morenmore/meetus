<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>


<title>Admin</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">HANG.OUT.</h1>
					<img src="/resources/images/koreanHanbok.jpg">
					<hr />
				</div>

			</div>
			<div class="main-login main-center">
				<form class="form-horizontal" method="post" action="#">
					<h1 class="title">SING UP</h1>
					<br></br>
					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Create
							New ID</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="userId" id="userId"
									placeholder="아이디를 만들어 주세요." />
							</div>
						</div>
					</div>


					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Your
							Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
									type="password" class="form-control" name="userPwd"
									id="userPwd" placeholder="비밀번호를 입력해주세요." />
							</div>
						</div>
					</div>


					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Your
							Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="userName" id="userName" placeholder="이름을 적어주세요." />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Your
							Email</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="userEmail"
									id="userEmail" placeholder="이메일 주소를 입력하세요." />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Your
							Phone Number</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="userPhone" id="userPhone" placeholder="연락처를 적어주세요." />
							</div>
						</div>
					</div>


					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Your
							Gender</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="fa fa-users fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="userGender"
									id="userGender" placeholder="성별을 선택하세요." />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Where
							were you born?</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"> <i
									class="fa  fa-map-marker fa" aria-hidden="true"></i></span>
								<div class="dropdown">
									<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"aria-expanded="true">
										국적선택									
									<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
										<li>ㄴㅇ</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="form-group ">
							<button type="button" id="signupbtn"
								class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						<div class="login-register">
							<a href="index.php">Login</a>
						</div>
				</form>
			</div>
		</div>
	</div>
</body>

<script>
	$("#signupbtn").click(function() {

		var au = new AjaxUtil("signup/insert");
		var param = {};
		param["userId"] = $("#userId").val();
		param["userPwd"] = $("#userPwd").val();
		param["userName"] = $("#userName").val();
		param["userEmail"] = $("#userEmail").val();
		param["userPhone"] = $("#userPhone").val();
		param["userGender"] = $("#userGender").val();
		param["userCountry"] = $("#userCountry").val();
		au.param = JSON.stringify(param);
		au.setCallbackSuccess(callbackSql);
		au.send();
		return;

	})
	function callbackSql(result) {
		if (result.error) {
			alert(result.error);
			return;
		}
		alert("성공데스");
	}
</script>
</html>