<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>웹코드보안 기말과제</title>

<!-- Bootstrap core CSS -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./bootstrap/bootstrap_narrow.css" rel="stylesheet">

<!-- 수제작 css -->
<link href="./bootstrap/project_css.css" rel="stylesheet">

<%@ page import="com.final20180971.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.apache.tomcat.util.http.fileupload.FileUtils"%>

<%

//폴더 경로
String file_key_location = application.getRealPath("/") + FileNameClass.getKey_file_folder();
//폴더 확인
ZipfileClass zfc = new ZipfileClass();

zfc.makeFolder(file_key_location);

//폴더 초기화
File key = new File(file_key_location);

try {
	FileUtils.cleanDirectory(key);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	//키 생성
	CreateKey ck = new CreateKey();
	
	ck.create_key(application.getRealPath("/"));
%>
</head>

<body>

	<hr>
	<br>
	<div class="container ononeLine">
		<h1 class="title_css">전자봉투 관리 사이트</h1>
		<br> <br> <br> <br>

		<h3>키 관리</h3>
		<div class="jumbotron ">
			<p>키가 생성되었습니다.</p>
			<p>다운로드를 위해 아래 버튼을 눌러주세요.</p>
			<hr>
			<p>키 다운로드</p>
			<a class="btn btn-lg btn-success" id="secu_key_b"
				href=<%=FileNameClass.getKey_file()%>>비밀키</a>
			<hr>
			<a class="btn btn-lg btn-success" id="public_key_b1"
				href=<%=FileNameClass.getPublicKey_file1()%>>공개키1</a> 
			<a class="btn btn-lg btn-success" id="private_key_b1"
				href=<%=FileNameClass.getPrivateKey_file1()%>>개인키1</a>
			<hr>
			<a class="btn btn-lg btn-success" id="public_key_b2"
				href=<%=FileNameClass.getPublicKey_file2()%>>공개키2</a> 
			<a class="btn btn-lg btn-success" id="private_key_b2"
				href=<%=FileNameClass.getPrivateKey_file2()%>>개인키2</a>
			<hr>
			<hr>
			<a class="btn btn-lg btn-success" id="back_2"
				href="./main.jsp">뒤로가기</a>
		</div>

			<footer class="footer">
				<p>20180971 컴퓨터학과 박주희</p>
				<br>
			</footer>
		</div>

	<!-- /container -->
</body>
</html>
