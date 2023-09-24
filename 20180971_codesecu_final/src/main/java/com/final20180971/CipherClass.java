package com.final20180971;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;

public class CipherClass extends FileNameClass implements Serializable {

	private static final long serialVersionUID = 1L;

	// cipher 객체 생성
	public Cipher createCypherObject(Key secretKey) {

		Cipher cipher = null;

		try {

			cipher = Cipher.getInstance(secretKey.getAlgorithm());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (cipher == null) {
			System.err.println("cipher null error");
		}

		try {

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cipher;
	}

	// 암호화
	public boolean encodeToFile(String fname, byte[] data, Cipher c) {

		try (FileOutputStream fstream = new FileOutputStream(fname)) {

			try (CipherOutputStream cos = new CipherOutputStream(fstream, c)) {

				cos.write(data);
				cos.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return true;
	}

	// 복호화
	public byte[] decodeToFile(String fname, Cipher c, Key key) {

		try {

			c = Cipher.getInstance(key.getAlgorithm());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			c.init(Cipher.DECRYPT_MODE, key);

		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] data = null;
		try (FileInputStream fstream = new FileInputStream(fname)) {
			try (CipherInputStream cis = new CipherInputStream(fstream, c)) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int len;
				byte[] buffer = new byte[1024];
				while ((len = cis.read(buffer, 0, buffer.length)) != -1) {
					baos.write(buffer, 0, len);
				}
				baos.flush();
				data = baos.toByteArray(); // get the byte array
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return data;
	}

}
