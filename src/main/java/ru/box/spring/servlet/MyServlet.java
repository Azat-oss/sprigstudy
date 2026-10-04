package ru.box.spring.servlet;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("/api/servlet")
public class MyServlet {

    @PostMapping("/maximum") //http://localhost:8080/api/servlet/maximum?num1=5&num2=12&num3=3
    public Map<String, Object> processForm(
            @RequestParam("num1") Double n1,
            @RequestParam("num2") Double n2,
            @RequestParam("num3") Double n3) {

        if (n1 == null || n2 == null || n3 == null) {
            return Map.of("error", "Все три числа (num1, num2, num3) обязательны");
        }


        double max = Math.max(n1, Math.max(n2, n3));
        return Map.of(
                "n1", n1,
                "n2", n2,
                "n3", n3,
                "max", max
        );
    }


}
