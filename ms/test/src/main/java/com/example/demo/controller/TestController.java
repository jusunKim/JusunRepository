package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hospital;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TestController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/hospital")
    public void getHospitals(Model model,
    						 @RequestParam(required = false) String search,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/hospital.json");

       System.out.println(search);
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON 파일을 읽어 List<Hospital>로 변환
        List<Hospital> hospitals = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Hospital>>() {});
        hospitals = hospitals.stream()
                .filter(hospital -> "동물병원".equals(hospital.getCtgry_THREE_NM()))
                .collect(Collectors.toList());
        
        if(search!=null) {
        	hospitals = hospitals.stream()
        			.filter(hospital -> search.equals(hospital.getCtprvn_NM()))
        			.collect(Collectors.toList());
        }
        
        int startIndex = page * size;
        int endIndex = Math.min(startIndex + size, hospitals.size());

        // 페이지에 해당하는 데이터만 추출
        List<Hospital> hospitalsPerPage = hospitals.subList(startIndex, endIndex);

        System.out.println(hospitalsPerPage.get(0));
        model.addAttribute("list", hospitalsPerPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) hospitals.size() / size));
    }

}
