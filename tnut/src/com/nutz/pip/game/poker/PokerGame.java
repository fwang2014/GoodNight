package com.nutz.pip.game.poker;

import java.util.ArrayList;
import java.util.List;

import org.nutz.lang.random.R;

public class PokerGame {
	private static final String type1s[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private static final String type2s[] = {"黑桃","红杏","梅花","方块"};//♡♣♧♢♠♤
	private static final String type3s[] = {"大鬼","小鬼"};
	private static final int NUM_CARD = 54;

	protected String pokers[] = setPokers4();
	
	protected Poker poks[] = getPokers();
	

	public PokerGame() {
	}
	
	public List<Poker> getList(){
		List<Poker> list = new ArrayList<Poker>();
		Poker[] pokers = this.getPokers();
		for(Poker p:pokers){
			list.add(p);
		}
		return list;
	}
	
	public List<Poker> shuffle(List<Poker> list){
		List<Poker> list2 = new ArrayList<Poker>();
		//Poker[] pokers = this.getPokers();
		for(int i=0;i<list.size()*10;i++){
			//list2.add(p);
			int rnd1 = R.random(0, 53);
			int rnd2 = R.random(0, 53);	
			if(rnd1 != rnd2){
				Poker tem = list.get(rnd1);	
				Poker p1 = list.get(rnd1);
				Poker p2 = list.get(rnd2);
				//p1 = p2;
				//p2 = tem;	
				list.add(rnd1, p2);
				list.add(rnd2, p1);
			}
			
		}
		return list2;
	}
	
	private Poker[] getPokers(){
		Poker pokers[] = new Poker[54];
		int index = 0;
		for(int i=0;i<type1s.length;i++){
			for(int j=0;j<type2s.length;j++){				
				//pokers[index] = type2s[j]+type1s[i];
				Poker poker = new Poker();
				poker.setId(index+"");
				poker.setIndex(index);
				poker.setName(type2s[j]+type1s[i]);
				poker.setStatus(0);
				
				pokers[index] = poker;
				index++;
				//System.out.println(index+":"+type2s[j]);
			}
		}
		Poker poker1 = new Poker();
		poker1.setId(53+"");
		poker1.setIndex(53);
		poker1.setName(type3s[0]);
		pokers[52] = poker1;
		
		Poker poker2 = new Poker();
		poker2.setId(54+"");
		poker2.setIndex(54);
		poker2.setName(type3s[1]);
		pokers[53] = poker2;
		return pokers;
	}
		
	
	private String[] setPokers4(){
		String pokers[] = new String[54];
		int index = 0;
		for(int i=0;i<type1s.length;i++){
			for(int j=0;j<type2s.length;j++){				
				pokers[index] = type2s[j]+type1s[i];
				index++;
				//System.out.println(index+":"+type2s[j]);
			}
		}
		pokers[52] = type3s[0];
		pokers[53] = type3s[1];
		return pokers;
	}
	
	private String[] setPokers13(){
		String pokers[] = new String[54];
		int index = 0;
		for(int i=0;i<type2s.length;i++){
			for(int j=0;j<type1s.length;j++){				
				pokers[index] = type2s[i]+type1s[j];
				index++;
			}
		}
		pokers[52] = type3s[0];
		pokers[53] = type3s[1];
		return pokers;
	}
	
	/**
	 * 3个人发牌 斗地主
	 * 17,17,20(地主多三张)
	 * @return
	 */
	public String[][] takeCardBy3(){
		String cards[][] = new String[3][18];
		
		return cards;
	}
	
	/**
	 * 洗牌
	 * 更改每张牌属性和序号完成
	 */
	private Poker[] shuffle(){
		if(poks != null && poks.length == this.NUM_CARD){
			for(int i=0;i<this.NUM_CARD*10;i++){
				int rnd1 = R.random(0, 53);
				int rnd2 = R.random(0, 53);
				if(rnd1 != rnd2){
					poks[rnd1].setIndex(rnd2);
					poks[rnd2].setIndex(rnd1);
				}
			}
		}
		return poks;
	}
	
	/**
	 * 洗牌
	 * 根据两次的随机数，调整两张牌的位置
	 */
	public Poker[] shuffle2(){
		if(poks != null && poks.length == this.NUM_CARD){
			for(int i=0;i<this.NUM_CARD*10;i++){
				int rnd1 = R.random(0, 53);
				int rnd2 = R.random(0, 53);				
				if(rnd1 != rnd2){
					Poker tem = poks[rnd1];
					poks[rnd1] = poks[rnd2];
					poks[rnd2] = tem;
					
					//poks[rnd1].setIndex(rnd2);
					//poks[rnd2].setIndex(rnd1);
				}
			}
		}
		return poks;
	}
	
	public void outCardInfo(Poker poks[]){
		System.out.println("---------------------------out card info start...");
		if(this.poks != null && this.poks.length==this.NUM_CARD){
			int count = 0;
			for(int i=0;i<=this.NUM_CARD;i++){
				for(int j=0;j<this.NUM_CARD;j++){
					
					Poker poker = poks[j];
					int index = poker.getIndex();
					if(index == i){
						System.out.println(i+":"+poker.getName()+"["+poker.getId()+"]");
						poker.setStatus(1);
						count++;
						break;
					}
				}
			}
			System.out.println("out count:"+count);
			
			System.out.println("--------------------not out card info as ------------");
			count = 0;
			for(int i=0;i<this.NUM_CARD;i++){
				Poker poker = poks[i];
				if(poker.getStatus() == 0){
					System.out.println(i+":"+poker.getName()+"["+poker.getId()+"]");
					count++;
				}
			}
			System.out.println("not out count:"+count);
			
		}		
		System.out.println("-----------------------------out card info end");
	}
	
	public void outCardInfo2(Poker poks[]){
		System.out.println("---------------------------out card info start...");
		if(this.poks != null && this.poks.length==this.NUM_CARD){
			int count = 0;
			for(int i=0;i<this.NUM_CARD;i++){
				//for(int j=0;j<this.NUM_CARD;j++){
					
					Poker poker = poks[i];
					int index = poker.getIndex();
					//if(index == i){
						System.out.println(i+":"+poker.getName()+"["+poker.getId()+"]");
						poker.setStatus(1);
						count++;
						//break;
					//}
				//}
			}
			System.out.println("out count:"+count);
			
			System.out.println("--------------------not out card info as ------------");
			count = 0;
			for(int i=0;i<this.NUM_CARD;i++){
				Poker poker = poks[i];
				if(poker.getStatus() == 0){
					System.out.println(i+":"+poker.getName()+"["+poker.getId()+"]");
					count++;
				}
			}
			System.out.println("not out count:"+count);
			
		}		
		System.out.println("-----------------------------out card info end");
	}
	
	public void testRand(){
		for(int i=0;i<100;i++){
			int rnd = R.random(-10, 54);//获取-10~54之间随机整数
			System.out.println(rnd);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PokerGame game = new PokerGame();
		Poker poks[] = game.getPokers();
		game.outCardInfo(poks);
		game.outCardInfo2(poks);
		//poks = game.shuffle();
		poks = game.shuffle2();
		//game.outCardInfo(poks);
		game.outCardInfo2(poks);
		
	}

}
