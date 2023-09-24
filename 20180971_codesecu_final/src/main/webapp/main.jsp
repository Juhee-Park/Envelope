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
String file_upload_location = application.getRealPath("/") + FileNameClass.getUpload_file_folder();
String file_download_location = application.getRealPath("/") + FileNameClass.getDownload_file_folder();
String file_envelope_location = application.getRealPath("/") + FileNameClass.getDigital_envelope_folder();

//���� Ȯ��
ZipfileClass zfc = new ZipfileClass();

zfc.makeFolder(file_key_location);
zfc.makeFolder(file_upload_location);
zfc.makeFolder(file_download_location);
zfc.makeFolder(file_envelope_location);

//���� �ʱ�ȭ
File key = new File(file_key_location);
File upload = new File(file_upload_location);
File download = new File(file_download_location);
File envelope = new File(file_envelope_location);

try {
	FileUtils.cleanDirectory(key);
	FileUtils.cleanDirectory(upload);
	FileUtils.cleanDirectory(download);
	FileUtils.cleanDirectory(envelope);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
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
			<p>1. Ű ����</p>
			<a class="btn btn-lg btn-success" id="go_key_c"
				href="./download_key.jsp">�����ϱ�</a>
		</div>
		<br> <br>
		<div class="header">
			<h3>���ں��� ����</h3>
			<div class="jumbotron">

				<form class="btn btn-lg" action="./download_evelope.jsp" method="post"
					enctype="multipart/form-data">
					<p>1. ������ ���� ����</p>
					<input type="file" name="data_2">
					<hr>
					<p>2. ���Ű ����</p>
					<input type="file" name="security_key_2">
					<hr>
					<p>3. ����Ű1 ����</p>
					<input type="file" name="private_key1_2">
					<hr>
					<p>4. ����Ű1 ����</p>
					<input type="file" name="public_key1_2">
					<hr>
					<p>5. ����Ű2 ����</p>
					<input type="file" name="public_key2_2">
					<hr>
					<p>6. ���ں��� ����</p>
					<input class="btn btn-lg btn-success" type="submit" id="create_DE"
						value="�����ϱ�">
				</form>

			</div>
			<br> <br>
			<h3>3. ���ں��� ����</h3>
			<div class="jumbotron">
				<form class="btn btn-lg" action="./download_data.jsp" method="post"
					enctype="multipart/form-data">
					<p>1. ���ں��� ����</p>
					<input type="file" name="data_3">
					<hr>
					<p>2. ����Ű2 ����</p>
					<input type="file" name="private_key2_3">
					<hr>
					<p>3. ����Ű1 ����</p>
					<input type="file" name="public_key1_3">
					<hr>
					<p>4. ����Ű2 ����</p>
					<input type="file" name="public_key2_3">
					<hr>
					<p>5. ���ں��� ����</p>
					<input class="btn btn-lg btn-success" type="submit" id="create_DE"
						value="�����ϱ�">
				</form>
			</div>

			<footer class="footer">
				<p>20180971 ��ǻ���а� ������</p>
				<br>
			</footer>
		</div>

	</div>
	<!-- /container -->
</body>
</html>
