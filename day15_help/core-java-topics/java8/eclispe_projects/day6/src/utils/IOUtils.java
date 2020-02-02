package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.app.core.Customer;

public class IOUtils {
	public static void writeData(HashMap<String, Customer> custs) throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("custs.ser"))) {
			out.writeObject(custs);
			System.out.println("info stored....");
		}
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, Customer> readData(String fileName) throws Exception {
		// java.io.File --class that represents metadata about files/folders
		// File class instance --represents path

		File f1 = new File(fileName);
		if (f1.exists() && f1.isFile() && f1.canRead()) {
			try (ObjectInputStream in = 
					new ObjectInputStream(new FileInputStream(fileName))) {
				return (HashMap<String, Customer>) in.readObject();
			}
		} else
			return new HashMap<>();
			

	}
}
