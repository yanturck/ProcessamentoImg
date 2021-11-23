package util;

// RGB <--> CMY
// RGB <--> HSI
// RGB <--> YUV

public class MudancaSCores {
    public static Imagem rgbCMY(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[3][alt][larg];

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                matOut[0][y][x] = 255 - matIn[0][y][x];
                matOut[1][y][x] = 255 - matIn[1][y][x];
                matOut[2][y][x] = 255 - matIn[2][y][x];
            }
        }

        return new Imagem(matOut);
    }

    public static Imagem cmyRGB(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[3][alt][larg];

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                matOut[0][y][x] = 255 - matIn[0][y][x];
                matOut[1][y][x] = 255 - matIn[1][y][x];
                matOut[2][y][x] = 255 - matIn[2][y][x];
            }
        }

        return new Imagem(matOut);
    }

    public static Imagem rgbHSI(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[3][alt][larg];
        int R, G, B;
        double auxDiv, auxDiv2;

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                R = matIn[0][y][x];
                G = matIn[1][y][x];
                B = matIn[2][y][x];

                matOut[2][y][x] = (int)((R + G + B)/3);

                auxDiv2 = R + G + B;
                if (auxDiv2 == 0) matOut[1][y][x] = 1;
                else matOut[1][y][x] = (int)(1 - (3/(auxDiv2))*Math.min(R, Math.min(G, B)));

                auxDiv = Math.sqrt(((R-G)*(R-G))+((R-B)*(G-B)));
                if (auxDiv == 0) matOut[0][y][x] = (int)(Math.acos(0));
                else matOut[0][y][x] = (int)(Math.acos((0.5*((R-G)+(R-B)))/(auxDiv)));
            }
        }
        // return Stretching.minMax(matOut);
        return new Imagem(matOut);
    }

    public static Imagem hsiRGB(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[3][alt][larg];
        int H, S, r, b;

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                H = matIn[0][y][x];
                S = matIn[1][y][x];

                r = matOut[0][y][x] = (int)((1/3)*(1+(S*Math.cos(H)/Math.cos((Math.PI/3)-H))));
                b = matOut[2][y][x] = (int)((1/3)*(1-S));
                matOut[1][y][x] = (int)(1-(r+b));
            }
        }
        // return Stretching.minMax(matOut);
        return new Imagem(matOut);
    }

    public static Imagem rgbYUV(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[3][alt][larg];
        int R, G, B;
        double Y;

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                R = matIn[0][y][x];
                G = matIn[1][y][x];
                B = matIn[2][y][x];

                Y = (0.299*R) + (0.587*G) + (0.114*B);
                matOut[0][y][x] = (int)(Y);
                matOut[1][y][x] = (int)(B - Y);
                matOut[2][y][x] = (int)(R - Y);
            }
        }
        return Stretching.minMax(matOut);
        // return new Imagem(matOut);
    }

    public static Imagem yuvRGB(Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[3][alt][larg];
        int Y, U, V;

        for (int y = 0; y < alt; y++) {
            for (int x = 0; x < larg; x++) {
                Y = matIn[0][y][x];
                U = matIn[1][y][x];
                V = matIn[2][y][x];

                matOut[0][y][x] = V + Y;
                matOut[1][y][x] = (int)((0.587*Y + 0.299*V + 0.114*U)/0.587);
                matOut[2][y][x] = U + Y;
            }
        }
        return Stretching.minMax(matOut);
        // return new Imagem(matOut);
    }
}
