public class Contato {
    private String nome;
    private String telefone;
    private Boolean bloqueado;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.bloqueado = false;
    }
    public Contato() {
    }

    public void bloquear(){
        this.bloqueado = true;
    }

    public void desbloquear(){
        this.bloqueado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }


    @Override
    public String toString() {
        String fraseBloq = bloqueado ? "Sim" : "Não";
        return """
                Nome: %s
                Telefone %s
                Bloqueado %s
                """.formatted(this.nome, this.telefone, fraseBloq);
    }
}
