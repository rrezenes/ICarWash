/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import java.util.ArrayList;

/**
 *
 * @author rezen
 */
interface BasicoDAO {
    public abstract void cadastrar(Object obj);

    public abstract ArrayList listar();

    public abstract  Object localizarPorId(int id);

    public abstract  void atualizar(Object obj);

    public abstract  void exluir(int id);
}
