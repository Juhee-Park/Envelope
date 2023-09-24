package com.final20180971;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class ReadWriteClass<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//데이터파일 읽어오기
	protected byte[] readStringDataFile(String file_name){
		
		String data = "";
		
		try {
			
			Scanner file = new Scanner(new BufferedReader(new FileReader(file_name)));
		
			while (file.hasNext()) {
				data += file.nextLine() + "\n";
			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (data == ""){
			System.err.println("read data null error");
		}
		byte[] data_arr = data.getBytes();
		
		if (data_arr == null){
			System.err.println("read data_arr null error");
		}

		return data_arr;
	}
	//데이터 파일 쓰기
	protected boolean writeDataFile(String fname, byte[] data) {

		String string_data = new String(data);
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fname));

			pw.println(string_data);
			
			if (pw != null) {
				pw.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램을 종료합니다.\n");
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	//객체 읽어오기
	protected T readFromFile(String fname) throws FileNotFoundException{

		T data = null;

		try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(fname))) {
			data = (T) file.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (data == null) {
			System.err.println("read null error");
		}

		return data;
	}
	
	//객체 쓰기
	protected boolean writeToFile(String fname, T data) {

		try (FileOutputStream fstream = new FileOutputStream(fname)) {

			try (ObjectOutputStream pw = new ObjectOutputStream(fstream)) {

				
				pw.writeObject(data);

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
}
