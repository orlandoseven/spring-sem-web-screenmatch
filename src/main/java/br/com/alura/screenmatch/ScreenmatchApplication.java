package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto spring sem web");
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=breaking+bad&apikey=d08b7f30");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados );
		System.out.println("************************************");
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=breaking+bad&season=2&episode=4&apikey=d08b7f30");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json,DadosEpisodio.class);
		System.out.println(dadosEpisodio);
	}
}
