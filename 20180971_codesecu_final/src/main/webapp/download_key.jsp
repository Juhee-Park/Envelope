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

<title>���ڵ庸�� �⸻����</title>

<!-- Bootstrap core CSS -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./bootstrap/bootstrap_narrow.css" rel="stylesheet">

<!-- ������ css -->
<link href="./bootstrap/project_css.css" rel="stylesheet">

<%@ page import="com.final20180971.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.apache.tomcat.util.http.fileupload.FileUtils"%>

<%

//���� ���
String file_key_location = application.getRealPath("/") + FileNameClass.getKey_file_folder();
//���� Ȯ��
ZipfileClass zfc = new ZipfileClass();

zfc.makeFolder(file_key_location);

//���� �ʱ�ȭ
File key = new File(file_key_location);

try {
	FileUtils.cleanDirectory(key);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	//Ű ����
	CreateKey ck = new CreateKey();
	
	ck.create_key(application.getRealPath("/"));
%>
</head>

<body>

	<hr>
	<br>
	<div class="container ononeLine">
		<h1 class="title_css">���ں��� ���� ����Ʈ</h1>
		<br> <br> <br> <br>

		<h3>Ű ����</h3>
		<div class="jumbotron ">
			<p>Ű�� �����Ǿ����ϴ�.</p>
			<p>�ٿ�ε带 ���� �Ʒ� ��ư�� �����ּ���.</p>
			<hr>
			<p>Ű �ٿ�ε�</p>
			<a class="btn btn-lg btn-success" id="secu_key_b"
				href=<%=FileNameClass.getKey_file()%>>���Ű</a>
			<hr>
			<a class="btn btn-lg btn-success" id="public_key_b1"
				href=<%=FileNameClass.getPublicKey_file1()%>>����Ű1</a> 
			<a class="btn btn-lg btn-success" id="private_key_b1"
				href=<%=FileNameClass.getPrivateKey_file1()%>>����Ű1</a>
			<hr>
			<a class="btn btn-lg btn-success" id="public_key_b2"
				href=<%=FileNameClass.getPublicKey_file2()%>>����Ű2</a> 
			<a class="btn btn-lg btn-success" id="private_key_b2"
				href=<%=FileNameClass.getPrivateKey_file2()%>>����Ű2</a>
			<hr>
			<hr>
			<a class="btn btn-lg btn-success" id="back_2"
				href="./main.jsp">�ڷΰ���</a>
		</div>

			<footer class="footer">
				<p>20180971 ��ǻ���а� ������</p>
				<br>
			</footer>
		</div>

	<!-- /container -->
</body>
</html>
