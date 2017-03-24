/**
 * 
 */
package gen.test;

import java.io.File;

import org.nutz.filepool.FilePool;
import org.nutz.filepool.NutFilePool;

/**
 * @author Administrator
 *
 */
public class MyLang {
	
	/**
	 * 文件池
	 */
	public void testPool(){
		// 将目录 ~/tmp/myfiles 作为一个文件池的根目录，里面最多同时有2000个文件
		FilePool pool = new NutFilePool("~/tmp/myfiles", 2000);
		// 将目录 ~/tmp/myfiles 作为一个文件池的根目录，里面不限文件
		//FilePool pool = new NutFilePool("~/tmp/myfiles");// 相当于FilePool pool = new NutFilePool("~/tmp/myfiles", 0);
	
		File f = pool.createFile(".png");  // 该文件本句之后，已经被创建
		
		System.out.println(f.getAbsolutePath());
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Lang 
		MyLang ml = new MyLang();
		ml.testPool();
	}

}
