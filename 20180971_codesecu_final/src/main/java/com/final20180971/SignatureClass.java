package com.final20180971;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureClass  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//객체 생성
	public Signature makeSignature(String signAlgorithm) {
		
		Signature sig = null;
		try {
			sig = Signature.getInstance(signAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sig == null) {
			System.err.println("Signature null error");
		}
		
		return sig;
		
	}
	
	//서명
	public byte[] sign(Signature sig, byte[] data, PrivateKey key) {
		
		byte[] signature = null;
		
		try {	
			sig.initSign(key);
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {		
			sig.update(data);
			
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {	
			signature = sig.sign();
			
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (signature == null) {
			System.out.println("signature null error");
		}
		
		return signature;	
	}
	
	//서명 읽어오기
	public byte[] readPrivateKey(String fname) {
		
		ReadWriteClass<byte[]> rwc = new ReadWriteClass<byte[]>();
		
		byte[] sig = null;
		try {
			sig = rwc.readFromFile(fname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("서명 파일이 존재하지 않습니다.");
		}
		
		return sig;
	}
	
	//서명 저장하기
	public boolean writeSignature(String fname, byte[] sig) {
		
		ReadWriteClass<byte[]> rwc = new ReadWriteClass<byte[]>();
		
		rwc.writeToFile(fname, sig);
		
		return true;
	}
	
	//검증
	public boolean verification(Signature sig, byte[] signature, byte[] data, PublicKey key) {
				
		try {
			sig.initVerify(key);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean rslt = false;
		
		try {
			
			sig.update(data);
		
			rslt = sig.verify(signature);
			
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rslt;
	}
	
}
