package heap;
//堆：TreeMap、TreeSet、优先队列

import java.util.*;

/*451. 根据字符出现频率排序
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。(大小写敏感)
输入:
"tree"
输出:
"eert"
解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class Solution451 {
//    public String frequencySort(String s) {
//         int[] letters = new int[128];
//         for (char c : s.toCharArray()) {
//             letters[c]++;
//         }
//         PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
//         StringBuilder res = new StringBuilder();
//
//         for (int i = 0; i < letters.length; ++i) {
//             if (letters[i] != 0) heap.offer((char)i);
//         }
//
//         while (!heap.isEmpty()) {
//             char c = heap.poll();
//             while (letters[c]-- > 0)
//                 res.append(c);
//         }
//         return res.toString();
//    }




//    public String frequencySort(String s) {
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        List<Character> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(s.charAt(i));
//        }
//        list.sort(new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                int count1=hashMap.get(o1);
//                int count2=hashMap.get(o2);
//                if (count1==count2) return o2-o1;
//                else return count2-count1;
//            }
//        });
//
//        StringBuilder builder = new StringBuilder();
//        for (Character character : list) {
//            builder.append(character);
//        }
//        return builder.toString();
//    }




    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

         //优先队列其实就是在每个元素加入队列的时候，就按照顺序进行摆放
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int count1=hashMap.get(o1);
                int count2=hashMap.get(o2);
                if (count1==count2) return o2-o1;
                else return count2-count1;
            }
        });
        for (int i = 0; i < n; i++) {
            queue.offer(s.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s="loveleetcode";
        System.out.println(new Solution451().frequencySort(s));
    }
}
