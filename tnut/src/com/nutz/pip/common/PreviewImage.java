package com.nutz.pip.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PreviewImage {
	   /* 方法：  PreviewImage 
	    * 描述：  从session读取二进制字节流(byte[])到页面中生成图片 
	    * 输入：  BufferedInputStream reader , OutputStream os  
	    * 返回：  
	   * 异常处理： 
	   */  
	  public PreviewImage(BufferedInputStream reader,OutputStream os)throws IOException{  
	       byte[]  b  =  new  byte[1024  *  5];   //输出流的缓冲区 5kb  
	        int  len;   
	       reader.mark(reader.available()+1);   //标记该输入流的最开始的位置  
	        while  ( (len  =  reader.read(b))  !=  -1)  {   
	         os.write(b, 0, len);    
	        }    
	        reader.reset();   //让输入流定位到mark标记的位置,让输入流可以重新读取数据，否则将无法再次读取该输入流的数据  
	        os.flush();   
	        os.close();  
	  } 
}
