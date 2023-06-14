package com.example.spr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;


@SpringBootApplication
@RestController
public class Spr1Application {

	String hostAddress;
	String tz;
	static Properties properties = new Properties();


	@RequestMapping("/")
	public ResponseEntity<?> home(TimeZone timeZone1) throws UnknownHostException {
		// adres IP odczytany z własności klasy InetAddress - metoda: getLocalHost i getHostAddress pozwala na wyciągnięcie obiektu hosta i odczytanie jego adresu IP
		hostAddress = InetAddress.getLocalHost().getHostAddress();
		// wyswietlenie czasu i strefy czasowej na podstawie pobranego z klasy TimeZone id strefy
		tz = ZonedDateTime.now(ZoneId.of(timeZone1.getID())).toString();
		String str = " adres IP: " + hostAddress + " timezone: " + tz;
		return new ResponseEntity<>(str, HttpStatus.OK);
	}


	public static void main(String[] args) {
		//inicjalizacja zmiennych
		String appPort = "";
		String date;
		String nameSurname;
		SpringApplication.run(Spr1Application.class, args);

		// numer portu ustawiony jest w application.properties
		//poniższy kod odcztywuje jego wartosc z pliku, z własności o nazwie server.port
		try {
			properties.load(Spr1Application.class.getClassLoader().getResourceAsStream("application.properties"));
			appPort = properties.getProperty("server.port").toString();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// czas uruchomienia
		date = LocalTime.now().toString();
		nameSurname = "Alicja Pasztelan";
		//wyswietlenie wartosci
		System.out.println("Port: " + appPort + " data: " + date + " imie i nazwisko: " + nameSurname);
	}

}
