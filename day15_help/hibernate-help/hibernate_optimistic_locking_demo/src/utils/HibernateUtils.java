package utils;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		try {
			// create standard service registry from its builder
			StandardServiceRegistry reg=
					new StandardServiceRegistryBuilder().
					configure().build();
			//create meta data to hold db details
			Metadata data=new MetadataSources(reg).
					buildMetadata();
			//build sf from std service reg
			sf=data.buildSessionFactory();
			System.out.println("sf created!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSf() {
		return sf;
	}

}
