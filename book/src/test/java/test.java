import com.book.entity.Books;
import com.book.entity.Records;
import com.book.service.BooksService;
import com.book.service.RecordsService;
import com.book.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 */
public class test {

    @Test
    public void test (){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RecordsService recordsService = (RecordsService) classPathXmlApplicationContext.getBean("RecordsServiceImpl");
        for (Map<String, Object> records : recordsService.queryAllRecords(null,null,0,0)) {
            System.out.println(records);
        }
    }
}
