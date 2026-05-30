class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            int x = 0, y = image[0].length - 1;

            while(x <= y){
                int temp = image[i][x] == 1 ? 0: 1;
                image[i][x] = image[i][y] == 1? 0: 1;
                image[i][y] = temp;
                x++;y--;
            }
        }

        return image;
    }
}