package com.final20180971;

import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class MakeEnvelope extends FileNameClass implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public boolean make_envelope (String real_path, String data_file_name, String upload_key, String upload_private_key1, 
			String upload_public_key1, String upload_public_key2) {
		
		//비밀키, 개인키1, 공개키2 가져오기
		CreateKeyClass ckc = new CreateKeyClass();
		
		SecretKey key = ckc.readKey(upload_key);
		PrivateKey private_key1 = ckc.readPrivateKey(upload_private_key1);
		PublicKey public_key1 = ckc.readPublicKey(upload_public_key1);
		PublicKey public_key2 = ckc.readPublicKey(upload_public_key2);

		if (key == null || private_key1 == null || public_key1 == null || public_key2 == null){
			System.err.println("\n사용 가능한 키가 없어 모드를 종료합니다.");
			return false;
		}
		
		
		//데이터 받아오기	
		System.out.println("전자봉투를 생성합니다.");
		
		CipherClass cc = new CipherClass();
		Cipher cipher_secuKey = cc.createCypherObject(key);
		Cipher cipher_public_key2 = cc.createCypherObject(public_key2);
		
		//데이터파일 생성
		ReadWriteClass<String> rwc = new ReadWriteClass<String>();
		byte[] data = rwc.readStringDataFile(data_file_name);

		//데이터파일 비밀키로 암호화
		cc.encodeToFile(data_cipher_file, data, cipher_secuKey);
		
		
		
		//서명파일 생성
		SignatureClass sigclass = new SignatureClass();		
		Signature sig = sigclass.makeSignature(signAlgorithm);
		
		byte[] sign_data = sigclass.sign(sig, data, private_key1);	
		
		//서명파일 비밀키로 암호화
		cc.encodeToFile(sign_cipher_file, sign_data, cipher_secuKey);
		
		//비밀키를 공개키2로 암호화
		cc.encodeToFile(digital_envelope_file, 
				key.getEncoded(), cipher_public_key2);
		
		
		//압축
		ZipfileClass zc = new ZipfileClass();	
		zc.zip_file(real_path + zip_file, data_cipher_file, 
				sign_cipher_file, digital_envelope_file);
		
		System.out.println("전자봉투가 생성되었습니다.");
		System.out.println("위치 : " + real_path + zip_file + "\n");
		
		//민감데이터 사용 후 삭제
		data = null;
		sign_data = null;
		
		return true;
	}
}
