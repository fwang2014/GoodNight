package com.nutz.pip.common.json;

import java.util.ArrayList;
import java.util.List;

import org.nutz.json.Json;

import com.nutz.pip.model.misc.Phonebook;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Phonebook book = new Phonebook();
		List list = new ArrayList();
		book.setCode("001");
		book.setName("fwang");
		book.setPhone("15926255746");
		
		String result = Json.toJson(book);
		System.out.println(result);
		list.add(book);
		result = Json.toJson(list);
		System.out.println(result);
		
		Phonebook book2 = new Phonebook();
		book2.setCode("002");
		book2.setName("fwang2");
		book2.setPhone("222");
		list.add(book2);
		result = Json.toJson(list);
		System.out.println(result);
	}

}
