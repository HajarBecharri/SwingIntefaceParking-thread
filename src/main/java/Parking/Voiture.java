/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parking; 
import java.util.*; 


/**
 *
 * @author hp
 */
public class Voiture implements Runnable {
     String nom;
     Parking park;
     Integer temps;
     String timer;
     UGParking UG;

    public Voiture(String nom, Parking park,Integer temps,UGParking UG) {
        this.temps=temps;
        this.nom = nom;
        this.park = park;
        this.UG=UG;
        
        
    }
    
    @Override
    public void run(){
    
    System.out.format("[%s]: Je débute ! \n", this.nom);
    timer=this.nom+" : attendre";
    UG.setText(timer);
    UG.setImage("C:\\attendreR.png");
        try {
    Thread.sleep(5000);
    System.out.format("[%s]: Je demande à rentrer \n", this.nom);
    this.rentrer();
    timer=this.nom+" : entrer";
    UG.setText(timer);
    UG.setImage("C:\\entreR.jpeg");
    Thread.sleep(5000);
    System.out.format("[%s]: Je viens d'entrer \n", this.nom);
    Thread.sleep(temps);
    System.out.format("[%s]: Je demande à sortir \n", this.nom);
    this.park.leave(this);
    timer=this.nom+" : sort";
    UG.setText(timer);
    UG.setImage("C:\\sorteR.png");
    
    
}
        catch(InterruptedException e){
    
}

    
}
    
    
    public void rentrer() throws InterruptedException{
    while (!(this.park.accept(this)))
    {
    Thread.sleep((long) (1000* Math.random()));
    System.out.format("[%s] : Je redemande à rentrer \n", this.nom);
    }
  }
    
   
    
    
}




