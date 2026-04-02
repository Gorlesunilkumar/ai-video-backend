package com.sunil.video_generator;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class PexelsVideoService {

    private final String API_KEY = "FdUVFcWxdmG9vcDwP6hCYCK4zwUosOEyQ0rQ7Wyek4EqXRN69JtdbJR0"; // 🔥 put your key

    public String getVideo(String query) {

        try {
            String url = "https://api.pexels.com/videos/search?query=" + query + "&per_page=3";

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", API_KEY);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Map.class
            );

            List videos = (List) response.getBody().get("videos");

            if (videos == null || videos.isEmpty()) {
                return null;
            }

            Map video = (Map) videos.get(0);
            List files = (List) video.get("video_files");

            // 🔥 IMPORTANT: choose LOW QUALITY video (fix memory issue)
            for (Object obj : files) {
                Map file = (Map) obj;

                int width = (int) file.get("width");

                if (width <= 640) {
                    System.out.println("✅ Using low quality video");
                    return (String) file.get("link");
                }
            }

            // fallback
            Map file = (Map) files.get(0);
            return (String) file.get("link");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}