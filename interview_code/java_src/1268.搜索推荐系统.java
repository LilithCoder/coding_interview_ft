class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            List<String> collector = new LinkedList<>();
            for (String product: products) {
                if (product.startsWith(prefix)) {
                    collector.add(product);
                    if (collector.size() == 3) {
                        break;
                    }
                }
            }
            res.add(collector);
        }
        return res;
    }
}