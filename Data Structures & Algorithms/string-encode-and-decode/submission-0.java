class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(String str : strs ) {
            sb
            .append(str.length())
            .append("#")
            .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList();
        int i = 0; 
        while (i < str.length()) {
            int j = str.indexOf("#", i);
            int length = Integer.parseInt(str.substring(i, j));
            String decoded = str.substring(j + 1, j + length + 1);
            result.add(decoded);
            i = j + length + 1;
        }
        return result;
    }
}
