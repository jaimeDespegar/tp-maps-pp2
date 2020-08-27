package factories;

import core.ClassFactory;
import factory.ClassLoaderFactory;
import implementation.LocationMock;
import model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClassLoaderFactoryTest {

    private ClassFactory instance;

    @Before
    public void setUp() {
        this.instance = new ClassLoaderFactory();
    }

    @Test
    public void loadClass_test() {
        Location provider = this.instance.load("/home/jaimequispe/ungs/pp2/jars", "implementation.LocationMock");
        Assert.assertEquals(provider.getClass(), LocationMock.class);
    }

}