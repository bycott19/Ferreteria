package Controlador;

import Modelo.Cliente;
import Modelo.Producto;
import Vista.UIFerreteria;

import java.util.ArrayList;
import java.util.Scanner;
public class ControladorFerreteria {
    //static Scanner sc= new Scanner(System.in);
    ArrayList <Cliente> clientes = new ArrayList();
    ArrayList <Producto> productos = new ArrayList();


    private static ControladorFerreteria instance=null;
    public static ControladorFerreteria getInstance() {
        if(instance==null){
            instance = new ControladorFerreteria();
        }
        return instance;
    }

    public void creaCliente(Cliente nuevo){
    }
    public void creaProducto(Producto nuevo){
    }
}
