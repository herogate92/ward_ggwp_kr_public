package ward.ggwp.kr;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class WardGgwpKrtest {

	@Test
	void contextLoads() 
	{
		for (int i = 0; i < 10000; i++) {
			System.out.println(RandomStringUtils.randomAlphanumeric(6));
		}
	}

}
