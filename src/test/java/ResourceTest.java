import com.bsuir.AbstractFactory;
import com.bsuir.resourceFactory.Resource;
import com.bsuir.resourceFactory.ResourceFactory;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Егор on 12.04.17.
 */
public class ResourceTest {
    AbstractFactory factory = new ResourceFactory();

    @Test
    public void TestXML(){
        Resource resource = factory.getResource("XML");
        Object ob = resource.getResource("TRAIN");
        assertNotNull(ob);
    }



}
