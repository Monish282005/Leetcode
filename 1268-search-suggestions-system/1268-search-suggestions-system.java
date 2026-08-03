class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int n = searchWord.length();

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            for (String s : products) {
                if(s.length() < i + 1)
                    continue;
                String sub = s.substring(0, i + 1);

                if (sub.equals(searchWord.substring(0, i + 1)) && temp.size() < 3) {
                    temp.add(s);
                }
            }
            
            res.add(new ArrayList<>(temp));
        }

        return res;
    }
}