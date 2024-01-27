import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class purchase_details {
public static void purchase(String cust_name,int vegid,String veg_name,int quan,int rate) {
	Configuration configuration=new Configuration();
	configuration.configure("hibernate.cfg.xml");
	SessionFactory factory=configuration.buildSessionFactory();
	Session session=factory.openSession();
	Transaction transaction=session.beginTransaction();
	Query query=session.createSQLQuery("INSERT INTO `vegetables`.`purchase_details` (`cust_name`, `vegid`, `name`, `quantity`, `rate`) VALUES ('"+cust_name+"', '"+vegid+"', '"+veg_name+"', '"+quan+"', '"+rate+"')");
	query.executeUpdate();
	transaction.commit();
}
}
