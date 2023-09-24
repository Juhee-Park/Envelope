package com.final20180971;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.security.Key;
import java.security.KeyPair;

import javax.crypto.SecretKey;

public class CreateKey extends FileNameClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public boolean create_key(String real_path) {

		System.out.println("\n개인키 파일 하나, 두 쌍의 비밀키와 공개키 파일을 생성합니다.");
		CreateKeyClass ckc = new CreateKeyClass();

		// 비밀키
		SecretKey key = ckc.makeKey(keyAlgorithm, keyAlgorithm_init);
		ckc.writeKey(real_path + key_file, key);

		KeyPair keypair1 = ckc.makeKeyPair(pairKeyAlgorithm, pairKeyAlgorithm_init);

		// 공개키1
		ckc.writePublicKey(real_path + publicKey_file1, keypair1.getPublic());
		// 개인키1
		ckc.writePrivateKey(real_path + privateKey_file1, keypair1.getPrivate());

		KeyPair keypair2 = ckc.makeKeyPair(pairKeyAlgorithm, pairKeyAlgorithm_init);

		// 공개키2
		ckc.writePublicKey(real_path + publicKey_file2, keypair2.getPublic());
		// 개인키2
		ckc.writePrivateKey(real_path + privateKey_file2, keypair2.getPrivate());

		System.out.println("모든 키 파일을 생성하였습니다.\n");

		
		return true;
	}
}
