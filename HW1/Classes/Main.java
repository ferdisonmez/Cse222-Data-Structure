
import java.util.Random;
import java.util.Scanner;

/**
 * This project can administrate cargo system 
 *This project can administrate cargo system and in this system can new cargo packets add or their remove.
 *if your would new packet ,you can send this packet 
 *if branch employee want to add new customer  in the  this system,he can add customer in this system
 * @author Ferdi Sönmez
 */
public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Sistem sistem=new Sistem();
        Scanner input=new Scanner(System.in); 
        while (true) {            
            
        
        System.out.println("*****Administrators Add******");
            System.out.println("1-Administrator Add\n"
                               +"2-Administrator Add Sisteminden Cikis");
            int ad_sec=input.nextInt();
        if (ad_sec==1) {
            System.out.println("***Lutfen Administrator Ekleyiniz***");
            System.out.println("Administrator Name Giriniz");
            input.nextLine();
            String name=input.nextLine();
            System.out.println("Administrator SurName Giriniz");
            String surname=input.nextLine();
            System.out.println("Administrator Password Olusturunuz");
            String password=input.nextLine();
            Administrator administrator=new Administrator(password, name, surname);
            sistem.administrator_sizeartir();
            sistem.administrator_add(administrator);
             
        }
        else if (ad_sec==2) {
                System.out.println("************************");
                System.out.println("Administrator Add Sisteminden Cikis Yapiliyor...");
                System.out.println("************************");
                break;
            }
        
        }
        
        if (sistem.getAdministrators().length!=0){
            int tut1=-1;
            System.out.println("Administator Olarak Sisteme Giris Yapabilmek Icin Password Girin:");
            input.nextLine();
            String Dpassword=input.nextLine();
            for (int i = 0; i <sistem.getAdministrators().length; i++) {
                if (sistem.getAdministrators()[i].getPassword().equals(Dpassword)) {
                    
                    tut1=i;
                }
            }
            if (tut1!=-1) {
                System.out.println(sistem.getAdministrators()[tut1].getIsim() +" isimli Administrator Giris yapti..");

       
        while (true) {            

        Arayuz();
        System.out.println("Yapilacak islemi Seciniz...");
        int islem=input.nextInt();
        
        if (islem==1) {//Administrator 
            System.out.println("***********************************");
            System.out.println("||||Administrator olarak giris yapildi||||");
            System.out.println("***********************************");
            System.out.println("Administrator Olarak Yapilacak islemi Seciniz...");
            System.out.println("1-Branch ekle veya Cikar\n"
                                +"2-Branch Employee ekle veya cikar\n"
                                +"3-Transportaion Personnel ekle veya cikar\n"
                                +"4-Administrator Sisteminden Cikis... ");
            int ad_islem=input.nextInt();
            if (ad_islem==1) {///Administrator Sisteminde branch ekle ve cikar
              while (true) {                    
                System.out.println("1-Branch ekle\n"
                                   +"2-Branch Cikar\n"
                                   +"3-Branch ekleme ve cikarma islemlerinden Cıkmak icin");
                int ad_branch=input.nextInt();
                if (ad_branch==1) {                
                    System.out.println("Eklemek istediginiz Branch ismini girin: ");
                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                    String branch_name=input.nextLine();   
                    Branch a=new Branch(branch_name);
                    sistem.branch_sizeartir();
                    sistem.branch_add(a);
                    System.out.println(a.getBranch_name()+" isimli Branch kuruldu");                 
                }
                if (ad_branch==2) {
                    System.out.println("Cikarmak istediginiz Branch ismini girin: ");
                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                    String remove_branch_name=input.nextLine();   
                    sistem.branch_remove(remove_branch_name);
                    sistem.branch_show();
                    
                }
                  if (ad_branch==3) {
                      System.out.println("Branch ekleme ve cikarma islemlerinden cikis yapiliyor...");
                      break;
                  }
                  
                
              }

            }
             if (ad_islem==2) {///Administrator sisteminde BranchEmployee ekle ve cikar
                 System.out.println("*******Branch employee ekle veya cikar*******");
                 System.out.println("1-BranchEmployee Ekle\n"
                                    +"2-BranchEmploye Cikar");
                 int is=input.nextInt();
                 if (is==1) {
           
                     int tut=-1;
                      System.out.println("********BranchEmployee Add*********");
                         if (sistem.branch_size()==0) {
                            System.out.println("Herhangi bir Branch olmadıgı icin once yonetici olarak Branch ekleyiniz:\n"
                                        +"Sistemi Tekrar Baslatiniz..");
                          }
                        else{
                           for (int i = 0; i <sistem.getBranchs().length; i++) {
                                System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());
                                tut=i;
                           }
                            if (tut!=-1 &&  sistem.getBranchs().length!=0) {
                                System.out.println("BranchEmployee Hangi Subeye Kaydedeceksiniz Sayi Seciniz:");
                                int index=input.nextInt();
                                
                                    System.out.println("Eklemek istediginiz BranchEmployee ismini girin: ");
                                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                                    String name=input.nextLine();
                                    System.out.println("Eklemek istediginiz BranchEmployee surname girin: ");
                                    String surname=input.nextLine();
                                    String takipno=Random_uret();
                                    Branch_employee c1=new Branch_employee(name, surname);
                                    sistem.getBranchs()[index].branch_employee_sizeartir();
                                    sistem.getBranchs()[index].add_branch_employee(c1);
                                
                            } 

                        }
             }
                 if (is==2) {
                     System.out.println("********BranchEmployee--Remove*********");
  
                            int tut=-1;
                           for (int i = 0; i <sistem.getBranchs().length; i++) {
                                System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());
                                tut=i;
                           }
                        
                          if (tut!=-1 &&  sistem.getBranchs().length!=0) {
                                System.out.println("BranchEmployee Hangi Subeden Sileceksiniz Sayi Seciniz:");
                                int index=input.nextInt();
                                if (sistem.getBranchs()[index].getBranch_employee().length==0) {
                                    System.out.println("Bu branchte Herhangi Bir BranchEmployee Calismiyor.\n"
                                                       +"Lutfen Calisan ekledikten sonra Deneyiniz.");
                                }
                                else{
                                    System.out.println("Silmek istediginiz BranchEmployee ismini girin: ");
                                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                                    String name=input.nextLine();
                                    System.out.println("Silmek istediginiz BranchEmployee surname girin: ");
                                    String surname=input.nextLine();
                                    sistem.getBranchs()[index].remove_customer(name);
                                }
                            }
                     
                     
                 }
                 
            }
            if (ad_islem==3) { ///Administrator sisteminde TransportationEmployee ekle ve Cikar
                System.out.println("*******Transportation-Personnel-Ekle-Veya-Cikar********");
                System.out.println("1-Transportation Personnel Add\n"
                                    +"2-Transportation Personnel Remove");
                int islem_sec=input.nextInt();
                if (islem_sec==1) {
                    System.out.println("****Transportation-Personnel-Add***");
                         int tut=-1;
                         if (sistem.branch_size()==0) {
                            System.out.println("Herhangi bir Branch olmadıgı icin once yonetici olarak Branch ekleyiniz:\n"
                                        +"Sistemi Tekrar Baslatiniz..");
                          }
                        else{
                           for (int i = 0; i <sistem.getBranchs().length; i++) {
                                System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());
                                tut=i;
                           }
                            if (tut!=-1 &&  sistem.getBranchs().length!=0) {
                                System.out.println("Transportation Personnel Hangi Subeye Kaydedeceksiniz Sayi Seciniz:");
                                int index=input.nextInt();
                                
                                    System.out.println("Eklemek istediginiz Transportation Personnel ismini girin: ");
                                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                                    String name=input.nextLine();
                                    System.out.println("Eklemek istediginiz Transportation Personnel surname girin: ");
                                    String surname=input.nextLine();
                                    Transportation_personnel c1=new Transportation_personnel(name, surname);
                                    sistem.getBranchs()[index].transportation_personnel_sizeartir();
                                    sistem.getBranchs()[index].add_transportation_personnel(c1);
                                    System.out.println(sistem.getBranchs()[index].getBranch_name() +" Branchinde Calisanlarin Listesi");
                                    for (int i = 0; i < sistem.getBranchs()[index].getTransportation_personnels().length; i++) {                  
                                        System.out.println(sistem.getBranchs()[index].getTransportation_personnels()[i].getIsim()+" " +sistem.getBranchs()[index].getTransportation_personnels()[i].getSurname());
                                }
                                
                            } 

                        }
                    
                    
                }
                if (islem_sec==2) {
                    System.out.println("****Transportation-Personnel-Remove***");
                            int tut=-1;
                           for (int i = 0; i <sistem.getBranchs().length; i++) {
                                System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());
                                tut=i;
                           }
                        
                          if (tut!=-1 &&  sistem.getBranchs().length!=0) {
                                System.out.println("Transportation-Personnel Hangi Subeden Sileceksiniz Sayi Seciniz:");
                                int index=input.nextInt();
                                if (sistem.getBranchs()[index].getBranch_employee().length==0) {
                                    System.out.println("Bu branchte Herhangi Bir BranchEmployee Calismiyor.\n"
                                                       +"Lutfen Calisan ekledikten sonra Deneyiniz.");
                                }
                                else{
                                    System.out.println("Silmek istediginiz Transportation-Personnel ismini girin: ");
                                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                                    String name=input.nextLine();
                                    System.out.println("Silmek istediginiz Transportation-Personnel surname girin: ");
                                    String surname=input.nextLine();
                                    sistem.getBranchs()[index].remove_transportation_personnel(name);
                                }
                            }
                      
                }
                
            }
            
        }//Administrator
        
        if (islem==2) {///Branch Employee 
            while (true) {                
            Branch_employee_arayuz();
            int Branch_employee_islem=input.nextInt();
            if (Branch_employee_islem==1) {///BranchEmployee Sisteminde Customer Add and Remove
                  System.out.println("1-Customer Ekle \n"
                                      +"2-Customer Cikar.");
                  System.out.print("Lutfen Seciniz:");
                  int sec=input.nextInt();
                
            if (sec==1) {
                    int tut=-1;
                      System.out.println("********Customer--Add*********");
                         if (sistem.branch_size()==0) {
                            System.out.println("Herhangi bir Branch olmadıgı icin once yonetici olarak Branch ekleyiniz:\n"
                                        +"Sistemi Tekrar Baslatiniz..");
                          }
                        else{
                           for (int i = 0; i <sistem.getBranchs().length; i++) {
                                System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());
                                tut=i;
                           }
                            if (tut!=-1 &&  sistem.getBranchs().length!=0) {
                                System.out.println("Customeri Hangi Subeye Kaydedeceksiniz Sayi Seciniz:");
                                int index=input.nextInt();
                                if (sistem.getBranchs()[index].getBranch_employee().length==0) {
                                    System.out.println("Bu branchte Herhangi Bir BranchEmployee Calismiyor.\n"
                                                       +"Lutfen Calisan ekledikten sonra Deneyiniz.");
                                }
                                else{
                                    System.out.println("Eklemek istediginiz Customer ismini girin: ");
                                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                                    String name=input.nextLine();
                                    System.out.println("Eklemek istediginiz Customer surname girin: ");
                                    String surname=input.nextLine();                            
                                    Customer customer1=new Customer(name, surname,"-2");
                                    sistem.getBranchs()[index].customer_sizeartir();
                                    sistem.getBranchs()[index].add_customer(customer1);
                                    
                                }
                            } 

                        }
                
                } 
                if (sec==2) {
                    System.out.println("********Customer--Remove*********");
                    if (sistem.branch_size()==0) {
                        System.out.println("Herhangi bir Branch olmadıgı icin once yonetici olarak Branch ekleyiniz:\n"
                                        +"Sistemi Tekrar Baslatiniz..");
                    }
                    else{
                        int tut=-1;
                           for (int i = 0; i <sistem.getBranchs().length; i++) {
                                System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());
                                tut=i;
                           }
                        
                          if (tut!=-1 &&  sistem.getBranchs().length!=0) {
                                System.out.println("Customeri Hangi Subeden Sileceksiniz Sayi Seciniz:");
                                int index=input.nextInt();
                                if (sistem.getBranchs()[index].getBranch_employee().length==0) {
                                    System.out.println("Bu branchte Herhangi Bir BranchEmployee Calismiyor.\n"
                                                       +"Lutfen Calisan ekledikten sonra Deneyiniz.");
                                }
                                else{
                                    System.out.println("Silmek istediginiz Customer ismini girin: ");
                                    input.nextLine(); ///Nextline hatasi icin kullanildi.
                                    String name=input.nextLine();
                                    System.out.println("Silmek istediginiz Customer surname girin: ");
                                    String surname=input.nextLine();
                                    sistem.getBranchs()[index].remove_customer(name);
                                }
                            }
                       
                    }
                
                } 
                break;
            }
            if (Branch_employee_islem==2) {///BranchEmployee Sisteminde Kargo Kabul
                int tut=-1;
                System.out.println("*****Customerdan-Kargo-Kabul*********");
                   if (sistem.branch_size()==0) {
                        System.out.println("Herhangi bir Branch olmadıgı icin once yonetici olarak Branch ekleyiniz:\n"
                                        +"Sistemi Tekrar Baslatiniz..");
                    }
                   else{
                       for (int i = 0; i <sistem.getBranchs().length; i++) {
                           System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());   
                       }
                       System.out.println("Hangi Branchden Kargo Kabulu Yaptiracaksiniz");
                       int index=input.nextInt();
                       if (sistem.getBranchs()[index].getCustomers().length >= 2) {   
                           System.out.println("***Kargoyu Gonderici Seciniz****");
                           for (int i = 0; i <sistem.getBranchs()[index].get_customers_size(); i++) {
                               System.out.println(i +"-"+sistem.getBranchs()[index].getCustomers()[i].getIsim()+" "+sistem.getBranchs()[index].getCustomers()[i].getSurname());
                           }
                       int gonderici_index=input.nextInt();
                         System.out.println("***Kargoyu Alici Seciniz****");
                           for (int i = 0; i <sistem.getBranchs()[index].get_customers_size(); i++) {
                               System.out.println(i +"-"+sistem.getBranchs()[index].getCustomers()[i].getIsim()+" "+sistem.getBranchs()[index].getCustomers()[i].getSurname());
                           }
                           int alici_index=input.nextInt();
                          String takipno=Random_uret(); 
                        int paket_sayisi=sistem.getPaketsize();

                           if (!sistem.getBranchs()[index].getCustomers()[gonderici_index].equals("-2")) {
                               sistem.pakets_sizeartir();
                               Paket paket=new Paket(sistem.getBranchs()[index].getCustomers()[alici_index], sistem.getBranchs()[index].getCustomers()[gonderici_index], takipno, "Branch");
                               sistem.add_pakets(paket); 
                               System.out.println("Kargo TakipNo=" +takipno);
                           }
                           else{
                               System.out.println("Bu Gonderici Adina Zaten Bir Kargo Kaydi Bulunmaktadir.");
                           }
                           
                       }
                       else{
                           System.out.println("Subede en az 2 musteri olmasi gerekmelidir.Lutfen musteri ekleyiniz.");
                       }

                       
                   }
                   break;
            }
            if (Branch_employee_islem==3) {///BranchEmployee Sisteminde Kargo Update
                System.out.println("********Kargo--Update--Sistemi********");
                    if (sistem.branch_size()==0) {
                        System.out.println("Herhangi bir Branch olmadıgı icin once yonetici olarak Branch ekleyiniz:\n"
                                        +"Sistemi Tekrar Baslatiniz..");
                    }
                    else{
                            
                          if (sistem.getPakets().length!=0) {
                              for (int i = 0; i <sistem.getBranchs().length; i++) {
                                System.out.println(i +"-"+sistem.getBranchs()[i].getBranch_name());                              
                              }
                                System.out.println("Hangi Branchte Islem Yapiyorsunuz");
                              int index=input.nextInt();

                                if (sistem.getBranchs()[index].getBranch_employee().length==0) {
                                    System.out.println("Bu branchte Herhangi Bir BranchEmployee Calismiyor.\n"
                                                       +"Lutfen Calisan ekledikten sonra Deneyiniz.");
                                }
                                else{
                                    System.out.println(sistem.getBranchs()[index].getBranch_name()+" isimli Kargo Branchinde BranchEmploye Olarak Calisanlarin Listesi");
                                    for (int i = 0; i <sistem.getBranchs()[index].getBranch_employee().length; i++) {
                                        System.out.println(i+"-"+sistem.getBranchs()[index].getBranch_employee()[i].getIsim()+" " + sistem.getBranchs()[index].getBranch_employee()[i].getSurname());
                                    }
                                     System.out.println("Branchdeki Hangi Calisansiniz");
                                    int br_index=input.nextInt();///BranchEmployee index
                                    for (int i = 0; i <sistem.getPakets().length; i++) {
                                        System.out.println(i+"-"+sistem.getPakets()[i].getTakip_no()+ " takip nolu kargo " +sistem.getPakets()[i].getPaketdurum()+" asamasındadir.");
                                    }  
                                    System.out.println("Hangi Kargonun Durumunu Update Yapacaksiniz Sayi Seciniz:");
                                    int cargo_index=input.nextInt();
                                    System.out.println("***Kargo-Status-Seciniz**\n"                                                      
                                                        +"1-Branch\n"
                                                        +"2-Transportation Process");
                                    int status=input.nextInt();
                                    String dur;
                                    if (status==2) {
                                        dur="Transportation Process";
                                    }
                                    else{
                                        dur="Branch";
                                    }
                                    sistem.update(dur,cargo_index);
                                    
                                }
                            }

                    }
                   break;
                 }
                 if (Branch_employee_islem==4){
                     System.out.println("BranchEmploye Sisteminden Cikis Yapiliyor...");
                     break;
                 }
            
            
            }
        }///BranchEmployee
        
        if (islem==3) {///Transportation Personnel
            while (true) {                
                Transportation_personel_arayuz();
                int secim=input.nextInt();
                if (secim==1) {
                    int tut=-1;
                    if (sistem.getPakets().length!=0) {
                       
                        for (int i = 0; i <sistem.getPakets().length; i++) {
                            if (sistem.getPakets()[i].getPaketdurum().equals("Transportation Process")) {
                                 sistem.getPakets()[i].setPaketdurum("Deliver");
                                 System.out.println(sistem.getPakets()[i].getTakip_no()+ " takipNolu Kargo "+sistem.getPakets()[i].getAlici().getIsim() +sistem.getPakets()[i].getAlici().getSurname()+" isimli Aliciya Teslim Edilmistir");
                                 tut=i;
                            }
                        }
                        if (tut==-1) {
                            System.out.println("Transportation Processde Herhangi Bir Kargo Yoktur");
                        }

                    }
                    
                    
                    break;
                }
                if (secim==2) {
                    System.out.println("Transportation Personel Sisteminden Cikis Yapiliyor...");
                    break;
                }
                
            }
 
        }
        if (islem==4) {///Customer
            while (true) {                
                    Customer_arayuz();
                    int secim=input.nextInt();
                 if (secim==1) {
                     int sec=-1;
                     System.out.println("Kargo Takip no Girin");
                     input.nextLine();
                     String takip=input.nextLine();
                     for (int i = 0; i <sistem.getPakets().length; i++) {
                         if (sistem.getPakets()[i].getTakip_no().equals(takip)) {
                             sec=i;
                         }
                     }
                     if (sec !=-1) {
                         System.out.println("****************");
                         System.out.println("Alici=" +sistem.getPakets()[sec].getAlici().getIsim() +" "+sistem.getPakets()[sec].getAlici().getSurname() +"\n"
                                            +"Gonderici=" +sistem.getPakets()[sec].getGonderici().getIsim()+" "+sistem.getPakets()[sec].getGonderici().getSurname()+"\n"
                                            +"Paket Durumu="+sistem.getPakets()[sec].getPaketdurum());
                         System.out.println("******************");
                     }
                     else{
                         System.out.println("Kargo TakipNo Yanlis.Tekrar Girin");
                     }
                    
                     
                     break;
                  }
                 if (secim==2) {
                        break;
                  } 
            }

        }
        if (islem==5) {///Sistemden cikis
            System.out.println("Sistemden Cikis Yapiliyor...");
            break;
        }
        

     }  ///While
       
     }
            else{
                System.out.println("Password Yanlis Girildi...");
                System.out.println("Sistemi Tekrar Baslatiniz...");
            }
            
 }  
        
    }

    /**
     *This function's task  create interface for cargo system
     */
    public static void Arayuz(){
        System.out.println("*******GENEL KARGO SISTEM***********");
        System.out.println("1-Administrator Olarak giris.\n"
                            +"2-Branch Empoyee olarak giris.\n"
                            +"3-Transportaion olarak giris.\n"
                            +"4-Customer olarak giris.\n"
                            +"5-Sistemden Cıkıs");
         System.out.println("*********************************");
    }

    /**
     *this function's task  create interface for BranchEmployee
     */
    public static void Branch_employee_arayuz(){
        
        System.out.println("*****Branch Employee Sistemi*******");
        System.out.println("1-Customer ekle veya Cikar.\n"
                            +"2-Customerden Kargo kabul et.\n"
                            +"3-Kargo bilgisi update.\n"
                             +"4-BranchEmployee Sisteminden Cikis");
         System.out.println("*********************************");
        
    }

    /**
     *this function's task  create interface for TransportationPersonnel system
     */
    public static void Transportation_personel_arayuz(){
        
        System.out.println("*****Transportation Personel Sistemi*******");
        System.out.println("1-Paket Teslim Edilirse Durum Güncelle.\n"
                            +"2-Transportation Personel Sisteminden Cikis");
         System.out.println("*********************************");
        
    }

    /**
     *this function's task  create interface for Customer system
     */
    public static void Customer_arayuz(){
        
        System.out.println("*****Customer Sistemi*******");
        System.out.println("1-Takipno ile Paket Durumunu Sorgula.\n"
                            +"2-Customer Sisteminden Cikis");
         System.out.println("*********************************");
        
    }
    
    /**
     *This function produce random number for cargo tracking no
     * @return a(Random Number)
     */
    public static String Random_uret(){
        Random r=new Random(); //random sınıfı
        int x=r.nextInt(10000);
        String a=String.valueOf(x);
        return a;
    }
    
}
