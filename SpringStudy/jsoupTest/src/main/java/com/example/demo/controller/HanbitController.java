package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.NewBook;

@RestController
public class HanbitController {

	@GetMapping("/seats")
	public String seat() {
		String r = "";
		try {
			String url = "http://mpllc-seat.sen.go.kr/seatinfo/Seat_Info/1_count.asp";
			Document doc = Jsoup.connect(url).get();
			r = doc.select(".wating_f").get(0).text();
		} catch (Exception e) {
			System.out.println("예외"+e.getMessage());
		}
		return r;
	}
	
//	@GetMapping("/newBook") 내가한방법: 바로 뷰로 넘기기
	public String newBookMe(Model model) {
		String base = "https://www.hanbit.co.kr";
		String url = "https://www.hanbit.co.kr/store/books/new_book_list.html";
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		try {
			Document doc = Jsoup.connect(url).get();
			Elements listing = doc.select(".book_tit");
			for(Element p:listing) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				Element a = p.firstElementChild(); //저 e는 p태그니까 그 안의 a를 찾아야해서..자식노드 찾는 메소드
				String text = a.text();
				String href = a.attr("href");
				System.out.println(text);
				System.out.println(base+href);
				map.put("text", text);
				map.put("link", base+href);
				list.add(map);
			}
			model.addAttribute("list",list);
		} catch (Exception e) {
			System.out.println("크롤링예외:"+e.getMessage());
		}
		return "list";
	}
	
	
	@GetMapping("/newBook") //json으로 데이터만 보여주고 뷰에서는 ajax통신으로 가져오기
	public List<NewBook> newBook() {
		List<NewBook> booklist = new ArrayList<NewBook>();
		String base = "https://www.hanbit.co.kr";
		try {
		int i=1;
			while(true) {
				String url = "https://www.hanbit.co.kr/store/books/new_book_list.html?page="+i;
				Document doc = Jsoup.connect(url).get();
				Elements list = doc.select(".book_tit");
				if(list.size()==0) {
					break;
				}
				for(Element p:list) {
					Element a = p.firstElementChild(); //저 e는 p태그니까 그 안의 a를 찾아야해서..자식노드 찾는 메소드
					String text = a.text();
					
					String href = a.attr("href");
					booklist.add(new NewBook(text,base+href));
				}
				System.out.println(i+"페이지를 수집햇습니다.");
			i++;
			} 
		}catch (Exception e) {
			System.out.println("크롤링예외:"+e.getMessage());
		}
		return booklist;
	}
}
