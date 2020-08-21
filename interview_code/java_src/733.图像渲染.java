class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) return null;
        int originColor = image[sr][sc];
        fill_image(image, sr, sc, originColor, newColor);
        return image;
    }
    private void fill_image(int[][] image, int x, int y, int originColor, int newColor) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) return;
        if (image[x][y] != originColor || image[x][y] == newColor) return;
        image[x][y] = newColor;
        fill_image(image, x, y + 1, originColor, newColor);
        fill_image(image, x, y - 1, originColor, newColor);
        fill_image(image, x - 1, y, originColor, newColor);
        fill_image(image, x + 1, y, originColor, newColor);
    }
}