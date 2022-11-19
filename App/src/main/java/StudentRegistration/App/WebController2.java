package StudentRegistration.App;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController2 {

    @RequestMapping("/page1")
    public ModelAndView page1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page1.html");
        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @RequestMapping("/student_view")
    public ModelAndView student() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student_view.html");
        return modelAndView;
    }

}