package util;

public class OperacoesLogicas {
    public static Imagem not (Imagem imgA) {
        int matA[][][] = imgA.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = matA[c][y][x];
                    cor=cor==0?255:0;
                    matOut[c][y][x] = cor;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem or (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor, corA, corB;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corA = matA[c][y][x];
                    corB = matB[c][y][x];
                    
                    if (corA == 0 && corB == 0) cor = 0;
                    else cor = 255;
                        

                    matOut[c][y][x] = cor;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem and (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor, corA, corB;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corA = matA[c][y][x];
                    corB = matB[c][y][x];

                    if (corA == 255 && corB == 255) cor = 255;
                    else cor = 0;
                    
                    matOut[c][y][x] = cor;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem xor (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor, corA, corB;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corA = matA[c][y][x];
                    corB = matB[c][y][x];

                    if (corA != corB) cor = 255;
                    else cor = 0;
                    
                    matOut[c][y][x] = cor;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem sub (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int cor, corA, corB;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corA = matA[c][y][x];
                    corB = matB[c][y][x];

                    if (corA == 255 && corB == 0) cor = 255;
                    else cor = 0;
                    
                    matOut[c][y][x] = cor;
                }
            }
        }
        return new Imagem(matOut);
    }
}
