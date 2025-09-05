package com.example.demo.Controller;

import com.example.demo.Domain.Common.Dto.MemoDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

//    @ExceptionHandler(Exception.class)
//    public String exception_handler(Exception e){
//        log.error("MemoController's Exception..." + e);
//        return "memo/error";
//    }



    @InitBinder
    public void dataBinder(WebDataBinder webDataBinder) throws Exception
    {
        log.info("MemoController's dataBinder...."+webDataBinder);
        webDataBinder.registerCustomEditor(LocalDate.class,"data_test", new DataTestEditor() );
    }

    private static class DataTestEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            log.info("DataTestEditor's setAsText text : " + text);
            LocalDate date =null;
            if(text.isEmpty()){
                date = LocalDate.now();
            }else{
                //format 확인(yyyy#MM#dd)
                text = text.replaceAll("#","-");
                date = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            setValue(date);
        }
    }


    @GetMapping("/add")
    public void add_memo_get() throws Exception
    {
        log.info("GET /memo/add...");
    }
    @PostMapping("/add")
    public void add_memo_post(@Valid MemoDto dto, BindingResult bindingResult, Model model) throws Exception
    {
        log.info("POST /memo/add..." + dto);
        //파라미터
        //입력값검증(데이터)
        log.info("유효성 오류 발생여부 : " + bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            for(FieldError error  : bindingResult.getFieldErrors()){
                log.info("Error Field : "+error.getField()+" Error Message : "+error.getDefaultMessage());
                model.addAttribute(error.getField(),error.getDefaultMessage());
            }

            throw new Exception("유효성 검증 오류!");
        }

        //서비스 요청 -> Domain.Common.Service
        //뷰로 이동
    }

}