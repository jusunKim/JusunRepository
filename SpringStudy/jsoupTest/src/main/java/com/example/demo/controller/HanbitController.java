package com.example.demo.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.BookDAO;
import com.example.demo.entity.Book;
import com.example.demo.entity.NewBook;

import lombok.Setter;

@RestController
@Setter
public class HanbitController {
	
	@Autowired
	private BookDAO dao;
	
	@PostMapping("/search")
	   public String search(String search) {
		String base = "https://www.hanbit.co.kr";
	      try {
	         String url = "https://www.hanbit.co.kr/store/books/new_book_list.html?keyWord="+search+"&searchKey=p_title";
	         Document doc = Jsoup.connect(url).get();         
	         Elements elements = doc.select(".book_tit");
	         for(Element e : elements) {
	        	 Element a = e.firstElementChild();
	            String title = a.text();
	            String link = a.attr("href");
	            String p_code = link.substring(link.indexOf("=")+1); 
	            String url2 = base+link;
	            
	            //첫화면에 필요한 내용이 다 없어가지구 링크 가져와서 한 번 더 타고 들어가서 뽑아와야댐.
	            Document doc2 = Jsoup.connect(url2).get();         
		        Elements li = doc2.select(".info_list").get(0).getElementsByTag("li");
		        String writer = li.get(0).getElementsByTag("span").get(0).text();
		        String regdate = li.get(1).getElementsByTag("span").get(0).text();
		        if( !Character.isDigit(regdate.charAt(0))) {
		        	regdate = li.get(2).getElementsByTag("span").get(0).text();
		        }
		        int price = Integer.parseInt(doc2.select(".pbr").get(0).text().replace(",", "").replace("원", "")) ;
		        
		        		        
		        System.out.println("도서코드:"+p_code);
		        System.out.println("도서명:"+title);
		        System.out.println("저자:"+writer);
		        System.out.println("출간일:"+regdate);
		        System.out.println("가격:"+price);
		        Book b = new Book();
		        b.setP_code(p_code);
		        b.setTitle(title);
		        b.setRegdate(regdate);
		        b.setWriter(writer);
		        b.setPrice(price);
		        dao.save(b);
		        System.out.println("------------------------------");
	         }
	      }catch (Exception e) {
	         System.out.println("예외발생 : "+e.getMessage());
	      }
	      return "검색끗.";
	   }
	
	public void imageDownload(String addr, String fname) {
		fname = fname.replace(":", "_");
		fname = fname.replace("/", "_");
		fname = fname.replace("#", "_");
		fname = fname.replace("?", "_");
//		String base = "https://www.hanbit.co.kr";	
		try {
				URL url = new URL(addr);
				InputStream is = url.openStream();
				FileOutputStream fos = new FileOutputStream("c:/data/"+fname+".jpg");
				FileCopyUtils.copy(is.readAllBytes(), fos);
				is.close(); fos.close();
				System.out.println(fname+"이미지다운로드함");
			} catch (Exception e) {
				System.out.println("예외발생"+e.getMessage());
			}
	}
	
	@GetMapping("/downAll")
	   public String downAll() {
	      try {         
	            int page = 1;
	            while(true) {
	               String url = "https://www.hanbit.co.kr/store/books/new_book_list.html?page="+page;
	               Document doc = Jsoup.connect(url).get();
	               Elements elements = doc.select(".view_box");
	               if(elements.size() == 0 ) { //elements.size() == 0 이면 즉, doc.select로 더이상 읽어들이는게 없으면 break하시오.
	                  break;
	               }
	               for(Element e : elements) {
	                  Elements img = e.getElementsByTag("img");
	                  String src = img.get(img.size()-1).attr("src");
	                  String title = e.select(".book_tit").get(0).getElementsByTag("a").get(0).text();
	                  imageDownload("https://www.hanbit.co.kr/"+src, title);
	            }      
	               System.out.println(page+"페이지를 다운로드하였습니다.");
	               page++;
	         }
	      }catch (Exception e) {
	         System.out.println("예외발생 : "+e.getMessage());
	      }
	      return "OK";
	   }

	
	@GetMapping("/downImage")
	public String downImage() {
		ArrayList<String> addrs = new ArrayList<String>();
		ArrayList<String> fnames = new ArrayList<String>();
		
		try {
			int i = 1;
			while(true) {
				String newUrl = "https://www.hanbit.co.kr/store/books/new_book_list.html?page="+i;
				Document doc = Jsoup.connect(newUrl).get();
				Elements listBookname = doc.select(".book_tit");
				Elements listImage = doc.select(".thumb");
				for (Element p:listBookname) {
					Element a = p.firstElementChild(); 
					String bookname = a.text();
					bookname = bookname.replace(":", "_");
					bookname = bookname.replace("/", "_");
					bookname = bookname.replace("#", "_");
					fnames.add(bookname);
				}
				for(Element img:listImage) {
					String imglink = img.attr("src");
					addrs.add(imglink);
				}
				if(listBookname.size()==0) {
					break;
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println("가져오는거예외발생:"+e.getMessage());
		}
		
		for(int i=0; i<addrs.size(); i++) {
			imageDownload(addrs.get(i), fnames.get(i));
		} 
		
		return "OK";
	}
	
	/*
	@GetMapping("/downImage")
	public String downImage() {
		String addr = "https://www.hanbit.co.kr/data/books/B7027415255_l.jpg";
		try {
			URL url = new URL(addr);
			String fname = "퀵드로잉.jpg";
			InputStream is = url.openStream();
			FileOutputStream fos = new FileOutputStream("c:/data/"+fname);
			FileCopyUtils.copy(is.readAllBytes(), fos);
			is.close(); fos.close();
			System.out.println("이미지를 다운로드했습니다.");
		} catch (Exception e) {
			System.out.println("downImage 예외발생:"+e.getMessage());
		}
		return "OK";
	}*/
	
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
