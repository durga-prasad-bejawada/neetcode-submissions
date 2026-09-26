class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {  

        HashMap<String, List<String>> map= new HashMap<>();
        

        for(String word : strs){

            int fr[]= new int [26];
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                fr[ch-'a']++;
            }
            StringBuilder st = new StringBuilder();
            for(int i='a';i<='z';i++){
                st.append(i);
                st.append(fr[i-'a']);
            }

            String s = new String(st);

            List<String> list = map.getOrDefault(s,new ArrayList<>());
            list.add(word);
            map.put(s,list);

        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> value: map.values()){
            ans.add(value);
        }
        return ans;


    }
}
