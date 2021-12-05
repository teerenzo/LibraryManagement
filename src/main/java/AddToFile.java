import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.RequestDispatcher;

public class AddToFile {
	
	public void data(String data) {
	    try {
			Files.write(Paths.get("C:\\Users\\user\\eclipse-workspace\\LibraryManagement\\name.txt"), data.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
