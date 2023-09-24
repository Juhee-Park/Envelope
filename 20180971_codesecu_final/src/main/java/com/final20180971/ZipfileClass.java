package com.final20180971;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipfileClass {

	// 압축하기
	public void zip_file(String zip_file_name, String... files) {

		byte[] buf = new byte[4096];

		try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip_file_name))) {

			for (String f : files) {
				try (FileInputStream in = new FileInputStream(f)) {
					ZipEntry ze = new ZipEntry(f);
					out.putNextEntry(ze);

					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}

					out.closeEntry();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 압축 해제
	public boolean unZip(String zipFileName, String zipUnzipPath) {

		// 파일 정상적으로 압축이 해제가 되어는가.
		boolean isChk = false;

		// 해제할 폴더 위치를 재조정
		zipUnzipPath = zipUnzipPath + zipFileName.replace(".zip", "");

		// zip 파일
		File zipFile = new File(zipFileName);

		FileInputStream fis = null;
		ZipInputStream zis = null;
		ZipEntry zipentry = null;

		try {
			// zipFileName을 통해서 폴더 만들기
			makeFolder(zipUnzipPath);

			// 파일 스트림
			fis = new FileInputStream(zipFile);

			// Zip 파일 스트림
			zis = new ZipInputStream(fis, Charset.forName("EUC-KR"));

			// 압축되어 있는 ZIP 파일의 목록 조회
			while ((zipentry = zis.getNextEntry()) != null) {
				String filename = zipentry.getName();
				File file = new File(zipUnzipPath, filename);

				// entiry가 폴더면 폴더 생성
				if (zipentry.isDirectory()) {
					file.mkdirs();
				} else {
					// 파일이면 파일 만들기
					try {
						createFile(file, zis);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}
			isChk = true;
		} catch (Exception e) {
			isChk = false;
		} finally {
			if (zis != null) {
				try {
					zis.close();
				} catch (IOException e) {
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
		}
		return isChk;
	}

	public boolean makeFolder(String folder) {
		if (folder.length() < 0) {
			return false;
		}
		String path = folder; // 폴더 경로
		File Folder = new File(path);
		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try {
				Folder.mkdir(); // 폴더 생성합니다.
			} catch (Exception e) {
				e.getStackTrace();
			}
		}

		return true;
	}

	private void createFile(File file, ZipInputStream zis) throws Throwable {
		// 디렉토리 확인
		File parentDir = new File(file.getParent());
		// 디렉토리가 없으면 생성하자
		if (!parentDir.exists()) {
			parentDir.mkdirs();
		}
		FileOutputStream fos = null;
		// 파일 스트림 선언
		try {
			fos = new FileOutputStream(file);
			byte[] buffer = new byte[256];
			int size = 0;
			// Zip스트림으로부터 byte뽑아내기
			while ((size = zis.read(buffer)) > 0) {
				// byte로 파일 만들기
				fos.write(buffer, 0, size);
			}
		} catch (Throwable e) {
			throw e;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
