import java.util.Random;


public class Chess960{



    // Array'den eleman çıkarma fonksiyonu
    public static String[] removeTheElement(String[] arr, int index)
    {
        if (arr == null || index<0 || index >= arr.length) {

            return arr;
        }

        String[] anotherArray = new String[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }


    public static String[] main(String[] args) {
        String chessPieces[] ={"rook","rook","bishop","bishop","knight","knight","king","queen"};
        String possibleLineup[] = new String[8];

        // Fillerin farklı renklerdeki kutularda olduğunu kontrol etmemizi sağlayacak değişken.
        int firstBishopIndex=0;
        
        // İçine taş yerleştirilecek 8 tane kutu var. Her bir kutu için sıra sıra kontrol gerçekleştirilecek.
        try {
            for(int i=0;i<=7;i++){
            
            

                do {
                    // Öncelikle rastgele bir taş seçiliyor
                    int rand = new Random().nextInt(0,chessPieces.length);
    
                    // Eğer seçilen taş ŞAH ise;
                    if(chessPieces[rand].equals("king")){
    
                    try {
                        // ŞAH'ın konulacağı kareden önceki kareye kadar bir KALE konulmuş olmalı.
                        for(int a=0 ; a<i ; a++){
                            if((possibleLineup[a].equals("rook"))){
    
                                // Mevcut kareye ŞAH'ı yerleştir.
                                possibleLineup[i]=chessPieces[rand];
    
                                // Pieces array'inden yerleştirilen taşı çıkar.
                                chessPieces = removeTheElement(chessPieces, rand);
    
                                // Mevcut kareden önce yerleştirilmiş bir KALE bulunması yeterli, KALE kontrolü döngüsünden çıkılabilir.
                                break;
                            }
                    }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    
                }
    
                // Seçilen taş KALE ise;
                else if(chessPieces[rand].equals("rook")){
    
                    /* İlk KALE'nin mi yoksa ikinci KALE'nin mi yerleştirileceğini kontrol ediyoruz. Eğer daha önce hem bir KALE hem de ŞAH yerleştirildiyse ya da daha önce bir KALE ya da
                       ŞAH yerleştirilmediyse 2. KALE yerleştirilebilir çünkü ŞAH iki KALE'nin ortasında olmak zorundadır. */
                    int rookAndking=0;
                    try {
                        for(int a=0 ; a<i ; a++){
                            if(possibleLineup[a].equals("rook") || possibleLineup[a].equals("king"))rookAndking+=1;
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    
                    if(rookAndking==0 || rookAndking==2){
                        possibleLineup[i]=chessPieces[rand];
                        chessPieces = removeTheElement(chessPieces, rand);
                    }
                }
    
                // Seçilen taş FİL ise;
                else if(chessPieces[rand].equals("bishop")){
    
                    
    
                    int bishopCounter=0;
    
                    
                        // Mevcut kareye kadar konulmuş FİL var mı yok mu kontrolünü yapıyoruz.
                        for(int a=0 ; a<i ; a++){
                            if(possibleLineup[a].equals("bishop")){
                                bishopCounter=1;
                                break;
                            }
                        }
                    
                    // Eğer şu anda ilk FİL konuluyorsa herhangi bir kontrol gerekmeden mevcut kareye yerleştirilebilir.
                    if(bishopCounter==0){
                        possibleLineup[i]=chessPieces[rand];
                        firstBishopIndex=i;
                        chessPieces = removeTheElement(chessPieces, rand);
                    }
    
                    // Eğer ikinci FİL konuluyorsa, FİL'lerin farklı renklerde karelerde olmaları gerektiğinden bir tanesinin tek sayılı diğerinin çift sayılı bir indiste bulunması gerekir.
                    else if(bishopCounter==1){
                        if((firstBishopIndex+i)%2!=0){
                            // Eğer şu anda yerleştirilecek olan 2. FİL, 1. FİL ile aynı renkli kareye denk geliyorsa hiçbir şey yapma.
                            possibleLineup[i]=chessPieces[rand];
                            chessPieces = removeTheElement(chessPieces, rand);
                        }
                    }
                }
    
                // Seçilen taş AT ise; herhangi bir koşul gerekmediği için AT direkt yerleştirilebilir.
                else if(chessPieces[rand].equals("knight")){
                    possibleLineup[i]=chessPieces[rand];
                    chessPieces = removeTheElement(chessPieces, rand);
                }
                
                // Seçilen taş VEZİR ise; herhangi bir koşul gerekmediği için VEZİR direkt yerleştirilebilir.
                else if(chessPieces[rand].equals("queen")){
                    possibleLineup[i]=chessPieces[rand];
                    chessPieces = removeTheElement(chessPieces, rand);
                }
                else;
                } while (possibleLineup[i]==null);
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Dizilimin son halini yazdırıyoruz.
        for(int x=0; x<8; x++){
            System.out.print(possibleLineup[x] + "    ");
        }
        return possibleLineup;
    }
}
