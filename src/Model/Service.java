/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dorsa
 */
public class Service {
   private int idService;
   private String nomService;
   private int capacite;
   private double cout;
   

    public Service(int idService , String nomService, int capacite, double cout) {
        this.idService = idService;
        this.nomService = nomService;
        this.capacite = capacite;
        this.cout = cout;
    }

    public int getIdService() {
        return idService;
    }
    public String getNomService() {
        return nomService;
    }

    public int getCapacite() {
        return capacite;
    }

    public double getCout() {
        return cout;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public void afficherService() {
        System.out.println("Nom du service : " + nomService);
        System.out.println("Capacité : " + capacite);
        System.out.println("Coût : " + cout);
}
}