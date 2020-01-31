<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<label for="user_id">아이디: </label><input type="text" id="user_id" name="user_id" /><br />
		<label for="user_pwd">비민번호: </label><input type="password" id="user_pwd" name="user_pwd" /><br />
		<input type="button" value="String응답" onClick="responseByString()" />
		<input type="button" value="json응답" onClick="responseByJson()" />
	</form>
</body>

<script type="text/javascript">
	var userId = document.getElementById('user_id')
	var userPwd = document.getElementById('user_pwd')
	
	var xhr = new XMLHttpRequest()
	

	function responseByJson() {
	    var url = '/ajax/json'

	    var user = {
	        userId: userId.value,
	        userPwd: userPwd.value
	    }

	    xhr.onreadystatechange = callBack

	    xhr.open('POST', url);
	    xhr.setRequestHeader('Content-Type', 'application/json')
	    xhr.send(JSON.stringify(user))
	} 
	
	function responseByString() {
		var url = '/ajax/string?userId=' + userId.value + "&userPwd=" + userPwd.value
		
		xhr.onreadystatechange = callBack;
		
		xhr.open('GET', url)
		xhr.send()
	}
	
	function callBack() {
	    if (xhr.readyState == 4 && xhr.status == 200) {
	        alert('callBack')
	        alert(xhr.responseText)
	        
	        var account = JSON.parse(xhr.responseText)
	        
	        alert(account.userId)
	        alert(account.userPwd)
	    }
	}
</script>
</html>