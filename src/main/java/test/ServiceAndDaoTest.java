package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
}
