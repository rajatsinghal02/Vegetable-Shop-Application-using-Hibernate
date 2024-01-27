import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DisplayData {
	static int id;
	static int quan;
	public static void DisplayData() {
		Scanner sc=new Scanner(System.in);
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Query query=session.createQuery("From Home");
		List<Home> list=query.list();
		for(Home home:list)
		{
			System.out.println(home.getVegid()+""+home.getName()+""+home.getStock()+""+home.getDesc()+""+home.getRate());
		}
		System.out.println("Enter the Vegetable ID you want to buy:");
		id=sc.nextInt();
		System.out.println("Enter the Quantity:");
		 quan=sc.nextInt();
		 BillGenerate.BillGenerate(id,quan);
		 System.out.println("Do you want to buy more vegetables");
			System.out.println("1--> Yes");
			System.out.println("2--> Want to Generate Bill");
			int ch=sc.nextInt();
			BuyVegetable(ch);
		
	}
	public static void  BuyVegetable(int ch1)
	{
		if(ch1==1)
		{
			DisplayData.DisplayData();
		}
		else if(ch1==2)
		{
			System.out.println("Thanks for Your Response");
			System.out.println(BillGenerate.final_bill);
		}
	}
}
