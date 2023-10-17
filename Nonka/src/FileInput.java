import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = null;
		try (FileInputStream fis = new FileInputStream("D:\\荣耀\\Documents\\IdeaProjects\\Loafer\\Nonka\\src\\FileInput.java")) {
			System.out.println(fis.read());
			fis1 = fis;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(fis1.read());
	}
}
