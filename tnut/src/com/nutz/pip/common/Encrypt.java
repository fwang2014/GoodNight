package com.nutz.pip.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 字符加密和解密工具类
 * 
 * @author fwang
 * 
 */
public class Encrypt {

	public Encrypt() {
	}

	public static String encode(String msg, String method) {
		if (msg == null || method == null)
			return msg;
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance(method);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return msg;
		}
		algorithm.reset();
		byte buf[] = msg.getBytes();
		algorithm.update(buf);
		byte digest[] = algorithm.digest();
		StringBuffer retsult = new StringBuffer(0);
		for (int i = 0; i < digest.length; i++)
			retsult.append(Encrypt.toHexString(digest[i]));
		return retsult.toString();

	}

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private static String toHexString(byte b) {
		int i = 0, j = 0;
		i = (byte) ((b >>> 4) & 15);
		j = (byte) (b & 15);
		return new StringBuffer().append(digits[i]).append(digits[j])
				.toString();
	}

	public static void main(String args[]) {

		System.out.println(Encrypt.encode("111", "MD5"));
		System.out.println(Encrypt.encode("111", "SHA"));
		System.out.println(Encrypt.encode("111", "SHA-1"));

		// 698d51a19d8a121ce581499d7b701668
		// 6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2
		// 6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2

		System.out.println(Encrypt.encode("ebuilds", "MD5"));
		System.out.println(Encrypt.encode("admin", "MD5"));
		
		System.out.println("武汉云庐茶通科技有限公司(MD5):"+Encrypt.encode("武汉云庐茶通科技有限公司", "MD5"));
		System.out.println("武汉云庐茶通科技有限公司(SHA):"+Encrypt.encode("武汉云庐茶通科技有限公司", "SHA"));
		System.out.println("武汉云庐茶通科技有限公司(SHA-1):"+Encrypt.encode("武汉云庐茶通科技有限公司", "SHA-1"));
	}

}
