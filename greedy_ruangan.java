import java.util.Scanner;
import java.text.DecimalFormat;

public class greedy_ruangan{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.#");

        int i,h =0; 
        int totRuangan, ruangTerpakai;
        int totJamPerHari = 14;
        int totMK = 0;
        float totJam = 0;
        int jumlahJam = 6;
        
        int[] arrMK = new int[jumlahJam];
        String[] arrHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jum'at"};

        System.out.print("Total Ruangan  :  ");
        totRuangan = in.nextInt();

        while(h < arrHari.length){
            System.out.println("\nHari "+arrHari[h]);

            for (i=0; i < arrMK.length; i++){
                System.out.print("Total MK "+ (i+1) + " jam :  ");
                arrMK[i] = in.nextInt();
                totMK = totMK + arrMK[i] ;
                totJam = totJam + ((i+1) * arrMK[i]);
            }

            totJam = totJam / totJamPerHari;
            ruangTerpakai = Math.round(totJam);
            if((ruangTerpakai - totJam) < 0.5){
                ruangTerpakai++;
            }
            
            if(ruangTerpakai > totRuangan){
                System.out.println("Tidak cukup ruang");
                System.out.println("kekurangan "+(ruangTerpakai-totRuangan)+" ruang");
            }else{
                float persentase = (((float)ruangTerpakai/(float)totRuangan) * 100);
                System.out.println("Ruang kosong : "+ (totRuangan-ruangTerpakai)+" ("+df.format(persentase)+" %)");
            }

            h++;
        }
        System.out.println("\n\n\n");
    }
}