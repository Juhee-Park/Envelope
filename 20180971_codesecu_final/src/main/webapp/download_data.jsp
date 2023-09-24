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

<title>전자봉투 다운로드 완료</title>

<!-- Bootstrap core CSS -->
<link href="./bootstrap/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./bootstrap/bootstrap_narrow.css" rel="stylesheet">

<!-- 수제작 css -->
<link href="./bootstrap/project_css.css" rel="stylesheet">

<%@ page import="com.final20180971.*"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="org.apache.tomcat.util.http.fileupload.FileUtils"%>

<%
		//폴더 초기화
		String file_download_location_real = application.getRealPath("/") + FileNameClass.getDownload_file_folder();
		String file_upload_location_real = application.getRealPath("/") + FileNameClass.getUpload_file_folder();
		
		File zipFile1 = new File(file_download_location_real);
		File zipFile2 = new File(file_upload_location_real);
		try {
			FileUtils.cleanDirectory(zipFile1);
			FileUtils.cleanDirectory(zipFile2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int maxSize_3 = 1024 * 1024 * 5;
		
		//업로드 파일 저장
		MultipartRequest multi_3 = new MultipartRequest(request,
				file_upload_location_real,
				  maxSize_3,
				  "utf-8",
				  new DefaultFileRenamePolicy());
		
		@SuppressWarnings("rawtypes")
		Enumeration files_3 = multi_3.getFileNames();
		
		//업로드 파일 경로 가져오기
		String upload_data_3 = "";
		String upload_private_key2_3 = "";
		String upload_public_key1_3 = "";
		String upload_public_key2_3 = "";
		
		while(files_3.hasMoreElements()){
			
			String para = (String)files_3.nextElement();
			String f_path = file_upload_location_real + "/"
					+ multi_3.getFilesystemName(para);
			
			if(para.indexOf("data_3") != -1){
				upload_data_3 = f_path;
			}
			if(para.indexOf("private_key2_3") != -1){
				upload_private_key2_3 = f_path;
			}
			if(para.indexOf("public_key1_3") != -1){
				upload_public_key1_3 = f_path;
			}
			if(para.indexOf("public_key2_3") != -1){
				upload_public_key2_3 = f_path;
			}	
		}
		if(upload_data_3 == "" || upload_private_key2_3 == ""
				|| upload_public_key1_3 == "" || upload_public_key2_3 == ""){
			System.err.println("para null error");
		}
			
		//전자봉투 검증하기
		VeriEnvelope ve = new VeriEnvelope();
		boolean rslt = ve.veri_envelope(application.getRealPath("/"),
				upload_data_3, upload_private_key2_3, upload_public_key1_3, upload_public_key2_3);
	%>
</head>

<body>

	<hr>
	<br>
	<div class="container ononeLine">
		<h1 class="title_css">전자봉투 관리 사이트</h1>
		<br> <br> <br> <br>
		
			<h3>전자봉투 검증이 완료되었습니다.</h3>
			<div class="jumbotron">
				<p>검증 결과</p>
				<p><%=rslt%></p>
				
				<%
					if(rslt){
				%>
				<hr>
				<p>데이터파일 확인</p>
				<a class="btn btn-lg btn-success" id="download_data"
					href=<%=FileNameClass.getData_file()%>>확인</a>
				<%
					}
				%>
				<hr>
				<hr>
				<a class="btn btn-lg btn-success" id="back_3"
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
