package ward.ggwp.kr.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/")
	public String indexPage() {
		return "index.html";
	}
}
