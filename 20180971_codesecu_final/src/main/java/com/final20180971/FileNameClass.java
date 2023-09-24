package com.final20180971;

public class FileNameClass {
	public static final long serialVersionUID = 1L;
	
	//알고리즘 이름
	protected static String keyAlgorithm = "AES";
	protected static int keyAlgorithm_init = 128;
	
	protected static String pairKeyAlgorithm = "RSA";
	protected static int pairKeyAlgorithm_init = 1024;
	
	protected static String signAlgorithm = "SHA1withRSA";

	//파일 경로
	protected static String upload_file_folder = "upload_file";
	protected static String download_file_folder = "download_file";

	protected static String data_file_folder = "data_file";
	protected static String cryptogram_folder = "data_file/cryptogram";
	protected static String key_file_folder = "key_file";
	protected static String digital_envelope_folder = "digital_envelope";
	
	protected static String unzip_file_path = "";
	
	
	// 파일 이름
	protected static String data_file = download_file_folder + "/data.txt";
	
	protected static String key_file = key_file_folder + "/secuKey.key";
	
	protected static String publicKey_file1 = key_file_folder + "/publicKey1.key";
	protected static String privateKey_file1 = key_file_folder + "/privateKey1.key";
	
	protected static String publicKey_file2 = key_file_folder + "/publicKey2.key";
	protected static String privateKey_file2 = key_file_folder + "/privateKey2.key";
	
	protected static String data_cipher_file = cryptogram_folder + "/data_cipher.bin";
	protected static String sign_cipher_file = cryptogram_folder + "/sign_cipher.bin";
	protected static String digital_envelope_file = data_file_folder + "/digital_envelope.bin";
	
	protected static String zip_file = digital_envelope_folder + "/document.zip";

	//getter setter
	public static String getUpload_file_folder() {
		return upload_file_folder;
	}

	public static void setUpload_file_folder(String upload_file_folder) {
		FileNameClass.upload_file_folder = upload_file_folder;
	}
	public static String getDownload_file_folder() {
		return download_file_folder;
	}

	public static void setDownload_file_folder(String download_file_folder) {
		FileNameClass.download_file_folder = download_file_folder;
	}
	public static String getKeyAlgorithm() {
		return keyAlgorithm;
	}

	public static void setKeyAlgorithm(String keyAlgorithm) {
		FileNameClass.keyAlgorithm = keyAlgorithm;
	}

	public static int getKeyAlgorithm_init() {
		return keyAlgorithm_init;
	}

	public static void setKeyAlgorithm_init(int keyAlgorithm_init) {
		FileNameClass.keyAlgorithm_init = keyAlgorithm_init;
	}

	public static String getPairKeyAlgorithm() {
		return pairKeyAlgorithm;
	}

	public static void setPairKeyAlgorithm(String pairKeyAlgorithm) {
		FileNameClass.pairKeyAlgorithm = pairKeyAlgorithm;
	}

	public static int getPairKeyAlgorithm_init() {
		return pairKeyAlgorithm_init;
	}

	public static void setPairKeyAlgorithm_init(int pairKeyAlgorithm_init) {
		FileNameClass.pairKeyAlgorithm_init = pairKeyAlgorithm_init;
	}

	public static String getSignAlgorithm() {
		return signAlgorithm;
	}

	public static void setSignAlgorithm(String signAlgorithm) {
		FileNameClass.signAlgorithm = signAlgorithm;
	}

	public static String getData_file_folder() {
		return data_file_folder;
	}

	public static void setData_file_folder(String data_file_folder) {
		FileNameClass.data_file_folder = data_file_folder;
	}

	public static String getCryptogram_folder() {
		return cryptogram_folder;
	}

	public static void setCryptogram_folder(String cryptogram_folder) {
		FileNameClass.cryptogram_folder = cryptogram_folder;
	}

	public static String getKey_file_folder() {
		return key_file_folder;
	}

	public static void setKey_file_folder(String key_file_folder) {
		FileNameClass.key_file_folder = key_file_folder;
	}

	public static String getDigital_envelope_folder() {
		return digital_envelope_folder;
	}

	public static void setDigital_envelope_folder(String digital_envelope_folder) {
		FileNameClass.digital_envelope_folder = digital_envelope_folder;
	}

	public static String getUnzip_file_path() {
		return unzip_file_path;
	}

	public static void setUnzip_file_path(String unzip_file_path) {
		FileNameClass.unzip_file_path = unzip_file_path;
	}

	public static String getData_file() {
		return data_file;
	}

	public static void setData_file(String data_file) {
		FileNameClass.data_file = data_file;
	}

	public static String getKey_file() {
		return key_file;
	}

	public static void setKey_file(String key_file) {
		FileNameClass.key_file = key_file;
	}

	public static String getPublicKey_file1() {
		return publicKey_file1;
	}

	public static void setPublicKey_file1(String publicKey_file1) {
		FileNameClass.publicKey_file1 = publicKey_file1;
	}

	public static String getPrivateKey_file1() {
		return privateKey_file1;
	}

	public static void setPrivateKey_file1(String privateKey_file1) {
		FileNameClass.privateKey_file1 = privateKey_file1;
	}

	public static String getPublicKey_file2() {
		return publicKey_file2;
	}

	public static void setPublicKey_file2(String publicKey_file2) {
		FileNameClass.publicKey_file2 = publicKey_file2;
	}

	public static String getPrivateKey_file2() {
		return privateKey_file2;
	}

	public static void setPrivateKey_file2(String privateKey_file2) {
		FileNameClass.privateKey_file2 = privateKey_file2;
	}

	public static String getData_cipher_file() {
		return data_cipher_file;
	}

	public static void setData_cipher_file(String data_cipher_file) {
		FileNameClass.data_cipher_file = data_cipher_file;
	}

	public static String getSign_cipher_file() {
		return sign_cipher_file;
	}

	public static void setSign_cipher_file(String sign_cipher_file) {
		FileNameClass.sign_cipher_file = sign_cipher_file;
	}

	public static String getDigital_envelope_file() {
		return digital_envelope_file;
	}

	public static void setDigital_envelope_file(String digital_envelope_file) {
		FileNameClass.digital_envelope_file = digital_envelope_file;
	}

	public static String getZip_file() {
		return zip_file;
	}

	public static void setZip_file(String zip_file) {
		FileNameClass.zip_file = zip_file;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//getter setter
}
