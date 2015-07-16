package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bhavsarer on 7/15/15.
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

    @ResponseBody
    public String hello(){
        return "Hello Web Services";
    }

}
