package creeper0809.discordbot;

import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DicCrawl {

	public String isthere(String word) {
		String noun = word;
		String url = "https://dict.naver.com/search.nhn?dicQuery=" + noun + "&query=" + noun
				+ "&target=dic&ie=utf8&query_utf=&isOnlyViewEE=";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements element = doc.getElementsByClass("kr_dic_section search_result dic_kr_entry");
			Elements ele = element.select("ul li p");
			String qe = ele.get(0).select("span.c_b").text();
			return ele.get(1).text();
		} catch (Exception e) {
			return "없는 단어";
		}

	}
}
