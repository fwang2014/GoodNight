package gen.test;

import java.io.File;
import java.io.IOException;



public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String folder = "d:/tem/gen/20130821/";
		String fileName = "test.txt";
		String filePath = folder +fileName;
		File f = new File(filePath);
		try {
			System.out.println(f.canRead());
			System.out.println(f.isDirectory());
			System.out.println(f.isFile());
			//f.mkdirs();
			//f.mkdir();

			f.createNewFile();
			if(!f.exists()){
				f.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
