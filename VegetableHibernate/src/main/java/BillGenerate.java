import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BillGenerate {
static int total_price;
static int final_bill;
	
	public static void BillGenerate(int id, int quan)

	{
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
	
		Query query=session.createSQLQuery("SELECT  rate FROM detail Where Vegid= '"+id+"'");
		Query query1=session.createSQLQuery("SELECT  stock FROM detail Where Vegid= '"+id+"'");
		    int res=(Integer) query.uniqueResult();
		    int stock=(Integer) query1.uniqueResult();
		    stock=stock-quan;
		    Query query2=session.createSQLQuery("UPDATE `vegetables`.`detail` SET `stock` = '"+stock+"' WHERE (`Vegid` = '"+id+"')");
		    query2.executeUpdate();
		    total_price=quan*res;
			final_bill+=total_price;
			 transaction.commit();
			 Home home=session.get(Home.class, id);
			 int id1=home.getVegid();
			 String name=home.getName();
             purchase_details.purchase(customer_info.name,id,name,quan,total_price);
		

		System.out.println("You Bought"+quan+"Kgs of"+name+"at Ruppess"+total_price);
	}
}
