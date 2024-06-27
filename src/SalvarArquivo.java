import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SalvarArquivo {

    public void salvarJson(List<Moeda> historico) throws IOException {
        LocalDateTime dataDia = LocalDateTime.now();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM");
        String data = dataDia.format(dataFormatada).replace("/","-");

        FileWriter escrever = new FileWriter("ListaMoedasConvertidas " + data +".json");

        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .create();

        escrever.write(gson.toJson(historico));
        escrever.close();
    }
}
