package com.final20180971;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class VeriEnvelope extends FileNameClass implements Serializable{

	private static final long serialVersionUID = 1L;

	public boolean veri_envelope (String real_path, String data_file_name, String upload_private_key2, 
			String upload_public_key1, String upload_public_key2) {
		
		//비밀키, 개인키1, 공개키2 가져오기
		CreateKeyClass ckc = new CreateKeyClass();
		
		PrivateKey private_key2 = ckc.readPrivateKey(upload_private_key2);
		PublicKey public_key1 = ckc.readPublicKey(upload_public_key1);
		PublicKey public_key2 = ckc.readPublicKey(upload_public_key2);

		if (private_key2 == null || public_key1 == null || public_key2 == null){
			System.err.println("\n사용 가능한 키가 없어 모드를 종료합니다.");
			return false;
		}
		
		//압축파일 경로
		String data_file_path = data_file_name.replace(".zip", "/");
		
		//압축 해제
		ZipfileClass zc = new ZipfileClass();	
		zc.unZip(data_file_name, unzip_file_path);
		
		
		System.out.println("전자봉투를 복호화합니다.");
		
		CipherClass cc = new CipherClass();
		Cipher cipher_private_key2 = cc.createCypherObject(private_key2);
		
		//비밀키 개인키2로 복호화
		
		byte[] key_byte = cc.decodeToFile(data_file_path + digital_envelope_file, 
				cipher_private_key2, private_key2);
		
		
		SecretKey key = new SecretKeySpec(key_byte, keyAlgorithm);
		
		//데이터, 전자서명 복호화
		Cipher cipher_key = cc.createCypherObject(key);
		
		byte[] data = cc.decodeToFile(data_file_path + data_cipher_file, 
				cipher_key, key);
		byte[] sign = cc.decodeToFile(data_file_path + sign_cipher_file, 
				cipher_key, key);
		
		//데이터 파일 저장
		@SuppressWarnings("rawtypes")
		ReadWriteClass rwc = new ReadWriteClass();
		rwc.writeDataFile(real_path + data_file, data);
		
		//공개키1로 서명 검증
		SignatureClass snc = new SignatureClass();
		Signature sig = snc.makeSignature(signAlgorithm);
		
		boolean rslt = snc.verification(sig, sign, data, public_key1);
		
		System.out.println("검증 결과 :" + rslt);
		
		System.out.println("전자봉투 검증이 완료되었습니다.\n");
		
		return rslt;
	}
}
