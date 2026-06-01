class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < s.length()){
            char c = s.charAt(i);

            if(c == ' '){
                list.add(sb.toString());
                sb.setLength(0);

                while(i < s.length() && s.charAt(i) == ' '){
                    i++;
                }
            }else{
              sb.append(c);
              i++;  
            } 
        }


        list.add(sb.toString());

        sb.setLength(0);
        for(i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i));
            if(i != 0){
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}