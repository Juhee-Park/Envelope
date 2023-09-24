package com.final20180971;
import java.io.FileNotFoundException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CreateKeyClass {
	
	//비밀키 생성
	public SecretKey makeKey(String algo, int key_size){

		KeyGenerator keygen = null;
		
		try {
			keygen = KeyGenerator.getInstance(algo);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (keygen == null){
			System.err.println("keygen null error");
		}
		
		keygen.init(key_size);

		SecretKey secretKey = keygen.generateKey();

		return secretKey;
	}
	
	//비밀키 읽어오기
	public SecretKey readKey(String fname) {
		
		ReadWriteClass<SecretKey> rwc = new ReadWriteClass<SecretKey>();
		
		SecretKey key = null;
		try {
			key = rwc.readFromFile(fname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("비밀키 파일이 존재하지 않습니다.");
		}
		
		return key;
	}
	
	//비밀키 저장하기
	public boolean writeKey(String fname, SecretKey key) {
		
		ReadWriteClass<SecretKey> rwc = new ReadWriteClass<SecretKey>();
		
		rwc.writeToFile(fname, key);
		
		return true;
	}
	
	//비대칭키 생성
	public KeyPair makeKeyPair(String algo, int key_pair_size){

		KeyPairGenerator keyPairGen = null;
		
		try {
			keyPairGen = KeyPairGenerator.getInstance(algo);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (keyPairGen == null){
			System.err.println("keypairGen null error");
		}
		
		keyPairGen.initialize(key_pair_size);

		KeyPair keyPair = keyPairGen.generateKeyPair();

		return keyPair;
	}
	
	//공개키 읽어오기
	public PublicKey readPublicKey(String fname) {
		
		ReadWriteClass<PublicKey> rwc = new ReadWriteClass<PublicKey>();
		
		PublicKey key = null;
		try {
			key = rwc.readFromFile(fname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("공개키 파일이 존재하지 않습니다.");
		}
		
		return key;
	}
	
	//공개키 저장하기
	public boolean writePublicKey(String fname, PublicKey key) {
		
		ReadWriteClass<PublicKey> rwc = new ReadWriteClass<PublicKey>();
		
		rwc.writeToFile(fname, key);
		
		return true;
	}
	
	//개인키 읽어오기
	public PrivateKey readPrivateKey(String fname) {
		
		ReadWriteClass<PrivateKey> rwc = new ReadWriteClass<PrivateKey>();
		
		PrivateKey key = null;
		try {
			key = rwc.readFromFile(fname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("개인키 파일이 존재하지 않습니다.");
		}
		
		return key;
	}
	
	//개인키 저장하기
	public boolean writePrivateKey(String fname, PrivateKey key) {
		
		ReadWriteClass<PrivateKey> rwc = new ReadWriteClass<PrivateKey>();
		
		rwc.writeToFile(fname, key);
		
		return true;
	}

}
