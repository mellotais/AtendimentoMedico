package AtendimentoMedico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // lista de médicos
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Dr. João", parseDate("22/11/1958"), "Cardiologista"));
        medicos.add(new Medico("Dra. Maria", parseDate("10/05/1975"), "Ortopedista"));
        medicos.add(new Medico("Dra. Ana", parseDate("16/06/1985"), "Dermatologista"));
        medicos.add(new Medico("Dra. Clara", parseDate("14/02/1995"), "Otorinolaringologista"));

        // lista de pacientes
        List<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Maria", parseDate("18/09/2001")));
        pacientes.add(new Paciente("João", parseDate("16/09/2002")));
        pacientes.add(new Paciente("Pedro", parseDate("13/09/2000")));
        pacientes.add(new Paciente("Paul", parseDate("11/09/2003")));

        // cria lista de atendimentos
        ListaDeAtendimentos listaDeAtendimentos = new ListaDeAtendimentos();

        
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------");
            System.out.println("           MENU:");
            System.out.println(" ");
            System.out.println(" 1. Criar atendimento");
            System.out.println(" 2. Listar atendimentos");
            System.out.println(" 3. Sair");
            System.out.println("- - - - - - - - - - - - - -");
            System.out.println(" Digite uma opção ");
            System.out.println("---------------------------");
            
            
            int opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    // seleciona aleatoriamente um médico e um paciente
                    Medico medicoSelecionado = medicos.get(new Random().nextInt(medicos.size()));
                    Paciente pacienteSelecionado = pacientes.get(new Random().nextInt(pacientes.size()));

                    // cria uma pergunta
                    ArrayList<Perguntas> perguntasTriagem = new ArrayList<Perguntas>();
                    
                    
                    perguntasTriagem.add(new Perguntas("Você tem febre?", numero()));
                    perguntasTriagem.add(new Perguntas("Você está com dor intensa?", numero()));
                    perguntasTriagem.add(new Perguntas("Você é uma criança ou idoso?", numero()));
                    perguntasTriagem.add(new Perguntas("Você possui machucados que requerem pontos?", numero()));
                    perguntasTriagem.add(new Perguntas("Tomou algum medicamento recentemente?", numero()));

                    String inicioAtendimento = gerarHoraAleatoria();
                    String fimAtendimento = gerarHoraPosterior(inicioAtendimento);
                    String chegada = gerarHoraPosterior(fimAtendimento);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    try {
                        Date horaChegadaTriagem = dateFormat.parse(chegada);
                        Date horaInicioTriagem = dateFormat.parse(inicioAtendimento);
                        Date horaFinalTriagem = dateFormat.parse(fimAtendimento);
                        Date dataAtual = new Date(06/10/2023); // 6 de outubro de 2023

                        // Cria um atendimento com as perguntas da triagem, paciente e médico
                        Atendimento atendimentoTriagem = new Atendimento(horaChegadaTriagem, horaInicioTriagem, horaFinalTriagem, dataAtual, false, perguntasTriagem, pacienteSelecionado, medicoSelecionado);

                        // Cria um atendimento
                        atendimentoTriagem.emitirAtestado("Atestado médico");

                        // Adiciona o atendimento à lista de atendimentos
                       
                        // Adiciona o atendimento à lista de atendimentos usando o método da classe ListaDeAtendimentos
                        listaDeAtendimentos.addAtendimento(atendimentoTriagem);

                        // Ordena a lista de atendimentos por prioridade
                        listaDeAtendimentos.ordenarPorPrioridade();

                        System.out.println("Atendimento de triagem criado.");
                        System.out.println();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    // Obtém a lista de atendimentos da classe ListaDeAtendimentos
                    ArrayList<Atendimento> atendimentos = listaDeAtendimentos.getAtendimentos();

                    if (atendimentos.isEmpty()) {
                        System.out.println("Não há atendimentos registrados.");
                    } else {
                        // Lista os atendimentos
                        for (Atendimento atendimento : atendimentos) {
                            System.out.println("Médico: " + atendimento.getMedico().getNome() + ", Especialidade: " + atendimento.getMedico().getEspecialidade() + ", Data de Nascimento: " + atendimento.getMedico().getDataNasc());
                            System.out.println("Paciente: " + atendimento.getPaciente().getNome() + " [" + atendimento.getPaciente().getDataNasc() + "] ");
                            System.out.println("Prioridade: " + atendimento.getPrioridade());
                            System.out.println("Atestado emitido: " + atendimento.emitirAtestado("Atestado médico"));
                            System.out.println("Chegada na Unidade: " + atendimento.getHoraChegadaNaUnidade());
                            System.out.println("Hora de Início atendimento: " + atendimento.getInicioAtendimento());
                            System.out.println("Hora de Fim do atendimento: " + atendimento.getFimAtendimento());
                            System.out.println("Duração: " + atendimento.calcularDuracao());
                            System.out.println("Atestado emitido: " + atendimento.emitirAtestado("Sim"));
                            System.out.println(" ");
                            System.out.println("********************************************************** ");
                        }
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
    
    private static String gerarHoraAleatoria() {
        Random random = new Random();
        int hora = random.nextInt(24);
        int minuto = random.nextInt(60);

        return String.format("%02d:%02d", hora, minuto);
    }

    private static String gerarHoraPosterior(String horaReferencia) {
        Random random = new Random();
        int minutosExtras = random.nextInt(60); // Adicionar até 59 minutos extras

        // Converter a hora de referência em minutos totais
        String[] partes = horaReferencia.split(":");
        int minutosTotais = Integer.parseInt(partes[0]) * 60 + Integer.parseInt(partes[1]);

        // Adicionar minutos extras e ajustar as horas e minutos, se necessário
        minutosTotais += minutosExtras;
        int hora = minutosTotais / 60;
        int minuto = minutosTotais % 60;

        // Formatar a hora como string
        return String.format("%02d:%02d", hora, minuto);
    }
    
    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    private static int numero() {
        List<Integer> listanumero = Arrays.asList(1, 0);
        int n = new Random().nextInt(listanumero.size());
        return listanumero.get(n);
    }


}

