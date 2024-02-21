package br.edu.unifacisa.openmind.model;


import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private String conteudo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPostagem;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }
    public String getNomeAutor() {
        return autor != null ? autor.getNome() : "Autor Desconhecido";
    }
}