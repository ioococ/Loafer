package ink.onei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.*;

@Controller
public class HelloController extends AbstractController {

    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("hello");
    }
}