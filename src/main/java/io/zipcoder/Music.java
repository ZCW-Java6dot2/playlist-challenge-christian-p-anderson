package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        ArrayList<String> songList = new ArrayList<String>(Arrays.asList(this.playList));

        Integer forwardCount = Math.abs(songList.indexOf(selection) - startIndex);
        Integer reverseCount = Math.abs((songList.size() + startIndex) - songList.lastIndexOf(selection));
        return Math.min(forwardCount, reverseCount);
    }
}
