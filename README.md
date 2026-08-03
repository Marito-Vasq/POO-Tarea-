package Encapsulacion;

// ==========================================
// 1️⃣ CLASE PERSONA
// ==========================================
class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println("Persona: " + nombre + " " + apellido + ", Edad: " + edad + " años.");
    }
}

// ==========================================
// 2️⃣ CLASE RECTÁNGULO
// ==========================================
class Rectangulo {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    }

    public double perimetro() {
        return 2 * (base + altura);
    }
}

// ==========================================
// 3️⃣ CLASE PRODUCTO
// ==========================================
class Producto {
    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void aplicarDescuento(double porcentaje) {
        this.precio = this.precio - (this.precio * (porcentaje / 100));
    }

    public void mostrarProducto() {
        System.out.println("Producto: " + nombre + " (" + codigo + ") - Precio: $" + precio);
    }
}

// ==========================================
// 4️⃣ CLASE CUENTA
// ==========================================
class Cuenta {
    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depositado: $" + monto);
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && (saldo - monto) >= 0) {
            saldo -= monto;
            System.out.println("Retirado: $" + monto);
        } else {
            System.out.println("Retiro denegado: Saldo insuficiente para retirar $" + monto);
        }
    }

    public void mostrarSaldo() {
        System.out.println("Cuenta de " + titular + " - Saldo Final: $" + saldo);
    }
}

// ==========================================
// 5️⃣ CLASE LIBRO
// ==========================================
class Libro {
    private String titulo;
    private String autor;
    private int paginas;

    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public boolean esLargo() {
        return paginas > 300;
    }

    public String getTitulo() {
        return titulo;
    }
}

// ==========================================
// 6️⃣ CLASE CALCULADORA
// ==========================================
class Calculadora {
    public double sumar(double a, double b) { return a + b; }
    public double restar(double a, double b) { return a - b; }
    public double multiplicar(double a, double b) { return a * b; }
    
    public double dividir(double a, double b) {
        if (b == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0;
        }
        return a / b;
    }
}

// ==========================================
// 7️⃣ CLASE FECHA
// ==========================================
class Fecha {
    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public boolean esValida() {
        return (dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12);
    }

    public void mostrarFecha() {
        System.out.println("Fecha: " + dia + "/" + mes + "/" + ano);
    }
}


// ==========================================
// CLASE PRINCIPAL PARA EJECUTAR LAS PRUEBAS
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== 1️⃣ PRUEBA CLASE PERSONA ===");
        Persona p1 = new Persona("Juan", "Perez", 25);
        Persona p2 = new Persona("Maria", "Gomez", 30);
        Persona p3 = new Persona("Carlos", "Lopez", 19);
        p1.mostrar();
        p2.mostrar();
        p3.mostrar();
        System.out.println();

        System.out.println("=== 2️⃣ PRUEBA CLASE RECTÁNGULO ===");
        Rectangulo r1 = new Rectangulo(5, 10);
        Rectangulo r2 = new Rectangulo(7, 8);
        System.out.println("Área Rectángulo 1: " + r1.area());
        System.out.println("Área Rectángulo 2: " + r2.area());
        if (r1.area() > r2.area()) {
            System.out.println("El Rectángulo 1 tiene mayor área.");
        } else if (r2.area() > r1.area()) {
            System.out.println("El Rectángulo 2 tiene mayor área.");
        } else {
            System.out.println("Ambos tienen la misma área.");
        }
        System.out.println();

        System.out.println("=== 3️⃣ PRUEBA CLASE PRODUCTO ===");
        Producto prod1 = new Producto("P001", "Laptop", 800.0);
        Producto prod2 = new Producto("P002", "Mouse", 20.0);
        prod1.aplicarDescuento(10);
        prod2.aplicarDescuento(5);
        prod1.mostrarProducto();
        prod2.mostrarProducto();
        System.out.println();

        System.out.println("=== 4️⃣ PRUEBA CLASE CUENTA ===");
        Cuenta miCuenta = new Cuenta("Alex", 100.0);
        miCuenta.depositar(50);
        miCuenta.retirar(30);
        miCuenta.retirar(200);
        miCuenta.mostrarSaldo();
        System.out.println();

        System.out.println("=== 5️⃣ PRUEBA CLASE LIBRO ===");
        Libro l1 = new Libro("Java Básico", "Autor A", 150);
        Libro l2 = new Libro("Don Quijote", "Cervantes", 800);
        Libro l3 = new Libro("Redes", "Autor B", 350);
        
        Libro[] libros = {l1, l2, l3};
        for (Libro l : libros) {
            if (l.esLargo()) {
                System.out.println("El libro '" + l.getTitulo() + "' es largo (más de 300 págs).");
            }
        }
        System.out.println();

        System.out.println("=== 6️⃣ PRUEBA CLASE CALCULADORA ===");
        Calculadora calc = new Calculadora();
        System.out.println("Suma (10+5): " + calc.sumar(10, 5));
        System.out.println("Multiplicación (4*3): " + calc.multiplicar(4, 3));
        System.out.print("División entre cero (8/0): ");
        calc.dividir(8, 0);
        System.out.println();

        System.out.println("=== 7️⃣ PRUEBA CLASE FECHA ===");
        Fecha f1 = new Fecha(15, 6, 2024);
        Fecha f2 = new Fecha(40, 5, 2023);
        Fecha f3 = new Fecha(12, 15, 2025);
        
        Fecha[] fechas = {f1, f2, f3};
        for (Fecha f : fechas) {
            f.mostrarFecha();
            System.out.println("¿Es válida?: " + (f.esValida() ? "Sí" : "No"));
        }
    }
}
