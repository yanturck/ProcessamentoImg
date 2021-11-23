package util;

public class OperacoesAritmeticas {
    public static Imagem adicao( Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int corSoma;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corSoma = matA[c][y][x]+matB[c][y][x];
                    if(corSoma > 255) corSoma = 255;
                    matOut[c][y][x] = corSoma;
                }
            }
        }
        return new Imagem(matOut);
    }
    
    public static Imagem subtracao (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int corSub;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corSub = matA[c][y][x]-matB[c][y][x];
                    if(corSub < 0) corSub = 0;
                    matOut[c][y][x] = corSub;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem multiplicacao (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int corMult;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corMult = matA[c][y][x]*matB[c][y][x];
                    if(corMult > 255) corMult = 255;
                    matOut[c][y][x] = corMult;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem divisao (Imagem imgA, Imagem imgB) {
        int matA[][][] = imgA.getMatriz();
        int matB[][][] = imgB.getMatriz();
        int qntCanais = imgA.getNCanais(); //rgb ou gray
        int alt = imgA.getAltura();
        int larg = imgA.getLargura();
        int corDiv;
        int matOut[][][] = new int[qntCanais][alt][larg];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corDiv = matA[c][y][x]/matB[c][y][x];
                    if(corDiv < 0) corDiv = 0;
                    matOut[c][y][x] = corDiv;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem media (Imagem[]in) {
        int qntCanais = in[0].getNCanais(); //rgb ou gray
        int alt = in[0].getAltura();
        int larg = in[0].getLargura();
        int corSoma, quantImg = in.length;
        int matOut[][][] = new int[qntCanais][alt][larg];
        int auxMat[][][];

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    corSoma = 0;
                    for (int i = 0; i < quantImg; i++) {
                        auxMat = in[i].getMatriz();
                        corSoma += auxMat[c][y][x];
                    }
                    matOut[c][y][x] = (int)(corSoma/quantImg);
                    // System.out.println("Chegou!");
                }
            }
        }
        return new Imagem(matOut);
    }    
}
