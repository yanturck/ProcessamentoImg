package util;

public class EqHistograma {
    public static Imagem equalizacaoHistograma (Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();

        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        
        int hist[][] = new int[256][nCanais]; // Histograma
        int histAC[][] = new int[256][nCanais]; // Histograma Acumulado
        int T[][] = new int[256][nCanais]; // Transformacao do Acumulado

        // Calculando o Histograma
        for (int coutC = 0; coutC < nCanais; coutC++) {
            for (int coutY = 0; coutY < alt; coutY++) {
                for (int coutX = 0; coutX < larg; coutX++) {
                    hist[matIn[coutC][coutY][coutX]][coutC]++;
                }
            }
        }

        // Calculando o Histograma Acumulado
        for (int c = 0; c < nCanais; c++) {
            histAC[0][c] = hist[0][c];
            for (int i = 1; i < hist.length; i++) {
                histAC[i][c] = hist[i][c] + histAC[i-1][c];
            }
        }

        // Calculando a Transformação para o Histograma Acumulado
        for (int c = 0; c < nCanais; c++) {
            for (int j = 0; j < histAC.length; j++) {
                T[j][c] = (int)((255*histAC[j][c])/(alt*larg));
            }
        }

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    matOut[c][y][x] = T[matIn[c][y][x]][c];
                }
            }
        }
        return new Imagem(matOut);
    }
}
