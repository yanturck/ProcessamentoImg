package util.M02;

import util.Imagem;


public class MoforlogiaBin {
    public Imagem erosao (Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[1][alt][larg];
        int r = (ee.length-1)/2;
        boolean iguais;

        for (int y = r; y < alt-r; y++) {
            for (int x = r; x < larg-r; x++) {
                iguais = true;
                for (int dy = -r; dy <= r && iguais; dy++) {
                    for (int dx = -r; dx <= r && iguais; dx++) {
                        if (matIn[0][y+dy][x+dx] != ee[r+dy][r+dx]) {
                            iguais = false;
                        }
                    }
                }
                matOut[0][x][y]=iguais?255:0;
            }
        }
        return new Imagem(matOut);
    }
}
