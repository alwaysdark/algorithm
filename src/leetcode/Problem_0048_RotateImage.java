package leetcode;

public class Problem_0048_RotateImage {

    /**
     * 整体是个矩阵，可以分层考虑，每圈是单独一层，
     * 左上角点和右下角点可以唯一确认一个圈，一圈结束左上角点往右下方，右下角点往左上方，唯一确认下一个圈
     * 每一个圈可以分组，组数是dR-tR
     *
     * */
    public void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length -1;
        while (tR < dR){
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC){
        for(int i=0; i < dC - tC; i++){
            int tmp = m[tR][tC+i];
            m[tR][tC+i] = m[dR-i][tC];
            m[dR-i][tC] = m[dR][dC-i];
            m[dR][dC-i] = m[tR+i][dC];
            m[tR+i][dC] = tmp;
        }
    }
}
