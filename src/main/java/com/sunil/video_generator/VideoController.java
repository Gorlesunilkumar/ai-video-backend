package com.sunil.video_generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class VideoController {

    @Autowired
    private PexelsVideoService pexelsVideoService;

    @PostMapping("/generate-video")
    public ResponseEntity<Map<String, Object>> generateVideo(@RequestBody VideoRequest request) {

        String videoUrl = pexelsVideoService.getVideo(request.getText());

        Map<String, Object> response = new HashMap<>();
        response.put("videoUrl", videoUrl);

        return ResponseEntity.ok(response);
    }
}