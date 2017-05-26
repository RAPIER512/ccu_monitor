package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.courage.ccu_monitor.dao.AlarmRecordMapper;
import com.courage.ccu_monitor.dao.CrawlReplyMapper;
import com.courage.ccu_monitor.dao.CrawlTitleMapper;
import com.courage.ccu_monitor.dao.KeywordMapper;
import com.courage.ccu_monitor.model.AlarmRecord;
import com.courage.ccu_monitor.model.CrawlTitle;
import com.courage.ccu_monitor.service.AlarmManage;
import com.github.pagehelper.PageHelper;

@RunWith(SpringJUnit4ClassRunner.class)      
@ContextConfiguration({"classpath*:/spring-mybatis.xml"})
public class ServiceAndDaoTest {
	@Autowired
	CrawlReplyMapper cReply;

	@Autowired
	CrawlTitleMapper cTitle;

	@Autowired
	KeywordMapper keyword;

	@Autowired
	AlarmRecordMapper aRecord;

	      
	@Autowired 
    private  AlarmManage am;
	
	
    @Test  
    public void test(){ 
//     	List<AlarmRecord> list = am.getAlarmRecord();
//    	System.out.println("list.size()"+list.size());

    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String end = sf.format(cal.getTime());
		cal.add(Calendar.MINUTE, -300);
		String start = sf.format(cal.getTime());
		
		StringBuffer sbf = new StringBuffer();
    	List<CrawlTitle> ltitle = cTitle.selectByTimeScope1(start, end);
		for (int i = 0; i < ltitle.size(); i++) {
			sbf.append(ltitle.get(i).getText());
		}
		System.out.println(sbf.toString());
    }  
    
    @Test  
    public void test1(){  
        System.out.println("wo jiu shi wo");
    } 
    
    public static void main(String[] args) {
    	String time = "2017-05-23 14:54:44";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
    	System.out.println(cal.get(Calendar.DAY_OF_YEAR));
    	
    	
    	/*ApplicationContext content = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    	try {
    		while(true){
    			Thread.sleep(1000*60*60);
    		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}
