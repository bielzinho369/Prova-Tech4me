package aplicativos;

public class Pessoa {

    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public String getcpf() {
        return cpf;
    }
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }
    }
