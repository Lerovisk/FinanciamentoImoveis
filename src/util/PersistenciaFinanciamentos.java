package util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import modelo.Financiamento;

public class PersistenciaFinanciamentos {
    private final Path pastaDestino;

    public PersistenciaFinanciamentos(String pastaDestino) {
        this.pastaDestino = Paths.get(pastaDestino);
    }

    public void salvarTexto(List<Financiamento> financiamentos) throws IOException {
        Files.createDirectories(pastaDestino);
        Path caminho = pastaDestino.resolve("financiamentos.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(caminho)) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.paraFormatoTexto() + "\n");
            }
        }
    }

    public void salvarSerializado(List<Financiamento> financiamentos) throws IOException {
        Files.createDirectories(pastaDestino);
        Path caminho = pastaDestino.resolve("financiamentos.ser");

        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(caminho))) {
            out.writeObject(new ArrayList<>(financiamentos));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Financiamento> carregarSerializado() throws IOException, ClassNotFoundException {
        Path caminho = pastaDestino.resolve("financiamentos.ser");
        if (!Files.exists(caminho)) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(caminho))) {
            return (List<Financiamento>) in.readObject();
        }
    }
}
