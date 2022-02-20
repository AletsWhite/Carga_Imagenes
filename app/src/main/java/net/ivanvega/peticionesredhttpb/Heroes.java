package net.ivanvega.peticionesredhttpb;

public class Heroes {
    int id;
    String nombre;
    String enlace;

    public Heroes(int id, String nombre, String enlace) {
        this.id = id;
        this.nombre = nombre;
        this.enlace = enlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }


}
