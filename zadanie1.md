# Sprawozdanie nr 1
Poniżej znajduje się opis zadań nr 1-3 ze sprawozdania nr 1.

## Zadanie nr 1
### A
Fragment kodu projektu przedstawiający wyświetlanie w logach czas i date uruchomienia, imienia i nazwiska oraz portu TCP. 
```
String appPort = "";
		String date;
		String nameSurname;
		SpringApplication.run(Spr1Application.class, args);

		try {
			properties.load(Spr1Application.class.getClassLoader().getResourceAsStream("application.properties"));
			appPort = properties.getProperty("server.port").toString();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		date = LocalTime.now().toString();
		nameSurname = "Alicja Pasztelan";
		System.out.println("Port: " + appPort + " data: " + date + " imie i nazwisko: " + nameSurname);
   
```
### B
Fragment kodu projektu przedstawiający wyświetlanie na stronie adresu IP klienta oraz daty i godziny w strefie czasowej klienta. 
```
@RequestMapping("/")
	public String home(TimeZone timeZone1) throws UnknownHostException {
		hostAddress = InetAddress.getLocalHost().getHostAddress();
		tz = ZonedDateTime.now(ZoneId.of(timeZone1.getID())).toString();
		return " adres IP: " + hostAddress + " timezone: " + tz;
	}
```
<img width="930" alt="image" src="https://github.com/Paszta/PFSwCHO/assets/63753108/50f1e075-d9f7-4f4a-8b9f-9f096e3c428c">

## Zadanie nr 2
Cała treśc pliku Dockerfile została dodana do repozytorium, włącznie z komentarzami. 

## Zadanie nr 3
### A - zbudowanie obrazu docker
```
docker build --tag=spr1:latest
```
### B - uruchomienie obrazu docker
```
docker run -p8080:8080 spr1:latest
```
### C - uzyskania informacji serwera
```
informacje wyswietlane sa na terminalu podczas budowania aplikacji, podczas uruchomienia  obrazu
```
### D - sprawdzenie ilosci warstw obrazu
```
docker image inspect spr1
```
