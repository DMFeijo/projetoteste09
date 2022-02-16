package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastrarAlunoTest {

	WebDriver driver;

	@Dado("^Acessar a pagina cadastro de Alunos$")
	public void acessar_a_pagina_cadastro_de_Alunos() {

		// definindo o local onde esta o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		// Abrindo o google chrome
		driver = new ChromeDriver();

		// Maximizando a janela do navegador
		driver.manage().window().maximize();

		// Acessando a pagina de cadastro de funcionario
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio07");

	}

	@Dado("^informar nome \"([^\"]*)\"$")
	public void informar_nome(String nomealuno) {

		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nomealuno);

	}

	@Dado("^informar CPF \"([^\"]*)\"$")
	public void informar_CPF(String CPF) {

		driver.findElement(By.xpath("//*[@id=\"CPF\"]")).sendKeys(CPF);

	}

	@Dado("^informar RG \"([^\"]*)\"$")
	public void informar_RG(String RG) {

		driver.findElement(By.xpath("//*[@id=\"RG\"]")).sendKeys(RG);

	}

	@Dado("^informar matricula \"([^\"]*)\"$")
	public void informar_matricula(String matricula) {

		driver.findElement(By.xpath("//*[@id=\"Matricula\"]")).sendKeys(matricula);

	}

	@Dado("^informar data nascimento \"([^\"]*)\"$")
	public void informar_data_nascimento(String datanascimento) {

		driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]")).sendKeys(datanascimento);

	}

	@Dado("^selecionar a escolaridade \"([^\"]*)\"$")
	public void selecionar_a_escolaridade(String escolaridade) {

		new Select(driver.findElement(By.xpath("//*[@id=\"Escolaridade\"]"))).selectByVisibleText(escolaridade);

	}

	@Quando("^Realizar cadastro do aluno$")
	public void realizar_cadastro_do_aluno() {

		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

	}

	@Entao("^o sistema exibe a mensagem \"([^\"]*)\"$")
	public void o_sistema_exibe_a_mensagem(String resultado) {

		// ler a mensagem exibida na tela do sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\cucumber\\Cadastro de Aluno " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

	@Entao("^o sistema exibe a mensagem campo obrigatorio$")
	public void o_sistema_exibe_a_mensagem_campo_obrigatorio() {

		// ler a mensagem de erro exibida em cada campo
		String erroNome = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[1]/div/span")).getText();
		String erroCPF = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[2]/div/span")).getText();
		String erroRG = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[3]/div/span")).getText();
		String erroMatricula = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div/span"))
				.getText();
		String erroData = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[2]/div/span")).getText();
		String erroEscolaridade = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[3]/div/span"))
				.getText();

		// comparar o conteudo de cada mensagem
		assertEquals(erroNome, "Campo obrigatório");
		assertEquals(erroCPF, "Campo obrigatório");
		assertEquals(erroRG, "Campo obrigatório");
		assertEquals(erroMatricula, "Campo obrigatório");
		assertEquals(erroData, "Campo obrigatório");
		assertEquals(erroEscolaridade, "Campo obrigatório");

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\cucumber\\Validacao Cadastro de Aluno " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

}
