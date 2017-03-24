package com.nutz.pip.common;

import java.util.Random;

public class SeqNum {

	public SeqNum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Long getPrimaryKeyForInt1(){	
		return System.currentTimeMillis();
	}
	
	public static String getPrimaryKeyForString(){	
		Long rand = (long)(new Random().nextFloat()*100000000);
		Long ct  = System.currentTimeMillis();
		StringBuffer buf = new StringBuffer();
		buf.append("PIP").append(ct).append("R").append(rand);
		return buf.toString();
	}
	
	public static String getFileSN(String fileType){	
		Long rand = (long)(new Random().nextFloat()*10000);
		Long ct  = System.currentTimeMillis();
		StringBuffer buf = new StringBuffer();
		buf.append(fileType).append(ct).append("-").append(rand);
		return buf.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
