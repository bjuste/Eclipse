package ejercicio11_T14;

public class Oficina {
	private int oficina;
    private String ciudad;
    private int superficie;
    private double ventas;

    // Constructor
    public Oficina(int oficina, String ciudad, int superficie, double ventas) {
        this.oficina = oficina;
        this.ciudad = ciudad;
        this.superficie = superficie;
        this.ventas = ventas;
    }

    // Getters y setters (pueden ser generados automáticamente)
    public int getOficina() {
        return oficina;
    }

    public void setOficina(int oficina) {
        this.oficina = oficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    // Método toString para mostrar la información de la oficina
    @Override
    public String toString() {
        return "Oficina [oficina=" + oficina + ", ciudad=" + ciudad + ", superficie=" + superficie + ", ventas=" + ventas + "]";
    }
}
