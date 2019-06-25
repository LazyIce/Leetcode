public class _223_RectangleArea {
    /**
     * time: O(1)
     * space: O(1)
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs((C - A) * (D - B));
        int area2 = Math.abs((G - E) * (H - F));
        int repeatWidth = Math.max(A, E) > Math.min(C, G) ? 0 : Math.min(C, G) - Math.max(A, E);
        int repeatHeight = Math.max(B, F) > Math.min(D, H) ? 0 : Math.min(D, H) - Math.max(B, F);
        return area1 + area2 - (repeatWidth * repeatHeight);
    }
}
