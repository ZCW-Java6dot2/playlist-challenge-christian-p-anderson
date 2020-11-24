package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(this.playList));

        String startSong = arrayList.get(startIndex);

        Integer fwdDistance = Integer.MAX_VALUE;
        Integer revDistance = Integer.MIN_VALUE;

//        move forwards
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if ((startSong.equals(playList[i]) && selection.equals(playList[j]) || selection.equals(playList[i]) && startSong.equals(playList[j]))
                        && fwdDistance > Math.abs(i - j)) {
                    fwdDistance = Math.abs(i - j);
                }

            }
        }

//        move backwards

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((startSong.equals(playList[i]) && selection.equals(playList[j]) || selection.equals(playList[i]) && startSong.equals(playList[j]))
                        && revDistance < Math.abs(i - j)) {
                    revDistance = Math.abs(i - j);
                }

            }
        }

        if (fwdDistance < revDistance) {
            return fwdDistance;
        } else if (fwdDistance.equals(revDistance)){
            return fwdDistance;
        } else {
            return revDistance;
        }
    }
}
