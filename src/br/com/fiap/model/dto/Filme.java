package br.com.fiap.model.dto;

//      Integrantes do Grupo

//      Tárik Moussa Alma - RM: 571411
//      Giovanni Azevedo - RM: 572894
//      Fabricio Aquiles Sales da Silva - RM: 570985
//      Carlos Eduardo Tsucamoto Chiarelli - RM: 569574
//      Ítalo Neto - RM: 572912

public class Filme {
    //atributos
    private int codigo;
    private String titulo;
    private String genero;
    private String produtora;

    //construtor vazio
    public Filme() {
    }

    //getters/setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
}
