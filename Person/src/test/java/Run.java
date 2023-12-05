package person;
import static junit.framework.Assert.*;
import org.junit.Test;
public class Run{
	@Test
	public void presonSay(){
		Preson preson = new Preson();
		System.out.println("在测试类中调用personSay()方法");
		preson.presonSay();
	}
}