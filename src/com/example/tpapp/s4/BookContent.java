package com.example.tpapp.s4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookContent {
	public static class Book {
		public Integer id;
		public String title;
		public String desc;

		public Book(Integer id, String title, String desc) {
			this.id = id;
			this.title = title;
			this.desc = desc;
		}
		@Override
		public String toString(){
			return title;
		}
	}
	public static List<Book> ITEMS = new ArrayList<Book>();
	public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
	static{
		addItem(new Book(1, "���Java����","һ��ȫ�桢�����Javaѧϰͼ�飬�Ѿ�����Ҹ�Уѡ���̲�"));
		addItem(new Book(2,"���Android����","Androidѧϰ�ߵ���ѡͼ�飬����ռ�ݾ���������������ѷ3����վAndroid�������а�İ���"));
		addItem(new Book(3,"������Java EE��ҵӦ��ʵս","ȫ�����Java EE������Struts2��Spring3��Hibernate4���"));
		
	}
	private static void addItem(Book book){
		ITEMS.add(book);
		ITEM_MAP.put(book.id, book);
	}
}
