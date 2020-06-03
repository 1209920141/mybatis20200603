import com.neuedu.mapper.EmpMapper;
import com.neuedu.po.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis2 {

    @Test
    public void test1() {
        //inputstream
        try {
           InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

           //create sqlSessionFactory
           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

           //get sqlsession using this factory
           SqlSession session = factory.openSession();

           EmpMapper empMapper = session.getMapper(EmpMapper.class);

           //get one emp
           Emp e = empMapper.selectEmp(7369);

           System.out.println(e.getEmpno()+"\t" + e.getEname()+"\t"+e.getHiredate());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
