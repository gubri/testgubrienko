package com.selsup.testgubrienko;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/api/v3/lk/documents")
public class API {
    private final CrptApi crptApi = new CrptApi(TimeUnit.SEC, 3);
    private Integer count = 0;
    private final Map<TimeUnit, Long> times = Map.of(TimeUnit.SEC, 1L, TimeUnit.MIN, 60L, TimeUnit.HOUR, 3600L);

    @ResponseBody
    @PostMapping(value = "/create")
    public ResponseEntity<DocMessage> createDoc(@RequestBody DocMessage docMessage,
                                                HttpServletRequest request) throws InterruptedException {
        if (count < crptApi.getRequestLimit())
            count++;
        else {
            Thread.sleep(times.get(crptApi.timeUnit) * 1000);
            count--;
        }
        return ResponseEntity.ok().body(docMessage);
    }

    @Data
    public class CrptApi {

        private final TimeUnit timeUnit;
        private final Integer requestLimit;

        public CrptApi(TimeUnit timeUnit, Integer requestLimit) {
            if (requestLimit <= 0)
                throw new IllegalArgumentException("requestLimit not more than zero");
            this.timeUnit = timeUnit;
            this.requestLimit = requestLimit;
        }
    }

    enum TimeUnit {
        SEC, MIN, HOUR
    }
}
