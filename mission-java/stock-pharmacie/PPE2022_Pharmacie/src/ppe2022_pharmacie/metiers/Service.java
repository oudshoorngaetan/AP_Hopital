/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe2022_pharmacie.metiers;

/**
 *
 * @author hbana
 */
public class Service {

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    private int idService;
    private String libelle;

    public Service(int idService, String libelle) {
        this.idService = idService;
        this.libelle = libelle;
    }

    public int getIdService() {
        return idService;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
    
}
