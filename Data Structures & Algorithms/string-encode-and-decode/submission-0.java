public class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find the delimiter separating length from string content
            int slashIndex = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, slashIndex));
            
            // The content starts right after '#'
            int start = slashIndex + 1;
            int end = start + len;
            
            result.add(str.substring(start, end));
            
            // Move pointer to the start of the next segment
            i = end;
        }

        return result;
    }
}