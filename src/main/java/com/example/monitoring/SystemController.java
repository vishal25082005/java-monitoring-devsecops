package com.example.monitoring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SystemController {

    @GetMapping("/api/metrics")
    public Map<String, Object> metrics() {
        Map<String, Object> data = new HashMap<>();
        Runtime rt = Runtime.getRuntime();

        data.put("processors", rt.availableProcessors());
        data.put("freeMemoryMB", rt.freeMemory() / (1024 * 1024));
        data.put("totalMemoryMB", rt.totalMemory() / (1024 * 1024));
        data.put("os", ManagementFactory.getOperatingSystemMXBean().getName());

        return data;
    }
}

