package org.zerock.ex2.controller;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.ex2.dto.SampleDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    // get
    @GetMapping({"/ex01", "/ex02"})
    public String ex01() {
        return "ex01";
    }

    @GetMapping("/ex03")
    public void ex03(
        @RequestParam(value = "name", required = false, defaultValue = "im") String name,
        @RequestParam("age") int age )
    {
        log.info("name : {}, age : {}",  name, age);



    }
    @GetMapping("/member/{id}/exist")
    public void ex04(@PathVariable("id") String id) {
        log.info("member id : {}", id);
    }

    // localhost:8080/ex05?
    @PostMapping("/ex05")
    public void ex05(@RequestBody SampleDTO dto) {
        log.info("..........ex05: {}", dto);
    }

    @GetMapping("/lost")
    public List<SampleDTO> ex06() {
//        List<SampleDTO> list = new ArrayList<>();
//        IntStream.rangeClosed(1, 20).forEach(i -> {
//            SampleDTO dto = SampleDTO.builder()
//                    .name("Test" + i)
//                    .age(20 + i)
//                    .build();
//            list.add(dto);
//        });
        List<SampleDTO> list = IntStream.rangeClosed(1, 20)
                .mapToObj(i -> SampleDTO.builder()
                        .name("Test" + i)
                    .age(20 + i)
                    .build()).collect(Collectors.toList());

        return list;
    }


}
