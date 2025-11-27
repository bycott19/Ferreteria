package Vista;

import Controlador.ControladorFerreteria;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.Scanner;

public class UIFerreteria {

    static Scanner sc = new Scanner(System.in);

    private static UIFerreteria instance = null;

    public static UIFerreteria getInstance(){
        if(instance==null){
            instance=new UIFerreteria();
        }
        return instance;
    }


    //Menu del sistema:

    public void mostrarMenu(){

        System.out.println();
        System.out.println("***** SISTEMA DE FERRETERIA *****");
        System.out.println("** MENU DE OPCIONES **");
        System.out.println("1.- Crear nuevo cliente");
        System.out.println("2.- Crear nuevo producto");
        System.out.println("3.- Listar a todos los clientes");
        System.out.println("4.- Listar todos los productos");
        System.out.println("5.- Ingresar venta");
        System.out.println("6.- Listar ventas");
        System.out.println("7.- Guardar Datos");
        System.out.println("8. -Cargar Datos");
        System.out.println("9.- Salir");
    }

    public void Menu(){

        int opcion=0;
        String opcionString;
        boolean repetirMenu=true;

        do{
            mostrarMenu();
            do{
                System.out.print("Ingrese la opción: ");
                opcionString = sc.next();

                try{
                    opcion = Integer.parseInt(opcionString);
                    if(opcion < 1 || opcion > 9){
                        System.out.println("");
                        System.out.println("La opción ingresada no esta disponible");
                    }else{
                        repetirMenu = false;
                    }
                }catch(Exception e){
                    System.out.println("");
                    System.out.println("Se ingreso un valor invalido. Recuerde ingresar valor númerico");
                }
            }while(repetirMenu);

            switch(opcion){
                case 1:
                    CrearCliente();
                    break;
                case 2:
                    CrearProducto();
                    break;
                case 3:
                    ListaClientes();
                    break;
                case 4:
                    ListaProductos();
                    break;
                case 5:
                    IngresarVenta();
                    break;
                case 6:
                    ListarVentas();
                    break;
                case 7:
                    ControladorFerreteria.getInstance().guardarDatos();
                    break;
                case 8:
                    ControladorFerreteria.getInstance().leerDatos();
                    break;
                case 9:
                    System.out.println("Adios!!!");
                    break;
            }
        }while(opcion != 9);
    }

    public void CrearCliente(){

        System.out.println();
        System.out.println("****Creando un nuevo cliente****");
        System.out.print("Rut: ");
        String rut=sc.next();

        while(ControladorFerreteria.getInstance().buscarCliente(rut) != null){
            System.out.println("ERROR. Ya existe un cliente con el mismo rut");
            System.out.print("Rut: ");
            rut=sc.next();
        }

        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre=sc.nextLine();
        System.out.print("Dirección: ");
        String direccion=sc.nextLine();
        System.out.print("Telefono: ");
        String telefono=sc.nextLine();

        Cliente nuevo = new Cliente(rut, nombre, direccion, telefono);
        ControladorFerreteria.getInstance().creaCliente(nuevo);

        System.out.println("Cliente creado con exito!!!!");
    }
    public void CrearProducto(){

        int cod=0;
        String cod2;
        boolean repetir=true;
        int prec=0;
        String precio;

        System.out.println();
        System.out.println("****Creando un nuevo producto****");

        do {
            System.out.print("Codigo: " );
            cod2=sc.next();
            try {
                cod=Integer.parseInt(cod2);
                if(ControladorFerreteria.getInstance().buscarProducto(cod)!=null){
                    System.out.println("Error. Ya existe un producto con el mismo codigo");
                }else{
                    repetir=false;
                }
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Se ingreso un valor invalido, recuerde ingresar un número");
            }
        }while (repetir);

        repetir=true;
        sc.nextLine();
        System.out.print("Marca: ");
        String marca=sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion= sc.nextLine();

        do {
            System.out.print("Precio: $");
            precio = sc.nextLine();
            try{
                prec = Integer.parseInt(precio);
                if(prec<1){
                    System.out.println();
                    System.out.println("Error. No puede ingresar un precio menor que $1");
                }else{
                    repetir=false;
                }
            } catch (NumberFormatException e){
                System.out.println();
                System.out.println("Se ingreso un valor invalido, recuerde ingresar un número");
            }
        } while(repetir);

        Producto nuevoProducto = new Producto(cod, marca, descripcion, prec);
        ControladorFerreteria.getInstance().creaProducto(nuevoProducto);

        System.out.println("Producto creado con exito!!!!");
    }

    public void ListaProductos(){

        System.out.println();
        System.out.println("***LISTADO DE PRODUCTOS****");
        System.out.printf("%-25s %-25s %-25s %-25s %n", "Codigo", "MARCA", "DESCRIPCIÓN", "PRECIO");

        Producto[] listaProductos = ControladorFerreteria.getInstance().listaProductos();
        for(int i =0; i<listaProductos.length; i++){
            System.out.printf("%-25d %-25s %-25s %-25d %n", listaProductos[i].getCodigo(), listaProductos[i].getMarca(), listaProductos[i].getDescripcion(), listaProductos[i].getPrecio());
        }
    }

    public void ListaClientes(){

        System.out.println();
        System.out.println("**** LISTADO DE CLIENTES ****");
        System.out.printf("%-25s %-30s %-35s %-25s %n","RUT", "NOMBRE", "DIRECCIÓN", "TELEFONO");

        Cliente[] listaClientes = ControladorFerreteria.getInstance().listaClientes();
        for(int i = 0; i<listaClientes.length; i++){
            System.out.printf("%-25s %-30s %-35s %-25s %n",listaClientes[i].getRut(), listaClientes[i].getNombre(), listaClientes[i].getDireccion(), listaClientes[i].getTelefono());
        }
    }

//SEGUNDA PARTE DEL PROYECTO

    public void IngresarVenta() {

        System.out.println();

        if (ControladorFerreteria.getInstance().existeCliente() == null && ControladorFerreteria.getInstance().existeProducto() == null) {
            System.out.println("No existen Datos en el sistema");
            return;
        } else {
            if (ControladorFerreteria.getInstance().existeProducto() == null) {
                System.out.println("No existen productos en el sistema");
                return;
            }
            if(ControladorFerreteria.getInstance().existeCliente()==null){
                System.out.println("No existen clientes en el sistema");
                return;
            }
        }

        System.out.println("****INGRESANDO VENTA AL SISTEMA****");
        System.out.print("Rut del cliente: ");
        String rut=sc.next();

        while(ControladorFerreteria.getInstance().buscarCliente(rut) == null){
            System.out.println();
            System.out.println("No existen clientes con ese rut");
            System.out.print("Rut del cliente: ");
            rut=sc.next();
        }
        String codigV;
        int codVenta = 0;
        boolean repetir = true;
        do{
            System.out.print("Codigo de venta: ");
            codigV =sc.next();
            try{
                codVenta = Integer.parseInt (codigV);
                repetir= false;
            } catch (NumberFormatException e){
                System.out.println();
                System.out.println("Se ingreso un valor invalido, recuerde ingresar un número");
            }
        } while(repetir);

        System.out.print("Fecha de la Venta: ");
        String fecha=sc.next();

        ArrayList<DetalleVenta> detallesVentas = new ArrayList<>();

        String opci, cantProd, codigP;
        int op=0, cantidadProductos = 0, codProducto = 0;
        repetir=true;

        do{
            do{
                System.out.print("Codigo del producto: ");
                codigP = sc.next();
                try{
                    codProducto = Integer.parseInt(codigP);
                    if (ControladorFerreteria.getInstance().buscarProducto(codProducto) == null){
                        System.out.println();
                        System.out.println("No existen productos con ese codigo");
                    }else {
                        repetir = false;
                    }
                } catch (NumberFormatException e){
                    System.out.println();
                    System.out.println("Se ingreso un valor invalido, recuerde ingresar un número");
                }
            } while (repetir);

            repetir=true;
            do {
                System.out.print("Cantidad: ");
                cantProd = sc.next();
                try{
                    cantidadProductos = Integer.parseInt(cantProd);
                    if(cantidadProductos < 1){
                        System.out.println();
                        System.out.println("No puede ingresar una cantidad menor que 1");
                    }else {
                        repetir = false;
                    }
                } catch (NumberFormatException e){
                    System.out.println();
                    System.out.println("Se ingreso un valor invalido, recuerde ingresar un número");
                }
            } while(repetir);

            repetir=true;

            Producto producto = ControladorFerreteria.getInstance().buscarProducto(codProducto);
            DetalleVenta detalle = new DetalleVenta(cantidadProductos, producto);
            detallesVentas.add(detalle);

            do{
                System.out.println("¿Añadir nuevo producto a la compra?");
                System.out.println("1- Si      2-No");
                opci=sc.next();
                try {
                    op=Integer.parseInt(opci);
                    if(op<1 || op>2){
                        System.out.println();
                        System.out.println("La opción ingresada no esta disponible");
                    }else{
                        repetir=false;
                    }
                }catch (NumberFormatException e){
                    System.out.println();
                    System.out.println("Se ingreso un valor invalido, recuerde ingresar un número");
                }
            }while(repetir);
        }while(op!=2);

        Venta miVenta = new Venta(codVenta, ControladorFerreteria.getInstance().buscarCliente(rut), fecha, detallesVentas);
        ControladorFerreteria.getInstance().creaVenta(miVenta);

        System.out.println("Venta ingresada con exito!!!!");
        System.out.println();
    }

    public void ListarVentas(){

        Venta [] listaVentas = ControladorFerreteria.getInstance().listaVentas();
        System.out.println();
        System.out.println("***LISTADO DE VENTAS****");
        System.out.println();

        for(int i=0; i<listaVentas.length; i++){
            System.out.println("N° DE FACTURA: "+listaVentas[i].getCodigoVenta());
            System.out.println("SE VENDIO AL: "+listaVentas[i].getCliente().toString());
            System.out.println("FECHA DE VENTA: "+listaVentas[i].getFecha());
            System.out.println("DETALLE DE LO VENDIDO: ");
            System.out.println();

            int acumulado=0;

            for(DetalleVenta detalle : listaVentas[i].getDetalleVenta()){
                Producto auxiliar = detalle.getProducto();
                int totalLinea =  auxiliar.getPrecio() * detalle.getCantidadCompra();
                System.out.println("Cantidad: "+detalle.getCantidadCompra()+"  "+auxiliar.getDescripcion()+"   total: $"+totalLinea);
                acumulado=acumulado+totalLinea;
            }

            System.out.println();
            System.out.println("Total NETO: $"+acumulado);
            double iva = acumulado* 0.19;
            System.out.println("IVA: "+iva);
            System.out.println("TOTAL : $"+(acumulado+iva));
            System.out.println();
        }
    }

}
