package com.sunil.video_generator;

public class VideoResponse {

    private String script;
    private String voice;
    private String video;

    public VideoResponse(String script, String voice, String video) {
        this.script = script;
        this.voice = voice;
        this.video = video;
    }

    public String getScript() {
        return script;
    }

    public String getVoice() {
        return voice;
    }

    public String getVideo() {
        return video;
    }
}