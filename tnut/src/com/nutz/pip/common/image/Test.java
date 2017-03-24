package com.nutz.pip.common.image;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class Test {
	
	public static void main(String args[]){
		String imagePath = "C:\\Users\\Administrator\\nutz\\upload\\tmps\\00\\00\\00\\00\\00\\00\\00\\02.jpg"; 
		String toPath = "d://tem/images/test2.jpg";
		String imageFormat = "JPG";
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(imagePath);
			BufferedImage image = ImageIO.read(is);
			
			os = new FileOutputStream(toPath);
			ImageIO.write(image, imageFormat, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
