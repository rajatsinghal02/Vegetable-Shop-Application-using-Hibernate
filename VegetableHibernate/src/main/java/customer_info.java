import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class customer_info {
	static String name;
public static void info() {
	Scanner sc=new Scanner(System.in);

	System.out.println("Enter Customer name:");
    name=sc.next();
	Configuration configuration=new Configuration();
	configuration.configure("hibernate.cfg.xml");
	SessionFactory factory=configuration.buildSessionFactory();
	Session session=factory.openSession();
	Transaction transaction=session.beginTransaction();
	Query query=session.createSQLQuery("INSERT INTO `vegetables`.`customersdetails` (`cust_name`) VALUES ('"+name+"')");
	query.executeUpdate();
	transaction.commit();
	
	
}
}
