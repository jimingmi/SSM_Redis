package com.gobha.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Helper {
	private MD5Helper(){}

	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	protected static MessageDigest messagedigest = null;
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * MD5字符串
	 *
	 * @param s
	 * @return
	 */
	public static String MD5(String s) {
		try {
			byte[] btInput = s.getBytes();
			messagedigest.update(btInput);
			byte[] md = messagedigest.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * MD5 文件
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String getFileMD5String(File file) throws IOException {

		InputStream fis;
		fis = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[1024];
		int numRead = 0;
		while ((numRead = fis.read(buffer)) > 0) {
			messagedigest.update(buffer, 0, numRead);
		}
		fis.close();
		return MD5Helper.bufferToHex(messagedigest.digest());
	}

	/**
	 * 对象HashCode
	 *
	 * @param object
	 * @return
	 * @throws IOException
	 */
	public static String getHashCode(Object object) throws IOException {
		if (object == null){
			return "";
		}

		String ss = null;
		ObjectOutputStream s = null;
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		try {
			s = new ObjectOutputStream(bo);
			s.writeObject(object);
			s.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
				s = null;
			}
		}
		ss = MD5Helper.MD5(bo.toString());
		return ss;
	}

	private static String bufferToHex(byte bytes[]) {
		return MD5Helper.bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			MD5Helper.appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];
		char c1 = hexDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static String MD5(String str , Integer num){
		if(num!=null){

			for(int i=0;i<num;i++){
				str = MD5Helper.MD5(str);
			}

		}else{
			str =  MD5Helper.MD5(str);
		}

		return str;
	}

	public static void main( String[] args ) {
		String str = "super";
		System.out.println(MD5Helper.MD5(str,10));
	}
}
