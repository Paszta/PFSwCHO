# Sprawozdanie nr 1
Poniżej znajduje się opis zadań nr 1-3 ze sprawozdania nr 1.

##Zadanie nr 1
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
