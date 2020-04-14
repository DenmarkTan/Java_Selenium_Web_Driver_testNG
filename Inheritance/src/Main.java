import java.awt.*;
import java.lang.Math;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Insect insect = new Insect(5,6);
		Spider spider = new Spider(13,true);
		Cricket cricket = new Cricket(21,1.25);
		
		System.out.println(cricket.no);
		insect.crawl();
		insect.says();
		
		spider.crawl();
		spider.says();
		
		cricket.crawl();
		cricket.says();
		cricket.jump();
		
	}
}
