import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
	public static void main(String[] args) throws IOException {
		FileInputStream fis1 = null;
		try (FileInputStream fis = new FileInputStream("/workspaces/Loafer/Nonka/src/Array_06.java")) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(fis1.read());
	}
}
