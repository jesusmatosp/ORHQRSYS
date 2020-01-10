package pe.gob.onp.orrhh.qr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrhqrsysApplicationTests {

	@Test
	void contextLoads() {
		String text = null;
		if(text != null && !text.isEmpty()) {
			System.out.println("no es vacio");
		} else {
			System.out.println("Es vacio");
		}
			
	}

}
