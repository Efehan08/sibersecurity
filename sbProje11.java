import java.util.Random;
import java.util.Scanner;

class sbProje11 {
    public static void main(String[] args) {
        int[] riskPuanlari = new int[10];
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        for(int i = 0; i < riskPuanlari.length; i++){
            riskPuanlari[i] = rand.nextInt(100);
            System.out.println(i + ". Dosya Risk Puanı: "+ riskPuanlari[i]);
        }
        boolean devam = true;
        while(devam){
            System.out.println("\n1- Sistemi Tara");
            System.out.println("2- Tehdit Analizi Yap");
            System.out.println("3- Otomatik Dosya Temizle");
            System.out.println("4- Manuel Dosya Temizle");
            System.out.println("5- Çıkış");
            System.out.print("Seçiminiz: ");

            int secim  = input.nextInt();

            switch(secim){
                case 1:
                    sistemiListele(riskPuanlari);
                    break;
                case 2:
                    System.out.println("\nTehdit İçeren Dosya Sayısı: " + tehditSayisi(riskPuanlari));
                    break;
                case 3:
                    System.out.println("\nTEMİZLEME BAŞLATILIYOR");
                    otomatikTemizle(riskPuanlari);
                    sistemiListele(riskPuanlari);
                    break;
                case 4:
                    System.out.println("Silinecek Dosyayı Seçiniz (0-9)?");
                    int silinecekDosya = input.nextInt();

                    manuelTemizle(riskPuanlari, silinecekDosya);
                    System.out.println(silinecekDosya + ". Dosya Temizlendi");
                    sistemiListele(riskPuanlari);
                    break;
                case 5:
                    System.out.println("\nSistem Kapatılıyor.");
                    devam = false;
                    break;
                default:
                    System.out.println("Geçersiz Seçim!");
            }
        }
    }
    public static void sistemiListele(int [] gelenDizi){
        System.out.println("\n");
        for(int i = 0; i < gelenDizi.length; i++){
            System.out.println(i + ". Dosya Risk Puanı: " + gelenDizi[i]);
        }
    }
    public static int tehditSayisi(int [] gelenDizi){
        int sayac = 0;
        for(int i = 0; i < gelenDizi.length; i++){
            if(gelenDizi[i] > 80){
                sayac++;
            }
        }
        return sayac;
    }
    public static void manuelTemizle(int [] gelenDizi, int hedefIndex){
        int sayac = 0;
        for (int i = 0; i < gelenDizi.length; i++){
            gelenDizi[hedefIndex] = sayac;
        }
    }
    public static void otomatikTemizle(int [] gelenDizi){
        for (int i = 0; i < gelenDizi.length; i++) {
            if (gelenDizi[i] > 80) {
                gelenDizi[i] = 0;
                System.out.println(i + ". Dosya Temizlendi");
            }
        }
    }
}