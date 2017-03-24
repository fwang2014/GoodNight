package com.nutz.pip.action.game;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.random.R;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;

import com.nutz.pip.action.misc.SysBeanAction;
import com.nutz.pip.dao.game.PokerDao;
import com.nutz.pip.game.poker.Poker;
import com.nutz.pip.game.poker.PokerGame;

/**
 * 游戏.扑克控制对象
 * @author Administrator
 *
 */
@IocBean
@InjectName
public class PokerAction {
	@SuppressWarnings("unused")
	private static final org.nutz.log.Log log = org.nutz.log.Logs
			.getLog(SysBeanAction.class);

	private final String tab = "Poker";
	private final String menuCode = "P01";

	@SuppressWarnings("unused")
	@Inject
	private PokerDao pokerDao;

	@At("/Game/Poker/index")
	@Ok("jsp:/jsp/game/poker/index")
	@Fail("jsp:/error")
	public void index(HttpServletRequest request) throws Exception {
		System.out.println("PokerAction.index");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		PokerGame game = new PokerGame();
		List<Poker> list = game.getList();
		request.setAttribute("list", list);		
	}
	
	@At("/Game/Poker/shuffle")
	@Ok("jsp:/jsp/game/poker/index")
	@Fail("jsp:/error")
	public void shuffle(HttpServletRequest request) throws Exception {
		System.out.println("PokerAction.shuffle");
		request.setAttribute("tab", tab);
		request.setAttribute("menuActive", menuCode);
		PokerGame game = new PokerGame();
		//List<Poker> list = game.getList();
		//list = game.shuffle(list);
		//request.setAttribute("list", list);	
		
		Poker[] pokers = game.shuffle2();
		request.setAttribute("list", pokers);
		
	}
	
	@At("/Json/Poker/rand")
	@Ok("json")
	@Fail("jsp:/error")
	public Object randomCard(HttpServletRequest request) throws Exception {
		System.out.println("PokerAction.randomCard");  
		int rands[] = new int[10];
		for(int i=0;i<10;i++){
			rands[i] = R.random(0, 53);
		}
		return rands; 
		
	}
	
	@At("/Json/test")
	@Ok("json")
	@Fail("jsp:/error")
	public Object randomCard2(HttpServletRequest request) throws Exception {
		System.out.println("PokerAction.randomCard2");  
		int rands[] = new int[10];
		for(int i=0;i<10;i++){
			rands[i] = R.random(0, 53);
		}
		return rands; 
		
	}
}
