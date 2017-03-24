/**
 * 
 */
package com.nutz.misc;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start...");
		String imgPath = "D:/tem/RQCode/QR_ghxd.png";
		imgPath = "D:/tem/RQCode/surTheNet.jpg";
		String encoderContent = "《上网入门知识课程》\n课时2天18小时\n联系电话:15926255746 地址:快活岭大队部旁";
		System.out.println("content length:"+encoderContent.length());
		TwoDimensionCode handler = new TwoDimensionCode();
		handler.encoderQRCode(encoderContent, imgPath, "jpg");
		System.out.println("invoke end!");
	}

}
