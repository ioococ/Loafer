import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class a {

	public static void main(String[] args) throws ScriptException {
		// TODO 自动生成的方法存根
		ScriptEngineManager manager = new ScriptEngineManager();//初始化ScriptEngine类
		ScriptEngine engine = manager.getEngineByName("js");//初始化js引擎（这里传入Js/javascript/JavaScript效果相同）
		String js = "1 + 2";//定义js表达式
		Integer result = (Integer) engine.eval(js);//将表达式传入引擎中执行
		System.out.println(result);
	}

}
