package Kuba;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int xa=-6;
        final int ya=0;
        final int xb=0;
        final int xc=6;
        final int yc=0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj współrzędną X punktu P:");
        int xp = scanner.nextInt();
        System.out.println("Podaj współrzędną Y punktu P:");
        int yp = scanner.nextInt();
        System.out.println("Podaj współrzędną Y wierzchołka B:");
        int yb = scanner.nextInt();

        boolean menu = true;

        while(menu) {
        System.out.println("1. Pole trójkąta.");
        System.out.println("2. Suma boków trójkąta.");
        System.out.println("3. Odległość punktu P od wierzchołka B.");
        System.out.println("4. Sprawdzenie czy punkt P należy do trójkąta ABC.");
        System.out.println("0. Wyjście z programu.");

        int choose= scanner.nextInt();

        switch (choose){
            case 1 ->System.out.println(poleTrojkata(xa,ya,xb,yb,xc,yc));
            case 2 ->System.out.println(sumaBokowTrojkata(xa,ya,xb,yb,xc,yc));
            case 3 ->System.out.println(odlegloscMiedzyPunktami(xb, yb, xp, yp));
            case 4 -> {
                if(czyNalezyDoTrojkata(xa, ya,  xb, yb, xc, yc, xp, yp)){
                    System.out.println("Punkt P należy do trójkąta ABC."); }
                else System.out.println("Punkt P nie należy do trójkąta ABC.");
            }
            case 0 ->menu=false;
        }
        }
    }
    static double poleTrojkata(int xa,int ya, int xb, int yb, int xc, int yc){
        double pole = (xb-xa)*(yc-ya)-(yb-ya)*(xc-xa) ;
        return Math.abs(pole)/2 ;
    }
    static double odlegloscMiedzyPunktami(int xb, int yb, int xp, int yp){
        return Math.sqrt(Math.pow(xb-xp, 2) + Math.pow(yb-yp,2)) ;
    }
    static double sumaBokowTrojkata(int xa,int ya, int xb, int yb, int xc, int yc){
        return Math.sqrt(Math.pow(xa-xb, 2) + Math.pow(ya-yb,2)) + Math.sqrt(Math.pow(xb-xc, 2) + Math.pow(yb-yc,2)) + Math.sqrt(Math.pow(xc-xa, 2) + Math.pow(yc-ya,2));
    }
    static double area(int xa, int ya, int xb, int yb, int xc, int yc)
    {
        return Math.abs((xa*(yb-yc) + xb*(yc-ya)+
                xc*(ya-yb))/2.0);
    }
    static boolean czyNalezyDoTrojkata(int xa,int ya, int xb, int yb, int xc, int yc, int xp, int yp){
        double A = area(xa, ya, xb, yb, xc, yc);
        double A1 = area(xp, yp, xb, yb, xc, yc);
        double A2 = area(xa, ya, xp, yp, xc, yc);
        double A3 = area(xa, ya, xb, yb, xp, yp);
        return (A==A1+A2+A3);
    }
}
