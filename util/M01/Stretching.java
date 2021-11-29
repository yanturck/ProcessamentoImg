package util.M01;

import util.Imagem;

public class Stretching {
    public static final int LINEAR = 1;
    public static final int RAIZQUADRADA = 2;
    public static final int QUADRADO = 3;
    public static final int LOGARITMICA = 4;
    public static final int EXPONENCIAL = 5;
    public static final int NEGATIVO = 6;

    public static Imagem minMax (int [][][]matIn) {
        int nCanais = matIn.length;
        int alt = matIn[0].length;
        int larg = matIn[0][0].length;
        int matOut[][][] = new int[nCanais][alt][larg];
        int min, max;

        for (int c = 0; c < nCanais; c++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    if (matIn[c][y][x] < min) min = matIn[c][y][x];
                    if (matIn[c][y][x] > max) max = matIn[c][y][x];
                }
            }

            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    if ((max-min) != 0) matOut[c][y][x] = (int)((matIn[c][y][x]-min)*255)/(max-min);
                    else matOut[c][y][x] = (int)((matIn[c][y][x]-min)*255);
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem linear (Imagem img, float a, float b, boolean minMax) {
        int nCanais = img.getNCanais();
        int alt = img.getAltura();
        int larg = img.getLargura();
        int matIn[][][] = img.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int cor;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = (int)(a*matIn[c][y][x]+b);
                    matOut[c][y][x] = cor;
                }
            }
        }
        if (minMax) return minMax(matOut);
        else return new Imagem(matOut);
    }

    public static Imagem raizQuadrada (Imagem img, float a, boolean minMax) {
        int nCanais = img.getNCanais();
        int alt = img.getAltura();
        int larg = img.getLargura();
        int matIn[][][] = img.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int cor;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = (int)(a*Math.sqrt(matIn[c][y][x]));
                    matOut[c][y][x] = cor;
                }
            }
        }
        if (minMax) return minMax(matOut);
        else return new Imagem(matOut);
    }

    public static Imagem quadrado (Imagem img, float a, boolean minMax) {
        int nCanais = img.getNCanais();
        int alt = img.getAltura();
        int larg = img.getLargura();
        int matIn[][][] = img.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int cor;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = (int)(a*matIn[c][y][x]*matIn[c][y][x]);
                    matOut[c][y][x] = cor;
                }
            }
        }
        if (minMax) return minMax(matOut);
        else return new Imagem(matOut);
    }

    public static Imagem logaritmica (Imagem img, float a, boolean minMax) {
        int nCanais = img.getNCanais();
        int alt = img.getAltura();
        int larg = img.getLargura();
        int matIn[][][] = img.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int cor;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = (int)(a*Math.log(matIn[c][y][x]+1));
                    matOut[c][y][x] = cor;
                }
            }
        }
        if (minMax) return minMax(matOut);
        else return new Imagem(matOut);
    }

    public static Imagem exponencial (Imagem img, float a, float b, boolean minMax) {
        int nCanais = img.getNCanais();
        int alt = img.getAltura();
        int larg = img.getLargura();
        int matIn[][][] = img.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int cor;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = (int)(a*Math.pow(b, matIn[c][y][x]));
                    matOut[c][y][x] = cor;
                }
            }
        }
        if (minMax) return minMax(matOut);
        else return new Imagem(matOut);
    }

    public static Imagem negativo (Imagem img, float a, float b, boolean minMax) {
        int nCanais = img.getNCanais();
        int alt = img.getAltura();
        int larg = img.getLargura();
        int matIn[][][] = img.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int cor;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = (int)(-(a*matIn[c][y][x] + b));
                    matOut[c][y][x] = cor;
                }
            }
        }
        if (minMax) return minMax(matOut);
        else return new Imagem(matOut);
    }

    public static Imagem porFatias (Imagem img, int [][]fatias, boolean minMax) {
        int nCanais = img.getNCanais();
        int alt = img.getAltura();
        int larg = img.getLargura();
        int matIn[][][] = img.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int qntFatias = fatias.length;
        int cor;

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = matIn[c][y][x];
                    for (int i = 0; i < qntFatias; i++) {
                        if (cor >= fatias[i][0] && cor <= fatias[i][1]) {
                            switch (fatias[i][2]) {
                                case LINEAR:
                                    cor = (int)(2.0*matIn[c][y][x]-10);
                                    matOut[c][y][x] = cor;
                                    break;
                                case RAIZQUADRADA:
                                    cor = (int)(2.0*Math.sqrt(matIn[c][y][x]));
                                    matOut[c][y][x] = cor;
                                    break;
                                case QUADRADO:
                                    cor = (int)(2.0*matIn[c][y][x]*matIn[c][y][x]);
                                    matOut[c][y][x] = cor;
                                    break;
                                case LOGARITMICA:
                                    cor = (int)(2.0*Math.log(matIn[c][y][x]+1));
                                    matOut[c][y][x] = cor;
                                    break;
                                case EXPONENCIAL:
                                    cor = (int)(2.0*Math.pow(0.1, matIn[c][y][x]));
                                    matOut[c][y][x] = cor;
                                    break;
                                case NEGATIVO:
                                    cor = (int)(-(2.0*matIn[c][y][x] + 1.0));
                                    matOut[c][y][x] = cor;
                                    break;
                            }
                        }
                    }
                }
            }
        }
        if (minMax) return minMax(matOut);
        else return new Imagem(matOut);
    }
}
