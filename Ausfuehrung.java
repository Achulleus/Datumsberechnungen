package datum;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ausfuehrung extends ExceptionArrayList {
	
	private int tag;
	private static int jahr;
	private static String wochentag;
	private static int endJahr;
	private static boolean check = false;
	private static boolean check2 = false;
	private static int zustandsnr = 6;
	
	private static int anzahl;
	
	private static ArrayList<LocalDate> daten = new ArrayList<LocalDate>();
	
	private static void home6() {
		System.out.println("Was wollen Sie?");
		System.out.println("Wochentage in einem Jahr zaehlen: 1");
		System.out.println("Wochentage in einer Zeitspanne zaehlen: 2");
		System.out.println("Zeit bis Zieldatum: 3");
		System.out.println("Bestimmtes Datum: 4");
		System.out.println("Bestimmten Tag: 5");
		Scanner scc = new Scanner(System.in);
		zustandsnr = scc.nextInt();
		if(zustandsnr == 1 || zustandsnr == 2) check = false;
	}
	
	private static void wochentage1() {
		if(check == false) {
			Scanner eingabe = new Scanner(System.in);
			System.out.println("Bitte geben Sie ein Jahr ein!");
			jahr = eingabe.nextInt();
			System.out.println("Bitte geben Sie einen Tag ein!");
			wochentag = eingabe.next();
			check = true;
		}
		LocalDate start = LocalDate.of(jahr, 1, 1);
		if(wochentag.equalsIgnoreCase("mo")) {
			for(int i = 0; i < i + 1; i++) {
				if(start.getDayOfWeek()==DayOfWeek.MONDAY) {
					anzahl++;				
					daten.add(start);
				}
				start = start.plusDays(1);
				if(start.isEqual(LocalDate.of(jahr, 12, 31))) break;
			}
		}
		if(wochentag.equalsIgnoreCase("di")) {
			for(int i = 0; i < i + 1; i++) {
				if(start.getDayOfWeek()==DayOfWeek.TUESDAY) {
					anzahl++;
					daten.add(start);
				}
				start = start.plusDays(1);
				if(start.isEqual(LocalDate.of(jahr, 12, 31))) break;
			}
		}
		if(wochentag.equalsIgnoreCase("mi")) {
			for(int i = 0; i < i + 1; i++) {
				if(start.getDayOfWeek()==DayOfWeek.WEDNESDAY) {
					anzahl++;	
					daten.add(start);
				}
				start = start.plusDays(1);
				if(start.isEqual(LocalDate.of(jahr, 12, 31))) break;
			}
		}
		if(wochentag.equalsIgnoreCase("do")) {
			for(int i = 0; i < i + 1; i++) {
				if(start.getDayOfWeek()==DayOfWeek.THURSDAY) {
					anzahl++;	
					daten.add(start);
				}
				start = start.plusDays(1);
				if(start.isEqual(LocalDate.of(jahr, 12, 31))) break;
			}
		}
		if(wochentag.equalsIgnoreCase("fr")) {
			for(int i = 0; i < i + 1; i++) {
				if(start.getDayOfWeek()==DayOfWeek.FRIDAY) {
					anzahl++;
					daten.add(start);
				}
				start = start.plusDays(1);
				if(start.isEqual(LocalDate.of(jahr, 12, 31))) break;
			}
		}
		if(wochentag.equalsIgnoreCase("sa")) {
			for(int i = 0; i < i + 1; i++) {
				if(start.getDayOfWeek()==DayOfWeek.SATURDAY) {
					anzahl++;	
					daten.add(start);
				}
				start = start.plusDays(1);
				if(start.isEqual(LocalDate.of(jahr, 12, 31))) break;
			}
		}
		if(wochentag.equalsIgnoreCase("so")) {
			for(int i = 0; i < i + 1; i++) {
				if(start.getDayOfWeek()==DayOfWeek.SUNDAY) {
					anzahl++;
					daten.add(start);
				}
				start = start.plusDays(1);
				if(start.isEqual(LocalDate.of(jahr, 12, 31))) break;
			}
		}
		System.out.println(anzahl);
		if(check2 == false){ 
			anzahl = 0;
			zustandsnr = 6;
		}
	}
	
	private static void wochentageJahr2() {
		check2 = true;
		Scanner sc = new Scanner(System.in); 
		System.out.println("Bis wann soll gezaehlt werden?");
		endJahr = sc.nextInt();
		for(int i = jahr; jahr <= endJahr; jahr++) {
			if(jahr == endJahr) check2 = false;
			wochentage1();
		}
		zustandsnr = 6;
	}
	
	private static void geburtstag3() {
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Geben Sie ein Zieldatum ein! Jahr, Monat, Tag");
		int gebJahr = eingabe.nextInt();
		int gebMonat = eingabe.nextInt();
		int gebTag = eingabe.nextInt();
		LocalDate heute = LocalDate.now();
		LocalDate geburtstag = LocalDate.of(gebJahr ,gebMonat, gebTag);
		Period periode = Period.between(heute, geburtstag);
		System.out.println("Noch "+periode.getYears()+" Jahre "+periode.getMonths()+" Monate und "+periode.getDays()+" Tage");
		daten.clear();
		zustandsnr = 6;
	}

	private static void ausgabeWochentag4(){
		try{
			Scanner eingabe = new Scanner(System.in);
			System.out.println("Von welchen Tag wollen Sie das Datum?");
			int wert = eingabe.nextInt();
			if(wert > daten.size()) throw new ExceptionArrayList("So viele Tage hat diese Zeitspanne nicht!");
			System.out.println("Wollen Sie ein europaeische Ausgabe: 1");
			System.out.println("Oder amerikanische Ausgabe: 2");
			int z = eingabe.nextInt();
			if(z==1)System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(daten.get(wert-1)));
			if(z==2)System.out.println(DateTimeFormatter.ofPattern("MM/dd/yy").format(daten.get(wert-1)));
		}catch(ExceptionArrayList a) {
			a.printStackTrace();
		}finally {
			daten.clear();
			zustandsnr = 6;
		}
	}
	
	private static void ausgabeDatum5() {
		Scanner eingabe = new Scanner(System.in);
		System.out.println("Bitte geben Sie ein Datum ein! Jahr, Monat, Tag");
		int zielJahr = eingabe.nextInt();
		int zielMonat = eingabe.nextInt();
		int zielTag = eingabe.nextInt();
		LocalDate zielDatum = LocalDate.of(zielJahr, zielMonat, zielTag);
		System.out.println("Es ist ein: " + zielDatum.getDayOfWeek());
		zustandsnr = 6;
	}
	
	public static void main(String[] args) {
		
		while(true) {
			switch(zustandsnr) {
				case 1:wochentage1();
				break;
				case 2:wochentageJahr2();
				break;
				case 3:geburtstag3();
				break;
				case 4:ausgabeWochentag4();
				break;
				case 5:ausgabeDatum5();
				break;
				case 6:home6();
				break;
			}
		}
	}
}
