package com.example.registrocomidas;

import android.widget.ImageView;

public class Comidas {

    String tipodeComida, descripcionComida, fotoURL;

    public Comidas(String tipodeComida, String descripcionComida, String fotoURL) {
        this.tipodeComida = tipodeComida;
        this.descripcionComida = descripcionComida;
        this.fotoURL = fotoURL;
    }


    public String getTipodeComida() {
        return tipodeComida;
    }

    public void setTipodeComida(String tipodeComida) {
        this.tipodeComida = tipodeComida;
    }

    public String getDescripcionComida() {
        return descripcionComida;
    }

    public void setDescripcionComida(String descripcionComida) {
        this.descripcionComida = descripcionComida;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }
}
