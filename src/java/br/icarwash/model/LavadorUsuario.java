/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.model;

/**
 *
 * @author rezen
 */
public class LavadorUsuario {

    private int idLavador;
    private int idUsuario;

    public LavadorUsuario(Lavador lavadorID, Usuario usuarioID) {
        this.idLavador = lavadorID.getId();
        this.idUsuario = usuarioID.getId();
    }

    public int getIdLavador() {
        return idLavador;
    }

    public void setIdLavador(int idLavador) {
        this.idLavador = idLavador;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
