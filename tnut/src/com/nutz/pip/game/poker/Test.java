package com.nutz.pip.game.poker;

public class Test {
	
	public static void main(String args[]){
		String type1s[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String type2s[] = {"黑桃","红杏","梅花","方块"};//♡♣♧♢♠♤
		String type3s[] = {"大鬼","小鬼"};
		
		/**
		 * 打印输入54张扑克
		 */
		String pokers[] = new String[54];		
		int index = 0;
		
		System.out.println("--------------------------打印输入54张扑克--------------------");
		for(int i=0;i<type1s.length;i++){
			for(int j=0;j<type2s.length;j++){				
				pokers[index] = type2s[j]+type1s[i];
				index++;
				//System.out.println(index+":"+type2s[j]);
			}
		}
		pokers[52] = type3s[0];
		pokers[53] = type3s[1];
		
		index = 0;
		for(String poker:pokers){
			index++;
			if(index%4==0){
				System.out.print("("+index+")"+poker+"\t\t");
				System.out.println();
			}else{
				System.out.print("("+index+")"+poker+"\t\t");
			}			
		}
		
		System.out.println();
		System.out.println("--------------------------按花色打印--------------------");
		/**
		 * 按花色打印
		 */
		String pokers2[] = new String[54];
		index = 0;
		for(int i=0;i<type2s.length;i++){
			for(int j=0;j<type1s.length;j++){
				pokers2[index] = type2s[i]+type1s[j];
				index++;
			}
		}
		pokers2[52] = type3s[0];
		pokers2[53] = type3s[1];
		
		index = 0;
		for(String poker:pokers2){
			index++;
			if(index%13==0){
				System.out.print(index+":"+poker+"\t");
				System.out.println();
			}else{
				System.out.print(index+":"+poker+"\t");
			}			
		}
		
	}

}
