package org.techstuff;

import java.util.*;

/**
 * Created by andersonkmi on 8/7/2016.
 */
public class RansomNote {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        Map<String, Integer> magazineWords = new HashMap<>();
        for(String word : magazine) {
            if(magazineWords.containsKey(word)) {
                Integer count = magazineWords.get(word);
                count++;
                magazineWords.put(word, count);
            } else {
                magazineWords.put(word, 1);
            }
        }

        Map<String, Integer> ransomWords = new HashMap<>();
        for(String word : ransom) {
            if(ransomWords.containsKey(word)) {
                Integer count = ransomWords.get(word);
                count++;
                ransomWords.put(word, count);
            } else {
                ransomWords.put(word, 1);
            }
        }

        boolean foundAll = true;
        Set<String> keys = ransomWords.keySet();
        for(String key : keys) {
            if(magazineWords.containsKey(key)) {
                Integer neededQuantity = ransomWords.get(key);
                Integer existingQuantity = magazineWords.get(key);
                if(existingQuantity < neededQuantity) {
                    foundAll = false;
                    break;
                }
            } else {
                foundAll = false;
                break;
            }
        }

        if(foundAll) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
