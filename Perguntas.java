package AtendimentoMedico;

import java.util.ArrayList;

class Perguntas {
    private String pergunta;
    private String resposta;
    private int peso;

    public Perguntas(String pergunta, String resposta, int peso) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.peso = peso;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public int getPeso() {
        return peso;
    }

    public static String calcularPrioridade(ArrayList<Perguntas> perguntas) {
        int somaPesos = 0;

        for (Perguntas pergunta : perguntas) {
            somaPesos += pergunta.getPeso();
        }

        double percentual = (double) somaPesos / (double) (perguntas.size() * 4);

        if (percentual >= 0.75) {
            return "Muito Urgente";
        } else if (percentual >= 0.5) {
            return "Urgente";
        } else if (percentual >= 0.25) {
            return "Pouco Urgente";
        } else {
            return "Não Urgente";
        }
    }
}
