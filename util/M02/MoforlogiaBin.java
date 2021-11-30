package util.M02;

import util.Imagem;


public class MoforlogiaBin {
    public Imagem erosao(Imagem in, int ee[][]) {
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
                        if (matIn[0][y+dy][x+dx] != ee[r+dy][r+dx]) iguais = false;
                    }
                }
                matOut[0][y][x]=iguais?255:0;
            }
        }
        return new Imagem(matOut);
    }

    public Imagem dilatacao(Imagem in, int ee[][]) {
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
                        if (matIn[0][y+dy][x+dx] == ee[r+dy][r+dx]) iguais = false;
                    }
                }
                matOut[0][y][x]=!iguais?255:0;
            }
        }
        return new Imagem(matOut);
    }

    public Imagem bordaInterna(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int imgErodida [][][] = erosao(in, ee).getMatriz();
        int matOut[][][] = new int[1][alt][larg];

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                matOut[0][y][x] = matIn[0][y][x] - imgErodida[0][y][x];
            }
        }
        return new Imagem(matOut);
    }

    public Imagem bordaExterna(Imagem in, int ee[][]) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int imgDilatada [][][] = dilatacao(in, ee).getMatriz();
        int matOut[][][] = new int[1][alt][larg];

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                matOut[0][y][x] = imgDilatada[0][y][x] - matIn[0][y][x];
            }
        }
        return new Imagem(matOut);
    }

    public Imagem abertura(Imagem in, int ee[][]) {
        Imagem imgErodida = erosao(in, ee);
        int matOut[][][] = dilatacao(imgErodida, ee).getMatriz();

        return new Imagem(matOut);
    }

    public Imagem fechamento(Imagem in, int ee[][]) {
        Imagem imgDilatada = dilatacao(in, ee);
        int matOut[][][] = erosao(imgDilatada, ee).getMatriz();

        return new Imagem(matOut);
    }

    public Imagem esqueleto(Imagem in, int ee[][], int k) {
        Imagem imgErodida = in;
        while (k != 0) {
            imgErodida = erosao(imgErodida, ee);
            k--;
        }

        int matOut[][][] = fechamento(imgErodida, ee).getMatriz();

        return new Imagem(matOut);
    }
}
