package com.dmooc.controller.android;

import com.dmooc.model.TranslatorModel;
import com.dmooc.service.android.TranslatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/android/translate")
public class TranslatorDispatcherController {
	
	@Autowired
	TranslatorService translatorService;
	
    @RequestMapping(value = "/getInterpreterList", method = RequestMethod.GET)
    @ResponseBody
    public List<TranslatorModel> GetTranslatorList() {
        return translatorService.getTranslators();
    }

    @RequestMapping(value = "/getInterpreterInfo", method = RequestMethod.GET)
    @ResponseBody
    public TranslatorModel GetTranslatorInfo(@RequestParam(value = "id", required = false) String interId) {
    	return translatorService.getTranslatorById(interId);
    }

    @RequestMapping(value = "/queryInterpreters", method = RequestMethod.GET)
    @ResponseBody
    public List<TranslatorModel> QueryTranslators(@RequestParam(value = "language", required = false) String language) {
        return translatorService.getTranslatorsByCondition(language);
    }
}
