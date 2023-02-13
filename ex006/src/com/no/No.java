package com.no;

public class No {
    private String conteudo;
    private No proxNo;

    public No(String conteudo){
        this.proxNo = no2;
        this.conteudo = conteudo;
    }

    public String getConteudo(){
        return conteudo;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public No getProxNo(){
        return proxNo;
    }

    public void setProxNo(No proxNo){
        this.proxNo = proxNo;
    }

    public String toString(){
        return "no{" +
                "conteudo='" + conteudo + '\'' +
                "}";
    }
}
