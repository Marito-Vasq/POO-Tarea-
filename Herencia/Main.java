package Herencia;

// 1️ PERSONA, DOCENTE, ESTUDIANTE
class Persona {
    protected String nombre;
    protected int edad;
    public Persona(String nombre, int edad) { this.nombre = nombre; this.edad = edad; }
    public void mostrar() { System.out.println("Nombre: " + nombre + ", Edad: " + edad); }
}
class Docente extends Persona {
    private String especialidad;
    public Docente(String nombre, int edad, String especialidad) { super(nombre, edad); this.especialidad = especialidad; }
    @Override public void mostrar() { super.mostrar(); System.out.println("Especialidad: " + especialidad); }
}
class Estudiante extends Persona {
    private String carnet;
    public Estudiante(String nombre, int edad, String carnet) { super(nombre, edad); this.carnet = carnet; }
    @Override public void mostrar() { super.mostrar(); System.out.println("Carnet: " + carnet); }
}

// 2️CUENTA Y CUENTACORRIENTE
class Cuenta {
    protected double saldo;
    public Cuenta(double saldo) { this.saldo = saldo; }
    public void retirar(double monto) { this.saldo -= monto; }
}
class CuentaCorriente extends Cuenta {
    private double limiteSobregiro;
    public CuentaCorriente(double saldo, double limiteSobregiro) { super(saldo); this.limiteSobregiro = limiteSobregiro; }
    @Override public void retirar(double monto) {
        if (saldo - monto >= -limiteSobregiro) { super.retirar(monto); System.out.println("Retiro exitoso. Saldo actual: $" + saldo); }
        else { System.out.println("Error: Supera el límite de sobregiro permitido."); }
    }
}

// 3️ PRODUCTO Y PRODUCTOPERECEDERO
class Producto {
    protected String nombre;
    public Producto(String nombre) { this.nombre = nombre; }
}
class ProductoPerecedero extends Producto {
    private int diasParaVencer;
    public ProductoPerecedero(String nombre, int diasParaVencer) { super(nombre); this.diasParaVencer = diasParaVencer; }
    public boolean estaVencido() { return diasParaVencer <= 0; }
}

// 4️ TRANSPORTE Y BUS
class Transporte {
    protected int capacidad;
    public Transporte(int capacidad) { this.capacidad = capacidad; }
}
class Bus extends Transporte {
    private String ruta;
    public Bus(int capacidad, String ruta) { super(capacidad); this.ruta = ruta; }
    public void descripcion() { System.out.println("Bus de la ruta '" + ruta + "' con capacidad para " + capacidad + " pasajeros."); }
}

// 5️ EMPLEADO Y GERENTE
class Empleado {
    protected String nombre; protected double salario;
    public Empleado(String nombre, double salario) { this.nombre = nombre; this.salario = salario; }
    public double calcularSalario() { return salario; }
}
class Gerente extends Empleado {
    private double bono;
    public Gerente(String nombre, double salario, double bono) { super(nombre, salario); this.bono = bono; }
    @Override public double calcularSalario() { return super.calcularSalario() + bono; }
}

// 6️ ANIMAL Y PERRO
class Animal { public void hacerSonido() { System.out.println("El animal hace un sonido genérico."); } }
class Perro extends Animal { @Override public void hacerSonido() { System.out.println("El perro hace: ¡Guau Guau!"); } }

// 7️ VEHICULO Y MOTO
class Vehiculo {
    protected String marca; protected double velocidad;
    public Vehiculo(String marca, double velocidad) { this.marca = marca; this.velocidad = velocidad; }
}
class Moto extends Vehiculo {
    private int cilindrada;
    public Moto(String marca, double velocidad, int cilindrada) { super(marca, velocidad); this.cilindrada = cilindrada; }
    public void mostrarInfo() { System.out.println("Moto " + marca + " | Velocidad: " + velocidad + " km/h | Cilindrada: " + cilindrada + "cc"); }
}

// 8️ FIGURA Y RECTANGULO
class Figura { public double calcularArea() { return 0; } }
class Rectangulo extends Figura {
    private double base, altura;
    public Rectangulo(double base, double altura) { this.base = base; this.altura = altura; }
    @Override public double calcularArea() { return base * altura; }
}
class Circulo extends Figura {
    private double radio;
    public Circulo(double radio) { this.radio = radio; }
    @Override public double calcularArea() { return 3.1416 * radio * radio; }
}

// 9️ LIBRO Y LIBRO DIGITAL
class Libro {
    protected String titulo, autor;
    public Libro(String titulo, String autor) { this.titulo = titulo; this.autor = autor; }
}
class LibroDigital extends Libro {
    private double tamanoMB;
    public LibroDigital(String titulo, String autor, double tamanoMB) { super(titulo, autor); this.tamanoMB = tamanoMB; }
    public void mostrarInfo() { System.out.println("Libro: " + titulo + " por " + autor + " | Tamaño: " + tamanoMB + " MB"); }
}

// 10 SISTEMA DE FACTURACIÓN
class Cliente {
    private String nombre; private String nit;
    public Cliente(String nombre, String nit) { this.nombre = nombre; this.nit = nit; }
    public String getNombre() { return nombre; }
}
class Factura {
    private int numero; private Cliente cliente; protected double totalBase;
    public Factura(int numero, Cliente cliente, double totalBase) {
        this.numero = numero; this.cliente = cliente;
        this.totalBase = (totalBase < 0) ? 0 : totalBase;
    }
    public double calcularTotal() { return totalBase; }
    public Cliente getCliente() { return cliente; }
}
class FacturaContado extends Factura {
    private double descuento;
    public FacturaContado(int numero, Cliente cliente, double totalBase, double descuento) { super(numero, cliente, totalBase); this.descuento = descuento; }
    @Override public double calcularTotal() { double total = super.calcularTotal() - descuento; return (total < 0) ? 0 : total; }
}
class FacturaCredito extends Factura {
    private double recargo; private int cuotas;
    public FacturaCredito(int numero, Cliente cliente, double totalBase, double recargo, int cuotas) { super(numero, cliente, totalBase); this.recargo = recargo; this.cuotas = cuotas; }
    @Override public double calcularTotal() { double total = super.calcularTotal() + recargo; return (total < 0) ? 0 : total; }
}

// CLASE PRINCIPAL DE EJECUCIÓN
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1️⃣ PERSONA, DOCENTE Y ESTUDIANTE ===");
        Docente doc = new Docente("Walter Cordoba", 40, "Sistemas");
        Estudiante est = new Estudiante("Mario", 22, "1790-25-7736");
        doc.mostrar(); est.mostrar(); System.out.println();

        System.out.println("=== 2️⃣ CUENTA CORRIENTE WITH SOBREGIRO ===");
        CuentaCorriente cc = new CuentaCorriente(100.0, 50.0);
        cc.retirar(130.0); cc.retirar(40.0); System.out.println();

        System.out.println("=== 3️⃣ PRODUCTO PERECEDERO ===");
        ProductoPerecedero leche = new ProductoPerecedero("Leche", 0);
        System.out.println("¿La leche está vencida?: " + (leche.estaVencido() ? "Sí" : "No")); System.out.println();

        System.out.println("=== 4️⃣ TRANSPORTE Y BUS ===");
        Bus miBus = new Bus(45, "Ruta Central");
        miBus.descripcion(); System.out.println();

        System.out.println("=== 5️⃣ EMPLEADO Y GERENTE ===");
        Gerente ger = new Gerente("Ana López", 2500.0, 500.0);
        System.out.println("Salario total del Gerente: $" + ger.calcularSalario()); System.out.println();

        System.out.println("=== 6️⃣ ANIMAL Y PERRO ===");
        Animal miAnimal = new Perro(); miAnimal.hacerSonido(); System.out.println();

        System.out.println("=== 7️⃣ VEHICULO Y MOTO ===");
        Moto miMoto = new Moto("Yamaha", 120.0, 250);
        miMoto.mostrarInfo(); System.out.println();

        System.out.println("=== 8️⃣ FIGURA Y RECTANGULO ===");
        Figura rect = new Rectangulo(5.0, 4.0); Figura circ = new Circulo(3.0);
        System.out.println("Área Rectángulo: " + rect.calcularArea());
        System.out.println("Área Círculo: " + circ.calcularArea()); System.out.println();

        System.out.println("=== 9️⃣ LIBRO Y LIBRO DIGITAL ===");
        LibroDigital libroDig = new LibroDigital("Java Avanzado", "Autor X", 4.5);
        libroDig.mostrarInfo(); System.out.println();

        System.out.println("=== 🔟 SISTEMA DE FACTURACIÓN ===");
        Cliente cli = new Cliente("Marito", "123456-7");
        FacturaContado facContado = new FacturaContado(101, cli, 200.0, 20.0);
        FacturaCredito facCredito = new FacturaCredito(102, cli, 200.0, 15.0, 3);
        System.out.println("Cliente: " + facContado.getCliente().getNombre());
        System.out.println("Total Factura Contado: $" + facContado.calcularTotal());
        System.out.println("Total Factura Crédito: $" + facCredito.calcularTotal());
    }
}
