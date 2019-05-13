import java.util.Arrays;

public class RectangleArea {
    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        // No overlap
        if (H <= B || D <= F || E >= C || A >= G)
            return area1 + area2;
        // include
        if (E <= A && F <= B && G >= C && H >= D || E >= A && F >= B && G <= C && H <= D)
            return Math.max(area1, area2);
        // not include, but overlap
        int[] x = new int[4], y = new int[4];
        x[0] = A;
        x[1] = C;
        x[2] = E;
        x[3] = G;
        y[0] = B;
        y[1] = D;
        y[2] = F;
        y[3] = H;
        Arrays.sort(x);
        Arrays.sort(y);
        return area1 + area2 - (x[2] - x[1]) * (y[2] - y[1]);
    }

    // Best method
    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs((D-B)*(C-A));
        int area2 = Math.abs((G-E)*(H-F));
        int repeat_h = Math.max(B,F)>Math.min(D,H) ? 0 : Math.min(D,H)-Math.max(B, F);
        int repeat_w = Math.max(A,E)>Math.min(C,G) ? 0 : Math.min(C,G)-Math.max(A, E);
        return area1+area2-(repeat_h*repeat_w);
    }
}
