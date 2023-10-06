package AtendimentoMedico;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria um médico
        Medico medico = new Medico("Dr. João", new Date(22/11/1958), "Cardiologista");

        // Cria um paciente
        Paciente paciente = new Paciente("Maria", new Date(18/9/2004));

        // Cria uma lista de atendimentos
        ListaDeAtendimentos listaDeAtendimentos = new ListaDeAtendimentos();

        // Cria um Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Criar atendimento");
            System.out.println("2. Listar atendimentos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Cria uma pergunta
                    ArrayList<Perguntas> perguntas = new ArrayList<Perguntas>();
                    perguntas.add(new Perguntas("Você tem febre?", "Sim", 3));
                    perguntas.add(new Perguntas("Você está com dor intensa?", "Sim", 3));
                    perguntas.add(new Perguntas("Você é uma criança ou idoso?", "Sim", 3));
                    perguntas.add(new Perguntas("Você possui machucados que requerem pontos?", "Sim", 4));
                    perguntas.add(new Perguntas("Tomou algum medicamento recentemente?", "Sim", 4));

                    String inicioAtendimento = "18:45";
                    String fimAtendimento = "19:30";
                    String chegada = "18:30";

                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    Date horaChegada = dateFormat.parse(chegada);
                    Date horaInicio = dateFormat.parse(inicioAtendimento);
                    Date horaFinal = dateFormat.parse(fimAtendimento);
                    
                    
                    
                    // Cria um atendimento com as perguntas da triagem e o paciente
                    Atendimento atendimento = new Atendimento(new Date(), new Date(), new Date(), new Date(), false, perguntas, paciente);

                    // Cria um atendimento
                    atendimento.emitirAtestado("Atestado médico");

                    // Adiciona o atendimento à lista de atendimentos
                    listaDeAtendimentos.addAtendimento(atendimento);

                    System.out.println("Atendimento criado.");
                    break;
                case 2:
                    // Lista os atendimentos
                    for (Atendimento atendimento : listaDeAtendimentos.getAtendimentos()) {
                        System.out.println("Atendimento, Paciente: " + atendimento.getPaciente().getNome() + ", Prioridade: "  + atendimento.getPrioridade() + ", Atestado emitido: " + atendimento.emitirAtestado("Atestado médico"));
                    }
                    break;
                case 3:
                    // Sai do programa
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}





/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            Medico medico1 = new Medico("Dr. João", new Date(22/11/1958), "Cardiologista");
            Medico medico2 = new Medico("Dra. Maria", new Date(10/05/1975), "Ortopedista");
            Medico medico3 = new Medico("Dra. Ana", new Date(16/06/1985), "Dermatologista");
            Medico medico4 = new Medico("Dra. Clara", new Date(14/02/1995), "Otorinolaringologista");

            // Criando uma lista de atendimentos
            ListaDeAtendimentos listaDeAtendimentos = new ListaDeAtendimentos();

            // Criando pacientes e consultas
            for (int i = 1; i <= 5; i++) {
                String nomePaciente = "Paciente" + i;
                Date dataNascimento = new Date(); // Defina a data de nascimento apropriada
                Date horaChegada = dateFormat.parse("18:" + (30 + i));
                Atendimento atendimento = criarAtendimento("18:45", "19:" + (30 + i), horaChegada);
                Paciente paciente = new Paciente(nomePaciente, dataNascimento, atendimento);

                // Define o médico associado ao paciente
                Medico medico = new Random().nextBoolean() ? medico1 : medico2;
                paciente.getAtendimento().setMedico(medico);

                // Adiciona o paciente à lista de atendimentos
                listaDeAtendimentos.addPaciente(paciente);
            }

            // Ordena a lista de atendimentos por prioridade
            listaDeAtendimentos.ordenarPorPrioridade();

            // Exibindo informações dos pacientes
            for (Paciente paciente : listaDeAtendimentos.getPacientes()) {
                Medico medico = paciente.getAtendimento().getMedico();
                System.out.println("Médico: " + medico.getNome() + ", Especialidade: " + medico.getEspecialidade());
                System.out.println("Paciente: " + paciente.getNome() + ", Data de Nascimento: " + dateFormat.format(paciente.getDataNascimento()));
                System.out.println("Atendimento: Duração: " + paciente.getAtendimento().calcularDuracao() +
                        ", Hora de Chegada: " + dateFormat.format(paciente.getAtendimento().getHoraChegada()) +
                        ", Prioridade: " + paciente.getAtendimento().getPrioridade() +
                        ", Atestado emitido: " + paciente.getAtendimento().emitirAtestado("Atestado médico"));
                System.out.println();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Atendimento criarAtendimento(String inicioAtendimento, String fimAtendimento, Date chegada) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date horaInicio = dateFormat.parse(inicioAtendimento);
        Date horaFinal = dateFormat.parse(fimAtendimento);

        ArrayList<Perguntas> perguntas = new ArrayList<>();
        perguntas.add(new Perguntas("Você tem febre?", "Sim", 3));
        perguntas.add(new Perguntas("Você está com dor intensa?", "Sim", 3));
        // Adicione mais perguntas, se necessário

        String prioridade = Perguntas.calcularPrioridade(perguntas);

        return new Atendimento(horaInicio, horaFinal, chegada, false, prioridade, perguntas);
    }
}
*/