package testweb1;

import java.util.List;

import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.biz.impl.UsersBizImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestBiz extends TestCase {

	public TestBiz(String testName) {
		super(testName);
	}

	public static Test suite() { // 测试套件
		TestSuite t = new TestSuite();
		t.addTestSuite(TestBiz.class);
		return t;
	}
	
	public void testlog(){
		Users u = new Users();
		u.setUname("a");
		u.setUpass("e");
		UsersBiz ub = new UsersBizImpl();
		Users user =  ub.login(u);
		System.out.println(user);
		
	}
}
