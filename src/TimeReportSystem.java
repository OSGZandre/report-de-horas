import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TimeReportSystem {
    static class Project {
        String name;
        List<WorkSession> sessions;
        double hourlyRate;

        Project(String name, double hourlyRate) {
            this.name = name;
            this.sessions = new ArrayList<>();
            this.hourlyRate = hourlyRate;
        }

        void addSession(LocalDateTime start, LocalDateTime end) {
            sessions.add(new WorkSession(start, end));
        }

        double getTotalHours() {
            return sessions.stream()
                    .mapToLong(s -> Duration.between(s.start, s.end).toHours())
                    .sum();
        }

        double getTotalCost() {
            return getTotalHours() * hourlyRate;
        }
    }

    static class WorkSession {
        LocalDateTime start;
        LocalDateTime end;

        WorkSession(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }
    }

    private Map<String, Project> projects;
    private Scanner scanner;

    public TimeReportSystem() {
        projects = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Cadastrar Projeto");
            System.out.println("2. Registrar Horas");
            System.out.println("3. Gerar Relatório");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (option) {
                case 1:
                    createProject();
                    break;
                case 2:
                    registerHours();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void createProject() {
        System.out.print("Nome do projeto: ");
        String name = scanner.nextLine();
        System.out.print("Valor por hora: ");
        double hourlyRate = scanner.nextDouble();
        projects.put(name, new Project(name, hourlyRate));
        System.out.println("Projeto cadastrado com sucesso!");
    }

    private void registerHours() {
        System.out.print("Nome do projeto: ");
        String name = scanner.nextLine();
        Project project = projects.get(name);
        if (project == null) {
            System.out.println("Projeto não encontrado!");
            return;
        }

        System.out.println("Formato de data/hora: yyyy-MM-dd HH:mm");
        System.out.print("Início (ex: 2025-04-15 09:00): ");
        String startStr = scanner.nextLine();
        System.out.print("Fim (ex: 2025-04-15 17:00): ");
        String endStr = scanner.nextLine();

        try {
            LocalDateTime start = LocalDateTime.parse(startStr.replace(" ", "T"));
            LocalDateTime end = LocalDateTime.parse(endStr.replace(" ", "T"));
            project.addSession(start, end);
            System.out.println("Horas registradas com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro no formato da data/hora!");
        }
    }

    private void generateReport() {
        System.out.print("Nome do projeto (ou deixe vazio para todos): ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            for (Project project : projects.values()) {
                printProjectReport(project);
            }
        } else {
            Project project = projects.get(name);
            if (project == null) {
                System.out.println("Projeto não encontrado!");
            } else {
                printProjectReport(project);
            }
        }
    }

    private void printProjectReport(Project project) {
        System.out.println("\nRelatório - Projeto: " + project.name);
        System.out.println("Total de horas: " + project.getTotalHours());
        System.out.println("Custo total: R$" + String.format("%.2f", project.getTotalCost()));
        System.out.println("Sessões:");
        for (WorkSession session : project.sessions) {
            System.out.println("- De " + session.start + " até " + session.end);
        }
    }

    public static void main(String[] args) {
        new TimeReportSystem().start();
    }
}